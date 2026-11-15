package com.jcd.model;

import java.util.Date;

public class Mes_avi_alarm {
    private String id;

    private String eqpNo;

    private String alarmDescription;

    private Date alarmTime;

    private String operatorCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEqpNo() {
        return eqpNo;
    }

    public void setEqpNo(String eqpNo) {
        this.eqpNo = eqpNo == null ? null : eqpNo.trim();
    }

    public String getAlarmDescription() {
        return alarmDescription;
    }

    public void setAlarmDescription(String alarmDescription) {
        this.alarmDescription = alarmDescription == null ? null : alarmDescription.trim();
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? null : operatorCode.trim();
    }
}