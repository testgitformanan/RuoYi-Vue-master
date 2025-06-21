package com.ruoyi.wxgz.mapper;

import com.ruoyi.wxgz.domain.WxgzGzztxs;

import java.util.List;

/**
 * 工作状态显示Mapper接口
 *
 * @author ruoyi
 * @date 2025-06-14
 */
public interface WxgzGzztxsMapper {
    /**
     * 查询工作状态显示
     *
     * @return 工作状态显示
     */
    public WxgzGzztxs selectWxgzGzztxsOrderByIdDesc();

    /**
     * 查询工作状态显示列表
     *
     * @param wxgzGzztxs 工作状态显示
     * @return 工作状态显示集合
     */
    public List<WxgzGzztxs> selectWxgzGzztxsList(WxgzGzztxs wxgzGzztxs);

    /**
     * 新增工作状态显示
     *
     * @param wxgzGzztxs 工作状态显示
     * @return 结果
     */
    public int insertWxgzGzztxs(WxgzGzztxs wxgzGzztxs);

    /**
     * 修改工作状态显示
     *
     * @param wxgzGzztxs 工作状态显示
     * @return 结果
     */
    public int updateWxgzGzztxs(WxgzGzztxs wxgzGzztxs);

    /**
     * 删除工作状态显示
     *
     * @param id 工作状态显示主键
     * @return 结果
     */
    public int deleteWxgzGzztxsById(Long id);

    /**
     * 批量删除工作状态显示
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWxgzGzztxsByIds(Long[] ids);
}
