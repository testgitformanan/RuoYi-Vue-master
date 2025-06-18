package com.ruoyi.wxgz.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.wxgz.domain.WxgzGzcspz;
import com.ruoyi.wxgz.mapper.WxgzGzcspzMapper;
import com.ruoyi.wxgz.service.IWxgzGzcspzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 无线感知工作参数配置Service业务层处理
 *
 * @author ruoyi
 * @date 2025-06-14
 */
@Service
public class WxgzGzcspzServiceImpl implements IWxgzGzcspzService {
    @Autowired
    private WxgzGzcspzMapper wxgzGzcspzMapper;

    /**
     * 查询无线感知工作参数配置
     *
     * @param id 无线感知工作参数配置主键
     * @return 无线感知工作参数配置
     */
    @Override
    public WxgzGzcspz selectWxgzGzcspzById(Long id) {
        return wxgzGzcspzMapper.selectWxgzGzcspzById(id);
    }

    /**
     * 查询无线感知工作参数配置列表
     *
     * @param wxgzGzcspz 无线感知工作参数配置
     * @return 无线感知工作参数配置
     */
    @Override
    public List<WxgzGzcspz> selectWxgzGzcspzList(WxgzGzcspz wxgzGzcspz) {
        return wxgzGzcspzMapper.selectWxgzGzcspzList(wxgzGzcspz);
    }

    /**
     * 新增无线感知工作参数配置
     *
     * @param wxgzGzcspz 无线感知工作参数配置
     * @return 结果
     */
    @Override
    public int insertWxgzGzcspz(WxgzGzcspz wxgzGzcspz) {
        wxgzGzcspz.setDate(DateUtils.getTime());
        wxgzGzcspz.setCreateTime(DateUtils.getNowDate());
        return wxgzGzcspzMapper.insertWxgzGzcspz(wxgzGzcspz);
    }

    /**
     * 修改无线感知工作参数配置
     *
     * @param wxgzGzcspz 无线感知工作参数配置
     * @return 结果
     */
    @Override
    public int updateWxgzGzcspz(WxgzGzcspz wxgzGzcspz) {
        wxgzGzcspz.setUpdateTime(DateUtils.getNowDate());
        return wxgzGzcspzMapper.updateWxgzGzcspz(wxgzGzcspz);
    }

    /**
     * 批量删除无线感知工作参数配置
     *
     * @param ids 需要删除的无线感知工作参数配置主键
     * @return 结果
     */
    @Override
    public int deleteWxgzGzcspzByIds(Long[] ids) {
        return wxgzGzcspzMapper.deleteWxgzGzcspzByIds(ids);
    }

    /**
     * 删除无线感知工作参数配置信息
     *
     * @param id 无线感知工作参数配置主键
     * @return 结果
     */
    @Override
    public int deleteWxgzGzcspzById(Long id) {
        return wxgzGzcspzMapper.deleteWxgzGzcspzById(id);
    }
}
