package com.jcd.model;

public class V_location_all {
    private String locId;

    private String locName;

    private String locType;

    private String locStatus;

    private String warehouse;

    private String wharea;

    private String rack;

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId == null ? null : locId.trim();
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName == null ? null : locName.trim();
    }

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType == null ? null : locType.trim();
    }

    public String getLocStatus() {
        return locStatus;
    }

    public void setLocStatus(String locStatus) {
        this.locStatus = locStatus == null ? null : locStatus.trim();
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse == null ? null : warehouse.trim();
    }

    public String getWharea() {
        return wharea;
    }

    public void setWharea(String wharea) {
        this.wharea = wharea == null ? null : wharea.trim();
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack == null ? null : rack.trim();
    }
}