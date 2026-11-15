package com.jcd.service.Impl;

//import com.alibaba.druid.sql.visitor.functions.Bin;
import com.alibaba.fastjson.JSONObject;
//import com.jcd.Tools.MailSendUtils;
import com.jcd.dto.SolderValidationRequestDto;
import com.jcd.mapper.*;
import com.jcd.service.PdaService;
import com.jcd.utils.UtilityMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


import com.jcd.model.*;

@Service("PdaService")
public class PdaServiceImpl implements PdaService {
//    @Autowired
//    private MailSendUtils mailSendUtils;
    @Autowired
    @Resource
    private MaterialModuleMapper materialModuleMapper;

    @Autowired
    @Resource
    private UpnMapper UpnMapper;

    @Autowired
    @Resource
    private LoadmaterialMapper LoadmaterialMapper;

    @Autowired
    @Resource
    private MaterialhistoryMapper MaterialhistoryMapper;

    @Autowired
    @Resource
    private MaterialorderMapper MaterialorderMapper;

    @Autowired
    @Resource
    private FeederMapper FeederMapper;

    @Autowired
    @Resource
    private PartnumberMapper PartnumberMapper;

    @Autowired
    @Resource
    private OrgpnMappingMapper orgpnMappingMapper;

    @Autowired
    @Resource
    private EqpMapper EqpMapper;

    @Autowired
    @Resource
    private Rmm_dewcelltimecontrolMapper Rmm_dewcelltimecontrolMapper;

    @Autowired
    @Resource
    private ReplenishUpnMapper ReplenishUpnMapper;

    @Autowired
    @Resource
    private Wip_upnhistMapper Wip_upnhistMapper;

    @Autowired
    @Resource
    private Prp_lotMapper Prp_lotMapper;

    @Autowired
    @Resource
    private UserprofileMapper userprofileMapper;

    @Autowired
    @Resource
    private LoadinglistcontentMapper LoadinglistcontentMapper;

    @Autowired
    @Resource
    private LoadinglistMapper LoadinglistMapper;

    @Autowired
    @Resource
    private Rmm_picklistMapper rmm_picklistMapper;

    @Autowired
    @Resource
    private WorkorderMapper workorderMapper;

    @Autowired
    @Resource
    private Uf_loadsteppasstimeMapper uf_loadsteppasstimeMapper;

    @Autowired
    @Resource
    private Prp_lotrectimeMapper prp_lotrectimeMapper;

    @Autowired
    @Resource
    private StepMapper stepMapper;

    @Autowired
    @Resource
    private WipMapper wipMapper;

    @Autowired
    @Resource
    private WiplogMapper wiplogMapper;

    @Autowired
    @Resource
    private Wip_storageMapper wip_storageMapper;

    @Autowired
    @Resource
    private PackcartonMapper packcartonMapper;

    @Autowired
    @Resource
    private StationMapper stationMapper;

    @Autowired
    @Resource
    private AreaMapper areaMapper;

    @Autowired
    @Resource
    private StencilmanageMapper stencilmanageMapper;

    @Autowired
    @Resource
    private StencilhisMapper stencilhisMapper;


    private void InsertMaterialhistory(List<String> Lists){

        Materialhistory materialhistory = new Materialhistory();
        materialhistory.setMhid(UtilityMethod.GetUUID());
        materialhistory.setMoid(Lists.get(0));
        materialhistory.setMoname(Lists.get(1));
        materialhistory.setTaskname(Lists.get(2));
        materialhistory.setEqpname(Lists.get(3));
        materialhistory.setSlot(Lists.get(4));

        materialhistory.setUpnname(Lists.get(5));

        materialhistory.setFeedername(Lists.get(6));
        materialhistory.setUsername(Lists.get(7));
        materialhistory.setDatetime(Lists.get(8));//
        int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);

    }

    private boolean UpnComfirmParts(String moid, String eqpname, String slot, String upnname) {

        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
        if (loadmaterials.size() > 0) {
            if (loadmaterials.stream().findFirst().get().getTaskname() != null) {
                List<Upn> upns = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);
                if (upns.size() > 0) {
                    for (Upn u:upns) {
                        if(u.getUpnname().equals(upnname)){
                            return true;
                        }
                    }
                    //return upns.stream().findFirst().get().getUpnname().equals(upnname);
                }
            }
        }

        return false;
    }
    private boolean UpnComfirmParts2(String moid, String eqpname, String slot, String upnname, String feeder) {

        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
        if (loadmaterials.size() > 0) {
            if (loadmaterials.stream().anyMatch(loadmaterial -> loadmaterial.getTaskname() != null)) {
                List<Upn> upns = UpnMapper.UpnGetByMOIDAndEQPNameAndSlotAndFeeder(moid, eqpname, slot,feeder);
                if (upns.size() > 0) {
                    for (Upn u:upns) {
                        if(u.getUpnname().equals(upnname)){
                            return true;
                        }
                    }
                    //return upns.stream().findFirst().get().getUpnname().equals(upnname);
                }
            }
        }

        return false;
    }

    private boolean hasMatchingIssuedWorkorderProduct(List<Rmm_picklist> rmmPicklists, String productPn) {
        return rmmPicklists.stream()
                .map(Rmm_picklist::getTransferid)
                .filter(Objects::nonNull)
                .distinct()
                .map(workorderMapper::selectByPrimaryKey)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .anyMatch(workorder -> Objects.equals(workorder.getProductname(), productPn));
    }

    private boolean isDuplicateReplenishSubmit(List<Loadmaterial> loadmaterials, String moid, String eqpname,
                                               String slot, String feeder, String oldupnname, String newupnname) {
        boolean loadmaterialAlreadyReplenished = loadmaterials.stream()
                .anyMatch(loadmaterial -> "ReplenishFeeders".equals(loadmaterial.getTaskname())
                        && Objects.equals(feeder, loadmaterial.getFeeder()));
        if (!loadmaterialAlreadyReplenished) {
            return false;
        }

        List<Upn> loadedNewUpns = UpnMapper.UpnGetByMOIDAndEQPNameAndSlotAndFeeder(moid, eqpname, slot, feeder);
        boolean newUpnAlreadyLoaded = loadedNewUpns.stream()
                .anyMatch(upn -> Objects.equals(newupnname, upn.getUpnname()));
        if (!newUpnAlreadyLoaded) {
            return false;
        }

        List<Upn> oldUpns = UpnMapper.GetUpnByUpnname(oldupnname);
        return oldUpns.stream().anyMatch(upn -> upn.getMoid() == null
                && upn.getEqpname() == null
                && upn.getFeederid() == null
                && upn.getSlot() == null
                && (upn.getRemainingqty() == null || BigDecimal.ZERO.compareTo(upn.getRemainingqty()) == 0));
    }

    private boolean hasText(String value) {
        return value != null && value.trim().length() > 0;
    }

    private String normalizeOrgpnModel(String value) {
        if (!hasText(value)) {
            return null;
        }
        return value.trim().toUpperCase(Locale.ROOT);
    }

    private String extractOrgpnModel(Partnumber partnumber) {
        if (partnumber == null) {
            return null;
        }
        String partname = partnumber.getPartname();
        if (!hasText(partname)) {
            return null;
        }
        String[] parts = partname.split("/", -1);
        if (parts.length < 2 || !hasText(parts[1])) {
            return null;
        }
        return parts[1];
    }

    private String validateOrgpn(JSONObject json, Partnumber partnumber) {
        String scannedModel = normalizeOrgpnModel(json.getString("orgpn"));
        if (scannedModel == null) {
            return null;
        }

        String maintainedModel = normalizeOrgpnModel(extractOrgpnModel(partnumber));
        if (maintainedModel == null) {
            return "原厂型号校验失败：PARTNUMBER.PARTNAME格式不正确，无法提取原厂型号，请先维护厂内料号资料！";
        }
        if (scannedModel.equals(maintainedModel)) {
            return null;
        }
        if (orgpnMappingMapper.countRelatedModels(scannedModel, maintainedModel) > 0) {
            return null;
        }
        return "原厂型号校验失败：扫描原厂型号[" + scannedModel + "]与系统维护型号[" + maintainedModel
                + "]不一致，且未维护新旧型号映射！";
    }

    @Override
    public int GetPNMsg(String lotname, String upnname, String reelname) {
        //System.out.println(lotname);
        return materialModuleMapper.GetPNMsg(lotname, upnname, reelname);
    }

    @Override
    public List<Map<String, Object>> GetMobyEqpname(String eqpname) {
        return materialModuleMapper.GetMobyEqpname(eqpname);
    }
    @Override
    public List<Map<String, Object>> GetLoadpartsMobyEqpname(String eqpname) {
        return materialModuleMapper.GetLoadpartsMobyEqpname(eqpname);
    }

    public List<Map<String, Object>> GetLoadMobyEqpname(String eqpname) {
        return materialModuleMapper.GetLoadMobyEqpname(eqpname);
    }


    @Override
    public int GetOkSlotCount(String moid, String slot, String pn, String eqpname) {
        return materialModuleMapper.GetOkSlotCount(moid, slot, pn, eqpname);
    }
    @Override
    public void Getpdastep(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();

        String username = json.getString("username");
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if(userprofiles.size()>0){
            if(userprofiles.stream().findFirst().get().getLinename().equals("ALL")){
                List<Step> steps = stepMapper.selectByUsernameAll(username);
                //for (Step s : steps) {
                    Request.put("step", steps);
                    //Request.put("stepnameCN", s.getDescription());
               // }
            }else {
                List<Step> steps = stepMapper.selectByUsername(username);
                //for (Step s : steps) {
                    Request.put("step", steps);
                    //Request.put("stepnameCN", s.getDescription());
                //}
            }



            Request.put("code", 200);
            Request.put("status", true);
           // Request.put("message", "批次不存在！");
            response.getWriter().print(Request);

        }
    }

    //进站
    @Override
    public void LotStepIn(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String lotname= json.getString("lotname");
        String stepname = json.getString("stepname");
        String username = json.getString("username");


        Date datetime = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Prp_lot> prp_lots = Prp_lotMapper.selectByLotname(lotname);

        if(prp_lots.size() < 1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "批次不存在！");
            response.getWriter().print(Request);
            return;
        }
        Prp_lot prp_lot = prp_lots.stream().findFirst().get();

        //此处需改为fromstep
        List<Uf_loadsteppasstime> uf_loadsteppasstimes = uf_loadsteppasstimeMapper.selectByStep(stepname);

        if(uf_loadsteppasstimes.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该站点未维护超时管控！");
            response.getWriter().print(Request);
            return;
        }
        List<Step> stepouts = stepMapper.selectByStepname(stepname);

        List<Prp_lotrectime> prp_lotrectimes = prp_lotrectimeMapper.selectByLotnameAndStepame(lotname,stepname);
        if(prp_lotrectimes.size() > 0){
            Prp_lotrectime prp_lotrectime = prp_lotrectimes.stream().findFirst().get();
                Request.put("code", 200);
                Request.put("status", true);
                if(prp_lotrectime.getSteppasstime()!=null){
                    Request.put("message","批次："+lotname + ",站点："+stepouts.stream().findFirst().get().getDescription()+",已记录进站时间:"
                            +sdf.format(prp_lotrectime.getStepintime())+",出站时间："
                            + sdf.format(prp_lotrectime.getSteppasstime()));
                }else {
                    Request.put("message","批次："+lotname + ",站点："+stepouts.stream().findFirst().get().getDescription()+",已记录进站时间:"
                            +sdf.format(prp_lotrectime.getStepintime())+",出站时间："
                            + " ");
                }

                response.getWriter().print(Request);
                return;

        }

        String stepnamein= stepname.split("-")[0]+"-TrackIn";
        List<Step> stepins = stepMapper.selectByStepname(stepnamein);

        if(stepins.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "找不到该站点进站，请联络IT维护！");
            response.getWriter().print(Request);
            return;
        }


//        List<Wip> wips = wipMapper.selectBySn(lotname);
//        List<Wiplog> wiplogs = wiplogMapper.selectByLotidAndStepid(prp_lot.getLotid(),stepins.stream().findFirst().get().getStepid());
//        //List<Wip> wips = wipMapper.
//        if(wiplogs.size()<1){
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "该站点未在MES操作进站，请先在MES进站！");
//            response.getWriter().print(Request);
//            return;
//        }
//        if(!wips.stream().findFirst().get().getCurrentstepid().equals(stepins.stream().findFirst().get().getStepid())){
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "该站点未在MES操作进站，请先在MES进站！");
//            response.getWriter().print(Request);
//            return;
//        }



        Prp_lotrectime prp_lotrectime = new Prp_lotrectime();
        prp_lotrectime.setId(UtilityMethod.GetUUID());
        prp_lotrectime.setLotid(prp_lot.getLotid());
        prp_lotrectime.setLotname(lotname);
        prp_lotrectime.setProductpn(prp_lot.getProductpn());
        prp_lotrectime.setStepid(stepouts.stream().findFirst().get().getStepid());
        prp_lotrectime.setStepname(stepname);
        prp_lotrectime.setUsername(username);
        prp_lotrectime.setStepintime(datetime);

        int prp_lotrectimeInsert = prp_lotrectimeMapper.insert(prp_lotrectime);
        Request.put("code", 200);
        Request.put("status", true);
        if(prp_lotrectime.getSteppasstime()!=null){
            Request.put("message","批次："+lotname + ",站点："+stepouts.stream().findFirst().get().getDescription()+",已记录进站时间:"
                    +sdf.format(prp_lotrectime.getStepintime())+",出站时间："
                    + sdf.format(prp_lotrectime.getSteppasstime()));
        }else {
            Request.put("message","批次："+lotname + ",站点："+stepouts.stream().findFirst().get().getDescription()+",已记录进站时间:"
                    +sdf.format(prp_lotrectime.getStepintime())+",出站时间："
                    + " ");
        }
        response.getWriter().print(Request);
        //return;


    }

    //出站
    @Override
    public void LotStepPass(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String lotname= json.getString("lotname");
        String stepname = json.getString("stepname");
        String username = json.getString("username");


        Date datetime = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Prp_lot> prp_lots = Prp_lotMapper.selectByLotname(lotname);
        if(prp_lots.size() < 1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "批次不存在！");
            response.getWriter().print(Request);
            return;
        }
        Prp_lot prp_lot = prp_lots.stream().findFirst().get();

        List<Uf_loadsteppasstime> uf_loadsteppasstimes = uf_loadsteppasstimeMapper.selectByStep2(stepname);
        if(uf_loadsteppasstimes.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该站点未维护超时管控！");
            response.getWriter().print(Request);
            return;
        }

//        String stepnamein= stepname.split("-")[0]+"-TrackIn";
//        List<Step> stepins = stepMapper.selectByStepname(stepnamein);
//
//        if(stepins.size()<1){
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "找不到该站点进站，请联络IT维护！");
//            response.getWriter().print(Request);
//            return;
//        }


//        List<Wip> wips0 = wipMapper.selectBySn(lotname);
//        List<Wiplog> wiplogs = wiplogMapper.selectByLotidAndStepid(prp_lot.getLotid(),stepins.stream().findFirst().get().getStepid());
//
//        if(wiplogs.size()<1){
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "该站点未在MES操作进站，请先在MES进站！");
//            response.getWriter().print(Request);
//            return;
//        }
//        if(!wips0.stream().findFirst().get().getCurrentstepid().equals(stepins.stream().findFirst().get().getStepid())){
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "该站点未在MES操作进站，请先在MES进站！");
//            response.getWriter().print(Request);
//            return;
//        }



        List<Step> stepouts = stepMapper.selectByStepname(stepname);
        //此处查询oa维护的出站tostep和记录的时间

        List<Prp_lotrectime> prp_lotrectimes = prp_lotrectimeMapper.selectByLotnameAndSteppassname(lotname,stepname);
        if(prp_lotrectimes.size() > 0){
            Prp_lotrectime prp_lotrectime = prp_lotrectimes.stream().findFirst().get();
            if(prp_lotrectime.getSteppasstime()!=null){
                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message","批次："+lotname + ",站点："+stepouts.stream().findFirst().get().getDescription()+",已记录进站时间:"
                        +sdf.format(prp_lotrectime.getStepintime())+",出站时间："
                        + sdf.format(prp_lotrectime.getSteppasstime()));
                response.getWriter().print(Request);
                return;
            }else {
                prp_lotrectime.setSteppassid(stepouts.stream().findFirst().get().getStepid());
                prp_lotrectime.setSteppassname(stepouts.stream().findFirst().get().getStepname());
                prp_lotrectime.setSteppasstime(datetime);
                int updateprp_lotrectime = prp_lotrectimeMapper.updateByPrimaryKey(prp_lotrectime);
                BigDecimal steppasstime = new BigDecimal(datetime.getTime()-prp_lotrectime.getStepintime().getTime()).divide(new BigDecimal(1000));
                if(steppasstime.compareTo(uf_loadsteppasstimes.stream().findFirst().get().getTime())>0){
                    //
                    //prp_lotrectime.setSteppasstime();
                    prp_lot.setStatus("HOLD");
                    //int updatePrp_lot = Prp_lotMapper.updateByPrimaryKey(prp_lot);

                    List<Wip> wips = wipMapper.selectBySn(lotname);
                    Step step = stepMapper.selectByStepname(stepname).stream().findFirst().get();

                    Station station = stationMapper.selectByStationname(stepname).stream().findFirst().get();
                    Wiplog wiplog = new Wiplog();
                    wiplog.setWiplogid(UtilityMethod.GetUUID());
                    wiplog.setWipid(wips.stream().findFirst().get().getWipid());
                    wiplog.setLotid(prp_lot.getLotid());
                    wiplog.setStepid(station.getStationid());
                    wiplog.setStationid(step.getStepid());
                    wiplog.setRemark("PDA过站超时自动锁定");
                    //int insertWiplog = wiplogMapper.insert(wiplog);


                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message","批次："+lotname + ",站点："+stepouts.stream().findFirst().get().getDescription()+",已记录进站时间:"
                            + sdf.format(prp_lotrectime.getStepintime())+",出站时间："
                            + prp_lotrectime.getSteppasstime()+",间隔过站时间"+steppasstime+"秒,已超该站点维护的"+ uf_loadsteppasstimes.stream().findFirst().get().getTime()+"秒，当前批次已锁定！");
                    response.getWriter().print(Request);

                   // String message=setMessage(lotname,stepouts.stream().findFirst().get().getDescription(),prp_lotrectime.getSteppasstime()+"",username);
                   // this.sendMail("liangzhengyang@jcdfpc.com;laijiasheng@jcdfpc.com",message,"台山MES预警PDA过站超时锁定预警");
                    return;
                }else {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message","批次："+lotname + ",站点："+stepouts.stream().findFirst().get().getDescription()+",已记录进站时间:"
                            + sdf.format(prp_lotrectime.getStepintime())+",出站时间："
                            + prp_lotrectime.getSteppasstime()+",间隔过站时间"+steppasstime+"秒,可正常过站！");
                    response.getWriter().print(Request);
                }
            }
        }else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "找不到该站点的开始过站记录时间！");
            response.getWriter().print(Request);
            return;
        }

    }

    //上料
    @Override
    public void Loadfeeder(JSONObject json, HttpServletResponse response) throws IOException, SQLException {

        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<>();
        /*
        0	Moid
        1	Moname
        2	Taskname
        3	Eqpname
        4	Slot
        5	upnname
        6	Feedername
        7	Username
        8	Datetime
        */


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }


//2024-01 取消校验槽位上是否有UPN
       // List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);

