package com.jcd.mapper;

import com.jcd.model.Packcarton;
import com.jcd.model.PackcartonExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface PackcartonMapper {
    int deleteByPrimaryKey(String cartonid);

    int insert(Packcarton record);

    int insertSelective(Packcarton record);

    List<Packcarton> selectByExample(PackcartonExample example);

    List<Packcarton> PackcartonGetByCartoncode(String cartonid);

    int updateByPrimaryKeySelective(Packcarton record);

    int updateByPrimaryKey(Packcarton record);
}