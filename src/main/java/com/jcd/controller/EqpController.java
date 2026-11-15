package com.jcd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jcd.model.Mes_avi;
import com.jcd.model.Mes_avi_alarm;
import com.jcd.model.Mes_avi_lotrectime;
import com.jcd.service.EqpService;
import com.jcd.utils.UtilityMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/jcdeqp")
public class EqpController {
    @Autowired
    private EqpService ES;

    /**
     * 1. 检测结果上传接口 (已根据文档修正)
     * @param json
     * @param response
     * @throws IOException
     * @throws ParseException
     */
    @PostMapping("/avi/mdavi_pnl_result_upload")
    public void mdavi_pnl_result_upload(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, ParseException, SQLException {
        JSONObject Request = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 从请求中获取参数
        String eqpNo = json.getString("eqpNo");
        String productnumber = json.getString("productnumber");
        String lot = json.getString("lot");
        String qrcode = json.getString("qrcode");
        Integer goodCount = json.getInteger("goodCount");
        Integer defectiveCount = json.getInteger("defectiveCount");
        Integer sideABDefectCount = json.getInteger("sideABDefectCount");
        Date checkTime = sdf.parse(json.getString("checkTime"));
        String operatorCode = json.getString("operatorCode");

        // 假设 Mes_avi 是用于存储单片检测结果的实体
        Mes_avi mes_avi = new Mes_avi();
        mes_avi.setId(UtilityMethod.GetUUID());
        mes_avi.setSegment1(eqpNo); // 建议在实体中增加对应字段
        mes_avi.setSegment2("牧德");
        mes_avi.setProductnumber(productnumber);
        mes_avi.setLot(lot);
        mes_avi.setQrcode(qrcode);
        mes_avi.setGoodCount(new BigDecimal(goodCount));
        mes_avi.setDefectiveCount(new BigDecimal(defectiveCount));
        mes_avi.setSideAbDefectCount(new BigDecimal(sideABDefectCount)); // 建议在实体中增加对应字段
        mes_avi.setCreatetime(checkTime); // 使用请求中的检测时间
        mes_avi.setCreater(operatorCode);

        // 调用Service层方法进行数据保存
        boolean blRet = ES.InsertMes_avi(mes_avi); // 假设此方法用于插入单片检测数据

        if(blRet){
            Request.put("code", 200);
            Request.put("message", "单片检测数据保存成功"); // 根据文档修正响应消息
        } else {
            Request.put("code", 500); // 建议使用500表示服务器内部错误
            Request.put("message", "数据保存失败");
        }

        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(Request);
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 2. 批次汇总上传接口 (新增)
     * @param json
     * @param response
     * @throws IOException
     * @throws ParseException
     */
    @PostMapping("/avi/mdavi_batch_summary_upload")
    public void mdavi_batch_summary_upload(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, ParseException, SQLException {
        JSONObject Request = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 从请求中获取参数
        String eqpNo = json.getString("eqpNo");
        String productnumber = json.getString("productnumber");
        String lot = json.getString("lot");
        Integer scanTotal = json.getInteger("scanTotal");
        Date startTime = sdf.parse(json.getString("startTime"));
        Date endTime = sdf.parse(json.getString("endTime"));
        BigDecimal totalTime = json.getBigDecimal("totalTime");
        String operatorCode = json.getString("operatorCode");


        Mes_avi_lotrectime lotSummary = new Mes_avi_lotrectime();
        lotSummary.setId(UtilityMethod.GetUUID());
        lotSummary.setEqpNo(eqpNo); // 建议在实体中增加对应字段
        lotSummary.setProductNumber(productnumber);
        lotSummary.setLot(lot);
        lotSummary.setScanTotal(new BigDecimal(scanTotal)); // 建议在实体中增加对应字段
        lotSummary.setStartTime(startTime);
        lotSummary.setEndTime(endTime);
        lotSummary.setTotalTime(totalTime); // 建议在实体中增加对应字段
        lotSummary.setOperatorCode(operatorCode); // 建议在实体中增加对应字段

        // 调用Service层方法进行数据保存
        boolean blRet = ES.InsertMes_avi_lotrectime(lotSummary); // 假设有对应的新增方法

        if(blRet){
            Request.put("code", 200);
            Request.put("message", "批次汇总数据保存成功");
        } else {
            Request.put("code", 500);
            Request.put("message", "服务器内部错误");
        }

        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(Request);
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 3. 设备报警信息上传接口 (新增)
     * @param json
     * @param response
     * @throws IOException
     * @throws ParseException
     */
    @PostMapping("/avi/mdavi_alarm_upload")
    public void mdavi_alarm_upload(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, ParseException, SQLException {
        JSONObject Request = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 从请求中获取参数
        String eqpNo = json.getString("eqpNo");
        String alarmDescription = json.getString("alarmDescription");
        Date alarmTime = sdf.parse(json.getString("alarmTime"));
        String operatorCode = json.getString("operatorCode");

        // 假设 Mes_avi_alarm 是用于存储报警信息的实体
        Mes_avi_alarm alarm = new Mes_avi_alarm();
        alarm.setId(UtilityMethod.GetUUID());
        alarm.setEqpNo(eqpNo); // 建议在实体中增加对应字段
        alarm.setAlarmDescription(alarmDescription); // 建议在实体中增加对应字段
        alarm.setAlarmTime(alarmTime); // 建议在实体中增加对应字段
        alarm.setOperatorCode(operatorCode); // 建议在实体中增加对应字段

        // 调用Service层方法进行数据保存
        boolean blRet = ES.InsertMesAviAlarm(alarm); // 假设有对应的新增方法

        if(blRet){
            Request.put("code", 200);
            Request.put("message", "报警信息上传成功");
        } else {
            Request.put("code", 500);
            Request.put("message", "数据保存失败");
        }

        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(Request);
        response.getWriter().flush();
        response.getWriter().close();
    }
}