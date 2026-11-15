package com.jcd.model.qafa;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 实验室数据明细 (动态列)
 * 表: QA_FA_LAB_DATA_ITEM
 */
@Data
public class QaFaLabDataItem {
    private String id;
    private String labDataId;
    private String columnName;
    private String unit;
    private BigDecimal avgVal;
    private BigDecimal stdVal;
    private BigDecimal cvVal;
    private BigDecimal rangeVal;
    private BigDecimal maxVal;
    private BigDecimal minVal;
    private Integer infiniteFlag;
    private String rawValuesJson;
    private Integer sortNo;
}
