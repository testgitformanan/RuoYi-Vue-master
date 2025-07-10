package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 浮标对象 sys_buoy
 * 
 * @author ruoyi
 * @date 2025-07-08
 */
public class SysBuoy extends BaseEntity
{
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

    /** 工作参数-发射增益 */
    @Excel(name = "工作参数-发射增益")
    private String gainJobParam;

    /** 发送指令 */
    @Excel(name = "发送指令")
    private String sendControl;

    /** 接收指令 */
    @Excel(name = "接收指令")
    private String receiverControl;

    /** 工作时长 持续工作/1小时/2小时0x00  持续工作  0x01 工作1小时   0x02工作两小时 */
    @Excel(name = "工作时长 持续工作/1小时/2小时0x00  持续工作  0x01 工作1小时   0x02工作两小时")
    private String workHours;

    /** 浮标类型 A型浮标/b型浮标0x00  A型浮标  0x01 B型浮标 */
    @Excel(name = "浮标类型 A型浮标/b型浮标0x00  A型浮标  0x01 B型浮标")
    private String buoyType;

    /** 通讯方式 0x00  超短波   0x01 公开体制   0x02 模拟铱星 */
    @Excel(name = "通讯方式 0x00  超短波   0x01 公开体制   0x02 模拟铱星")
    private String communicationMethod;

    /** 上行频率 */
    @Excel(name = "上行频率")
    private String upwardFrequency;

    /** 下行频率 */
    @Excel(name = "下行频率")
    private String downFrequency;

    /** 上行功率 */
    @Excel(name = "上行功率")
    private String upwardPower;

    /** 下行功率 */
    @Excel(name = "下行功率")
    private String downPower;

    /** 上行制式 */
    @Excel(name = "上行制式")
    private String upwardStandard;

    /** 下行制式 */
    @Excel(name = "下行制式")
    private String downStandard;

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

    public void setWorkHours(String workHours) 
    {
        this.workHours = workHours;
    }

    public String getWorkHours() 
    {
        return workHours;
    }

    public void setBuoyType(String buoyType) 
    {
        this.buoyType = buoyType;
    }

    public String getBuoyType() 
    {
        return buoyType;
    }

    public void setCommunicationMethod(String communicationMethod) 
    {
        this.communicationMethod = communicationMethod;
    }

    public String getCommunicationMethod() 
    {
        return communicationMethod;
    }

    public void setUpwardFrequency(String upwardFrequency) 
    {
        this.upwardFrequency = upwardFrequency;
    }

    public String getUpwardFrequency() 
    {
        return upwardFrequency;
    }

    public void setDownFrequency(String downFrequency) 
    {
        this.downFrequency = downFrequency;
    }

    public String getDownFrequency() 
    {
        return downFrequency;
    }

    public void setUpwardPower(String upwardPower) 
    {
        this.upwardPower = upwardPower;
    }

    public String getUpwardPower() 
    {
        return upwardPower;
    }

    public void setDownPower(String downPower) 
    {
        this.downPower = downPower;
    }

    public String getDownPower() 
    {
        return downPower;
    }

    public void setUpwardStandard(String upwardStandard) 
    {
        this.upwardStandard = upwardStandard;
    }

    public String getUpwardStandard() 
    {
        return upwardStandard;
    }

    public void setDownStandard(String downStandard) 
    {
        this.downStandard = downStandard;
    }

    public String getDownStandard() 
    {
        return downStandard;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
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
            .append("workHours", getWorkHours())
            .append("buoyType", getBuoyType())
            .append("communicationMethod", getCommunicationMethod())
            .append("upwardFrequency", getUpwardFrequency())
            .append("downFrequency", getDownFrequency())
            .append("upwardPower", getUpwardPower())
            .append("downPower", getDownPower())
            .append("upwardStandard", getUpwardStandard())
            .append("downStandard", getDownStandard())
            .append("jobStatusFileName", getJobStatusFileName())
            .append("jobParamSendControlFileName", getJobParamSendControlFileName())
            .append("jobParamReceiverControlFileName", getJobParamReceiverControlFileName())
            .append("typeStatus", getTypeStatus())
            .append("buoyStartOrStop", getBuoyStartOrStop())
            .append("buoyStartOrStopStatusBack", getBuoyStartOrStopStatusBack())
            .append("buoyStatus", getBuoyStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
