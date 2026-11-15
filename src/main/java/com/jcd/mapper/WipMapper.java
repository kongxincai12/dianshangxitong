package com.jcd.mapper;

import com.jcd.model.Wip;
import com.jcd.model.WipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface WipMapper {
    int deleteByPrimaryKey(String wipid);

    int insert(Wip record);

    int insertSelective(Wip record);

    List<Wip> selectByExample(WipExample example);
    List<Wip> selectBySn(String sn);

    Wip selectByPrimaryKey(String wipid);

    int updateByExampleSelective(@Param("record") Wip record, @Param("example") WipExample example);

    int updateByExample(@Param("record") Wip record, @Param("example") WipExample example);

    int updateByPrimaryKeySelective(Wip record);

    int updateByPrimaryKey(Wip record);
}