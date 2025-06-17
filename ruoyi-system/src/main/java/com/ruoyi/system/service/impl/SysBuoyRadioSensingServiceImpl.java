package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysBuoyRadioSensingMapper;
import com.ruoyi.system.domain.SysBuoyRadioSensing;
import com.ruoyi.system.service.ISysBuoyRadioSensingService;

/**
 * 浮标无线电感知业务Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-17
 */
@Service
public class SysBuoyRadioSensingServiceImpl implements ISysBuoyRadioSensingService 
{
    @Autowired
    private SysBuoyRadioSensingMapper sysBuoyRadioSensingMapper;

    /**
     * 查询浮标无线电感知业务
     * 
     * @param id 浮标无线电感知业务主键
     * @return 浮标无线电感知业务
     */
    @Override
    public SysBuoyRadioSensing selectSysBuoyRadioSensingById(Long id)
    {
        return sysBuoyRadioSensingMapper.selectSysBuoyRadioSensingById(id);
    }

    /**
     * 查询浮标无线电感知业务列表
     * 
     * @param sysBuoyRadioSensing 浮标无线电感知业务
     * @return 浮标无线电感知业务
     */
    @Override
    public List<SysBuoyRadioSensing> selectSysBuoyRadioSensingList(SysBuoyRadioSensing sysBuoyRadioSensing)
    {
        return sysBuoyRadioSensingMapper.selectSysBuoyRadioSensingList(sysBuoyRadioSensing);
    }

    /**
     * 新增浮标无线电感知业务
     * 
     * @param sysBuoyRadioSensing 浮标无线电感知业务
     * @return 结果
     */
    @Override
    public int insertSysBuoyRadioSensing(SysBuoyRadioSensing sysBuoyRadioSensing)
    {
        sysBuoyRadioSensing.setCreateTime(DateUtils.getNowDate());
        return sysBuoyRadioSensingMapper.insertSysBuoyRadioSensing(sysBuoyRadioSensing);
    }

    /**
     * 修改浮标无线电感知业务
     * 
     * @param sysBuoyRadioSensing 浮标无线电感知业务
     * @return 结果
     */
    @Override
    public int updateSysBuoyRadioSensing(SysBuoyRadioSensing sysBuoyRadioSensing)
    {
        sysBuoyRadioSensing.setUpdateTime(DateUtils.getNowDate());
        return sysBuoyRadioSensingMapper.updateSysBuoyRadioSensing(sysBuoyRadioSensing);
    }

    /**
     * 批量删除浮标无线电感知业务
     * 
     * @param ids 需要删除的浮标无线电感知业务主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyRadioSensingByIds(Long[] ids)
    {
        return sysBuoyRadioSensingMapper.deleteSysBuoyRadioSensingByIds(ids);
    }

    /**
     * 删除浮标无线电感知业务信息
     * 
     * @param id 浮标无线电感知业务主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyRadioSensingById(Long id)
    {
        return sysBuoyRadioSensingMapper.deleteSysBuoyRadioSensingById(id);
    }
}
