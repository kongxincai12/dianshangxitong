package com.jcd.dto.qafa;

import lombok.Data;

@Data
public class QaFaTransitionDto {
    /** QC_APPROVE / QC_REJECT / QC_RETURN / VOID */
    private String action;
    /** QC_APPROVE 必填: QUALIFIED / UNQUALIFIED */
    private String finalJudge;
    private String comment;
    private String problemDesc;
}
