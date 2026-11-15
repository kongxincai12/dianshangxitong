package com.jcd.mapper;

import com.jcd.model.Mes_avi_lotrectime;
import com.jcd.model.Mes_avi_lotrectimeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface Mes_avi_lotrectimeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Mes_avi_lotrectime record);

    int insertSelective(Mes_avi_lotrectime record);

    List<Mes_avi_lotrectime> selectByExample(Mes_avi_lotrectimeExample example);

    Mes_avi_lotrectime selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Mes_avi_lotrectime record, @Param("example") Mes_avi_lotrectimeExample example);

    int updateByExample(@Param("record") Mes_avi_lotrectime record, @Param("example") Mes_avi_lotrectimeExample example);

    int updateByPrimaryKeySelective(Mes_avi_lotrectime record);

    int updateByPrimaryKey(Mes_avi_lotrectime record);
}