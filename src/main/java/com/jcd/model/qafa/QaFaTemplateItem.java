package com.jcd.model.qafa;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 首件检验模板检查项
 * 表: QA_FA_TEMPLATE_ITEM
 */
@Data
public class QaFaTemplateItem {
    private String id;
    private String templateId;
    private String sectionId;
    private String code;
    private String name;
    private String tool;
    private String standardText;
    private String inputType;
    private String unit;
    private String ruleJson;
    private String fillRole;
    private Integer required;
    private Integer critical;
    private Integer sortNo;
    private String remark;
    private BigDecimal standardMin;
    private BigDecimal standardMax;
    private Integer rangeCheckEnabled;
    private String rangeCheckMode;
}
