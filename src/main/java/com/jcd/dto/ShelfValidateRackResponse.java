package com.jcd.dto;

import java.util.List;

/**
 * 智能货架 - 校验货架响应体
 */
public class ShelfValidateRackResponse {

    /** 货架编号 */
    private String rackCode;

    /** 储位类型: 1=原料仓, 2=线边仓 */
    private String locationType;

    /** 仓库名称 */
    private String warehouse;

    /** 该货架下所有储位列表 */
    private List<LocationInfo> locations;

    /** 货架服务IP地址 */
    private String shelfIp;

    /** 货架服务端口 */
    private Integer shelfPort;

    public String getRackCode() {
        return rackCode;
    }

    public void setRackCode(String rackCode) {
        this.rackCode = rackCode;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public List<LocationInfo> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationInfo> locations) {
        this.locations = locations;
    }

    public String getShelfIp() {
        return shelfIp;
    }

    public void setShelfIp(String shelfIp) {
        this.shelfIp = shelfIp;
    }

    public Integer getShelfPort() {
        return shelfPort;
    }

    public void setShelfPort(Integer shelfPort) {
        this.shelfPort = shelfPort;
    }

    /**
     * 单个储位信息
     */
    public static class LocationInfo {
        /** 储位ID (LOC_ID) */
        private String locId;
        /** 储位编码 (LOC_NAME) - 即货架接口中的LocationId */
        private String locName;
        /** 储位状态 */
        private String locStatus;

        public LocationInfo() {
        }

        public LocationInfo(String locId, String locName, String locStatus) {
            this.locId = locId;
            this.locName = locName;
            this.locStatus = locStatus;
        }

        public String getLocId() {
            return locId;
        }

        public void setLocId(String locId) {
            this.locId = locId;
        }

        public String getLocName() {
            return locName;
        }

        public void setLocName(String locName) {
            this.locName = locName;
        }

        public String getLocStatus() {
            return locStatus;
        }

        public void setLocStatus(String locStatus) {
            this.locStatus = locStatus;
        }
    }
}
