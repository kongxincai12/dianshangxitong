package com.jcd.model.qafa;

import lombok.Data;

/**
 * 首件检验模板区块
 * 表: QA_FA_TEMPLATE_SECTION
 */
@Data
public class QaFaTemplateSection {
    private String id;
    private String templateId;
    private String code;
    private String name;
    private Integer sortNo;
    private String remark;
    private String stageCode;
    private String stageName;
    private Integer stageSortNo;
    private Integer stageEnabled;
    private Integer finalRequired;
    private Integer releaseOnPass;
}
