package com.jcd.model;

import java.util.Date;

public class Userprofile {
    private String userid;

    private String username;

    private String password;

    private String fullname;

    private Date activationdate;

    private Date expirationdate;

    private String againperiod;

    private String lastpassworddate;

    private String emailaddress;

    private String emailpwd;

    private String emailserver;

    private String factoryname;

    private String linename;

    private String department;

    private String userposition;

    private String phonenumber;

    private String object2;

    private String object3;

    private String status;

    private String oaaddress;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public Date getActivationdate() {
        return activationdate;
    }

    public void setActivationdate(Date activationdate) {
        this.activationdate = activationdate;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getAgainperiod() {
        return againperiod;
    }

    public void setAgainperiod(String againperiod) {
        this.againperiod = againperiod == null ? null : againperiod.trim();
    }

    public String getLastpassworddate() {
        return lastpassworddate;
    }

    public void setLastpassworddate(String lastpassworddate) {
        this.lastpassworddate = lastpassworddate == null ? null : lastpassworddate.trim();
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress == null ? null : emailaddress.trim();
    }

    public String getEmailpwd() {
        return emailpwd;
    }

    public void setEmailpwd(String emailpwd) {
        this.emailpwd = emailpwd == null ? null : emailpwd.trim();
    }

    public String getEmailserver() {
        return emailserver;
    }

    public void setEmailserver(String emailserver) {
        this.emailserver = emailserver == null ? null : emailserver.trim();
    }

    public String getFactoryname() {
        return factoryname;
    }

    public void setFactoryname(String factoryname) {
        this.factoryname = factoryname == null ? null : factoryname.trim();
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename == null ? null : linename.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getUserposition() {
        return userposition;
    }

    public void setUserposition(String userposition) {
        this.userposition = userposition == null ? null : userposition.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getObject2() {
        return object2;
    }

    public void setObject2(String object2) {
        this.object2 = object2 == null ? null : object2.trim();
    }

    public String getObject3() {
        return object3;
    }

    public void setObject3(String object3) {
        this.object3 = object3 == null ? null : object3.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOaaddress() {
        return oaaddress;
    }

    public void setOaaddress(String oaaddress) {
        this.oaaddress = oaaddress == null ? null : oaaddress.trim();
    }
}