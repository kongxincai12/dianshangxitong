package com.jcd.service.qafa.impl;

import com.jcd.mapper.qafa.QaFaUserPrefMapper;
import com.jcd.model.qafa.QaFaUserPref;
import com.jcd.service.qafa.QaFaUserPrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class QaFaUserPrefServiceImpl implements QaFaUserPrefService {

    @Autowired
    private QaFaUserPrefMapper mapper;

    @Override
    public String get(String userId, String key) {
        QaFaUserPref pref = mapper.selectByUserKey(userId, key);
        return pref == null ? null : pref.getPrefValue();
    }

    @Override
    public void set(String userId, String key, String value) {
        QaFaUserPref existing = mapper.selectByUserKey(userId, key);
        if (existing == null) {
            QaFaUserPref pref = new QaFaUserPref();
            pref.setId(UUID.randomUUID().toString().replace("-", ""));
            pref.setUserId(userId);
            pref.setPrefKey(key);
            pref.setPrefValue(value);
            pref.setUpdateTime(new Date());
            mapper.insert(pref);
        } else {
            mapper.updateValue(userId, key, value);
        }
    }
}
