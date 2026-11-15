package com.jcd.mapper;

import com.jcd.model.Station;
import com.jcd.model.StationExample;
import java.util.List;

import com.jcd.model.Step;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface StationMapper {
    int deleteByPrimaryKey(String stationid);

    int insert(Station record);

    int insertSelective(Station record);

    List<Station> selectByExample(StationExample example);

    Station selectByPrimaryKey(String stationid);
    List<Station> selectByStationname(String stationname);//STATIONNAME

    int updateByExampleSelective(@Param("record") Station record, @Param("example") StationExample example);

    int updateByExample(@Param("record") Station record, @Param("example") StationExample example);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
}