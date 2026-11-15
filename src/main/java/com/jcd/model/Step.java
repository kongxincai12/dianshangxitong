package com.jcd.model;

public class Step {
    private String stepid;

    private String stepname;

    private String description;

    private String steptype;

    private String resourcetype;

    private String resourceid;

    private String categoryid;

    private String sectionname;

    private String stepcategory;

    private String username;

    private String datetime;

    private String iconurl;

    private String edcplanid;

    private String boardside;

    private String obj1;

    private String obj2;

    private String iserpstep;

    private byte[] picture;

    public String getStepid() {
        return stepid;
    }

    public void setStepid(String stepid) {
        this.stepid = stepid == null ? null : stepid.trim();
    }

    public String getStepname() {
        return stepname;
    }

    public void setStepname(String stepname) {
        this.stepname = stepname == null ? null : stepname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSteptype() {
        return steptype;
    }

    public void setSteptype(String steptype) {
        this.steptype = steptype == null ? null : steptype.trim();
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype == null ? null : resourcetype.trim();
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname == null ? null : sectionname.trim();
    }

    public String getStepcategory() {
        return stepcategory;
    }

    public void setStepcategory(String stepcategory) {
        this.stepcategory = stepcategory == null ? null : stepcategory.trim();
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

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl == null ? null : iconurl.trim();
    }

    public String getEdcplanid() {
        return edcplanid;
    }

    public void setEdcplanid(String edcplanid) {
        this.edcplanid = edcplanid == null ? null : edcplanid.trim();
    }

    public String getBoardside() {
        return boardside;
    }

    public void setBoardside(String boardside) {
        this.boardside = boardside == null ? null : boardside.trim();
    }

    public String getObj1() {
        return obj1;
    }

    public void setObj1(String obj1) {
        this.obj1 = obj1 == null ? null : obj1.trim();
    }

    public String getObj2() {
        return obj2;
    }

    public void setObj2(String obj2) {
        this.obj2 = obj2 == null ? null : obj2.trim();
    }

    public String getIserpstep() {
        return iserpstep;
    }

    public void setIserpstep(String iserpstep) {
        this.iserpstep = iserpstep == null ? null : iserpstep.trim();
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}