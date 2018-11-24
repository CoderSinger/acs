package com.acsustc.acs.entity;

import javax.persistence.*;

/**
 * @author wong
 * @date 2018/11/23
 */
@Entity
@Table(name="cdr_table_ab")
public class CdrTableAB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    private String uuid;
    private String callUuid;
    private String callerIdName;
    private String callerIdNumber;
    private String destinationNumber;
    private String startStamp;
    private String answerStamp;
    private String endStamp;
    private String uduration;
    private String billsec;
    private String hangupCause;
    public CdrTableAB(String callUuid, String callerIdName, String callerIdNumber, String destinationNumber) {
        this.callUuid = callUuid;
        this.callerIdName = callerIdName;
        this.callerIdNumber = callerIdNumber;
        this.destinationNumber = destinationNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCallUuid() {
        return callUuid;
    }

    public void setCallUuid(String callUuid) {
        this.callUuid = callUuid;
    }

    public String getCallerIdName() {
        return callerIdName;
    }

    public void setCallerIdName(String callerIdName) {
        this.callerIdName = callerIdName;
    }

    public String getCallerIdNumber() {
        return callerIdNumber;
    }

    public void setCallerIdNumber(String callerIdNumber) {
        this.callerIdNumber = callerIdNumber;
    }

    public String getDestinationNumber() {
        return destinationNumber;
    }

    public void setDestinationNumber(String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    public String getStartStamp() {
        return startStamp;
    }

    public void setStartStamp(String startStamp) {
        this.startStamp = startStamp;
    }

    public String getAnswerStamp() {
        return answerStamp;
    }

    public void setAnswerStamp(String answerStamp) {
        this.answerStamp = answerStamp;
    }

    public String getEndStamp() {
        return endStamp;
    }

    public void setEndStamp(String endStamp) {
        this.endStamp = endStamp;
    }

    public String getUduration() {
        return uduration;
    }

    public void setUduration(String uduration) {
        this.uduration = uduration;
    }

    public String getBillsec() {
        return billsec;
    }

    public void setBillsec(String billsec) {
        this.billsec = billsec;
    }

    public String getHangupCause() {
        return hangupCause;
    }

    public void setHangupCause(String hangupCause) {
        this.hangupCause = hangupCause;
    }
}
