package com.jcd.mapper;

import com.jcd.model.ParamOverride;
import com.jcd.model.ParamOverrideExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface ParamOverrideMapper {


    int delete(ParamOverrideExample example);

    int insert(ParamOverride record);

    List<ParamOverride> findByEqpId(@Param("eqpId") String eqpId);
    ParamOverride findById(@Param("id") String id);

    int batchInsert(@Param("list") List<ParamOverride> paramList);

    int deleteByEqpId(@Param("eqpId") String eqpId);



    int deleteById(@Param("id") String id);

    int update(ParamOverride record);
}