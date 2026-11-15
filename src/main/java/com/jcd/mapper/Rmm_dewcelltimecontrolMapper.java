package com.jcd.mapper;

import com.jcd.model.Rmm_dewcelltimecontrol;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface Rmm_dewcelltimecontrolMapper {
    int deleteByPrimaryKey(String dewcelltcid);

    int insert(Rmm_dewcelltimecontrol record);

    int insertSelective(Rmm_dewcelltimecontrol record);

    Rmm_dewcelltimecontrol selectByPrimaryKey(String dewcelltcid);
    List<Rmm_dewcelltimecontrol> selectByUpnid(String upnid);

    int updateByPrimaryKeySelective(Rmm_dewcelltimecontrol record);

    int updateByPrimaryKey(Rmm_dewcelltimecontrol record);
}