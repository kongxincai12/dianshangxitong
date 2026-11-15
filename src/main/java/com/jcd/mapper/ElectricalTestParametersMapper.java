package com.jcd.mapper;

import com.jcd.model.ElectricalTestParameters;
import com.jcd.model.ElectricalTestRecordDefect;

import java.util.List;
import java.util.Map;

public interface ElectricalTestParametersMapper {

    int insertSelective(ElectricalTestParameters record);

    int updateByPrimaryKeySelective(ElectricalTestParameters record);

    List<ElectricalTestParameters> selectByRecordId(String recordId);

    List<Map<String, String>> selectElectricalTestCraftParameters(String recordId);

    int deleteByRecordId(String recordId);

}
