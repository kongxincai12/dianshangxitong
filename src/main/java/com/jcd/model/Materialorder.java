package com.jcd.model;

public class Materialorder {
    private String moid;

    private String moname;

    private String lineid;

    private String lotid;

    private String status;

    private String isusing;

    private String boardside;

    private String leadfree;

    private String llid;

    private String description;

    private String username;

    private String datetime;

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
    }

    public String getMoname() {
        return moname;
    }

    public void setMoname(String moname) {
        this.moname = moname == null ? null : moname.trim();
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid == null ? null : lineid.trim();
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid == null ? null : lotid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsusing() {
        return isusing;
    }

    public void setIsusing(String isusing) {
        this.isusing = isusing == null ? null : isusing.trim();
    }

    public String getBoardside() {
        return boardside;
    }

    public void setBoardside(String boardside) {
        this.boardside = boardside == null ? null : boardside.trim();
    }

    public String getLeadfree() {
        return leadfree;
    }

    public void setLeadfree(String leadfree) {
        this.leadfree = leadfree == null ? null : leadfree.trim();
    }

    public String getLlid() {
        return llid;
    }

    public void setLlid(String llid) {
        this.llid = llid == null ? null : llid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime == null ? null : datetime.trim();
    }
}