//        if (checkupn.size() > 0) {
//            //插入错误log
//            String message ="错误：上料，槽位已有UPN";//错误原因
//            Lists.add(0,moid);
//            Lists.add(1,moname);
//            Lists.add(2,message);
//            Lists.add(3,eqpname);
//            Lists.add(4,slot);
//            Lists.add(5,upnname);
//            Lists.add(6,feeder);
//            Lists.add(7,worknumber);
//            Lists.add(8,sdf.format(datetime));
//            InsertMaterialhistory(Lists);
//
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "该上料任务的槽位已有UPN，不允许再上料！");
//            response.getWriter().print(Request);
//            return;
//        }

        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);

        if (upninfo.size() > 0) {
            Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
            Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder0.getLotid());
            Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
            String orgpnMessage = validateOrgpn(json, partnumber);
            if (orgpnMessage != null) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", orgpnMessage);
                response.getWriter().print(Request);
                return;
            }
            String pn = partnumber.getPn();
            String upn_smt = "732D4EE6E2C046A9936378840989A365";
            List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());

            if (loadinglistcontents.size() < 1) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "找不到站位表");
                response.getWriter().print(Request);
                return;
            } else {
                loadinglistcontents = loadinglistcontents.stream()
                        .filter(loadinglistcontent ->(loadinglistcontent.getPn()!=null && loadinglistcontent.getPn().equals(pn)) ||( loadinglistcontent.getAlternatepn()!=null&& loadinglistcontent.getAlternatepn().equals(pn)))
                        .filter(loadinglistcontent ->loadinglistcontent.getSlot()!=null && loadinglistcontent.getSlot().equals(slot))
                        .collect(Collectors.toList());
                if (loadinglistcontents.size() < 1) {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "找不到站位表中的料号");
                    response.getWriter().print(Request);
                    return;
                }
            }
            Loadinglistcontent loadinglistcontent = loadinglistcontents.stream().findFirst().get();

            if (GetOkSlotCount(moid, slot, loadinglistcontent.getPn(), eqpname) > 0 || GetOkSlotCount(moid, slot, loadinglistcontent.getAlternatepn(), eqpname) > 0) {
                if (upninfo.size() > 0) {
                    if (upninfo.stream().anyMatch(upn -> !upn.getState().equals("ACTIVE"))) {
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "该UPN状态不可用");
                        response.getWriter().print(Request);
                        return;
                    }
                    //检查UPN是否已发料
                    if (upninfo.stream().anyMatch(upn -> upn.getCurrentstepid().equals(upn_smt))) {
                        List<Rmm_picklist> rmm_picklists = rmm_picklistMapper.selectByUpn(upnname);
                        if(rmm_picklists.size()>0){
                            if(!hasMatchingIssuedWorkorderProduct(rmm_picklists, prp_lot.getProductpn())){
                                Request.put("code", 200);
                                Request.put("status", false);
                                Request.put("message", "该UPN发料的成品料号与当前上料任务的成品料号不匹配！");
                                response.getWriter().print(Request);
                                return;
                            }
                        }else {
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "此UPN:" + upnname + "未发料到工单！");
                            response.getWriter().print(Request);
                            return;
                        }
                        //if(rmm_picklists.stream().anyMatch(rmm_picklist -> rmm_picklist.getUpn().equals(upnname))){
                        if (upninfo.stream().anyMatch(upn -> upn.getMoid() == null)) {//是否有绑定上料任务
                            if (upninfo.stream().anyMatch(upn -> upn.getEqpname() == null)) {//是否有绑定设备
                                if (upninfo.stream().anyMatch(upn -> upn.getFeederid() == null)) {//是否有绑定飞达
                                    if (upninfo.stream().anyMatch(upn -> upn.getSlot() == null)) {//是否有绑定槽位
                                        //开始检查传输过来的数据有无问题
                                        //moid、eqpname、upn、slot在前面已检查
                                        List<Feeder> feederinfo = FeederMapper.GetFeederByFeedername(feeder);
                                        if (feederinfo.size() > 0) {//是否有这个飞达
                                            List<Upn> upnfeeder = UpnMapper.GetUpnByFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                            if (upnfeeder.size() > 0 && !upnfeeder.stream().findFirst().get().getUpnname().equals(upnname)) {
                                                //插入错误log
                                                String message ="错误：上料，飞达已绑定到其他UPN："+upnfeeder.stream().findFirst().get().getUpnname() ;//错误原因
                                                Lists.add(0,moid);
                                                Lists.add(1,moname);
                                                Lists.add(2,message);
                                                Lists.add(3,eqpname);
                                                Lists.add(4,slot);
                                                Lists.add(5,upnname);
                                                Lists.add(6,feeder);
                                                Lists.add(7,worknumber);
                                                Lists.add(8,sdf.format(datetime));
                                                InsertMaterialhistory(Lists);

                                                Request.put("code", 200);
                                                Request.put("status", false);
                                                Request.put("message", "该飞达已绑定到其他UPN：" + upnfeeder.stream().findFirst().get().getUpnname() + "上！");
                                                response.getWriter().print(Request);
                                                return;
                                            }
                                            List<Eqp> eqpinfo = EqpMapper.GetEqpbyEqpname(eqpname);
                                            //设备与飞达是否匹配
                                            if (eqpinfo.stream().findFirst().get().getEqptypeid().equals(feederinfo.stream().findFirst().get().getEqptypeid())) {
                                                //更新UPN信息
                                                Upn upn = upninfo.stream().findFirst().get();
                                                upn.setEqpname(eqpname);
                                                upn.setFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                                upn.setSlot(slot);
                                                upn.setMoid(moid);
                                                int updateUpn = UpnMapper.updateByPrimaryKey(upn);

                                                if (updateUpn > 0) {
                                                    List<Rmm_dewcelltimecontrol> rmm_dewcelltimecontrolInfo = Rmm_dewcelltimecontrolMapper.selectByUpnid(upn.getUpnid());
                                                    if (rmm_dewcelltimecontrolInfo.size() > 0) {
                                                        Rmm_dewcelltimecontrol rmm_dewcelltimecontrol = rmm_dewcelltimecontrolInfo.stream().findFirst().get();
                                                        rmm_dewcelltimecontrol.setFshbreaktime(datetime);
                                                        Rmm_dewcelltimecontrolMapper.updateByPrimaryKey(rmm_dewcelltimecontrol);
                                                    }
                                                    //更新或插入
                                                    List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                                                    //assert loadmaterials != null;

                                                    List<Loadmaterial> loadmaterials1 = loadmaterials.stream()
                                                            .filter(loadmaterial -> loadmaterial.getTaskname()== null)
                                                            .collect(Collectors.toList());
                                                    Loadmaterial loadmaterial;
                                                    if(loadmaterials1.size() >= 1 ){
                                                        loadmaterial = loadmaterials1.stream().findFirst().
                                                                orElseThrow(() -> new RuntimeException("未找到taskname为null的Loadmaterial对象"));
                                                        loadmaterial.setTaskname("LoadFeeders");
                                                        loadmaterial.setFeeder(feeder);
                                                        //直接更新
                                                        LoadmaterialMapper.updateByPrimaryKey(loadmaterial);
                                                    }else{
                                                        loadmaterial = loadmaterials.stream().findFirst().get();
                                                        loadmaterial.setTaskname("LoadFeeders");
                                                        loadmaterial.setFeeder(feeder);
                                                        loadmaterial.setLmid(UtilityMethod.GetUUID());
                                                        //插入新的数据
                                                        LoadmaterialMapper.insert(loadmaterial);
                                                    }
                                                    //loadmaterial = loadmaterials.stream().findFirst().get();


                                                    Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);

                                                    if(!materialorder.getStatus().equals("FINISH")){
                                                        List<Loadmaterial> loadmaterial1 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);
                                                        List<Loadmaterial> loadmaterial2 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream().filter(l2 -> l2.getTaskname() == null).collect(Collectors.toList());
                                                        boolean canFinsh = true;
                                                        if (loadmaterial2.size() == 0 && loadmaterial1.size() > 0) {
                                                            if(!materialorder.getStatus().equals("FINISH")){
                                                                materialorder.setStatus("FINISH");
                                                                int updateMaterialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);
                                                            }
                                                        } else {
                                                            if (loadmaterial1.size() > 0) {
                                                                for (Loadmaterial l2 : loadmaterial2) {
                                                                    if (loadmaterial1.stream().noneMatch(l1 -> l1.getPn().equals(l2.getPn()) && l1.getTaskname() != null)) {
                                                                        canFinsh = false;
                                                                        break;
                                                                    }
                                                                }
                                                                if (canFinsh||materialModuleMapper.GetNotLoadPN(materialorder.getMoid(),materialorder.getLlid())==0) {
                                                                    materialorder.setStatus("FINISH");
                                                                    int updateMaterialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);
                                                                }
                                                            }
                                                        }
                                                    }

                                                    //插入记录

                                                    Materialhistory materialhistory = new Materialhistory();
                                                    materialhistory.setMhid(UtilityMethod.GetUUID());
                                                    materialhistory.setMoid(moid);
                                                    materialhistory.setMoname(moname);
                                                    materialhistory.setTaskname("LoadFeeders");
                                                    materialhistory.setEqpname(eqpname);
                                                    materialhistory.setSlot(slot);
                                                    materialhistory.setPn(pn);
                                                    materialhistory.setQty(loadmaterial.getQty());
                                                    materialhistory.setBoardside(loadmaterial.getBoardside());
                                                    materialhistory.setUpnname(upnname);
                                                    materialhistory.setUpnqty(upn.getRemainingqty());
                                                    materialhistory.setFeedername(feeder);
                                                    materialhistory.setUsername(worknumber);
                                                    materialhistory.setDatetime(sdf.format(datetime));
                                                    int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);

                                                    ReplenishUpn replenishUpn = new ReplenishUpn();
                                                    replenishUpn.setReplenishgroupid(UtilityMethod.GetUUID());
                                                    replenishUpn.setUpnid(upn.getUpnid());
                                                    replenishUpn.setSlot(slot);
                                                    replenishUpn.setCurrentflag("Y");
                                                    replenishUpn.setReplenishupnid(UtilityMethod.GetUUID());
                                                    replenishUpn.setUsername(upnname);
                                                    replenishUpn.setMoid(moid);
                                                    replenishUpn.setDatetime(datetime);
                                                    int insertReplenishUpn = ReplenishUpnMapper.insert(replenishUpn);
                                                    upn.setReplenishgroupid(replenishUpn.getReplenishgroupid());
                                                    int updateUpn2 = UpnMapper.updateByPrimaryKey(upn);

                                                    List<Wip_upnhist> wip_upnhists = Wip_upnhistMapper.Wip_upnhistsGetbyUpnidAndMoid(upn.getUpnid(), moid);
                                                    if (wip_upnhists.size() > 0) {
                                                        int updateWip_upnhist = Wip_upnhistMapper.Wip_upnhistUpdateEndtimeNull(wip_upnhists.stream().findFirst().get());
                                                    } else {
                                                        Wip_upnhist wip_upnhist = new Wip_upnhist();
                                                        wip_upnhist.setHistid(UtilityMethod.GetUUID());
                                                        wip_upnhist.setLotid(materialorder.getLotid());
                                                        wip_upnhist.setMoid(moid);
                                                        wip_upnhist.setUpnid(upn.getUpnid());
                                                        wip_upnhist.setBegintime(datetime);
                                                        wip_upnhist.setSlot(slot);
                                                        int insertWip_upnhist = Wip_upnhistMapper.insert(wip_upnhist);
                                                    }

                                                    Request.put("code", 200);
                                                    Request.put("status", true);
                                                    Request.put("message", "槽位：" + slot + "，上料OK！");
                                                    response.getWriter().print(Request);
                                                    materialModuleMapper.A03_SHIMIN_SMT("PDA上料",upnname,moid,materialorder.getLineid(),"","",worknumber);


                                                }
                                            } else {
                                                //插入错误log
                                                String message ="错误：上料，设备与飞达不匹配";//错误原因
                                                Lists.add(0,moid);
                                                Lists.add(1,moname);
                                                Lists.add(2,message);
                                                Lists.add(3,eqpname);
                                                Lists.add(4,slot);
                                                Lists.add(5,upnname);
                                                Lists.add(6,feeder);
                                                Lists.add(7,worknumber);
                                                Lists.add(8,sdf.format(datetime));
                                                InsertMaterialhistory(Lists);

                                                Request.put("code", 200);
                                                Request.put("status", false);
                                                Request.put("message", "该设备：" + eqpname + "与该飞达：" + feeder + "不匹配！");
                                                response.getWriter().print(Request);
                                            }
                                        } else {
                                            //插入错误log
                                            String message ="错误：上料，找不到飞达";//错误原因
                                            Lists.add(0,moid);
                                            Lists.add(1,moname);
                                            Lists.add(2,message);
                                            Lists.add(3,eqpname);
                                            Lists.add(4,slot);
                                            Lists.add(5,upnname);
                                            Lists.add(6,feeder);
                                            Lists.add(7,worknumber);
                                            Lists.add(8,sdf.format(datetime));
                                            InsertMaterialhistory(Lists);
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "找不到飞达！");
                                            response.getWriter().print(Request);
                                        }

                                    } else {
                                        //插入错误log
                                        String message ="错误：上料，UPN已与槽位"+slot+"绑定";//错误原因
                                        Lists.add(0,moid);
                                        Lists.add(1,moname);
                                        Lists.add(2,message);
                                        Lists.add(3,eqpname);
                                        Lists.add(4,slot);
                                        Lists.add(5,upnname);
                                        Lists.add(6,feeder);
                                        Lists.add(7,worknumber);
                                        Lists.add(8,sdf.format(datetime));
                                        InsertMaterialhistory(Lists);

                                        Request.put("code", 200);
                                        Request.put("status", false);
                                        Request.put("message", "该UPN已与槽位" + slot + "绑定！");
                                        response.getWriter().print(Request);
                                    }
                                } else {
                                    Feeder feederinfo = FeederMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getFeederid());
                                    //插入错误log
                                    String message ="错误：上料，UPN已与飞达" + feederinfo.getFeedername() + "绑定";//错误原因
                                    Lists.add(0,moid);
                                    Lists.add(1,moname);
                                    Lists.add(2,message);
                                    Lists.add(3,eqpname);
                                    Lists.add(4,slot);
                                    Lists.add(5,upnname);
                                    Lists.add(6,feeder);
                                    Lists.add(7,worknumber);
                                    Lists.add(8,sdf.format(datetime));
                                    InsertMaterialhistory(Lists);

                                    Request.put("code", 200);
                                    Request.put("status", false);
                                    Request.put("message", "该UPN已与飞达" + feederinfo.getFeedername() + "绑定！");
                                    response.getWriter().print(Request);
                                }
                            } else {
                                //插入错误log
                                String message ="错误：上料，UPN已与设备" + upninfo.stream().findFirst().get().getEqpname() + "绑定";//错误原因
                                Lists.add(0,moid);
                                Lists.add(1,moname);
                                Lists.add(2,message);
                                Lists.add(3,eqpname);
                                Lists.add(4,slot);
                                Lists.add(5,upnname);
                                Lists.add(6,feeder);
                                Lists.add(7,worknumber);
                                Lists.add(8,sdf.format(datetime));
                                InsertMaterialhistory(Lists);

                                Request.put("code", 200);
                                Request.put("status", false);
                                Request.put("message", "该UPN已与设备" + upninfo.stream().findFirst().get().getEqpname() + "绑定！");
                                response.getWriter().print(Request);
                            }


                        } else {
                            //插入错误log
                            Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getMoid());
                            String message ="错误：上料，UPN已与上料任务" +   materialorderinfo.getMoname()  + "绑定";//错误原因
                            Lists.add(0,moid);
                            Lists.add(1,moname);
                            Lists.add(2,message);
                            Lists.add(3,eqpname);
                            Lists.add(4,slot);
                            Lists.add(5,upnname);
                            Lists.add(6,feeder);
                            Lists.add(7,worknumber);
                            Lists.add(8,sdf.format(datetime));
                            InsertMaterialhistory(Lists);

                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN已与上料任务" + materialorderinfo.getMoname() + "绑定！");
                            response.getWriter().print(Request);
                        }
                        // }
                            /*else {
                                Request.put("code",200);
                                Request.put("status",false);
                                Request.put("message","此UPN未发料到当前工单，请确认");
                                response.getWriter().print(Request);
                            }*/


                        /*}else {
                            Request.put("code",200);
                            Request.put("status",false);
                            Request.put("message","此批次/工单未发料，请确认");
                            response.getWriter().print(Request);
                        }*/

                    } else {
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "此UPN:" + upnname + "未从仓库发料！");
                        response.getWriter().print(Request);
                    }

                } else {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "该UPN不存在或剩余数量等于0！");
                    response.getWriter().print(Request);
                }
            } else {
                //插入错误log
                Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getMoid());
                String message ="错误：上料，可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用";//错误原因
                Lists.add(0,moid);
                Lists.add(1,moname);
                Lists.add(2,message);
                Lists.add(3,eqpname);
                Lists.add(4,slot);
                Lists.add(5,upnname);
                Lists.add(6,feeder);
                Lists.add(7,worknumber);
                Lists.add(8,sdf.format(datetime));
                InsertMaterialhistory(Lists);
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
                response.getWriter().print(Request);
            }
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }

    //上刮刀
    @Override
    public void LoadGD(JSONObject json, HttpServletResponse response) throws IOException, SQLException {

        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上刮刀账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }



        List<Upn> checkupn = UpnMapper.UpnGetGDByMOID(moid);

        if (checkupn.size() > 1) {
            String upnnametmp="";
            for (Upn upn: checkupn) {
                upnnametmp = upnnametmp + upn.getUpnname()+",";
            }
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该上料任务的槽位已上超过两个刮刀，不允许再上刮刀！已上刮刀："+upnnametmp);
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);

        if(upninfo.size()< 1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
            return;

        }
        if(!upninfo.stream().findFirst().get().getUpnname().contains("0000001")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不属于刮刀！");
            response.getWriter().print(Request);
            return;
        }
        if(upninfo.stream().findFirst().get().getMoid()!= null){
            Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getMoid());

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该刮刀已有上料任务："+materialorder.getMoname()+"，不允许再上！");
            response.getWriter().print(Request);
            return;
        }
        if(upninfo.stream().findFirst().get().getState().equals("SCRAP")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该刮刀已报废！");
            response.getWriter().print(Request);
            return;
        }

            //检查使用数量
            Upn gdupn = upninfo.stream().findFirst().get();
            List<Map<String, Object>> data = materialModuleMapper.SearchSTENCIL(moid);
            int stencilqty=0;
            int usingqty=0;
            int usdqty=0;

            if (data.size() > 0) {
                stencilqty = Integer.parseInt(data.get(0).get("PNPCSQTY").toString());
            }else {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "找不到该上料任务对应的钢网，请先上钢网！");
                response.getWriter().print(Request);
                return;
            }
            //生产总数÷对应使用的钢网pcs数×0.9÷2=使用次数（取整数）
            //if(gdupn.getReleaseqty().compareTo(gdupn.getOutqty()))
            Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
            Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder.getLotid());
            //本次使用次数
            usingqty=(int)Math.ceil(prp_lot.getWipqty().intValue()/stencilqty*0.9/2);

            //大于最大使用次数
            usdqty = gdupn.getReleaseqty().intValue()+usingqty;
            if(usdqty >gdupn.getTotalqty().intValue()){
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "当前刮刀使用次数将超过刮刀规定的最大使用次数，本次使用次数："+usdqty+",刮刀规定最大使用次数："+gdupn.getTotalqty()+",不允许上刮刀！");
                response.getWriter().print(Request);
                return;
            }


            //更新
            gdupn.setMoid(moid);
            gdupn.setRemainingqty(BigDecimal.valueOf(usingqty));//上次使用次数
            gdupn.setReleaseqty(BigDecimal.valueOf(usdqty));//本次使用次数

            //插入使用记录

            Materialhistory materialhistory = new Materialhistory();
            materialhistory.setMhid(UtilityMethod.GetUUID());
            materialhistory.setMoid(moid);
            materialhistory.setMoname(moname);
            materialhistory.setTaskname("上刮刀");
            //materialhistory.setEqpname(eqpname);
            materialhistory.setSlot(slot);
            materialhistory.setPn("0000001");
            materialhistory.setQty(BigDecimal.valueOf(usingqty));
            //materialhistory.setBoardside(loadmaterial.getBoardside());
            materialhistory.setUpnname(upnname);
            materialhistory.setUpnqty(gdupn.getRemainingqty());
            //materialhistory.setFeedername(feeder);
            materialhistory.setUsername(worknumber);
            materialhistory.setDatetime(sdf.format(datetime));
            int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);
            int updateUpn = UpnMapper.updateByPrimaryKey(gdupn);


        if(checkupn.size()==0){
            if(usdqty>(gdupn.getTotalqty().intValue()-2000)){
                Request.put("code", 201);
                Request.put("status", true);
                Request.put("currentqty", usdqty);
                Request.put("totalqty", gdupn.getTotalqty());
                Request.put("message", "OK,当前上料任务已上第一把刮刀："+upnname);
                response.getWriter().print(Request);
            }else {
                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "OK,当前上料任务已上第一把刮刀："+upnname);
                response.getWriter().print(Request);
            }
        }else if(checkupn.size()==1){
            if((gdupn.getReleaseqty().intValue()+usingqty) >(gdupn.getTotalqty().intValue()-2000)){
                Request.put("code", 201);
                Request.put("currentqyt", usdqty);
                Request.put("totalqty", gdupn.getTotalqty());
            }else {
                Request.put("code", 200);
            }
            Request.put("status", true);
            Request.put("message", "OK,当前上料任务已上第二把刮刀："+upnname+",第一把刮刀："+checkupn.stream().findFirst().get().getUpnname());
            response.getWriter().print(Request);
        }

    }

    //同时两把上刮刀
    @Override
    public void LoadGD2(JSONObject json, HttpServletResponse response) throws IOException, SQLException {

        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String upnname2 = json.getString("upnname2");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<String>();
        /*
        0	Moid
        1	Moname
        2	Taskname
        3	Eqpname
        4	Slot
        5	upnname
        6	Feedername
        7	Username
        8	Datetime
        */

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上刮刀账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }
        if(upnname.equals(upnname2)){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀不能是同一个！");
            response.getWriter().print(Request);
            return;
        }



        List<Upn> checkupn = UpnMapper.UpnGetGDByMOID(moid);

        if (checkupn.size() > 1) {
            String upnnametmp="";
            for (Upn upn: checkupn) {
                upnnametmp = upnnametmp + upn.getUpnname()+",";
            }
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该上料任务的槽位已上超过两个刮刀，不允许再上刮刀！已上刮刀："+upnnametmp);
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);

        if(upninfo.size()< 1){
            //插入错误log
            String message ="错误：上刮刀，刮刀1不存在";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,upnname);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀1不存在！");
            response.getWriter().print(Request);
            return;

        }
        List<Upn> upninfo2 = UpnMapper.GetUpnByUpnname(upnname2);

        if(upninfo2.size()< 1){
            //插入错误log
            String message ="错误：上刮刀，刮刀2不存在";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,upnname2);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀2不存在！");
            response.getWriter().print(Request);
            return;

        }
        if(!upninfo.stream().findFirst().get().getUpnname().contains("0000001")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN1不属于刮刀！");
            response.getWriter().print(Request);
            return;
        }else  if(!upninfo2.stream().findFirst().get().getUpnname().contains("0000001")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN2不属于刮刀！");
            response.getWriter().print(Request);
            return;
        }
        if(upninfo.stream().findFirst().get().getMoid()!= null){
            Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getMoid());

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀1已有上料任务："+materialorder.getMoname()+"，不允许再上！");
            response.getWriter().print(Request);
            return;
        }else if(upninfo2.stream().findFirst().get().getMoid()!= null){
            Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(upninfo2.stream().findFirst().get().getMoid());

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀2已有上料任务："+materialorder.getMoname()+"，不允许再上！");
            response.getWriter().print(Request);
            return;
        }
        if(upninfo.stream().findFirst().get().getState().equals("SCRAP")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀1已报废！");
            response.getWriter().print(Request);
            return;
        }else if(upninfo2.stream().findFirst().get().getState().equals("SCRAP")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀2已报废！");
            response.getWriter().print(Request);
            return;
        }

        //检查使用数量
        Upn gdupn = upninfo.stream().findFirst().get();
        Upn gdupn2 = upninfo2.stream().findFirst().get();
        List<Map<String, Object>> data = materialModuleMapper.SearchSTENCIL(moid);
        int stencilqty=0;
        int usingqty=0;
        int usdqty=0;
        int usdqty2=0;

        if (data.size() > 0) {
            stencilqty = Integer.parseInt(data.get(0).get("PNPCSQTY").toString());
        }else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "找不到该上料任务对应的钢网，请先上钢网！");
            response.getWriter().print(Request);
            return;
        }
        //生产总数÷对应使用的钢网pcs数×0.9÷2=使用次数（取整数）
        //if(gdupn.getReleaseqty().compareTo(gdupn.getOutqty()))
        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
        Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder.getLotid());
        //本次使用次数
        usingqty=(int)Math.ceil(prp_lot.getWipqty().intValue()/stencilqty*0.9/2);

        //大于最大使用次数
        usdqty = gdupn.getReleaseqty().intValue()+usingqty;
        if(usdqty >gdupn.getTotalqty().intValue()){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀1使用次数将超过刮刀规定的最大使用次数，本次使用次数："+usdqty+",刮刀规定最大使用次数："+gdupn.getTotalqty()+",不允许上刮刀！");
            response.getWriter().print(Request);
            return;
        }
        usdqty2=gdupn2.getReleaseqty().intValue()+usingqty;
        if(usdqty2 >gdupn2.getTotalqty().intValue()){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "刮刀2使用次数将超过刮刀规定的最大使用次数，本次使用次数："+usdqty2+",刮刀规定最大使用次数："+gdupn2.getTotalqty()+",不允许上刮刀！");
            response.getWriter().print(Request);
            return;
        }

        //更新
        gdupn.setMoid(moid);
        gdupn.setRemainingqty(BigDecimal.valueOf(usingqty));//上次使用次数
        gdupn.setReleaseqty(BigDecimal.valueOf(usdqty));//本次使用次数
        //更新
        gdupn2.setMoid(moid);
        gdupn2.setRemainingqty(BigDecimal.valueOf(usingqty));//上次使用次数
        gdupn2.setReleaseqty(BigDecimal.valueOf(usdqty2));//本次使用次数

        //插入使用记录

        Materialhistory materialhistory = new Materialhistory();
        materialhistory.setMhid(UtilityMethod.GetUUID());
        materialhistory.setMoid(moid);
        materialhistory.setMoname(moname);
        materialhistory.setTaskname("上刮刀");
        //materialhistory.setEqpname(eqpname);
        materialhistory.setSlot(slot);
        materialhistory.setPn("0000001");
        materialhistory.setQty(BigDecimal.valueOf(usingqty));
        //materialhistory.setBoardside(loadmaterial.getBoardside());
        materialhistory.setUpnname(upnname);
        materialhistory.setUpnqty(gdupn.getRemainingqty());
        //materialhistory.setFeedername(feeder);
        materialhistory.setUsername(worknumber);
        materialhistory.setDatetime(sdf.format(datetime));
        int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);
        int updateUpn = UpnMapper.updateByPrimaryKey(gdupn);
        //插入使用记录

        Materialhistory materialhistory2 = new Materialhistory();
        materialhistory2.setMhid(UtilityMethod.GetUUID());
        materialhistory2.setMoid(moid);
        materialhistory2.setMoname(moname);
        materialhistory2.setTaskname("上刮刀");
        //materialhistory.setEqpname(eqpname);
        materialhistory2.setSlot(slot);
        materialhistory2.setPn("0000001");
        materialhistory2.setQty(BigDecimal.valueOf(usingqty));
        //materialhistory.setBoardside(loadmaterial.getBoardside());
        materialhistory2.setUpnname(upnname2);
        materialhistory2.setUpnqty(gdupn2.getRemainingqty());
        //materialhistory.setFeedername(feeder);
        materialhistory2.setUsername(worknumber);
        materialhistory2.setDatetime(sdf.format(datetime));
        insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory2);
        updateUpn = UpnMapper.updateByPrimaryKey(gdupn2);

        if(usdqty>(gdupn.getTotalqty().intValue()-2000)){
            Request.put("code", 200);
            Request.put("status", true);
            String message="OK,当前上料任务已上刮刀1："+upnname+",刮刀2："+upnname2+"。注意："+upnname+"当前使用次数："+usdqty+",规定最大使用次数"+gdupn.getTotalqty()+";";

            if(usdqty2>(gdupn2.getTotalqty().intValue()-2000)){
                message +=upnname2+"当前使用次数："+usdqty2+",规定最大使用次数:"+gdupn2.getTotalqty()+";";
            }

            //Request.put("currentqty", usdqty);
            //Request.put("totalqty", gdupn.getTotalqty());
            Request.put("message", message);
            response.getWriter().print(Request);
        }else  if(usdqty2>(gdupn2.getTotalqty().intValue()-2000)) {
            Request.put("code", 200);
            Request.put("status", true);
            String message = "OK,当前上料任务已上刮刀1：" + upnname + ",刮刀2：" + upnname2 + "。注意："+upnname2+"当前使用次数：" + usdqty2 + ",规定最大使用次数" + gdupn2.getTotalqty() + ";";
            Request.put("message", message);
            response.getWriter().print(Request);
        }
        else {
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "OK,当前上料任务已上刮刀1："+upnname+",刮刀2："+upnname2+" ");
            response.getWriter().print(Request);
        }


    }

    @Override
    public void LoadGW(JSONObject json, HttpServletResponse response) throws IOException, SQLException {

        JSONObject Request = new JSONObject();

        String line = json.getString("line");
        //String username = json.getString("username");
        String upnname = json.getString("upnname");
        String username = json.getString("worknumber");

        String msg = "";
        List<String> Lists = new ArrayList<String>();
        /*
        0	Moid
        1	Moname
        2	Taskname
        3	Eqpname
        4	Slot
        5	upnname
        6	Feedername
        7	Username
        8	Datetime
        */

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            UtilityMethod.doRequest(response,Request,200,false,"无法找到用户");
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            UtilityMethod.doRequest(response,Request,200,false,"非规定的可上钢网账号，无法操作！");
            return;
        }

        //检查线体
        Area area = areaMapper.selectByAreaname(line);


        if(area == null || !area.getAreatype().equals("LINE")){
            UtilityMethod.doRequest(response,Request,200,false,"系统找不到扫入的线体，请确认！");
            return;
        }

        //检查UPN
        List<Upn> upninfos = UpnMapper.GetUpnByUpnname(upnname);
        if (upninfos.size() > 0) {
            if(!upninfos.stream().findFirst().get().getUpnname().contains("0000000-")){
                UtilityMethod.doRequest(response,Request,200,false,"扫入的UPN不属于钢网！");
                return;
            }

        }else {
            UtilityMethod.doRequest(response,Request,200,false,"UPN不存在！");
            return;
        }
        Upn upninfo = upninfos.stream().findFirst().get();

        List<Stencilmanage> stencilmanages = stencilmanageMapper.selectByUpnid(upninfo.getUpnid());
        if(stencilmanages!=null&&!stencilmanages.isEmpty()){
            if(stencilmanages.stream().findFirst().get().getStencilusedhistid()!= null&& stencilmanages.stream().findFirst().get().getLineid()!= null){
                /*if(stencilmanages.stream().findFirst().get().getLineid() == null){
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "该钢网正在使用中，请勿重复上钢网！");
                    response.getWriter().print(Request);
                    return;
                }*/
                Area lineusing = areaMapper.selectByPrimaryKey(stencilmanages.stream().findFirst().get().getLineid());

                UtilityMethod.doRequest(response,Request,200,false,"该钢网"+upnname+"正在"+lineusing.getAreaname()+"使用中，请勿重复上钢网或卸除钢网后再上钢网！");
                return;
            }
        }else{
            UtilityMethod.doRequest(response,Request,200,false,"该UPN不属于钢网！");
            return;
        }

        //检查UPN使用数量
        Stencilmanage stencilmanage = stencilmanages.stream().findFirst().get();
        if(stencilmanage.getCurrentfrequency() >= stencilmanage.getMaxfrequency()){
            String message = "钢网："+upnname+" 当前使用次数："+stencilmanage.getCurrentfrequency()+" 已超最大使用次数"+stencilmanage.getMaxfrequency()+"，不允许操作！";
            UtilityMethod.doRequest(response,Request,200,false,message);
            return;
        }

        if(stencilmanage.getCurrentfrequency() >= stencilmanage.getStdfrequency()){
            msg = "请注意，当前钢网已使用次数："+stencilmanage.getCurrentfrequency()+",已达到预警使用次数！";
        }

        //上钢网 LOAD
        Stencilhis stencilhis = new Stencilhis();
        String StencilSHID = UtilityMethod.GetUUID();//钢网历史表自己的ID
        String StencilUSEDID = UtilityMethod.GetUUID();//钢网历史表的使用ID

        stencilhis.setShid(StencilSHID);
        stencilhis.setUsedid(StencilUSEDID);
        stencilhis.setUpnname(upnname);
        stencilhis.setLine(line);
        stencilhis.setTaskname("LOAD");
        stencilhis.setUsername(username);
        stencilhis.setDatetime(datetime);
        stencilhis.setQty(stencilmanage.getCurrentfrequency());

        int operater = stencilhisMapper.insert(stencilhis);
        if(operater < 1){
            UtilityMethod.doRequest(response,Request,200,false,"钢网使用历史插入失败，请重试！");
            return;
        }
        //钢网表设置使用历史id
        stencilmanage.setStencilusedhistid(StencilUSEDID);
        stencilmanage.setLineid(area.getAreaid());
        operater = stencilmanageMapper.updateByPrimaryKey(stencilmanage);
        if(operater < 1 ){
            UtilityMethod.doRequest(response,Request,200,false,"上钢网失败（使用ID插入失败），请重试！");
            return;
        }else {
            msg = upnname+"上钢网成功！"+msg;
            UtilityMethod.doRequest(response,Request,200,true,msg);
        }





    }

    @Override
    public void UnloadGW(JSONObject json, HttpServletResponse response) throws IOException, SQLException {

        JSONObject Request = new JSONObject();

        String line = json.getString("line");
        //String username = json.getString("username");
        String upnname = json.getString("upnname");
        String username = json.getString("worknumber");
        String usedid = json.getString("usedid");

        String msg = "";
        List<String> Lists = new ArrayList<String>();
        /*
        0	Moid
        1	Moname
        2	Taskname
        3	Eqpname
        4	Slot
        5	upnname
        6	Feedername
        7	Username
        8	Datetime
        */

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            UtilityMethod.doRequest(response,Request,200,false,"无法找到用户");
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            UtilityMethod.doRequest(response,Request,200,false,"非规定的可上钢网账号，无法操作！");
            return;
        }

        //检查线体
        Area area = areaMapper.selectByAreaname(line);
        if(area != null && !area.getAreatype().equals("LINE")){
            UtilityMethod.doRequest(response,Request,200,false,"系统找不到扫入的线体，请确认！");
            return;
        }

        //检查UPN
        List<Upn> upninfos = UpnMapper.GetUpnByUpnname(upnname);
        if (upninfos.size() > 0) {
            if(!upninfos.stream().findFirst().get().getUpnname().contains("0000000-")){
                UtilityMethod.doRequest(response,Request,200,false,"扫入的UPN不属于钢网！");
                return;
            }
        } else {
            UtilityMethod.doRequest(response,Request,200,false,"UPN不存在！");
            return;
        }
        Upn upninfo = upninfos.stream().findFirst().get();

        List<Stencilmanage> stencilmanages = stencilmanageMapper.selectByUpnid(upninfo.getUpnid());
        if(stencilmanages.size() == 0){
            UtilityMethod.doRequest(response,Request,200,false,"该UPN不属于钢网！");
            return;
        }else if(stencilmanages.stream().findFirst().get().getStencilusedhistid() == null){
            UtilityMethod.doRequest(response,Request,200,false,"该钢网"+upnname+"未被使用，请确认！");
            return;
        }
        Optional<Stencilhis>  stencilhiss = stencilhisMapper.selectByUsedid(usedid).stream().filter(sh -> sh.getTaskname().equals("LOAD")).findFirst();;
        if(!stencilhiss.isPresent()){
            UtilityMethod.doRequest(response,Request,200,false,"该钢网"+upnname+"未被使用，请确认！");
            return;
        }


        Stencilmanage stencilmanage = stencilmanages.stream().findFirst().get();

        //卸钢网 LOAD
        Stencilhis stencilhis = new Stencilhis();
        String StencilSHID = UtilityMethod.GetUUID();//钢网历史表自己的ID

        stencilhis.setShid(StencilSHID);
        stencilhis.setUsedid(usedid);
        stencilhis.setUpnname(upnname);
        stencilhis.setLine(line);
        stencilhis.setTaskname("UNLOAD");
        stencilhis.setUsername(username);
        stencilhis.setDatetime(datetime);
        stencilhis.setQty(stencilmanage.getCurrentfrequency());

        int operater = stencilhisMapper.insert(stencilhis);
        if(operater < 1){
            UtilityMethod.doRequest(response,Request,200,false,"钢网使用历史插入失败，请重试！");
            return;
        }
        //钢网表设置使用历史id
        stencilmanage.setStencilusedhistid(null);
        stencilmanage.setLineid(null);
        operater = stencilmanageMapper.updateByPrimaryKey(stencilmanage);
        if(operater < 1 ){
            UtilityMethod.doRequest(response,Request,200,false,"卸钢网失败，请重试！");

        }else {

           // Date datetime = new Date();
           // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date datetimefrom = Timestamp.valueOf(sdf.format(stencilhiss.get().getDatetime() ));

            msg = line+" "+ upnname+"卸钢网成功！"+msg+"使用时间："+ datetimefrom + "至 "+datetime+",使用次数："
                    +(stencilmanage.getCurrentfrequency()-stencilhiss.get().getQty()) +" 总使用次数："+stencilmanage.getCurrentfrequency();
            UtilityMethod.doRequest(response,Request,200,true,msg);
        }

    }

    @Override
    public void GetOnloadGW(JSONObject json, HttpServletResponse response) throws IOException, SQLException {

        JSONObject Request = new JSONObject();

        String line = json.getString("line");
        //String username = json.getString("username");
        String upnname = json.getString("upnname");
        String username = json.getString("worknumber");

        String msg = "";
        List<String> Lists = new ArrayList<String>();
        /*
        0	Moid
        1	Moname
        2	Taskname
        3	Eqpname
        4	Slot
        5	upnname
        6	Feedername
        7	Username
        8	Datetime
        */

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            UtilityMethod.doRequest(response,Request,200,false,"无法找到用户");
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            UtilityMethod.doRequest(response,Request,200,false,"非规定的可上钢网账号，无法操作！");
            return;
        }

        //检查线体
        Area area = areaMapper.selectByAreaname(line);
        if(area == null || !area.getAreatype().equals("LINE")){
            UtilityMethod.doRequest(response,Request,200,false,"系统找不到扫入的线体，请确认！");
            return;
        }


        List<Map<String, Object>> stencil =  materialModuleMapper.GetOnloadGW(line);

        if(stencil !=null ){
            msg = "线体："+line+" 钢网："+stencil.get(0).get("UPNNAME")+" 截至"+datetime+"总使用次数："+stencil.get(0).get("CURRENTFREQUENCY");
            Request.put("usedid",stencil.get(0).get("USEDID"));
            Request.put("upnname",stencil.get(0).get("UPNNAME"));
            Request.put("line",stencil.get(0).get("LINE"));

            UtilityMethod.doRequest(response,Request,200,true,msg);
        }


    }
    @Override
    public void ComfirmParts2(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String username = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String slot = json.getString("slotname");
        String feedername = json.getString("feeder");
        List<String> Lists = new ArrayList<String>();


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA对料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可对料账号，无法对料！");
            response.getWriter().print(Request);
            return;
        }



        List<Upn> upninfos = UpnMapper.GetUpnByUpnname(upnname);
        if (upninfos.size() > 0) {
            Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfos.stream().findFirst().get().getPnid());
            String orgpnMessage = validateOrgpn(json, partnumber);
            if (orgpnMessage != null) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", orgpnMessage);
                response.getWriter().print(Request);
                return;
            }
            List<Feeder> feeder = FeederMapper.GetFeederByFeedername(feedername);
            if(feeder.size() < 1){
                String message ="错误：对料，飞达不存在！";//错误原因
                Lists.add(0,moid);
                Lists.add(1,moname);
                Lists.add(2,message);
                Lists.add(3,eqpname);
                Lists.add(4,slot);
                Lists.add(5,upnname);
                Lists.add(6,"/");
                Lists.add(7,username);
                Lists.add(8,sdf.format(datetime));
                InsertMaterialhistory(Lists);
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "对料失败，飞达不存在！");
                response.getWriter().print(Request);
            }
            if (UpnComfirmParts2(moid, eqpname, slot, upnname,feedername)) {
                Upn upninfo = upninfos.stream().findFirst().get();

                List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                List<Loadmaterial> loadmaterials1 = loadmaterials.stream()
                        .filter(loadmaterial1 -> loadmaterial1.getFeeder() != null && loadmaterial1.getFeeder().equals(feedername))
                        .collect(Collectors.toList());
                //更新
                Loadmaterial loadmaterial;
                List<Loadmaterial> loadmaterialsToConfirm;
                if(loadmaterials1.size()>0){
                    loadmaterial= loadmaterials1.stream().findFirst().get();
                    loadmaterialsToConfirm = loadmaterials1;
                }else {
                    loadmaterial = loadmaterials.stream().findFirst().get();
                    loadmaterialsToConfirm = Collections.singletonList(loadmaterial);
                }
                for (Loadmaterial loadmaterialToConfirm : loadmaterialsToConfirm) {
                    loadmaterialToConfirm.setTaskname("ComfirmParts");
                    loadmaterialToConfirm.setFeeder(feedername);
                    LoadmaterialMapper.updateByPrimaryKey(loadmaterialToConfirm);
                }


                //插入记录


                Materialhistory materialhistory = new Materialhistory();
                materialhistory.setMhid(UtilityMethod.GetUUID());
                materialhistory.setMoid(moid);
                materialhistory.setMoname(moname);
                materialhistory.setTaskname("ComfirmParts");
                materialhistory.setEqpname(eqpname);
                materialhistory.setSlot(slot);
                materialhistory.setPn(loadmaterial.getPn());
                materialhistory.setQty(loadmaterial.getQty());
                materialhistory.setBoardside(loadmaterial.getBoardside());
                materialhistory.setUpnname(upnname);
                materialhistory.setUpnqty(upninfo.getRemainingqty());
                materialhistory.setFeedername(feeder.stream().findFirst().get().getFeedername());
                materialhistory.setUsername(username);
                materialhistory.setDatetime(sdf.format(datetime));
                MaterialhistoryMapper.insert(materialhistory);

                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "槽位：" + slot + "，对料完成，请继续！");
                response.getWriter().print(Request);


            } else {

                if(UpnComfirmParts(moid, eqpname, slot, upnname)){
                    //List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                    //Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                    String message ="错误：对料，飞达不匹配";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,"/");
                    Lists.add(7,username);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "对料失败，飞达不匹配！");
                    response.getWriter().print(Request);
                }else {
                    //List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                    //Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                    String message ="错误：对料，当前UPN与当前槽位UPN不匹配";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,"/");
                    Lists.add(7,username);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "对料失败，当前UPN与当前槽位UPN不匹配！");
                    response.getWriter().print(Request);
                }


            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }

    @Override
    public void ComfirmParts(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String username = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String slot = json.getString("slotname");
       // String feeder1 = json.getString("feeder");
        List<String> Lists = new ArrayList<String>();


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA对料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可对料账号，无法对料！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfos = UpnMapper.GetUpnByUpnname(upnname);
        if (upninfos.size() > 0) {
            if (UpnComfirmParts(moid, eqpname, slot, upnname)) {
                Upn upninfo = upninfos.stream().findFirst().get();
                Feeder feeder = FeederMapper.selectByPrimaryKey(upninfo.getFeederid());
                Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
                List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                Loadmaterial loadmaterial = loadmaterials.stream().findFirst().get();
                //更新
                loadmaterial.setTaskname("ComfirmParts");
                int updateLoadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);


                //插入记录


                Materialhistory materialhistory = new Materialhistory();
                materialhistory.setMhid(UtilityMethod.GetUUID());
                materialhistory.setMoid(moid);
                materialhistory.setMoname(moname);
                materialhistory.setTaskname("ComfirmParts");
                materialhistory.setEqpname(eqpname);
                materialhistory.setSlot(slot);
                materialhistory.setPn(loadmaterial.getPn());
                materialhistory.setQty(loadmaterial.getQty());
                materialhistory.setBoardside(loadmaterial.getBoardside());
                materialhistory.setUpnname(upnname);
                materialhistory.setUpnqty(upninfo.getRemainingqty());
                materialhistory.setFeedername(feeder.getFeedername());
                materialhistory.setUsername(username);
                materialhistory.setDatetime(sdf.format(datetime));
                int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);

                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "槽位：" + slot + "，对料完成，请继续！");
                response.getWriter().print(Request);


            } else {
                List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                String message ="错误：对料，当前UPN与当前槽位UPN不匹配";//错误原因
                Lists.add(0,moid);
                Lists.add(1,moname);
                Lists.add(2,message);
                Lists.add(3,eqpname);
                Lists.add(4,slot);
                Lists.add(5,upnname);
                Lists.add(6,"/");
                Lists.add(7,username);
                Lists.add(8,sdf.format(datetime));
                InsertMaterialhistory(Lists);
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "对料失败，当前UPN与当前槽位UPN不匹配！");
                response.getWriter().print(Request);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }


    @Override
    public void CheckParts(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String username = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<String>();

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        //System.out.println("IN");
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可检查物料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfos = UpnMapper.GetUpnByUpnname(upnname);
        if (upninfos.size() > 0) {
            if (UpnComfirmParts(moid, eqpname, slot, upnname)) {
                Upn upninfo = upninfos.stream().findFirst().get();
                Feeder feeder = FeederMapper.selectByPrimaryKey(upninfo.getFeederid());
                Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
                List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                Loadmaterial loadmaterial = loadmaterials.stream().findFirst().get();
                //更新
                //loadmaterial.setTaskname("CheckParts");
                //int updateLoadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);


                //插入记录


                Materialhistory materialhistory = new Materialhistory();
                materialhistory.setMhid(UtilityMethod.GetUUID());
                materialhistory.setMoid(moid);
                materialhistory.setMoname(moname);
                materialhistory.setTaskname("CheckParts");
                materialhistory.setEqpname(eqpname);
                materialhistory.setSlot(slot);
                materialhistory.setPn(loadmaterial.getPn());
                materialhistory.setQty(loadmaterial.getQty());
                materialhistory.setBoardside(loadmaterial.getBoardside());
                materialhistory.setUpnname(upnname);
                materialhistory.setUpnqty(upninfo.getRemainingqty());
                materialhistory.setFeedername(feeder.getFeedername());
                materialhistory.setUsername(username);
                materialhistory.setDatetime(sdf.format(datetime));
                int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);

                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "槽位：" + slot + "，检查完成，请继续！");
                response.getWriter().print(Request);

            } else {
               // List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);

                if(UpnComfirmParts(moid, eqpname, slot, upnname)){
                    List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                    Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                    String message ="错误：物料检查，飞达不匹配";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,"/");
                    Lists.add(7,username);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "物料检查失败，飞达不匹配！");
                    response.getWriter().print(Request);
                }else {
                    List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                    Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                    String message ="错误：物料检查，当前UPN与当前槽位UPN不匹配";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,"/");
                    Lists.add(7,username);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "物料检查失败，当前UPN与当前槽位UPN不匹配！");
                    response.getWriter().print(Request);
                }
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }

    @Override
    public void CheckParts2(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String username = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String slot = json.getString("slotname");
        String feedername = json.getString("feeder");
        List<String> Lists = new ArrayList<String>();

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        //System.out.println("IN");
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可检查物料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfos = UpnMapper.GetUpnByUpnname(upnname);
        if (upninfos.size() > 0) {
            Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfos.stream().findFirst().get().getPnid());
            String orgpnMessage = validateOrgpn(json, partnumber);
            if (orgpnMessage != null) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", orgpnMessage);
                response.getWriter().print(Request);
                return;
            }
            List<Feeder> feeder = FeederMapper.GetFeederByFeedername(feedername);
            if(feeder.size() == 0){
               // List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
               // Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                String message ="错误：物料检查，飞达不存在！";//错误原因
                Lists.add(0,moid);
                Lists.add(1,moname);
                Lists.add(2,message);
                Lists.add(3,eqpname);
                Lists.add(4,slot);
                Lists.add(5,upnname);
                Lists.add(6,"/");
                Lists.add(7,username);
                Lists.add(8,sdf.format(datetime));
                InsertMaterialhistory(Lists);
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "物料检查失败，飞达不存在！");
                response.getWriter().print(Request);
                return;
            }
            if (UpnComfirmParts2(moid, eqpname, slot, upnname, feedername)) {
                Upn upninfo = upninfos.stream().findFirst().get();

                List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                Loadmaterial loadmaterial = loadmaterials.stream().findFirst().get();



                //插入记录


                Materialhistory materialhistory = new Materialhistory();
                materialhistory.setMhid(UtilityMethod.GetUUID());
                materialhistory.setMoid(moid);
                materialhistory.setMoname(moname);
                materialhistory.setTaskname("CheckParts");
                materialhistory.setEqpname(eqpname);
                materialhistory.setSlot(slot);
                materialhistory.setPn(loadmaterial.getPn());
                materialhistory.setQty(loadmaterial.getQty());
                materialhistory.setBoardside(loadmaterial.getBoardside());
                materialhistory.setUpnname(upnname);
                materialhistory.setUpnqty(upninfo.getRemainingqty());
                materialhistory.setFeedername(feeder.stream().findFirst().get().getFeedername());
                materialhistory.setUsername(username);
                materialhistory.setDatetime(sdf.format(datetime));
                MaterialhistoryMapper.insert(materialhistory);

                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "槽位：" + slot + "，检查完成，请继续！");
                response.getWriter().print(Request);

            } else {
                //List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);

                //Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                String message ="错误：物料检查，当前UPN与槽位或飞达不匹配";//错误原因
                Lists.add(0,moid);
                Lists.add(1,moname);
                Lists.add(2,message);
                Lists.add(3,eqpname);
                Lists.add(4,slot);
                Lists.add(5,upnname);
                Lists.add(6,"");
                Lists.add(7,username);
                Lists.add(8,sdf.format(datetime));
                InsertMaterialhistory(Lists);

                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "失败，当前UPN与槽位或飞达不匹配！");
                response.getWriter().print(Request);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }
    @Override
    public void ComfirmPartsNew(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String slot = json.getString("slotname");
        String orgpn = json.getString("orgpn");


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Upn> upninfos = UpnMapper.GetUpnByUpnname(upnname);
        if (upninfos.size() > 0) {
            if (UpnComfirmParts(moid, eqpname, slot, upnname)) {
                Upn upninfo = upninfos.stream().findFirst().get();
                Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.getPnid());
                if(!partnumber.getPartname().contains(orgpn)){
                    //List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "对料失败，当前UPN与原厂标签的料号不匹配！");
                    response.getWriter().print(Request);
                    return;
                }
                Feeder feeder = FeederMapper.selectByPrimaryKey(upninfo.getFeederid());
                Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
                List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                Loadmaterial loadmaterial = loadmaterials.stream().findFirst().get();
                //更新
                loadmaterial.setTaskname("ComfirmParts");
                int updateLoadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);


                //插入记录


                Materialhistory materialhistory = new Materialhistory();
                materialhistory.setMhid(UtilityMethod.GetUUID());
                materialhistory.setMoid(moid);
                materialhistory.setMoname(moname);
                materialhistory.setTaskname("ComfirmParts");
                materialhistory.setEqpname(eqpname);
                materialhistory.setSlot(slot);
                materialhistory.setPn(loadmaterial.getPn());
                materialhistory.setQty(loadmaterial.getQty());
                materialhistory.setBoardside(loadmaterial.getBoardside());
                materialhistory.setUpnname(upnname);
                materialhistory.setUpnqty(upninfo.getRemainingqty());
                materialhistory.setFeedername(feeder.getFeedername());
                materialhistory.setUsername(worknumber);
                materialhistory.setDatetime(sdf.format(datetime));
                int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);

                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "槽位：" + slot + "，对料完成，请继续！");
                response.getWriter().print(Request);


            } else {
                List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "对料失败，当前UPN与当前槽位UPN不匹配！");
                response.getWriter().print(Request);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }


    //续料+校验AOI生产数
    @Override
    public void ReplenishFeeders(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = "";
        String oldupnname = json.getString("oldupnname");
        String newupnname = json.getString("newupnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<String>();


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }


        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
        if (loadmaterials.size() > 0) {
            if (isDuplicateReplenishSubmit(loadmaterials, moid, eqpname, slot, feeder, oldupnname, newupnname)) {
                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "槽位：" + slot + "，续料已完成，请勿重复提交！");
                response.getWriter().print(Request);
                return;
            }
            List<Loadmaterial> loadmaterials1 = loadmaterials.stream().filter(loadmaterial -> loadmaterial.getFeeder()!=null && loadmaterial.getFeeder().equals(feeder)).collect(Collectors.toList());
            if(loadmaterials1.size() > 0){
                if(!loadmaterials.stream().allMatch(loadmaterial ->loadmaterial.getTaskname() !=null &&  loadmaterial.getTaskname().equals("ComfirmParts"))){
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "当前槽位、飞达未做对料，请先对料！");
                    response.getWriter().print(Request);
                    return;
                }
            }else if (!loadmaterials.stream().allMatch(loadmaterial -> loadmaterial.getTaskname() !=null && loadmaterial.getTaskname().equals("ComfirmParts"))) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "当前槽位未做对料，请先对料！");
                response.getWriter().print(Request);
                return;
            }

        } else {
            Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
            String message ="错误：续料，可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,upnname);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
            response.getWriter().print(Request);
            return;
        }

        Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
        List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);
        if (!(checkupn.size() > 0)) {
            String message ="错误：续料，可能原因：上料任务与槽位不匹配";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,upnname);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "上料任务与槽位不匹配！");
            response.getWriter().print(Request);
            return;
        }




        if (checkupn.stream().noneMatch(upn -> upn.getUpnname().equals(oldupnname))) {
            String message ="错误：续料，扫入的旧UPN不是目前上料的UPN";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,oldupnname);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的旧UPN不是目前上料的UPN！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(newupnname);
        List<Upn> oldupninfo = UpnMapper.GetUpnByUpnname(oldupnname);


        //System.out.println("IN");

        //List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);

        if (upninfo.size() > 0) {
            if (upninfo.stream().anyMatch(upn -> !upn.getState().equals("ACTIVE"))) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "新UPN状态不可用");
                response.getWriter().print(Request);
                return;
            }
            Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
            String orgpnMessage = validateOrgpn(json, partnumber);
            if (orgpnMessage != null) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", orgpnMessage);
                response.getWriter().print(Request);
                return;
            }
            String pn = partnumber.getPn();
            String upn_smt = "732D4EE6E2C046A9936378840989A365";

            Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
            Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder0.getLotid());
            List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());
            if (loadinglistcontents.size() < 1) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "找不到站位表");
                response.getWriter().print(Request);
                return;
            } else {
                loadinglistcontents = loadinglistcontents.stream().filter(loadinglistcontent ->loadinglistcontent.getPn()!=null&& loadinglistcontent.getPn().equals(pn) || loadinglistcontent.getAlternatepn().equals(pn))
                        .filter(loadinglistcontent -> loadinglistcontent.getSlot()!=null&&loadinglistcontent.getSlot().equals(slot))
                        .collect(Collectors.toList());
                if (loadinglistcontents.size() < 1) {
                    String message ="错误：续料，新UPN与站位表中的物料不匹配";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,feeder);
                    Lists.add(7,worknumber);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "新UPN与站位表中的物料不匹配！");
                    response.getWriter().print(Request);
                    return;
                }else if(loadinglistcontents.stream()
                        .filter(loadinglistcontent -> loadinglistcontent.getEqpname()!=null&&loadinglistcontent.getEqpname().equals(eqpname))
                        .collect(Collectors.toList()).size() < 1){
                    String message ="错误：续料，新UPN与站位表中的物料不匹配(设备不匹配)";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,feeder);
                    Lists.add(7,worknumber);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "新UPN与站位表中的物料不匹配(设备不匹配)！");
                    response.getWriter().print(Request);
                    return;
                }
            }


            if (upninfo.size() > 0 && upninfo.stream().anyMatch(upn -> upn.getState().equals("ACTIVE"))) {

                if (upninfo.stream().anyMatch(upn -> upn.getCurrentstepid().equals(upn_smt))) {
                    //检查是否为发料UPN
                    List<Rmm_picklist> rmm_picklists = rmm_picklistMapper.selectByUpn(newupnname);
                    if(rmm_picklists.size()>0){
                        if(!hasMatchingIssuedWorkorderProduct(rmm_picklists, prp_lot.getProductpn())){
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN发料的成品料号与当前上料任务的成品料号不匹配！");
                            response.getWriter().print(Request);
                            return;
                        }
                    }else {
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "此UPN:" + newupnname + "未发料到工单！");
                        response.getWriter().print(Request);
                        return;
                    }

                    //List<Rmm_picklist> rmm_picklists = materialModuleMapper.Rmm_picklistsGetByPnAndLot(prp_lot.getWorkorderid(),prp_lot.getLotid(),pn);

                    //if(rmm_picklists.size()>0){
                    //  if(rmm_picklists.stream().anyMatch(rmm_picklist -> rmm_picklist.getUpn().equals(newupnname))){
                    if (upninfo.stream().anyMatch(upn -> upn.getMoid() == null)) {//是否有绑定上料任务
                        if (upninfo.stream().anyMatch(upn -> upn.getEqpname() == null)) {//是否有绑定设备
                            if (upninfo.stream().anyMatch(upn -> upn.getFeederid() == null)) {//是否有绑定飞达
                                if (upninfo.stream().anyMatch(upn -> upn.getSlot() == null)) {//是否有绑定槽位
                                    //开始检查传输过来的数据有无问题
                                    //moid、eqpname、upn、slot在前面已检查
                                    List<Feeder> feederinfo = FeederMapper.GetFeederByFeedername(feeder);
                                    if (feederinfo.size() > 0) {//是否有这个飞达
                                        List<Upn> upnfeeder = UpnMapper.GetUpnByFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                        if (upnfeeder.size() > 0 && !upnfeeder.stream().findFirst().get().getUpnname().equals(oldupnname)) {
                                            String message ="错误：续料，飞达已绑定到其他UPN"+ upnfeeder.stream().findFirst().get().getUpnname() ;//错误原因
                                            Lists.add(0,moid);
                                            Lists.add(1,moname);
                                            Lists.add(2,message);
                                            Lists.add(3,eqpname);
                                            Lists.add(4,slot);
                                            Lists.add(5,upnname);
                                            Lists.add(6,feeder);
                                            Lists.add(7,worknumber);
                                            Lists.add(8,sdf.format(datetime));
                                            InsertMaterialhistory(Lists);
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "该飞达已绑定到其他UPN：" + upnfeeder.stream().findFirst().get().getUpnname() + "上！");
                                            response.getWriter().print(Request);
                                            return;
                                        }
                                        List<Eqp> eqpinfo = EqpMapper.GetEqpbyEqpname(eqpname);
                                        //设备与飞达是否匹配
                                        if (eqpinfo.stream().findFirst().get().getEqptypeid().equals(feederinfo.stream().findFirst().get().getEqptypeid())) {
                                            //插入记录

                                            Upn upn = upninfo.stream().findFirst().get();
                                            Upn oldupn = oldupninfo.stream().findFirst().get();


                                            List<Loadmaterial> loadmaterialsS = LoadmaterialMapper.LoadMaterialGetByEqpAndSlotAndTaskname(moid, eqpname, slot, "ComfirmParts");
                                            Loadmaterial loadmaterial = null;
                                            if(loadmaterialsS.stream().anyMatch(ls->ls.getFeeder()!=null&& ls.getFeeder().equals(feeder))){
                                                loadmaterial = loadmaterialsS.stream().filter(loadmaterial1 -> loadmaterial1.getFeeder()!=null&&loadmaterial1.getFeeder().equals(feeder)).findFirst().get();
                                            }else{
                                                Feeder feederold = FeederMapper.selectByPrimaryKey(oldupn.getFeederid());
                                                if(feederold != null && feederold.getFeedername()!=null&&loadmaterialsS.stream().anyMatch(ls->ls.getFeeder()!=null&&ls.getFeeder().equals(feederold.getFeedername()))){
                                                    loadmaterial  = loadmaterialsS.stream().filter(loadmaterial1 -> loadmaterial1.getFeeder()!=null&&loadmaterial1.getFeeder().equals(feederold.getFeedername())).findFirst().get();
                                                }else {
                                                    loadmaterial  = loadmaterialsS.stream().findFirst().get();
                                                }

                                            }

                                            //if(loadmaterial.)

                                            //插入记录
                                            Materialhistory materialhistoryold = new Materialhistory();
                                            materialhistoryold.setMhid(UtilityMethod.GetUUID());
                                            materialhistoryold.setMoid(moid);
                                            materialhistoryold.setMoname(moname);
                                            materialhistoryold.setTaskname("UnloadParts");
                                            materialhistoryold.setEqpname(eqpname);
                                            materialhistoryold.setSlot(slot);
                                            materialhistoryold.setPn(pn);
                                            materialhistoryold.setQty(oldupn.getRemainingqty());
                                            materialhistoryold.setBoardside(loadmaterial.getBoardside());
                                            materialhistoryold.setUpnname(oldupnname);
                                            materialhistoryold.setUpnqty(oldupn.getRemainingqty());
                                            materialhistoryold.setFeedername(feeder);
                                            materialhistoryold.setUsername(worknumber);
                                            materialhistoryold.setDatetime(sdf.format(datetime));
                                            int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);

                                            Materialhistory materialhistoryNew = new Materialhistory();
                                            materialhistoryNew.setMhid(UtilityMethod.GetUUID());
                                            materialhistoryNew.setMoid(moid);
                                            materialhistoryNew.setMoname(moname);
                                            materialhistoryNew.setTaskname("ReplenishFeeders");
                                            materialhistoryNew.setEqpname(eqpname);
                                            materialhistoryNew.setSlot(slot);
                                            materialhistoryNew.setPn(pn);
                                            materialhistoryNew.setQty(upn.getRemainingqty());
                                            materialhistoryNew.setBoardside(loadmaterial.getBoardside());
                                            materialhistoryNew.setUpnname(newupnname);
                                            materialhistoryNew.setUpnqty(upn.getRemainingqty());
                                            materialhistoryNew.setFeedername(feeder);
                                            materialhistoryNew.setUsername(worknumber);
                                            materialhistoryNew.setDatetime(sdf.format(datetime));
                                            int insertMaterialhistoryNew = MaterialhistoryMapper.insert(materialhistoryNew);


                                            //更新UPN信息 续料的逻辑 旧UPN清空moid、feerderid、eqpname、slot
                                            upn.setEqpname(eqpname);
                                            upn.setFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                            upn.setSlot(slot);
                                            upn.setMoid(moid);
                                            upn.setObj05("PDA续料");
                                            if (oldupn.getObj06() != null) {
                                                upn.setObj06((upn.getRemainingqty().add(new BigDecimal(oldupn.getObj06())) ) + "");
                                            } else {
                                                upn.setObj06(oldupn.getRemainingqty().toString());
                                            }
                                            upn.setRemainingqty(upn.getRemainingqty().add(oldupn.getRemainingqty()));

                                            int updateUpn = UpnMapper.updateByPrimaryKey(upn);

                                            oldupn.setEqpname(null);
                                            oldupn.setMoid(null);
                                            oldupn.setFeederid(null);
                                            oldupn.setSlot(null);
                                            oldupn.setRemainingqty(new BigDecimal(0)  );
                                            int updateOldUpn = UpnMapper.updateByPrimaryKey(oldupn);

                                            loadmaterial.setTaskname("ReplenishFeeders");
                                            loadmaterial.setFeeder(feeder);
                                            int updateLoadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);

                                            Request.put("code", 200);
                                            Request.put("status", true);
                                            Request.put("message", "槽位：" + slot + "，续料成功！");
                                            response.getWriter().print(Request);
                                            materialModuleMapper.A03_SHIMIN_SMT("PDA续料",newupnname,moid,materialorderinfo.getLineid(),oldupnname,"",worknumber);
                                        } else {
                                            String message ="错误：续料，设备：" + eqpname + "与飞达：" + feeder + "不匹配";//错误原因
                                            Lists.add(0,moid);
                                            Lists.add(1,moname);
                                            Lists.add(2,message);
                                            Lists.add(3,eqpname);
                                            Lists.add(4,slot);
                                            Lists.add(5,upnname);
                                            Lists.add(6,feeder);
                                            Lists.add(7,worknumber);
                                            Lists.add(8,sdf.format(datetime));
                                            InsertMaterialhistory(Lists);
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "该设备：" + eqpname + "与该飞达：" + feeder + "不匹配！");
                                            response.getWriter().print(Request);
                                        }
                                    } else {
                                        Request.put("code", 200);
                                        Request.put("status", false);
                                        Request.put("message", "找不到飞达！");
                                        response.getWriter().print(Request);
                                    }

                                } else {

                                    Request.put("code", 200);
                                    Request.put("status", false);
                                    Request.put("message", "该UPN已与槽位" + slot + "绑定！");
                                    response.getWriter().print(Request);
                                }
                            } else {
                                Feeder feederinfo = FeederMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getFeederid());
                                String message ="错误：续料，UPN已与飞达" + feederinfo.getFeedername() + "绑定";//错误原因
                                Lists.add(0,moid);
                                Lists.add(1,moname);
                                Lists.add(2,message);
                                Lists.add(3,eqpname);
                                Lists.add(4,slot);
                                Lists.add(5,upnname);
                                Lists.add(6,feederinfo.getFeedername());
                                Lists.add(7,worknumber);
                                Lists.add(8,sdf.format(datetime));
                                InsertMaterialhistory(Lists);
                                Request.put("code", 200);
                                Request.put("status", false);
                                Request.put("message", "该UPN已与飞达" + feederinfo.getFeedername() + "绑定！");
                                response.getWriter().print(Request);
                            }
                        } else {
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN已与飞达" + upninfo.stream().findFirst().get().getEqpname() + "绑定！");
                            response.getWriter().print(Request);
                        }


                    } else {

                        //Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                        String message ="错误：续料，UPN已与上料任务" + materialorderinfo.getMoname() + "绑定";//错误原因
                        Lists.add(0,moid);
                        Lists.add(1,moname);
                        Lists.add(2,message);
                        Lists.add(3,eqpname);
                        Lists.add(4,slot);
                        Lists.add(5,upnname);
                        Lists.add(6,feeder);
                        Lists.add(7,worknumber);
                        Lists.add(8,sdf.format(datetime));
                        InsertMaterialhistory(Lists);
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "该UPN已与上料任务" + materialorderinfo.getMoname() + "绑定！");
                        response.getWriter().print(Request);
                    }
                          /*  }
                            else {
                                Request.put("code",200);
                                Request.put("status",false);
                                Request.put("message","此UPN未发料，请确认");
                                response.getWriter().print(Request);
                            }*/


                        /*}else {
                            Request.put("code",200);
                            Request.put("status",false);
                            Request.put("message","此批次/工单未发料，请确认");
                            response.getWriter().print(Request);
                        }*/

                } else {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "此UPN:" + newupnname + "未从仓库发料！");
                    response.getWriter().print(Request);
                }

            } else {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "该UPN不可用！");
                response.getWriter().print(Request);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }
