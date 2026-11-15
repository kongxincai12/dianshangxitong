package com.jcd.dto;

import lombok.Data;

import java.math.BigDecimal;

/** 同批次、同工序站点已被设备作业占用的数量。 */
@Data
public class ProductionAllocatedQtyDto {
    private BigDecimal allocatedPnl;
    private BigDecimal allocatedPcs;
}
