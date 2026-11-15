package com.jcd.model;

import lombok.Data;

import java.util.Date;

@Data
public class EquipmentStationBinding {
    private Long id;
    private String eqpCode;
    private String eqpName;
    private String stationId;
    private String stationName;
    private String stationDesc;
    private String status;
    private String remark;
    private String operateUser;
    private Date operateTime;
}
