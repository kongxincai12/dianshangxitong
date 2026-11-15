package com.jcd.dto;

import java.io.Serializable;
import java.util.List;

public class ParamMaintenanceDto implements Serializable {
    private String paramSource; // "DEFAULT" 或 "OVERRIDE"
    private List<ParamOverrideDto> parameters;
    // Getters and Setters
    public String getParamSource() { return paramSource; }
    public void setParamSource(String paramSource) { this.paramSource = paramSource; }
    public List<ParamOverrideDto> getParameters() { return parameters; }
    public void setParameters(List<ParamOverrideDto> parameters) { this.parameters = parameters; }
}
