package com.jcd.model;

import lombok.Data;

import java.util.Date;

@Data
public class PdaLineUserRel {
    private String lineCode;
    private String usernumber;
    private String username;
    private String remark;
    private String operateUser;
    private Date operateTime;
}
