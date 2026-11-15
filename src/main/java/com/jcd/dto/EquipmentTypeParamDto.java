package com.jcd.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.io.Serializable;

@Data
public class EquipmentTypeParamDto {
    private static final long serialVersionUID = 1L;
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
    private JsonNode validationRule; // 使用JsonNode来接收/发送结构化的规则
    private String enableFlag;
    private String shiftBased; // "Y" or "N"，是否按班次自动回填
    private Validation validation;

    public Validation getValidation() { return validation; }
    public void setValidation(Validation validation) { this.validation = validation; }

    public static class Validation implements Serializable {
        private static final long serialVersionUID = 1L;
        private String dataType; // 'number' or 'text'
        private String type;     // 'range' or 'equals'
        private Object rule;     // 校验规则 (e.g., [80, 100] or "自动模式")

        // Getters and Setters
        public String getDataType() { return dataType; }
        public void setDataType(String dataType) { this.dataType = dataType; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public Object getRule() { return rule; }
        public void setRule(Object rule) { this.rule = rule; }
    }
}
