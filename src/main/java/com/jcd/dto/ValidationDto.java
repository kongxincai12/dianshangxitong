package com.jcd.dto;

import lombok.Data;

@Data
public class ValidationDto {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getRule() {
        return rule;
    }

    public void setRule(Object rule) {
        this.rule = rule;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    private String type;

    private Object rule; // 使用Object类型以支持数组(for range)和字符串(for equals)
    private String dataType;


}
