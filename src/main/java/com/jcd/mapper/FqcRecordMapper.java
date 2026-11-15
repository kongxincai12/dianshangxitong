package com.jcd.mapper;

import com.jcd.model.FqcRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Mapper
public interface FqcRecordMapper {

    int insertSelective(FqcRecord record);

    int updateByPrimaryKeySelective(FqcRecord record);

    FqcRecord selectByPrimaryKey(String id);

    List<FqcRecord> selectByLotAndDate(@Param("lotCode") String lotCode,
                                        @Param("inspDate") Date inspDate);

    List<FqcRecord> selectByInspectorAndDate(@Param("inspectorId") String inspectorId,
                                              @Param("inspDate") Date inspDate);

    int checkFqcPermission(@Param("employeeId") String employeeId);

    List<Map<String, String>> selectFqcDefectPresets();

    List<Map<String, String>> selectCcdDefectPresets();

    int deleteByPrimaryKey(String id);

    int selectStandardCapacity(String modelName);

}
