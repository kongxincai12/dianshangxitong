package com.jcd.service.Impl;

import com.alibaba.fastjson.JSONObject;
//import com.jcd.Tools.MailSendUtils;
import com.jcd.dto.WorkstationDto;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.*;
import com.jcd.model.*;
import com.jcd.service.CartonService;
import com.jcd.utils.UtilityMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("CartonService")
public class CartonServiceImpl implements CartonService {
    @Autowired
    @Resource
    private PackcartonMapper packcartonMapper;
    @Autowired
    @Resource
    private V_location_allMapper v_location_allMapper;
    @Autowired
    @Resource
    private MlmappinginfoMapper mlmappinginfoMapper;
    @Autowired
    @Resource
    private Wip_storageMapper wip_storageMapper;

    @Autowired
    @Resource
    private Wip_storage_hisMapper wip_storage_hisMapper;

    @Autowired
    @Resource
    private Erp_message_transMapper erp_message_transMapper;

       @Autowired
    @Resource
    private MaterialModuleMapper materialModuleMapper ;

    @Autowired
    @Resource
    private WorkorderMapper workorderMapper ;



   // @Autowired
   // private MailSendUtils mailSendUtils;

    @Override
    public List<Packcarton> PackcartonGetByCartoncode(String cartoncode) {
        return packcartonMapper.PackcartonGetByCartoncode(cartoncode);
    }

    @Override
    public List<V_location_all> V_location_allGetByLoc_name(String loc_name) {
        return v_location_allMapper.V_location_allGetByLoc_name(loc_name);
    }
    @Override
    public List<Mlmappinginfo>  MlmappinginfoGetByPartnumber(String partnumber){
        return mlmappinginfoMapper.MlmappinginfoGetByPartnumber(partnumber);
    }
    @Override
    public List<Mlmappinginfo>  MlmappinginfoGetByPntype(String pntype){
        return mlmappinginfoMapper.MlmappinginfoGetByPntype(pntype);
    }

    @Override
    public  List<Wip_storage> Wip_storageGetByCartoncode(String cartoncode){
        return wip_storageMapper.Wip_storageGetByCartoncode(cartoncode);
    }
    @Override
    public boolean Wip_storageInsert(Wip_storage record){
        boolean blRet;
        int iRet = wip_storageMapper.Wip_storageInsert(record);
        blRet = iRet > 0;
        return blRet;
    }

    @Override
    public boolean Wip_storage_hisInsert(Wip_storage_his record){
        boolean blRet;
        int iRet = wip_storage_hisMapper.Wip_storage_hisInsert(record);
        blRet = iRet > 0;
        return blRet;
    }
    @Override
    public boolean Erp_message_transInsert(Erp_message_trans record){
        boolean blRet;
        int iRet = erp_message_transMapper.Erp_message_transInsert(record);
        blRet = iRet > 0;
        return blRet;
    }

    @Override
    public List<Map<String, Object>> GetStorageWorkorderQty2(String orderid){
        return materialModuleMapper.GetStorageWorkorderQty2(orderid);
    }

    @Override
    public List<Map<String, Object>> GetWorkordersByCarton(String cartoncode){
        return materialModuleMapper.GetWorkordersByCarton(cartoncode);
    }

    @Override
    public boolean updateWorkorderStatus(String state,String orderid){
        boolean blRet;
        int iRet = workorderMapper.updateWorkorderStatus(state,orderid);
        blRet = iRet > 0;
        return blRet;
    }
    @Override
    public boolean Wip_storageUpdate(Wip_storage record){
        boolean blRet;
        int iRet = wip_storageMapper.Wip_storageUpdate(record);
        blRet = iRet > 0;
        return blRet;
    }

