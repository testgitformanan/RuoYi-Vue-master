package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 浮标无线电感知业务对象 sys_buoy_information
 * 
 * @author ruoyi
 * @date 2025-06-17
 */
public class SysBuoyInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 批次标识 */
    @Excel(name = "批次标识")
    private String code;

    /** 信号内容 */
    @Excel(name = "信号内容")
    private String content;

    /** 信号数据文件路径 */
    @Excel(name = "信号数据文件路径")
    private String informationFileName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setInformationFileName(String informationFileName) 
    {
        this.informationFileName = informationFileName;
    }

    public String getInformationFileName() 
    {
        return informationFileName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("content", getContent())
            .append("informationFileName", getInformationFileName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
