package com.jcd.model.qafa;

import lombok.Data;

import java.util.Date;

/**
 * 首件记录-检查项明细
 * 表: QA_FA_RECORD_ITEM
 */
@Data
public class QaFaRecordItem {
    private String id;
    private String recordId;
    private String templateItemId;
    private String sectionCode;
    private String itemCode;
    private String itemName;
    private Integer roundNo;
    private String prodValue;
    private String prodPass;
    private String prodUserId;
    private Date prodTime;
    private String qcValue;
    private String qcPass;
    private String qcUserId;
    private Date qcTime;
    private String remark;
}
