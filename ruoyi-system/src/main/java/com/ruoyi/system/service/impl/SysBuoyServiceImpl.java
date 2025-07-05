package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.*;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.SysBuoy;
import com.ruoyi.system.domain.SysBuoyInformation;
import com.ruoyi.system.domain.SysBuoyMachine;
import com.ruoyi.system.domain.SysBuoyRadioSensing;
import com.ruoyi.system.domain.vo.MetaVo;
import com.ruoyi.system.domain.vo.RouterVo;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysBuoyService;
import com.ruoyi.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private SysBuoyMachineMapper sysBuoyMachineMapper;

    @Autowired
    private SysBuoyMapper sysBuoyMapper;

    @Autowired
    private SysBuoyInformationMapper sysBuoyInformationMapper;

    @Value("${remoting.cPath.fbgzcspz.ljqt}")
    private String fbtxljPath;
    @Value("${remoting.cPath.fbgzcspz.yckzzl}")
    private String fbyckzzlPath;
    @Value("${remoting.cPath.machine.txlj}")
    private String machinetxljPath;
    @Value("${remoting.cPath.machine.gzcspz}")
    private String machinegzcspzPath;
    @Value("${remoting.cPath.machine.xhypwj}")
    private String machinexhypwjPath;
    @Value("${remoting.cPath.xhsj.xhsjwjgs}")
    private String machinexhsjwjgsPath;
    @Autowired
    private SysBuoyRadioSensingMapper sysBuoyRadioSensingMapper;

    /**
     * 浮标启动/关闭连接
     * 
     * @param param 浮标信息
     * @return 菜单列表
     */
    @Override
    public String connectBuoy(String param, Long userId)
    {
        JSONObject jsonObject = JSONObject.parseObject(param);
        jsonObject.put("userId", userId);

        // 启动与关闭连接
        String apiUrl = fbtxljPath;
//        String apiUrl = "http://1095rm2tl0368.vicp.fun/fb/gzcspz/ljqt";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; ");
        headers.put("Authorization", "Bearer your_access_token");
        String postResponse = "";
        try {
            String jsonString = JSON.toJSONString(jsonObject);
            postResponse = sendPostRequest(apiUrl, headers, jsonString);
            saveBuoyInfo(param, userId,2L);
            System.out.println("POST Response: " + postResponse);
        } catch (Exception e) {
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

        // 启动与关闭连接
        String apiUrl = machinetxljPath;
//        String apiUrl = "http://1095rm2tl0368.vicp.fun/sstxj/txlj/ljqt";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        String postResponse = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(param);
            jsonObject.put("userId", userId);
            String jsonString = JSON.toJSONString(jsonObject);
            postResponse = sendPostRequest(apiUrl, headers, jsonString);
            saveBuoyMachineInfo(jsonString, userId,2L);
            System.out.println("POST Response: " + postResponse);

        } catch (Exception e) {
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
        String apiUrl = fbyckzzlPath;
//        String apiUrl = "http://1095rm2tl0368.vicp.fun/fb/gzcspz/yckzzl";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        try {
            JSONObject jsonObject = JSONObject.parseObject(param);
            jsonObject.put("userId", userId);
            String code = UUID.randomUUID().toString();
            jsonObject.put("code", code);
            String jsonString = JSON.toJSONString(jsonObject);
            String postResponse = sendPostRequest(apiUrl, headers, jsonString);
            saveBuoyInfo(jsonString, userId,1L);
            System.out.println("POST Response: " + postResponse);
            return postResponse;
//            return jsonString;
        } catch (Exception e) {
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
        String apiUrl = machinegzcspzPath;
//        String apiUrl = "http://1095rm2tl0368.vicp.fun/sstxj/gzcspz/yckzzl";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        try {
            JSONObject jsonObject = JSONObject.parseObject(communication);
            jsonObject.put("userId", userId);
            String code = UUID.randomUUID().toString();
            jsonObject.put("code", code);
            String jsonString = JSON.toJSONString(jsonObject);
            String postResponse = sendPostRequest(apiUrl, headers, jsonString);
            System.out.println("POST Response: " + postResponse);
            saveBuoyMachineInfo(jsonString, userId,1L);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("我来了connect");
        return null;
    }

    /**
     * 发送信号数据给c端
     *
     * @param param 浮标信息
     * @return 菜单列表
     */
    public String sendBuoyInformation(String param, Long userId)
    {
        // 启动与关闭连接
        String apiUrl = machinexhypwjPath;
//        String apiUrl = "http://1095rm2tl0368.vicp.fun/sstxj/xhypwj/xhypwjfs";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        String postResponse = "";
        try {
            postResponse = sendPostRequest(apiUrl, headers, param);
            System.out.println("POST Response: " + postResponse);
            SysBuoyInformation sysBuoyInformation = new SysBuoyInformation();
            JSONObject jsonObject = JSONObject.parseObject(param);
            String fileNumber = jsonObject.get("fileNumber")==null?null:(String)jsonObject.get("fileNumber");
            String code = jsonObject.get("code")==null?null:(String)jsonObject.get("code");
            String content = jsonObject.get("content")==null?null:(String)jsonObject.get("content");
            String informationFileName = jsonObject.get("informationFileName")==null?null:(String)jsonObject.get("informationFileName");
            sysBuoyInformation.setContent(content);
            sysBuoyInformation.setInformationFileName(informationFileName);
            sysBuoyInformation.setCreateBy(String.valueOf(userId));
            sysBuoyInformation.setCode(code);
            sysBuoyInformation.setFileNumber(String.valueOf(fileNumber));
            sysBuoyInformationMapper.insertSysBuoyInformation(sysBuoyInformation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postResponse;
    }

    /**
     * 浮标数据文件文件个数传递
     *
     * @param communication 浮标信息
     * @return 菜单列表
     */
    @Override
    public String connectBuoyInformationFileNumberForWeb(String communication, Long userId)
    {
        // 配置工作参数
        String apiUrl = machinexhsjwjgsPath;
//        String apiUrl = "http://1095rm2tl0368.vicp.fun/sstxj/gzcspz/yckzzl";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer your_access_token");
        try {
            String postResponse = sendPostRequest(apiUrl, headers, communication);
            System.out.println("POST Response: " + postResponse);
            JSONObject jsonObject = JSONObject.parseObject(communication);
            String fileNumber = jsonObject.get("fileNumber")==null?null:(String)jsonObject.get("fileNumber");
            String code = jsonObject.get("code")==null?null:(String)jsonObject.get("code");
            String content = jsonObject.get("content")==null?null:(String)jsonObject.get("content");
            String informationFileName = jsonObject.get("informationFileName")==null?null:(String)jsonObject.get("informationFileName");
            SysBuoyInformation sysBuoyInformation = new SysBuoyInformation();
            sysBuoyInformation.setContent(content);
            sysBuoyInformation.setInformationFileName(informationFileName);
            sysBuoyInformation.setCreateBy(String.valueOf(userId));
            sysBuoyInformation.setCode(code);
            sysBuoyInformation.setFileNumber(fileNumber);
            sysBuoyInformationMapper.insertSysBuoyInformation(sysBuoyInformation);
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
    public SysBuoy getBuoyInfo(SysCommunication communication, Long userId)
    {
        SysBuoy buoy = new SysBuoy();
        buoy.setId(userId);
        SysBuoyMachine buoyMachine = new SysBuoyMachine();
        List<SysBuoyMachine> sysBuoyMachines = sysBuoyMachineMapper.selectSysBuoyMachineList(buoyMachine);
        SysBuoy sysBuoy = sysBuoyMapper.selectSysBuoyById(buoy.getId());
        return sysBuoy;
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
        saveBuoyInfo(jsonString, userId,1L);
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
            saveBuoyInfo(jsonString, userId,1L);
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
            String jsonString = JSON.toJSONString(sysBuoyDto);
            saveBuoyInfo(jsonString, userId,0L);
            return sysBuoyDto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 浮标导入信号数据文件
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String analyzeBuoyInformation(MultipartFile file, Long userId,String fileName){
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);

            SysBuoyInformation sysBuoyInformation = new SysBuoyInformation();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sysBuoyInformation.setContent(line);
            }
            scanner.close();
            sysBuoyInformation.setInformationFileName(fileName);
            if(sysBuoyInformation.getContent()==null){
                sysBuoyInformation.setContent(file.getOriginalFilename());
            }
            String jsonString = JSON.toJSONString(sysBuoyInformation);
            sysBuoyInformationMapper.insertSysBuoyInformation(sysBuoyInformation);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 保存浮标工作状态 工作参数 发送指令接收指令数据
     * @param buoyInfo
     * @param userId
     * @param typeStatus  工作状态为0工作参数为1启动停止连接2
     * @return
     */
    @Override
    public String saveBuoyInfo(String buoyInfo,Long userId,Long typeStatus) {
        SysBuoy sysBuoy = new SysBuoy();
        JSONObject jsonObject = JSONObject.parseObject(buoyInfo);
        String uuidString = UUID.randomUUID().toString();
        String code = jsonObject.get("code")==null?uuidString:(String) jsonObject.get("code");
        if(userId==null){
            userId = jsonObject.get("userId")==null?null:(Long) jsonObject.get("userId");
        }
//        sysBuoy.setCreateBy(String.valueOf(userId));
        sysBuoy.setTypeStatus(typeStatus);
        sysBuoy.setCode(code);
        List<SysBuoy> sysBuoyList = sysBuoyMapper.selectSysBuoyList(sysBuoy);
        String communicationFrequencyJobParam = jsonObject.get("communicationFrequencyJobParam")==null?null:(String)jsonObject.get("communicationFrequencyJobParam");
        String modulationTypeJobParam = jsonObject.get("modulationTypeJobParam")==null?null:(String)jsonObject.get("modulationTypeJobParam");
        String gainJobParam = jsonObject.get("gainJobParam")==null?null:(String)jsonObject.get("gainJobParam");
        String communicationFrequencyJobStatus = jsonObject.get("communicationFrequencyJobStatus")==null?null:(String)jsonObject.get("communicationFrequencyJobStatus");
        String modulationTypeJobStatus = jsonObject.get("modulationTypeJobStatus")==null?null:(String)jsonObject.get("modulationTypeJobStatus");
        String communicationSystemJobStatus = jsonObject.get("communicationSystemJobStatus")==null?null:(String)jsonObject.get("communicationSystemJobStatus");
        String sendControl = jsonObject.get("sendControl")==null?null:(String)jsonObject.get("sendControl");
        String receiverControl = jsonObject.get("receiverControl")==null?null:(String)jsonObject.get("receiverControl");
        String buoyStartOrStop = jsonObject.get("buoyStartOrStop")==null?null:(String)jsonObject.get("buoyStartOrStop");
        String buoyStartOrStopStatusBack = jsonObject.get("buoyStartOrStopStatusBack")==null?null:(String)jsonObject.get("buoyStartOrStopStatusBack");
        String buoyStatus = jsonObject.get("buoyStatus")==null?null:(String)jsonObject.get("buoyStatus");
        sysBuoy.setCommunicationFrequencyJobStatus(communicationFrequencyJobStatus);
        sysBuoy.setModulationTypeJobStatus(modulationTypeJobStatus);
        sysBuoy.setCommunicationSystemJobStatus(communicationSystemJobStatus);
        sysBuoy.setCommunicationFrequencyJobParam(communicationFrequencyJobParam);
        sysBuoy.setModulationTypeJobParam(modulationTypeJobParam);
        sysBuoy.setGainJobParam(gainJobParam);
        sysBuoy.setSendControl(sendControl);
        sysBuoy.setReceiverControl(receiverControl);
        sysBuoy.setCreateBy(String.valueOf(userId));
        sysBuoy.setTypeStatus(typeStatus);
        sysBuoy.setCode(code);
        sysBuoy.setBuoyStartOrStop(buoyStartOrStop);
        sysBuoy.setBuoyStartOrStopStatusBack(buoyStartOrStopStatusBack);
        sysBuoy.setBuoyStatus(buoyStatus);
        if(sysBuoyList == null || sysBuoyList.isEmpty()){
//            sysBuoy.setId(userId);
            sysBuoyMapper.insertSysBuoy(sysBuoy);
        }else {
            SysBuoy sysBuoy1 = sysBuoyList.get(0);
            sysBuoy.setId(sysBuoy1.getId());
            sysBuoyMapper.updateSysBuoy(sysBuoy);
        }
        return JSON.toJSONString(sysBuoy);
    }


    /**
     * 保存水声通信机工作状态 工作参数 发送指令接收指令数据
     * @param buoyInfo
     * @param userId
     * @param typeStatus  工作状态为0工作参数为1启动停止连接2
     * @return
     */
    @Override
    public String saveBuoyMachineInfo(String buoyInfo,Long userId,Long typeStatus){
        SysBuoyMachine sysBuoyMachine = new SysBuoyMachine();
        JSONObject jsonObject = JSONObject.parseObject(buoyInfo);
        String uuidString = UUID.randomUUID().toString();
        String code = jsonObject.get("code")==null?uuidString:(String) jsonObject.get("code");
        if(userId==null){
            userId = jsonObject.get("userId")==null?null:(Long) jsonObject.get("userId");
        }
//        sysBuoyMachine.setCreateBy(String.valueOf(userId));
        sysBuoyMachine.setTypeStatus(typeStatus);
        sysBuoyMachine.setCode(code);
        List<SysBuoyMachine> selectSysBuoyMachineList = sysBuoyMachineMapper.selectSysBuoyMachineList(sysBuoyMachine);
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
        String machineStartOrStop = jsonObject.get("machineStartOrStop")==null?null:(String)jsonObject.get("machineStartOrStop");
        String machineStartOrStopStatusBack = jsonObject.get("machineStartOrStopStatusBack")==null?null:(String)jsonObject.get("machineStartOrStopStatusBack");
        String machineStatus = jsonObject.get("machineStatus")==null?null:(String)jsonObject.get("machineStatus");
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
        sysBuoyMachine.setCreateBy(String.valueOf(userId));

        sysBuoyMachine.setTypeStatus(typeStatus);
        sysBuoyMachine.setCode(code);
        sysBuoyMachine.setMachineStartOrStop(machineStartOrStop);
        sysBuoyMachine.setMachineStartOrStopStatusBack(machineStartOrStopStatusBack);
        sysBuoyMachine.setMachineStatus(machineStatus);
        if(selectSysBuoyMachineList == null || selectSysBuoyMachineList.isEmpty()){
//            sysBuoyMachine.setId(userId);
            sysBuoyMachineMapper.insertSysBuoyMachine(sysBuoyMachine);
        }else {
            SysBuoyMachine sysBuoyMachine1 = selectSysBuoyMachineList.get(0);
            sysBuoyMachine.setId(sysBuoyMachine1.getId());
            sysBuoyMachineMapper.updateSysBuoyMachine(sysBuoyMachine);
        }
        return JSON.toJSONString(sysBuoyMachine);
    }

    /**
     * 保存无线电感知数据
     * @param buoyInfo
     * @param userId
     * @return
     */
    @Override
    public String saveBuoyRadioSensing(String buoyInfo,Long userId){
        SysBuoyRadioSensing sysBuoyRadioSensing = sysBuoyRadioSensingMapper.selectSysBuoyRadioSensingById(userId);
        JSONObject jsonObject = JSONObject.parseObject(buoyInfo);
        String uuidString = UUID.randomUUID().toString();
        String code = jsonObject.get("code")==null?uuidString:(String) jsonObject.get("code");
        if(userId==null){
            userId = jsonObject.get("userId")==null?null:(Long) jsonObject.get("userId");
        }
//        sysBuoyRadioSensing.setCreateBy(String.valueOf(userId));
        String jobStatus = jsonObject.get("jobStatus")==null?null:(String)jsonObject.get("jobStatus");
        String communicationFrequency = jsonObject.get("communicationFrequency")==null?null:(String)jsonObject.get("communicationFrequency");
        String modulationType = jsonObject.get("modulationType")==null?null:(String)jsonObject.get("modulationType");
        String communicationSystem = jsonObject.get("communicationSystem")==null?null:(String)jsonObject.get("communicationSystem");
        String azimuthAngle = jsonObject.get("azimuthAngle")==null?null:(String)jsonObject.get("azimuthAngle");
        String pitchAngle = jsonObject.get("pitchAngle")==null?null:(String)jsonObject.get("pitchAngle");
        String typeStatus = jsonObject.get("typeStatus")==null?"0":(String)jsonObject.get("typeStatus");
        sysBuoyRadioSensing.setCode(code);
        sysBuoyRadioSensing.setAzimuthAngle(azimuthAngle);
        sysBuoyRadioSensing.setPitchAngle(pitchAngle);
        sysBuoyRadioSensing.setCommunicationSystem(communicationSystem);
        sysBuoyRadioSensing.setCommunicationFrequency(communicationFrequency);
        sysBuoyRadioSensing.setModulationType(modulationType);
        sysBuoyRadioSensing.setTypeStatus(Long.valueOf(typeStatus));
        sysBuoyRadioSensing.setJobStatus(jobStatus);

//        if(sysBuoyMachine == null){
//            sysBuoyMachine.setId(userId);
        sysBuoyRadioSensingMapper.insertSysBuoyRadioSensing(sysBuoyRadioSensing);
//        }else {
//            sysBuoyMachineMapper.updateSysBuoyMachine(sysBuoyMachine);
//        }
        return JSON.toJSONString(sysBuoyRadioSensing);
    }



    /**
     * 水声通信机导入工作参数文件 并发送远程控制指令请求
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
            saveBuoyMachineInfo(jsonString, userId,1L);
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
            String jsonString = JSON.toJSONString(sysBuoyDto);
            saveBuoyInfo(jsonString, userId,0L);
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
        sysBuoyMachineMapper.insertSysBuoyMachine(sysBuoyMachine);
        return jsonString;
    }

    /**
     * 浮标导入信号数据文件 并发送远程请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String uploadBuoyInformation(MultipartFile file, Long userId){
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            File file1 = File.createTempFile("temp", null);
            file.transferTo(file1);
            Scanner scanner = new Scanner(file1);
            SysBuoyInformation sysBuoyInformation = new SysBuoyInformation();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                for (String s : split) {
                    String[] splitStatus = s.split("&");
                    String split0= splitStatus[0];
                    sysBuoyInformation.setContent(split0);
                }
                // 解析每一行文本的逻辑
            }
            scanner.close();
            String jsonString = JSON.toJSONString(sysBuoyInformation);
            return sendBuoyInformation(jsonString, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 查询浮标
     *
     * @param id 浮标主键
     * @return 浮标
     */
    @Override
    public SysBuoy selectSysBuoyById(Long id)
    {
        return sysBuoyMapper.selectSysBuoyById(id);
    }

    /**
     * 查询浮标列表
     *
     * @param sysBuoy 浮标
     * @return 浮标
     */
    @Override
    public List<SysBuoy> selectSysBuoyList(SysBuoy sysBuoy)
    {
        return sysBuoyMapper.selectSysBuoyList(sysBuoy);
    }

    /**
     * 新增浮标
     *
     * @param sysBuoy 浮标
     * @return 结果
     */
    @Override
    public int insertSysBuoy(SysBuoy sysBuoy)
    {
        sysBuoy.setCreateTime(DateUtils.getNowDate());
        return sysBuoyMapper.insertSysBuoy(sysBuoy);
    }

    /**
     * 修改浮标
     *
     * @param sysBuoy 浮标
     * @return 结果
     */
    @Override
    public int updateSysBuoy(SysBuoy sysBuoy)
    {
        sysBuoy.setUpdateTime(DateUtils.getNowDate());
        return sysBuoyMapper.updateSysBuoy(sysBuoy);
    }

    /**
     * 批量删除浮标
     *
     * @param ids 需要删除的浮标主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyByIds(Long[] ids)
    {
        return sysBuoyMapper.deleteSysBuoyByIds(ids);
    }

    /**
     * 删除浮标信息
     *
     * @param id 浮标主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyById(Long id)
    {
        return sysBuoyMapper.deleteSysBuoyById(id);
    }
}
