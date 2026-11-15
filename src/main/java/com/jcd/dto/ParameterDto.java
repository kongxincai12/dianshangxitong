package com.jcd.dto;

import lombok.Data;

@Data
public class ParameterDto {
    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getStandardDisplay() {
        return standardDisplay;
    }

    public void setStandardDisplay(String standardDisplay) {
        this.standardDisplay = standardDisplay;
    }

    public ValidationDto getValidation() {
        return validation;
    }

    public void setValidation(ValidationDto validation) {
        this.validation = validation;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String paramKey;
    private String paramName;
    private String standardDisplay;
    private ValidationDto validation;
    // 以下字段用于在线设备
    private String currentValue;
    private String unit;
    private String status;
}
