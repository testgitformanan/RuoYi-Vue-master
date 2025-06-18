package com.ruoyi.wxgz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 信号数据对象 wxgz_xhsj
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
public class WxgzXhsj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 日期yyyy-MM-dd */
    @Excel(name = "日期yyyy-MM-dd")
    private String date;

    /** 频率 */
    @Excel(name = "频率")
    private String hz;

    /** 幅度 */
    @Excel(name = "幅度")
    private String db;

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

    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }

    public void setHz(String hz) 
    {
        this.hz = hz;
    }

    public String getHz() 
    {
        return hz;
    }

    public void setDb(String db) 
    {
        this.db = db;
    }

    public String getDb() 
    {
        return db;
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
            .append("date", getDate())
            .append("hz", getHz())
            .append("db", getDb())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
