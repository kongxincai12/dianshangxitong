package com.jcd.model;

import lombok.Data;

import java.util.Date;

@Data
public class Location {

    /** 储位ID */
    private String locationid;

    /** 货架/架位ID */
    private String rackid;

    /** 储位名称 */
    private String locationname;

    /** 状态 */
    private String status;

    /** 描述 */
    private String description;

    /** 操作用户 */
    private String username;

    /** 操作时间 */
    private Date datetime;
}
