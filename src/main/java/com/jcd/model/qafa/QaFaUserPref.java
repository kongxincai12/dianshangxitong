package com.jcd.model.qafa;

import lombok.Data;

import java.util.Date;

/**
 * 用户偏好 (路径记忆等)
 * 表: QA_FA_USER_PREF
 */
@Data
public class QaFaUserPref {
    private String id;
    private String userId;
    private String prefKey;
    private String prefValue;
    private Date updateTime;
}
