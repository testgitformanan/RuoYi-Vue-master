package com.ruoyi.web.controller.wxgz;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.GzztxsStatus;
import com.ruoyi.common.enums.GzztxsType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.wxgz.domain.WxgzGzztxs;
import com.ruoyi.wxgz.service.IWxgzGzztxsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 工作状态显示Controller
 *
 * @author ruoyi
 * @date 2025-06-14
 */
@RestController
@RequestMapping("/wxgz/gzztxs")
@Anonymous
public class WxgzGzztxsController extends BaseController {
    @Autowired
    private IWxgzGzztxsService wxgzGzztxsService;

    /**
     * HTML->Java
     * 查询工作状态显示列表
     */
    @GetMapping("/list")
    public AjaxResult list(WxgzGzztxs wxgzGzztxs) {
        if (StrUtil.isNotBlank(wxgzGzztxs.getDate())) {
            String[] split = wxgzGzztxs.getDate().split(",");
            if (split.length > 0) {
                HashMap<String, Object> params = new HashMap<>();
                params.put("beginTime", split[0]);
                params.put("endTime", split[1]);
                wxgzGzztxs.setParams(params);
                wxgzGzztxs.setDate(null);
            }
        }
        List<WxgzGzztxs> list = wxgzGzztxsService.selectWxgzGzztxsList(wxgzGzztxs);
        return toAjax(list);
    }

    /**
     * C->Java
     * 新增工作状态显示
     */
    @Log(title = "工作状态显示", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody String param) {
        logger.info("工作状态显示进来了:{}", param);
        JSONObject obj = JSONUtil.parseObj(param);
        obj.forEach((k, v) -> {
            int type = GzztxsType.getTypeByName(k);
            if (type != 0) {
                String statusName = GzztxsStatus.getNameByStatus(Convert.toStr(v));
                WxgzGzztxs wxgzGzztxs = new WxgzGzztxs();
                wxgzGzztxs.setType(Convert.toLong(type));
                wxgzGzztxs.setStatus(statusName);
                wxgzGzztxsService.insertWxgzGzztxs(wxgzGzztxs);
            }
        });
        return toAjax(1);
    }

    /**
     * 导出工作状态显示列表
     */
    @Log(title = "工作状态显示", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WxgzGzztxs wxgzGzztxs) {
        List<WxgzGzztxs> list = wxgzGzztxsService.selectWxgzGzztxsList(wxgzGzztxs);
        ExcelUtil<WxgzGzztxs> util = new ExcelUtil<WxgzGzztxs>(WxgzGzztxs.class);
        util.exportExcel(response, list, "工作状态显示数据");
    }

    /**
     * 获取工作状态显示详细信息
     */
    @PreAuthorize("@ss.hasPermi('wxgz:gzztxs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(wxgzGzztxsService.selectWxgzGzztxsById(id));
    }

    /**
     * 修改工作状态显示
     */
    @PreAuthorize("@ss.hasPermi('wxgz:gzztxs:edit')")
    @Log(title = "工作状态显示", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxgzGzztxs wxgzGzztxs) {
        return toAjax(wxgzGzztxsService.updateWxgzGzztxs(wxgzGzztxs));
    }

    /**
     * 删除工作状态显示
     */
    @PreAuthorize("@ss.hasPermi('wxgz:gzztxs:remove')")
    @Log(title = "工作状态显示", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wxgzGzztxsService.deleteWxgzGzztxsByIds(ids));
    }
}
