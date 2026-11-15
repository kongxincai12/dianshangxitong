package com.jcd.mapper;

import com.jcd.model.Location;
import com.jcd.model.PdaMoldIoRecord;
import com.jcd.model.PdaMoldStock;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PdaMoldStockMapper {
    @Select("select * from PDA_MOLD_STOCK where MOLD_CODE = #{moldCode}")
    PdaMoldStock getStockByMoldCode(String moldCode);

    @Select("select count(*) from PDA_MOLD_STOCK where LOCATION_CODE = #{locationName}")
    Integer checkByLocationName(String locationName);

    @Insert("insert into PDA_MOLD_STOCK(MOLD_CODE,MOLD_NAME,LOCATION_CODE,OPERATE_USER,OPERATE_TIME)" +
            "VALUES(#{moldCode},#{moldName},#{locationCode},#{operateUser},SYSDATE)")
    Integer insertIntoPdaMoldStock(PdaMoldStock pdaMoldStock);


    @Insert("INSERT INTO PDA_MOLD_IO_RECORD ( " +
            "ID, FACILITYTYPE, LOCATION_CODE, IO_TYPE, " +
            " REMARK, OPERATE_USER, OPERATE_TIME " +
            ") VALUES ( " +
            "SEQ_PDA_MOLD_IO_RECORD.NEXTVAL, #{facilityType},  #{locationCode}, #{ioType}, " +
            "#{remark}, #{operateUser}, SYSDATE " +
            ")")
    Integer insertIntoPdaMoldIORecord(PdaMoldIoRecord pdaMoldIoRecord);

    @Select("select * from LOCATION where LOCATIONNAME = #{locationName}")
    Location getLocationByLocationName(String locationName);


    @Select("select count(*) from DUAL where EXISTS(SELECT 1 FROM RMM_PRODUCTFACILITY WHERE FACILITYTYPE = #{moldCode})" +
            " OR EXISTS(SELECT 1 FROM BIM_FACILITY WHERE UPN = #{moldCode})")
    Integer getMoleByMoldCode(@Param("moldCode") String moldCode);


    @Select("select count(*) from PDA_MOLD_STOCK where LOCATION_CODE = #{locationCode}")
    Integer checkLocationOutStatus(String locationCode);

    @Delete("delete from PDA_MOLD_STOCK where LOCATION_CODE = #{locationCode}")
    Integer deletePdaMoldStockByLocationCode(String locationCode);

    @Select("select MOLD_CODE from PDA_MOLD_STOCK where LOCATION_CODE = #{locationCode}")
    String getMoleByLocationCode(String locationCode);


    @Insert("INSERT INTO PDA_MOLD_IO_RECORD ( " +
            "ID, FACILITYTYPE, LOCATION_CODE, IO_TYPE, " +
            " REMARK, OPERATE_USER, OPERATE_TIME " +
            ") VALUES ( " +
            "SEQ_PDA_MOLD_IO_RECORD.NEXTVAL, #{facilityType},  #{locationCode}, #{ioType}, " +
            "#{remark}, #{operateUser}, SYSDATE " +
            ")")
    Integer insertIntoPdaMoldOUTRecord(PdaMoldIoRecord pdaMoldIoRecord);

    @Select("select count(*) from PDA_MOLD_STOCK where MOLD_CODE = #{moldCode} and LOCATION_CODE = #{locationCode}")
    Integer checkMoldInLocation(String moldCode, String locationCode);

    @Delete("delete from PDA_MOLD_STOCK where LOCATION_CODE = #{locationCode} and MOLD_CODE = #{moldCode}")
    Integer deletePdaMoldStockByLocationCodeAndMoldCold(String locationCode,String moldCode);


    List<PdaMoldStock> searchStock(String moldCode, String locationCode);

    List<String> getMoldsByLocationCode(String locationCode);
}
