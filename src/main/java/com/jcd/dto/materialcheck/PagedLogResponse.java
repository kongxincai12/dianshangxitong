package com.jcd.dto.materialcheck;

import java.util.List;

public class PagedLogResponse {

    /**
     * 总页数
     */
    private long totalPages;
    /**
     * 总记录数
     */
    private long totalElements;
    /**
     * 当前页的日志列表
     */
    private List<MismatchLogDto> logs;

    // --- 构造函数 ---

    public PagedLogResponse(long totalPages, long totalElements, List<MismatchLogDto> logs) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.logs = logs;
    }

    // Getters and Setters

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<MismatchLogDto> getLogs() {
        return logs;
    }

    public void setLogs(List<MismatchLogDto> logs) {
        this.logs = logs;
    }
}
