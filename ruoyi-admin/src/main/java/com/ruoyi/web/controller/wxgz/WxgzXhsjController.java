package com.ruoyi.web.controller.wxgz;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.wxgz.domain.WxgzXhsj;
import com.ruoyi.wxgz.service.IWxgzXhsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 信号数据Controller
 *
 * @author ruoyi
 * @date 2025-06-14
 */
@RestController
@RequestMapping("/wxgz/xhsj")
@Anonymous
public class WxgzXhsjController extends BaseController {
    @Autowired
    private IWxgzXhsjService wxgzXhsjService;

    /**
     * HTML->Java
     * 查询信号数据列表
     */
    @GetMapping("/list")
    public AjaxResult list(WxgzXhsj wxgzXhsj) {
        if (StrUtil.isNotBlank(wxgzXhsj.getDate())) {
            String[] split = wxgzXhsj.getDate().split(",");
            if (split.length > 0) {
                HashMap<String, Object> params = new HashMap<>();
                params.put("beginTime", split[0]);
                params.put("endTime", split[1]);
                wxgzXhsj.setParams(params);
                wxgzXhsj.setDate(null);
            }
        }
        List<WxgzXhsj> list = wxgzXhsjService.selectWxgzXhsjList(wxgzXhsj);
        return toAjax(list);
    }

    /**
     * C->Java
     * 新增信号数据
     */
    @Log(title = "信号数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody String param) {
        logger.info("信号数据进来了:{}", param);
        WxgzXhsj wxgzXhsj = new WxgzXhsj();
        wxgzXhsj.setContent(param);
        return toAjax(wxgzXhsjService.insertWxgzXhsj(wxgzXhsj));
    }


    /**
     * 导出信号数据列表
     */
    @PreAuthorize("@ss.hasPermi('wxgz:xhsj:export')")
    @Log(title = "信号数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WxgzXhsj wxgzXhsj) {
        List<WxgzXhsj> list = wxgzXhsjService.selectWxgzXhsjList(wxgzXhsj);
        ExcelUtil<WxgzXhsj> util = new ExcelUtil<WxgzXhsj>(WxgzXhsj.class);
        util.exportExcel(response, list, "信号数据数据");
    }

    /**
     * 获取信号数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('wxgz:xhsj:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(wxgzXhsjService.selectWxgzXhsjById(id));
    }

    /**
     * 修改信号数据
     */
    @PreAuthorize("@ss.hasPermi('wxgz:xhsj:edit')")
    @Log(title = "信号数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxgzXhsj wxgzXhsj) {
        return toAjax(wxgzXhsjService.updateWxgzXhsj(wxgzXhsj));
    }

    /**
     * 删除信号数据
     */
    @PreAuthorize("@ss.hasPermi('wxgz:xhsj:remove')")
    @Log(title = "信号数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wxgzXhsjService.deleteWxgzXhsjByIds(ids));
    }
}
