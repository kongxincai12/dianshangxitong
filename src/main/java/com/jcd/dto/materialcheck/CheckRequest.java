package com.jcd.dto.materialcheck;

public class CheckRequest {

    /**
     * 扫描的供应商物料
     */
    private String supplierMaterial;

    /**
     * 扫描的UPN
     */
    private String upn;

    /**
     * 操作员用户名
     */
    private String operator;

    // Getters and Setters

    public String getSupplierMaterial() {
        return supplierMaterial;
    }

    public void setSupplierMaterial(String supplierMaterial) {
        this.supplierMaterial = supplierMaterial;
    }

    public String getUpn() {
        return upn;
    }

    public void setUpn(String upn) {
        this.upn = upn;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}

