package com.jcd.dto;

import com.jcd.model.ProductionRecord;
import com.jcd.model.RecordMaterial;
import com.jcd.model.RecordParameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductionRecordDetailVO extends ProductionRecord {
    // 继承了 ProductionRecord 的所有字段
    // 额外增加关联信息
    private List<RecordMaterial> materials;
    private List<RecordParameter> parameters;
    private Integer panelPcs;
}
