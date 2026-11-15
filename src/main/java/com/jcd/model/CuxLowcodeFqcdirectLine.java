package com.jcd.model;

import java.util.Date;

public class CuxLowcodeFqcdirectLine {
    private String id;

    private String HEADID;

    private Long TYPEID;

    private Long TYPEVALUE;

    public Long getTYPEVALUE() {
        return TYPEVALUE;
    }

    public void setTYPEVALUE(Long TYPEVALUE) {
        this.TYPEVALUE = TYPEVALUE;
    }

    public Long getTYPEID() {
        return TYPEID;
    }

    public void setTYPEID(Long TYPEID) {
        this.TYPEID = TYPEID;
    }

    public String getHEADID() {
        return HEADID;
    }

    public void setHEADID(String HEADID) {
        this.HEADID = HEADID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
