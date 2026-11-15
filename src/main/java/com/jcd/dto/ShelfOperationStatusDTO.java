package com.jcd.dto;

/**
 * 智能货架 - 操作状态响应体 (前端轮询结果)
 */
public class ShelfOperationStatusDTO {

    /** 操作ID */
    private String operationId;

    /** 操作状态: PENDING=等待放入, DONE=完成, FAILED=失败, EXPIRED=超时 */
    private String status;

    /** 操作类型: INBOUND=入库, TRANSFER=移库 */
    private String operationType;

    /** UPN名称 */
    private String upnname;

    /** 实际绑定的储位编码(LOC_NAME) - StatusChanged回调后填入 */
    private String locationId;

    /** 货架编号 */
    private String rackCode;

    /** 结果消息 */
    private String message;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getUpnname() {
        return upnname;
    }

    public void setUpnname(String upnname) {
        this.upnname = upnname;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getRackCode() {
        return rackCode;
    }

    public void setRackCode(String rackCode) {
        this.rackCode = rackCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
