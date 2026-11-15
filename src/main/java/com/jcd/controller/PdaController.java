package com.jcd.controller;


import com.alibaba.fastjson.JSONObject;
import com.jcd.dto.SolderValidationRequestDto;
import com.jcd.service.PdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


@RestController
@RequestMapping("/pdaservice")
public class PdaController {
    @Autowired
    private PdaService PDA;

    @PostMapping("/confirmReelMsg")
    public void ConfirmReelMsg(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");

        boolean blRet = PDA.ConfirmReelMsg(json, response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/getmolist")
    public void  Getmolist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ReturnMo(json,response);
        response.getWriter().flush();
        response.getWriter().close();

    }

    @PostMapping("/loadfeeder")
    public void Loadfeeder(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.Loadfeeder(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/comfirmparts")
    public void Comfirmparts(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ComfirmParts(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/comfirmparts2")
    public void Comfirmparts2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ComfirmParts2(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/comfirmpartsNew")
    public void ComfirmpartsNew(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ComfirmPartsNew(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/replenishFeeders")
    public void ReplenishFeeders(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ReplenishFeeders(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/replenishFeedersCheckAoi")
    public void ReplenishFeedersCheckAoi(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ReplenishFeedersCheckAoi(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/replenishUpn")
    public void ReplenishUpn(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ReplenishUpn(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/unloadmaterialbySlot")
    public void UnloadmaterialbySlot(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnloadmaterialbySlot(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/unloadmaterialbySlot2")
    public void UnloadmaterialbySlot2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnloadmaterialbySlot2(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/unloadmaterialbySlotsp")
    public void UnloadmaterialbySlotsp(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnloadmaterialbySlotsp(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/lotstepin")
    public void LotStepIn(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.LotStepIn(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/lotsteppass")
    public void LotStepPass(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.LotStepPass(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/getpdastep")
    public void Getpdastep(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.Getpdastep(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/unloadmaterialall")
    public  void UnloadmaterialAll(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnloadmaterialAll(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/unloadmaterialall2")
    public  void UnloadmaterialAll2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnloadmaterialAll2(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/checkparts")
    public  void CheckParts(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.CheckParts(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/checkparts2")
    public  void CheckParts2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.CheckParts2(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/lockmo")
    public  void Lockmaterial(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.Lockmaterial(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/unlockmo")
    public  void UnLockmaterial(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnLockmaterial(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/searchematerialstatus")
    public  void  Searchematerialstatus(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.Searchematerialstatus(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/searchematerialstatusnocom")
    public  void  SearchematerialstatusNoCom(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.SearchematerialstatusNoCom(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/SLMaterialstatusNoCom")
    public void SearchLoadStartsmaterialstatusNoCom(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.SearchLoadStartsmaterialstatusNoCom(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/getLoadinglist")
    public  void  GetLoadinglist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.GetLoadinglist(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/getLoadinglistSlot")
    public  void  GetLoadinglistSlot(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.GetLoadinglistSlot(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/getMolist2")
    public void GetMolist2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.GetMolist(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/loadGD")
    public  void  LoadGD(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.LoadGD(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/loadGD2")
    public  void  LoadGD2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.LoadGD2(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/getGD")
    public  void  GetGD(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.GetGD(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/changeFeeder")
    public  void  ChangeFeeder(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ChangeFeeder(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/unloadFeeder")
    public  void  UnloadFeeder(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnloadFeeder(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/returnloadmolist")
    public  void  ReturnLoadMoList(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ReturnLoadMoList(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/loadparts")
    public  void  LoadParts(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.LoadParts(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/getmoinfo")
    public  void  GetMoInfo(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.GetMoInfo(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/changegd")
    public  void  ChangGD(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.ChangeGD(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/checkcarton")
    public void Checkcarton(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.GetCartonlist(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/getonloadgw")
    public void GetOnloadGW(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.GetOnloadGW(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @PostMapping("/unloadgw")
    public void UnLoadGW(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.UnloadGW(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/loadgw")
    public void LoadGW(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        PDA.LoadGW(json,response);
        response.getWriter().flush();
        response.getWriter().close();
    }
    @PostMapping("/validateLine")
    public ResponseEntity<Map<String, Object>> validateLine(@RequestBody Map<String, String> requestBody) {
        // 将 GetLine 方法的结果 return 出去
        return PDA.GetLine(requestBody);
    }

    @PostMapping("/validateSolderPaste")
    public ResponseEntity<Map<String, Object>> validateSolderPaste(@RequestBody SolderValidationRequestDto request) {
        // 调用 Service 层处理业务逻辑
        return PDA.validateSolderPaste(request);
    }

}
