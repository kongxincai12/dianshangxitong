package com.jcd.model.qafa;

import lombok.Data;

import java.util.Date;

/**
 * 首件检验记录主表
 * 表: QA_FA_RECORD
 */
@Data
public class QaFaRecord {
    private String id;
    private String recordNo;
    private String templateId;
    private String processCode;
    private String lotId;
    private String lotName;
    private String productPn;
    private String lineCode;
    private Integer sampleQty;
    private String sampleUnit;
    private Date sampleTime;
    private String status;
    private Integer currentRound;
    private String prodUserId;
    private String prodUserName;
    private Date prodSubmitTime;
    private String qcUserId;
    private String qcUserName;
    private Date qcReviewTime;
    private String finalJudge;
    private String problemDesc;
    private String rejectReason;
    private Date createTime;
    private Date updateTime;
    private String stageSummaryText;
    private String stageSummaryStatus;
    private String stageProgressText;
    /** 外观等放行阶段已通过，生产可继续作业。非数据库字段。 */
    private Boolean productionReleased;
}
