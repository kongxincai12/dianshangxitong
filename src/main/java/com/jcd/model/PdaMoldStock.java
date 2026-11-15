package com.jcd.model;

import lombok.Data;

import java.util.Date;

@Data
public class PdaMoldStock {

    /**
     * 模具编码
     */
    private String moldCode;

    /**
     * 模具名称
     */
    private String moldName;

    /**
     * 储位编码
     */
    private String locationCode;

    /**
     * 操作人
     */
    private String operateUser;

    /**
     * 操作时间
     */
    private Date operateTime;
}