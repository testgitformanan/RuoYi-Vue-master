package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysBuoyMachineMapper;
import com.ruoyi.system.domain.SysBuoyMachine;
import com.ruoyi.system.service.ISysBuoyMachineService;

/**
 * 浮标水声通信机业务Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
@Service
public class SysBuoyMachineServiceImpl implements ISysBuoyMachineService 
{
    @Autowired
    private SysBuoyMachineMapper sysBuoyMachineMapper;

    /**
     * 查询浮标水声通信机业务
     * 
     * @param id 浮标水声通信机业务主键
     * @return 浮标水声通信机业务
     */
    @Override
    public SysBuoyMachine selectSysBuoyMachineById(Long id)
    {
        return sysBuoyMachineMapper.selectSysBuoyMachineById(id);
    }

    /**
     * 查询浮标水声通信机业务列表
     * 
     * @param sysBuoyMachine 浮标水声通信机业务
     * @return 浮标水声通信机业务
     */
    @Override
    public List<SysBuoyMachine> selectSysBuoyMachineList(SysBuoyMachine sysBuoyMachine)
    {
        return sysBuoyMachineMapper.selectSysBuoyMachineList(sysBuoyMachine);
    }

    /**
     * 新增浮标水声通信机业务
     * 
     * @param sysBuoyMachine 浮标水声通信机业务
     * @return 结果
     */
    @Override
    public int insertSysBuoyMachine(SysBuoyMachine sysBuoyMachine)
    {
        sysBuoyMachine.setCreateTime(DateUtils.getNowDate());
        return sysBuoyMachineMapper.insertSysBuoyMachine(sysBuoyMachine);
    }

    /**
     * 修改浮标水声通信机业务
     * 
     * @param sysBuoyMachine 浮标水声通信机业务
     * @return 结果
     */
    @Override
    public int updateSysBuoyMachine(SysBuoyMachine sysBuoyMachine)
    {
        return sysBuoyMachineMapper.updateSysBuoyMachine(sysBuoyMachine);
    }

    /**
     * 批量删除浮标水声通信机业务
     * 
     * @param ids 需要删除的浮标水声通信机业务主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyMachineByIds(Long[] ids)
    {
        return sysBuoyMachineMapper.deleteSysBuoyMachineByIds(ids);
    }

    /**
     * 删除浮标水声通信机业务信息
     * 
     * @param id 浮标水声通信机业务主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyMachineById(Long id)
    {
        return sysBuoyMachineMapper.deleteSysBuoyMachineById(id);
    }
}
