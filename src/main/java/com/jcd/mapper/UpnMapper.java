package com.jcd.mapper;

import com.jcd.model.Upn;import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface UpnMapper {
    int deleteByPrimaryKey(String upnid);

    int insert(Upn record);

    int insertSelective(Upn record);

    Upn selectByPrimaryKey(String upnid);
    List<Upn> GetUpnByUpnname(String upnname);
    List<Upn> UpnGetByMOIDAndEQPNameAndSlot(String moid,String eqpname,String slot);
    List<Upn> UpnGetByMOIDAndEQPNameAndSlotAndFeeder(String moid,String eqpname,String slot,String feeder);
    List<Upn> UpnGetGDByMOID(String moid);

    List<Upn> GetUpnByFeederid(String feederid);
    List<Upn> GetUpnByMoid (String moid);

    /** 根据储位编码(LOC_NAME)查询该储位上的有效UPN (ACTIVE/HOLD/NG且REMAININGQTY>0) */
    List<Upn> selectActiveUpnByLocationName(@org.apache.ibatis.annotations.Param("locName") String locName);

    int updateByPrimaryKeySelective(Upn record);

    int updateByPrimaryKey(Upn record);
}