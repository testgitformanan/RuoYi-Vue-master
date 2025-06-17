package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysBuoyMachine;

/**
 * 浮标水声通信机业务Service接口
 * 
 * @author ruoyi
 * @date 2025-06-17
 */
public interface ISysBuoyMachineService 
{
    /**
     * 查询浮标水声通信机业务
     * 
     * @param id 浮标水声通信机业务主键
     * @return 浮标水声通信机业务
     */
    public SysBuoyMachine selectSysBuoyMachineById(Long id);

    /**
     * 查询浮标水声通信机业务列表
     * 
     * @param sysBuoyMachine 浮标水声通信机业务
     * @return 浮标水声通信机业务集合
     */
    public List<SysBuoyMachine> selectSysBuoyMachineList(SysBuoyMachine sysBuoyMachine);

    /**
     * 新增浮标水声通信机业务
     * 
     * @param sysBuoyMachine 浮标水声通信机业务
     * @return 结果
     */
    public int insertSysBuoyMachine(SysBuoyMachine sysBuoyMachine);

    /**
     * 修改浮标水声通信机业务
     * 
     * @param sysBuoyMachine 浮标水声通信机业务
     * @return 结果
     */
    public int updateSysBuoyMachine(SysBuoyMachine sysBuoyMachine);

    /**
     * 批量删除浮标水声通信机业务
     * 
     * @param ids 需要删除的浮标水声通信机业务主键集合
     * @return 结果
     */
    public int deleteSysBuoyMachineByIds(Long[] ids);

    /**
     * 删除浮标水声通信机业务信息
     * 
     * @param id 浮标水声通信机业务主键
     * @return 结果
     */
    public int deleteSysBuoyMachineById(Long id);
}
