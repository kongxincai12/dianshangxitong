package com.jcd.mapper;

import com.jcd.model.Prp_lotrectime;
import com.jcd.model.Prp_lotrectimeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface Prp_lotrectimeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Prp_lotrectime record);

    int insertSelective(Prp_lotrectime record);

    List<Prp_lotrectime> selectByExample(Prp_lotrectimeExample example);
    List<Prp_lotrectime> selectByLotnameAndStepame(String lotname ,String stepname);
    List<Prp_lotrectime> selectByLotnameAndSteppassname(String lotname ,String stepname);
    Prp_lotrectime selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Prp_lotrectime record, @Param("example") Prp_lotrectimeExample example);

    int updateByExample(@Param("record") Prp_lotrectime record, @Param("example") Prp_lotrectimeExample example);

    int updateByPrimaryKeySelective(Prp_lotrectime record);

    int updateByPrimaryKey(Prp_lotrectime record);
}