package com.jcd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 智能货架 StatusChanged 回调请求体
 * 对应接口文档 3.3 感应式灯条反馈
 * 由货架硬件系统主动调用
 */
public class ShelfStatusChangedRequest {

    /** 储位的唯一标识 - 对应 V_LOCATION_ALL.LOC_NAME */
    @JsonProperty("LocationId")
    private String locationId;

    /** 灯的颜色和状态: 0灭灯, 32红, 64绿, 96蓝, 128黄, 160品红, 192青 */
    @JsonProperty("LightColor")
    private Integer lightColor;

    /** 储位触发的状态: 0=从有到无(取走操作), 1=从无到有(放入操作) */
    @JsonProperty("State")
    private Integer state;

    /** 发生时间, 格式: "2022-08-19 10:30:00" */
    @JsonProperty("time")
    private String time;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Integer getLightColor() {
        return lightColor;
    }

    public void setLightColor(Integer lightColor) {
        this.lightColor = lightColor;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
