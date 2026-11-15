package com.jcd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WipExample() {
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

        public Criteria andWipidIsNull() {
            addCriterion("WIPID is null");
            return (Criteria) this;
        }

        public Criteria andWipidIsNotNull() {
            addCriterion("WIPID is not null");
            return (Criteria) this;
        }

        public Criteria andWipidEqualTo(String value) {
            addCriterion("WIPID =", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidNotEqualTo(String value) {
            addCriterion("WIPID <>", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidGreaterThan(String value) {
            addCriterion("WIPID >", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidGreaterThanOrEqualTo(String value) {
            addCriterion("WIPID >=", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidLessThan(String value) {
            addCriterion("WIPID <", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidLessThanOrEqualTo(String value) {
            addCriterion("WIPID <=", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidLike(String value) {
            addCriterion("WIPID like", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidNotLike(String value) {
            addCriterion("WIPID not like", value, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidIn(List<String> values) {
            addCriterion("WIPID in", values, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidNotIn(List<String> values) {
            addCriterion("WIPID not in", values, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidBetween(String value1, String value2) {
            addCriterion("WIPID between", value1, value2, "wipid");
            return (Criteria) this;
        }

        public Criteria andWipidNotBetween(String value1, String value2) {
            addCriterion("WIPID not between", value1, value2, "wipid");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("SN =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("SN <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("SN >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("SN >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("SN <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("SN <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("SN like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("SN not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("SN in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("SN not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("SN between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andTrackingunitIsNull() {
            addCriterion("TRACKINGUNIT is null");
            return (Criteria) this;
        }

        public Criteria andTrackingunitIsNotNull() {
            addCriterion("TRACKINGUNIT is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingunitEqualTo(String value) {
            addCriterion("TRACKINGUNIT =", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitNotEqualTo(String value) {
            addCriterion("TRACKINGUNIT <>", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitGreaterThan(String value) {
            addCriterion("TRACKINGUNIT >", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitGreaterThanOrEqualTo(String value) {
            addCriterion("TRACKINGUNIT >=", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitLessThan(String value) {
            addCriterion("TRACKINGUNIT <", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitLessThanOrEqualTo(String value) {
            addCriterion("TRACKINGUNIT <=", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitLike(String value) {
            addCriterion("TRACKINGUNIT like", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitNotLike(String value) {
            addCriterion("TRACKINGUNIT not like", value, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitIn(List<String> values) {
            addCriterion("TRACKINGUNIT in", values, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitNotIn(List<String> values) {
            addCriterion("TRACKINGUNIT not in", values, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitBetween(String value1, String value2) {
            addCriterion("TRACKINGUNIT between", value1, value2, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andTrackingunitNotBetween(String value1, String value2) {
            addCriterion("TRACKINGUNIT not between", value1, value2, "trackingunit");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("PRODUCTID is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("PRODUCTID is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(String value) {
            addCriterion("PRODUCTID =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(String value) {
            addCriterion("PRODUCTID <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(String value) {
            addCriterion("PRODUCTID >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTID >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(String value) {
            addCriterion("PRODUCTID <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTID <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLike(String value) {
            addCriterion("PRODUCTID like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotLike(String value) {
            addCriterion("PRODUCTID not like", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<String> values) {
            addCriterion("PRODUCTID in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<String> values) {
            addCriterion("PRODUCTID not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(String value1, String value2) {
            addCriterion("PRODUCTID between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(String value1, String value2) {
            addCriterion("PRODUCTID not between", value1, value2, "productid");
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

        public Criteria andCurrentstepidIsNull() {
            addCriterion("CURRENTSTEPID is null");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidIsNotNull() {
            addCriterion("CURRENTSTEPID is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidEqualTo(String value) {
            addCriterion("CURRENTSTEPID =", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidNotEqualTo(String value) {
            addCriterion("CURRENTSTEPID <>", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidGreaterThan(String value) {
            addCriterion("CURRENTSTEPID >", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENTSTEPID >=", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidLessThan(String value) {
            addCriterion("CURRENTSTEPID <", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidLessThanOrEqualTo(String value) {
            addCriterion("CURRENTSTEPID <=", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidLike(String value) {
            addCriterion("CURRENTSTEPID like", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidNotLike(String value) {
            addCriterion("CURRENTSTEPID not like", value, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidIn(List<String> values) {
            addCriterion("CURRENTSTEPID in", values, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidNotIn(List<String> values) {
            addCriterion("CURRENTSTEPID not in", values, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidBetween(String value1, String value2) {
            addCriterion("CURRENTSTEPID between", value1, value2, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andCurrentstepidNotBetween(String value1, String value2) {
            addCriterion("CURRENTSTEPID not between", value1, value2, "currentstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidIsNull() {
            addCriterion("NEXTSTEPID is null");
            return (Criteria) this;
        }

        public Criteria andNextstepidIsNotNull() {
            addCriterion("NEXTSTEPID is not null");
            return (Criteria) this;
        }

        public Criteria andNextstepidEqualTo(String value) {
            addCriterion("NEXTSTEPID =", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidNotEqualTo(String value) {
            addCriterion("NEXTSTEPID <>", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidGreaterThan(String value) {
            addCriterion("NEXTSTEPID >", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidGreaterThanOrEqualTo(String value) {
            addCriterion("NEXTSTEPID >=", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidLessThan(String value) {
            addCriterion("NEXTSTEPID <", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidLessThanOrEqualTo(String value) {
            addCriterion("NEXTSTEPID <=", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidLike(String value) {
            addCriterion("NEXTSTEPID like", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidNotLike(String value) {
            addCriterion("NEXTSTEPID not like", value, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidIn(List<String> values) {
            addCriterion("NEXTSTEPID in", values, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidNotIn(List<String> values) {
            addCriterion("NEXTSTEPID not in", values, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidBetween(String value1, String value2) {
            addCriterion("NEXTSTEPID between", value1, value2, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andNextstepidNotBetween(String value1, String value2) {
            addCriterion("NEXTSTEPID not between", value1, value2, "nextstepid");
            return (Criteria) this;
        }

        public Criteria andDefectflagIsNull() {
            addCriterion("DEFECTFLAG is null");
            return (Criteria) this;
        }

        public Criteria andDefectflagIsNotNull() {
            addCriterion("DEFECTFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDefectflagEqualTo(String value) {
            addCriterion("DEFECTFLAG =", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagNotEqualTo(String value) {
            addCriterion("DEFECTFLAG <>", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagGreaterThan(String value) {
            addCriterion("DEFECTFLAG >", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagGreaterThanOrEqualTo(String value) {
            addCriterion("DEFECTFLAG >=", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagLessThan(String value) {
            addCriterion("DEFECTFLAG <", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagLessThanOrEqualTo(String value) {
            addCriterion("DEFECTFLAG <=", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagLike(String value) {
            addCriterion("DEFECTFLAG like", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagNotLike(String value) {
            addCriterion("DEFECTFLAG not like", value, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagIn(List<String> values) {
            addCriterion("DEFECTFLAG in", values, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagNotIn(List<String> values) {
            addCriterion("DEFECTFLAG not in", values, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagBetween(String value1, String value2) {
            addCriterion("DEFECTFLAG between", value1, value2, "defectflag");
            return (Criteria) this;
        }

        public Criteria andDefectflagNotBetween(String value1, String value2) {
            addCriterion("DEFECTFLAG not between", value1, value2, "defectflag");
            return (Criteria) this;
        }

        public Criteria andActionidIsNull() {
            addCriterion("ACTIONID is null");
            return (Criteria) this;
        }

        public Criteria andActionidIsNotNull() {
            addCriterion("ACTIONID is not null");
            return (Criteria) this;
        }

        public Criteria andActionidEqualTo(String value) {
            addCriterion("ACTIONID =", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidNotEqualTo(String value) {
            addCriterion("ACTIONID <>", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidGreaterThan(String value) {
            addCriterion("ACTIONID >", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIONID >=", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidLessThan(String value) {
            addCriterion("ACTIONID <", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidLessThanOrEqualTo(String value) {
            addCriterion("ACTIONID <=", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidLike(String value) {
            addCriterion("ACTIONID like", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidNotLike(String value) {
            addCriterion("ACTIONID not like", value, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidIn(List<String> values) {
            addCriterion("ACTIONID in", values, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidNotIn(List<String> values) {
            addCriterion("ACTIONID not in", values, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidBetween(String value1, String value2) {
            addCriterion("ACTIONID between", value1, value2, "actionid");
            return (Criteria) this;
        }

        public Criteria andActionidNotBetween(String value1, String value2) {
            addCriterion("ACTIONID not between", value1, value2, "actionid");
            return (Criteria) this;
        }

        public Criteria andQtyinIsNull() {
            addCriterion("QTYIN is null");
            return (Criteria) this;
        }

        public Criteria andQtyinIsNotNull() {
            addCriterion("QTYIN is not null");
            return (Criteria) this;
        }

        public Criteria andQtyinEqualTo(BigDecimal value) {
            addCriterion("QTYIN =", value, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinNotEqualTo(BigDecimal value) {
            addCriterion("QTYIN <>", value, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinGreaterThan(BigDecimal value) {
            addCriterion("QTYIN >", value, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTYIN >=", value, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinLessThan(BigDecimal value) {
            addCriterion("QTYIN <", value, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTYIN <=", value, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinIn(List<BigDecimal> values) {
            addCriterion("QTYIN in", values, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinNotIn(List<BigDecimal> values) {
            addCriterion("QTYIN not in", values, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTYIN between", value1, value2, "qtyin");
            return (Criteria) this;
        }

        public Criteria andQtyinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTYIN not between", value1, value2, "qtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinIsNull() {
            addCriterion("SUBCOMPQTYIN is null");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinIsNotNull() {
            addCriterion("SUBCOMPQTYIN is not null");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYIN =", value, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinNotEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYIN <>", value, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinGreaterThan(BigDecimal value) {
            addCriterion("SUBCOMPQTYIN >", value, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYIN >=", value, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinLessThan(BigDecimal value) {
            addCriterion("SUBCOMPQTYIN <", value, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYIN <=", value, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinIn(List<BigDecimal> values) {
            addCriterion("SUBCOMPQTYIN in", values, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinNotIn(List<BigDecimal> values) {
            addCriterion("SUBCOMPQTYIN not in", values, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUBCOMPQTYIN between", value1, value2, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUBCOMPQTYIN not between", value1, value2, "subcompqtyin");
            return (Criteria) this;
        }

        public Criteria andQtyoutIsNull() {
            addCriterion("QTYOUT is null");
            return (Criteria) this;
        }

        public Criteria andQtyoutIsNotNull() {
            addCriterion("QTYOUT is not null");
            return (Criteria) this;
        }

        public Criteria andQtyoutEqualTo(BigDecimal value) {
            addCriterion("QTYOUT =", value, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutNotEqualTo(BigDecimal value) {
            addCriterion("QTYOUT <>", value, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutGreaterThan(BigDecimal value) {
            addCriterion("QTYOUT >", value, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTYOUT >=", value, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutLessThan(BigDecimal value) {
            addCriterion("QTYOUT <", value, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTYOUT <=", value, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutIn(List<BigDecimal> values) {
            addCriterion("QTYOUT in", values, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutNotIn(List<BigDecimal> values) {
            addCriterion("QTYOUT not in", values, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTYOUT between", value1, value2, "qtyout");
            return (Criteria) this;
        }

        public Criteria andQtyoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTYOUT not between", value1, value2, "qtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutIsNull() {
            addCriterion("SUBCOMPQTYOUT is null");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutIsNotNull() {
            addCriterion("SUBCOMPQTYOUT is not null");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYOUT =", value, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutNotEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYOUT <>", value, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutGreaterThan(BigDecimal value) {
            addCriterion("SUBCOMPQTYOUT >", value, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYOUT >=", value, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutLessThan(BigDecimal value) {
            addCriterion("SUBCOMPQTYOUT <", value, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUBCOMPQTYOUT <=", value, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutIn(List<BigDecimal> values) {
            addCriterion("SUBCOMPQTYOUT in", values, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutNotIn(List<BigDecimal> values) {
            addCriterion("SUBCOMPQTYOUT not in", values, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUBCOMPQTYOUT between", value1, value2, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andSubcompqtyoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUBCOMPQTYOUT not between", value1, value2, "subcompqtyout");
            return (Criteria) this;
        }

        public Criteria andCommentidIsNull() {
            addCriterion("COMMENTID is null");
            return (Criteria) this;
        }

        public Criteria andCommentidIsNotNull() {
            addCriterion("COMMENTID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentidEqualTo(String value) {
            addCriterion("COMMENTID =", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotEqualTo(String value) {
            addCriterion("COMMENTID <>", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThan(String value) {
            addCriterion("COMMENTID >", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTID >=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThan(String value) {
            addCriterion("COMMENTID <", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThanOrEqualTo(String value) {
            addCriterion("COMMENTID <=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLike(String value) {
            addCriterion("COMMENTID like", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotLike(String value) {
            addCriterion("COMMENTID not like", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidIn(List<String> values) {
            addCriterion("COMMENTID in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotIn(List<String> values) {
            addCriterion("COMMENTID not in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidBetween(String value1, String value2) {
            addCriterion("COMMENTID between", value1, value2, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotBetween(String value1, String value2) {
            addCriterion("COMMENTID not between", value1, value2, "commentid");
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

        public Criteria andCurrentnodehandleIsNull() {
            addCriterion("CURRENTNODEHANDLE is null");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleIsNotNull() {
            addCriterion("CURRENTNODEHANDLE is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleEqualTo(String value) {
            addCriterion("CURRENTNODEHANDLE =", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleNotEqualTo(String value) {
            addCriterion("CURRENTNODEHANDLE <>", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleGreaterThan(String value) {
            addCriterion("CURRENTNODEHANDLE >", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENTNODEHANDLE >=", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleLessThan(String value) {
            addCriterion("CURRENTNODEHANDLE <", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleLessThanOrEqualTo(String value) {
            addCriterion("CURRENTNODEHANDLE <=", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleLike(String value) {
            addCriterion("CURRENTNODEHANDLE like", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleNotLike(String value) {
            addCriterion("CURRENTNODEHANDLE not like", value, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleIn(List<String> values) {
            addCriterion("CURRENTNODEHANDLE in", values, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleNotIn(List<String> values) {
            addCriterion("CURRENTNODEHANDLE not in", values, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleBetween(String value1, String value2) {
            addCriterion("CURRENTNODEHANDLE between", value1, value2, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andCurrentnodehandleNotBetween(String value1, String value2) {
            addCriterion("CURRENTNODEHANDLE not between", value1, value2, "currentnodehandle");
            return (Criteria) this;
        }

        public Criteria andWipstatusIsNull() {
            addCriterion("WIPSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andWipstatusIsNotNull() {
            addCriterion("WIPSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWipstatusEqualTo(String value) {
            addCriterion("WIPSTATUS =", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusNotEqualTo(String value) {
            addCriterion("WIPSTATUS <>", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusGreaterThan(String value) {
            addCriterion("WIPSTATUS >", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusGreaterThanOrEqualTo(String value) {
            addCriterion("WIPSTATUS >=", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusLessThan(String value) {
            addCriterion("WIPSTATUS <", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusLessThanOrEqualTo(String value) {
            addCriterion("WIPSTATUS <=", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusLike(String value) {
            addCriterion("WIPSTATUS like", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusNotLike(String value) {
            addCriterion("WIPSTATUS not like", value, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusIn(List<String> values) {
            addCriterion("WIPSTATUS in", values, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusNotIn(List<String> values) {
            addCriterion("WIPSTATUS not in", values, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusBetween(String value1, String value2) {
            addCriterion("WIPSTATUS between", value1, value2, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipstatusNotBetween(String value1, String value2) {
            addCriterion("WIPSTATUS not between", value1, value2, "wipstatus");
            return (Criteria) this;
        }

        public Criteria andWipresidIsNull() {
            addCriterion("WIPRESID is null");
            return (Criteria) this;
        }

        public Criteria andWipresidIsNotNull() {
            addCriterion("WIPRESID is not null");
            return (Criteria) this;
        }

        public Criteria andWipresidEqualTo(String value) {
            addCriterion("WIPRESID =", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidNotEqualTo(String value) {
            addCriterion("WIPRESID <>", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidGreaterThan(String value) {
            addCriterion("WIPRESID >", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidGreaterThanOrEqualTo(String value) {
            addCriterion("WIPRESID >=", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidLessThan(String value) {
            addCriterion("WIPRESID <", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidLessThanOrEqualTo(String value) {
            addCriterion("WIPRESID <=", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidLike(String value) {
            addCriterion("WIPRESID like", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidNotLike(String value) {
            addCriterion("WIPRESID not like", value, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidIn(List<String> values) {
            addCriterion("WIPRESID in", values, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidNotIn(List<String> values) {
            addCriterion("WIPRESID not in", values, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidBetween(String value1, String value2) {
            addCriterion("WIPRESID between", value1, value2, "wipresid");
            return (Criteria) this;
        }

        public Criteria andWipresidNotBetween(String value1, String value2) {
            addCriterion("WIPRESID not between", value1, value2, "wipresid");
            return (Criteria) this;
        }

        public Criteria andDefectqtyIsNull() {
            addCriterion("DEFECTQTY is null");
            return (Criteria) this;
        }

        public Criteria andDefectqtyIsNotNull() {
            addCriterion("DEFECTQTY is not null");
            return (Criteria) this;
        }

        public Criteria andDefectqtyEqualTo(Short value) {
            addCriterion("DEFECTQTY =", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyNotEqualTo(Short value) {
            addCriterion("DEFECTQTY <>", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyGreaterThan(Short value) {
            addCriterion("DEFECTQTY >", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyGreaterThanOrEqualTo(Short value) {
            addCriterion("DEFECTQTY >=", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyLessThan(Short value) {
            addCriterion("DEFECTQTY <", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyLessThanOrEqualTo(Short value) {
            addCriterion("DEFECTQTY <=", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyIn(List<Short> values) {
            addCriterion("DEFECTQTY in", values, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyNotIn(List<Short> values) {
            addCriterion("DEFECTQTY not in", values, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyBetween(Short value1, Short value2) {
            addCriterion("DEFECTQTY between", value1, value2, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyNotBetween(Short value1, Short value2) {
            addCriterion("DEFECTQTY not between", value1, value2, "defectqty");
            return (Criteria) this;
        }

        public Criteria andTestversionIsNull() {
            addCriterion("TESTVERSION is null");
            return (Criteria) this;
        }

        public Criteria andTestversionIsNotNull() {
            addCriterion("TESTVERSION is not null");
            return (Criteria) this;
        }

        public Criteria andTestversionEqualTo(String value) {
            addCriterion("TESTVERSION =", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionNotEqualTo(String value) {
            addCriterion("TESTVERSION <>", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionGreaterThan(String value) {
            addCriterion("TESTVERSION >", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionGreaterThanOrEqualTo(String value) {
            addCriterion("TESTVERSION >=", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionLessThan(String value) {
            addCriterion("TESTVERSION <", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionLessThanOrEqualTo(String value) {
            addCriterion("TESTVERSION <=", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionLike(String value) {
            addCriterion("TESTVERSION like", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionNotLike(String value) {
            addCriterion("TESTVERSION not like", value, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionIn(List<String> values) {
            addCriterion("TESTVERSION in", values, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionNotIn(List<String> values) {
            addCriterion("TESTVERSION not in", values, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionBetween(String value1, String value2) {
            addCriterion("TESTVERSION between", value1, value2, "testversion");
            return (Criteria) this;
        }

        public Criteria andTestversionNotBetween(String value1, String value2) {
            addCriterion("TESTVERSION not between", value1, value2, "testversion");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusIsNull() {
            addCriterion("IPQCSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusIsNotNull() {
            addCriterion("IPQCSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusEqualTo(String value) {
            addCriterion("IPQCSTATUS =", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusNotEqualTo(String value) {
            addCriterion("IPQCSTATUS <>", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusGreaterThan(String value) {
            addCriterion("IPQCSTATUS >", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusGreaterThanOrEqualTo(String value) {
            addCriterion("IPQCSTATUS >=", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusLessThan(String value) {
            addCriterion("IPQCSTATUS <", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusLessThanOrEqualTo(String value) {
            addCriterion("IPQCSTATUS <=", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusLike(String value) {
            addCriterion("IPQCSTATUS like", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusNotLike(String value) {
            addCriterion("IPQCSTATUS not like", value, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusIn(List<String> values) {
            addCriterion("IPQCSTATUS in", values, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusNotIn(List<String> values) {
            addCriterion("IPQCSTATUS not in", values, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusBetween(String value1, String value2) {
            addCriterion("IPQCSTATUS between", value1, value2, "ipqcstatus");
            return (Criteria) this;
        }

        public Criteria andIpqcstatusNotBetween(String value1, String value2) {
            addCriterion("IPQCSTATUS not between", value1, value2, "ipqcstatus");
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