package com.jcd.dto.materialcheck;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 异常日志查询 响应 DTO (用于列表中的单条记录)
 */
public class MismatchLogDto {

    private Long logId;
    private String scannedSupplierMaterial;
    private String scannedUpn;
    private String fetchedMaterialDescription;
    private String operatorUsername;

    /**
     * 指定JSON中日期时间的输出格式和时区
     * (请根据您的服务器和客户端时区配置调整 "GMT+8")
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date logTime;

    // Getters and Setters

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getScannedSupplierMaterial() {
        return scannedSupplierMaterial;
    }

    public void setScannedSupplierMaterial(String scannedSupplierMaterial) {
        this.scannedSupplierMaterial = scannedSupplierMaterial;
    }

    public String getScannedUpn() {
        return scannedUpn;
    }

    public void setScannedUpn(String scannedUpn) {
        this.scannedUpn = scannedUpn;
    }

    public String getFetchedMaterialDescription() {
        return fetchedMaterialDescription;
    }

    public void setFetchedMaterialDescription(String fetchedMaterialDescription) {
        this.fetchedMaterialDescription = fetchedMaterialDescription;
    }

    public String getOperatorUsername() {
        return operatorUsername;
    }

    public void setOperatorUsername(String operatorUsername) {
        this.operatorUsername = operatorUsername;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}

