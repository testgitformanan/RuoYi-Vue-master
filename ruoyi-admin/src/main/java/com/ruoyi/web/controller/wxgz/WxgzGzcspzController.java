package com.ruoyi.web.controller.wxgz;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.wxgz.domain.WxgzGzcspz;
import com.ruoyi.wxgz.service.IWxgzGzcspzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 无线感知工作参数配置Controller
 *
 * @author ruoyi
 * @date 2025-06-13
 */
@RestController
@RequestMapping("/wxgz/gzcspz")
@Anonymous
public class WxgzGzcspzController extends BaseController {
    @Autowired
    private IWxgzGzcspzService wxgzGzcspzService;
    private final String url = "http://1095rm2tl0368.vicp.fun";

    /**
     * HTML->Java
     * 查询无线感知工作参数配置列表
     */
    @GetMapping("/list")
    public AjaxResult list(WxgzGzcspz wxgzGzcspz) {
        if (StrUtil.isNotBlank(wxgzGzcspz.getDate())) {
            String[] split = wxgzGzcspz.getDate().split(",");
            if (split.length > 0) {
                HashMap<String, Object> params = new HashMap<>();
                params.put("beginTime", split[0]);
                params.put("endTime", split[1]);
                wxgzGzcspz.setParams(params);
                wxgzGzcspz.setDate(null);
            }
        }
        List<WxgzGzcspz> list = wxgzGzcspzService.selectWxgzGzcspzList(wxgzGzcspz);
        return toAjax(list);
    }

    /**
     * HTML->Java
     * 新增无线感知工作参数配置
     */
    @Log(title = "无线感知工作参数配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxgzGzcspz wxgzGzcspz) {
        //向c发送数据，并将数据保存
        int rows = wxgzGzcspzService.insertWxgzGzcspz(wxgzGzcspz);
        JSONObject obj = JSONUtil.createObj();
        obj.putOpt("id", wxgzGzcspz.getId());
        obj.putOpt("hz", wxgzGzcspz.getHz());
        obj.putOpt("speed", wxgzGzcspz.getHz());
        obj.putOpt("height", wxgzGzcspz.getHz());
        obj.putOpt("mode", wxgzGzcspz.getHz());
        String postJson = HttpUtils.sendPostJson(url + "/wxgz/gzcspz/yckzzl", obj.toString());
        // success!
        logger.info("工作参数配置C返回数据：{}", postJson);
        if (!StrUtil.equals(postJson, "success!")) {
            wxgzGzcspzService.deleteWxgzGzcspzById(wxgzGzcspz.getId());
            throw new ServiceException("C端接口返回失败" + postJson);
        }
        //数据保存到文件中
        /*if (rows > 0) {
            String fileName = RuoYiConfig.getProfile() + "/" + DateUtils.getNowYmd() + ".txt";
            File file = new File(fileName);
            if (file.exists()) {
                String s = FileUtil.readUtf8String(fileName);
                List<WxgzGzcspz> list = JSONUtil.toList(s, WxgzGzcspz.class);
                list.add(wxgzGzcspz);
                FileUtil.writeUtf8String(JSONUtil.toJsonStr(list), fileName);
            } else {
                try {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();  // 自动创建多级父目录
                    }
                    file.createNewFile();

                    List<WxgzGzcspz> list = new ArrayList<>();
                    list.add(wxgzGzcspz);
                    FileUtil.writeUtf8String(JSONUtil.toJsonStr(list), fileName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }*/
        return toAjax(rows);
    }

    /**
     * C->Java
     * 修改无线感知工作参数配置
     */
    @Log(title = "无线感知工作参数配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody String param) {
        logger.info("工作参数配置进来了:{}", param);
        JSONObject obj = JSONUtil.parseObj(param);
        WxgzGzcspz gzcspz = new WxgzGzcspz();
        gzcspz.setId(obj.getLong("id"));
        gzcspz.setContent(obj.getStr("data"));
        return toAjax(wxgzGzcspzService.updateWxgzGzcspz(gzcspz));
    }

    /**
     * 导出无线感知工作参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('wxgz:gzcspz:export')")
    @Log(title = "无线感知工作参数配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WxgzGzcspz wxgzGzcspz) {
        List<WxgzGzcspz> list = wxgzGzcspzService.selectWxgzGzcspzList(wxgzGzcspz);
        ExcelUtil<WxgzGzcspz> util = new ExcelUtil<WxgzGzcspz>(WxgzGzcspz.class);
        util.exportExcel(response, list, "无线感知工作参数配置数据");
    }

    /**
     * 获取无线感知工作参数配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('wxgz:gzcspz:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(wxgzGzcspzService.selectWxgzGzcspzById(id));
    }

    /**
     * 删除无线感知工作参数配置
     */
    @PreAuthorize("@ss.hasPermi('wxgz:gzcspz:remove')")
    @Log(title = "无线感知工作参数配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wxgzGzcspzService.deleteWxgzGzcspzByIds(ids));
    }


    @PostMapping("/file/Upload")
    public AjaxResult fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        System.out.println(filePath);
        System.out.println(fileName);
        return toAjax(1);
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/file/Download")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            // 本地资源路径
            String localPath = RuoYiConfig.getDownloadPath();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (Exception e) {
            logger.error("下载文件失败", e);
        }
    }
}
