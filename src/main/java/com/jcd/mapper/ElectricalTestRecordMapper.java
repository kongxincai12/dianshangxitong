package com.jcd.mapper;

import com.jcd.model.ElectricalTestRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ElectricalTestRecordMapper {

    int insertSelective(ElectricalTestRecord record);

    int updateByPrimaryKeySelective(ElectricalTestRecord record);

    ElectricalTestRecord selectByPrimaryKey(String id);

    List<ElectricalTestRecord> selectByLotAndDate(@Param("lotCode") String lotCode,
                                        @Param("inspDate") Date inspDate);

    List<ElectricalTestRecord> selectByInspectorAndDate(@Param("inspectorId") String inspectorId,
                                              @Param("inspDate") Date inspDate);

    int checkElectricalPermission(@Param("employeeId") String employeeId);

    List<Map<String, String>> selectElectricalTestDefectPresets();

    int deleteByPrimaryKey(String id);

    int selectStandardCapacity(String modelName);

    int getSumByLotCode(String lotCode, String recordId);

}
