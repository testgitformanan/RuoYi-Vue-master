package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysBuoyInformation;
import com.ruoyi.system.service.ISysBuoyInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 浮标信号数据业务Controller
 * 
 * @author ruoyi
 * @date 2025-06-21
 */
@RestController
@RequestMapping("/system/information")
public class SysBuoyInformationController extends BaseController
{
    @Autowired
    private ISysBuoyInformationService sysBuoyInformationService;

    /**
     * 查询浮标信号数据业务列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBuoyInformation sysBuoyInformation)
    {
        startPage();
        List<SysBuoyInformation> list = sysBuoyInformationService.selectSysBuoyInformationList(sysBuoyInformation);
        return getDataTable(list);
    }

    /**
     * 导出浮标信号数据业务列表
     */
    @PreAuthorize("@ss.hasPermi('system:information:export')")
    @Log(title = "浮标信号数据业务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysBuoyInformation sysBuoyInformation)
    {
        List<SysBuoyInformation> list = sysBuoyInformationService.selectSysBuoyInformationList(sysBuoyInformation);
        ExcelUtil<SysBuoyInformation> util = new ExcelUtil<SysBuoyInformation>(SysBuoyInformation.class);
        util.exportExcel(response, list, "浮标信号数据业务数据");
    }

    /**
     * 获取浮标信号数据业务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysBuoyInformationService.selectSysBuoyInformationById(id));
    }

    /**
     * 新增浮标信号数据业务
     */
    @PreAuthorize("@ss.hasPermi('system:information:add')")
    @Log(title = "浮标信号数据业务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBuoyInformation sysBuoyInformation)
    {
        return toAjax(sysBuoyInformationService.insertSysBuoyInformation(sysBuoyInformation));
    }

    /**
     * 修改浮标信号数据业务
     */
    @PreAuthorize("@ss.hasPermi('system:information:edit')")
    @Log(title = "浮标信号数据业务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBuoyInformation sysBuoyInformation)
    {
        return toAjax(sysBuoyInformationService.updateSysBuoyInformation(sysBuoyInformation));
    }

    /**
     * 删除浮标信号数据业务
     */
    @PreAuthorize("@ss.hasPermi('system:information:remove')")
    @Log(title = "浮标信号数据业务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysBuoyInformationService.deleteSysBuoyInformationByIds(ids));
    }
}
