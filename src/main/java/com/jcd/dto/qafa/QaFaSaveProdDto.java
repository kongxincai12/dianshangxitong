package com.jcd.dto.qafa;

import lombok.Data;

import java.util.List;

@Data
public class QaFaSaveProdDto {
    private List<QaFaItemValueDto> items;
    private String lineCode;
    private Integer sampleQty;
    private String sampleUnit;
}
