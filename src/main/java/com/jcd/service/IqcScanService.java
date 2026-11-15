package com.jcd.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface IqcScanService {


    @Transactional(rollbackFor = Exception.class)
    Map<String, Object> processScan(String scanText, String detailId, String userId) throws Exception;
}
