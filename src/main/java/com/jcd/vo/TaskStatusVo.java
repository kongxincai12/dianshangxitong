package com.jcd.vo;

public class TaskStatusVo {
    private String siteName;
    private String shift;
    private String status;

    // 默认构造函数
    public TaskStatusVo() {
    }

    // --- Getter 和 Setter 方法 ---

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}