package com.jcd.model;

import lombok.Data;
// 注意：这里的字段名使用驼峰命名法，MyBatis会自动映射到下划线的数据库列名
@Data
public class Equipment {
    private String id;
    private String eqpCode;
    private String eqpName;
    private String assetsCode;
    private String eqpTypeId;
    private String enableFlag;
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEqpCode() {
        return eqpCode;
    }

    public void setEqpCode(String eqpCode) {
        this.eqpCode = eqpCode;
    }

    public String getEqpName() {
        return eqpName;
    }

    public void setEqpName(String eqpName) {
        this.eqpName = eqpName;
    }

    public String getAssetsCode() {
        return assetsCode;
    }

    public void setAssetsCode(String assetsCode) {
        this.assetsCode = assetsCode;
    }

    public String getEqpTypeId() {
        return eqpTypeId;
    }

    public void setEqpTypeId(String eqpTypeId) {
        this.eqpTypeId = eqpTypeId;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}



    // ... 其他字段根据需要添加
}
