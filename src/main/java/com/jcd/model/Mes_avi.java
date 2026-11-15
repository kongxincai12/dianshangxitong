package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Mes_avi {
    private String id;

    private String productnumber;

    private String qrcode;

    private String lot;

    private Date createtime;

    private String createtimestr;

    private String creater;

    private String status;

    private String segment1;

    private String segment2;

    private String segment3;

    private String segment4;

    private String segment5;

    private Short scanTotal;

    private BigDecimal goodCount;

    private BigDecimal defectiveCount;

    private Short passRate;

    private Date startTime;

    private Date endTime;

    private Short totalTime;

    private Short avgTimePerPiece;

    private BigDecimal sideAbDefectCount;

    private String deviceExceptionInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(String productnumber) {
        this.productnumber = productnumber == null ? null : productnumber.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot == null ? null : lot.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatetimestr() {
        return createtimestr;
    }

    public void setCreatetimestr(String createtimestr) {
        this.createtimestr = createtimestr == null ? null : createtimestr.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1 == null ? null : segment1.trim();
    }

    public String getSegment2() {
        return segment2;
    }

    public void setSegment2(String segment2) {
        this.segment2 = segment2 == null ? null : segment2.trim();
    }

    public String getSegment3() {
        return segment3;
    }

    public void setSegment3(String segment3) {
        this.segment3 = segment3 == null ? null : segment3.trim();
    }

    public String getSegment4() {
        return segment4;
    }

    public void setSegment4(String segment4) {
        this.segment4 = segment4 == null ? null : segment4.trim();
    }

    public String getSegment5() {
        return segment5;
    }

    public void setSegment5(String segment5) {
        this.segment5 = segment5 == null ? null : segment5.trim();
    }

    public Short getScanTotal() {
        return scanTotal;
    }

    public void setScanTotal(Short scanTotal) {
        this.scanTotal = scanTotal;
    }

    public BigDecimal getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(BigDecimal goodCount) {
        this.goodCount = goodCount;
    }

    public BigDecimal getDefectiveCount() {
        return defectiveCount;
    }

    public void setDefectiveCount(BigDecimal defectiveCount) {
        this.defectiveCount = defectiveCount;
    }

    public Short getPassRate() {
        return passRate;
    }

    public void setPassRate(Short passRate) {
        this.passRate = passRate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Short totalTime) {
        this.totalTime = totalTime;
    }

    public Short getAvgTimePerPiece() {
        return avgTimePerPiece;
    }

    public void setAvgTimePerPiece(Short avgTimePerPiece) {
        this.avgTimePerPiece = avgTimePerPiece;
    }

    public BigDecimal getSideAbDefectCount() {
        return sideAbDefectCount;
    }

    public void setSideAbDefectCount(BigDecimal sideAbDefectCount) {
        this.sideAbDefectCount = sideAbDefectCount;
    }

    public String getDeviceExceptionInfo() {
        return deviceExceptionInfo;
    }

    public void setDeviceExceptionInfo(String deviceExceptionInfo) {
        this.deviceExceptionInfo = deviceExceptionInfo == null ? null : deviceExceptionInfo.trim();
    }
}