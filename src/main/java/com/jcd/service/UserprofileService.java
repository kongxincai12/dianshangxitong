package com.jcd.service;

import com.jcd.dto.Hrdetail;
import com.jcd.model.Userprofile;

import java.util.List;

public interface UserprofileService {
    List<Userprofile> UserprofileGetByUserNameAndPassword(String username, String password);
    String GetMd5Str(String password);
    List<Userprofile> UserprofileGetByUsername(String username);
    Hrdetail selectByHrDetail(String userid);
}
