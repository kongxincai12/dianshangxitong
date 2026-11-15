package com.jcd.mapper;

import com.jcd.model.ProductionRecord;
import com.jcd.model.RecordMaterial;
import com.jcd.model.RecordMaterialExample;
import java.util.List;

import com.jcd.model.RecordParameter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface RecordMaterialMapper {
    void deleteByRecordId(String recordId);
    int batchInsert(List<RecordMaterial> materialEntities);
    void batchInsertMaterials(@Param("materials") List<RecordMaterial> materials);
    void batchInsertParameters(@Param("parameters") List<RecordParameter> parameters);
    ProductionRecord findById(@Param("id") String id);
    int updateProductionRecord(ProductionRecord record);
    void insert(RecordMaterial record);
    void deleteByRecordIdAndMaterialCode(String recordId, String materialCode);
}