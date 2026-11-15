package com.jcd.dto;

import java.io.Serializable;
import java.util.List;

public class GetEquipmentParametersResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String equipmentId;
    private String equipmentCode;
    private String equipmentName;
    private Boolean isOnline;
    private String paramSource; // 参数来源: DEFAULT 或 OVERRIDE
    private List<EquipmentTypeParamDto> parameters;

    // Getters and Setters
    public String getEquipmentId() { return equipmentId; }
    public void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }
    public String getEquipmentCode() { return equipmentCode; }
    public void setEquipmentCode(String equipmentCode) { this.equipmentCode = equipmentCode; }
    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }
    public Boolean getIsOnline() { return isOnline; }
    public void setIsOnline(Boolean isOnline) { this.isOnline = isOnline; }
    public String getParamSource() { return paramSource; }
    public void setParamSource(String paramSource) { this.paramSource = paramSource; }
    public List<EquipmentTypeParamDto> getParameters() { return parameters; }
    public void setParameters(List<EquipmentTypeParamDto> parameters) { this.parameters = parameters; }
}