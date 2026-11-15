package com.jcd.mapper;

import com.jcd.model.RmmInvoicedetail;
import com.jcd.model.RmmInvoicedetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface RmmInvoicedetailMapper {
    int countByExample(RmmInvoicedetailExample example);

    int deleteByExample(RmmInvoicedetailExample example);

    int deleteByPrimaryKey(String invoicedetailid);

    int insert(RmmInvoicedetail record);

    int insertSelective(RmmInvoicedetail record);

    List<RmmInvoicedetail> selectByExample(RmmInvoicedetailExample example);
    List<RmmInvoicedetail>  selectByInvoiceId(String invoiceId);

    RmmInvoicedetail selectByPrimaryKey(String invoicedetailid);

    int updateByExampleSelective(@Param("record") RmmInvoicedetail record, @Param("example") RmmInvoicedetailExample example);

    int updateByExample(@Param("record") RmmInvoicedetail record, @Param("example") RmmInvoicedetailExample example);

    int updateByPrimaryKeySelective(RmmInvoicedetail record);

    int updateByPrimaryKey(RmmInvoicedetail record);
}