//        }else {
//            Request.put("code",200);
//            Request.put("status",false);
//            Request.put("message","失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
//            response.getWriter().print(Request);
//            return;
//        }

    }

    //续料+校验AOI生产数
    @Override
    public void ReplenishFeedersCheckAoi(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = "";
        String oldupnname = json.getString("oldupnname");
        String newupnname = json.getString("newupnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<String>();


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }


        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
        if (loadmaterials.size() > 0) {
            if (isDuplicateReplenishSubmit(loadmaterials, moid, eqpname, slot, feeder, oldupnname, newupnname)) {
                Request.put("code", 200);
                Request.put("status", true);
                Request.put("message", "槽位：" + slot + "，续料已完成，请勿重复提交！");
                response.getWriter().print(Request);
                return;
            }
            List<Loadmaterial> loadmaterials1 = loadmaterials.stream().filter(loadmaterial -> loadmaterial.getFeeder()!=null && loadmaterial.getFeeder().equals(feeder)).collect(Collectors.toList());
            if(loadmaterials1.size() > 0){
                if(!loadmaterials.stream().allMatch(loadmaterial ->loadmaterial.getTaskname() !=null &&  loadmaterial.getTaskname().equals("ComfirmParts"))){
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "当前槽位、飞达未做对料，请先对料！");
                    response.getWriter().print(Request);
                    return;
                }
            }else if (!loadmaterials.stream().allMatch(loadmaterial -> loadmaterial.getTaskname() !=null && loadmaterial.getTaskname().equals("ComfirmParts"))) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "当前槽位未做对料，请先对料！");
                response.getWriter().print(Request);
                return;
            }

        } else {
            Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
            String message ="错误：续料，可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,upnname);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
            response.getWriter().print(Request);
            return;
        }

        Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
        List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);
        if (!(checkupn.size() > 0)) {
            String message ="错误：续料，可能原因：上料任务与槽位不匹配";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,upnname);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "上料任务与槽位不匹配！");
            response.getWriter().print(Request);
            return;
        }




        if (checkupn.stream().noneMatch(upn -> upn.getUpnname().equals(oldupnname))) {
            String message ="错误：续料，扫入的旧UPN不是目前上料的UPN";//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,oldupnname);
            Lists.add(6,feeder);
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的旧UPN不是目前上料的UPN！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(newupnname);
        List<Upn> oldupninfo = UpnMapper.GetUpnByUpnname(oldupnname);


        //System.out.println("IN");

        //List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);

        if (upninfo.size() > 0) {
            if (upninfo.stream().anyMatch(upn -> !upn.getState().equals("ACTIVE"))) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "新UPN状态不可用");
                response.getWriter().print(Request);
                return;
            }
            Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
            String orgpnMessage = validateOrgpn(json, partnumber);
            if (orgpnMessage != null) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", orgpnMessage);
                response.getWriter().print(Request);
                return;
            }
            String pn = partnumber.getPn();
            String upn_smt = "732D4EE6E2C046A9936378840989A365";

            Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
            Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder0.getLotid());
            List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());
            if (loadinglistcontents.size() < 1) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "找不到站位表");
                response.getWriter().print(Request);
                return;
            } else {
                loadinglistcontents = loadinglistcontents.stream().filter(loadinglistcontent ->loadinglistcontent.getPn()!=null&& loadinglistcontent.getPn().equals(pn) || loadinglistcontent.getAlternatepn().equals(pn))
                        .filter(loadinglistcontent -> loadinglistcontent.getSlot()!=null&&loadinglistcontent.getSlot().equals(slot))
                        .collect(Collectors.toList());
                if (loadinglistcontents.size() < 1) {
                    String message ="错误：续料，新UPN与站位表中的物料不匹配";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,feeder);
                    Lists.add(7,worknumber);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "新UPN与站位表中的物料不匹配！");
                    response.getWriter().print(Request);
                    return;
                }else if(loadinglistcontents.stream()
                        .filter(loadinglistcontent -> loadinglistcontent.getEqpname()!=null&&loadinglistcontent.getEqpname().equals(eqpname))
                        .collect(Collectors.toList()).size() < 1){
                    String message ="错误：续料，新UPN与站位表中的物料不匹配(设备不匹配)";//错误原因
                    Lists.add(0,moid);
                    Lists.add(1,moname);
                    Lists.add(2,message);
                    Lists.add(3,eqpname);
                    Lists.add(4,slot);
                    Lists.add(5,upnname);
                    Lists.add(6,feeder);
                    Lists.add(7,worknumber);
                    Lists.add(8,sdf.format(datetime));
                    InsertMaterialhistory(Lists);
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "新UPN与站位表中的物料不匹配(设备不匹配)！");
                    response.getWriter().print(Request);
                    return;
                }
            }


            if (upninfo.size() > 0 && upninfo.stream().anyMatch(upn -> upn.getState().equals("ACTIVE"))) {

                if (upninfo.stream().anyMatch(upn -> upn.getCurrentstepid().equals(upn_smt))) {
                    //检查是否为发料UPN
                    List<Rmm_picklist> rmm_picklists = rmm_picklistMapper.selectByUpn(newupnname);
                    if(rmm_picklists.size()>0){
                        if(!hasMatchingIssuedWorkorderProduct(rmm_picklists, prp_lot.getProductpn())){
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN发料的成品料号与当前上料任务的成品料号不匹配！");
                            response.getWriter().print(Request);
                            return;
                        }
                    }else {
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "此UPN:" + newupnname + "未发料到工单！");
                        response.getWriter().print(Request);
                        return;
                    }

                    //List<Rmm_picklist> rmm_picklists = materialModuleMapper.Rmm_picklistsGetByPnAndLot(prp_lot.getWorkorderid(),prp_lot.getLotid(),pn);

                    //if(rmm_picklists.size()>0){
                    //  if(rmm_picklists.stream().anyMatch(rmm_picklist -> rmm_picklist.getUpn().equals(newupnname))){
                    if (upninfo.stream().anyMatch(upn -> upn.getMoid() == null)) {//是否有绑定上料任务
                        if (upninfo.stream().anyMatch(upn -> upn.getEqpname() == null)) {//是否有绑定设备
                            if (upninfo.stream().anyMatch(upn -> upn.getFeederid() == null)) {//是否有绑定飞达
                                if (upninfo.stream().anyMatch(upn -> upn.getSlot() == null)) {//是否有绑定槽位
                                    //开始检查传输过来的数据有无问题
                                    //moid、eqpname、upn、slot在前面已检查
                                    List<Feeder> feederinfo = FeederMapper.GetFeederByFeedername(feeder);
                                    if (feederinfo.size() > 0) {//是否有这个飞达
                                        List<Upn> upnfeeder = UpnMapper.GetUpnByFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                        if (upnfeeder.size() > 0 && !upnfeeder.stream().findFirst().get().getUpnname().equals(oldupnname)) {
                                            String message ="错误：续料，飞达已绑定到其他UPN"+ upnfeeder.stream().findFirst().get().getUpnname() ;//错误原因
                                            Lists.add(0,moid);
                                            Lists.add(1,moname);
                                            Lists.add(2,message);
                                            Lists.add(3,eqpname);
                                            Lists.add(4,slot);
                                            Lists.add(5,upnname);
                                            Lists.add(6,feeder);
                                            Lists.add(7,worknumber);
                                            Lists.add(8,sdf.format(datetime));
                                            InsertMaterialhistory(Lists);
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "该飞达已绑定到其他UPN：" + upnfeeder.stream().findFirst().get().getUpnname() + "上！");
                                            response.getWriter().print(Request);
                                            return;
                                        }
                                        List<Eqp> eqpinfo = EqpMapper.GetEqpbyEqpname(eqpname);
                                        //设备与飞达是否匹配
                                        if (eqpinfo.stream().findFirst().get().getEqptypeid().equals(feederinfo.stream().findFirst().get().getEqptypeid())) {
                                            //插入记录

                                            Upn upn = upninfo.stream().findFirst().get();
                                            Upn oldupn = oldupninfo.stream().findFirst().get();


                                            List<Loadmaterial> loadmaterialsS = LoadmaterialMapper.LoadMaterialGetByEqpAndSlotAndTaskname(moid, eqpname, slot, "ComfirmParts");
                                            Loadmaterial loadmaterial = null;
                                            if(loadmaterialsS.stream().anyMatch(ls->ls.getFeeder()!=null&& ls.getFeeder().equals(feeder))){
                                                loadmaterial = loadmaterialsS.stream().filter(loadmaterial1 -> loadmaterial1.getFeeder()!=null&&loadmaterial1.getFeeder().equals(feeder)).findFirst().get();
                                            }else{
                                                Feeder feederold = FeederMapper.selectByPrimaryKey(oldupn.getFeederid());
                                                if(feederold != null && feederold.getFeedername()!=null&&loadmaterialsS.stream().anyMatch(ls->ls.getFeeder()!=null&&ls.getFeeder().equals(feederold.getFeedername()))){
                                                    loadmaterial  = loadmaterialsS.stream().filter(loadmaterial1 -> loadmaterial1.getFeeder()!=null&&loadmaterial1.getFeeder().equals(feederold.getFeedername())).findFirst().get();
                                                }else {
                                                    loadmaterial  = loadmaterialsS.stream().findFirst().get();
                                                }

                                            }

                                            //if(loadmaterial.)

                                            //插入记录
                                            Materialhistory materialhistoryold = new Materialhistory();
                                            materialhistoryold.setMhid(UtilityMethod.GetUUID());
                                            materialhistoryold.setMoid(moid);
                                            materialhistoryold.setMoname(moname);
                                            materialhistoryold.setTaskname("UnloadParts");
                                            materialhistoryold.setEqpname(eqpname);
                                            materialhistoryold.setSlot(slot);
                                            materialhistoryold.setPn(pn);
                                            materialhistoryold.setQty(oldupn.getRemainingqty());
                                            materialhistoryold.setBoardside(loadmaterial.getBoardside());
                                            materialhistoryold.setUpnname(oldupnname);
                                            materialhistoryold.setUpnqty(oldupn.getRemainingqty());
                                            materialhistoryold.setFeedername(feeder);
                                            materialhistoryold.setUsername(worknumber);
                                            materialhistoryold.setDatetime(sdf.format(datetime));
                                            int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);

                                            Materialhistory materialhistoryNew = new Materialhistory();
                                            materialhistoryNew.setMhid(UtilityMethod.GetUUID());
                                            materialhistoryNew.setMoid(moid);
                                            materialhistoryNew.setMoname(moname);
                                            materialhistoryNew.setTaskname("ReplenishFeeders");
                                            materialhistoryNew.setEqpname(eqpname);
                                            materialhistoryNew.setSlot(slot);
                                            materialhistoryNew.setPn(pn);
                                            materialhistoryNew.setQty(upn.getRemainingqty());
                                            materialhistoryNew.setBoardside(loadmaterial.getBoardside());
                                            materialhistoryNew.setUpnname(newupnname);
                                            materialhistoryNew.setUpnqty(upn.getRemainingqty());
                                            materialhistoryNew.setFeedername(feeder);
                                            materialhistoryNew.setUsername(worknumber);
                                            materialhistoryNew.setDatetime(sdf.format(datetime));
                                            int insertMaterialhistoryNew = MaterialhistoryMapper.insert(materialhistoryNew);


                                            //更新UPN信息 续料的逻辑 旧UPN清空moid、feerderid、eqpname、slot
                                            upn.setEqpname(eqpname);
                                            upn.setFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                            upn.setSlot(slot);
                                            upn.setMoid(moid);
                                            upn.setObj05("PDA续料");
                                            if (oldupn.getObj06() != null) {
                                                upn.setObj06((upn.getRemainingqty().add(new BigDecimal(oldupn.getObj06())) ) + "");
                                            } else {
                                                upn.setObj06(oldupn.getRemainingqty().toString());
                                            }
                                            upn.setRemainingqty(upn.getRemainingqty().add(oldupn.getRemainingqty()));

                                            int updateUpn = UpnMapper.updateByPrimaryKey(upn);

                                            oldupn.setEqpname(null);
                                            oldupn.setMoid(null);
                                            oldupn.setFeederid(null);
                                            oldupn.setSlot(null);
                                            oldupn.setRemainingqty(new BigDecimal(0)  );
                                            int updateOldUpn = UpnMapper.updateByPrimaryKey(oldupn);

                                            loadmaterial.setTaskname("ReplenishFeeders");
                                            loadmaterial.setFeeder(feeder);
                                            int updateLoadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);


                                            String  msg= "槽位：" + slot + "，续料成功！";
                                            materialModuleMapper.A03_SHIMIN_SMT("PDA续料",newupnname,moid,materialorderinfo.getLineid(),oldupnname,"",worknumber);

                                            List<Map<String, Object>> target =  materialModuleMapper.GetAOI_SMT_TARGETByLine(materialorder0.getLineid());
                                            if(target.size() > 0 && Double.parseDouble(target.get(0).get("TARGET").toString()) >0){
                                                List<Map<String, Object>> upnqty  = materialModuleMapper.GetCHQTY(oldupnname);

                                                if(upnqty.size()>0){
                                                    if(Integer.parseInt(upnqty.get(0).get("QTY").toString() ) < 0){
                                                        msg += " 注意注意！当前槽位可能异常超耗，请联系工艺确认！";
                                                    }
                                                }
                                            }

                                            Request.put("code", 200);
                                            Request.put("status", true);
                                            Request.put("message", msg);
                                            response.getWriter().print(Request);


                                        } else {
                                            String message ="错误：续料，设备：" + eqpname + "与飞达：" + feeder + "不匹配";//错误原因
                                            Lists.add(0,moid);
                                            Lists.add(1,moname);
                                            Lists.add(2,message);
                                            Lists.add(3,eqpname);
                                            Lists.add(4,slot);
                                            Lists.add(5,upnname);
                                            Lists.add(6,feeder);
                                            Lists.add(7,worknumber);
                                            Lists.add(8,sdf.format(datetime));
                                            InsertMaterialhistory(Lists);
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "该设备：" + eqpname + "与该飞达：" + feeder + "不匹配！");
                                            response.getWriter().print(Request);
                                        }
                                    } else {
                                        Request.put("code", 200);
                                        Request.put("status", false);
                                        Request.put("message", "找不到飞达！");
                                        response.getWriter().print(Request);
                                    }

                                } else {

                                    Request.put("code", 200);
                                    Request.put("status", false);
                                    Request.put("message", "该UPN已与槽位" + slot + "绑定！");
                                    response.getWriter().print(Request);
                                }
                            } else {
                                Feeder feederinfo = FeederMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getFeederid());
                                String message ="错误：续料，UPN已与飞达" + feederinfo.getFeedername() + "绑定";//错误原因
                                Lists.add(0,moid);
                                Lists.add(1,moname);
                                Lists.add(2,message);
                                Lists.add(3,eqpname);
                                Lists.add(4,slot);
                                Lists.add(5,upnname);
                                Lists.add(6,feederinfo.getFeedername());
                                Lists.add(7,worknumber);
                                Lists.add(8,sdf.format(datetime));
                                InsertMaterialhistory(Lists);
                                Request.put("code", 200);
                                Request.put("status", false);
                                Request.put("message", "该UPN已与飞达" + feederinfo.getFeedername() + "绑定！");
                                response.getWriter().print(Request);
                            }
                        } else {
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN已与飞达" + upninfo.stream().findFirst().get().getEqpname() + "绑定！");
                            response.getWriter().print(Request);
                        }


                    } else {

                        //Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
                        String message ="错误：续料，UPN已与上料任务" + materialorderinfo.getMoname() + "绑定";//错误原因
                        Lists.add(0,moid);
                        Lists.add(1,moname);
                        Lists.add(2,message);
                        Lists.add(3,eqpname);
                        Lists.add(4,slot);
                        Lists.add(5,upnname);
                        Lists.add(6,feeder);
                        Lists.add(7,worknumber);
                        Lists.add(8,sdf.format(datetime));
                        InsertMaterialhistory(Lists);
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "该UPN已与上料任务" + materialorderinfo.getMoname() + "绑定！");
                        response.getWriter().print(Request);
                    }
                          /*  }
                            else {
                                Request.put("code",200);
                                Request.put("status",false);
                                Request.put("message","此UPN未发料，请确认");
                                response.getWriter().print(Request);
                            }*/


                        /*}else {
                            Request.put("code",200);
                            Request.put("status",false);
                            Request.put("message","此批次/工单未发料，请确认");
                            response.getWriter().print(Request);
                        }*/

                } else {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "此UPN:" + newupnname + "未从仓库发料！");
                    response.getWriter().print(Request);
                }

            } else {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "该UPN不可用！");
                response.getWriter().print(Request);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }
