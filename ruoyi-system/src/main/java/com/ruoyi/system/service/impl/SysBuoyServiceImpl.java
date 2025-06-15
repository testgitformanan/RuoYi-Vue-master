package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.*;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.SysBuoy;
import com.ruoyi.system.domain.SysBuoyMachine;
import com.ruoyi.system.domain.vo.MetaVo;
import com.ruoyi.system.domain.vo.RouterVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysBuoyService;
import com.ruoyi.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 菜单 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysBuoyServiceImpl implements ISysBuoyService
{
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";
    private final String UPLOAD_DIR = "uploads/";


    @Autowired
    private SysMenuMapper menuMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Autowired
    private SysBuoyMachineMapper sysBuoyMachineMapper;

    private SysBuoyMapper sysBuoyMapper;

    /**
     * 浮标启动/关闭连接
     * 
     * @param param 浮标信息
     * @return 菜单列表
     */
    @Override
    public String connectBuoy(String param, Long userId)
    {
//        JSONObject jsonObject = JSONObject.parseObject(param);
//        Integer port = jsonObject.get("port")==null?null:(Integer)jsonObject.get("port");
//        String baudRate = jsonObject.get("baudRate")==null?null:(String)jsonObject.get("baudRate");
//        String modulationTypeSet = jsonObject.get("modulationTypeSet")==null?null:(String)jsonObject.get("modulationTypeSet");
//        String sendGainSet = jsonObject.get("sendGainSet")==null?null:(String)jsonObject.get("sendGainSet");
//        String receiverGainSet = jsonObject.get("receiverGainSet")==null?null:(String)jsonObject.get("receiverGainSet");
//        System.out.println("port:"+port+"baudRate:"+baudRate);
//        SysCommunication communication = new SysCommunication();
//        System.out.println(communication);

        // 启动与关闭连接
        String apiUrl = "http://1095rm2tl0368.vicp.fun/fb/gzcspz/ljqt";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        String postResponse = "";
        try {
//            communication.setPort(port);
//            communication.setBaudRate(baudRate);
//            communication.setModulationTypeSet(modulationTypeSet);
//            communication.setSendGainSet(sendGainSet);
//            communication.setReceiverGainSet(receiverGainSet);
//            String jsonString = JSON.toJSONString(communication);
//            System.out.println(jsonString);
//            String postResponse = sendPostRequest(apiUrl, headers, jsonString);
            postResponse = sendPostRequest(apiUrl, headers, param);
            System.out.println("POST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("我来了connect");
        return postResponse;
    }

    /**
     * 水声通信机启动/关闭连接
     *
     * @param param 浮标信息
     * @return 菜单列表
     */
    @Override
    public String connectBuoyMachine(String param, Long userId)
    {
//        JSONObject jsonObject = JSONObject.parseObject(param);
//        Integer port = jsonObject.get("port")==null?null:(Integer)jsonObject.get("port");
//        String baudRate = jsonObject.get("baudRate")==null?null:(String)jsonObject.get("baudRate");
//        String modulationTypeSet = jsonObject.get("modulationTypeSet")==null?null:(String)jsonObject.get("modulationTypeSet");
//        String sendGainSet = jsonObject.get("sendGainSet")==null?null:(String)jsonObject.get("sendGainSet");
//        String receiverGainSet = jsonObject.get("receiverGainSet")==null?null:(String)jsonObject.get("receiverGainSet");
//        System.out.println("port:"+port+"baudRate:"+baudRate);
//        SysCommunication communication = new SysCommunication();
//        System.out.println(communication);

        // 启动与关闭连接
        String apiUrl = "http://1095rm2tl0368.vicp.fun/fb/gzcspz/ljqt";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        String postResponse = "";
        try {
//            communication.setPort(port);
//            communication.setBaudRate(baudRate);
//            communication.setModulationTypeSet(modulationTypeSet);
//            communication.setSendGainSet(sendGainSet);
//            communication.setReceiverGainSet(receiverGainSet);
//            String jsonString = JSON.toJSONString(communication);
//            System.out.println(jsonString);
//            String postResponse = sendPostRequest(apiUrl, headers, jsonString);
            postResponse = sendPostRequest(apiUrl, headers, param);
            System.out.println("POST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("我来了connect");
        return postResponse;
    }

    /**
     * 浮标工作参数配置
     *
     * @param param 浮标信息
     * @return 菜单列表
     */
    @Override
    public String setBuoyJobParam(String param, Long userId)
    {
        // 配置工作参数
        String apiUrl = "http://1095rm2tl0368.vicp.fun/fb/gzcspz/yckzzl";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        try {
            String postResponse = sendPostRequest(apiUrl, headers, param);
            System.out.println("POST Response: " + postResponse);
            return postResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 水声通信机工作参数配置
     *
     * @param communication 浮标信息
     * @return 菜单列表
     */
    @Override
    public String setMachineJobParam(String communication, Long userId)
    {
        // 配置工作参数
        String apiUrl = "http://1095rm2tl0368.vicp.fun/fb/gzcspz/yckzzl";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        try {
            String postResponse = sendPostRequest(apiUrl, headers, communication);
            System.out.println("POST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("我来了connect");
        return null;
    }

    /**
     * 查询浮标详细信息
     *
     * @param communication 菜单信息
     * @return 菜单列表
     */
    @Override
    public List<SysBuoy> getBuoyInfo(SysCommunication communication, Long userId)
    {
        SysBuoy buoy = new SysBuoy();
        buoy.setId(userId);
        SysBuoyMachine buoyMachine = new SysBuoyMachine();
        List<SysBuoyMachine> sysBuoyMachines = sysBuoyMachineMapper.selectSysBuoyMachineList(buoyMachine);
        buoy.setSysBuoyMachines(sysBuoyMachines);
        return sysBuoyMapper.selectSysBuoyList(buoy);
    }

    /**
     * 发送POST请求
     */
    public static String sendPostRequest(String apiUrl, Map<String, String> headers, String postData) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        // 设置请求头
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        // 设置请求体
        connection.setDoOutput(true);
        try (java.io.OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = postData.getBytes(StandardCharsets.UTF_8);
            outputStream.write(input, 0, input.length);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }
    /**
     * 解析浮標傳入文件  工作参数远程控制指令接收文件
     * @param file
     * @param userId
     * @return
     */
    @Override
    public String analyzeBuoyJobParam(MultipartFile file, Long userId){
        Scanner scanner = null;
        SysBuoyDto sysBuoyDto = new SysBuoyDto();
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            scanner = new Scanner(file1);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {
                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysBuoyDto.setCommunicationFrequencyJobParam(split0);
                    sysBuoyDto.setModulationTypeJobParam(split1);
                    sysBuoyDto.setGainJobParam(split2);
                }
                // 解析每一行文本的逻辑
            }
            scanner.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String jsonString = JSON.toJSONString(sysBuoyDto);
        return jsonString;
    }


    /**
     * 浮标导入工作参数文件 并发送远程控制指令请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String sendBuoyJobParam(MultipartFile file, Long userId){
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);

            SysBuoyDto sysBuoyDto = new SysBuoyDto();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {
                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysBuoyDto.setCommunicationFrequencyJobParam(split0);
                    sysBuoyDto.setModulationTypeJobParam(split1);
                    sysBuoyDto.setGainJobParam(split2);
                }
                // 解析每一行文本的逻辑
            }
            scanner.close();
            String jsonString = JSON.toJSONString(sysBuoyDto);
            return setBuoyJobParam(jsonString, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 浮标导入工作状态文件
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public SysBuoyDto sendBuoyJobStatus(MultipartFile file, Long userId){
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);

            SysBuoyDto sysBuoyDto = new SysBuoyDto();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {

                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysBuoyDto.setCommunicationFrequencyJobStatus(split0);
                    sysBuoyDto.setModulationTypeJobStatus(split1);
                    sysBuoyDto.setCommunicationSystemJobStatus(split2);
                }
                // 解析每一行文本的逻辑
            }
            scanner.close();
            return sysBuoyDto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 保存浮标工作状态 工作参数 发送指令接收指令数据
     * @param buoyInfo
     * @param userId
     * @return
     */
    @Override
    public String saveBuoyInfo(String buoyInfo,Long userId){
        SysBuoy sysBuoy = sysBuoyMapper.selectSysBuoyById(userId);
        JSONObject jsonObject = JSONObject.parseObject(buoyInfo);
        String communicationFrequencyJobParam = jsonObject.get("communicationFrequencyJobParam")==null?null:(String)jsonObject.get("communicationFrequencyJobParam");
        String modulationTypeJobParam = jsonObject.get("modulationTypeJobParam")==null?null:(String)jsonObject.get("modulationTypeJobParam");
        String gainJobParam = jsonObject.get("gainJobParam")==null?null:(String)jsonObject.get("gainJobParam");
        String communicationFrequencyJobStatus = jsonObject.get("communicationFrequencyJobStatus")==null?null:(String)jsonObject.get("communicationFrequencyJobStatus");
        String modulationTypeJobStatus = jsonObject.get("modulationTypeJobStatus")==null?null:(String)jsonObject.get("modulationTypeJobStatus");
        String communicationSystemJobStatus = jsonObject.get("communicationSystemJobStatus")==null?null:(String)jsonObject.get("communicationSystemJobStatus");
        String sendControl = jsonObject.get("sendControl")==null?null:(String)jsonObject.get("sendControl");
        String receiverControl = jsonObject.get("receiverControl")==null?null:(String)jsonObject.get("receiverControl");
        sysBuoy.setCommunicationFrequencyJobStatus(communicationFrequencyJobStatus);
        sysBuoy.setModulationTypeJobStatus(modulationTypeJobStatus);
        sysBuoy.setCommunicationSystemJobStatus(communicationSystemJobStatus);
        sysBuoy.setCommunicationFrequencyJobParam(communicationFrequencyJobParam);
        sysBuoy.setModulationTypeJobParam(modulationTypeJobParam);
        sysBuoy.setGainJobParam(gainJobParam);
        sysBuoy.setSendControl(sendControl);
        sysBuoy.setReceiverControl(receiverControl);
        if(sysBuoy == null){
            sysBuoy.setId(userId);
            sysBuoyMapper.insertSysBuoy(sysBuoy);
        }else {
            sysBuoyMapper.updateSysBuoy(sysBuoy);
        }
        return JSON.toJSONString(sysBuoy);
    }


    /**
     * 保存水声通信机工作状态 工作参数 发送指令接收指令数据
     * @param buoyInfo
     * @param userId
     * @return
     */
    @Override
    public String saveBuoyMachineInfo(String buoyInfo,Long userId){
        SysBuoyMachine sysBuoyMachine = sysBuoyMachineMapper.selectSysBuoyMachineById(userId);
        JSONObject jsonObject = JSONObject.parseObject(buoyInfo);
        String port = jsonObject.get("port")==null?null:(String)jsonObject.get("port");
        String baudRate = jsonObject.get("baudRate")==null?null:(String)jsonObject.get("baudRate");
        String modulationTypeJobStatus = jsonObject.get("modulationTypeJobStatus")==null?null:(String)jsonObject.get("modulationTypeJobStatus");
        String sendGainJobStatus = jsonObject.get("sendGainJobStatus")==null?null:(String)jsonObject.get("sendGainJobStatus");
        String receiverGainJobStatus = jsonObject.get("receiverGainJobStatus")==null?null:(String)jsonObject.get("receiverGainJobStatus");
        String sendGainJobParam = jsonObject.get("sendGainJobParam")==null?null:(String)jsonObject.get("sendGainJobParam");
        String modulationTypeJobParam = jsonObject.get("modulationTypeJobParam")==null?null:(String)jsonObject.get("modulationTypeJobParam");
        String receiverGainJobParam = jsonObject.get("receiverGainJobParam")==null?null:(String)jsonObject.get("receiverGainJobParam");
        String sendControl = jsonObject.get("sendControl")==null?null:(String)jsonObject.get("sendControl");
        String receiverControl = jsonObject.get("receiverControl")==null?null:(String)jsonObject.get("receiverControl");
        sysBuoyMachine.setPort(port);
        sysBuoyMachine.setBaudRate(baudRate);
        sysBuoyMachine.setReceiverGainJobStatus(receiverGainJobStatus);
        sysBuoyMachine.setSendGainJobStatus(sendGainJobStatus);
        sysBuoyMachine.setModulationTypeJobStatus(modulationTypeJobStatus);
        sysBuoyMachine.setModulationTypeJobParam(modulationTypeJobParam);
        sysBuoyMachine.setSendGainJobParam(sendGainJobParam);
        sysBuoyMachine.setReceiverGainJobParam(receiverGainJobParam);
        sysBuoyMachine.setSendControl(sendControl);
        sysBuoyMachine.setReceiverControl(receiverControl);
        if(sysBuoyMachine == null){
            sysBuoyMachine.setId(userId);
            sysBuoyMachineMapper.insertSysBuoyMachine(sysBuoyMachine);
        }else {
            sysBuoyMachineMapper.updateSysBuoyMachine(sysBuoyMachine);
        }
        return JSON.toJSONString(sysBuoyMachine);
    }



    /**
     * 浮标导入工作参数文件 并发送远程控制指令请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String sendBuoyMachineJobParam(MultipartFile file, Long userId){
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);

            SysBuoyMachine sysBuoyMachine = new SysBuoyMachine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {
                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysBuoyMachine.setModulationTypeJobParam(split0);
                    sysBuoyMachine.setSendGainJobParam(split1);
                    sysBuoyMachine.setReceiverGainJobParam(split2);
                }
                // 解析每一行文本的逻辑
            }
            scanner.close();
            String jsonString = JSON.toJSONString(sysBuoyMachine);
            return setMachineJobParam(jsonString, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 浮标导入工作状态文件
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public SysBuoyMachine sendBuoyMachineJobStatus(MultipartFile file, Long userId){
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);

            SysBuoyMachine sysBuoyDto = new SysBuoyMachine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {

                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysBuoyDto.setModulationTypeJobStatus(split0);
                    sysBuoyDto.setSendGainJobStatus(split1);
                    sysBuoyDto.setReceiverGainJobStatus(split2);
                }
                // 解析每一行文本的逻辑
            }
            scanner.close();
            return sysBuoyDto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析浮標傳入文件  工作参数远程控制指令接收文件
     * @param file
     * @param userId
     * @return
     */
    @Override
    public String analyzeBuoyMachineJobParam(MultipartFile file, Long userId){
        Scanner scanner = null;
        SysBuoyMachine sysBuoyMachine = new SysBuoyMachine();
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            scanner = new Scanner(file1);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {
                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    String split1= splitStatus[1];
                    String split2= splitStatus[2];
                    sysBuoyMachine.setModulationTypeJobParam(split0);
                    sysBuoyMachine.setSendGainJobParam(split1);
                    sysBuoyMachine.setReceiverGainJobParam(split2);
                }
                // 解析每一行文本的逻辑
            }
            scanner.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String jsonString = JSON.toJSONString(sysBuoyMachine);
        return jsonString;
    }
}
