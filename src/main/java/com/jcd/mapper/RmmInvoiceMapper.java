package com.jcd.mapper;

import com.jcd.model.RmmInvoice;
import com.jcd.model.RmmInvoiceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface RmmInvoiceMapper {
    int countByExample(RmmInvoiceExample example);

    int deleteByExample(RmmInvoiceExample example);

    int deleteByPrimaryKey(String invoiceid);

    int insert(RmmInvoice record);

    int insertSelective(RmmInvoice record);

    List<RmmInvoice> selectByExample(RmmInvoiceExample example);

    RmmInvoice selectByPrimaryKey(String invoiceid);

    int updateByExampleSelective(@Param("record") RmmInvoice record, @Param("example") RmmInvoiceExample example);

    int updateByExample(@Param("record") RmmInvoice record, @Param("example") RmmInvoiceExample example);

    int updateByPrimaryKeySelective(RmmInvoice record);

    int updateByPrimaryKey(RmmInvoice record);
}