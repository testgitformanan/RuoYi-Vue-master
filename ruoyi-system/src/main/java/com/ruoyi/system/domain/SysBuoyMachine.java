package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 浮标水声通信机业务对象 sys_buoy_machine
 * 
 * @author ruoyi
 * @date 2025-06-14
 */
public class SysBuoyMachine extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 端口 */
    @Excel(name = "端口")
    private String port;

    /** 波特率 */
    @Excel(name = "波特率")
    private String baudRate;

    /** 工作状态-发送增益 */
    @Excel(name = "工作状态-发送增益")
    private String sendGainJobStatus;

    /** 工作状态-调制方式 */
    @Excel(name = "工作状态-调制方式")
    private String modulationTypeJobStatus;

    /** 工作状态-接收增益 */
    @Excel(name = "工作状态-接收增益")
    private String receiverGainJobStatus;

    /** 工作参数-发送增益 */
    @Excel(name = "工作参数-发送增益")
    private String sendGainJobParam;

    /** 工作参数-调制方式 */
    @Excel(name = "工作参数-调制方式")
    private String modulationTypeJobParam;

    /** 工作参数-接收增益 */
    @Excel(name = "工作参数-接收增益")
    private String receiverGainJobParam;

    /** 发送指令 */
    @Excel(name = "发送指令")
    private String sendControl;

    /** 接收指令 */
    @Excel(name = "接收指令")
    private String receiverControl;

    /** 工作状态-文件名称 */
    @Excel(name = "工作状态-文件名称")
    private String jobStatusFileName;

    /** 工作参数-发送指令-文件名称 */
    @Excel(name = "工作参数-发送指令-文件名称")
    private String jobParamSendControlFileName;

    /** 工作参数-接收指令-文件名称 */
    @Excel(name = "工作参数-接收指令-文件名称")
    private String jobParamReceiverControlFileName;

    /** 水声通信机启动关闭连接状态 1启动0关闭 */
    @Excel(name = "水声通信机启动关闭连接状态 1启动0关闭")
    private String builStartStopFrame;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }

    public void setBaudRate(String baudRate) 
    {
        this.baudRate = baudRate;
    }

    public String getBaudRate() 
    {
        return baudRate;
    }

    public void setSendGainJobStatus(String sendGainJobStatus) 
    {
        this.sendGainJobStatus = sendGainJobStatus;
    }

    public String getSendGainJobStatus() 
    {
        return sendGainJobStatus;
    }

    public void setModulationTypeJobStatus(String modulationTypeJobStatus) 
    {
        this.modulationTypeJobStatus = modulationTypeJobStatus;
    }

    public String getModulationTypeJobStatus() 
    {
        return modulationTypeJobStatus;
    }

    public void setReceiverGainJobStatus(String receiverGainJobStatus) 
    {
        this.receiverGainJobStatus = receiverGainJobStatus;
    }

    public String getReceiverGainJobStatus() 
    {
        return receiverGainJobStatus;
    }

    public void setSendGainJobParam(String sendGainJobParam) 
    {
        this.sendGainJobParam = sendGainJobParam;
    }

    public String getSendGainJobParam() 
    {
        return sendGainJobParam;
    }

    public void setModulationTypeJobParam(String modulationTypeJobParam) 
    {
        this.modulationTypeJobParam = modulationTypeJobParam;
    }

    public String getModulationTypeJobParam() 
    {
        return modulationTypeJobParam;
    }

    public void setReceiverGainJobParam(String receiverGainJobParam) 
    {
        this.receiverGainJobParam = receiverGainJobParam;
    }

    public String getReceiverGainJobParam() 
    {
        return receiverGainJobParam;
    }

    public void setSendControl(String sendControl) 
    {
        this.sendControl = sendControl;
    }

    public String getSendControl() 
    {
        return sendControl;
    }

    public void setReceiverControl(String receiverControl) 
    {
        this.receiverControl = receiverControl;
    }

    public String getReceiverControl() 
    {
        return receiverControl;
    }

    public void setJobStatusFileName(String jobStatusFileName) 
    {
        this.jobStatusFileName = jobStatusFileName;
    }

    public String getJobStatusFileName() 
    {
        return jobStatusFileName;
    }

    public void setJobParamSendControlFileName(String jobParamSendControlFileName) 
    {
        this.jobParamSendControlFileName = jobParamSendControlFileName;
    }

    public String getJobParamSendControlFileName() 
    {
        return jobParamSendControlFileName;
    }

    public void setJobParamReceiverControlFileName(String jobParamReceiverControlFileName) 
    {
        this.jobParamReceiverControlFileName = jobParamReceiverControlFileName;
    }

    public String getJobParamReceiverControlFileName() 
    {
        return jobParamReceiverControlFileName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("port", getPort())
            .append("baudRate", getBaudRate())
            .append("sendGainJobStatus", getSendGainJobStatus())
            .append("modulationTypeJobStatus", getModulationTypeJobStatus())
            .append("receiverGainJobStatus", getReceiverGainJobStatus())
            .append("sendGainJobParam", getSendGainJobParam())
            .append("modulationTypeJobParam", getModulationTypeJobParam())
            .append("receiverGainJobParam", getReceiverGainJobParam())
            .append("sendControl", getSendControl())
            .append("receiverControl", getReceiverControl())
            .append("jobStatusFileName", getJobStatusFileName())
            .append("jobParamSendControlFileName", getJobParamSendControlFileName())
            .append("jobParamReceiverControlFileName", getJobParamReceiverControlFileName())
            .append("createTime", getCreateTime())
            .toString();
    }

    public String getBuilStartStopFrame() {
        return builStartStopFrame;
    }

    public void setBuilStartStopFrame(String builStartStopFrame) {
        this.builStartStopFrame = builStartStopFrame;
    }
}
