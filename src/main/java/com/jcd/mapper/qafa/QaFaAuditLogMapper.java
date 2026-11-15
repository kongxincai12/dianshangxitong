package com.jcd.mapper.qafa;

import com.jcd.model.qafa.QaFaAuditLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaFaAuditLogMapper {

    int insert(QaFaAuditLog log);

    List<QaFaAuditLog> selectByRecordId(@Param("recordId") String recordId);
}
