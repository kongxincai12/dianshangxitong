package com.jcd.model;

import lombok.Data;

@Data
public class UsageRecordDto {
    private Integer Id;
    // 线体-缸体-物料绑定关系ID
    private Long lineCylinderMatRelId;
    private String usernumber;
    private String username;
    private String lineCode;
    private String cylinderCode;
    private String materialPn;
    private String usageAmount;
    private String usagePurpose;

    //白晚班
    private String remark;

    private String operateUser;
    private String operateTime;

}
