package com.jcd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class EquipmentParametersDto {
    private String equipmentId;
    private String equipmentName;
    private String equipmentCode;

    @JsonProperty("isOnline") // 序列化为isOnline
    private boolean isOnline;

    public List<ParameterDto> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDto> parameters) {
        this.parameters = parameters;
    }



    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    private List<ParameterDto> parameters;

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}

