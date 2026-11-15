package com.jcd.dto;

import lombok.Data;
import java.util.List;

@Data
public class ManualProductionAddDto {
    // 此 DTO 与 EquipmentProductionAddDto 类似，但不包含设备相关字段
    private String employeeId;
    private String workstationId; // 注意这里是 workstationId
    private String lotCode;
    private List<String> materials;
    private int pnl;
    private int pcs;
    private String startTime; // ISO 8601 格式的字符串, e.g., "2025-08-28T10:00:00.000Z"

    // 从前端的用户信息或批次信息中获取
    private String siteCode;
    private String lotSite;
    private String remark;
}
