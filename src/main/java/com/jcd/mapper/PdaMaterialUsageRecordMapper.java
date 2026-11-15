package com.jcd.mapper;

import com.jcd.model.LineCylinderRelIdAndLindCode;
import com.jcd.model.PdaLineCylinderMatRel;
import com.jcd.model.PdaMaterialUsageRecord;
import com.jcd.model.UsageRecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PdaMaterialUsageRecordMapper {


    List<PdaMaterialUsageRecord> getUsageRecords(String cylinderCode);

    @Select("select ID as lineCylinderRelId, LINE_CODE as lindCode from PDA_LINE_CYLINDER_REL where CYLINDER_CODE = #{cylinderCode}")
    LineCylinderRelIdAndLindCode getLineCylinderRelIdByCylinderCode(String cylinderCode);

    List<PdaLineCylinderMatRel> getRelMaterials(String lineCylinderRelId);

    Integer insertRecord(UsageRecordDto recordDto);
}
