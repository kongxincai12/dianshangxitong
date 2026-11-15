package com.jcd.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField; // 导入这个类
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;

import java.util.Date;

@Data
public class EquipmentTypeParam {
    private String id;
    private String eqpTypeId;
    private String paramKey;
    private String paramName;
    private Integer paramOrder;
    private String unit;
    private String standardDisplay;
    private String dataType;
    private String validationType;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JsonNode validationRule;
    private String enableFlag;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;


}

