package com.jcd.model.qafa;

import lombok.Data;

import java.util.Date;

/**
 * 首件检验模板主表
 * 表: QA_FA_TEMPLATE
 */
@Data
public class QaFaTemplate {
    private String id;
    private String processCode;
    private String processName;
    private String version;
    private String name;
    private String sopRef;
    private String status;
    private Date validFrom;
    private Date validTo;
    private String remark;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}
