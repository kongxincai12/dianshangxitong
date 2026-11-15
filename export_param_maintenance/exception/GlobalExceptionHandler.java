package com.jcd.exception;

import com.jcd.utils.Result;
import lombok.extern.slf4j.Slf4j; // 1. 引入 Lombok 的包
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j // 2. 加上这个注解，就有 log 对象用了
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        // 建议把业务异常也记录一下（用 warn 级别），方便排查是不是传参不对导致的业务报错
        log.warn("出现业务异常: {}", e.getMessage());
        return Result.error(500, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        // 3. 核心修复：把这里的注释删掉，真正把报错堆栈打印出来
        // e 放在最后，才能打印出完整的报错堆栈信息
        log.error("系统内部严重异常", e);

        return Result.error(500, "系统内部错误，请联系管理员");
    }
}