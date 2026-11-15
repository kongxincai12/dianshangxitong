package com.jcd.model;

import java.util.Date;

/**
 * 系统账号实体 - 对应 SYS_USER_ACCOUNT 表
 * 用于 Process Data Maintenance 系统登录校验
 */
public class SysUserAccount {

    /** 登录账号（工号 USERNUMBER） */
    private String userId;

    /** 员工姓名 */
    private String username;

    /** MD5 加密后的密码 */
    private String password;

    /** 部门名称 */
    private String unitName;

    /** 是否首次登录：1=是（初始密码，需强制改密）, 0=否 */
    private Integer isFirstLogin;

    /** 账号状态：ACTIVE=正常, DISABLED=禁用 */
    private String status;

    /** 备注 */
    private String remark;

    /** 创建时间 */
    private Date createTime;

    /** 最后更新时间 */
    private Date updateTime;

    // ─────────────── Getters / Setters ───────────────

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUnitName() { return unitName; }
    public void setUnitName(String unitName) { this.unitName = unitName; }

    public Integer getIsFirstLogin() { return isFirstLogin; }
    public void setIsFirstLogin(Integer isFirstLogin) { this.isFirstLogin = isFirstLogin; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
}
