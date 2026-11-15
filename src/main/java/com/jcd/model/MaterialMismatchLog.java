package com.jcd.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 物料扫描异常日志 实体类
 * 对应数据库表: MATERIAL_MISMATCH_LOG
 * * 备注:
 * 1. @Entity 和 @Table 注解用于JPA，如果您使用MyBatis-Plus，它们同样适用。
 * 2. @SequenceGenerator 用于配置Oracle的序列，确保主键自增。
 */
@Entity
@Table(name = "MATERIAL_MISMATCH_LOG")
public class MaterialMismatchLog {

    /**
     * 日志主键ID
     * 使用 SEQ_MISMATCH_LOG_ID 序列
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMismatchLogGenerator")
    @SequenceGenerator(
            name = "seqMismatchLogGenerator",
            sequenceName = "SEQ_MISMATCH_LOG_ID", // 对应 database_schema.sql 中创建的序列
            allocationSize = 1 // 每次从序列获取一个值
    )
    @Column(name = "LOG_ID")
    private Long logId;

    /**
     * 扫描的供应商物料信息
     */
    @Column(name = "SCANNED_SUPPLIER_MATERIAL")
    private String scannedSupplierMaterial;

    /**
     * 扫描的UPN码
     */
    @Column(name = "SCANNED_UPN")
    private String scannedUpn;

    /**
     * 根据UPN带出的物料描述
     */
    @Column(name = "FETCHED_MATERIAL_DESCRIPTION")
    private String fetchedMaterialDescription;

    /**
     * 操作员用户名
     */
    @Column(name = "OPERATOR_USERNAME")
    private String operatorUsername;

    /**
     * 日志记录时间
     * Oracle的DATE类型可以映射为java.util.Date
     */
    @Column(name = "LOG_TIME")
    @Temporal(TemporalType.TIMESTAMP) // 确保时间戳精度
    private Date logTime;

    // --- 构造函数 ---

    public MaterialMismatchLog() {
    }

    // --- Getters 和 Setters ---

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

    /**
     * JPA/Hibernate 回调函数，在持久化（插入）之前自动设置 logTime
     * 如果您的表定义了 DEFAULT SYSDATE 并且您依赖数据库设置时间，可以移除此方法
     * 但在Java层设置更具可移植性
     */
    @PrePersist
    protected void onCreate() {
        if (logTime == null) {
            logTime = new Date();
        }
    }
}
