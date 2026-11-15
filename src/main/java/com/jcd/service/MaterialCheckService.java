package com.jcd.service;

import com.jcd.dto.materialcheck.CheckRequest;
import com.jcd.dto.materialcheck.CheckResponse;
import com.jcd.dto.materialcheck.PagedLogResponse;

import java.util.Date;

/**
 * 物料核对与日志查询 服务接口
 */
public interface MaterialCheckService {

    /**
     * 执行物料一致性核对
     *
     * @param request 包含 supplierMaterial, upn, 和 operator 的请求
     * @return 包含匹配结果、物料描述和消息的响应
     */
    CheckResponse checkConsistency(CheckRequest request);

    /**
     * 分页查询异常日志
     *
     * @param page      当前页码 (从 1 开始)
     * @param size      每页大小
     * @param startDate (可选) 筛选开始日期
     * @param endDate   (可选) 筛选结束日期
     * @return 分页后的日志响应 DTO
     */
    PagedLogResponse getMismatchLogs(int page,
                                     int size,
                                     Date startDate,
                                     Date endDate);
}