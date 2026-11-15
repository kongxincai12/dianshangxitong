package com.jcd.mapper;

import com.jcd.model.Wipupn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper()
public interface WipupnMapper {

    int insert(Wipupn record);

    int insertSelective(Wipupn record);

    Wipupn selectByPrimaryKey(String wipupnid);

    List<Wipupn> selectByUpnid(String upnid);

    int updateByPrimaryKeySelective(Wipupn record);
}
