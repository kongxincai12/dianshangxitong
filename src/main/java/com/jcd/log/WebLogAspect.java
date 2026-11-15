package com.jcd.log;

import com.jcd.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Value("${web.log.response-detail:false}")
    private boolean responseDetail;

    @Value("${web.log.max-length:1000}")
    private int maxLogLength;

    // 定义切点：拦截 controller 包下的所有方法
    @Pointcut("execution(public * com.jcd.controller..*.*(..))")
    public void webLog() {}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Object result = null;
        try {
            // 执行目标方法
            result = proceedingJoinPoint.proceed();
        } finally {
            // 无论成功失败，都在这里打印日志（或只在成功时打印，看需求）
            long timeCost = System.currentTimeMillis() - startTime;

            // 打印请求信息
            log.info("========================================== Start ==========================================");
            log.info("URL          : {}", request.getRequestURL().toString());
            log.info("HTTP Method  : {}", request.getMethod());
            log.info("Class Method : {}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
            log.info("IP           : {}", request.getRemoteAddr());
            log.info("Request Args : {}", summarizeArgs(proceedingJoinPoint.getArgs()));
            log.info("Response     : {}", summarizeResponse(result));
            log.info("Time Cost    : {} ms", timeCost);
            log.info("=========================================== End ===========================================");
        }
        return result;
    }

    private String summarizeArgs(Object[] args) {
        if (args == null || args.length == 0) return "[]";
        return Arrays.stream(args)
                .map(this::summarizeObject)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private String summarizeResponse(Object result) {
        if (responseDetail) {
            return limitedString(result);
        }
        if (result instanceof Result) {
            Result<?> res = (Result<?>) result;
            return "Result(code=" + res.getCode()
                    + ", message=" + res.getMessage()
                    + ", data=" + summarizeObject(res.getData()) + ")";
        }
        if (result instanceof ResponseEntity) {
            ResponseEntity<?> entity = (ResponseEntity<?>) result;
            return "ResponseEntity(status=" + entity.getStatusCodeValue()
                    + ", body=" + summarizeObject(entity.getBody()) + ")";
        }
        return summarizeObject(result);
    }

    private String summarizeObject(Object value) {
        if (value == null) return "null";
        if (value instanceof HttpServletRequest) return "HttpServletRequest";
        if (value instanceof Result) return summarizeResponse(value);
        if (value instanceof ResponseEntity) return summarizeResponse(value);
        if (isSimpleValue(value)) return limitedString(value);
        if (value instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) value;
            String keys = map.keySet().stream()
                    .limit(10)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", map.size() > 10 ? ", ...]" : "]"));
            return "Map(size=" + map.size() + ", keys=" + keys + ")";
        }
        if (value instanceof Collection) {
            Collection<?> collection = (Collection<?>) value;
            String itemType = collection.stream()
                    .filter(v -> v != null)
                    .findFirst()
                    .map(v -> v.getClass().getSimpleName())
                    .orElse("unknown");
            return "Collection(size=" + collection.size() + ", itemType=" + itemType + ")";
        }
        if (value.getClass().isArray()) {
            return "Array(length=" + Array.getLength(value) + ", type=" + value.getClass().getComponentType().getSimpleName() + ")";
        }
        return value.getClass().getSimpleName();
    }

    private boolean isSimpleValue(Object value) {
        return value instanceof CharSequence
                || value instanceof Number
                || value instanceof Boolean
                || value instanceof Character
                || value instanceof Date
                || value.getClass().isEnum();
    }

    private String limitedString(Object value) {
        String text;
        try {
            text = String.valueOf(value);
        } catch (Exception e) {
            text = value == null ? "null" : value.getClass().getSimpleName();
        }
        if (text.length() <= maxLogLength) return text;
        return text.substring(0, maxLogLength) + "... (truncated, length=" + text.length() + ")";
    }
}