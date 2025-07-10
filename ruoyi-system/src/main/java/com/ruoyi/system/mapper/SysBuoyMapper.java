package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysBuoy;

/**
 * 浮标Mapper接口
 * 
 * @author ruoyi
 * @date 2025-07-08
 */
public interface SysBuoyMapper 
{
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
     * 删除浮标
     * 
     * @param id 浮标主键
     * @return 结果
     */
    public int deleteSysBuoyById(Long id);

    /**
     * 批量删除浮标
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysBuoyByIds(Long[] ids);
}
