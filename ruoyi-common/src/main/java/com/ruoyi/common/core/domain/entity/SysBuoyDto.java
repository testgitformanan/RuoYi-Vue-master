package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.Map;

/**
 * 浮标实体
 */
public class SysBuoyDto  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 批次标识 */
    @Excel(name = "批次标识")
    private String code;

    /** 工作状态 */
    @Excel(name = "工作状态")
    private String jobStatus;

    /** 工作状态-通信频率 */
    @Excel(name = "工作状态-通信频率")
    private String communicationFrequencyJobStatus;

    /** 工作状态-调制方式 */
    @Excel(name = "工作状态-调制方式")
    private String modulationTypeJobStatus;

    /** 工作状态-通信体制 */
    @Excel(name = "工作状态-通信体制")
    private String communicationSystemJobStatus;

    /** 工作参数-通信频率 */
    @Excel(name = "工作参数-通信频率")
    private String communicationFrequencyJobParam;

    /** 工作参数-调制方式 */
    @Excel(name = "工作参数-调制方式")
    private String modulationTypeJobParam;

    /** 工作参数-通信体制 */
    @Excel(name = "工作参数-通信体制")
    private String gainJobParam;

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

    /** 工作状态为0工作参数为1启动停止连接2 */
    @Excel(name = "工作状态为0工作参数为1启动停止连接2")
    private Long typeStatus;

    /** 浮标启动关闭连接状态传递给c端 启动连接：1   停止连接：0  链接中：2 */
    @Excel(name = "浮标启动关闭连接状态传递给c端 启动连接：1   停止连接：0  链接中：2")
    private String buoyStartOrStop;

    /** 浮标启动关闭连接状态 已启动：1  未启动：0 */
    @Excel(name = "浮标启动关闭连接状态 已启动：1  未启动：0")
    private String buoyStartOrStopStatusBack;

    /** 浮标工作状态 运行中：1  待机中：0  */
    @Excel(name = "浮标工作状态 运行中：1  待机中：0 ")
    private String buoyStatus;

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

    public void setJobStatus(String jobStatus)
    {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus()
    {
        return jobStatus;
    }

    public void setCommunicationFrequencyJobStatus(String communicationFrequencyJobStatus)
    {
        this.communicationFrequencyJobStatus = communicationFrequencyJobStatus;
    }

    public String getCommunicationFrequencyJobStatus()
    {
        return communicationFrequencyJobStatus;
    }

    public void setModulationTypeJobStatus(String modulationTypeJobStatus)
    {
        this.modulationTypeJobStatus = modulationTypeJobStatus;
    }

    public String getModulationTypeJobStatus()
    {
        return modulationTypeJobStatus;
    }

    public void setCommunicationSystemJobStatus(String communicationSystemJobStatus)
    {
        this.communicationSystemJobStatus = communicationSystemJobStatus;
    }

    public String getCommunicationSystemJobStatus()
    {
        return communicationSystemJobStatus;
    }

    public void setCommunicationFrequencyJobParam(String communicationFrequencyJobParam)
    {
        this.communicationFrequencyJobParam = communicationFrequencyJobParam;
    }

    public String getCommunicationFrequencyJobParam()
    {
        return communicationFrequencyJobParam;
    }

    public void setModulationTypeJobParam(String modulationTypeJobParam)
    {
        this.modulationTypeJobParam = modulationTypeJobParam;
    }

    public String getModulationTypeJobParam()
    {
        return modulationTypeJobParam;
    }

    public void setGainJobParam(String gainJobParam)
    {
        this.gainJobParam = gainJobParam;
    }

    public String getGainJobParam()
    {
        return gainJobParam;
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

    public void setTypeStatus(Long typeStatus)
    {
        this.typeStatus = typeStatus;
    }

    public Long getTypeStatus()
    {
        return typeStatus;
    }

    public void setBuoyStartOrStop(String buoyStartOrStop)
    {
        this.buoyStartOrStop = buoyStartOrStop;
    }

    public String getBuoyStartOrStop()
    {
        return buoyStartOrStop;
    }

    public void setBuoyStartOrStopStatusBack(String buoyStartOrStopStatusBack)
    {
        this.buoyStartOrStopStatusBack = buoyStartOrStopStatusBack;
    }

    public String getBuoyStartOrStopStatusBack()
    {
        return buoyStartOrStopStatusBack;
    }

    public void setBuoyStatus(String buoyStatus)
    {
        this.buoyStatus = buoyStatus;
    }

    public String getBuoyStatus()
    {
        return buoyStatus;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("code", getCode())
                .append("jobStatus", getJobStatus())
                .append("communicationFrequencyJobStatus", getCommunicationFrequencyJobStatus())
                .append("modulationTypeJobStatus", getModulationTypeJobStatus())
                .append("communicationSystemJobStatus", getCommunicationSystemJobStatus())
                .append("communicationFrequencyJobParam", getCommunicationFrequencyJobParam())
                .append("modulationTypeJobParam", getModulationTypeJobParam())
                .append("gainJobParam", getGainJobParam())
                .append("sendControl", getSendControl())
                .append("receiverControl", getReceiverControl())
                .append("jobStatusFileName", getJobStatusFileName())
                .append("jobParamSendControlFileName", getJobParamSendControlFileName())
                .append("jobParamReceiverControlFileName", getJobParamReceiverControlFileName())
                .append("typeStatus", getTypeStatus())
                .append("buoyStartOrStop", getBuoyStartOrStop())
                .append("buoyStartOrStopStatusBack", getBuoyStartOrStopStatusBack())
                .append("buoyStatus", getBuoyStatus())
                .toString();
    }
}
