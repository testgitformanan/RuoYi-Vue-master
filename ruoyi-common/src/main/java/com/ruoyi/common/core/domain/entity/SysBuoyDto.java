package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.annotation.Excel;

import java.util.List;
import java.util.Map;

/**
 * 浮标实体
 */
public class SysBuoyDto {
    private Integer id;
    private List<Map> jobStatus;
    // 工作状态-通信频率
    private String communicationFrequencyJobStatus;
    // 工作状态-调制方式
    private String modulationTypeJobStatus;
    // 工作状态-通信体制
    private String communicationSystemJobStatus;

    // 工作参数-通信频率
    private String communicationFrequencyJobParam;
    // 工作参数-调制方式
    private String modulationTypeJobParam;
    // 工作参数-发送增益
    private String gainJobParam;
    /** 发送指令 */
    private String sendControl;

    /** 接收指令 */
    private String receiverControl;



    // 水声通信机
    private SysCommunication sysCommunication;

    /** 浮标启动关闭连接状态 1启动0关闭 */
    @Excel(name = "浮标启动关闭连接状态 1启动0关闭")
    private String builStartStopFrame;

    @Excel(name = "工作状态为0工作参数为1")
    private Integer typeStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Map> getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(List<Map> jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCommunicationFrequencyJobStatus() {
        return communicationFrequencyJobStatus;
    }

    public void setCommunicationFrequencyJobStatus(String communicationFrequencyJobStatus) {
        this.communicationFrequencyJobStatus = communicationFrequencyJobStatus;
    }

    public String getModulationTypeJobStatus() {
        return modulationTypeJobStatus;
    }

    public void setModulationTypeJobStatus(String modulationTypeJobStatus) {
        this.modulationTypeJobStatus = modulationTypeJobStatus;
    }

    public String getCommunicationSystemJobStatus() {
        return communicationSystemJobStatus;
    }

    public void setCommunicationSystemJobStatus(String communicationSystemJobStatus) {
        this.communicationSystemJobStatus = communicationSystemJobStatus;
    }

    public String getCommunicationFrequencyJobParam() {
        return communicationFrequencyJobParam;
    }

    public void setCommunicationFrequencyJobParam(String communicationFrequencyJobParam) {
        this.communicationFrequencyJobParam = communicationFrequencyJobParam;
    }

    public String getModulationTypeJobParam() {
        return modulationTypeJobParam;
    }

    public void setModulationTypeJobParam(String modulationTypeJobParam) {
        this.modulationTypeJobParam = modulationTypeJobParam;
    }

    public String getGainJobParam() {
        return gainJobParam;
    }

    public void setGainJobParam(String gainJobParam) {
        this.gainJobParam = gainJobParam;
    }

    public String getSendControl() {
        return sendControl;
    }

    public void setSendControl(String sendControl) {
        this.sendControl = sendControl;
    }

    public String getReceiverControl() {
        return receiverControl;
    }

    public void setReceiverControl(String receiverControl) {
        this.receiverControl = receiverControl;
    }

    public SysCommunication getSysCommunication() {
        return sysCommunication;
    }

    public void setSysCommunication(SysCommunication sysCommunication) {
        this.sysCommunication = sysCommunication;
    }
}
