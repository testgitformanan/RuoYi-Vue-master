package com.ruoyi.wxgz.service;

import java.util.List;
import com.ruoyi.wxgz.domain.WxgzGzcspz;

/**
 * 无线感知工作参数配置Service接口
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
public interface IWxgzGzcspzService 
{
    /**
     * 查询无线感知工作参数配置
     * 
     * @param id 无线感知工作参数配置主键
     * @return 无线感知工作参数配置
     */
    public WxgzGzcspz selectWxgzGzcspzById(Long id);

    /**
     * 查询无线感知工作参数配置列表
     * 
     * @param wxgzGzcspz 无线感知工作参数配置
     * @return 无线感知工作参数配置集合
     */
    public List<WxgzGzcspz> selectWxgzGzcspzList(WxgzGzcspz wxgzGzcspz);

    /**
     * 新增无线感知工作参数配置
     * 
     * @param wxgzGzcspz 无线感知工作参数配置
     * @return 结果
     */
    public int insertWxgzGzcspz(WxgzGzcspz wxgzGzcspz);

    /**
     * 修改无线感知工作参数配置
     * 
     * @param wxgzGzcspz 无线感知工作参数配置
     * @return 结果
     */
    public int updateWxgzGzcspz(WxgzGzcspz wxgzGzcspz);

    /**
     * 批量删除无线感知工作参数配置
     * 
     * @param ids 需要删除的无线感知工作参数配置主键集合
     * @return 结果
     */
    public int deleteWxgzGzcspzByIds(Long[] ids);

    /**
     * 删除无线感知工作参数配置信息
     * 
     * @param id 无线感知工作参数配置主键
     * @return 结果
     */
    public int deleteWxgzGzcspzById(Long id);
}
