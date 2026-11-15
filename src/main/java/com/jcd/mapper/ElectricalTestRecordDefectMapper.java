package com.jcd.mapper;

import com.jcd.model.ElectricalTestRecordDefect;

import java.util.List;

public interface ElectricalTestRecordDefectMapper {

    int insertSelective(ElectricalTestRecordDefect record);

    int updateByPrimaryKeySelective(ElectricalTestRecordDefect record);

    List<ElectricalTestRecordDefect> selectByRecordId(String recordId);

    int deleteByRecordId(String recordId);

    Long sumDefectQtyByRecordId(String recordId);
}
