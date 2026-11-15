package com.jcd.mapper;

import com.jcd.model.Mes_avi_alarm;
import com.jcd.model.Mes_avi_alarmExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface Mes_avi_alarmMapper {
    int deleteByPrimaryKey(String id);

    int insert(Mes_avi_alarm record);

    int insertSelective(Mes_avi_alarm record);

    List<Mes_avi_alarm> selectByExample(Mes_avi_alarmExample example);

    Mes_avi_alarm selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Mes_avi_alarm record, @Param("example") Mes_avi_alarmExample example);

    int updateByExample(@Param("record") Mes_avi_alarm record, @Param("example") Mes_avi_alarmExample example);

    int updateByPrimaryKeySelective(Mes_avi_alarm record);

    int updateByPrimaryKey(Mes_avi_alarm record);
}