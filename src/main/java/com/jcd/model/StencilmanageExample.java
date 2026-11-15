package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StencilmanageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StencilmanageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStencilmanageidIsNull() {
            addCriterion("STENCILMANAGEID is null");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidIsNotNull() {
            addCriterion("STENCILMANAGEID is not null");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidEqualTo(String value) {
            addCriterion("STENCILMANAGEID =", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidNotEqualTo(String value) {
            addCriterion("STENCILMANAGEID <>", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidGreaterThan(String value) {
            addCriterion("STENCILMANAGEID >", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidGreaterThanOrEqualTo(String value) {
            addCriterion("STENCILMANAGEID >=", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidLessThan(String value) {
            addCriterion("STENCILMANAGEID <", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidLessThanOrEqualTo(String value) {
            addCriterion("STENCILMANAGEID <=", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidLike(String value) {
            addCriterion("STENCILMANAGEID like", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidNotLike(String value) {
            addCriterion("STENCILMANAGEID not like", value, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidIn(List<String> values) {
            addCriterion("STENCILMANAGEID in", values, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidNotIn(List<String> values) {
            addCriterion("STENCILMANAGEID not in", values, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidBetween(String value1, String value2) {
            addCriterion("STENCILMANAGEID between", value1, value2, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andStencilmanageidNotBetween(String value1, String value2) {
            addCriterion("STENCILMANAGEID not between", value1, value2, "stencilmanageid");
            return (Criteria) this;
        }

        public Criteria andProductpnIsNull() {
            addCriterion("PRODUCTPN is null");
            return (Criteria) this;
        }

        public Criteria andProductpnIsNotNull() {
            addCriterion("PRODUCTPN is not null");
            return (Criteria) this;
        }

        public Criteria andProductpnEqualTo(String value) {
            addCriterion("PRODUCTPN =", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotEqualTo(String value) {
            addCriterion("PRODUCTPN <>", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnGreaterThan(String value) {
            addCriterion("PRODUCTPN >", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTPN >=", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnLessThan(String value) {
            addCriterion("PRODUCTPN <", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTPN <=", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnLike(String value) {
            addCriterion("PRODUCTPN like", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotLike(String value) {
            addCriterion("PRODUCTPN not like", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnIn(List<String> values) {
            addCriterion("PRODUCTPN in", values, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotIn(List<String> values) {
            addCriterion("PRODUCTPN not in", values, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnBetween(String value1, String value2) {
            addCriterion("PRODUCTPN between", value1, value2, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotBetween(String value1, String value2) {
            addCriterion("PRODUCTPN not between", value1, value2, "productpn");
            return (Criteria) this;
        }

        public Criteria andErppnIsNull() {
            addCriterion("ERPPN is null");
            return (Criteria) this;
        }

        public Criteria andErppnIsNotNull() {
            addCriterion("ERPPN is not null");
            return (Criteria) this;
        }

        public Criteria andErppnEqualTo(String value) {
            addCriterion("ERPPN =", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnNotEqualTo(String value) {
            addCriterion("ERPPN <>", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnGreaterThan(String value) {
            addCriterion("ERPPN >", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnGreaterThanOrEqualTo(String value) {
            addCriterion("ERPPN >=", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnLessThan(String value) {
            addCriterion("ERPPN <", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnLessThanOrEqualTo(String value) {
            addCriterion("ERPPN <=", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnLike(String value) {
            addCriterion("ERPPN like", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnNotLike(String value) {
            addCriterion("ERPPN not like", value, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnIn(List<String> values) {
            addCriterion("ERPPN in", values, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnNotIn(List<String> values) {
            addCriterion("ERPPN not in", values, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnBetween(String value1, String value2) {
            addCriterion("ERPPN between", value1, value2, "erppn");
            return (Criteria) this;
        }

        public Criteria andErppnNotBetween(String value1, String value2) {
            addCriterion("ERPPN not between", value1, value2, "erppn");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andUpnidIsNull() {
            addCriterion("UPNID is null");
            return (Criteria) this;
        }

        public Criteria andUpnidIsNotNull() {
            addCriterion("UPNID is not null");
            return (Criteria) this;
        }

        public Criteria andUpnidEqualTo(String value) {
            addCriterion("UPNID =", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidNotEqualTo(String value) {
            addCriterion("UPNID <>", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidGreaterThan(String value) {
            addCriterion("UPNID >", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidGreaterThanOrEqualTo(String value) {
            addCriterion("UPNID >=", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidLessThan(String value) {
            addCriterion("UPNID <", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidLessThanOrEqualTo(String value) {
            addCriterion("UPNID <=", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidLike(String value) {
            addCriterion("UPNID like", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidNotLike(String value) {
            addCriterion("UPNID not like", value, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidIn(List<String> values) {
            addCriterion("UPNID in", values, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidNotIn(List<String> values) {
            addCriterion("UPNID not in", values, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidBetween(String value1, String value2) {
            addCriterion("UPNID between", value1, value2, "upnid");
            return (Criteria) this;
        }

        public Criteria andUpnidNotBetween(String value1, String value2) {
            addCriterion("UPNID not between", value1, value2, "upnid");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyIsNull() {
            addCriterion("STDFREQUENCY is null");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyIsNotNull() {
            addCriterion("STDFREQUENCY is not null");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyEqualTo(Integer value) {
            addCriterion("STDFREQUENCY =", value, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyNotEqualTo(Integer value) {
            addCriterion("STDFREQUENCY <>", value, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyGreaterThan(Integer value) {
            addCriterion("STDFREQUENCY >", value, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("STDFREQUENCY >=", value, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyLessThan(Integer value) {
            addCriterion("STDFREQUENCY <", value, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("STDFREQUENCY <=", value, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyIn(List<Integer> values) {
            addCriterion("STDFREQUENCY in", values, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyNotIn(List<Integer> values) {
            addCriterion("STDFREQUENCY not in", values, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyBetween(Integer value1, Integer value2) {
            addCriterion("STDFREQUENCY between", value1, value2, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andStdfrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("STDFREQUENCY not between", value1, value2, "stdfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyIsNull() {
            addCriterion("MAXFREQUENCY is null");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyIsNotNull() {
            addCriterion("MAXFREQUENCY is not null");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyEqualTo(Integer value) {
            addCriterion("MAXFREQUENCY =", value, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyNotEqualTo(Integer value) {
            addCriterion("MAXFREQUENCY <>", value, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyGreaterThan(Integer value) {
            addCriterion("MAXFREQUENCY >", value, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAXFREQUENCY >=", value, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyLessThan(Integer value) {
            addCriterion("MAXFREQUENCY <", value, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("MAXFREQUENCY <=", value, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyIn(List<Integer> values) {
            addCriterion("MAXFREQUENCY in", values, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyNotIn(List<Integer> values) {
            addCriterion("MAXFREQUENCY not in", values, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyBetween(Integer value1, Integer value2) {
            addCriterion("MAXFREQUENCY between", value1, value2, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andMaxfrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("MAXFREQUENCY not between", value1, value2, "maxfrequency");
            return (Criteria) this;
        }

        public Criteria andLineidIsNull() {
            addCriterion("LINEID is null");
            return (Criteria) this;
        }

        public Criteria andLineidIsNotNull() {
            addCriterion("LINEID is not null");
            return (Criteria) this;
        }

        public Criteria andLineidEqualTo(String value) {
            addCriterion("LINEID =", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotEqualTo(String value) {
            addCriterion("LINEID <>", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThan(String value) {
            addCriterion("LINEID >", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThanOrEqualTo(String value) {
            addCriterion("LINEID >=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThan(String value) {
            addCriterion("LINEID <", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThanOrEqualTo(String value) {
            addCriterion("LINEID <=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLike(String value) {
            addCriterion("LINEID like", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotLike(String value) {
            addCriterion("LINEID not like", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidIn(List<String> values) {
            addCriterion("LINEID in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotIn(List<String> values) {
            addCriterion("LINEID not in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidBetween(String value1, String value2) {
            addCriterion("LINEID between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotBetween(String value1, String value2) {
            addCriterion("LINEID not between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNull() {
            addCriterion("DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Date value) {
            addCriterion("DATETIME =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Date value) {
            addCriterion("DATETIME <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Date value) {
            addCriterion("DATETIME >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DATETIME >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Date value) {
            addCriterion("DATETIME <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("DATETIME <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Date> values) {
            addCriterion("DATETIME in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Date> values) {
            addCriterion("DATETIME not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Date value1, Date value2) {
            addCriterion("DATETIME between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("DATETIME not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNull() {
            addCriterion("UPDATEUSERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIsNotNull() {
            addCriterion("UPDATEUSERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameEqualTo(String value) {
            addCriterion("UPDATEUSERNAME =", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotEqualTo(String value) {
            addCriterion("UPDATEUSERNAME <>", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThan(String value) {
            addCriterion("UPDATEUSERNAME >", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERNAME >=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThan(String value) {
            addCriterion("UPDATEUSERNAME <", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLessThanOrEqualTo(String value) {
            addCriterion("UPDATEUSERNAME <=", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameLike(String value) {
            addCriterion("UPDATEUSERNAME like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotLike(String value) {
            addCriterion("UPDATEUSERNAME not like", value, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameIn(List<String> values) {
            addCriterion("UPDATEUSERNAME in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotIn(List<String> values) {
            addCriterion("UPDATEUSERNAME not in", values, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameBetween(String value1, String value2) {
            addCriterion("UPDATEUSERNAME between", value1, value2, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpdateusernameNotBetween(String value1, String value2) {
            addCriterion("UPDATEUSERNAME not between", value1, value2, "updateusername");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeIsNull() {
            addCriterion("UPATEDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeIsNotNull() {
            addCriterion("UPATEDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeEqualTo(Date value) {
            addCriterion("UPATEDATETIME =", value, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeNotEqualTo(Date value) {
            addCriterion("UPATEDATETIME <>", value, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeGreaterThan(Date value) {
            addCriterion("UPATEDATETIME >", value, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPATEDATETIME >=", value, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeLessThan(Date value) {
            addCriterion("UPATEDATETIME <", value, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPATEDATETIME <=", value, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeIn(List<Date> values) {
            addCriterion("UPATEDATETIME in", values, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeNotIn(List<Date> values) {
            addCriterion("UPATEDATETIME not in", values, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeBetween(Date value1, Date value2) {
            addCriterion("UPATEDATETIME between", value1, value2, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andUpatedatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPATEDATETIME not between", value1, value2, "upatedatetime");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyIsNull() {
            addCriterion("CURRENTFREQUENCY is null");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyIsNotNull() {
            addCriterion("CURRENTFREQUENCY is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyEqualTo(Integer value) {
            addCriterion("CURRENTFREQUENCY =", value, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyNotEqualTo(Integer value) {
            addCriterion("CURRENTFREQUENCY <>", value, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyGreaterThan(Integer value) {
            addCriterion("CURRENTFREQUENCY >", value, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("CURRENTFREQUENCY >=", value, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyLessThan(Integer value) {
            addCriterion("CURRENTFREQUENCY <", value, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("CURRENTFREQUENCY <=", value, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyIn(List<Integer> values) {
            addCriterion("CURRENTFREQUENCY in", values, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyNotIn(List<Integer> values) {
            addCriterion("CURRENTFREQUENCY not in", values, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyBetween(Integer value1, Integer value2) {
            addCriterion("CURRENTFREQUENCY between", value1, value2, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andCurrentfrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("CURRENTFREQUENCY not between", value1, value2, "currentfrequency");
            return (Criteria) this;
        }

        public Criteria andBoardsideIsNull() {
            addCriterion("BOARDSIDE is null");
            return (Criteria) this;
        }

        public Criteria andBoardsideIsNotNull() {
            addCriterion("BOARDSIDE is not null");
            return (Criteria) this;
        }

        public Criteria andBoardsideEqualTo(String value) {
            addCriterion("BOARDSIDE =", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotEqualTo(String value) {
            addCriterion("BOARDSIDE <>", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideGreaterThan(String value) {
            addCriterion("BOARDSIDE >", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideGreaterThanOrEqualTo(String value) {
            addCriterion("BOARDSIDE >=", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideLessThan(String value) {
            addCriterion("BOARDSIDE <", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideLessThanOrEqualTo(String value) {
            addCriterion("BOARDSIDE <=", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideLike(String value) {
            addCriterion("BOARDSIDE like", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotLike(String value) {
            addCriterion("BOARDSIDE not like", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideIn(List<String> values) {
            addCriterion("BOARDSIDE in", values, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotIn(List<String> values) {
            addCriterion("BOARDSIDE not in", values, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideBetween(String value1, String value2) {
            addCriterion("BOARDSIDE between", value1, value2, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotBetween(String value1, String value2) {
            addCriterion("BOARDSIDE not between", value1, value2, "boardside");
            return (Criteria) this;
        }

        public Criteria andVendorcodeIsNull() {
            addCriterion("VENDORCODE is null");
            return (Criteria) this;
        }

        public Criteria andVendorcodeIsNotNull() {
            addCriterion("VENDORCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVendorcodeEqualTo(String value) {
            addCriterion("VENDORCODE =", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotEqualTo(String value) {
            addCriterion("VENDORCODE <>", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeGreaterThan(String value) {
            addCriterion("VENDORCODE >", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VENDORCODE >=", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeLessThan(String value) {
            addCriterion("VENDORCODE <", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeLessThanOrEqualTo(String value) {
            addCriterion("VENDORCODE <=", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeLike(String value) {
            addCriterion("VENDORCODE like", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotLike(String value) {
            addCriterion("VENDORCODE not like", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeIn(List<String> values) {
            addCriterion("VENDORCODE in", values, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotIn(List<String> values) {
            addCriterion("VENDORCODE not in", values, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeBetween(String value1, String value2) {
            addCriterion("VENDORCODE between", value1, value2, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotBetween(String value1, String value2) {
            addCriterion("VENDORCODE not between", value1, value2, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andMonameIsNull() {
            addCriterion("MONAME is null");
            return (Criteria) this;
        }

        public Criteria andMonameIsNotNull() {
            addCriterion("MONAME is not null");
            return (Criteria) this;
        }

        public Criteria andMonameEqualTo(String value) {
            addCriterion("MONAME =", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameNotEqualTo(String value) {
            addCriterion("MONAME <>", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameGreaterThan(String value) {
            addCriterion("MONAME >", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameGreaterThanOrEqualTo(String value) {
            addCriterion("MONAME >=", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameLessThan(String value) {
            addCriterion("MONAME <", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameLessThanOrEqualTo(String value) {
            addCriterion("MONAME <=", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameLike(String value) {
            addCriterion("MONAME like", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameNotLike(String value) {
            addCriterion("MONAME not like", value, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameIn(List<String> values) {
            addCriterion("MONAME in", values, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameNotIn(List<String> values) {
            addCriterion("MONAME not in", values, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameBetween(String value1, String value2) {
            addCriterion("MONAME between", value1, value2, "moname");
            return (Criteria) this;
        }

        public Criteria andMonameNotBetween(String value1, String value2) {
            addCriterion("MONAME not between", value1, value2, "moname");
            return (Criteria) this;
        }

        public Criteria andLocationidIsNull() {
            addCriterion("LOCATIONID is null");
            return (Criteria) this;
        }

        public Criteria andLocationidIsNotNull() {
            addCriterion("LOCATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andLocationidEqualTo(String value) {
            addCriterion("LOCATIONID =", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidNotEqualTo(String value) {
            addCriterion("LOCATIONID <>", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidGreaterThan(String value) {
            addCriterion("LOCATIONID >", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATIONID >=", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidLessThan(String value) {
            addCriterion("LOCATIONID <", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidLessThanOrEqualTo(String value) {
            addCriterion("LOCATIONID <=", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidLike(String value) {
            addCriterion("LOCATIONID like", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidNotLike(String value) {
            addCriterion("LOCATIONID not like", value, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidIn(List<String> values) {
            addCriterion("LOCATIONID in", values, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidNotIn(List<String> values) {
            addCriterion("LOCATIONID not in", values, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidBetween(String value1, String value2) {
            addCriterion("LOCATIONID between", value1, value2, "locationid");
            return (Criteria) this;
        }

        public Criteria andLocationidNotBetween(String value1, String value2) {
            addCriterion("LOCATIONID not between", value1, value2, "locationid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPntypeIsNull() {
            addCriterion("PNTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPntypeIsNotNull() {
            addCriterion("PNTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPntypeEqualTo(String value) {
            addCriterion("PNTYPE =", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotEqualTo(String value) {
            addCriterion("PNTYPE <>", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeGreaterThan(String value) {
            addCriterion("PNTYPE >", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeGreaterThanOrEqualTo(String value) {
            addCriterion("PNTYPE >=", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeLessThan(String value) {
            addCriterion("PNTYPE <", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeLessThanOrEqualTo(String value) {
            addCriterion("PNTYPE <=", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeLike(String value) {
            addCriterion("PNTYPE like", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotLike(String value) {
            addCriterion("PNTYPE not like", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeIn(List<String> values) {
            addCriterion("PNTYPE in", values, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotIn(List<String> values) {
            addCriterion("PNTYPE not in", values, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeBetween(String value1, String value2) {
            addCriterion("PNTYPE between", value1, value2, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotBetween(String value1, String value2) {
            addCriterion("PNTYPE not between", value1, value2, "pntype");
            return (Criteria) this;
        }

        public Criteria andPnoutdateIsNull() {
            addCriterion("PNOUTDATE is null");
            return (Criteria) this;
        }

        public Criteria andPnoutdateIsNotNull() {
            addCriterion("PNOUTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andPnoutdateEqualTo(Date value) {
            addCriterion("PNOUTDATE =", value, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateNotEqualTo(Date value) {
            addCriterion("PNOUTDATE <>", value, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateGreaterThan(Date value) {
            addCriterion("PNOUTDATE >", value, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateGreaterThanOrEqualTo(Date value) {
            addCriterion("PNOUTDATE >=", value, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateLessThan(Date value) {
            addCriterion("PNOUTDATE <", value, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateLessThanOrEqualTo(Date value) {
            addCriterion("PNOUTDATE <=", value, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateIn(List<Date> values) {
            addCriterion("PNOUTDATE in", values, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateNotIn(List<Date> values) {
            addCriterion("PNOUTDATE not in", values, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateBetween(Date value1, Date value2) {
            addCriterion("PNOUTDATE between", value1, value2, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutdateNotBetween(Date value1, Date value2) {
            addCriterion("PNOUTDATE not between", value1, value2, "pnoutdate");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeIsNull() {
            addCriterion("PNOUTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeIsNotNull() {
            addCriterion("PNOUTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeEqualTo(String value) {
            addCriterion("PNOUTCODE =", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeNotEqualTo(String value) {
            addCriterion("PNOUTCODE <>", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeGreaterThan(String value) {
            addCriterion("PNOUTCODE >", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PNOUTCODE >=", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeLessThan(String value) {
            addCriterion("PNOUTCODE <", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeLessThanOrEqualTo(String value) {
            addCriterion("PNOUTCODE <=", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeLike(String value) {
            addCriterion("PNOUTCODE like", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeNotLike(String value) {
            addCriterion("PNOUTCODE not like", value, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeIn(List<String> values) {
            addCriterion("PNOUTCODE in", values, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeNotIn(List<String> values) {
            addCriterion("PNOUTCODE not in", values, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeBetween(String value1, String value2) {
            addCriterion("PNOUTCODE between", value1, value2, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnoutcodeNotBetween(String value1, String value2) {
            addCriterion("PNOUTCODE not between", value1, value2, "pnoutcode");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyIsNull() {
            addCriterion("PNPCSQTY is null");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyIsNotNull() {
            addCriterion("PNPCSQTY is not null");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyEqualTo(Integer value) {
            addCriterion("PNPCSQTY =", value, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyNotEqualTo(Integer value) {
            addCriterion("PNPCSQTY <>", value, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyGreaterThan(Integer value) {
            addCriterion("PNPCSQTY >", value, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("PNPCSQTY >=", value, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyLessThan(Integer value) {
            addCriterion("PNPCSQTY <", value, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyLessThanOrEqualTo(Integer value) {
            addCriterion("PNPCSQTY <=", value, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyIn(List<Integer> values) {
            addCriterion("PNPCSQTY in", values, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyNotIn(List<Integer> values) {
            addCriterion("PNPCSQTY not in", values, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyBetween(Integer value1, Integer value2) {
            addCriterion("PNPCSQTY between", value1, value2, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andPnpcsqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("PNPCSQTY not between", value1, value2, "pnpcsqty");
            return (Criteria) this;
        }

        public Criteria andProductpn2sIsNull() {
            addCriterion("PRODUCTPN2S is null");
            return (Criteria) this;
        }

        public Criteria andProductpn2sIsNotNull() {
            addCriterion("PRODUCTPN2S is not null");
            return (Criteria) this;
        }

        public Criteria andProductpn2sEqualTo(String value) {
            addCriterion("PRODUCTPN2S =", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sNotEqualTo(String value) {
            addCriterion("PRODUCTPN2S <>", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sGreaterThan(String value) {
            addCriterion("PRODUCTPN2S >", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTPN2S >=", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sLessThan(String value) {
            addCriterion("PRODUCTPN2S <", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTPN2S <=", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sLike(String value) {
            addCriterion("PRODUCTPN2S like", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sNotLike(String value) {
            addCriterion("PRODUCTPN2S not like", value, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sIn(List<String> values) {
            addCriterion("PRODUCTPN2S in", values, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sNotIn(List<String> values) {
            addCriterion("PRODUCTPN2S not in", values, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sBetween(String value1, String value2) {
            addCriterion("PRODUCTPN2S between", value1, value2, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andProductpn2sNotBetween(String value1, String value2) {
            addCriterion("PRODUCTPN2S not between", value1, value2, "productpn2s");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyIsNull() {
            addCriterion("TOTALFREQUENCY is null");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyIsNotNull() {
            addCriterion("TOTALFREQUENCY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyEqualTo(Integer value) {
            addCriterion("TOTALFREQUENCY =", value, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyNotEqualTo(Integer value) {
            addCriterion("TOTALFREQUENCY <>", value, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyGreaterThan(Integer value) {
            addCriterion("TOTALFREQUENCY >", value, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTALFREQUENCY >=", value, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyLessThan(Integer value) {
            addCriterion("TOTALFREQUENCY <", value, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("TOTALFREQUENCY <=", value, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyIn(List<Integer> values) {
            addCriterion("TOTALFREQUENCY in", values, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyNotIn(List<Integer> values) {
            addCriterion("TOTALFREQUENCY not in", values, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyBetween(Integer value1, Integer value2) {
            addCriterion("TOTALFREQUENCY between", value1, value2, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andTotalfrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTALFREQUENCY not between", value1, value2, "totalfrequency");
            return (Criteria) this;
        }

        public Criteria andPnkaikouIsNull() {
            addCriterion("PNKAIKOU is null");
            return (Criteria) this;
        }

        public Criteria andPnkaikouIsNotNull() {
            addCriterion("PNKAIKOU is not null");
            return (Criteria) this;
        }

        public Criteria andPnkaikouEqualTo(String value) {
            addCriterion("PNKAIKOU =", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouNotEqualTo(String value) {
            addCriterion("PNKAIKOU <>", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouGreaterThan(String value) {
            addCriterion("PNKAIKOU >", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouGreaterThanOrEqualTo(String value) {
            addCriterion("PNKAIKOU >=", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouLessThan(String value) {
            addCriterion("PNKAIKOU <", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouLessThanOrEqualTo(String value) {
            addCriterion("PNKAIKOU <=", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouLike(String value) {
            addCriterion("PNKAIKOU like", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouNotLike(String value) {
            addCriterion("PNKAIKOU not like", value, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouIn(List<String> values) {
            addCriterion("PNKAIKOU in", values, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouNotIn(List<String> values) {
            addCriterion("PNKAIKOU not in", values, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouBetween(String value1, String value2) {
            addCriterion("PNKAIKOU between", value1, value2, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnkaikouNotBetween(String value1, String value2) {
            addCriterion("PNKAIKOU not between", value1, value2, "pnkaikou");
            return (Criteria) this;
        }

        public Criteria andPnsizeIsNull() {
            addCriterion("PNSIZE is null");
            return (Criteria) this;
        }

        public Criteria andPnsizeIsNotNull() {
            addCriterion("PNSIZE is not null");
            return (Criteria) this;
        }

        public Criteria andPnsizeEqualTo(String value) {
            addCriterion("PNSIZE =", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeNotEqualTo(String value) {
            addCriterion("PNSIZE <>", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeGreaterThan(String value) {
            addCriterion("PNSIZE >", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeGreaterThanOrEqualTo(String value) {
            addCriterion("PNSIZE >=", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeLessThan(String value) {
            addCriterion("PNSIZE <", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeLessThanOrEqualTo(String value) {
            addCriterion("PNSIZE <=", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeLike(String value) {
            addCriterion("PNSIZE like", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeNotLike(String value) {
            addCriterion("PNSIZE not like", value, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeIn(List<String> values) {
            addCriterion("PNSIZE in", values, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeNotIn(List<String> values) {
            addCriterion("PNSIZE not in", values, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeBetween(String value1, String value2) {
            addCriterion("PNSIZE between", value1, value2, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnsizeNotBetween(String value1, String value2) {
            addCriterion("PNSIZE not between", value1, value2, "pnsize");
            return (Criteria) this;
        }

        public Criteria andPnthicknessIsNull() {
            addCriterion("PNTHICKNESS is null");
            return (Criteria) this;
        }

        public Criteria andPnthicknessIsNotNull() {
            addCriterion("PNTHICKNESS is not null");
            return (Criteria) this;
        }

        public Criteria andPnthicknessEqualTo(String value) {
            addCriterion("PNTHICKNESS =", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessNotEqualTo(String value) {
            addCriterion("PNTHICKNESS <>", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessGreaterThan(String value) {
            addCriterion("PNTHICKNESS >", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessGreaterThanOrEqualTo(String value) {
            addCriterion("PNTHICKNESS >=", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessLessThan(String value) {
            addCriterion("PNTHICKNESS <", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessLessThanOrEqualTo(String value) {
            addCriterion("PNTHICKNESS <=", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessLike(String value) {
            addCriterion("PNTHICKNESS like", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessNotLike(String value) {
            addCriterion("PNTHICKNESS not like", value, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessIn(List<String> values) {
            addCriterion("PNTHICKNESS in", values, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessNotIn(List<String> values) {
            addCriterion("PNTHICKNESS not in", values, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessBetween(String value1, String value2) {
            addCriterion("PNTHICKNESS between", value1, value2, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andPnthicknessNotBetween(String value1, String value2) {
            addCriterion("PNTHICKNESS not between", value1, value2, "pnthickness");
            return (Criteria) this;
        }

        public Criteria andUsedstatusIsNull() {
            addCriterion("USEDSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andUsedstatusIsNotNull() {
            addCriterion("USEDSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andUsedstatusEqualTo(String value) {
            addCriterion("USEDSTATUS =", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusNotEqualTo(String value) {
            addCriterion("USEDSTATUS <>", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusGreaterThan(String value) {
            addCriterion("USEDSTATUS >", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusGreaterThanOrEqualTo(String value) {
            addCriterion("USEDSTATUS >=", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusLessThan(String value) {
            addCriterion("USEDSTATUS <", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusLessThanOrEqualTo(String value) {
            addCriterion("USEDSTATUS <=", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusLike(String value) {
            addCriterion("USEDSTATUS like", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusNotLike(String value) {
            addCriterion("USEDSTATUS not like", value, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusIn(List<String> values) {
            addCriterion("USEDSTATUS in", values, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusNotIn(List<String> values) {
            addCriterion("USEDSTATUS not in", values, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusBetween(String value1, String value2) {
            addCriterion("USEDSTATUS between", value1, value2, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andUsedstatusNotBetween(String value1, String value2) {
            addCriterion("USEDSTATUS not between", value1, value2, "usedstatus");
            return (Criteria) this;
        }

        public Criteria andPnthickdescIsNull() {
            addCriterion("PNTHICKDESC is null");
            return (Criteria) this;
        }

        public Criteria andPnthickdescIsNotNull() {
            addCriterion("PNTHICKDESC is not null");
            return (Criteria) this;
        }

        public Criteria andPnthickdescEqualTo(String value) {
            addCriterion("PNTHICKDESC =", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescNotEqualTo(String value) {
            addCriterion("PNTHICKDESC <>", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescGreaterThan(String value) {
            addCriterion("PNTHICKDESC >", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescGreaterThanOrEqualTo(String value) {
            addCriterion("PNTHICKDESC >=", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescLessThan(String value) {
            addCriterion("PNTHICKDESC <", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescLessThanOrEqualTo(String value) {
            addCriterion("PNTHICKDESC <=", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescLike(String value) {
            addCriterion("PNTHICKDESC like", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescNotLike(String value) {
            addCriterion("PNTHICKDESC not like", value, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescIn(List<String> values) {
            addCriterion("PNTHICKDESC in", values, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescNotIn(List<String> values) {
            addCriterion("PNTHICKDESC not in", values, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescBetween(String value1, String value2) {
            addCriterion("PNTHICKDESC between", value1, value2, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnthickdescNotBetween(String value1, String value2) {
            addCriterion("PNTHICKDESC not between", value1, value2, "pnthickdesc");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnIsNull() {
            addCriterion("PNAPPLYPRODUCTPN is null");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnIsNotNull() {
            addCriterion("PNAPPLYPRODUCTPN is not null");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPN =", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnNotEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPN <>", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnGreaterThan(String value) {
            addCriterion("PNAPPLYPRODUCTPN >", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnGreaterThanOrEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPN >=", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnLessThan(String value) {
            addCriterion("PNAPPLYPRODUCTPN <", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnLessThanOrEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPN <=", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnLike(String value) {
            addCriterion("PNAPPLYPRODUCTPN like", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnNotLike(String value) {
            addCriterion("PNAPPLYPRODUCTPN not like", value, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnIn(List<String> values) {
            addCriterion("PNAPPLYPRODUCTPN in", values, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnNotIn(List<String> values) {
            addCriterion("PNAPPLYPRODUCTPN not in", values, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnBetween(String value1, String value2) {
            addCriterion("PNAPPLYPRODUCTPN between", value1, value2, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnNotBetween(String value1, String value2) {
            addCriterion("PNAPPLYPRODUCTPN not between", value1, value2, "pnapplyproductpn");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsIsNull() {
            addCriterion("PNAPPLYPRODUCTPNS is null");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsIsNotNull() {
            addCriterion("PNAPPLYPRODUCTPNS is not null");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPNS =", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsNotEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPNS <>", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsGreaterThan(String value) {
            addCriterion("PNAPPLYPRODUCTPNS >", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsGreaterThanOrEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPNS >=", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsLessThan(String value) {
            addCriterion("PNAPPLYPRODUCTPNS <", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsLessThanOrEqualTo(String value) {
            addCriterion("PNAPPLYPRODUCTPNS <=", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsLike(String value) {
            addCriterion("PNAPPLYPRODUCTPNS like", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsNotLike(String value) {
            addCriterion("PNAPPLYPRODUCTPNS not like", value, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsIn(List<String> values) {
            addCriterion("PNAPPLYPRODUCTPNS in", values, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsNotIn(List<String> values) {
            addCriterion("PNAPPLYPRODUCTPNS not in", values, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsBetween(String value1, String value2) {
            addCriterion("PNAPPLYPRODUCTPNS between", value1, value2, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnapplyproductpnsNotBetween(String value1, String value2) {
            addCriterion("PNAPPLYPRODUCTPNS not between", value1, value2, "pnapplyproductpns");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnIsNull() {
            addCriterion("PNSTENCILPN is null");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnIsNotNull() {
            addCriterion("PNSTENCILPN is not null");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnEqualTo(String value) {
            addCriterion("PNSTENCILPN =", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnNotEqualTo(String value) {
            addCriterion("PNSTENCILPN <>", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnGreaterThan(String value) {
            addCriterion("PNSTENCILPN >", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnGreaterThanOrEqualTo(String value) {
            addCriterion("PNSTENCILPN >=", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnLessThan(String value) {
            addCriterion("PNSTENCILPN <", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnLessThanOrEqualTo(String value) {
            addCriterion("PNSTENCILPN <=", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnLike(String value) {
            addCriterion("PNSTENCILPN like", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnNotLike(String value) {
            addCriterion("PNSTENCILPN not like", value, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnIn(List<String> values) {
            addCriterion("PNSTENCILPN in", values, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnNotIn(List<String> values) {
            addCriterion("PNSTENCILPN not in", values, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnBetween(String value1, String value2) {
            addCriterion("PNSTENCILPN between", value1, value2, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andPnstencilpnNotBetween(String value1, String value2) {
            addCriterion("PNSTENCILPN not between", value1, value2, "pnstencilpn");
            return (Criteria) this;
        }

        public Criteria andStenciltypeIsNull() {
            addCriterion("STENCILTYPE is null");
            return (Criteria) this;
        }

        public Criteria andStenciltypeIsNotNull() {
            addCriterion("STENCILTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andStenciltypeEqualTo(String value) {
            addCriterion("STENCILTYPE =", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeNotEqualTo(String value) {
            addCriterion("STENCILTYPE <>", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeGreaterThan(String value) {
            addCriterion("STENCILTYPE >", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeGreaterThanOrEqualTo(String value) {
            addCriterion("STENCILTYPE >=", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeLessThan(String value) {
            addCriterion("STENCILTYPE <", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeLessThanOrEqualTo(String value) {
            addCriterion("STENCILTYPE <=", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeLike(String value) {
            addCriterion("STENCILTYPE like", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeNotLike(String value) {
            addCriterion("STENCILTYPE not like", value, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeIn(List<String> values) {
            addCriterion("STENCILTYPE in", values, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeNotIn(List<String> values) {
            addCriterion("STENCILTYPE not in", values, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeBetween(String value1, String value2) {
            addCriterion("STENCILTYPE between", value1, value2, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andStenciltypeNotBetween(String value1, String value2) {
            addCriterion("STENCILTYPE not between", value1, value2, "stenciltype");
            return (Criteria) this;
        }

        public Criteria andLotidIsNull() {
            addCriterion("LOTID is null");
            return (Criteria) this;
        }

        public Criteria andLotidIsNotNull() {
            addCriterion("LOTID is not null");
            return (Criteria) this;
        }

        public Criteria andLotidEqualTo(String value) {
            addCriterion("LOTID =", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotEqualTo(String value) {
            addCriterion("LOTID <>", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidGreaterThan(String value) {
            addCriterion("LOTID >", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidGreaterThanOrEqualTo(String value) {
            addCriterion("LOTID >=", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidLessThan(String value) {
            addCriterion("LOTID <", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidLessThanOrEqualTo(String value) {
            addCriterion("LOTID <=", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidLike(String value) {
            addCriterion("LOTID like", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotLike(String value) {
            addCriterion("LOTID not like", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidIn(List<String> values) {
            addCriterion("LOTID in", values, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotIn(List<String> values) {
            addCriterion("LOTID not in", values, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidBetween(String value1, String value2) {
            addCriterion("LOTID between", value1, value2, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotBetween(String value1, String value2) {
            addCriterion("LOTID not between", value1, value2, "lotid");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeIsNull() {
            addCriterion("LASTUSEDTIME is null");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeIsNotNull() {
            addCriterion("LASTUSEDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeEqualTo(Date value) {
            addCriterion("LASTUSEDTIME =", value, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeNotEqualTo(Date value) {
            addCriterion("LASTUSEDTIME <>", value, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeGreaterThan(Date value) {
            addCriterion("LASTUSEDTIME >", value, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LASTUSEDTIME >=", value, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeLessThan(Date value) {
            addCriterion("LASTUSEDTIME <", value, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeLessThanOrEqualTo(Date value) {
            addCriterion("LASTUSEDTIME <=", value, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeIn(List<Date> values) {
            addCriterion("LASTUSEDTIME in", values, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeNotIn(List<Date> values) {
            addCriterion("LASTUSEDTIME not in", values, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeBetween(Date value1, Date value2) {
            addCriterion("LASTUSEDTIME between", value1, value2, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andLastusedtimeNotBetween(Date value1, Date value2) {
            addCriterion("LASTUSEDTIME not between", value1, value2, "lastusedtime");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidIsNull() {
            addCriterion("STENCILUSEDHISTID is null");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidIsNotNull() {
            addCriterion("STENCILUSEDHISTID is not null");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidEqualTo(String value) {
            addCriterion("STENCILUSEDHISTID =", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidNotEqualTo(String value) {
            addCriterion("STENCILUSEDHISTID <>", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidGreaterThan(String value) {
            addCriterion("STENCILUSEDHISTID >", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidGreaterThanOrEqualTo(String value) {
            addCriterion("STENCILUSEDHISTID >=", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidLessThan(String value) {
            addCriterion("STENCILUSEDHISTID <", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidLessThanOrEqualTo(String value) {
            addCriterion("STENCILUSEDHISTID <=", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidLike(String value) {
            addCriterion("STENCILUSEDHISTID like", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidNotLike(String value) {
            addCriterion("STENCILUSEDHISTID not like", value, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidIn(List<String> values) {
            addCriterion("STENCILUSEDHISTID in", values, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidNotIn(List<String> values) {
            addCriterion("STENCILUSEDHISTID not in", values, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidBetween(String value1, String value2) {
            addCriterion("STENCILUSEDHISTID between", value1, value2, "stencilusedhistid");
            return (Criteria) this;
        }

        public Criteria andStencilusedhistidNotBetween(String value1, String value2) {
            addCriterion("STENCILUSEDHISTID not between", value1, value2, "stencilusedhistid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}