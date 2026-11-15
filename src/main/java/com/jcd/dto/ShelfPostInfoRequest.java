package com.jcd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * 智能货架 PostInfo 请求体 - 调用货架系统亮灯接口
 * 对应接口文档 3.1
 */
public class ShelfPostInfoRequest {

    /** 自动熄灭时间(秒): 0=常亮, 1-10 */
    @JsonProperty("TwinkleTime")
    private Integer twinkleTime;

    /** 储位亮灯详情列表 */
    @JsonProperty("Details")
    private List<Detail> details;

    public Integer getTwinkleTime() {
        return twinkleTime;
    }

    public void setTwinkleTime(Integer twinkleTime) {
        this.twinkleTime = twinkleTime;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public static class Detail {
        @JsonProperty("LocationId")
        private String locationId;
        @JsonProperty("LightColor")
        private Integer lightColor;
        @JsonProperty("Twinkle")
        private Integer twinkle;
        @JsonProperty("IsLocked")
        private Integer isLocked;
        @JsonProperty("IsMustCollect")
        private Integer isMustCollect;
        @JsonProperty("Quantity")
        private Integer quantity;
        @JsonProperty("SubText")
        private String subText;
        @JsonProperty("BatchCode")
        private String batchCode;
        @JsonProperty("Name")
        private String name;
        @JsonProperty("R1")
        private String r1;
        @JsonProperty("R2")
        private String r2;
        @JsonProperty("R3")
        private String r3;
        @JsonProperty("SubTitle")
        private String subTitle;
        @JsonProperty("Title")
        private String title;
        @JsonProperty("Unit")
        private String unit;
        @JsonProperty("RelateToTower")
        private Boolean relateToTower;

        public String getLocationId() { return locationId; }
        public void setLocationId(String locationId) { this.locationId = locationId; }
        public Integer getLightColor() { return lightColor; }
        public void setLightColor(Integer lightColor) { this.lightColor = lightColor; }
        public Integer getTwinkle() { return twinkle; }
        public void setTwinkle(Integer twinkle) { this.twinkle = twinkle; }
        public Integer getIsLocked() { return isLocked; }
        public void setIsLocked(Integer isLocked) { this.isLocked = isLocked; }
        public Integer getIsMustCollect() { return isMustCollect; }
        public void setIsMustCollect(Integer isMustCollect) { this.isMustCollect = isMustCollect; }
        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
        public String getSubText() { return subText; }
        public void setSubText(String subText) { this.subText = subText; }
        public String getBatchCode() { return batchCode; }
        public void setBatchCode(String batchCode) { this.batchCode = batchCode; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getR1() { return r1; }
        public void setR1(String r1) { this.r1 = r1; }
        public String getR2() { return r2; }
        public void setR2(String r2) { this.r2 = r2; }
        public String getR3() { return r3; }
        public void setR3(String r3) { this.r3 = r3; }
        public String getSubTitle() { return subTitle; }
        public void setSubTitle(String subTitle) { this.subTitle = subTitle; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getUnit() { return unit; }
        public void setUnit(String unit) { this.unit = unit; }
        public Boolean getRelateToTower() { return relateToTower; }
        public void setRelateToTower(Boolean relateToTower) { this.relateToTower = relateToTower; }
    }
}