    @Override
    public boolean CartonInhouse(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        JSONObject Request = new JSONObject();
        boolean blRet = false;
        String cartoncode = json.getString("cartoncode");
        String locationname = json.getString("locationname");
        String username= json.getString("username");
        //System.out.println(username);
        Date datetime = new Date();
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetime= Timestamp.valueOf(sdf.format(datetime)) ;
        Request.put("code",200);

        //筛选Deleteflag状态为N的卡通
        List<Packcarton> packcartons = PackcartonGetByCartoncode(cartoncode).stream()
                .filter(packcarton ->"N".equals(packcarton.getDeleteflag()))
                .collect(Collectors.toList());

        if(packcartons.size()>0){
            //获取料号
            String productpn = packcartons.stream().findFirst().get().getProductpn();
            //筛选属于成品仓的储位
            List<V_location_all> v_location_alls = V_location_allGetByLoc_name(locationname).stream()
                    .filter(v_location_all -> "6".equals(v_location_all.getLocType()))
                    .filter(v_location_all -> v_location_all.getWharea()!=null)
                    .collect(Collectors.toList());

            if(v_location_alls.size() > 0){
                //首先Mapping料号对应的储位
                List<Mlmappinginfo> mlmappinginfos1 = MlmappinginfoGetByPartnumber(productpn).stream()
                        .filter(mlmappinginfo -> locationname.substring(0, Math.min(mlmappinginfo.getLocation().length(), locationname.length())).equals(mlmappinginfo.getLocation()))
                        .collect(Collectors.toList());
                if(mlmappinginfos1.size()==0){
                    //MAPPING 类别对应储位信息
                    List<Mlmappinginfo> mlmappinginfos2 = MlmappinginfoGetByPntype(productpn.substring(0,3)).stream()
                            .filter(mlmappinginfo -> locationname.substring(0, Math.min(mlmappinginfo.getLocation().length(), locationname.length())).equals(mlmappinginfo.getLocation()))
                            .collect(Collectors.toList());
                    if(mlmappinginfos2.size()==0){
                        Request.put("status",false);
                        Request.put("message","此物料:"+ productpn +" 没有维护与"+locationname+"对应关系！");
                        response.getWriter().print(Request);
                        return false;
                    }
                }
                //取储位id
                String locid = V_location_allGetByLoc_name(locationname).stream().findFirst().get().getLocId();
                //检查Wip_storage有无记录
                List<Wip_storage> wip_storage = Wip_storageGetByCartoncode(cartoncode);
                if(wip_storage.size() > 0){
                    //有记录，状态是否为退包装，退包装可以重新入库
                    if(!"R".equals(wip_storage.stream().findFirst().get().getStatus())){
                        Request.put("status",false);
                        Request.put("message","此卡通状态不允许入库!");
                        response.getWriter().print(Request);
                        return false;
                    }

                }else{
                    //插入状态表
                    Wip_storage wip_storageInsert = new Wip_storage();
                    wip_storageInsert.setStorageid(UtilityMethod.GetUUID());
                    wip_storageInsert.setCartoncode(cartoncode);
                    wip_storageInsert.setLocationid(locid);
                    wip_storageInsert.setStatus("N");
                    wip_storageInsert.setUsername(username);
                    wip_storageInsert.setDatetime(datetime);

                    blRet =Wip_storageInsert(wip_storageInsert);

                    //记 log
                    Wip_storage_his wip_storage_hisInsert = new Wip_storage_his();
                    wip_storage_hisInsert.setStoragehisid(UtilityMethod.GetUUID());
                    wip_storage_hisInsert.setStatus("STORAGE");
                    wip_storage_hisInsert.setCartoncode(cartoncode);
                    wip_storage_hisInsert.setUsername(username);
                    wip_storage_hisInsert.setDatetime(wip_storageInsert.getDatetime());
                    wip_storage_hisInsert.setLocationid(locid);
                    wip_storage_hisInsert.setQty(packcartons.stream().findFirst().get().getCartonqty());

                    blRet &= Wip_storage_hisInsert(wip_storage_hisInsert);

                    if(!blRet){
                        Request.put("status",false);
                        Request.put("message","系统异常！入库异常！请联络IT处理！");
                        response.getWriter().print(Request);
                        return false;
                    }else {
                        //通知接口入库
                        Erp_message_trans erp_message_trans = new Erp_message_trans();
                        erp_message_trans.setId(UtilityMethod.GetUUID());
                        erp_message_trans.setTransactions("工单完工入库");
                        erp_message_trans.setLogtable("WIPSTORAGEHIS");
                        erp_message_trans.setLogtableid(wip_storage_hisInsert.getStoragehisid());
                        erp_message_trans.setTransFlag("0");
                        erp_message_trans.setUsername(username);
                        erp_message_trans.setDatetime(wip_storage_hisInsert.getDatetime());
                        blRet = Erp_message_transInsert(erp_message_trans);

                    }
                }
                if(wip_storage.size() > 0){
                    Wip_storage wip_storageUpdate = wip_storage.get(0);
                    wip_storageUpdate.setLocationid(locid);
                    wip_storageUpdate.setStatus("N");
                    wip_storageUpdate.setUsername(username);
                    wip_storageUpdate.setDatetime(datetime);

                    blRet = Wip_storageUpdate(wip_storageUpdate);

                    //记 log
                    Wip_storage_his wip_storage_hisInsert = new Wip_storage_his();
                    wip_storage_hisInsert.setStoragehisid(UtilityMethod.GetUUID());
                    wip_storage_hisInsert.setStatus("STORAGE");
                    wip_storage_hisInsert.setCartoncode(cartoncode);
                    wip_storage_hisInsert.setUsername(username);
                    wip_storage_hisInsert.setDatetime(wip_storageUpdate.getDatetime());
                    wip_storage_hisInsert.setLocationid(locid);
                    wip_storage_hisInsert.setQty(packcartons.stream().findFirst().get().getCartonqty());

                    blRet &= Wip_storage_hisInsert(wip_storage_hisInsert);
                    if(!blRet){
                        Request.put("status",false);
                        Request.put("message","系统异常！入库异常！请联络IT处理！");
                        response.getWriter().print(Request);
                        return false;
                    }else {
                        //通知接口入库
                        Erp_message_trans erp_message_trans = new Erp_message_trans();
                        erp_message_trans.setId(UtilityMethod.GetUUID());
                        erp_message_trans.setTransactions("工单完工入库");
                        erp_message_trans.setLogtable("WIPSTORAGEHIS");
                        erp_message_trans.setLogtableid(wip_storage_hisInsert.getStoragehisid());
                        erp_message_trans.setTransFlag("0");
                        erp_message_trans.setUsername(username);
                        erp_message_trans.setDatetime(wip_storage_hisInsert.getDatetime());

                        blRet = Erp_message_transInsert(erp_message_trans);

                    }
                }

            } else {
                Request.put("status",false);
                Request.put("message","输入储位:"+locationname+" 不属于成品仓储位!");
                response.getWriter().print(Request);
                return false;
            }
        }else{
            Request.put("status",false);
            Request.put("message","卡通条码:"+cartoncode+"不存在!");
            response.getWriter().print(Request);
            return false;
        }
        List<Map<String, Object>> workorderList = GetWorkordersByCarton(cartoncode);
        if(workorderList.size()>0){
            for (Map<String, Object> wl:workorderList) {
                String workorderid=wl.get("ORDERID").toString();
                List<Map<String, Object>>  storageWorkorderQtyList = GetStorageWorkorderQty2(wl.get("ORDERID").toString());
                if(storageWorkorderQtyList.size() > 0){
                    int workroderqty = storageWorkorderQtyList.get(0).get("STARTQTY") == null ? 0: Integer.parseInt(storageWorkorderQtyList.get(0).get("STARTQTY").toString());
                    int storageqty = storageWorkorderQtyList.get(0).get("LOTTOTALQTY") == null ? 0: Integer.parseInt(storageWorkorderQtyList.get(0).get("STARTQTY").toString());

                    //已入库的数量大于等于工单开工数量是，将其关闭，并回传erp接口
                    if(storageqty >= workroderqty){
                        //更新为FINISH
                        blRet &= updateWorkorderStatus("FINISH",workorderid);

                        Erp_message_trans erp_message_trans2 = new Erp_message_trans();
                        erp_message_trans2.setId(UtilityMethod.GetUUID());
                        erp_message_trans2.setTransactions("工单完工入库");
                        erp_message_trans2.setLogtable("WORKORDER");
                        erp_message_trans2.setLogtableid(workorderid);
                        erp_message_trans2.setTransFlag("0");
                        erp_message_trans2.setUsername(username);
                        erp_message_trans2.setDatetime(datetime);
                        blRet &= Erp_message_transInsert(erp_message_trans2);
                    }
                }
            }
        }


        if(blRet){
            Request.put("status",true);
            Request.put("message","success！入库成功！");
            response.getWriter().print(Request);
            return true;
        }else {
            Request.put("status",false);
            Request.put("message","Faild！入库失败！");
            response.getWriter().print(Request);
            return false;
        }

    }



    //private void
}
