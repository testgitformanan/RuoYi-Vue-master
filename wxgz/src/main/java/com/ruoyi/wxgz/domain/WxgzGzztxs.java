package com.ruoyi.wxgz.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 工作状态显示对象 wxgz_gzztxs
 *
 * @author ruoyi
 * @date 2025-06-14
 */
public class WxgzGzztxs extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 1无人机2温度传感器3信号强度4摄像头5湿度传感器6数据传输7雷达8压力传感器9系统自检
     */
    @Excel(name = "1无人机2温度传感器3信号强度4摄像头5湿度传感器6数据传输7雷达8压力传感器9系统自检")
    private Long type;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 日期yyyy-MM-dd HH:mm:ss
     */
    @Excel(name = "日期yyyy-MM-dd HH:mm:ss")
    private String date;

    /**
     * 经度
     */
    @Excel(name = "经度")
    private String lng;

    /**
     * 纬度
     */
    @Excel(name = "纬度")
    private String lat;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLng() {
        return lng;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLat() {
        return lat;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .append("status", getStatus())
                .append("date", getDate())
                .append("lng", getLng())
                .append("lat", getLat())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
