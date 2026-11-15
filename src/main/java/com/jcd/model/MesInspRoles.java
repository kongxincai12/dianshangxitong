package com.jcd.model;

public class MesInspRoles {
    private String id;

    private String roleCode;

    private String roleName;

    private Long roleLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Long getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Long roleLevel) {
        this.roleLevel = roleLevel;
    }
}