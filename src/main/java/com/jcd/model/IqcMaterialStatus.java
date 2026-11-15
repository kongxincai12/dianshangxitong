package com.jcd.model;

import java.util.Date;

public class IqcMaterialStatus {
    private String statusid;

    private String statusname;

    private String fifopriority;

    private String description;

    private String username;

    private Date datetime;

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid == null ? null : statusid.trim();
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname == null ? null : statusname.trim();
    }

    public String getFifopriority() {
        return fifopriority;
    }

    public void setFifopriority(String fifopriority) {
        this.fifopriority = fifopriority == null ? null : fifopriority.trim();
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