//        }else {
//            Request.put("code",200);
//            Request.put("status",false);
//            Request.put("message","失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
//            response.getWriter().print(Request);
//            return;
//        }

    }



    //换料
    @Override
    public void ReplenishUpn(JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = "";
        String oldupnname = json.getString("oldupnname");
        String newupnname = json.getString("newupnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }

        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
        if (loadmaterials.size() > 0) {
            if (!loadmaterials.stream().findFirst().get().getTaskname().equals("ComfirmParts")) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "当前槽位未做对料，请先对料！");
                response.getWriter().print(Request);
                return;
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);

        if (!(checkupn.size() > 0)) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "上料任务与槽位不匹配！");
            response.getWriter().print(Request);
            return;
        }

        if (!checkupn.stream().findFirst().get().getUpnname().equals(oldupnname)) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的旧UPN不是目前上料的UPN！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(newupnname);
        List<Upn> oldupninfo = UpnMapper.GetUpnByUpnname(oldupnname);

        //System.out.println("IN");

        //List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);

        if (upninfo.size() > 0) {
            if (upninfo.stream().anyMatch(upn -> !upn.getState().equals("ACTIVE"))) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "新UPN状态不可用");
                response.getWriter().print(Request);
                return;
            }
            Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
            String orgpnMessage = validateOrgpn(json, partnumber);
            if (orgpnMessage != null) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", orgpnMessage);
                response.getWriter().print(Request);
                return;
            }
            String pn = partnumber.getPn();
            String upn_smt = "732D4EE6E2C046A9936378840989A365";
            Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
            Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder0.getLotid());
            List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());//.LoadinglistcontentGetbyPnAndLine(prp_lot.getProductpn(), line);
            if (loadinglistcontents.size() < 1) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "找不到站位表");
                response.getWriter().print(Request);
                return;
            } else {
                loadinglistcontents = loadinglistcontents.stream().filter(loadinglistcontent -> (loadinglistcontent.getPn()!=null&&loadinglistcontent.getPn().equals(pn)) || (loadinglistcontent.getAlternatepn()!=null&&loadinglistcontent.getAlternatepn().equals(pn)))
                        .filter(loadinglistcontent -> loadinglistcontent.getSlot().equals(slot))
                        .collect(Collectors.toList());
                if (loadinglistcontents.size() < 1) {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "新UPN与站位表中的物料不匹配！");
                    response.getWriter().print(Request);
                    return;
                }else if(loadinglistcontents.stream()
                        .filter(loadinglistcontent ->loadinglistcontent.getEqpname()!=null&& loadinglistcontent.getEqpname().equals(eqpname))
                        .collect(Collectors.toList()).size() < 1){
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "新UPN与站位表中的物料不匹配(设备不匹配)！");
                    response.getWriter().print(Request);
                    return;
                }
            }
            if (upninfo.size() > 0 && upninfo.stream().anyMatch(upn -> upn.getState().equals("ACTIVE"))) {

                if (upninfo.stream().anyMatch(upn -> upn.getCurrentstepid().equals(upn_smt))) {
                    //检查是否为发料UPN
                    List<Rmm_picklist> rmm_picklists = rmm_picklistMapper.selectByUpn(newupnname);
                    if(rmm_picklists.size()>0){
                        if(!hasMatchingIssuedWorkorderProduct(rmm_picklists, prp_lot.getProductpn())){
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN发料的成品料号与当前上料任务的成品料号不匹配！");
                            response.getWriter().print(Request);
                            return;
                        }
                    }else{
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "此UPN:" + newupnname + "未发料到工单！");
                        response.getWriter().print(Request);
                        return;
                    }
                    //Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
                    //Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder0.getLotid());
                    //List<Rmm_picklist> rmm_picklists = materialModuleMapper.Rmm_picklistsGetByPnAndLot(prp_lot.getWorkorderid(),prp_lot.getLotid(),pn);

                    //if(rmm_picklists.size()>0){
                    //    if(rmm_picklists.stream().anyMatch(rmm_picklist -> rmm_picklist.getUpn().equals(newupnname))){
                    if (upninfo.stream().anyMatch(upn -> upn.getMoid() == null)) {//是否有绑定上料任务
                        if (upninfo.stream().anyMatch(upn -> upn.getEqpname() == null)) {//是否有绑定设备
                            if (upninfo.stream().anyMatch(upn -> upn.getFeederid() == null)) {//是否有绑定飞达
                                if (upninfo.stream().anyMatch(upn -> upn.getSlot() == null)) {//是否有绑定槽位
                                    //开始检查传输过来的数据有无问题
                                    //moid、eqpname、upn、slot在前面已检查
                                    List<Feeder> feederinfo = FeederMapper.GetFeederByFeedername(feeder);
                                    if (feederinfo.size() > 0) {//是否有这个飞达
                                        List<Upn> upnfeeder = UpnMapper.GetUpnByFeederid(feederinfo.stream().findFirst().get().getFeederid());

                                        if (upnfeeder.size() > 0 && !upnfeeder.stream().findFirst().get().getUpnname().equals(oldupnname)) {
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "该飞达已绑定到其他UPN：" + upnfeeder.stream().findFirst().get().getUpnname() + "上！");
                                            response.getWriter().print(Request);
                                            return;
                                        }
                                        List<Eqp> eqpinfo = EqpMapper.GetEqpbyEqpname(eqpname);
                                        //设备与飞达是否匹配
                                        if (eqpinfo.stream().findFirst().get().getEqptypeid().equals(feederinfo.stream().findFirst().get().getEqptypeid())) {
                                            //插入记录

                                            Upn upn = upninfo.stream().findFirst().get();
                                            Upn oldupn = oldupninfo.stream().findFirst().get();

                                            List<Loadmaterial> loadmaterialss = LoadmaterialMapper.LoadMaterialGetByEqpAndSlotAndTaskname(moid, eqpname, slot, "ComfirmParts");
                                            Loadmaterial loadmaterial = loadmaterialss.stream().findFirst().get();
                                            loadmaterial.setTaskname("LoadFeeders");
                                            //插入记录
                                            Materialhistory materialhistoryold = new Materialhistory();
                                            materialhistoryold.setMhid(UtilityMethod.GetUUID());
                                            materialhistoryold.setMoid(moid);
                                            materialhistoryold.setMoname(moname);
                                            materialhistoryold.setTaskname("UnloadParts");
                                            materialhistoryold.setEqpname(eqpname);
                                            materialhistoryold.setSlot(slot);
                                            materialhistoryold.setPn(pn);
                                            materialhistoryold.setQty(loadmaterial.getQty());
                                            materialhistoryold.setBoardside(loadmaterial.getBoardside());
                                            materialhistoryold.setUpnname(oldupnname);
                                            materialhistoryold.setUpnqty(oldupn.getRemainingqty());
                                            materialhistoryold.setFeedername(feeder);
                                            materialhistoryold.setUsername(worknumber);
                                            materialhistoryold.setDatetime(sdf.format(datetime));
                                            int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);

                                            Materialhistory materialhistoryNew = new Materialhistory();
                                            materialhistoryNew.setMhid(UtilityMethod.GetUUID());
                                            materialhistoryNew.setMoid(moid);
                                            materialhistoryNew.setMoname(moname);
                                            materialhistoryNew.setTaskname("ReplenishFeeders");
                                            materialhistoryNew.setEqpname(eqpname);
                                            materialhistoryNew.setSlot(slot);
                                            materialhistoryNew.setPn(pn);
                                            materialhistoryNew.setQty(loadmaterial.getQty());
                                            materialhistoryNew.setBoardside(loadmaterial.getBoardside());
                                            materialhistoryNew.setUpnname(newupnname);
                                            materialhistoryNew.setUpnqty(upn.getRemainingqty());
                                            materialhistoryNew.setFeedername(feeder);
                                            materialhistoryNew.setUsername(worknumber);
                                            materialhistoryNew.setDatetime(sdf.format(datetime));
                                            int insertMaterialhistoryNew = MaterialhistoryMapper.insert(materialhistoryNew);


                                            //更新UPN信息 换料的逻辑 旧UPN清空moid、feerderid、eqpname、slot
                                            upn.setEqpname(eqpname);
                                            upn.setFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                            upn.setSlot(slot);
                                            upn.setMoid(moid);
                                            upn.setObj05("PDA换料");
                                            if (oldupn.getObj06() != null) {
                                                upn.setObj06(oldupn.getObj06());
                                                //System.out.println(oldupn.getObj06());
                                                //System.out.println(upn.getRemainingqty());
                                                upn.setRemainingqty(upn.getRemainingqty().add(new BigDecimal(oldupn.getObj06())) );
                                                //System.out.println(upn.getRemainingqty());
                                            }/*else {
                                                        upn.setObj06(upn.getRemainingqty().toString());
                                                    }*/

                                            int updateUpn = UpnMapper.updateByPrimaryKey(upn);

                                            oldupn.setEqpname(null);
                                            oldupn.setMoid(null);
                                            oldupn.setFeederid(null);
                                            oldupn.setSlot(null);
                                            if (oldupn.getObj06() != null) {
                                                oldupn.setRemainingqty(oldupn.getRemainingqty().subtract(new BigDecimal(oldupn.getObj06())) );
                                            }
                                            //oldupn.setState("HOLD");2026年4月7日
                                            oldupn.setDescription("PDA换料");
                                            oldupn.setObj06(null);
                                            int updateOldUpn = UpnMapper.updateByPrimaryKey(oldupn);

                                            loadmaterial.setTaskname("ReplenishFeeders");
                                            int updateLoadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);

                                            Request.put("code", 200);
                                            Request.put("status", true);
                                            Request.put("message", "槽位：" + slot + "，换料成功！");
                                            response.getWriter().print(Request);


                                        } else {
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "该设备：" + eqpname + "与该飞达：" + feeder + "不匹配！");
                                            response.getWriter().print(Request);
                                        }
                                    } else {
                                        Request.put("code", 200);
                                        Request.put("status", false);
                                        Request.put("message", "找不到飞达！");
                                        response.getWriter().print(Request);
                                    }

                                } else {
                                    Request.put("code", 200);
                                    Request.put("status", false);
                                    Request.put("message", "该UPN已与槽位" + slot + "绑定！");
                                    response.getWriter().print(Request);
                                }
                            } else {
                                Feeder feederinfo = FeederMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getFeederid());
                                Request.put("code", 200);
                                Request.put("status", false);
                                Request.put("message", "该UPN已与飞达" + feederinfo.getFeedername() + "绑定！");
                                response.getWriter().print(Request);
                            }
                        } else {
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN已与飞达" + upninfo.stream().findFirst().get().getEqpname() + "绑定！");
                            response.getWriter().print(Request);
                        }


                    } else {

                        Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getMoid());
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "该UPN已与上料任务" + materialorderinfo.getMoname() + "绑定！");
                        response.getWriter().print(Request);
                    }
                       /* }
                        else {
                            Request.put("code",200);
                            Request.put("status",false);
                            Request.put("message","此UPN未发料，请确认");
                            response.getWriter().print(Request);
                        }*/


                   /* }else {
                        Request.put("code",200);
                        Request.put("status",false);
                        Request.put("message","此批次/工单未发料，请确认");
                        response.getWriter().print(Request);
                    }*/

                } else {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "此UPN:" + newupnname + "未从仓库发料！");
                    response.getWriter().print(Request);
                }

            } else {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "该UPN不可用！");
                response.getWriter().print(Request);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }

    //卸料
    @Override
    public void UnloadmaterialbySlot(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        //String upnname="";
        //String oldupnname = json.getString("oldupnname");
        String upnname = json.getString("upnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }

        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);

        if (loadmaterials.size() > 0) {
            if (!loadmaterials.stream().findFirst().get().getTaskname().equals("ComfirmParts")) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "当前槽位未做对料，请先对料！");
                response.getWriter().print(Request);
                return;
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);

        if (checkupn.stream().noneMatch(upn -> upn.getUpnname().equals(upnname))) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的UPN不是目前上料的UPN！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);
        Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
        String pn = partnumber.getPn();
        Upn upn = upninfo.stream().findFirst().get();

        Loadmaterial loadmaterial = loadmaterials.stream().findFirst().get();
        loadmaterial.setTaskname(null);
        int updateloadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);

        //插入记录
        Materialhistory materialhistoryold = new Materialhistory();
        materialhistoryold.setMhid(UtilityMethod.GetUUID());
        materialhistoryold.setMoid(moid);
        materialhistoryold.setMoname(moname);
        materialhistoryold.setTaskname("UnloadParts");
        materialhistoryold.setEqpname(eqpname);
        materialhistoryold.setSlot(slot);
        materialhistoryold.setPn(pn);
        materialhistoryold.setQty(loadmaterial.getQty());
        materialhistoryold.setBoardside(loadmaterial.getBoardside());
        materialhistoryold.setUpnname(upnname);
        materialhistoryold.setUpnqty(upn.getRemainingqty());
        materialhistoryold.setFeedername("");
        materialhistoryold.setUsername(worknumber);
        materialhistoryold.setDatetime(sdf.format(datetime));
        int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);



