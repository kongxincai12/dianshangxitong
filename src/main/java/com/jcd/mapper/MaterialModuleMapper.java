package com.jcd.mapper;

import com.jcd.dto.LotInfoDto;
import com.jcd.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Mapper()
public interface MaterialModuleMapper {
    List<Map<String, Object>> GetStorageWorkorderQty2(String orderid);
    List<Map<String, Object>> GetWorkordersByCarton(String cartoncode);
    int GetPNMsg(String lotname,String upnname,String reelname);
    List<Map<String, Object>> GetMobyEqpname(String eqpname);
    List<Map<String, Object>> GetMobyEqpname2(String eqpname);
    List<Map<String, Object>> GetLoadMobyEqpname(String eqpname);
    List<Map<String, Object>> GetLoadpartsMobyEqpname (String eqpname);
    List<Map<String, Object>> GetFeerderbyFeedername(String Feedername);
    List<Map<String, Object>> Searchematerialstatus(String moid,String eqpname);
    List<Map<String, Object>> SearchematerialstatusNoCom(String moid,String eqpname);
    List<Map<String, Object>> SearchSTENCIL(String moid);
    int GetOkSlotCount(String moid,String slot,String pn,String eqpname);
    List<Rmm_picklist> Rmm_picklistsGetByPnAndLot(String workorderid, String lotid, String pn);
    List<Loadinglistcontent> LoadinglistcontentGetbyPnAndLine(String productname,String linename);
    List<Map<String, Object>>SearchLoadinglistcontentSlot(String upn,String pn ,String llid);
    List<Map<String, Object>>GetGDUpn(String upnname);
    List<Map<String, Object>>GetPACK_MERGE_SPLITFROMCODE(String cartoncode);
    List<Map<String, Object>>GetAOI_SMT_TARGETByLine(String line);

    void  A03_SHIMIN_SMT(String P_CAOZUOTYPE,String P_UPNNAME,String P_MOID,String P_LINEID,String P_OLDUPNNAME,String P_OLDMOID,String P_USERID);
    int GetNotLoadPN(String moid,String llid);
    List<Map<String, Object>>GetCHQTY(String upn);
    List<Map<String, Object>>GetOnloadGW(String line);

    LotInfoDto findLotInfo(@Param("lotCode") String lotCode);
    Integer countByUpnName(@Param("upnName") String upnName);
    Integer countByLotNameAndSection(@Param("lotName") String lotName, @Param("section") String section);
    Integer countByLotNameAndUpn(@Param("lotName") String lotName, @Param("upnName") String upnName);
    Integer countByLotNameAndLotName(@Param("lotName1")  String lotName1, @Param("lotName2") String lotName2);

    SysAppVersion findLatestVersion(@Param("appId") String appId, @Param("platform") String platform);

    String findUsedStatusByUpn(String upn);
    void insertLoadingLog(String employeeId, String upn, String lineId, LocalDateTime loadingTime);
    String findLastLineIdByUpn(String upn,String lineId);
}
