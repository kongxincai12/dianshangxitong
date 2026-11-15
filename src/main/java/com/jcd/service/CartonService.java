package com.jcd.service;
import com.alibaba.fastjson.JSONObject;
import com.jcd.model.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface  CartonService {
    List<Packcarton> PackcartonGetByCartoncode(String cartoncode);
    List<V_location_all> V_location_allGetByLoc_name(String loc_name);
    List<Mlmappinginfo>  MlmappinginfoGetByPartnumber(String partnumber);
    List<Mlmappinginfo>  MlmappinginfoGetByPntype(String pntype);
    List<Wip_storage> Wip_storageGetByCartoncode(String cartoncode);
    boolean Wip_storageInsert (Wip_storage record);
    boolean Wip_storage_hisInsert(Wip_storage_his record);
    boolean Erp_message_transInsert(Erp_message_trans record);
    List<Map<String, Object>> GetStorageWorkorderQty2(String orderid);
    List<Map<String, Object>> GetWorkordersByCarton(String cartoncode);
    boolean updateWorkorderStatus(String state,String orderid);
    boolean Wip_storageUpdate(Wip_storage record);
    boolean CartonInhouse(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException;
}

