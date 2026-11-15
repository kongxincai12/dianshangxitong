package com.jcd.model;

import java.util.Date;

public class Mlmappinginfo {
    private String mlmiid;

    private String pntype;

    private String partnumber;

    private String location;

    private String locationtype;

    private String description;

    private String username;

    private Date datetime;

    public String getMlmiid() {
        return mlmiid;
    }

    public void setMlmiid(String mlmiid) {
        this.mlmiid = mlmiid == null ? null : mlmiid.trim();
    }

    public String getPntype() {
        return pntype;
    }

    public void setPntype(String pntype) {
        this.pntype = pntype == null ? null : pntype.trim();
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber == null ? null : partnumber.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getLocationtype() {
        return locationtype;
    }

    public void setLocationtype(String locationtype) {
        this.locationtype = locationtype == null ? null : locationtype.trim();
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}