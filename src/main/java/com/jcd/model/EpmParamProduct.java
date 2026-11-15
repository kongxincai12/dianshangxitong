package com.jcd.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Date;

/**
 * 设备料号参数实体（对应 EPM_PARAM_PRODUCT 表）
 * 料号 + 设备 绑定的参数
 */
public class EpmParamProduct {
    private String id;
    private String eqpId;
    private String productCode;
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
    private String shiftBased;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id == null ? null : id.trim(); }

    public String getEqpId() { return eqpId; }
    public void setEqpId(String eqpId) { this.eqpId = eqpId == null ? null : eqpId.trim(); }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode == null ? null : productCode.trim(); }

    public String getParamKey() { return paramKey; }
    public void setParamKey(String paramKey) { this.paramKey = paramKey == null ? null : paramKey.trim(); }

    public String getParamName() { return paramName; }
    public void setParamName(String paramName) { this.paramName = paramName == null ? null : paramName.trim(); }

    public Integer getParamOrder() { return paramOrder; }
    public void setParamOrder(Integer paramOrder) { this.paramOrder = paramOrder; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit == null ? null : unit.trim(); }

    public String getStandardDisplay() { return standardDisplay; }
    public void setStandardDisplay(String standardDisplay) { this.standardDisplay = standardDisplay == null ? null : standardDisplay.trim(); }

    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType == null ? null : dataType.trim(); }

    public String getValidationType() { return validationType; }
    public void setValidationType(String validationType) { this.validationType = validationType == null ? null : validationType.trim(); }

    public JsonNode getValidationRule() { return validationRule; }
    public void setValidationRule(JsonNode validationRule) { this.validationRule = validationRule; }

    public String getEnableFlag() { return enableFlag; }
    public void setEnableFlag(String enableFlag) { this.enableFlag = enableFlag == null ? null : enableFlag.trim(); }

    public String getShiftBased() { return shiftBased; }
    public void setShiftBased(String shiftBased) { this.shiftBased = shiftBased == null ? null : shiftBased.trim(); }

    public String getCreateBy() { return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy == null ? null : createBy.trim(); }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy == null ? null : updateBy.trim(); }

    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
}
