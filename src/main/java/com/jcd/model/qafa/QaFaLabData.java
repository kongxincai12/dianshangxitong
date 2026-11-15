package com.jcd.model.qafa;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 实验室数据主表 (一份Excel一行)
 * 表: QA_FA_LAB_DATA
 */
@Data
public class QaFaLabData {
    private String id;
    private String recordId;
    private String sourceType;
    private String smbFullPath;
    private String fileName;
    private String fileLotParsed;
    private String lotMatchResult;
    private String sampleName;
    private String measurer;
    private String machineName;
    private String judgeStdText;
    private BigDecimal judgeStdAuMin;
    private BigDecimal judgeStdAuMax;
    private BigDecimal judgeStdNiMin;
    private BigDecimal judgeStdNiMax;
    private String judgeResult;
    private Date testDate;
    private Date parsedTime;
    private String parsedBy;
    private String parseStatus;
    private String parseError;
    private String rawJson;
}
