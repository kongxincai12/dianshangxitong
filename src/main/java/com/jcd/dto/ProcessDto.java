//定义返回给检验员的“工序”的数据结构。
package com.jcd.dto;

public class ProcessDto {
    private String name;
    private String site;
    private String description;

    // 构造函数
    public ProcessDto(String name, String site, String description) {
        this.name = name;
        this.site = site;
        this.description = description;
    }

    // --- Getter 和 Setter 方法 ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}