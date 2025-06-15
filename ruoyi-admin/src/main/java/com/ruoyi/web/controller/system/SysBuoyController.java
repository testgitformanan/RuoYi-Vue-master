package com.ruoyi.web.controller.system;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysBuoyDto;
import com.ruoyi.common.core.domain.entity.SysCommunication;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.SysBuoy;
import com.ruoyi.system.domain.SysBuoyInformation;
import com.ruoyi.system.domain.SysBuoyRadioSensing;
import com.ruoyi.system.service.ISysBuoyInformationService;
import com.ruoyi.system.service.ISysBuoyRadioSensingService;
import com.ruoyi.system.service.ISysBuoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * 浮标
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/buoy")
public class SysBuoyController extends BaseController
{
    @Autowired
    private ISysBuoyService buoyService;

    @Autowired
    private ISysBuoyRadioSensingService radioSensingService;

    @Autowired
    private ISysBuoyInformationService buoyInformationService;


    /**
     * 浮标信息获取
     */
    @GetMapping("/getBuoyInfo")
    public AjaxResult getBuoyInfo(SysCommunication communication)
    {
        List<SysBuoy> menus = buoyService.getBuoyInfo(null, getUserId());
        return success(menus);
    }

    /**
     * 浮标启动/关闭连接
     */
    @RequestMapping("/connect")
    public AjaxResult connectBuoy(@RequestBody String param)
    {
        String menus = buoyService.connectBuoy(param, 1L);
        return success(menus);
    }

    /**
     * 浮标工作参数配置
     */
    @PostMapping("/set/buoyJobParam")
    public AjaxResult setBuoyJobParam(@RequestBody String communication)
    {
        String menus = buoyService.setBuoyJobParam(communication, 1L);
        return success(menus);
    }

    /**
     * 水声通信机启动/关闭连接
     */
    @RequestMapping("/connect/machine")
    public AjaxResult connectBuoyMachine(@RequestBody String param)
    {
        String menus = buoyService.connectBuoyMachine(param, 1L);
        return success(menus);
    }
    /**
     * 水声通信机工作参数配置
     */
    @PostMapping("/set/machineJobParam")
    public AjaxResult setMachineJobParam(@RequestBody String communication)
    {
        System.out.println(communication);
        String menus = buoyService.setMachineJobParam(communication, 1L);
        return success(menus);
    }

    /**
     * 水声通信机导入工作参数文件  远程控制指令发送并发送远程控制指令
     */

    @PostMapping("/upload/machine/jobParam/send")
    public AjaxResult sendMachineJobParam(@RequestParam("file") MultipartFile file) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);

            SysCommunication sysCommunication = new SysCommunication();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {

                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysCommunication.setModulationType(split0);
                    sysCommunication.setSendGain(split1);
                    sysCommunication.setReceiverGain(split2);
                }
                // 解析每一行文本的逻辑
                System.out.println(line);
            }
            scanner.close();
            String jsonString = JSON.toJSONString(sysCommunication);
            String menus = buoyService.setMachineJobParam(jsonString, 1L);
            return success(menus);
        } catch (Exception e) {
            return error("上传失败: " + e.getMessage());
        }
    }
    /**
     * 水声通信机器导入工作状态文件
     */

    @PostMapping("/upload/machine/jobStatus/send")
    public AjaxResult sendMachineJobStatus(@RequestParam("file") MultipartFile file) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);

            SysCommunication sysCommunication = new SysCommunication();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {

                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysCommunication.setModulationTypeSet(split0);
                    sysCommunication.setSendGainSet(split1);
                    sysCommunication.setReceiverGainSet(split2);
                }
                // 解析每一行文本的逻辑
                System.out.println(line);
            }
            scanner.close();
            String jsonString = JSON.toJSONString(sysCommunication);
