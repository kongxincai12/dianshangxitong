package com.jcd.mapper;

import com.jcd.model.Prp_lot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper()
public interface Prp_lotMapper {
    int deleteByPrimaryKey(String lotid);

    int insert(Prp_lot record);

    int insertSelective(Prp_lot record);

    List<Prp_lot> selectByLotname(String lotname);

    Prp_lot selectByPrimaryKey(String lotid);

    int updateByPrimaryKeySelective(Prp_lot record);

    int updateByPrimaryKey(Prp_lot record);
}