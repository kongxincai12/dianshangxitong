package com.jcd.mapper.qafa;

import com.jcd.model.qafa.QaFaLabData;
import com.jcd.model.qafa.QaFaLabDataItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaFaLabDataMapper {

    int insert(QaFaLabData data);

    int batchInsertItems(@Param("items") List<QaFaLabDataItem> items);

    QaFaLabData selectById(@Param("id") String id);

    List<QaFaLabData> selectByRecordId(@Param("recordId") String recordId);

    List<QaFaLabDataItem> selectItemsByLabDataId(@Param("labDataId") String labDataId);

    int deleteById(@Param("id") String id);

    int deleteItemsByLabDataId(@Param("labDataId") String labDataId);
}
