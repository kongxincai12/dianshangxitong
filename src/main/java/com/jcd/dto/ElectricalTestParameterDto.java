package com.jcd.dto;

public class ElectricalTestParameterDto {
    private String id;
    private String electrical_test_id;
    private String eqp_id;
    private String paramName;
    private String paramValue;
    private Integer displayOrder;
    private String isCustom;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getElectrical_test_id() {
        return electrical_test_id;
    }

    public void setElectrical_test_id(String electrical_test_id) {
        this.electrical_test_id = electrical_test_id;
    }

    public String getEqp_id() {
        return eqp_id;
    }

    public void setEqp_id(String eqp_id) {
        this.eqp_id = eqp_id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(String isCustom) {
        this.isCustom = isCustom;
    }
}
