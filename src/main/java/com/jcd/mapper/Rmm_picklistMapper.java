package com.jcd.mapper;

import com.jcd.model.Rmm_picklist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper()
public interface Rmm_picklistMapper {
    int deleteByPrimaryKey(String picklistid);

    int insert(Rmm_picklist record);

    int insertSelective(Rmm_picklist record);

    Rmm_picklist selectByPrimaryKey(String picklistid);
    List<Rmm_picklist> selectByUpn(String upn);

    int updateByPrimaryKeySelective(Rmm_picklist record);

    int updateByPrimaryKey(Rmm_picklist record);
}