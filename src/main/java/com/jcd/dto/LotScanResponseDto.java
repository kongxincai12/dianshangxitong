package com.jcd.dto;



import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

// --- 用于响应批次扫描的 DTO ---
@Data
public class LotScanResponseDto {
    private LotInfo lotInfo;
    private List<DefectItemDto> defectItems;

    @Data
    public static class LotInfo {
        private String productCode; // 假设的物料号
        private BigDecimal defaultTotalQty; // 假设的默认送检数
        private BigDecimal defaultSampleQty; // 假设的默认抽检数
    }
}