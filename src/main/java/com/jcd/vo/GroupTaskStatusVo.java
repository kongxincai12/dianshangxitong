package com.jcd.vo;

public class GroupTaskStatusVo {
    private String siteName;
    private String recordStatus;
    private Integer statusCount;

    // 默认构造函数
    public GroupTaskStatusVo() {
    }

    // 全参构造函数
    public GroupTaskStatusVo(String siteName, String recordStatus, Integer statusCount) {
        this.siteName = siteName;
        this.recordStatus = recordStatus;
        this.statusCount = statusCount;
    }

    // --- Getter 和 Setter 方法 ---

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getStatusCount() {
        return statusCount;
    }

    public void setStatusCount(Integer statusCount) {
        this.statusCount = statusCount;
    }
}