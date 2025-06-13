package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysCommunication;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.system.domain.vo.RouterVo;

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
     * 水声通信机启动/关闭连接
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String connectBuoyMachine(String communication, Long userId);

    /**
     * 浮标工作参数配置
     *
     * @param communication 浮标信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    public String setBuoyJobParam(String communication, Long userId);

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
    public List<SysMenu> getBuoyInfo(SysCommunication communication, Long userId);

}
