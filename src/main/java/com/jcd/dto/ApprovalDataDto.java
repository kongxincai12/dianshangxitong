//封装返回给审批详情页的完整数据结构
package com.jcd.dto;

import java.util.List;
import java.util.Map;

public class ApprovalDataDto {
    private List<String> defectHeaders;
    private List<Map<String, Object>> records;

    public ApprovalDataDto(List<String> defectHeaders, List<Map<String, Object>> records) {
        this.defectHeaders = defectHeaders;
        this.records = records;
    }

    // Getters and Setters...
    public List<String> getDefectHeaders() { return defectHeaders; }
    public void setDefectHeaders(List<String> defectHeaders) { this.defectHeaders = defectHeaders; }
    public List<Map<String, Object>> getRecords() { return records; }
    public void setRecords(List<Map<String, Object>> records) { this.records = records; }
}