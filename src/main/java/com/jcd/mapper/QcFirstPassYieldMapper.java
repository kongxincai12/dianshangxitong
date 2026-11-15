package com.jcd.mapper;

import com.jcd.model.CuxLowcodeFqcdirect;
import com.jcd.model.FqcRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface QcFirstPassYieldMapper {

    int insertSelective(CuxLowcodeFqcdirect fqcdirect);
    int updateByPrimaryKeySelective(CuxLowcodeFqcdirect fqcdirect);
    CuxLowcodeFqcdirect selectByPrimaryKeyA(@Param("id")String id);
    int deleteByPrimaryKey(@Param("id")String id);
}