//        Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
//        List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());
//        HashSet<String> hashSet1 = new HashSet<>();
//        HashSet<String> hashSet2 = new HashSet<>();//存放重复的slot
//        if (loadinglistcontents.size() < 1) {
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "找不到站位表");
//            response.getWriter().print(Request);
//            return;
//        } else {
//            //String[] loadingStrings= loadinglistcontents.s
//            for(String s : loadinglistcontents.stream().map(Loadinglistcontent::getSlot).collect(Collectors.toList())){
//                if(hashSet1.contains(s)){
//                    hashSet2.add(s);
//                }else {
//                    hashSet1.add(s);
//                }
//
//            }
//
//
//        }

        upn.setEqpname(null);
        upn.setMoid(null);
        upn.setFeederid(null);
        upn.setSlot(null);
        upn.setObj05(null);
        upn.setObj06(null);

        //upn.setState("HOLD"); 2026年4月7日
//        if(hashSet2.contains(slot)){
//            upn.setState("HOLD");
//        }
        upn.setDescription("PDA卸料");

        int updateupn = UpnMapper.updateByPrimaryKey(upn);


        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);

        List<Loadmaterial> loadmaterials1 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);
        List<Loadmaterial> loadmaterials2 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream().filter(loadmaterial1 -> loadmaterial1.getTaskname()==null).collect(Collectors.toList());
        //Taskname全为空
        if (loadmaterials1.size()==loadmaterials2.size()&& materialorder.getStatus().equals("FINISH")) {
            materialorder.setStatus("CLOSE");
            int updatematerialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "当前槽位" + slot + "已卸料," + "上料任务" + moname + "已全部卸料完毕");
            response.getWriter().print(Request);
            return;
        }

        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "当前槽位" + slot + "已卸料！");
        response.getWriter().print(Request);


    }

    //按槽位特殊卸料
    @Override
    public void UnloadmaterialbySlotsp(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        //String upnname="";
        //String oldupnname = json.getString("oldupnname");
        String upnname = json.getString("upnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA特殊卸料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可特殊卸料的账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }

        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);

        if (loadmaterials.size() > 0) {
            if (loadmaterials.stream().noneMatch(loadmaterial -> loadmaterial.getTaskname().equals("ComfirmParts"))) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "当前槽位未做对料，请先对料！");
                response.getWriter().print(Request);
                return;
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);

        if (checkupn.stream().noneMatch(upn -> upn.getUpnname().equals(upnname))) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的UPN不是目前上料的UPN！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);
        Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
        String pn = partnumber.getPn();
        Upn upn = upninfo.stream().findFirst().get();

        Feeder feeder1 = FeederMapper.selectByPrimaryKey(upn.getFeederid());

        Optional<Loadmaterial> optionalLoadmaterial = loadmaterials.stream()
                .filter(loadmaterial1 -> loadmaterial1.getFeeder().equals(feeder1.getFeedername()))
                .findFirst();

        if (!optionalLoadmaterial.isPresent()) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "当前槽位" + slot + "无法卸料!请确认！" );
            response.getWriter().print(Request);
            return;
            // 这里可以继续使用loadmaterial对象，因为它已经存在
        }
        Loadmaterial loadmaterial = optionalLoadmaterial.get();
        loadmaterial.setTaskname(null);
        loadmaterial.setFeeder(null);
        int updateloadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);

        //插入记录
        Materialhistory materialhistoryold = new Materialhistory();
        materialhistoryold.setMhid(UtilityMethod.GetUUID());
        materialhistoryold.setMoid(moid);
        materialhistoryold.setMoname(moname);
        materialhistoryold.setTaskname("UnloadParts");
        materialhistoryold.setEqpname(eqpname);
        materialhistoryold.setSlot(slot);
        materialhistoryold.setPn(pn);
        materialhistoryold.setQty(loadmaterial.getQty());
        materialhistoryold.setBoardside(loadmaterial.getBoardside());
        materialhistoryold.setUpnname(upnname);
        materialhistoryold.setUpnqty(upn.getRemainingqty());
        materialhistoryold.setFeedername("");
        materialhistoryold.setUsername(worknumber);
        materialhistoryold.setDatetime(sdf.format(datetime));
        int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);



