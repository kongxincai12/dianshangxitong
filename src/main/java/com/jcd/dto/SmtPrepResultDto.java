package com.jcd.dto;

import java.util.List;

/**
 * SMT备料计算最终结果DTO
 * 包含：物料需求总表 + 发料明细表
 */
public class SmtPrepResultDto {

    /** 物料需求总表（仅包含有缺口的数据） */
    private List<MaterialRequirementDto> requirementList;

    /** 发料明细表（FIFO分配后的UPN明细） */
    private List<IssueDetailDto> issueDetailList;

    public SmtPrepResultDto() {
    }

    public SmtPrepResultDto(List<MaterialRequirementDto> requirementList, List<IssueDetailDto> issueDetailList) {
        this.requirementList = requirementList;
        this.issueDetailList = issueDetailList;
    }

    public List<MaterialRequirementDto> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<MaterialRequirementDto> requirementList) {
        this.requirementList = requirementList;
    }

    public List<IssueDetailDto> getIssueDetailList() {
        return issueDetailList;
    }

    public void setIssueDetailList(List<IssueDetailDto> issueDetailList) {
        this.issueDetailList = issueDetailList;
    }
}
