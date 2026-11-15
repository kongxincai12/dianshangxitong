package com.jcd.mapper;

import com.jcd.entity.IqcScanLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IqcScanLogMapper {
    // 插入扫码记录
    int insert(IqcScanLog log);

    // 检查 UPN 是否存在 (防重码)
    int checkUpnExists(@Param("upn") String upn);
}