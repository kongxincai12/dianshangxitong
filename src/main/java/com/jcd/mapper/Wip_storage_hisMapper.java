package com.jcd.mapper;

import com.jcd.model.Wip_storage_his;
import com.jcd.model.Wip_storage_hisExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface Wip_storage_hisMapper {
    int deleteByPrimaryKey(String storagehisid);

    int Wip_storage_hisInsert(Wip_storage_his record);

    int insertSelective(Wip_storage_his record);

    List<Wip_storage_his> selectByExample(Wip_storage_hisExample example);

    Wip_storage_his selectByPrimaryKey(String storagehisid);

    int updateByPrimaryKeySelective(Wip_storage_his record);

    int updateByPrimaryKey(Wip_storage_his record);
}