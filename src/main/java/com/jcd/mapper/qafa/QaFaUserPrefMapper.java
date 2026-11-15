package com.jcd.mapper.qafa;

import com.jcd.model.qafa.QaFaUserPref;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QaFaUserPrefMapper {

    QaFaUserPref selectByUserKey(@Param("userId") String userId,
                                 @Param("prefKey") String prefKey);

    int insert(QaFaUserPref pref);

    int updateValue(@Param("userId") String userId,
                    @Param("prefKey") String prefKey,
                    @Param("prefValue") String prefValue);
}
