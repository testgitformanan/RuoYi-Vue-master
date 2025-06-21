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
import com.ruoyi.system.domain.SysBuoyMachine;
import com.ruoyi.system.service.ISysBuoyMachineService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 浮标水声通信机业务Controller
 * 
 * @author ruoyi
 * @date 2025-06-17
 */
@RestController
@RequestMapping("/system/machine")
public class SysBuoyMachineController extends BaseController
{
    @Autowired
    private ISysBuoyMachineService sysBuoyMachineService;

    /**
     * 查询浮标水声通信机业务列表
     */
    @PreAuthorize("@ss.hasPermi('system:machine:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBuoyMachine sysBuoyMachine)
    {
        startPage();
        List<SysBuoyMachine> list = sysBuoyMachineService.selectSysBuoyMachineList(sysBuoyMachine);
        return getDataTable(list);
    }

    /**
     * 导出浮标水声通信机业务列表
     */
    @PreAuthorize("@ss.hasPermi('system:machine:export')")
    @Log(title = "浮标水声通信机业务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysBuoyMachine sysBuoyMachine)
    {
        List<SysBuoyMachine> list = sysBuoyMachineService.selectSysBuoyMachineList(sysBuoyMachine);
        ExcelUtil<SysBuoyMachine> util = new ExcelUtil<SysBuoyMachine>(SysBuoyMachine.class);
        util.exportExcel(response, list, "浮标水声通信机业务数据");
    }

    /**
     * 获取浮标水声通信机业务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:machine:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysBuoyMachineService.selectSysBuoyMachineById(id));
    }

    /**
     * 新增浮标水声通信机业务
     */
    @PreAuthorize("@ss.hasPermi('system:machine:add')")
    @Log(title = "浮标水声通信机业务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBuoyMachine sysBuoyMachine)
    {
        return toAjax(sysBuoyMachineService.insertSysBuoyMachine(sysBuoyMachine));
    }

    /**
     * 修改浮标水声通信机业务
     */
    @PreAuthorize("@ss.hasPermi('system:machine:edit')")
    @Log(title = "浮标水声通信机业务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBuoyMachine sysBuoyMachine)
    {
        return toAjax(sysBuoyMachineService.updateSysBuoyMachine(sysBuoyMachine));
    }

    /**
     * 删除浮标水声通信机业务
     */
    @PreAuthorize("@ss.hasPermi('system:machine:remove')")
    @Log(title = "浮标水声通信机业务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysBuoyMachineService.deleteSysBuoyMachineByIds(ids));
    }
}
