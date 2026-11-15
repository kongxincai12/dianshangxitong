package com.jcd.dto.materialcheck;

/**
 * 物料核对 响应 DTO
 * 用于向前端返回 /api/material/check-consistency 接口的处理结果
 */
public class CheckResponse {

    /**
     * 是否匹配
     */
    private boolean match;

    /**
     * （根据UPN）查询到的物料描述
     */
    private String materialDescription;

    /**
     * 反馈给用户的消息
     */
    private String message;

    // --- 构造函数 ---

    public CheckResponse() {
    }

    public CheckResponse(boolean match, String materialDescription, String message) {
        this.match = match;
        this.materialDescription = materialDescription;
        this.message = message;
    }

    // --- 静态工厂方法 (推荐使用，使Service层代码更清晰) ---

    public static CheckResponse success(String description) {
        return new CheckResponse(true, description, "物料信息一致");
    }

    public static CheckResponse mismatch(String description, String message) {
        return new CheckResponse(false, description, message);
    }

    public static CheckResponse error(String message) {
        return new CheckResponse(false, "", message);
    }


    // Getters and Setters

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
