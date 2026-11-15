package com.jcd.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 设备作业在同一生产批次、同一工序站点下的数量占用情况。
 */
@Data
public class ProductionQuotaDto {
    private String lotCode;
    private String stationId;
    private String lotSite;
    private Integer panelPcs;
    private BigDecimal batchPnl;
    private BigDecimal batchPcs;
    private BigDecimal allocatedPnl;
    private BigDecimal allocatedPcs;
    private BigDecimal remainingPnl;
    private BigDecimal remainingPcs;
}
