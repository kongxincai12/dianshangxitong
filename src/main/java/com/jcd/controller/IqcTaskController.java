package com.jcd.controller;

import com.jcd.entity.IqcTaskInfo;
import com.jcd.entity.Result;
import com.jcd.service.IqcScanService;
import com.jcd.service.IqcTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/iqc")
@CrossOrigin // 允许前端跨域
public class IqcTaskController {

    @Autowired
    private IqcTaskService taskService;

    @Autowired
    private IqcScanService scanService;

    // 1. 任务列表接口
    @GetMapping("/task/list")
    public Result getTaskList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String poNumber,
            @RequestParam(required = false) String partNumber,
            @RequestParam(required = false) String keyword) {

        // 计算 Oracle 分页的 ROWNUM 范围
        int startRow = (page - 1) * limit;
        int endRow = page * limit;

        List<IqcTaskInfo> list = taskService.getTaskList(startRow, endRow,poNumber,partNumber, keyword);
        return Result.success(list);
    }

    // 2. 扫码校验接口
    @PostMapping("/scan/submit")
    public Result submitScan(@RequestBody Map<String, Object> payload) {
        try {
            String scanCode = (String) payload.get("scanCode");
            String detailId = payload.get("id").toString();
            String userId = (String) payload.get("userId"); // 从前端传过来的 UserID

            Map<String, Object> data = scanService.processScan(scanCode, detailId, userId);

            //Map msg = scanService.processScan(scanCode, detailId, userId);
            return Result.success(data);
        } catch (Exception e) {
            e.printStackTrace();
            // 捕获所有校验异常，返回给前端展示
            return Result.error(e.getMessage());
        }
    }
}