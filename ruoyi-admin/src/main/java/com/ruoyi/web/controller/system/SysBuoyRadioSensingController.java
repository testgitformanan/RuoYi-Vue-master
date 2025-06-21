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
import com.ruoyi.system.domain.SysBuoyRadioSensing;
import com.ruoyi.system.service.ISysBuoyRadioSensingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 浮标无线电感知业务Controller
 * 
 * @author ruoyi
 * @date 2025-06-17
 */
@RestController
@RequestMapping("/system/sensing")
public class SysBuoyRadioSensingController extends BaseController
{
    @Autowired
    private ISysBuoyRadioSensingService sysBuoyRadioSensingService;

    /**
     * 查询浮标无线电感知业务列表
     */
    @PreAuthorize("@ss.hasPermi('system:sensing:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBuoyRadioSensing sysBuoyRadioSensing)
    {
        startPage();
        List<SysBuoyRadioSensing> list = sysBuoyRadioSensingService.selectSysBuoyRadioSensingList(sysBuoyRadioSensing);
        return getDataTable(list);
    }

    /**
     * 导出浮标无线电感知业务列表
     */
    @PreAuthorize("@ss.hasPermi('system:sensing:export')")
    @Log(title = "浮标无线电感知业务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysBuoyRadioSensing sysBuoyRadioSensing)
    {
        List<SysBuoyRadioSensing> list = sysBuoyRadioSensingService.selectSysBuoyRadioSensingList(sysBuoyRadioSensing);
        ExcelUtil<SysBuoyRadioSensing> util = new ExcelUtil<SysBuoyRadioSensing>(SysBuoyRadioSensing.class);
        util.exportExcel(response, list, "浮标无线电感知业务数据");
    }

    /**
     * 获取浮标无线电感知业务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sensing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysBuoyRadioSensingService.selectSysBuoyRadioSensingById(id));
    }

    /**
     * 新增浮标无线电感知业务
     */
    @PreAuthorize("@ss.hasPermi('system:sensing:add')")
    @Log(title = "浮标无线电感知业务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBuoyRadioSensing sysBuoyRadioSensing)
    {
        return toAjax(sysBuoyRadioSensingService.insertSysBuoyRadioSensing(sysBuoyRadioSensing));
    }

    /**
     * 修改浮标无线电感知业务
     */
    @PreAuthorize("@ss.hasPermi('system:sensing:edit')")
    @Log(title = "浮标无线电感知业务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBuoyRadioSensing sysBuoyRadioSensing)
    {
        return toAjax(sysBuoyRadioSensingService.updateSysBuoyRadioSensing(sysBuoyRadioSensing));
    }

    /**
     * 删除浮标无线电感知业务
     */
    @PreAuthorize("@ss.hasPermi('system:sensing:remove')")
    @Log(title = "浮标无线电感知业务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysBuoyRadioSensingService.deleteSysBuoyRadioSensingByIds(ids));
    }
}
