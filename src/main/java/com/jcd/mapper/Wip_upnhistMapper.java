package com.jcd.mapper;

import com.jcd.model.Wip_upnhist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface Wip_upnhistMapper {
    int deleteByPrimaryKey(String histid);

    int insert(Wip_upnhist record);

    int insertSelective(Wip_upnhist record);

    Wip_upnhist selectByPrimaryKey(String histid);
    List<Wip_upnhist> Wip_upnhistsGetbyUpnidAndMoid(String upnid,String moid);

    int updateByPrimaryKeySelective(Wip_upnhist record);

    int updateByPrimaryKey(Wip_upnhist record);

    int Wip_upnhistUpdateEndtimeNull(Wip_upnhist record);
}