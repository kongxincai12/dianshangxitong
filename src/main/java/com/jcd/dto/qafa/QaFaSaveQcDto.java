package com.jcd.dto.qafa;

import lombok.Data;

import java.util.List;

@Data
public class QaFaSaveQcDto {
    private List<QaFaItemValueDto> items;
    private String problemDesc;
}
