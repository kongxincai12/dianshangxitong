package com.jcd.dto.qafa;

import lombok.Data;

@Data
public class QaFaItemValueDto {
    /** QA_FA_TEMPLATE_ITEM.ID */
    private String templateItemId;
    /** 数值/文本/PASS/FAIL等 */
    private String value;
    /** PASS/FAIL/NA */
    private String pass;
    private String remark;
}
