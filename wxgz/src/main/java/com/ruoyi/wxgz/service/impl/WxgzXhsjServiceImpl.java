package com.ruoyi.wxgz.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.wxgz.domain.WxgzXhsj;
import com.ruoyi.wxgz.mapper.WxgzXhsjMapper;
import com.ruoyi.wxgz.service.IWxgzXhsjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 信号数据Service业务层处理
 *
 * @author ruoyi
 * @date 2025-06-14
 */
@Service
public class WxgzXhsjServiceImpl implements IWxgzXhsjService {
    @Autowired
    private WxgzXhsjMapper wxgzXhsjMapper;

    /**
     * 查询信号数据
     *
     * @param id 信号数据主键
     * @return 信号数据
     */
    @Override
    public WxgzXhsj selectWxgzXhsjById(Long id) {
        return wxgzXhsjMapper.selectWxgzXhsjById(id);
    }

    /**
     * 查询信号数据列表
     *
     * @param wxgzXhsj 信号数据
     * @return 信号数据
     */
    @Override
    public List<WxgzXhsj> selectWxgzXhsjList(WxgzXhsj wxgzXhsj) {
        return wxgzXhsjMapper.selectWxgzXhsjList(wxgzXhsj);
    }

    /**
     * 新增信号数据
     *
     * @param wxgzXhsj 信号数据
     * @return 结果
     */
    @Override
    public int insertWxgzXhsj(WxgzXhsj wxgzXhsj) {
        wxgzXhsj.setDate(DateUtils.getTime());
        wxgzXhsj.setCreateTime(DateUtils.getNowDate());
        return wxgzXhsjMapper.insertWxgzXhsj(wxgzXhsj);
    }

    /**
     * 修改信号数据
     *
     * @param wxgzXhsj 信号数据
     * @return 结果
     */
    @Override
    public int updateWxgzXhsj(WxgzXhsj wxgzXhsj) {
        wxgzXhsj.setUpdateTime(DateUtils.getNowDate());
        return wxgzXhsjMapper.updateWxgzXhsj(wxgzXhsj);
    }

    /**
     * 批量删除信号数据
     *
     * @param ids 需要删除的信号数据主键
     * @return 结果
     */
    @Override
    public int deleteWxgzXhsjByIds(Long[] ids) {
        return wxgzXhsjMapper.deleteWxgzXhsjByIds(ids);
    }

    /**
     * 删除信号数据信息
     *
     * @param id 信号数据主键
     * @return 结果
     */
    @Override
    public int deleteWxgzXhsjById(Long id) {
        return wxgzXhsjMapper.deleteWxgzXhsjById(id);
    }
}
