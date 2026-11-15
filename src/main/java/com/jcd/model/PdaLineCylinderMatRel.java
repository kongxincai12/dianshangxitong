package com.jcd.model;

import lombok.Data;

import java.util.Date;

@Data
public class PdaLineCylinderMatRel {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 线体缸体绑定关系ID
     */
    private Long lineCylinderRelId;

    /**
     * 物料PN
     */
    private String materialPn;

    /**
     * 物料名称
     */
    private String partname;

    /**
     * 物料规格
     */
    private String partspec;

    /**
     * 单位
     */
    private String unit;

    /**
     * 状态：ACTIVE有效，INACTIVE无效
     */
    private String status;

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