//        Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
//        List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());
//        HashSet<String> hashSet1 = new HashSet<>();
//        HashSet<String> hashSet2 = new HashSet<>();//存放重复的slot
//        if (loadinglistcontents.size() < 1) {
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "找不到站位表");
//            response.getWriter().print(Request);
//            return;
//        } else {
//            //String[] loadingStrings= loadinglistcontents.s
//            for(String s : loadinglistcontents.stream().map(Loadinglistcontent::getSlot).collect(Collectors.toList())){
//                if(hashSet1.contains(s)){
//                    hashSet2.add(s);
//                }else {
//                    hashSet1.add(s);
//                }
//
//            }
//
//
//        }

        upn.setEqpname(null);
        upn.setMoid(null);
        upn.setFeederid(null);
        upn.setSlot(null);
        upn.setObj05(null);
        upn.setObj06(null);

        //upn.setState("HOLD");特殊卸料取消
//        if(hashSet2.contains(slot)){
//            upn.setState("HOLD");
//        }
        upn.setDescription("PDA卸料");

        int updateupn = UpnMapper.updateByPrimaryKey(upn);


        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);

        List<Loadmaterial> loadmaterials1 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);
        List<Loadmaterial> loadmaterials2 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream().filter(loadmaterial1 -> loadmaterial1.getTaskname()==null).collect(Collectors.toList());
        //Taskname全为空
        if (loadmaterials1.size()==loadmaterials2.size()&& materialorder.getStatus().equals("FINISH")) {
            materialorder.setStatus("CLOSE");
            int updatematerialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "当前槽位" + slot + "已卸料," + "上料任务" + moname + "已全部卸料完毕");
            response.getWriter().print(Request);
            return;
        }

        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "当前槽位" + slot + "已卸料！");
        response.getWriter().print(Request);


    }

    @Override
    public void UnloadmaterialbySlot2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        //String upnname="";
        //String oldupnname = json.getString("oldupnname");
        String upnname = json.getString("upnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA特殊卸料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可特殊卸料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }

        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);

        if (loadmaterials.size() > 0) {
            if (!loadmaterials.stream().findFirst().get().getTaskname().equals("ComfirmParts")) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "当前槽位未做对料，请先对料！");
                response.getWriter().print(Request);
                return;
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);

        if (checkupn.stream().noneMatch(upn -> upn.getUpnname().equals(upnname))) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的UPN不是目前上料的UPN！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);
        Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
        String pn = partnumber.getPn();
        Upn upn = upninfo.stream().findFirst().get();

        Loadmaterial loadmaterial = loadmaterials.stream().findFirst().get();
        loadmaterial.setTaskname(null);
        loadmaterial.setFeeder(null);
        int updateloadmaterial = LoadmaterialMapper.updateByPrimaryKey(loadmaterial);

        //插入记录
        Materialhistory materialhistoryold = new Materialhistory();
        materialhistoryold.setMhid(UtilityMethod.GetUUID());
        materialhistoryold.setMoid(moid);
        materialhistoryold.setMoname(moname);
        materialhistoryold.setTaskname("UnloadParts");
        materialhistoryold.setEqpname(eqpname);
        materialhistoryold.setSlot(slot);
        materialhistoryold.setPn(pn);
        materialhistoryold.setQty(loadmaterial.getQty());
        materialhistoryold.setBoardside(loadmaterial.getBoardside());
        materialhistoryold.setUpnname(upnname);
        materialhistoryold.setUpnqty(upn.getRemainingqty());
        materialhistoryold.setFeedername("");
        materialhistoryold.setUsername(worknumber);
        materialhistoryold.setDatetime(sdf.format(datetime));
        int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);



//        Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
//        List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());
//        HashSet<String> hashSet1 = new HashSet<>();
//        HashSet<String> hashSet2 = new HashSet<>();//存放重复的slot
//        if (loadinglistcontents.size() < 1) {
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "找不到站位表");
//            response.getWriter().print(Request);
//            return;
//        } else {
//            //String[] loadingStrings= loadinglistcontents.s
//            for(String s : loadinglistcontents.stream().map(Loadinglistcontent::getSlot).collect(Collectors.toList())){
//                if(hashSet1.contains(s)){
//                    hashSet2.add(s);
//                }else {
//                    hashSet1.add(s);
//                }
//
//            }
//
//
//        }

        upn.setEqpname(null);
        upn.setMoid(null);
        upn.setFeederid(null);
        upn.setSlot(null);
        upn.setObj05(null);
        upn.setObj06(null);

        //upn.setState("HOLD");特殊卸料取消
