package com.ruoyi.web.controller.wxgz;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
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
    public TableDataInfo list(WxgzGzcspz wxgzGzcspz) {
        logger.info("前端无线感知显示请求：{}", JSONUtil.toJsonStr(wxgzGzcspz));
        startPage();
        List<WxgzGzcspz> list = wxgzGzcspzService.selectWxgzGzcspzList(wxgzGzcspz);
        return getDataTable(list);
    }

    /**
     * HTML->Java
     * 新增无线感知工作参数配置
     */
    @Log(title = "无线感知工作参数配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody String wxgzGzcspz) {
        logger.info("无线感知工作参数请求参数：{}", JSONUtil.toJsonStr(wxgzGzcspz));
        JSONObject wxgzObj = JSONUtil.parseObj(wxgzGzcspz);
        JSONObject obj = JSONUtil.createObj();
        obj.putOpt("storage_start", wxgzObj.get("storage_start"));
        obj.putOpt("storage_stop", wxgzObj.get("storage_stop"));
        obj.putOpt("storage_time", wxgzObj.get("storage_time"));
        obj.putOpt("workMode", wxgzObj.get("workMode"));
        obj.putOpt("rfMode", wxgzObj.get("rfMode"));
        obj.putOpt("Manua", wxgzObj.get("Manua"));
        obj.putOpt("AGCtime", wxgzObj.get("AGCtime"));
        JSONObject freqObj = JSONUtil.createObj();
        freqObj.putOpt("center", wxgzObj.get("center"));
        freqObj.putOpt("bw", 400);
        obj.putOpt("freq", freqObj);
        JSONObject funcObj = JSONUtil.createObj();
        funcObj.putOpt("switch", wxgzObj.get("switch"));
        obj.putOpt("func", funcObj);
        JSONObject specObj = JSONUtil.createObj();
        specObj.putOpt("report", wxgzObj.get("report"));
        specObj.putOpt("mode", wxgzObj.get("mode"));
        specObj.putOpt("freqRes", wxgzObj.get("freqRes"));
        specObj.putOpt("timeSmooth", wxgzObj.get("timeSmooth"));
        specObj.putOpt("freqSmooth", wxgzObj.get("freqSmooth"));
        obj.putOpt("spec", specObj);
        JSONObject rfCtrlObj = JSONUtil.createObj();
        rfCtrlObj.putOpt("txSw", wxgzObj.get("txSw"));
        rfCtrlObj.putOpt("txAtt", wxgzObj.get("txAtt"));
        rfCtrlObj.putOpt("rxFrq", wxgzObj.get("rxFrq"));
        rfCtrlObj.putOpt("moFrq", wxgzObj.get("moFrq"));
        rfCtrlObj.putOpt("txFrq", wxgzObj.get("txFrq"));
        rfCtrlObj.putOpt("rxSel", wxgzObj.get("rxSel"));
        rfCtrlObj.putOpt("antSw", wxgzObj.get("antSw"));
        JSONArray rxAttArr = JSONUtil.createArray();
        for (int i = 1; i < 8; i++) {
            JSONObject rxAttObj = JSONUtil.createObj();
            rxAttObj.putOpt("id", i);
            rxAttObj.putOpt("att", wxgzObj.get("rxAtt"));
            rxAttArr.add(rxAttObj);
        }
        rfCtrlObj.putOpt("rxAtt", rxAttArr);
        obj.putOpt("rfCtrl", rfCtrlObj);
        String postJson = HttpUtils.sendPostJson(url + "/wxgz/gzcspz/yckzzl", obj.toString());
        // success!
        logger.info("工作参数配置C返回数据：{}", postJson);
        /*if (!StrUtil.equals(postJson, "success!")) {
            wxgzGzcspzService.deleteWxgzGzcspzById(wxgzGzcspz.getId());
            throw new ServiceException("C端接口返回失败" + postJson);
        }*/
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
        return toAjax(1);
    }

    /**
     * C->Java
     * 修改无线感知工作参数配置
     */
    @Log(title = "无线感知工作参数配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody String param) {
        logger.info("工作参数配置进来了:{}", param);

        JSONObject wxgzObj = JSONUtil.parseObj(param);
        JSONObject obj = JSONUtil.createObj();
        obj.putOpt("workMode", wxgzObj.get("workMode"));
        obj.putOpt("rfMode", wxgzObj.get("rfMode"));
        obj.putOpt("Manua", wxgzObj.get("Manua"));
        obj.putOpt("AGCtime", wxgzObj.get("AGCtime"));
        JSONObject freqObj = wxgzObj.getJSONObject("freq");
        obj.putOpt("center", freqObj.get("center"));
        obj.putOpt("bw", freqObj.get("bw"));
        JSONObject funcObj = wxgzObj.getJSONObject("func");
        obj.putOpt("switch", funcObj.get("switch"));
        JSONObject specObj = wxgzObj.getJSONObject("spec");
        obj.putOpt("report", specObj.get("report"));
        obj.putOpt("mode", specObj.get("mode"));
        obj.putOpt("freqRes", specObj.get("freqRes"));
        obj.putOpt("timeSmooth", specObj.get("timeSmooth"));
        obj.putOpt("freqSmooth", specObj.get("freqSmooth"));
        JSONObject rfCtrlObj = wxgzObj.getJSONObject("rfCtrl");
        obj.putOpt("txSw", rfCtrlObj.get("txSw"));
        obj.putOpt("txAtt", rfCtrlObj.get("txAtt"));
        obj.putOpt("rxFrq", rfCtrlObj.get("rxFrq"));
        obj.putOpt("moFrq", rfCtrlObj.get("moFrq"));
        obj.putOpt("txFrq", rfCtrlObj.get("txFrq"));
        obj.putOpt("rxSel", rfCtrlObj.get("rxSel"));
        obj.putOpt("antSw", rfCtrlObj.get("antSw"));
        obj.putOpt("rxAtt", rfCtrlObj.getJSONArray("rxAtt").getJSONObject(0).get("att"));

        WxgzGzcspz gzcspz = new WxgzGzcspz();
        gzcspz.setContent(obj.toString());
        int rows = wxgzGzcspzService.updateWxgzGzcspz(gzcspz);
        logger.info("无线感知工作参数配置新增返回C：{}", rows);
        return toAjax(rows);
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
