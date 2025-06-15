package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysBuoyDto;
import com.ruoyi.common.core.domain.entity.SysCommunication;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.system.domain.SysBuoy;
import com.ruoyi.system.domain.SysBuoyMachine;
import com.ruoyi.system.domain.vo.RouterVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * 菜单 业务层
 * 
 * @author ruoyi
 */
public interface ISysBuoyService
{
    /**
     * 浮标启动/关闭连接
     * 
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String connectBuoy(String communication, Long userId);



    /**
     * 浮标工作参数配置
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String setBuoyJobParam(String communication, Long userId);


    /**
     * 浮标相关信息存储
     */
    String saveBuoyInfo(String buoyInfo,Long userId);

    /**
     * 水声通信机相关信息存储
     */
    String saveBuoyMachineInfo(String buoyInfo,Long userId);

    /**
     * 水声通信机启动/关闭连接
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String connectBuoyMachine(String communication, Long userId);

    /**
     * 水声通信机工作参数配置
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String setMachineJobParam(String communication, Long userId);

    /**
     * 浮标获取
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysBuoy> getBuoyInfo(SysCommunication communication, Long userId);


    /**
     * 浮标导入工作参数文件 并发送远程控制指令请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String sendBuoyJobParam(MultipartFile file, Long userId);

    /**
     * 浮标导入工作状态文件 并发送远程控制指令请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public SysBuoyDto sendBuoyJobStatus(MultipartFile file, Long userId);
    /**
     * 解析浮标工作参数文件 并将相应内容写入实体
     * @param file
     * @param userId
     * @return
     */
    String analyzeBuoyJobParam(MultipartFile file, Long userId);



    /**
     * 水声通信机导入工作状态文件 并发送远程控制指令请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public SysBuoyMachine sendBuoyMachineJobStatus(MultipartFile file, Long userId);
    /**
     * 水声通信机导入工作参数文件 并发送远程控制指令请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String sendBuoyMachineJobParam(MultipartFile file, Long userId);

    /**
     * 解析水声通信机工作参数文件 并将相应内容写入实体
     * @param file
     * @param userId
     * @return
     */
    String analyzeBuoyMachineJobParam(MultipartFile file, Long userId);
}
