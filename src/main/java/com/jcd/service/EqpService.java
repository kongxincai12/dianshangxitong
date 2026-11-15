package com.jcd.service;
import com.alibaba.fastjson.JSONObject;
import com.jcd.model.Mes_avi;
import com.jcd.model.Mes_avi_alarm;
import com.jcd.model.Mes_avi_lotrectime;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EqpService {
    boolean InsertMes_avi(Mes_avi record) throws IOException, SQLException ;

    boolean InsertMesAviAlarm(Mes_avi_alarm alarm) throws IOException, SQLException ;;

    boolean InsertMes_avi_lotrectime(Mes_avi_lotrectime lotSummary) throws IOException, SQLException ;;
}
