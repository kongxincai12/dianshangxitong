package com.jcd.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InspectionRecordDto {
    private String id;
    private String lotCode;
    private String equipmentCode;
    private String inspectorId;
    private String site;
    private Integer totalQty;
    private Integer sampleQty;
    private String status;
    private Date inspectionTime;
    private List<DetailDto> details;

    @Data
    public static class DetailDto {
        private String defectName;
        private Integer defectQty;
    }
}
