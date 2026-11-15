package com.jcd.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class UserPermissionInfoDto implements Serializable {
    private String employeeId;
    private String employeeName;
    private boolean hasPermission; // 是否有权访问此模块
    private List<PermissionDetail> permissions;

    @Data
    public static class PermissionDetail implements Serializable {
        private String site;
        private String roleCode;
        private String roleName;
        private Integer roleLevel;
    }
}
