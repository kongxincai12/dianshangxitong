package com.jcd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 对应 IQC_SCAN_LOGS 表的实体类
 */
public class IqcScanLog implements Serializable {
    private Long id;
    private String invoiceDetailId;
    private String upn;          // 唯一序列号
    private String poNumber;
    private String partNumber;
    private BigDecimal scanQty;
    private String vendorLot;
    private String dateCode;
    private String scanBy;       // 扫描人
    private Date scanTime;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInvoiceDetailId() { return invoiceDetailId; }
    public void setInvoiceDetailId(String invoiceDetailId) { this.invoiceDetailId = invoiceDetailId; }

    public String getUpn() { return upn; }
    public void setUpn(String upn) { this.upn = upn; }

    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }

    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }

    public BigDecimal getScanQty() { return scanQty; }
    public void setScanQty(BigDecimal scanQty) { this.scanQty = scanQty; }

    public String getVendorLot() { return vendorLot; }
    public void setVendorLot(String vendorLot) { this.vendorLot = vendorLot; }

    public String getDateCode() { return dateCode; }
    public void setDateCode(String dateCode) { this.dateCode = dateCode; }

    public String getScanBy() { return scanBy; }
    public void setScanBy(String scanBy) { this.scanBy = scanBy; }

    public Date getScanTime() { return scanTime; }
    public void setScanTime(Date scanTime) { this.scanTime = scanTime; }
}