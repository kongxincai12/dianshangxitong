package com.jcd.model.qafa;

import lombok.Data;

import java.util.Date;

/**
 * 首件状态流转审计流水
 * 表: QA_FA_AUDIT_LOG
 */
@Data
public class QaFaAuditLog {
    private String id;
    private String recordId;
    private String fromStatus;
    private String toStatus;
    private String action;
    private String operatorId;
    private String operatorName;
    private String commentText;
    private Date opTime;
}
