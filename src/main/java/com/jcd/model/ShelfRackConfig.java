package com.jcd.model;

import java.util.Date;

/**
 * 智能货架配置表 SHELF_RACK_CONFIG
 * 存储料架(RACK)与货架服务IP的绑定关系
 */
public class ShelfRackConfig {

    /** 主键ID */
    private String configId;

    /** 料架编号 (对应V_LOCATION_ALL.RACK) */
    private String rackCode;

    /** 货架服务IP地址 */
    private String shelfIp;

    /** 货架服务端口 (默认9090) */
    private Integer shelfPort;

    /** 状态: ACTIVE=启用, INACTIVE=停用 */
    private String status;

    /** 备注 */
    private String remark;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    // ===================== Getters & Setters =====================

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId == null ? null : configId.trim();
    }

    public String getRackCode() {
        return rackCode;
    }

    public void setRackCode(String rackCode) {
        this.rackCode = rackCode == null ? null : rackCode.trim();
    }

    public String getShelfIp() {
        return shelfIp;
    }

    public void setShelfIp(String shelfIp) {
        this.shelfIp = shelfIp == null ? null : shelfIp.trim();
    }

    public Integer getShelfPort() {
        return shelfPort;
    }

    public void setShelfPort(Integer shelfPort) {
        this.shelfPort = shelfPort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取货架服务完整基础URL
     * 如: http://192.168.1.10:9090
     */
    public String getShelfBaseUrl() {
        int port = (shelfPort != null) ? shelfPort : 9090;
        return "http://" + shelfIp + ":" + port;
    }
}
