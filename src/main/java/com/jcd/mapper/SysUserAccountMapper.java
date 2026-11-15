package com.jcd.mapper;

import com.jcd.model.SysUserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * SYS_USER_ACCOUNT 数据访问接口
 */
@Mapper
public interface SysUserAccountMapper {

    /**
     * 按主键（工号）查询账号
     */
    SysUserAccount selectByUserId(@Param("userId") String userId);

    /**
     * 按工号+密码查询（登录校验）
     */
    SysUserAccount selectByUserIdAndPassword(@Param("userId") String userId,
                                             @Param("password") String password);

    /**
     * 插入新账号（首次自动创建）
     */
    int insert(SysUserAccount record);

    /**
     * 更新密码和首次登录标志
     */
    int updatePassword(@Param("userId") String userId,
                       @Param("newPassword") String newPassword);

    /**
     * 查询 HR 视图 - 检查工号是否在允许的部门范围内
     * （UNITNAME 包含 IT/IE/研发/工艺/项目，且在职）
     */
    Map<String, Object> selectHrEmployeeByUsernumber(@Param("usernumber") String usernumber);

    @Select("select USERNAME from cux_erp_hr_employee_v where USERNUMBER = #{usernumber} and STATUS = '在职'")
    String selectNameByUserId(String usernumber);
}
