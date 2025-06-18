package com.ruoyi.wxgz.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.wxgz.domain.WxgzGzztxs;
import com.ruoyi.wxgz.mapper.WxgzGzztxsMapper;
import com.ruoyi.wxgz.service.IWxgzGzztxsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工作状态显示Service业务层处理
 *
 * @author ruoyi
 * @date 2025-06-14
 */
@Service
public class WxgzGzztxsServiceImpl implements IWxgzGzztxsService {
    @Autowired
    private WxgzGzztxsMapper wxgzGzztxsMapper;

    /**
     * 查询工作状态显示
     *
     * @param id 工作状态显示主键
     * @return 工作状态显示
     */
    @Override
    public WxgzGzztxs selectWxgzGzztxsById(Long id) {
        return wxgzGzztxsMapper.selectWxgzGzztxsById(id);
    }

    /**
     * 查询工作状态显示列表
     *
     * @param wxgzGzztxs 工作状态显示
     * @return 工作状态显示
     */
    @Override
    public List<WxgzGzztxs> selectWxgzGzztxsList(WxgzGzztxs wxgzGzztxs) {
        return wxgzGzztxsMapper.selectWxgzGzztxsList(wxgzGzztxs);
    }

    /**
     * 新增工作状态显示
     *
     * @param wxgzGzztxs 工作状态显示
     * @return 结果
     */
    @Override
    public int insertWxgzGzztxs(WxgzGzztxs wxgzGzztxs) {
        wxgzGzztxs.setDate(DateUtils.getTime());
        wxgzGzztxs.setCreateTime(DateUtils.getNowDate());
        return wxgzGzztxsMapper.insertWxgzGzztxs(wxgzGzztxs);
    }

    /**
     * 修改工作状态显示
     *
     * @param wxgzGzztxs 工作状态显示
     * @return 结果
     */
    @Override
    public int updateWxgzGzztxs(WxgzGzztxs wxgzGzztxs) {
        wxgzGzztxs.setUpdateTime(DateUtils.getNowDate());
        return wxgzGzztxsMapper.updateWxgzGzztxs(wxgzGzztxs);
    }

    /**
     * 批量删除工作状态显示
     *
     * @param ids 需要删除的工作状态显示主键
     * @return 结果
     */
    @Override
    public int deleteWxgzGzztxsByIds(Long[] ids) {
        return wxgzGzztxsMapper.deleteWxgzGzztxsByIds(ids);
    }

    /**
     * 删除工作状态显示信息
     *
     * @param id 工作状态显示主键
     * @return 结果
     */
    @Override
    public int deleteWxgzGzztxsById(Long id) {
        return wxgzGzztxsMapper.deleteWxgzGzztxsById(id);
    }
}