//        if(hashSet2.contains(slot)){
//            upn.setState("HOLD");
//        }
        upn.setDescription("PDA卸料");

        int updateupn = UpnMapper.updateByPrimaryKey(upn);


        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);

        List<Loadmaterial> loadmaterials1 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);
        List<Loadmaterial> loadmaterials2 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream().filter(loadmaterial1 -> loadmaterial1.getTaskname()==null).collect(Collectors.toList());
        //Taskname全为空
        if (loadmaterials1.size()==loadmaterials2.size()&& materialorder.getStatus().equals("FINISH")) {
            materialorder.setStatus("CLOSE");
            int updatematerialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "当前槽位" + slot + "已卸料," + "上料任务" + moname + "已全部卸料完毕");
            response.getWriter().print(Request);
            return;
        }

        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "当前槽位" + slot + "已卸料！");
        response.getWriter().print(Request);


    }

    //更换飞达
    @Override
    public void ChangeFeeder(JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String feeder=json.getString("feeder");//旧飞达
        String upnname=json.getString("upnname");//新飞达
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<>();

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Feeder> feedersold = FeederMapper.GetFeederByFeedername(feeder);
        if(feedersold.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "系统查询不到扫入的旧飞达信息，请检查！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> upns = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid,eqpname,slot);
        if(upns.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "查询不到该设备的槽位，请检查！");
            response.getWriter().print(Request);
            return;
        }
        upns = upns.stream().filter(upn -> upn.getFeederid()!=null&&upn.getFeederid().equals(feedersold.stream().findFirst().get().getFeederid()))
                .collect(Collectors.toList());
        if(upns.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的旧飞达没有绑定在UPN上，请检查！");
            response.getWriter().print(Request);
            return;
        }
        List<Feeder> feeders = FeederMapper.GetFeederByFeedername(upnname);
        if(feeders.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "系统查询不到扫入的新飞达信息，请检查！");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> upns1 = UpnMapper.GetUpnByFeederid(feeders.stream().findFirst().get().getFeederid());
        if(upns1.size()> 0){
            Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
            String message ="错误：更换飞达，扫入的新飞达已绑定到其他UPN：" + upns1.stream().findFirst().get().getUpnname()  ;//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,upnname);
            Lists.add(6,feeders.stream().findFirst().get().getFeedername());
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的新飞达已绑定到其他UPN：" + upns1.stream().findFirst().get().getUpnname() + "上！");
            response.getWriter().print(Request);
            return;
        }

        //插入记录
        Materialhistory materialhistoryold = new Materialhistory();
        materialhistoryold.setMhid(UtilityMethod.GetUUID());
        materialhistoryold.setMoid(moid);
        materialhistoryold.setMoname(moname);
        materialhistoryold.setTaskname("更换飞达");
        materialhistoryold.setEqpname(eqpname);
        materialhistoryold.setSlot(slot);

        materialhistoryold.setUpnname(upns.stream().findFirst().get().getUpnname());

        materialhistoryold.setFeedername(feedersold.stream().findFirst().get().getFeedername()+"->"+upnname);
        materialhistoryold.setUsername(worknumber);
        materialhistoryold.setDatetime(sdf.format(datetime));
        MaterialhistoryMapper.insert(materialhistoryold);




        Upn upn = upns.stream().findFirst().get();
        Feeder feeder1= FeederMapper.selectByPrimaryKey(upn.getFeederid());

        /*List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream()
                .filter(loadmaterial ->loadmaterial.getSlot()!=null&& loadmaterial.getSlot().equals(slot))
                .collect(Collectors.toList());
        if(loadmaterials.size()>0){
            Loadmaterial loadmaterial = loadmaterials.stream().filter(loadmaterial1 ->loadmaterial1.getPda1()!=null&& loadmaterial1.getPda1().equals(feeder1.getFeedername())).findFirst().get();
            if(loadmaterial != null){
                loadmaterial.setPda1(upnname);
                LoadmaterialMapper.updateByPrimaryKey(loadmaterial);
            }
        }*/

        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);
        if (loadmaterials != null && !loadmaterials.isEmpty()) {
            Optional<Loadmaterial> optionalLoadmaterial = loadmaterials.stream()
                    .filter(lm -> lm.getSlot() != null && lm.getSlot().equals(slot))
                    .filter(lm -> lm.getFeeder() != null && lm.getFeeder().equals(feeder1.getFeedername()))
                    .findFirst();
            if (optionalLoadmaterial.isPresent()) {
                Loadmaterial loadmaterial = optionalLoadmaterial.get();
                loadmaterial.setFeeder(upnname);
                LoadmaterialMapper.updateByPrimaryKey(loadmaterial);
            }
        }





        upn.setFeederid(feeders.stream().findFirst().get().getFeederid());

        UpnMapper.updateByPrimaryKey(upn);

        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "更换飞达"+upnname+"成功！");
        response.getWriter().print(Request);

    }

    //更换刮刀
    @Override
    public void ChangeGD(JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String oldupnname=json.getString("feeder");//旧刮刀
        String upnname=json.getString("upnname");//新刮刀
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<>();

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Upn> upns = UpnMapper.GetUpnByUpnname(oldupnname);

        if(upns.size() < 1|| upns.stream().noneMatch(upn -> upn.getUpnname().contains("0000001"))){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "系统查询不到扫入的旧刮刀信息，请检查！");
            response.getWriter().print(Request);
            return;
        }

        if(upns.stream().findFirst().get().getMoid()==null){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "扫入的旧刮刀没有绑定在上料任务上，请检查！");
            response.getWriter().print(Request);
            return;
        }

        List<Upn> upnsnew = UpnMapper.GetUpnByUpnname(upnname);

        if(upnsnew.isEmpty() || upnsnew.stream().noneMatch(upn -> upn.getUpnname().contains("0000001"))){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "系统查询不到扫入的新刮刀信息，请检查！");
            response.getWriter().print(Request);
            return;
        }

        if(upnsnew.stream().findFirst().get().getMoid()!=null){

            Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(upnsnew.stream().findFirst().get().getMoid());
            if(materialorderinfo!=null){
                String message ="错误：更换刮刀，扫入的新刮刀已绑定到其他上料任务：" + materialorderinfo.getMoname()  ;//错误原因
                Lists.add(0,moid);
                Lists.add(1,moname);
                Lists.add(2,message);
                Lists.add(3,eqpname);
                Lists.add(4,slot);
                Lists.add(5,upnname);
                Lists.add(6,"");
                Lists.add(7,worknumber);
                Lists.add(8,sdf.format(datetime));
                InsertMaterialhistory(Lists);

                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "扫入的新刮刀绑定在上料任务:"+ materialorderinfo.getMoname()+",请检查！");
                response.getWriter().print(Request);
                return;
            }

        }



        //插入记录
        Materialhistory materialhistoryold = new Materialhistory();
        materialhistoryold.setMhid(UtilityMethod.GetUUID());
        materialhistoryold.setMoid(moid);
        materialhistoryold.setMoname(moname);
        materialhistoryold.setTaskname("更换刮刀");
        materialhistoryold.setEqpname(eqpname);
        materialhistoryold.setSlot(slot);

        materialhistoryold.setUpnname(upns.stream().findFirst().get().getUpnname()+"->"+upnsnew.stream().findFirst().get().getUpnname());

        //materialhistoryold.setFeedername(feedersold.stream().findFirst().get().getFeedername()+"->"+upnname);
        materialhistoryold.setUsername(worknumber);
        materialhistoryold.setDatetime(sdf.format(datetime));
        MaterialhistoryMapper.insert(materialhistoryold);




        Upn upnold = upns.stream().findFirst().get();
        Upn upnnew = upnsnew.stream().findFirst().get();
        String newMoid = upnold.getMoid();
        upnold.setMoid(null);
        upnnew.setMoid(newMoid);
        UpnMapper.updateByPrimaryKey(upnold);
        UpnMapper.updateByPrimaryKey(upnnew);

        //Feeder feeder1= FeederMapper.selectByPrimaryKey(upn.getFeederid());

        /*List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream()
                .filter(loadmaterial ->loadmaterial.getSlot()!=null&& loadmaterial.getSlot().equals(slot))
                .collect(Collectors.toList());
        if(loadmaterials.size()>0){
            Loadmaterial loadmaterial = loadmaterials.stream().filter(loadmaterial1 ->loadmaterial1.getPda1()!=null&& loadmaterial1.getPda1().equals(feeder1.getFeedername())).findFirst().get();
            if(loadmaterial != null){
                loadmaterial.setPda1(upnname);
                LoadmaterialMapper.updateByPrimaryKey(loadmaterial);
            }
        }*/



        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "更换刮刀"+upnname+"成功！");
        response.getWriter().print(Request);

    }

    //卸飞达
    @Override
    public void UnloadFeeder(JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String feeder=json.getString("feeder");
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<>();

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Upn> upns = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid,eqpname,slot);
        if(upns.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "查询不到该设备的槽位，请检查！");
            response.getWriter().print(Request);
            return;
        }
        if(upns.size()<2){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该站位上料小于两套料，不允许卸飞达！");
            response.getWriter().print(Request);
            return;
        }
        List<Feeder> feeders = FeederMapper.GetFeederByFeedername(feeder);
        if(feeders.size()<1){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "查询不到该飞达，请检查！");
            response.getWriter().print(Request);
            return;
        }
        String feederid=feeders.stream().findFirst().get().getFeederid();
        List<Upn> upns1 = upns.stream().filter(upn ->upn.getFeederid()!=null && upn.getFeederid().equals(feederid))
                .collect(Collectors.toList());
        if(upns1.size() < 1){
            //Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(moid);
            String message ="错误：卸飞达，找不到与该飞达绑定的UPN"  ;//错误原因
            Lists.add(0,moid);
            Lists.add(1,moname);
            Lists.add(2,message);
            Lists.add(3,eqpname);
            Lists.add(4,slot);
            Lists.add(5,feeder);
            Lists.add(6,feeders.stream().findFirst().get().getFeedername());
            Lists.add(7,worknumber);
            Lists.add(8,sdf.format(datetime));
            InsertMaterialhistory(Lists);

            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "找不到与该飞达绑定的UPN!");
            response.getWriter().print(Request);
            return;
        }
        List<Upn> upns2 = upns.stream().filter(upn -> upn.getFeederid() == null ||!upn.getFeederid().equals(feederid)).collect(Collectors.toList());
        Upn upn1 = upns1.stream().findFirst().get();
        Upn upn2 = upns2.stream().findFirst().get();
        upn2.setRemainingqty(upn2.getRemainingqty().add(upn1.getRemainingqty()));
        upn1.setRemainingqty(BigDecimal.valueOf(0));
        upn1.setFeederid(null);
        upn1.setMoid(null);
        upn1.setSlot(null);
        upn1.setEqpname(null);
        UpnMapper.updateByPrimaryKey(upn1);
        UpnMapper.updateByPrimaryKey(upn2);
        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream()
                .filter(loadmaterial -> loadmaterial.getSlot()!=null&&loadmaterial.getSlot().equals(slot))
                .collect(Collectors.toList());
        Loadmaterial loadmaterial = loadmaterials.stream().filter(loadmaterial1 -> loadmaterial1.getFeeder()!=null &&loadmaterial1.getFeeder().equals(feeder)).findFirst().get();
        LoadmaterialMapper.deleteByPrimaryKey(loadmaterial.getLmid());

        //loadmaterial.setPda1("");
        //插入记录
        Materialhistory materialhistoryold = new Materialhistory();
        materialhistoryold.setMhid(UtilityMethod.GetUUID());
        materialhistoryold.setMoid(moid);
        materialhistoryold.setMoname(moname);
        materialhistoryold.setTaskname("卸飞达");
        materialhistoryold.setEqpname(eqpname);
        materialhistoryold.setSlot(slot);

        materialhistoryold.setUpnname(upns.stream().findFirst().get().getUpnname());

        materialhistoryold.setFeedername(feeders.stream().findFirst().get().getFeedername());
        materialhistoryold.setUsername(worknumber);
        materialhistoryold.setDatetime(sdf.format(datetime));
        MaterialhistoryMapper.insert(materialhistoryold);

       // upns.stream().findFirst().get().setFeederid(feeders.stream().findFirst().get().getFeederid());

       // int updateFeeder= UpnMapper.updateByPrimaryKey(upns.stream().findFirst().get());



        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "卸飞达"+feeder+"成功！");
        response.getWriter().print(Request);

    }

    //一键卸料
    @Override
    public void UnloadmaterialAll(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        //String upnname="";
        //String oldupnname = json.getString("oldupnname");
        String upnname = json.getString("upnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可一键卸料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }




        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);

        if (loadmaterials.size() > 0) {

            for (Loadmaterial lm: loadmaterials) {

                if (lm.getTaskname()!=null&&!lm.getTaskname().equals("ComfirmParts")) {
                    Request.put("code", 200);
                    //Request.put("status", false);
                    System.out.println(lm.getSlot());
                    Request.put("message", "当前槽位:"+lm.getSlot()+",未做对料，请先对料！");
                    response.getWriter().print(Request);
                    return;
                }
            }

            //先更新上料任务的状态
            for (Loadmaterial lm2:loadmaterials) {
                lm2.setTaskname(null);
                int updateloadmaterial = LoadmaterialMapper.updateByPrimaryKey(lm2);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！找不到该上料任务");
            response.getWriter().print(Request);
            return;
        }
        //接下来更新UPN数据
        List<Upn> upns = UpnMapper.GetUpnByMoid(moid);
        if(upns.size()>0){


            for(Upn upn : upns){
                Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upn.getPnid());
                String pn = partnumber.getPn();
                upn.setEqpname(null);
                upn.setMoid(null);
                upn.setFeederid(null);
                upn.setSlot(null);
                upn.setObj05(null);
                upn.setObj06(null);
                //upn.setState("HOLD");2026年4月7日
                upn.setDescription("PDA卸料");

                int updateupn = UpnMapper.updateByPrimaryKey(upn);

                //插入记录
                Materialhistory materialhistoryold = new Materialhistory();
                materialhistoryold.setMhid(UtilityMethod.GetUUID());
                materialhistoryold.setMoid(moid);
                materialhistoryold.setMoname(moname);
                materialhistoryold.setTaskname("UnloadParts");
                materialhistoryold.setEqpname(upn.getEqpname());
                materialhistoryold.setSlot(upn.getSlot());
                materialhistoryold.setPn(pn);
                //materialhistoryold.setQty(loadmaterial.getQty());
                //materialhistoryold.setBoardside(loadmaterial.getBoardside());
                materialhistoryold.setUpnname(upn.getUpnname());
                materialhistoryold.setUpnqty(upn.getRemainingqty());
                materialhistoryold.setFeedername("");
                materialhistoryold.setUsername(worknumber);
                materialhistoryold.setDatetime(sdf.format(datetime));
                int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);


            }


        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！该上料任务没有绑定UPN，无法卸料！");
            response.getWriter().print(Request);
            return;
        }





        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
        materialorder.setStatus("CLOSE");
        int updatematerialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);


        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "当前上料任务" + moname + "已卸料完毕！");
        response.getWriter().print(Request);


    }

    //一键特殊卸料
    @Override
    public void UnloadmaterialAll2(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        //String upnname="";
        //String oldupnname = json.getString("oldupnname");
        String upnname = json.getString("upnname");
        String taskName = json.getString("taskName");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");

        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("特殊卸料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可特殊卸料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }




        List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);

        if (loadmaterials.size() > 0) {

            if(userprofiles.stream().findFirst().get().getDepartment().contains("特殊卸料（对料后）")){
                for (Loadmaterial lm: loadmaterials) {
                    if (lm.getTaskname()!=null&&!lm.getTaskname().equals("ComfirmParts")) {
                        Request.put("code", 200);
                        //Request.put("status", false);
                        System.out.println(lm.getSlot());
                        Request.put("message", "当前槽位:"+lm.getSlot()+",未做对料，请先对料！");
                        response.getWriter().print(Request);
                        return;
                    }
                }
            }

            //先更新上料任务的状态
            for (Loadmaterial lm2:loadmaterials) {
                lm2.setTaskname(null);
                int updateloadmaterial = LoadmaterialMapper.updateByPrimaryKey(lm2);
            }

        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！找不到该上料任务");
            response.getWriter().print(Request);
            return;
        }
        //接下来更新UPN数据
        List<Upn> upns = UpnMapper.GetUpnByMoid(moid);
        if(upns.size()>0){


            for(Upn upn : upns){
                Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upn.getPnid());
                String pn = partnumber.getPn();
                upn.setEqpname(null);
                upn.setMoid(null);
                upn.setFeederid(null);
                upn.setSlot(null);
                upn.setObj05(null);
                upn.setObj06(null);
                //upn.setState("HOLD");
                upn.setDescription("PDA卸料");

                int updateupn = UpnMapper.updateByPrimaryKey(upn);

                //插入记录
                Materialhistory materialhistoryold = new Materialhistory();
                materialhistoryold.setMhid(UtilityMethod.GetUUID());
                materialhistoryold.setMoid(moid);
                materialhistoryold.setMoname(moname);
                materialhistoryold.setTaskname("UnloadParts");
                materialhistoryold.setEqpname(upn.getEqpname());
                materialhistoryold.setSlot(upn.getSlot());
                materialhistoryold.setPn(pn);
                //materialhistoryold.setQty(loadmaterial.getQty());
                //materialhistoryold.setBoardside(loadmaterial.getBoardside());
                materialhistoryold.setUpnname(upn.getUpnname());
                materialhistoryold.setUpnqty(upn.getRemainingqty());
                materialhistoryold.setFeedername("");
                materialhistoryold.setUsername(worknumber);
                materialhistoryold.setDatetime(sdf.format(datetime));
                int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);


            }


        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "失败！该上料任务没有绑定UPN，无法卸料！");
            response.getWriter().print(Request);
            return;
        }





        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
        materialorder.setStatus("CLOSE");
        int updatematerialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);


        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "当前上料任务" + moname + "已卸料完毕！");
        response.getWriter().print(Request);


    }

    //锁定
    @Override
    public void Lockmaterial(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        //String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        //String upnname="";
        //String oldupnname = json.getString("oldupnname");


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA冻结")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可冻结上料任务账号，不可操作！");
            response.getWriter().print(Request);
            return;
        }
        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
        if(materialorder.getStatus().contains("HOLD")){
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "当前上料任务已冻结！");
            response.getWriter().print(Request);
            return;
        }

                //插入记录
                Materialhistory materialhistoryold = new Materialhistory();
                materialhistoryold.setMhid(UtilityMethod.GetUUID());
                materialhistoryold.setMoid(moid);
                materialhistoryold.setMoname(materialorder.getMoname());
                materialhistoryold.setTaskname("HOLD");
                //materialhistoryold.setEqpname(upn.getEqpname());
                //materialhistoryold.setSlot(upn.getSlot());
                //materialhistoryold.setPn(pn);
                //materialhistoryold.setQty(loadmaterial.getQty());
                //materialhistoryold.setBoardside(loadmaterial.getBoardside());
                //materialhistoryold.setUpnname(upn.getUpnname());
                //materialhistoryold.setUpnqty(upn.getRemainingqty());
                //materialhistoryold.setFeedername("");
                materialhistoryold.setUsername(worknumber);
                materialhistoryold.setDatetime(sdf.format(datetime));
                MaterialhistoryMapper.insert(materialhistoryold);



        materialorder.setStatus(materialorder.getStatus()+"-HOLD");
        MaterialorderMapper.updateByPrimaryKey(materialorder);


        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "当前上料任务已冻结！");
        response.getWriter().print(Request);


    }

    @Override
    public void UnLockmaterial(JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String[] status= {};
        //String upnname="";
        //String oldupnname = json.getString("oldupnname");


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));
        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA解冻")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可解冻上料任务账号，不可操作！");
            response.getWriter().print(Request);
            return;
        }
        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
        if(!materialorder.getStatus().contains("HOLD")){
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "当前上料任务不在冻结状态！");
            response.getWriter().print(Request);
            return;
        }

        //插入记录
        Materialhistory materialhistoryold = new Materialhistory();
        materialhistoryold.setMhid(UtilityMethod.GetUUID());
        materialhistoryold.setMoid(moid);
        materialhistoryold.setMoname(moname);
        materialhistoryold.setTaskname("UNHOLD");
        //materialhistoryold.setEqpname(upn.getEqpname());
        //materialhistoryold.setSlot(upn.getSlot());
        //materialhistoryold.setPn(pn);
        //materialhistoryold.setQty(loadmaterial.getQty());
        //materialhistoryold.setBoardside(loadmaterial.getBoardside());
        //materialhistoryold.setUpnname(upn.getUpnname());
        //materialhistoryold.setUpnqty(upn.getRemainingqty());
        //materialhistoryold.setFeedername("");
        materialhistoryold.setUsername(worknumber);
        materialhistoryold.setDatetime(sdf.format(datetime));
        int insertMaterialhistoryOld = MaterialhistoryMapper.insert(materialhistoryold);



        status=materialorder.getStatus().split("-");
        materialorder.setStatus(status[0]);
        int updatematerialorder = MaterialorderMapper.updateByPrimaryKey(materialorder);


        Request.put("code", 200);
        Request.put("status", true);
        Request.put("message", "当前上料任务已解冻！");
        response.getWriter().print(Request);
    }


    @Override
    public boolean ConfirmReelMsg(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String lotname = json.getString("lotname");
        String upnname = json.getString("upnname");
        String reelname = json.getString("reelname");
        int getCount = GetPNMsg(lotname, upnname, reelname);
        if (getCount > 0) {
            Request.put("status", true);
            Request.put("code", 200);
            Request.put("message", "三码校验通过!");
            response.getWriter().print(Request);
            return true;
        } else {
            Request.put("status", false);
            Request.put("code", 200);
            Request.put("message", "三码校验不通过!");
            response.getWriter().print(Request);
            return false;
        }

    }

    @Override
    public void ReturnMo(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String username = json.getString("worknumber");
        String moname = "";
        String line = "";
        String moid = "";

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }


        List<Map<String, Object>> moList = GetMobyEqpname(eqpname);
        if (moList.size() > 0) {
            moname = moList.get(0).get("MONAME").toString();
            line = moList.get(0).get("AREANAME").toString();
            moid = moList.get(0).get("MOID").toString();
           /*for(Map<String,Object> ml : moList){
                String moname="";
            }*/
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "success");
            Request.put("moname", moname);
            Request.put("line", line);
            Request.put("moid", moid);
            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务，请检查！");
            response.getWriter().print(Request);
        }
    }

    @Override
    public void ReturnLoadPartsMo(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String username = json.getString("worknumber");
        String moname = "";
        String line = "";
        String moid = "";

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }


        List<Map<String, Object>> moList = GetLoadpartsMobyEqpname(eqpname);
        if (moList.size() > 0) {
            moname = moList.get(0).get("MONAME").toString();
            line = moList.get(0).get("AREANAME").toString();
            moid = moList.get(0).get("MOID").toString();
           /*for(Map<String,Object> ml : moList){
                String moname="";
            }*/
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "success");
            Request.put("moname", moname);
            Request.put("line", line);
            Request.put("moid", moid);
            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务，请检查！");
            response.getWriter().print(Request);
        }
    }

    //返回列表
    @Override
    public void ReturnLoadMoList(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String username = json.getString("worknumber");
        String moname = "";
        String line = "";
        String moid = "";

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }


        List<Map<String, Object>> moList = GetLoadMobyEqpname(eqpname);
        if (moList.size() > 0) {

            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "success");
            //Request.put("moname", moname);
            Request.put("line", line);
            Request.put("moList", moList);
            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务");
            response.getWriter().print(Request);
        }
    }

    //备料
    @Override
    public void LoadParts(JSONObject json, HttpServletResponse response) throws IOException {

        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = json.getString("moname");
        String line = json.getString("line");
        String moid = json.getString("moid");
        String worknumber = json.getString("worknumber");
        String upnname = json.getString("upnname");
        String feeder = json.getString("feeder");
        String slot = json.getString("slotname");
        List<String> Lists = new ArrayList<>();
        /*
        0	Moid
        1	Moname
        2	Taskname
        3	Eqpname
        4	Slot
        5	upnname
        6	Feedername
        7	Username
        8	Datetime
        */


        Date datetime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime = Timestamp.valueOf(sdf.format(datetime));

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(worknumber);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }else if(!userprofiles.stream().findFirst().get().getDepartment().contains("PDA上料")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "非规定的可上料账号，无法操作！");
            response.getWriter().print(Request);
            return;
        }


//2024-01 取消校验槽位上是否有UPN
        // List<Upn> checkupn = UpnMapper.UpnGetByMOIDAndEQPNameAndSlot(moid, eqpname, slot);

