package com.jcd.utils;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    // 补充这个静态方法
    public static <T> Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setCode(500); // 或者你们项目约定的错误码
        result.setMessage(message);
        return result;
    }
}