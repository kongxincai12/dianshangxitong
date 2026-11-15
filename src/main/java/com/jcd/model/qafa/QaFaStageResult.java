package com.jcd.model.qafa;

import lombok.Data;

import java.util.Date;

/**
 * 首件记录阶段判定结果
 * 表: QA_FA_STAGE_RESULT
 */
@Data
public class QaFaStageResult {
    private String id;
    private String recordId;
    private String stageCode;
    private String stageName;
    private Integer sortNo;
    private String status;
    private Integer finalRequired;
    private Integer releaseOnPass;
    private String judgeUserId;
    private String judgeUserName;
    private Date judgeTime;
    private String commentText;
    private Date createTime;
    private Date updateTime;
}