//            String menus = buoyService.setBuoyJobParam(jsonString, 1L);
            return success(jsonString);
        } catch (Exception e) {
            return error("上传失败: " + e.getMessage());
        }
    }

    /**
     * 浮标工作参数远程控制指令接收  c-java端
     */
    @RequestMapping("/connect/buoy/jobParam/get/c")
    public AjaxResult getBuoyJobParam(@RequestBody String test) {
        System.out.println(test);
        long l = 1L;
        String fileName = l + "getBuoyJobParam.txt";
        // todo 写入文件与存储数据库处理
        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyInfo(test,1L);
        return success(test);
    }

    /**
     * 浮标工作状态显示  c-java端
     */
    @RequestMapping("/connect/buoy/jobStatus/get/c")
    public AjaxResult getBuoyJobStatusGetC(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        // todo 写入文件与存储数据库处理
        String fileName = l + "getBuoyJobStatus.txt";
        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyInfo(test,1L);
        return success(test);
    }

    /**
     * 浮标信号数据显示  c-java端
     */
    @RequestMapping("/connect/buoy/information/get/c")
    public AjaxResult getBuoyInformationForC(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        // todo 写入文件与存储数据库处理
        String fileName = l + "getBuoyJobStatus.txt";
        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        SysBuoyInformation sysBuoyInformation = new SysBuoyInformation();
        sysBuoyInformation.setId(l);
        sysBuoyInformation.setInformationFileName(fileName);
        sysBuoyInformation.setContent(test);
        buoyInformationService.insertSysBuoyInformation(sysBuoyInformation);
        return success(test);
    }


    /**
     * 水声通信机工作参数远程控制指令接收  c-java端
     */
    @RequestMapping("/connect/machine/jobParam/get")
    public AjaxResult getMachineJobParam(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        // todo 写入文件与存储数据库处理
        String fileName = l + "getMachineJobParam.txt";
        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyMachineInfo(test,1L);
        return success(test);
    }

    /**
     * 水声通信机工作状态显示   c-java端
     */
    @RequestMapping("/connect/machine/jobStatus/get")
    public AjaxResult getMachineJobStatus(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        // todo 写入文件与存储数据库处理
        String fileName = l + "getMachineJobStatus.txt";
        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyMachineInfo(test,1L);
        return success(test);
    }


    /**
     * 浮标信号数据显示  web-java端
     */
    @RequestMapping("/connect/buoy/information/get/web")
    public AjaxResult getBuoyInformationForWeb(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        SysBuoyInformation sysBuoyInformation = new SysBuoyInformation();
        List<SysBuoyInformation> sysBuoyInformations = buoyInformationService.selectSysBuoyInformationList(sysBuoyInformation);
        return success(sysBuoyInformations);
    }

    /**
     * 浮标工作状态显示  web-java端  先试用getBuoyInfo获取全部浮标信息接口
     */
    @RequestMapping("/connect/buoy/jobStatus/get/web")
    public AjaxResult getBuoyJobStatusGetWeb(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        String fileName = l + "getBuoyJobStatus.txt";
        try {
            File absoluteFile = FileUploadUtils.getAbsoluteFile(UPLOAD_DIR, fileName);

        }catch (Exception e) {
            e.printStackTrace();
        }
        // todo 需要从数据库读取对应数据进行返回页面展示

        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        return success(test);
    }

    /**
     * 浮标导入工作状态文件  wen-java
     */

    @PostMapping("/upload/buoy/jobStatus/send")
    public AjaxResult sendBuoyJobStatus(@RequestParam("file") MultipartFile file) {
        SysBuoyDto sysBuoyDto = buoyService.sendBuoyJobStatus(file, 1L);
        return success(sysBuoyDto);
    }

    /**
     * 浮标导入工作参数远程控制指令发送文件 并发送远程控制指令请求    wen-java  java-c
     */
    @PostMapping("/upload/buoy/jobParam/send")
    public AjaxResult sendBuoyJobParamSend(@RequestParam("file") MultipartFile file) {

        String menus = buoyService.sendBuoyJobParam(file, 1L);
        if(menus!= null){
            return success(menus);
        }
        return error("0");
    }

    /**
     * 浮标导入工作参数远程控制指令接收文件    wen-java
     */
    @PostMapping("/upload/buoy/jobParam/get")
    public AjaxResult sendBuoyJobParam(@RequestParam("file") MultipartFile file) {

        String menus = buoyService.analyzeBuoyJobParam(file, 1L);
        if(menus!= null){
            return success(menus);
        }
        return error("0");
    }


    /**
     * 浮标无线电感知教学 内容获取
     */
    @GetMapping("/getBuoyRadioSensing")
    public AjaxResult getBuoyRadioSensing(SysCommunication communication)
    {
        SysBuoyRadioSensing buoyRadioSensing = new SysBuoyRadioSensing();
        List<SysBuoyRadioSensing> sysBuoyRadioSensings = radioSensingService.selectSysBuoyRadioSensingList(buoyRadioSensing);
        return success(sysBuoyRadioSensings);
    }


    private final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public AjaxResult uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String upload = FileUploadUtils.upload(UPLOAD_DIR, file);
            return success(upload);
        } catch (Exception e) {
            return error("上传失败: " + e.getMessage());
        }
    }



    @GetMapping("/download")
    public void downloadFile(String fileName, HttpServletResponse response) {
        try {
            File file = FileUploadUtils.getAbsoluteFile(UPLOAD_DIR, fileName);
            if (!file.exists()) {
                throw new Exception("文件不存在");
            }
            FileUtils.setAttachmentResponseHeader(response,fileName);
            FileInputStream inputStream = new FileInputStream(file);
            ServletOutputStream out = response.getOutputStream();

            int b = 0;
            byte[] buffer = new byte[1024];
            while (b != -1) {
                b = inputStream.read(buffer);
                //4.写到输出流(out)中
                out.write(buffer, 0, b);
            }
            out.flush();
            out.close();
            inputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}