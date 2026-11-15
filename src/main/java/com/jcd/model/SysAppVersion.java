package com.jcd.model;

import lombok.Data;
import java.util.Date;

@Data
public class SysAppVersion {
    private String id;
    private String appId;
    private String platform;
    private String versionName;
    private Integer versionCode;
    private String downloadUrl;
    private String updateNotes;
    private char isForced; // 使用 char or String to match CHAR(1)
    private Date releaseTime;
    private String createBy;
    private Date createTime;
}