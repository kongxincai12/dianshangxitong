package com.jcd.mapper;

import com.jcd.model.Eqp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface EqpMapper {
    int deleteByPrimaryKey(String eqpid);

    int insert(Eqp record);

    int insertSelective(Eqp record);

    Eqp selectByPrimaryKey(String eqpid);
    List<Eqp> GetEqpbyEqpname(String eqpnname);

    int updateByPrimaryKeySelective(Eqp record);

    int updateByPrimaryKey(Eqp record);
}