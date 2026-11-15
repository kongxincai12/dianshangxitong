package com.jcd.mapper;

import com.jcd.model.Uf_loadsteppasstime;
import com.jcd.model.Uf_loadsteppasstimeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface Uf_loadsteppasstimeMapper {
    int insert(Uf_loadsteppasstime record);

    int insertSelective(Uf_loadsteppasstime record);

    List<Uf_loadsteppasstime> selectByExample(Uf_loadsteppasstimeExample example);

    List<Uf_loadsteppasstime> selectByStep(String step);
    List<Uf_loadsteppasstime> selectByStep2(String step);


    int updateByExampleSelective(@Param("record") Uf_loadsteppasstime record, @Param("example") Uf_loadsteppasstimeExample example);

    int updateByExample(@Param("record") Uf_loadsteppasstime record, @Param("example") Uf_loadsteppasstimeExample example);
}