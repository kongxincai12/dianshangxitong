package com.jcd.model;

public class Loadinglist {
    private String llid;

    private String llname;

    private String productname;

    private String linename;

    private String description;

    private String username;

    private String datetime;

    private String version;

    private String status;

    public String getLlid() {
        return llid;
    }

    public void setLlid(String llid) {
        this.llid = llid == null ? null : llid.trim();
    }

    public String getLlname() {
        return llname;
    }

    public void setLlname(String llname) {
        this.llname = llname == null ? null : llname.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename == null ? null : linename.trim();
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}