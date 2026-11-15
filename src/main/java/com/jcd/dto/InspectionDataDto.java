package com.jcd.dto;

import java.util.List;

// 假设 LqcRecordDto.DefectDetailDto 是一个已定义的静态内部类或独立类
// 如果 LqcRecordDto 不在同一个包中，你可能需要导入它
// import com.jcd.another.package.LqcRecordDto;

public class InspectionDataDto {
    private boolean isExistingRecord; // 标志是新记录还是已存在的记录
    private String recordId; // 如果是已存在的记录，则返回其ID

    // 以下是批次信息
    private String productPn;
    private Integer totalQty;
    private Integer sampleQty;

    private Integer panelPcs; // 用于 PNL 和 PCS 换算
    private String judgementResult;

    // 已保存的缺陷列表
    // 假设 LqcRecordDto.DefectDetailDto 是一个有效的类型
    private List<LqcRecordDto.DefectDetailDto> defects;

    // 默认构造函数
    public InspectionDataDto() {
    }

    // --- Getters and Setters ---

    public boolean isExistingRecord() {
        return isExistingRecord;
    }

    public void setExistingRecord(boolean existingRecord) {
        isExistingRecord = existingRecord;
    }

    public Integer getPanelPcs(){
        return panelPcs;
    }
    public void setPanelPcs(Integer panelPcs) {
        this.panelPcs = panelPcs;
    }
    public String getJudgementResult() {
        return judgementResult;
    }
    public void setJudgementResult(String judgementResult) {
        this.judgementResult = judgementResult;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getProductPn() {
        return productPn;
    }

    public void setProductPn(String productPn) {
        this.productPn = productPn;
    }

    public Integer getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Integer totalQty) {
        this.totalQty = totalQty;
    }

    public Integer getSampleQty() {
        return sampleQty;
    }

    public void setSampleQty(Integer sampleQty) {
        this.sampleQty = sampleQty;
    }

    public List<LqcRecordDto.DefectDetailDto> getDefects() {
        return defects;
    }

    public void setDefects(List<LqcRecordDto.DefectDetailDto> defects) {
        this.defects = defects;
    }
}