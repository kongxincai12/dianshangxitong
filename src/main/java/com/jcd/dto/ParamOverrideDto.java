package com.jcd.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.io.Serializable;
@Data()
public class ParamOverrideDto implements Serializable {
    private String id;
    private String eqpId;
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


}

