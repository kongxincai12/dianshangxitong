package com.jcd.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.jcd.mapper.*;
import com.jcd.model.Mes_avi;
import com.jcd.model.Mes_avi_alarm;
import com.jcd.model.Mes_avi_lotrectime;
import com.jcd.model.Wip_storage;
import com.jcd.service.EqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@Service("EqpService")
public class EqpServiceImpl implements EqpService {
    @Autowired
    @Resource
    private Mes_aviMapper mes_aviMapper;
    @Autowired
    @Resource
    private Mes_avi_lotrectimeMapper mes_avi_lotrectime;
    @Autowired
    @Resource
    private Mes_avi_alarmMapper mes_avi_alarm;
    @Override
    public boolean InsertMes_avi(Mes_avi record) throws IOException, SQLException{
            boolean blRet;
            int iRet = mes_aviMapper.insert(record);
            blRet = iRet > 0;
            return blRet;

    }

    @Override
    public boolean InsertMesAviAlarm(Mes_avi_alarm alarm) throws IOException, SQLException {
        boolean blRet;
        int iRet = mes_avi_alarm.insert(alarm);
        blRet = iRet > 0;
        return blRet;
    }

    @Override
    public boolean InsertMes_avi_lotrectime(Mes_avi_lotrectime lotSummary) throws IOException, SQLException {
        boolean blRet;
        int iRet = mes_avi_lotrectime.insert(lotSummary);
        blRet = iRet > 0;
        return blRet;
    }

}
