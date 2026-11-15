package com.jcd.service.Impl;
import com.jcd.dto.Hrdetail;
import com.jcd.mapper.UserprofileMapper;
import com.jcd.model.Userprofile;
import com.jcd.service.UserprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.List;


@Service("UserprofileService")
public class UserServiceImpl implements UserprofileService {
    @Autowired
    @Resource
    private UserprofileMapper userprofileMapper;
    @Override
    public List<Userprofile> UserprofileGetByUserNameAndPassword(String username, String password){ return userprofileMapper.UserprofileGetByUserNameAndPassword(username,password);}
    @Override
    public List<Userprofile> UserprofileGetByUsername(String username){ return userprofileMapper.UserprofileGetByUsername(username);}

    @Override
    public Hrdetail selectByHrDetail(String userid) {
        return userprofileMapper.selectByHrDetail(userid);
    }

    @Override
    public  String GetMd5Str(String password){
        String md5Str="";
        int length = Math.min(password.length(), 5);
        md5Str = makeMD5(makeMD5(password) + password.substring(0,length));
        return  md5Str;
    }
    private static String makeMD5(String password) {
                 try {

                     StringBuilder pwd = new StringBuilder("");

                     MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
                     byte[] digest1 = md.digest(password.getBytes("UTF-8"));
                     for (int i = 0; i < digest1.length; i++)
                     {
                         //将得到的字符串使用十六进制类型格式。格式后的字符是小写的字母，如果使用大写（X）则格式后的字符是大写字符
                         int v = digest1[i] & 0xFf;
                         String hv = Integer.toHexString(v);
                         if (hv.length() < 2) {
                             pwd.append(0);
                         }
                         pwd.append(hv);
                     }
                     return pwd.toString();
                     } catch (Exception e) {
                         e.printStackTrace();
                     }

                 return password;
             }
}
