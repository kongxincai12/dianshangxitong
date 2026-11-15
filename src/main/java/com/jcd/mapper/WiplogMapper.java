package com.jcd.mapper;

import com.jcd.model.Wiplog;
import com.jcd.model.WiplogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface WiplogMapper {
    int insert(Wiplog record);

    int insertSelective(Wiplog record);

    List<Wiplog> selectByExample(WiplogExample example);
    List<Wiplog> selectByLotidAndStepid(String lotid,String stepid);

    int updateByExampleSelective(@Param("record") Wiplog record, @Param("example") WiplogExample example);

    int updateByExample(@Param("record") Wiplog record, @Param("example") WiplogExample example);
}