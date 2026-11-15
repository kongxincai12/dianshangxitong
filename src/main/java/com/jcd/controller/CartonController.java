package com.jcd.controller;
import com.alibaba.fastjson.JSONObject;
import com.jcd.service.CartonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;



@RestController
//@RequestMapping("/carton")
public class CartonController {
    @Autowired
    private CartonService CS;

   // @PostMapping("/inhouse")//成品入库
    public void CartonInhouse(@RequestBody JSONObject json, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("applicaiton/json; charset=utf-8");
        boolean blRet =  CS.CartonInhouse(json, response);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
