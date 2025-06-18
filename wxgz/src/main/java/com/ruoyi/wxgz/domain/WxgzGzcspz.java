package com.ruoyi.wxgz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 无线感知工作参数配置对象 wxgz_gzcspz
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
public class WxgzGzcspz extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 频率 */
    @Excel(name = "频率")
    private String hz;

    /** 传输速度 */
    @Excel(name = "传输速度")
    private String speed;

    /** 飞行高度 */
    @Excel(name = "飞行高度")
    private String height;

    /** 飞行模式 */
    @Excel(name = "飞行模式")
    private String mode;

    /** 日期yyyy-MM-dd */
    @Excel(name = "日期yyyy-MM-dd")
    private String date;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setHz(String hz) 
    {
        this.hz = hz;
    }

    public String getHz() 
    {
        return hz;
    }

    public void setSpeed(String speed) 
    {
        this.speed = speed;
    }

    public String getSpeed() 
    {
        return speed;
    }

    public void setHeight(String height) 
    {
        this.height = height;
    }

    public String getHeight() 
    {
        return height;
    }

    public void setMode(String mode) 
    {
        this.mode = mode;
    }

    public String getMode() 
    {
        return mode;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("hz", getHz())
            .append("speed", getSpeed())
            .append("height", getHeight())
            .append("mode", getMode())
            .append("date", getDate())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
