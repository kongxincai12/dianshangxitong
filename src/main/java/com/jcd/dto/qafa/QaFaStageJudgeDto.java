package com.jcd.dto.qafa;

import lombok.Data;

@Data
public class QaFaStageJudgeDto {
    private String stageCode;
    /** PASS / FAIL */
    private String judge;
    private String comment;
    private String problemDesc;
}
