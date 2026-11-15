package com.jcd.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PdaMaterialUsageRecord {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 线体缸体物料绑定关系ID
     */
    private Long lineCylinderMatRelId;

    /**
     * 用户工号
     */
    private String usernumber;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 线体编码
     */
    private String lineCode;

    /**
     * 缸体编码
     */
    private String cylinderCode;

    /**
     * 物料PN
     */
    private String materialPn;

    /**
     * 使用数量
     */
    private BigDecimal usageAmount;

    /**
     * 使用用途：ADD / MAINTAIN / OPEN
     */
    private String usagePurpose;

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
