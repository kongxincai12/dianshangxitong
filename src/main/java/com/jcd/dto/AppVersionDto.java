package com.jcd.dto;

public class AppVersionDto {
    private String version; // 最新版本号, 例如 "1.0.2"
    private String downloadUrl; // 新版本的下载地址
    private String notes; // 更新说明
    private boolean forceUpdate;
    // 构造函数
    public AppVersionDto(String version, String downloadUrl, String notes) {
        this.version = version;
        this.downloadUrl = downloadUrl;
        this.notes = notes;
    }

    public AppVersionDto() {

    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    // Getters and Setters
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}