package com.acsustc.acs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * CdrTableA实体类
 * @Author 陈桢秀
 * 2018-11-23 23:09:32
 */
@Entity
@Table(name="cdr_table_a")
public class CdrTableA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    String uuid;

    String callUuid;
    String callerIdName;
    String callerIdNumber;
    String destinationNumber;
    String startStamp;
    String answerStamp;
    String endStamp;
    String uduration;
    String billsec;
    String hangupCause;

    public CdrTableA(String callUuid, String callerIdName, String callerIdNumber, String destinationNumber) {
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
