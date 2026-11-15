package com.jcd.entity;

import java.io.Serializable;

/**
 * 统一 API 返回结果封装
 */
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.code = 200;
        r.msg = "success";
        r.data = data;
        return r;
    }

    public static Result<String> success(String msg) {
        Result<String> r = new Result<>();
        r.code = 200;
        r.msg = msg;
        return r;
    }

    public static Result<Object> error(String msg) {
        Result<Object> r = new Result<>();
        r.code = 500;
        r.msg = msg;
        return r;
    }

    // Getters and Setters
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}