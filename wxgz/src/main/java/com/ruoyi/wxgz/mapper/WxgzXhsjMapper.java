package com.ruoyi.wxgz.mapper;

import java.util.List;
import com.ruoyi.wxgz.domain.WxgzXhsj;

/**
 * 信号数据Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
public interface WxgzXhsjMapper 
{
    /**
     * 查询信号数据
     * 
     * @param id 信号数据主键
     * @return 信号数据
     */
    public WxgzXhsj selectWxgzXhsjById(Long id);

    /**
     * 查询信号数据列表
     * 
     * @param wxgzXhsj 信号数据
     * @return 信号数据集合
     */
    public List<WxgzXhsj> selectWxgzXhsjList(WxgzXhsj wxgzXhsj);

    /**
     * 新增信号数据
     * 
     * @param wxgzXhsj 信号数据
     * @return 结果
     */
    public int insertWxgzXhsj(WxgzXhsj wxgzXhsj);

    /**
     * 修改信号数据
     * 
     * @param wxgzXhsj 信号数据
     * @return 结果
     */
    public int updateWxgzXhsj(WxgzXhsj wxgzXhsj);

    /**
     * 删除信号数据
     * 
     * @param id 信号数据主键
     * @return 结果
     */
    public int deleteWxgzXhsjById(Long id);

    /**
     * 批量删除信号数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWxgzXhsjByIds(Long[] ids);
}
