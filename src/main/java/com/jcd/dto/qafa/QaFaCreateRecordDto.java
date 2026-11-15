package com.jcd.dto.qafa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QaFaCreateRecordDto {
    private String templateId;
    private String lotName;
    private String lineCode;
    private Integer sampleQty;
    private String sampleUnit;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sampleTime;
}
