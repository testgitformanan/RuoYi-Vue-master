package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysBuoyInformation;

/**
 * 浮标无线电感知业务Service接口
 * 
 * @author ruoyi
 * @date 2025-06-17
 */
public interface ISysBuoyInformationService 
{
    /**
     * 查询浮标无线电感知业务
     * 
     * @param id 浮标无线电感知业务主键
     * @return 浮标无线电感知业务
     */
    public SysBuoyInformation selectSysBuoyInformationById(Long id);

    /**
     * 查询浮标无线电感知业务列表
     * 
     * @param sysBuoyInformation 浮标无线电感知业务
     * @return 浮标无线电感知业务集合
     */
    public List<SysBuoyInformation> selectSysBuoyInformationList(SysBuoyInformation sysBuoyInformation);

    /**
     * 新增浮标无线电感知业务
     * 
     * @param sysBuoyInformation 浮标无线电感知业务
     * @return 结果
     */
    public int insertSysBuoyInformation(SysBuoyInformation sysBuoyInformation);

    /**
     * 修改浮标无线电感知业务
     * 
     * @param sysBuoyInformation 浮标无线电感知业务
     * @return 结果
     */
    public int updateSysBuoyInformation(SysBuoyInformation sysBuoyInformation);

    /**
     * 批量删除浮标无线电感知业务
     * 
     * @param ids 需要删除的浮标无线电感知业务主键集合
     * @return 结果
     */
    public int deleteSysBuoyInformationByIds(Long[] ids);

    /**
     * 删除浮标无线电感知业务信息
     * 
     * @param id 浮标无线电感知业务主键
     * @return 结果
     */
    public int deleteSysBuoyInformationById(Long id);
}
