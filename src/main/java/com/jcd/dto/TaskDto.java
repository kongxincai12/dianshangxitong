//定义返回给前端的单个“任务”的数据结构。
package com.jcd.dto;

import java.util.Map;

public class TaskDto {
    private String id;
    private String title;
    private String description;
    private String status;
    private String statusText;
    private Map<String, String> params;

    // 构造函数
    public TaskDto(String id, String title, String description, String status, String statusText, Map<String, String> params) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.statusText = statusText;
        this.params = params;
    }

    // --- Getter 和 Setter 方法 ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}