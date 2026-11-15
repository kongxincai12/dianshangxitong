package com.jcd.service;

import com.alibaba.fastjson.JSONObject;
import com.jcd.dto.SolderValidationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PdaService {
     int GetPNMsg(String lotname,String upnname,String reelname);
     boolean ConfirmReelMsg(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException ;
     void ReturnMo(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException ;
     List<Map<String, Object>> GetMobyEqpname(String eqpname);
     void Loadfeeder(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException ;
     void ComfirmParts(JSONObject json, HttpServletResponse response) throws IOException, SQLException ;
     void ComfirmPartsNew(JSONObject json, HttpServletResponse response) throws IOException, SQLException ;
     void ComfirmParts2(JSONObject json, HttpServletResponse response) throws IOException, SQLException ;

     void ReplenishFeeders(JSONObject json, HttpServletResponse response) throws IOException, SQLException ;
     void ReplenishUpn(JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     void UnloadmaterialbySlot(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void UnloadmaterialAll(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void UnloadmaterialAll2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void LoadGD (@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     void LoadGD2 (@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     List<Map<String, Object>> GetLoadpartsMobyEqpname(String eqpname);
     void ReturnLoadPartsMo(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void SearchLoadStartsmaterialstatusNoCom(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;

     void GetGD(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void Lockmaterial(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void UnLockmaterial(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void Searchematerialstatus(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void SearchematerialstatusNoCom(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void CheckParts(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException ;
     void CheckParts2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException ;

     int  GetOkSlotCount(String moid,String slot,String pn,String eqpname);
     void LotStepIn(JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     void LotStepPass(JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     void Getpdastep(JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     void GetLoadinglistSlot(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void GetLoadinglist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void GetMolist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void UnloadmaterialbySlot2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void ChangeFeeder(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;

     void UnloadFeeder(JSONObject json, HttpServletResponse response) throws IOException;
     void ReturnLoadMoList(JSONObject json, HttpServletResponse response) throws IOException;
     void LoadParts(JSONObject json, HttpServletResponse response) throws IOException;
     void GetMoInfo(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void UnloadmaterialbySlotsp(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void ChangeGD(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void GetCartonlist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException;
     void ReplenishFeedersCheckAoi(JSONObject json, HttpServletResponse response) throws IOException, SQLException;

     void LoadGW(JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     void GetOnloadGW(JSONObject json, HttpServletResponse response) throws IOException, SQLException;
     void UnloadGW(JSONObject json, HttpServletResponse response) throws IOException, SQLException;

    ResponseEntity<Map<String, Object>> GetLine(@RequestBody Map<String, String> requestBody) ;

    @Transactional // 添加事务管理, 确保记录日志和校验的原子性
    ResponseEntity<Map<String, Object>> validateSolderPaste(SolderValidationRequestDto request);



    //ResponseEntity<Map<String, Object>> getLine(@RequestBody Map<String, String> requestBody);
}
