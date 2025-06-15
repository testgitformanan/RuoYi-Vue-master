package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysBuoyInformationMapper;
import com.ruoyi.system.domain.SysBuoyInformation;
import com.ruoyi.system.service.ISysBuoyInformationService;

/**
 * 浮标无线电感知业务Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
@Service
public class SysBuoyInformationServiceImpl implements ISysBuoyInformationService 
{
    @Autowired
    private SysBuoyInformationMapper sysBuoyInformationMapper;

    /**
     * 查询浮标无线电感知业务
     * 
     * @param id 浮标无线电感知业务主键
     * @return 浮标无线电感知业务
     */
    @Override
    public SysBuoyInformation selectSysBuoyInformationById(Long id)
    {
        return sysBuoyInformationMapper.selectSysBuoyInformationById(id);
    }

    /**
     * 查询浮标无线电感知业务列表
     * 
     * @param sysBuoyInformation 浮标无线电感知业务
     * @return 浮标无线电感知业务
     */
    @Override
    public List<SysBuoyInformation> selectSysBuoyInformationList(SysBuoyInformation sysBuoyInformation)
    {
        return sysBuoyInformationMapper.selectSysBuoyInformationList(sysBuoyInformation);
    }

    /**
     * 新增浮标无线电感知业务
     * 
     * @param sysBuoyInformation 浮标无线电感知业务
     * @return 结果
     */
    @Override
    public int insertSysBuoyInformation(SysBuoyInformation sysBuoyInformation)
    {
        sysBuoyInformation.setCreateTime(DateUtils.getNowDate());
        return sysBuoyInformationMapper.insertSysBuoyInformation(sysBuoyInformation);
    }

    /**
     * 修改浮标无线电感知业务
     * 
     * @param sysBuoyInformation 浮标无线电感知业务
     * @return 结果
     */
    @Override
    public int updateSysBuoyInformation(SysBuoyInformation sysBuoyInformation)
    {
        return sysBuoyInformationMapper.updateSysBuoyInformation(sysBuoyInformation);
    }

    /**
     * 批量删除浮标无线电感知业务
     * 
     * @param ids 需要删除的浮标无线电感知业务主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyInformationByIds(Long[] ids)
    {
        return sysBuoyInformationMapper.deleteSysBuoyInformationByIds(ids);
    }

    /**
     * 删除浮标无线电感知业务信息
     * 
     * @param id 浮标无线电感知业务主键
     * @return 结果
     */
    @Override
    public int deleteSysBuoyInformationById(Long id)
    {
        return sysBuoyInformationMapper.deleteSysBuoyInformationById(id);
    }
}
