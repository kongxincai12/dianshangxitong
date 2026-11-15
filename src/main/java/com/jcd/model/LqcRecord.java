package com.jcd.model;

import java.util.Date;

public class LqcRecord {
    private String id;

    private Date checkDate;

    private String shift;

    private String inspectorUsername;

    private String siteName;

    private String lotName;

    private String productPn;

    private Integer totalQty;

    private Integer sampleQty;

    private Integer totalDefectQty;

    private String recordStatus;

    private String shiftConfirmedBy;

    private Date shiftConfirmationDate;

    private String leaderConfirmedBy;

    private Date leaderConfirmationDate;

    private String attribute1;

    private String attribute2;

    private String createdBy;

    private Date creationDate;

    private String lastUpdatedBy;

    private Date lastUpdateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift == null ? null : shift.trim();
    }

    public String getInspectorUsername() {
        return inspectorUsername;
    }

    public void setInspectorUsername(String inspectorUsername) {
        this.inspectorUsername = inspectorUsername == null ? null : inspectorUsername.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName == null ? null : lotName.trim();
    }

    public String getProductPn() {
        return productPn;
    }

    public void setProductPn(String productPn) {
        this.productPn = productPn == null ? null : productPn.trim();
    }

    public Integer getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Integer totalQty) {
        this.totalQty = totalQty;
    }

    public Integer getSampleQty() {
        return sampleQty;
    }

    public void setSampleQty(Integer sampleQty) {
        this.sampleQty = sampleQty;
    }

    public Integer getTotalDefectQty() {
        return totalDefectQty;
    }

    public void setTotalDefectQty(Integer totalDefectQty) {
        this.totalDefectQty = totalDefectQty;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    public String getShiftConfirmedBy() {
        return shiftConfirmedBy;
    }

    public void setShiftConfirmedBy(String shiftConfirmedBy) {
        this.shiftConfirmedBy = shiftConfirmedBy == null ? null : shiftConfirmedBy.trim();
    }

    public Date getShiftConfirmationDate() {
        return shiftConfirmationDate;
    }

    public void setShiftConfirmationDate(Date shiftConfirmationDate) {
        this.shiftConfirmationDate = shiftConfirmationDate;
    }

    public String getLeaderConfirmedBy() {
        return leaderConfirmedBy;
    }

    public void setLeaderConfirmedBy(String leaderConfirmedBy) {
        this.leaderConfirmedBy = leaderConfirmedBy == null ? null : leaderConfirmedBy.trim();
    }

    public Date getLeaderConfirmationDate() {
        return leaderConfirmationDate;
    }

    public void setLeaderConfirmationDate(Date leaderConfirmationDate) {
        this.leaderConfirmationDate = leaderConfirmationDate;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }


}