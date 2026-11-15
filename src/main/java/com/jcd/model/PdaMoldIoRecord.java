package com.jcd.model;

import lombok.Data;
import java.util.Date;

@Data
public class PdaMoldIoRecord {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 模具编码
     */
    private String facilityType;

    /**
     * 模具名称
     */
    private String moldName;

    /**
     * 储位编码
     */
    private String locationCode;

    /**
     * 出入库类型：IN 入库 / OUT 出库
     */
    private String ioType;

    /**
     * 工号
     */
    private String usernumber;

    /**
     * 姓名
     */
    private String username;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作人
     */
    private String operateUser;

    /**
     * 操作时间
     */
    private Date operateTime;
}
