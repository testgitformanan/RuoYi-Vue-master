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
     * typeStatus工作状态为0工作参数为1启动停止连接2
     */
    String saveBuoyInfo(String buoyInfo,Long userId,Long typeStatus);

    /**
     * 水声通信机相关信息存储
     * typeStatus工作状态为0工作参数为1启动停止连接2
     */
    String saveBuoyMachineInfo(String buoyInfo,Long userId,Long typeStatus);

    /**
     * 浮标无线电感知教学数据存储
     */
    String saveBuoyRadioSensing(String buoyInfo,Long userId);

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
     * 浮标数据文件文件个数传递
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String connectBuoyInformationFileNumberForWeb(String communication, Long userId);

    /**
     * 浮标获取
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public SysBuoy getBuoyInfo(SysCommunication communication, Long userId);


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
     * 解析浮标信号数据文件 并将相应内容写入实体
     * @param file
     * @param userId
     * @return
     */
    String analyzeBuoyInformation(MultipartFile file, Long userId,String fileName);



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

    /**
     * 水声通信机导入信号数据文件 并发送远程控制指令请求
     *
     * @param file 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    String uploadBuoyInformation(MultipartFile file, Long userId);


    /**
     * 查询浮标
     *
     * @param id 浮标主键
     * @return 浮标
     */
    public SysBuoy selectSysBuoyById(Long id);

    /**
     * 查询浮标列表
     *
     * @param sysBuoy 浮标
     * @return 浮标集合
     */
    public List<SysBuoy> selectSysBuoyList(SysBuoy sysBuoy);

    /**
     * 新增浮标
     *
     * @param sysBuoy 浮标
     * @return 结果
     */
    public int insertSysBuoy(SysBuoy sysBuoy);

    /**
     * 修改浮标
     *
     * @param sysBuoy 浮标
     * @return 结果
     */
    public int updateSysBuoy(SysBuoy sysBuoy);

    /**
     * 批量删除浮标
     *
     * @param ids 需要删除的浮标主键集合
     * @return 结果
     */
    public int deleteSysBuoyByIds(Long[] ids);

    /**
     * 删除浮标信息
     *
     * @param id 浮标主键
     * @return 结果
     */
    public int deleteSysBuoyById(Long id);
}
