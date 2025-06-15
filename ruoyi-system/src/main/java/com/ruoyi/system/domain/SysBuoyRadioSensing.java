package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 浮标无线电感知业务对象 sys_buoy_radio_sensing
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
public class SysBuoyRadioSensing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 工作状态 */
    @Excel(name = "工作状态")
    private String jobStatus;

    /** 通信频率 */
    @Excel(name = "通信频率")
    private String communicationFrequency;

    /** 调制方式 */
    @Excel(name = "调制方式")
    private String modulationType;

    /** 通信体制 */
    @Excel(name = "通信体制")
    private String communicationSystem;

    /** 方位角 */
    @Excel(name = "方位角")
    private String azimuthAngle;

    /** 俯仰角 */
    @Excel(name = "俯仰角")
    private String pitchAngle;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setJobStatus(String jobStatus) 
    {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() 
    {
        return jobStatus;
    }

    public void setCommunicationFrequency(String communicationFrequency) 
    {
        this.communicationFrequency = communicationFrequency;
    }

    public String getCommunicationFrequency() 
    {
        return communicationFrequency;
    }

    public void setModulationType(String modulationType) 
    {
        this.modulationType = modulationType;
    }

    public String getModulationType() 
    {
        return modulationType;
    }

    public void setCommunicationSystem(String communicationSystem) 
    {
        this.communicationSystem = communicationSystem;
    }

    public String getCommunicationSystem() 
    {
        return communicationSystem;
    }

    public void setAzimuthAngle(String azimuthAngle) 
    {
        this.azimuthAngle = azimuthAngle;
    }

    public String getAzimuthAngle() 
    {
        return azimuthAngle;
    }

    public void setPitchAngle(String pitchAngle) 
    {
        this.pitchAngle = pitchAngle;
    }

    public String getPitchAngle() 
    {
        return pitchAngle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jobStatus", getJobStatus())
            .append("communicationFrequency", getCommunicationFrequency())
            .append("modulationType", getModulationType())
            .append("communicationSystem", getCommunicationSystem())
            .append("azimuthAngle", getAzimuthAngle())
            .append("pitchAngle", getPitchAngle())
            .append("createTime", getCreateTime())
            .toString();
    }
}
