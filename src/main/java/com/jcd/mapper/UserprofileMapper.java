package com.jcd.mapper;

import com.jcd.dto.Hrdetail;
import com.jcd.model.Userprofile;
import com.jcd.model.UserprofileExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface UserprofileMapper {
    int deleteByPrimaryKey(String userid);

    int insert(Userprofile record);

    int insertSelective(Userprofile record);

    List<Userprofile> selectByExample(UserprofileExample example);

    Userprofile selectByPrimaryKey(String userid);
    Hrdetail selectByHrDetail(String userid);
    List<Userprofile> UserprofileGetByUsername(String username);
    List<Userprofile> UserprofileGetByUserNameAndPassword(String username,String password);

    int updateByPrimaryKeySelective(Userprofile record);

    int updateByPrimaryKey(Userprofile record);
}