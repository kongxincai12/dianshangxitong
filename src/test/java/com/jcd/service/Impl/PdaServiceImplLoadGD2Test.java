package com.jcd.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.jcd.mapper.MaterialhistoryMapper;
import com.jcd.mapper.MaterialorderMapper;
import com.jcd.mapper.UpnMapper;
import com.jcd.mapper.UserprofileMapper;
import com.jcd.model.Materialorder;
import com.jcd.model.Upn;
import com.jcd.model.Userprofile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PdaServiceImplLoadGD2Test {

    private PdaServiceImpl service;
    private UpnMapper upnMapper;
    private MaterialorderMapper materialorderMapper;
    private MaterialhistoryMapper materialhistoryMapper;

    @BeforeEach
    void setUp() {
        service = new PdaServiceImpl();
        upnMapper = mock(UpnMapper.class);
        materialorderMapper = mock(MaterialorderMapper.class);
        materialhistoryMapper = mock(MaterialhistoryMapper.class);
        UserprofileMapper userprofileMapper = mock(UserprofileMapper.class);

        Userprofile user = new Userprofile();
        user.setDepartment("PDA上料");
        when(userprofileMapper.UserprofileGetByUsername("18071001"))
                .thenReturn(Collections.singletonList(user));

        ReflectionTestUtils.setField(service, "UpnMapper", upnMapper);
        ReflectionTestUtils.setField(service, "MaterialorderMapper", materialorderMapper);
        ReflectionTestUtils.setField(service, "MaterialhistoryMapper", materialhistoryMapper);
        ReflectionTestUtils.setField(service, "userprofileMapper", userprofileMapper);
    }

    @Test
    void reportsTheSecondBladeExistingTask() throws Exception {
        Upn firstBlade = blade("0000001-CZ001-9090", null);
        Upn secondBlade = blade("0000001-CZ001-9091", "existing-moid");
        Materialorder existingOrder = new Materialorder();
        existingOrder.setMoname("EXISTING-MO");

        when(upnMapper.UpnGetGDByMOID("new-moid")).thenReturn(Collections.emptyList());
        when(upnMapper.GetUpnByUpnname(firstBlade.getUpnname()))
                .thenReturn(Collections.singletonList(firstBlade));
        when(upnMapper.GetUpnByUpnname(secondBlade.getUpnname()))
                .thenReturn(Collections.singletonList(secondBlade));
        when(materialorderMapper.selectByPrimaryKey("existing-moid")).thenReturn(existingOrder);

        JSONObject result = invokeLoadGD2();

        assertFalse(result.getBooleanValue("status"));
        assertEquals("刮刀2已有上料任务：EXISTING-MO，不允许再上！", result.getString("message"));
        verify(materialorderMapper).selectByPrimaryKey("existing-moid");
    }

    @Test
    void reportsWhenTheSecondBladeDoesNotExist() throws Exception {
        Upn firstBlade = blade("0000001-CZ001-9090", null);
        when(upnMapper.UpnGetGDByMOID("new-moid")).thenReturn(Collections.emptyList());
        when(upnMapper.GetUpnByUpnname(firstBlade.getUpnname()))
                .thenReturn(Collections.singletonList(firstBlade));
        when(upnMapper.GetUpnByUpnname("0000001-CZ001-9091"))
                .thenReturn(Collections.emptyList());

        JSONObject result = invokeLoadGD2();

        assertFalse(result.getBooleanValue("status"));
        assertEquals("刮刀2不存在！", result.getString("message"));
        verify(materialhistoryMapper).insert(any());
    }

    private JSONObject invokeLoadGD2() throws Exception {
        JSONObject request = new JSONObject();
        request.put("eqpname", "L01-CZFUJI-01");
        request.put("moname", "NEW-MO");
        request.put("line", "AUTOSMT-L01");
        request.put("moid", "new-moid");
        request.put("worknumber", "18071001");
        request.put("upnname", "0000001-CZ001-9090");
        request.put("upnname2", "0000001-CZ001-9091");
        request.put("feeder", "");
        request.put("slotname", "");

        MockHttpServletResponse response = new MockHttpServletResponse();
        response.setCharacterEncoding("UTF-8");
        service.LoadGD2(request, response);
        return JSONObject.parseObject(response.getContentAsString());
    }

    private Upn blade(String upnname, String moid) {
        Upn blade = new Upn();
        blade.setUpnname(upnname);
        blade.setMoid(moid);
        return blade;
    }
}