//        if (checkupn.size() > 0) {
//            //插入错误log
//            String message ="错误：上料，槽位已有UPN";//错误原因
//            Lists.add(0,moid);
//            Lists.add(1,moname);
//            Lists.add(2,message);
//            Lists.add(3,eqpname);
//            Lists.add(4,slot);
//            Lists.add(5,upnname);
//            Lists.add(6,feeder);
//            Lists.add(7,worknumber);
//            Lists.add(8,sdf.format(datetime));
//            InsertMaterialhistory(Lists);
//
//            Request.put("code", 200);
//            Request.put("status", false);
//            Request.put("message", "该上料任务的槽位已有UPN，不允许再上料！");
//            response.getWriter().print(Request);
//            return;
//        }

        List<Upn> upninfo = UpnMapper.GetUpnByUpnname(upnname);

        if (upninfo.size() > 0) {

            Materialorder materialorder0 = MaterialorderMapper.selectByPrimaryKey(moid);
            
            moname = materialorder0.getMoname();


            Prp_lot prp_lot = Prp_lotMapper.selectByPrimaryKey(materialorder0.getLotid());
            Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getPnid());
            String orgpnMessage = validateOrgpn(json, partnumber);
            if (orgpnMessage != null) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", orgpnMessage);
                response.getWriter().print(Request);
                return;
            }
            String pn = partnumber.getPn();
            String upn_smt = "732D4EE6E2C046A9936378840989A365";
            List<Loadinglistcontent> loadinglistcontents = LoadinglistcontentMapper.selectByPrimaryKeyLlid(materialorder0.getLlid());

            if (loadinglistcontents.size() < 1) {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "找不到站位表");
                response.getWriter().print(Request);
                return;
            } else {
                loadinglistcontents = loadinglistcontents.stream().filter(loadinglistcontent ->loadinglistcontent.getPn()!=null && loadinglistcontent.getPn().equals(pn) || loadinglistcontent.getAlternatepn().equals(pn))
                        .filter(loadinglistcontent ->loadinglistcontent.getSlot()!=null && loadinglistcontent.getSlot().equals(slot))
                        .collect(Collectors.toList());
                if (loadinglistcontents.size() < 1) {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "找不到站位表中的料号");
                    response.getWriter().print(Request);
                    return;
                }
            }
            Loadinglistcontent loadinglistcontent = loadinglistcontents.stream().findFirst().get();

            if (GetOkSlotCount(moid, slot, loadinglistcontent.getPn(), eqpname) > 0 || GetOkSlotCount(moid, slot, loadinglistcontent.getAlternatepn(), eqpname) > 0) {
                if (upninfo.size() > 0) {
                    if (upninfo.stream().anyMatch(upn -> !upn.getState().equals("ACTIVE"))) {
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "该UPN状态不可用");
                        response.getWriter().print(Request);
                        return;
                    }
                    //检查UPN是否已发料
                    if (upninfo.stream().anyMatch(upn -> upn.getCurrentstepid().equals(upn_smt))) {
                        List<Rmm_picklist> rmm_picklists = rmm_picklistMapper.selectByUpn(upnname);
                        if(rmm_picklists.size()>0){
                            if(!hasMatchingIssuedWorkorderProduct(rmm_picklists, prp_lot.getProductpn())){
                                Request.put("code", 200);
                                Request.put("status", false);
                                Request.put("message", "该UPN发料的成品料号与当前备料任务的成品料号不匹配！");
                                response.getWriter().print(Request);
                                return;
                            }
                        }else {
                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "此UPN:" + upnname + "未发料到工单！");
                            response.getWriter().print(Request);
                            return;
                        }
                        //if(rmm_picklists.stream().anyMatch(rmm_picklist -> rmm_picklist.getUpn().equals(upnname))){
                        if (upninfo.stream().anyMatch(upn -> upn.getMoid() == null)) {//是否有绑定上料任务
                            if (upninfo.stream().anyMatch(upn -> upn.getEqpname() == null)) {//是否有绑定设备
                                if (upninfo.stream().anyMatch(upn -> upn.getFeederid() == null)) {//是否有绑定飞达
                                    if (upninfo.stream().anyMatch(upn -> upn.getSlot() == null)) {//是否有绑定槽位
                                        //开始检查传输过来的数据有无问题
                                        //moid、eqpname、upn、slot在前面已检查
                                        List<Feeder> feederinfo = FeederMapper.GetFeederByFeedername(feeder);
                                        if (feederinfo.size() > 0) {//是否有这个飞达
                                            List<Upn> upnfeeder = UpnMapper.GetUpnByFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                            if (upnfeeder.size() > 0 && !upnfeeder.stream().findFirst().get().getUpnname().equals(upnname)) {
                                                //插入错误log
                                                String message ="错误：备料，飞达已绑定到其他UPN："+upnfeeder.stream().findFirst().get().getUpnname() ;//错误原因
                                                Lists.add(0,moid);
                                                Lists.add(1,moname);
                                                Lists.add(2,message);
                                                Lists.add(3,eqpname);
                                                Lists.add(4,slot);
                                                Lists.add(5,upnname);
                                                Lists.add(6,feeder);
                                                Lists.add(7,worknumber);
                                                Lists.add(8,sdf.format(datetime));
                                                InsertMaterialhistory(Lists);

                                                Request.put("code", 200);
                                                Request.put("status", false);
                                                Request.put("message", "该飞达已绑定到其他UPN：" + upnfeeder.stream().findFirst().get().getUpnname() + "上！");
                                                response.getWriter().print(Request);
                                                return;
                                            }
                                            List<Eqp> eqpinfo = EqpMapper.GetEqpbyEqpname(eqpname);
                                            //设备与飞达是否匹配
                                            if (eqpinfo.stream().findFirst().get().getEqptypeid().equals(feederinfo.stream().findFirst().get().getEqptypeid())) {
                                                //更新UPN信息
                                                Upn upn = upninfo.stream().findFirst().get();
                                                upn.setEqpname(eqpname);
                                                upn.setFeederid(feederinfo.stream().findFirst().get().getFeederid());
                                                upn.setSlot(slot);
                                                upn.setMoid(moid);
                                                int updateUpn = UpnMapper.updateByPrimaryKey(upn);

                                                if (updateUpn > 0) {
                                                    List<Rmm_dewcelltimecontrol> rmm_dewcelltimecontrolInfo = Rmm_dewcelltimecontrolMapper.selectByUpnid(upn.getUpnid());
                                                    if (rmm_dewcelltimecontrolInfo.size() > 0) {
                                                        Rmm_dewcelltimecontrol rmm_dewcelltimecontrol = rmm_dewcelltimecontrolInfo.stream().findFirst().get();
                                                        rmm_dewcelltimecontrol.setFshbreaktime(datetime);
                                                        Rmm_dewcelltimecontrolMapper.updateByPrimaryKey(rmm_dewcelltimecontrol);
                                                    }
                                                    //更新或插入
                                                    List<Loadmaterial> loadmaterials = LoadmaterialMapper.LoadmateriaInfoGetByEqpandSlot(moid, eqpname, slot);
                                                    //assert loadmaterials != null;

                                                    List<Loadmaterial> loadmaterials1 = loadmaterials.stream()
                                                            .filter(loadmaterial -> loadmaterial.getTaskname()== null)
                                                            .collect(Collectors.toList());
                                                    Loadmaterial loadmaterial;
                                                    if(loadmaterials1.size() >= 1 ){
                                                        loadmaterial = loadmaterials1.stream().findFirst().
                                                                orElseThrow(() -> new RuntimeException("未找到taskname为null的Loadmaterial对象"));
                                                        loadmaterial.setTaskname("LoadFeeders");
                                                        loadmaterial.setFeeder(feeder);
                                                        //直接更新
                                                        LoadmaterialMapper.updateByPrimaryKey(loadmaterial);
                                                    }else{
                                                        loadmaterial = loadmaterials.stream().findFirst().get();
                                                        loadmaterial.setTaskname("LoadFeeders");
                                                        loadmaterial.setFeeder(feeder);
                                                        loadmaterial.setLmid(UtilityMethod.GetUUID());
                                                        //插入新的数据
                                                        LoadmaterialMapper.insert(loadmaterial);
                                                    }
                                                    //loadmaterial = loadmaterials.stream().findFirst().get();




                                                    if(!materialorder0.getStatus().equals("LOADPARTS_F")){
                                                        List<Loadmaterial> loadmaterial1 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid);
                                                        List<Loadmaterial> loadmaterial2 = LoadmaterialMapper.LoadmateriaInfoGetByMoid(moid).stream().filter(l2 -> l2.getTaskname() == null).collect(Collectors.toList());
                                                        boolean canFinsh = true;
                                                        if (loadmaterial2.size() == 0 && loadmaterial1.size() > 0) {
                                                            if(!materialorder0.getStatus().equals("LOADPARTS_F")){
                                                                materialorder0.setStatus("LOADPARTS_F");
                                                                int updateMaterialorder = MaterialorderMapper.updateByPrimaryKey(materialorder0);
                                                            }

                                                        } else {
                                                            if (loadmaterial1.size() > 0) {
                                                                for (Loadmaterial l2 : loadmaterial2) {
                                                                    if (loadmaterial1.stream().noneMatch(l1 -> l1.getPn().equals(l2.getPn()) && l1.getTaskname() != null)) {
                                                                        canFinsh = false;
                                                                        break;
                                                                    }
                                                                }
                                                                if (canFinsh) {
                                                                    materialorder0.setStatus("LOADPARTS_F");
                                                                    int updateMaterialorder = MaterialorderMapper.updateByPrimaryKey(materialorder0);
                                                                }
                                                            }
                                                        }
                                                    }

                                                    //插入记录
                                                    Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
                                                    Materialhistory materialhistory = new Materialhistory();
                                                    materialhistory.setMhid(UtilityMethod.GetUUID());
                                                    materialhistory.setMoid(moid);
                                                    materialhistory.setMoname(moname);
                                                    materialhistory.setTaskname("LoadParts");
                                                    materialhistory.setEqpname(eqpname);
                                                    materialhistory.setSlot(slot);
                                                    materialhistory.setPn(pn);
                                                    materialhistory.setQty(loadmaterial.getQty());
                                                    materialhistory.setBoardside(loadmaterial.getBoardside());
                                                    materialhistory.setUpnname(upnname);
                                                    materialhistory.setUpnqty(upn.getRemainingqty());
                                                    materialhistory.setFeedername(feeder);
                                                    materialhistory.setUsername(worknumber);
                                                    materialhistory.setDatetime(sdf.format(datetime));
                                                    int insertMaterialhistory = MaterialhistoryMapper.insert(materialhistory);

                                                    ReplenishUpn replenishUpn = new ReplenishUpn();
                                                    replenishUpn.setReplenishgroupid(UtilityMethod.GetUUID());
                                                    replenishUpn.setUpnid(upn.getUpnid());
                                                    replenishUpn.setSlot(slot);
                                                    replenishUpn.setCurrentflag("Y");
                                                    replenishUpn.setReplenishupnid(UtilityMethod.GetUUID());
                                                    replenishUpn.setUsername(upnname);
                                                    replenishUpn.setMoid(moid);
                                                    replenishUpn.setDatetime(datetime);
                                                    int insertReplenishUpn = ReplenishUpnMapper.insert(replenishUpn);
                                                    upn.setReplenishgroupid(replenishUpn.getReplenishgroupid());
                                                    int updateUpn2 = UpnMapper.updateByPrimaryKey(upn);

                                                    List<Wip_upnhist> wip_upnhists = Wip_upnhistMapper.Wip_upnhistsGetbyUpnidAndMoid(upn.getUpnid(), moid);
                                                    if (wip_upnhists.size() > 0) {
                                                        int updateWip_upnhist = Wip_upnhistMapper.Wip_upnhistUpdateEndtimeNull(wip_upnhists.stream().findFirst().get());
                                                    } else {
                                                        Wip_upnhist wip_upnhist = new Wip_upnhist();
                                                        wip_upnhist.setHistid(UtilityMethod.GetUUID());
                                                        wip_upnhist.setLotid(materialorder.getLotid());
                                                        wip_upnhist.setMoid(moid);
                                                        wip_upnhist.setUpnid(upn.getUpnid());
                                                        wip_upnhist.setBegintime(datetime);
                                                        wip_upnhist.setSlot(slot);
                                                        int insertWip_upnhist = Wip_upnhistMapper.insert(wip_upnhist);
                                                    }

                                                    Request.put("code", 200);
                                                    Request.put("status", true);
                                                    Request.put("message", "槽位：" + slot + "，备料OK！");
                                                    response.getWriter().print(Request);
                                                    //materialModuleMapper.A03_SHIMIN_SMT("PDA上料",upnname,moid,materialorder.getLineid(),"","",worknumber);


                                                }
                                            } else {
                                                //插入错误log
                                                String message ="错误：备料，设备与飞达不匹配";//错误原因
                                                Lists.add(0,moid);
                                                Lists.add(1,moname);
                                                Lists.add(2,message);
                                                Lists.add(3,eqpname);
                                                Lists.add(4,slot);
                                                Lists.add(5,upnname);
                                                Lists.add(6,feeder);
                                                Lists.add(7,worknumber);
                                                Lists.add(8,sdf.format(datetime));
                                                InsertMaterialhistory(Lists);

                                                Request.put("code", 200);
                                                Request.put("status", false);
                                                Request.put("message", "该设备：" + eqpname + "与该飞达：" + feeder + "不匹配！");
                                                response.getWriter().print(Request);
                                            }
                                        } else {
                                            //插入错误log
                                            String message ="错误：备料，找不到飞达";//错误原因
                                            Lists.add(0,moid);
                                            Lists.add(1,moname);
                                            Lists.add(2,message);
                                            Lists.add(3,eqpname);
                                            Lists.add(4,slot);
                                            Lists.add(5,upnname);
                                            Lists.add(6,feeder);
                                            Lists.add(7,worknumber);
                                            Lists.add(8,sdf.format(datetime));
                                            InsertMaterialhistory(Lists);
                                            Request.put("code", 200);
                                            Request.put("status", false);
                                            Request.put("message", "找不到飞达！");
                                            response.getWriter().print(Request);
                                        }

                                    } else {
                                        //插入错误log
                                        String message ="错误：备料，UPN已与槽位"+slot+"绑定";//错误原因
                                        Lists.add(0,moid);
                                        Lists.add(1,moname);
                                        Lists.add(2,message);
                                        Lists.add(3,eqpname);
                                        Lists.add(4,slot);
                                        Lists.add(5,upnname);
                                        Lists.add(6,feeder);
                                        Lists.add(7,worknumber);
                                        Lists.add(8,sdf.format(datetime));
                                        InsertMaterialhistory(Lists);

                                        Request.put("code", 200);
                                        Request.put("status", false);
                                        Request.put("message", "该UPN已与槽位" + slot + "绑定！");
                                        response.getWriter().print(Request);
                                    }
                                } else {
                                    Feeder feederinfo = FeederMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getFeederid());
                                    //插入错误log
                                    String message ="错误：备料，UPN已与飞达" + feederinfo.getFeedername() + "绑定";//错误原因
                                    Lists.add(0,moid);
                                    Lists.add(1,moname);
                                    Lists.add(2,message);
                                    Lists.add(3,eqpname);
                                    Lists.add(4,slot);
                                    Lists.add(5,upnname);
                                    Lists.add(6,feeder);
                                    Lists.add(7,worknumber);
                                    Lists.add(8,sdf.format(datetime));
                                    InsertMaterialhistory(Lists);

                                    Request.put("code", 200);
                                    Request.put("status", false);
                                    Request.put("message", "该UPN已与飞达" + feederinfo.getFeedername() + "绑定！");
                                    response.getWriter().print(Request);
                                }
                            } else {
                                //插入错误log
                                String message ="错误：备料，UPN已与设备" + upninfo.stream().findFirst().get().getEqpname() + "绑定";//错误原因
                                Lists.add(0,moid);
                                Lists.add(1,moname);
                                Lists.add(2,message);
                                Lists.add(3,eqpname);
                                Lists.add(4,slot);
                                Lists.add(5,upnname);
                                Lists.add(6,feeder);
                                Lists.add(7,worknumber);
                                Lists.add(8,sdf.format(datetime));
                                InsertMaterialhistory(Lists);

                                Request.put("code", 200);
                                Request.put("status", false);
                                Request.put("message", "该UPN已与设备" + upninfo.stream().findFirst().get().getEqpname() + "绑定！");
                                response.getWriter().print(Request);
                            }


                        } else {
                            //插入错误log
                            Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getMoid());
                            String message ="错误：备料，UPN已与上料任务" +   materialorderinfo.getMoname()  + "绑定";//错误原因
                            Lists.add(0,moid);
                            Lists.add(1,moname);
                            Lists.add(2,message);
                            Lists.add(3,eqpname);
                            Lists.add(4,slot);
                            Lists.add(5,upnname);
                            Lists.add(6,feeder);
                            Lists.add(7,worknumber);
                            Lists.add(8,sdf.format(datetime));
                            InsertMaterialhistory(Lists);

                            Request.put("code", 200);
                            Request.put("status", false);
                            Request.put("message", "该UPN已与上料任务" + materialorderinfo.getMoname() + "绑定！");
                            response.getWriter().print(Request);
                        }
                        // }
                            /*else {
                                Request.put("code",200);
                                Request.put("status",false);
                                Request.put("message","此UPN未发料到当前工单，请确认");
                                response.getWriter().print(Request);
                            }*/


                        /*}else {
                            Request.put("code",200);
                            Request.put("status",false);
                            Request.put("message","此批次/工单未发料，请确认");
                            response.getWriter().print(Request);
                        }*/

                    } else {
                        Request.put("code", 200);
                        Request.put("status", false);
                        Request.put("message", "此UPN:" + upnname + "未从仓库发料！");
                        response.getWriter().print(Request);
                    }

                } else {
                    Request.put("code", 200);
                    Request.put("status", false);
                    Request.put("message", "该UPN不存在或剩余数量等于0！");
                    response.getWriter().print(Request);
                }
            } else {
                //插入错误log
                Materialorder materialorderinfo = MaterialorderMapper.selectByPrimaryKey(upninfo.stream().findFirst().get().getMoid());
                String message ="错误：备料，可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用";//错误原因
                Lists.add(0,moid);
                Lists.add(1,moname);
                Lists.add(2,message);
                Lists.add(3,eqpname);
                Lists.add(4,slot);
                Lists.add(5,upnname);
                Lists.add(6,feeder);
                Lists.add(7,worknumber);
                Lists.add(8,sdf.format(datetime));
                InsertMaterialhistory(Lists);
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "失败！可能原因：设备不匹配、料号不匹配、槽位不匹配、已被其他任务占用！");
                response.getWriter().print(Request);
            }
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "UPN不存在！");
            response.getWriter().print(Request);
        }

    }

    @Override
    public void Searchematerialstatus(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = "";
        String line = "";
        String moid = "";

        List<Map<String, Object>> moList = GetMobyEqpname(eqpname);
        if (moList.size() > 0) {
            moname = moList.get(0).get("MONAME").toString();
            line = moList.get(0).get("AREANAME").toString();
            moid = moList.get(0).get("MOID").toString();
           /*for(Map<String,Object> ml : moList){
                String moname="";
            }*/
            List<Map<String, Object>> data = materialModuleMapper.Searchematerialstatus(moid,eqpname);
            Request.put("code", 200);
            Request.put("status", true);

            Request.put("message", "success");
            Request.put("moname", moname);
            Request.put("line", line);
            Request.put("moid", moid);
            Request.put("data", data);




            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务，请检查！");
            response.getWriter().print(Request);
        }
    }


    @Override
    public void SearchematerialstatusNoCom(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = "";
        String line = "";
        String moid = "";

        List<Map<String, Object>> moList = GetMobyEqpname(eqpname);
        if (moList.size() > 0) {
            moname = moList.get(0).get("MONAME").toString();
            line = moList.get(0).get("AREANAME").toString();
            moid = moList.get(0).get("MOID").toString();
           /*for(Map<String,Object> ml : moList){
                String moname="";
            }*/
            List<Map<String, Object>> data = materialModuleMapper.SearchematerialstatusNoCom(moid,eqpname);
            Request.put("code", 200);
            Request.put("status", true);

            Request.put("message", "success");
            Request.put("moname", moname);
            Request.put("line", line);
            Request.put("moid", moid);
            Request.put("data", data);




            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务，请检查！");
            response.getWriter().print(Request);
        }
    }

    @Override
    public void SearchLoadStartsmaterialstatusNoCom(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String moname = "";
        String line = "";
        String moid = "";

        List<Map<String, Object>> moList = GetLoadMobyEqpname(eqpname);
        if (moList.size() > 0) {
            moname = moList.get(0).get("MONAME").toString();
            line = moList.get(0).get("AREANAME").toString();
            moid = moList.get(0).get("MOID").toString();
           /*for(Map<String,Object> ml : moList){
                String moname="";
            }*/
            List<Map<String, Object>> data = materialModuleMapper.SearchematerialstatusNoCom(moid,eqpname);
            Request.put("code", 200);
            Request.put("status", true);

            Request.put("message", "success");
            Request.put("moname", moname);
            Request.put("line", line);
            Request.put("moid", moid);
            Request.put("data", data);




            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务，请检查！");
            response.getWriter().print(Request);
        }
    }

    @Override
    public void GetCartonlist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String cartoncode = json.getString("worknumber");

        List<Map<String, Object>> data  = materialModuleMapper.GetPACK_MERGE_SPLITFROMCODE(cartoncode);
        if (data.size() > 0) {
            //for (Step s : steps) {ca
            Request.put("cartonlist", data);
            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "mix");
            response.getWriter().print(Request);
        } else {

            List<Packcarton> packcarton = packcartonMapper.PackcartonGetByCartoncode(cartoncode);
            if(packcarton.size()>0){
                Request.put("cartonlist", packcarton.get(0));
                Request.put("code", 200);

                Request.put("status", true);
                Request.put("message", "single");
                response.getWriter().print(Request);
            }else {
                Request.put("code", 200);
                Request.put("status", false);
                Request.put("message", "无法找到该卡通号" + cartoncode);
                response.getWriter().print(Request);
            }
        }
    }

    @Override
    public void GetLoadinglist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String lotname = json.getString("lotname");

        List<Prp_lot> prp_lot =  Prp_lotMapper.selectByLotname(lotname);
        List<Loadinglist> loadinglist = LoadinglistMapper.selectByProductname(prp_lot.get(0).getProductpn())
                .stream().filter(loadinglist1 ->loadinglist1.getStatus()==null || !loadinglist1.getStatus().equals("UNPASS"))
                .filter(loadinglist1 -> loadinglist1.getStatus()==null||!loadinglist1.getStatus().equals("LOCK"))
                .collect(Collectors.toList());
        //Loadinglistcontent loadinglistcontent =
        if (loadinglist.size() > 0) {
            //for (Step s : steps) {
            Request.put("loadinglist", loadinglist);

            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "success");

            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该工单对应的站位表，请检查！");
            response.getWriter().print(Request);
        }
    }
    @Override
    public void GetLoadinglistSlot(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String upn = json.getString("upn");
        String llid = json.getString("llid");
        String pn="";

        List<Upn> upninfo =  UpnMapper.GetUpnByUpnname(upn);
        if(!(upninfo.size() > 0)){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "找不到该UPN，请检查！");
            response.getWriter().print(Request);
            return;
        }
        Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.get(0).getPnid());
        pn = partnumber.getPn();


        List<Map<String, Object>> data = materialModuleMapper.SearchLoadinglistcontentSlot(upninfo.get(0).getUpnname(),pn,llid);



            Request.put("code", 200);
            Request.put("status", true);
            Request.put("data", data);
            Request.put("message", "success");
            response.getWriter().print(Request);

    }
    @Override
    public void GetGD(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String upn = json.getString("upn");
        //String llid = json.getString("llid");
        String pn="";

        List<Upn> upninfo =  UpnMapper.GetUpnByUpnname(upn);
        if(!(upninfo.size() > 0)){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "找不到该UPN，请检查！");
            response.getWriter().print(Request);
            return;
        }
        if(!upninfo.stream().findFirst().get().getUpnname().contains("0000001")){
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "该UPN不是刮刀，请检查！");
            response.getWriter().print(Request);
            return;
        }
        //Partnumber partnumber = PartnumberMapper.selectByPrimaryKey(upninfo.get(0).getPnid());
        //pn = partnumber.getPn();


        List<Map<String, Object>> data = materialModuleMapper.GetGDUpn(upn);



        Request.put("code", 200);
        Request.put("status", true);
        Request.put("data", data);
        Request.put("message", "success");
        response.getWriter().print(Request);

    }



    @Override
    public void GetMolist(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String username = json.getString("worknumber");
        String moname = "";
        String line = "";
        String moid = "";

        List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }


        List<Map<String, Object>> moList = materialModuleMapper.GetMobyEqpname2(eqpname);
        if (moList.size() > 0) {

            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "success");
            //Request.put("moname", moname);
            Request.put("line", line);
            Request.put("moList", moList);
            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务");
            response.getWriter().print(Request);
        }
    }

    @Override
    public void GetMoInfo(@RequestBody JSONObject json, HttpServletResponse response) throws IOException {
        JSONObject Request = new JSONObject();
        String eqpname = json.getString("eqpname");
        String username = json.getString("worknumber");
        String moname = "";
        //String line = "";
        String moid = json.getString("moid");;

       /* List<Userprofile> userprofiles = userprofileMapper.UserprofileGetByUsername(username);
        if (userprofiles.size() < 1) {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法找到用户！");
            response.getWriter().print(Request);
            return;
        }*/


        Materialorder materialorder = MaterialorderMapper.selectByPrimaryKey(moid);
        if (materialorder!=null) {

            Request.put("code", 200);
            Request.put("status", true);
            Request.put("message", "success");
            Request.put("moname", materialorder.getMoname());
            Area line= areaMapper.selectByPrimaryKey(materialorder.getLineid());
            Request.put("line", line.getAreaname());
            Request.put("moid", materialorder.getMoid());
            response.getWriter().print(Request);
        } else {
            Request.put("code", 200);
            Request.put("status", false);
            Request.put("message", "无法查询到该设备对应的上料任务");
            response.getWriter().print(Request);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> GetLine(@RequestBody Map<String, String> requestBody) {
        // 1. 创建标准响应结构
        Map<String, Object> response = new HashMap<>();
        String lineName = requestBody.get("lineName");

        if (lineName == null || lineName.trim().isEmpty()) {
            response.put("code", 400); // Bad Request
            response.put("message", "线体名不能为空");
            response.put("data", null);
            return ResponseEntity.badRequest().body(response);
        }

        try {
            // 2. 执行业务逻辑
            Area area = areaMapper.selectByAreaname(lineName);

            if (area != null && "LINE".equals(area.getAreatype())) {
                // --- 校验成功 ---
                Map<String, Object> data = new HashMap<>();
                data.put("lineId", area.getAreaid()); // 可以将有效信息放入data
                data.put("lineName", area.getAreaname());

                response.put("code", 200);
                response.put("message", "OK");
                response.put("data", data);
                return ResponseEntity.ok(response);
            } else {
                // --- 校验失败 ---
                response.put("code", 404); // Not Found 更语义化
                response.put("message", "系统找不到扫入的线体，请确认！");
                response.put("data", null);
                return ResponseEntity.status(404).body(response);
            }
        } catch (Exception e) {
            // --- 异常处理 ---
            // logger.error("校验线体时发生异常", e); // 建议记录日志
            response.put("code", 500); // Internal Server Error
            response.put("message", "服务器内部错误");
            response.put("data", null);
            return ResponseEntity.status(500).body(response);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<Map<String, Object>> validateSolderPaste(SolderValidationRequestDto request) {
        // --- 步骤 1: 检查锡膏状态 ---
        String usedStatus = materialModuleMapper.findUsedStatusByUpn(request.getUpn());

        if (usedStatus == null) {
            return createErrorResponse(404, "无效的锡膏UPN, 系统未找到该锡膏信息。");
        }

        // 根据状态进行判断
        if (usedStatus.contains("开始回温")) {
            return createErrorResponse(400, "该锡膏未回温完成, 无法上料。");
        }
        if (usedStatus.contains("开始搅拌")) {
            return createErrorResponse(400, "该锡膏未搅拌完成, 无法上料。");
        }
        // 只有在状态完全等于 "完成搅拌" 时才通过
        if (!"完成搅拌".equals(usedStatus)) {
            return createErrorResponse(400, "该锡膏不符合发料条件, 请确认。当前状态: " + usedStatus);
        }

        // --- 步骤 2: 检查发料线体是否匹配 ---
        String lastLineId = materialModuleMapper.findLastLineIdByUpn(request.getUpn(),request.getLineId());

        if (lastLineId == null) {
            return createErrorResponse(404, "上料失败,线体不匹配。");
        }

        // 核心比对逻辑
        Area areaTo= areaMapper.selectByPrimaryKey(lastLineId);
        Area areaCurrent = areaMapper.selectByPrimaryKey(request.getLineId());
        if (!Objects.equals(lastLineId, request.getLineId())) {
            String errorMessage = String.format("上料失败, 该锡膏应发往线体 [%s], 而当前线体为 [%s]。", areaTo.getAreaname(), areaCurrent.getAreaname());
            return createErrorResponse(400, errorMessage);
        }

        // --- 步骤 3: 校验通过, 记录日志 ---
        try {
            materialModuleMapper.insertLoadingLog(request.getEmployeeId(), request.getUpn(), request.getLineId(), LocalDateTime.now());
        } catch (Exception e) {
            // Log the exception, e.g., logger.error("记录上料日志失败", e);
            return createErrorResponse(500, "数据校验成功, 但记录上料信息时发生内部错误。");
        }

        // --- 步骤 4: 返回成功响应 ---
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        // 将成功信息放入data, 供前端展示
        data.put("success", true);
        data.put("message", "锡膏已验证, 上料成功!");
        data.put("employeeName", request.getEmployeeName()); // 将员工姓名也返回, 方便前端显示

        response.put("code", 200);
        response.put("message", "OK");
        response.put("data", data);

        return ResponseEntity.ok(response);
    }

    /**
     * 创建一个标准的错误响应体
     * @param code HTTP状态码 (或业务码)
     * @param message 错误信息
     * @return ResponseEntity
     */
    private ResponseEntity<Map<String, Object>> createErrorResponse(int code, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("code", code);
        response.put("message", message);
        response.put("data", null);
        return ResponseEntity.status(code).body(response);
    }

}
