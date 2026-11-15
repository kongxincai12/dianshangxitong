package com.jcd.mapper;

import com.jcd.model.Erp_message_trans;
import com.jcd.model.Erp_message_transExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface Erp_message_transMapper {
    int deleteByPrimaryKey(String id);

    int Erp_message_transInsert(Erp_message_trans record);

    int insertSelective(Erp_message_trans record);

    List<Erp_message_trans> selectByExample(Erp_message_transExample example);

    Erp_message_trans selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Erp_message_trans record);

    int updateByPrimaryKey(Erp_message_trans record);
}