package com.jcd.dto;

import java.util.List;

public class LqcRecordDto {
    // Basic Info
    private String recordId;
    private String inspectorId; // 前端传来的是 userid，这里用 inspectorId 接收
    private String site;
    private String date; // 检验日期
    private String shift;

    // Lot Info
    private String lotname;
    private String productPn;
    private Integer totalQty;
    private Integer sampleQty;
    private Integer totalDefectQty;
    private String judgementResult;
    private Integer panelPcs;
    // Defect Details
    private List<DefectDetailDto> defects;

    // Inner class for defect details
    public static class DefectDetailDto {
        private String name;
        private Integer qty;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public Integer getQty() { return qty; }
        public void setQty(Integer qty) { this.qty = qty; }
    }

    public void setPanelPcs(Integer panelPcs) {this.panelPcs = panelPcs;}
    public Integer getPanelPcs() { return panelPcs; }

    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getInspectorId() { return inspectorId; }
    public void setInspectorId(String inspectorId) { this.inspectorId = inspectorId; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public String getLotname() { return lotname; }
    public void setLotname(String lotname) { this.lotname = lotname; }
    public String getProductPn() { return productPn; }
    public void setProductPn(String productPn) { this.productPn = productPn; }
    public Integer getTotalQty() { return totalQty; }
    public void setTotalQty(Integer totalQty) { this.totalQty = totalQty; }
    public Integer getSampleQty() { return sampleQty; }
    public void setSampleQty(Integer sampleQty) { this.sampleQty = sampleQty; }
    public Integer getTotalDefectQty() { return totalDefectQty; }
    public void setTotalDefectQty(Integer totalDefectQty) { this.totalDefectQty = totalDefectQty; }
    public List<DefectDetailDto> getDefects() { return defects; }
    public void setDefects(List<DefectDetailDto> defects) { this.defects = defects; }
    public String getJudgementResult() { return judgementResult; }
    public void setJudgementResult(String judgementResult) { this.judgementResult = judgementResult; }

}