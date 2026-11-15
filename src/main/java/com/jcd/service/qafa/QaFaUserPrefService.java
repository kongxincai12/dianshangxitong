package com.jcd.service.qafa;

public interface QaFaUserPrefService {

    String get(String userId, String key);

    void set(String userId, String key, String value);
}
