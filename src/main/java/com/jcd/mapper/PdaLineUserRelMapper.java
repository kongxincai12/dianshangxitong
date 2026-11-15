package com.jcd.mapper;

import com.jcd.model.PdaLineUserRel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PdaLineUserRelMapper {

    @Select("SELECT COUNT(1) FROM PDA_LINE_USER_REL where USERNUMBER = #{employeeId}")
    int countPotionPermission(String employeeId);

    @Select("select * from PDA_LINE_USER_REL where USERNUMBER = #{usernumber} and LINE_CODE = #{lineCode}")
    PdaLineUserRel getUserByUserMember(@Param("lineCode") String lineCode, @Param("usernumber") String usernumber);

    @Insert("insert into PDA_LINE_USER_REL(LINE_CODE,USERNUMBER,USERNAME,OPERATE_USER,OPERATE_TIME)" +
            "values(#{lineCode},#{usernumber},#{username},#{operateUser},#{operateTime}) ")
    void add(PdaLineUserRel pdaLineUserRel);

    @Delete("delete from PDA_LINE_USER_REL where LINE_CODE = #{lineCode} and USERNUMBER = #{usernumber}")
    void deleteByLindeCodeAndUsernumber(String lineCode, String usernumber);

    @Select("select count(*) from PDA_LINE_USER_REL where LINE_CODE = #{lindeCode} and USERNUMBER = #{usernumber}") //todo
    int checkIsLineRelUser(String usernumber, String lindeCode);
}
