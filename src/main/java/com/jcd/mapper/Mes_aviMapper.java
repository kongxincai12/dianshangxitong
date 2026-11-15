package com.jcd.mapper;

import com.jcd.model.Mes_avi;
import com.jcd.model.Mes_aviExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface Mes_aviMapper {
    int insert(Mes_avi record);

    int insertSelective(Mes_avi record);

    List<Mes_avi> selectByExample(Mes_aviExample example);

    int updateByExampleSelective(@Param("record") Mes_avi record, @Param("example") Mes_aviExample example);

    int updateByExample(@Param("record") Mes_avi record, @Param("example") Mes_aviExample example);
}