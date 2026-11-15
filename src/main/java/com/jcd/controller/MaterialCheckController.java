package com.jcd.controller;

import com.jcd.dto.materialcheck.CheckRequest;
import com.jcd.dto.materialcheck.CheckResponse;
import com.jcd.dto.materialcheck.PagedLogResponse;
import com.jcd.service.MaterialCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 物料核对 API 控制器
 * 路径: /api/material
 */
@RestController
@RequestMapping("/api/materialcheck")
public class MaterialCheckController {

    private final MaterialCheckService materialCheckService;

    @Autowired
    public MaterialCheckController(MaterialCheckService materialCheckService) {
        this.materialCheckService = materialCheckService;
    }

    /**
     * 接口 1: 物料一致性核对
     * 对应前端 "自动提交" 或 "确认核对"
     *
     * @param request 请求体 (JSON)
     * @return 响应体 (JSON)
     */
    @PostMapping("/check-consistency")
    public ResponseEntity<CheckResponse> checkConsistency(@RequestBody CheckRequest request) {
        CheckResponse response = materialCheckService.checkConsistency(request);

        // 如果(逻辑上)匹配失败，返回 200 OK 状态码，因为API本身是成功执行的。
        // 前端根据响应体中的 "match: false" 来显示警告。
        return ResponseEntity.ok(response);
    }

    /**
     * 接口 2: 查阅异常日志 (分页)
     *
     * @param page      页码 (默认 1)
     * @param size      每页大小 (默认 10)
     * @param startDate 筛选开始日期 (格式 yyyy-MM-dd)
     * @param endDate   筛选结束日期 (格式 yyyy-MM-dd)
     * @return 分页的日志数据
     */
    @GetMapping("/mismatch-logs")
    public ResponseEntity<PagedLogResponse> getMismatchLogs(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        // Service 层会处理分页逻辑
        PagedLogResponse response = materialCheckService.getMismatchLogs(page, size, startDate, endDate);
        return ResponseEntity.ok(response);
    }
}

