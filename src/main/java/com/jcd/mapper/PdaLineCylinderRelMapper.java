package com.jcd.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PdaLineCylinderRelMapper {

    @Select("SELECT COUNT(1) FROM PDA_LINE_CYLINDER_REL WHERE CYLINDER_CODE = #{cylinderCode}")
    int countActiveByCylinderCode(String cylinderCode);

    @Select("select count(*) from PDA_LINE_CYLINDER_REL where id = #{id}")
    int countById(Long id);

    @Delete("delete from PDA_LINE_CYLINDER_REL where id =#{id} ")
    void deleteById(Long id);

    @Select("select LINE_CODE from PDA_LINE_CYLINDER_REL where CYLINDER_CODE = #{cylinderCode}")
    String getLineCodeByCylinderCode(String cylinderCode);
}
