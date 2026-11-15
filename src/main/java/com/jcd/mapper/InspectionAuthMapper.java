package com.jcd.mapper;

import com.jcd.dto.UserPermissionInfoDto;
import com.jcd.model.MesInspUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper()


public interface InspectionAuthMapper {

    MesInspUsers findUserByEmployeeId(@Param("employeeId") String employeeId);

    List<UserPermissionInfoDto.PermissionDetail> findPermissionsByUserId(@Param("userId") String userId);

    //void insertRecord(MesInspRecords record);
    //void updateRecord(MesInspRecords record);
    //MesInspRecords findRecordById(String id);

    //List<MesInspDefectItems> findBySite(@Param("site") String site);
}
