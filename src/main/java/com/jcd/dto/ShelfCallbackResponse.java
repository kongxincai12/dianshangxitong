package com.jcd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 智能货架回调响应体
 * 符合货架厂商接口规范: {Result: 0/1, Message: "..."}
 * 注意: Result=1表示成功, Result=0表示失败 (与ResponseDTO的code不同)
 */
public class ShelfCallbackResponse {

    /** 结果: 0=不成功, 1=成功 */
    @JsonProperty("Result")
    private Integer result;

    /** 具体结果信息 */
    @JsonProperty("Message")
    private String message;

    public ShelfCallbackResponse() {
    }

    public ShelfCallbackResponse(Integer result, String message) {
        this.result = result;
        this.message = message;
    }

    public static ShelfCallbackResponse success(String message) {
        return new ShelfCallbackResponse(1, message);
    }

    public static ShelfCallbackResponse fail(String message) {
        return new ShelfCallbackResponse(0, message);
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
