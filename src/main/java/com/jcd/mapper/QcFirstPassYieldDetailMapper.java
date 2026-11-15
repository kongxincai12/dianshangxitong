package com.jcd.mapper;

import com.jcd.model.CuxLowcodeFqcdirect;
import com.jcd.model.CuxLowcodeFqcdirectLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QcFirstPassYieldDetailMapper {

    int insertSelective(CuxLowcodeFqcdirectLine fqcdirectLine);
    Integer selectTypeId(@Param("defectName")String defectName,@Param("plateSharp")String plateSharp);
    int deleteByPrimaryKey(String id);
    CuxLowcodeFqcdirectLine selectByPrimaryKey(String recordId);

    int insertTypeId(String uuid,String defectName,String value);
}
