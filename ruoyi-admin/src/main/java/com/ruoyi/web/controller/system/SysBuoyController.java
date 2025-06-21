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
import com.ruoyi.system.domain.SysBuoyMachine;
import com.ruoyi.system.domain.SysBuoyRadioSensing;
import com.ruoyi.system.service.ISysBuoyInformationService;
import com.ruoyi.system.service.ISysBuoyMachineService;
import com.ruoyi.system.service.ISysBuoyRadioSensingService;
import com.ruoyi.system.service.ISysBuoyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * 浮标
 * 
 * @author ruoyi
 */
@Api("浮标管理")
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

    @Autowired
    private ISysBuoyMachineService buoyMachineService;


    /**
     * 浮标信息获取
     */
    @ApiOperation("获取浮标详情")
    @GetMapping("/getBuoyInfo")
    public AjaxResult getBuoyInfo(SysCommunication communication)
    {
//        SysBuoy menus = buoyService.getBuoyInfo(null, getUserId());
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        SysBuoy buoy = new SysBuoy();
        buoy.setTypeStatus(0L);
        List<SysBuoy> sysBuoys = buoyService.selectSysBuoyList(buoy);
        objectObjectHashMap.put("fbgzzt", sysBuoys);
        SysBuoy buoy1 = new SysBuoy();
        buoy1.setTypeStatus(1L);
        List<SysBuoy> sysBuoys1 = buoyService.selectSysBuoyList(buoy1);
        objectObjectHashMap.put("fbgzcs", sysBuoys1);
        SysBuoy buoy2 = new SysBuoy();
        buoy2.setTypeStatus(2L);
        List<SysBuoy> sysBuoys2 = buoyService.selectSysBuoyList(buoy2);
        objectObjectHashMap.put("fbtxlj", sysBuoys2);
        return success(objectObjectHashMap);
    }
    /**
     * 浮标连接信息获取
     */
    @ApiOperation("获取浮标连接信息")
    @GetMapping("/get/buoy/connect/info")
    public AjaxResult getBuoyConnectInfo(SysBuoy buoy)
    {
        buoy.setTypeStatus(2L);
        List<SysBuoy> sysBuoys = buoyService.selectSysBuoyList(buoy);
        return success(sysBuoys);
    }

    /**
     * 浮标工作状态获取
     */
    @ApiOperation("获取浮标工作状态")
    @GetMapping("/get/buoy/job/status")
    public AjaxResult getBuoyJobStatus(SysBuoy buoy)
    {
        buoy.setTypeStatus(0L);
        List<SysBuoy> sysBuoys = buoyService.selectSysBuoyList(buoy);
        return success(sysBuoys);
    }

    /**
     * 浮标工作参数列表获取
     */
    @ApiOperation("获取浮标工作参数")
    @GetMapping("/get/buoy/job/param")
    public AjaxResult getBuoyJobParam(SysBuoy buoy)
    {
        buoy.setTypeStatus(1L);
        List<SysBuoy> sysBuoys = buoyService.selectSysBuoyList(buoy);
        return success(sysBuoys);
    }


    /**
     * 水声通信机工作状态获取
     */
    @ApiOperation("获取水声通信机工作状态")
    @GetMapping("/get/buoy/machine/job/status")
    public AjaxResult getBuoyMachineJobStatus(SysBuoyMachine buoyMachine)
    {
        buoyMachine.setTypeStatus(0L);
        List<SysBuoyMachine> sysBuoyMachines = buoyMachineService.selectSysBuoyMachineList(buoyMachine);
        return success(sysBuoyMachines);
    }

    /**
     * 水声通信机工作参数列表获取
     */
    @ApiOperation("获取水声通信机工作参数")
    @GetMapping("/get/buoy/machine/job/param")
    public AjaxResult getBuoyMachineJobParam(SysBuoyMachine buoyMachine)
    {
        buoyMachine.setTypeStatus(1L);
        List<SysBuoyMachine> sysBuoyMachines = buoyMachineService.selectSysBuoyMachineList(buoyMachine);
        return success(sysBuoyMachines);
    }

    /**
     * 浮标启动/关闭连接
     */
    @ApiOperation("浮标启动/关闭连接")
    @RequestMapping("/connect")
    public AjaxResult connectBuoy(@RequestBody String param)
    {
        String menus = buoyService.connectBuoy(param, getUserId());
        return success(menus);
    }

    /**
     * 浮标工作参数配置
     */
    @ApiOperation("浮标工作参数配置")
    @PostMapping("/set/buoyJobParam")
    public AjaxResult setBuoyJobParam(@RequestBody String communication)
    {
        String menus = buoyService.setBuoyJobParam(communication, getUserId());
        return success(menus);
    }

    /**
     * 水声通信机启动/关闭连接
     */
    @ApiOperation("水声通信机启动/关闭连接")
    @RequestMapping("/connect/machine")
    public AjaxResult connectBuoyMachine(@RequestBody String param)
    {
        String menus = buoyService.connectBuoyMachine(param, getUserId());
        return success(menus);
    }
    /**
     * 水声通信机工作参数配置
     */
    @ApiOperation("水声通信机工作参数配置")
    @PostMapping("/set/machineJobParam")
    public AjaxResult setMachineJobParam(@RequestBody String communication)
    {
        System.out.println(communication);
        String menus = buoyService.setMachineJobParam(communication, getUserId());
        return success(menus);
    }

    /**
     * 水声通信机导入工作参数文件  远程控制指令发送并发送远程控制指令
     */
    @ApiOperation("水声通信机导入工作参数文件")
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
            String menus = buoyService.setMachineJobParam(jsonString, getUserId());
            return success(menus);
        } catch (Exception e) {
            return error("上传失败: " + e.getMessage());
        }
    }
    /**
     * 水声通信机器导入工作状态文件
     */
    @ApiOperation("水声通信机器导入工作状态文件")
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
//        String fileName = l + "getBuoyJobParam.txt";
//        // todo 写入文件与存储数据库处理
//        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyInfo(test,getUserId(),1L);
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
//        String fileName = l + "getBuoyJobStatusGetC.txt";
//        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyInfo(test,getUserId(),0L);
        return success(test);
    }

    /**
     * 浮标连接启动和关闭状态获取  c-java端
     */
    @RequestMapping("/connect/status/buoy/get/c")
    public AjaxResult getBuoyConnectStatusGetC(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        String string = UUID.randomUUID().toString();
        // todo 写入文件与存储数据库处理
//        String fileName = l + "getBuoyConnectStatusGetC.txt";
//        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyInfo(test,getUserId(),3L);
        return success(test);
    }


    /**
     * 浮标信号数据显示  c-java端
     */
    @RequestMapping("/connect/buoy/information/get/c")
    public AjaxResult getBuoyInformationForC(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        buoyService.analyzeBuoyInformation(file,getUserId());
        return success(1);
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
//        String fileName = l + "getMachineJobParam.txt";
//        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyMachineInfo(test,l,1L);
        return success(test);
    }

    /**
     * 水声通信机启动关闭连接状态获取   c-java端
     */
    @RequestMapping("/connect/status/machine/get/c")
    public AjaxResult getMachineConnectStatusGetC(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        // todo 写入文件与存储数据库处理
//        String fileName = l + "getMachineConnectStatusGetC.txt";
//        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyMachineInfo(test,l,3L);
        return success(test);
    }

    /**
     * 浮标无线电感知radioSensing获取   c-java端
     */
    @RequestMapping("/connect/radio/sensing/get/c")
    public AjaxResult getConnectRadioSensingGetC(@RequestBody String test)
    {
        System.out.println(test);
        long l = 1L;
        buoyService.saveBuoyRadioSensing(test,l);
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
//        String fileName = l + "getMachineJobStatus.txt";
//        FileUtils.WriteTxtFile(test,UPLOAD_DIR,fileName);
        buoyService.saveBuoyMachineInfo(test,l,0L);
        return success(test);
    }


    /**
     * 浮标信号数据显示  web-java端
     */
    @ApiOperation("浮标信号数据显示")
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
    @ApiOperation("浮标导入工作状态文件")
    @PostMapping("/upload/buoy/jobStatus/send")
    public AjaxResult sendBuoyJobStatus(@RequestParam("file") MultipartFile file) {
        SysBuoyDto sysBuoyDto = buoyService.sendBuoyJobStatus(file, getUserId());
        return success(sysBuoyDto);
    }

    /**
     * 浮标导入工作参数远程控制指令发送文件 并发送远程控制指令请求    wen-java  java-c
     */
    @ApiOperation("浮标导入工作参数远程控制指令发送文件")
    @PostMapping("/upload/buoy/jobParam/send")
    public AjaxResult sendBuoyJobParamSend(@RequestParam("file") MultipartFile file) {

        String menus = buoyService.sendBuoyJobParam(file, getUserId());
        if(menus!= null){
            return success(menus);
        }
        return error("0");
    }

    /**
     * 浮标导入信号数据文件 并发送到c端  web-java端
     */
    @ApiOperation("浮标导入信号数据文件")
    @RequestMapping("/upload/buoy/information/get/web")
    public AjaxResult uploadBuoyInformationForWeb(@RequestParam("file") MultipartFile file)
    {
        String s = buoyService.uploadBuoyInformation(file, getUserId());
        return success(s);
    }

    /**
     * 浮标数据文件文件个数传递 并发送到c端  web-java端
     */
    @ApiOperation("浮标数据文件文件个数传递")
    @RequestMapping("/connect/buoy/information/file/number/get/web")
    public AjaxResult connectBuoyInformationFileNumberForWeb(@RequestBody String fileNumber)
    {
        String s = buoyService.connectBuoyInformationFileNumberForWeb(fileNumber, getUserId());
        return success(s);
    }

    /**
     * 浮标导入工作参数远程控制指令接收文件    wen-java
     */
    @ApiOperation("浮标导入工作参数远程控制指令接收文件")
    @PostMapping("/upload/buoy/jobParam/get")
    public AjaxResult sendBuoyJobParam(@RequestParam("file") MultipartFile file) {

        String menus = buoyService.analyzeBuoyJobParam(file, getUserId());
        if(menus!= null){
            return success(menus);
        }
        return error("0");
    }


    /**
     * 浮标无线电感知教学 内容获取
     */
    @ApiOperation("浮标无线电感知教学 内容获取")
    @GetMapping("/get/buoy/radioSensing")
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