package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.BaseEntity;


/**
 * 水声通信机
 * 
 * @author ruoyi
 */
public class SysCommunication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 端口 */
    private Integer port;

    /** 波特率 */
    private String baudRate ;

    /** 调制方式 */
    private String modulationType;

    /** 发送增益 */
    private String sendGain;

    /** 接收增益 */
    private String receiverGain;

    /** 调制方式设置 */
    private String modulationTypeSet;

    /** 发送增益设置 */
    private String sendGainSet;

    /** 接收增益设置 */
    private String receiverGainSet;

    /** 发送指令 */
    private String sendControl;

    /** 接收指令 */
    private String receiverControl;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(String baudRate) {
        this.baudRate = baudRate;
    }

    public String getModulationType() {
        return modulationType;
    }

    public void setModulationType(String modulationType) {
        this.modulationType = modulationType;
    }

    public String getSendGain() {
        return sendGain;
    }

    public void setSendGain(String sendGain) {
        this.sendGain = sendGain;
    }

    public String getReceiverGain() {
        return receiverGain;
    }

    public void setReceiverGain(String receiverGain) {
        this.receiverGain = receiverGain;
    }

    public String getModulationTypeSet() {
        return modulationTypeSet;
    }

    public void setModulationTypeSet(String modulationTypeSet) {
        this.modulationTypeSet = modulationTypeSet;
    }

    public String getSendGainSet() {
        return sendGainSet;
    }

    public void setSendGainSet(String sendGainSet) {
        this.sendGainSet = sendGainSet;
    }

    public String getReceiverGainSet() {
        return receiverGainSet;
    }

    public void setReceiverGainSet(String receiverGainSet) {
        this.receiverGainSet = receiverGainSet;
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

    @Override
    public String toString() {
        return "SysCommunication{" +
                "port=" + port +
                ", baudRate='" + baudRate + '\'' +
                ", modulationType='" + modulationType + '\'' +
                ", sendGain='" + sendGain + '\'' +
                ", receiverGain='" + receiverGain + '\'' +
                ", modulationTypeSet='" + modulationTypeSet + '\'' +
                ", sendGainSet='" + sendGainSet + '\'' +
                ", receiverGainSet='" + receiverGainSet + '\'' +
                ", sendControl='" + sendControl + '\'' +
                ", receiverControl='" + receiverControl + '\'' +
                '}';
    }
}
