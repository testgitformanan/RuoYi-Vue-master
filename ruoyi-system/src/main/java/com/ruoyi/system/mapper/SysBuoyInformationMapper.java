package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysBuoyInformation;

/**
 * 浮标无线电感知业务Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-17
 */
public interface SysBuoyInformationMapper 
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
     * 删除浮标无线电感知业务
     * 
     * @param id 浮标无线电感知业务主键
     * @return 结果
     */
    public int deleteSysBuoyInformationById(Long id);

    /**
     * 批量删除浮标无线电感知业务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysBuoyInformationByIds(Long[] ids);
}
