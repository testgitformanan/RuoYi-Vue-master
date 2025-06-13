package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysCommunication;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.vo.MetaVo;
import com.ruoyi.system.domain.vo.RouterVo;
import com.ruoyi.system.mapper.SysMenuMapper;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.mapper.SysRoleMenuMapper;
import com.ruoyi.system.service.ISysBuoyService;
import com.ruoyi.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

    @Autowired
    private SysMenuMapper menuMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

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
//            communication.setPort(port);
//            communication.setBaudRate(baudRate);
//            communication.setModulationTypeSet(modulationTypeSet);
//            communication.setSendGainSet(sendGainSet);
//            communication.setReceiverGainSet(receiverGainSet);
//            String jsonString = JSON.toJSONString(communication);
//            System.out.println(jsonString);
            String postResponse = sendPostRequest(apiUrl, headers, param);
//            String postResponse = sendPostRequest(apiUrl, headers, param);
            System.out.println("POST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("我来了connect");
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
//            communication.setPort(port);
//            communication.setBaudRate(baudRate);
//            communication.setModulationTypeSet(modulationTypeSet);
//            communication.setSendGainSet(sendGainSet);
//            communication.setReceiverGainSet(receiverGainSet);
//            String jsonString = JSON.toJSONString(communication);
//            System.out.println(jsonString);
            String postResponse = sendPostRequest(apiUrl, headers, communication);
//            String postResponse = sendPostRequest(apiUrl, headers, param);
            System.out.println("POST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("我来了connect");
        return null;
    }

    /**
     * 查询系统菜单列表
     *
     * @param communication 菜单信息
     * @return 菜单列表
     */
    @Override
    public List<SysMenu> getBuoyInfo(SysCommunication communication, Long userId)
    {

        System.out.println("我来了getBuoyInfo");
        System.out.println(userId);

        return null;
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

}
