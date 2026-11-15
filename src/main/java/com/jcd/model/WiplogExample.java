package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WiplogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WiplogExample() {
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

        public Criteria andWiplogidIsNull() {
            addCriterion("WIPLOGID is null");
            return (Criteria) this;
        }

        public Criteria andWiplogidIsNotNull() {
            addCriterion("WIPLOGID is not null");
            return (Criteria) this;
        }

        public Criteria andWiplogidEqualTo(String value) {
            addCriterion("WIPLOGID =", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidNotEqualTo(String value) {
            addCriterion("WIPLOGID <>", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidGreaterThan(String value) {
            addCriterion("WIPLOGID >", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidGreaterThanOrEqualTo(String value) {
            addCriterion("WIPLOGID >=", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidLessThan(String value) {
            addCriterion("WIPLOGID <", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidLessThanOrEqualTo(String value) {
            addCriterion("WIPLOGID <=", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidLike(String value) {
            addCriterion("WIPLOGID like", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidNotLike(String value) {
            addCriterion("WIPLOGID not like", value, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidIn(List<String> values) {
            addCriterion("WIPLOGID in", values, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidNotIn(List<String> values) {
            addCriterion("WIPLOGID not in", values, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidBetween(String value1, String value2) {
            addCriterion("WIPLOGID between", value1, value2, "wiplogid");
            return (Criteria) this;
        }

        public Criteria andWiplogidNotBetween(String value1, String value2) {
            addCriterion("WIPLOGID not between", value1, value2, "wiplogid");
            return (Criteria) this;
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

        public Criteria andStepidIsNull() {
            addCriterion("STEPID is null");
            return (Criteria) this;
        }

        public Criteria andStepidIsNotNull() {
            addCriterion("STEPID is not null");
            return (Criteria) this;
        }

        public Criteria andStepidEqualTo(String value) {
            addCriterion("STEPID =", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotEqualTo(String value) {
            addCriterion("STEPID <>", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidGreaterThan(String value) {
            addCriterion("STEPID >", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidGreaterThanOrEqualTo(String value) {
            addCriterion("STEPID >=", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLessThan(String value) {
            addCriterion("STEPID <", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLessThanOrEqualTo(String value) {
            addCriterion("STEPID <=", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLike(String value) {
            addCriterion("STEPID like", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotLike(String value) {
            addCriterion("STEPID not like", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidIn(List<String> values) {
            addCriterion("STEPID in", values, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotIn(List<String> values) {
            addCriterion("STEPID not in", values, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidBetween(String value1, String value2) {
            addCriterion("STEPID between", value1, value2, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotBetween(String value1, String value2) {
            addCriterion("STEPID not between", value1, value2, "stepid");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeIsNull() {
            addCriterion("STEPPASSTIME is null");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeIsNotNull() {
            addCriterion("STEPPASSTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeEqualTo(Date value) {
            addCriterion("STEPPASSTIME =", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeNotEqualTo(Date value) {
            addCriterion("STEPPASSTIME <>", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeGreaterThan(Date value) {
            addCriterion("STEPPASSTIME >", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STEPPASSTIME >=", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeLessThan(Date value) {
            addCriterion("STEPPASSTIME <", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeLessThanOrEqualTo(Date value) {
            addCriterion("STEPPASSTIME <=", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeIn(List<Date> values) {
            addCriterion("STEPPASSTIME in", values, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeNotIn(List<Date> values) {
            addCriterion("STEPPASSTIME not in", values, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeBetween(Date value1, Date value2) {
            addCriterion("STEPPASSTIME between", value1, value2, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeNotBetween(Date value1, Date value2) {
            addCriterion("STEPPASSTIME not between", value1, value2, "steppasstime");
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

        public Criteria andStationidIsNull() {
            addCriterion("STATIONID is null");
            return (Criteria) this;
        }

        public Criteria andStationidIsNotNull() {
            addCriterion("STATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andStationidEqualTo(String value) {
            addCriterion("STATIONID =", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotEqualTo(String value) {
            addCriterion("STATIONID <>", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThan(String value) {
            addCriterion("STATIONID >", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThanOrEqualTo(String value) {
            addCriterion("STATIONID >=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThan(String value) {
            addCriterion("STATIONID <", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThanOrEqualTo(String value) {
            addCriterion("STATIONID <=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLike(String value) {
            addCriterion("STATIONID like", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotLike(String value) {
            addCriterion("STATIONID not like", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidIn(List<String> values) {
            addCriterion("STATIONID in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotIn(List<String> values) {
            addCriterion("STATIONID not in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidBetween(String value1, String value2) {
            addCriterion("STATIONID between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotBetween(String value1, String value2) {
            addCriterion("STATIONID not between", value1, value2, "stationid");
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

        public Criteria andMoidIsNull() {
            addCriterion("MOID is null");
            return (Criteria) this;
        }

        public Criteria andMoidIsNotNull() {
            addCriterion("MOID is not null");
            return (Criteria) this;
        }

        public Criteria andMoidEqualTo(String value) {
            addCriterion("MOID =", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotEqualTo(String value) {
            addCriterion("MOID <>", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidGreaterThan(String value) {
            addCriterion("MOID >", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidGreaterThanOrEqualTo(String value) {
            addCriterion("MOID >=", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidLessThan(String value) {
            addCriterion("MOID <", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidLessThanOrEqualTo(String value) {
            addCriterion("MOID <=", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidLike(String value) {
            addCriterion("MOID like", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotLike(String value) {
            addCriterion("MOID not like", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidIn(List<String> values) {
            addCriterion("MOID in", values, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotIn(List<String> values) {
            addCriterion("MOID not in", values, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidBetween(String value1, String value2) {
            addCriterion("MOID between", value1, value2, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotBetween(String value1, String value2) {
            addCriterion("MOID not between", value1, value2, "moid");
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

        public Criteria andWipqtyIsNull() {
            addCriterion("WIPQTY is null");
            return (Criteria) this;
        }

        public Criteria andWipqtyIsNotNull() {
            addCriterion("WIPQTY is not null");
            return (Criteria) this;
        }

        public Criteria andWipqtyEqualTo(Short value) {
            addCriterion("WIPQTY =", value, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyNotEqualTo(Short value) {
            addCriterion("WIPQTY <>", value, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyGreaterThan(Short value) {
            addCriterion("WIPQTY >", value, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyGreaterThanOrEqualTo(Short value) {
            addCriterion("WIPQTY >=", value, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyLessThan(Short value) {
            addCriterion("WIPQTY <", value, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyLessThanOrEqualTo(Short value) {
            addCriterion("WIPQTY <=", value, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyIn(List<Short> values) {
            addCriterion("WIPQTY in", values, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyNotIn(List<Short> values) {
            addCriterion("WIPQTY not in", values, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyBetween(Short value1, Short value2) {
            addCriterion("WIPQTY between", value1, value2, "wipqty");
            return (Criteria) this;
        }

        public Criteria andWipqtyNotBetween(Short value1, Short value2) {
            addCriterion("WIPQTY not between", value1, value2, "wipqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyIsNull() {
            addCriterion("SCRAPQTY is null");
            return (Criteria) this;
        }

        public Criteria andScrapqtyIsNotNull() {
            addCriterion("SCRAPQTY is not null");
            return (Criteria) this;
        }

        public Criteria andScrapqtyEqualTo(Short value) {
            addCriterion("SCRAPQTY =", value, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyNotEqualTo(Short value) {
            addCriterion("SCRAPQTY <>", value, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyGreaterThan(Short value) {
            addCriterion("SCRAPQTY >", value, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyGreaterThanOrEqualTo(Short value) {
            addCriterion("SCRAPQTY >=", value, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyLessThan(Short value) {
            addCriterion("SCRAPQTY <", value, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyLessThanOrEqualTo(Short value) {
            addCriterion("SCRAPQTY <=", value, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyIn(List<Short> values) {
            addCriterion("SCRAPQTY in", values, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyNotIn(List<Short> values) {
            addCriterion("SCRAPQTY not in", values, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyBetween(Short value1, Short value2) {
            addCriterion("SCRAPQTY between", value1, value2, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andScrapqtyNotBetween(Short value1, Short value2) {
            addCriterion("SCRAPQTY not between", value1, value2, "scrapqty");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursIsNull() {
            addCriterion("WORKINGHOURS is null");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursIsNotNull() {
            addCriterion("WORKINGHOURS is not null");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursEqualTo(Short value) {
            addCriterion("WORKINGHOURS =", value, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursNotEqualTo(Short value) {
            addCriterion("WORKINGHOURS <>", value, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursGreaterThan(Short value) {
            addCriterion("WORKINGHOURS >", value, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursGreaterThanOrEqualTo(Short value) {
            addCriterion("WORKINGHOURS >=", value, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursLessThan(Short value) {
            addCriterion("WORKINGHOURS <", value, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursLessThanOrEqualTo(Short value) {
            addCriterion("WORKINGHOURS <=", value, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursIn(List<Short> values) {
            addCriterion("WORKINGHOURS in", values, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursNotIn(List<Short> values) {
            addCriterion("WORKINGHOURS not in", values, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursBetween(Short value1, Short value2) {
            addCriterion("WORKINGHOURS between", value1, value2, "workinghours");
            return (Criteria) this;
        }

        public Criteria andWorkinghoursNotBetween(Short value1, Short value2) {
            addCriterion("WORKINGHOURS not between", value1, value2, "workinghours");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidIsNull() {
            addCriterion("OSP_INVOICEDETAILID is null");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidIsNotNull() {
            addCriterion("OSP_INVOICEDETAILID is not null");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidEqualTo(String value) {
            addCriterion("OSP_INVOICEDETAILID =", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidNotEqualTo(String value) {
            addCriterion("OSP_INVOICEDETAILID <>", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidGreaterThan(String value) {
            addCriterion("OSP_INVOICEDETAILID >", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidGreaterThanOrEqualTo(String value) {
            addCriterion("OSP_INVOICEDETAILID >=", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidLessThan(String value) {
            addCriterion("OSP_INVOICEDETAILID <", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidLessThanOrEqualTo(String value) {
            addCriterion("OSP_INVOICEDETAILID <=", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidLike(String value) {
            addCriterion("OSP_INVOICEDETAILID like", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidNotLike(String value) {
            addCriterion("OSP_INVOICEDETAILID not like", value, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidIn(List<String> values) {
            addCriterion("OSP_INVOICEDETAILID in", values, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidNotIn(List<String> values) {
            addCriterion("OSP_INVOICEDETAILID not in", values, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidBetween(String value1, String value2) {
            addCriterion("OSP_INVOICEDETAILID between", value1, value2, "ospInvoicedetailid");
            return (Criteria) this;
        }

        public Criteria andOspInvoicedetailidNotBetween(String value1, String value2) {
            addCriterion("OSP_INVOICEDETAILID not between", value1, value2, "ospInvoicedetailid");
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

        public Criteria andProcessseqIsNull() {
            addCriterion("PROCESSSEQ is null");
            return (Criteria) this;
        }

        public Criteria andProcessseqIsNotNull() {
            addCriterion("PROCESSSEQ is not null");
            return (Criteria) this;
        }

        public Criteria andProcessseqEqualTo(String value) {
            addCriterion("PROCESSSEQ =", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqNotEqualTo(String value) {
            addCriterion("PROCESSSEQ <>", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqGreaterThan(String value) {
            addCriterion("PROCESSSEQ >", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESSSEQ >=", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqLessThan(String value) {
            addCriterion("PROCESSSEQ <", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqLessThanOrEqualTo(String value) {
            addCriterion("PROCESSSEQ <=", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqLike(String value) {
            addCriterion("PROCESSSEQ like", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqNotLike(String value) {
            addCriterion("PROCESSSEQ not like", value, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqIn(List<String> values) {
            addCriterion("PROCESSSEQ in", values, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqNotIn(List<String> values) {
            addCriterion("PROCESSSEQ not in", values, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqBetween(String value1, String value2) {
            addCriterion("PROCESSSEQ between", value1, value2, "processseq");
            return (Criteria) this;
        }

        public Criteria andProcessseqNotBetween(String value1, String value2) {
            addCriterion("PROCESSSEQ not between", value1, value2, "processseq");
            return (Criteria) this;
        }

        public Criteria andWorkorderidIsNull() {
            addCriterion("WORKORDERID is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderidIsNotNull() {
            addCriterion("WORKORDERID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderidEqualTo(String value) {
            addCriterion("WORKORDERID =", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotEqualTo(String value) {
            addCriterion("WORKORDERID <>", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidGreaterThan(String value) {
            addCriterion("WORKORDERID >", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidGreaterThanOrEqualTo(String value) {
            addCriterion("WORKORDERID >=", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidLessThan(String value) {
            addCriterion("WORKORDERID <", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidLessThanOrEqualTo(String value) {
            addCriterion("WORKORDERID <=", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidLike(String value) {
            addCriterion("WORKORDERID like", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotLike(String value) {
            addCriterion("WORKORDERID not like", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidIn(List<String> values) {
            addCriterion("WORKORDERID in", values, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotIn(List<String> values) {
            addCriterion("WORKORDERID not in", values, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidBetween(String value1, String value2) {
            addCriterion("WORKORDERID between", value1, value2, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotBetween(String value1, String value2) {
            addCriterion("WORKORDERID not between", value1, value2, "workorderid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDatecodeIsNull() {
            addCriterion("DATECODE is null");
            return (Criteria) this;
        }

        public Criteria andDatecodeIsNotNull() {
            addCriterion("DATECODE is not null");
            return (Criteria) this;
        }

        public Criteria andDatecodeEqualTo(String value) {
            addCriterion("DATECODE =", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeNotEqualTo(String value) {
            addCriterion("DATECODE <>", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeGreaterThan(String value) {
            addCriterion("DATECODE >", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeGreaterThanOrEqualTo(String value) {
            addCriterion("DATECODE >=", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeLessThan(String value) {
            addCriterion("DATECODE <", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeLessThanOrEqualTo(String value) {
            addCriterion("DATECODE <=", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeLike(String value) {
            addCriterion("DATECODE like", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeNotLike(String value) {
            addCriterion("DATECODE not like", value, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeIn(List<String> values) {
            addCriterion("DATECODE in", values, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeNotIn(List<String> values) {
            addCriterion("DATECODE not in", values, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeBetween(String value1, String value2) {
            addCriterion("DATECODE between", value1, value2, "datecode");
            return (Criteria) this;
        }

        public Criteria andDatecodeNotBetween(String value1, String value2) {
            addCriterion("DATECODE not between", value1, value2, "datecode");
            return (Criteria) this;
        }

        public Criteria andShipidIsNull() {
            addCriterion("SHIPID is null");
            return (Criteria) this;
        }

        public Criteria andShipidIsNotNull() {
            addCriterion("SHIPID is not null");
            return (Criteria) this;
        }

        public Criteria andShipidEqualTo(String value) {
            addCriterion("SHIPID =", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidNotEqualTo(String value) {
            addCriterion("SHIPID <>", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidGreaterThan(String value) {
            addCriterion("SHIPID >", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidGreaterThanOrEqualTo(String value) {
            addCriterion("SHIPID >=", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidLessThan(String value) {
            addCriterion("SHIPID <", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidLessThanOrEqualTo(String value) {
            addCriterion("SHIPID <=", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidLike(String value) {
            addCriterion("SHIPID like", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidNotLike(String value) {
            addCriterion("SHIPID not like", value, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidIn(List<String> values) {
            addCriterion("SHIPID in", values, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidNotIn(List<String> values) {
            addCriterion("SHIPID not in", values, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidBetween(String value1, String value2) {
            addCriterion("SHIPID between", value1, value2, "shipid");
            return (Criteria) this;
        }

        public Criteria andShipidNotBetween(String value1, String value2) {
            addCriterion("SHIPID not between", value1, value2, "shipid");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursIsNull() {
            addCriterion("EQPWORKHOURS is null");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursIsNotNull() {
            addCriterion("EQPWORKHOURS is not null");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursEqualTo(Short value) {
            addCriterion("EQPWORKHOURS =", value, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursNotEqualTo(Short value) {
            addCriterion("EQPWORKHOURS <>", value, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursGreaterThan(Short value) {
            addCriterion("EQPWORKHOURS >", value, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursGreaterThanOrEqualTo(Short value) {
            addCriterion("EQPWORKHOURS >=", value, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursLessThan(Short value) {
            addCriterion("EQPWORKHOURS <", value, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursLessThanOrEqualTo(Short value) {
            addCriterion("EQPWORKHOURS <=", value, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursIn(List<Short> values) {
            addCriterion("EQPWORKHOURS in", values, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursNotIn(List<Short> values) {
            addCriterion("EQPWORKHOURS not in", values, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursBetween(Short value1, Short value2) {
            addCriterion("EQPWORKHOURS between", value1, value2, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andEqpworkhoursNotBetween(Short value1, Short value2) {
            addCriterion("EQPWORKHOURS not between", value1, value2, "eqpworkhours");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeIsNull() {
            addCriterion("OSPVENDORCODE is null");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeIsNotNull() {
            addCriterion("OSPVENDORCODE is not null");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeEqualTo(String value) {
            addCriterion("OSPVENDORCODE =", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeNotEqualTo(String value) {
            addCriterion("OSPVENDORCODE <>", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeGreaterThan(String value) {
            addCriterion("OSPVENDORCODE >", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeGreaterThanOrEqualTo(String value) {
            addCriterion("OSPVENDORCODE >=", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeLessThan(String value) {
            addCriterion("OSPVENDORCODE <", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeLessThanOrEqualTo(String value) {
            addCriterion("OSPVENDORCODE <=", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeLike(String value) {
            addCriterion("OSPVENDORCODE like", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeNotLike(String value) {
            addCriterion("OSPVENDORCODE not like", value, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeIn(List<String> values) {
            addCriterion("OSPVENDORCODE in", values, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeNotIn(List<String> values) {
            addCriterion("OSPVENDORCODE not in", values, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeBetween(String value1, String value2) {
            addCriterion("OSPVENDORCODE between", value1, value2, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendorcodeNotBetween(String value1, String value2) {
            addCriterion("OSPVENDORCODE not between", value1, value2, "ospvendorcode");
            return (Criteria) this;
        }

        public Criteria andOspvendornameIsNull() {
            addCriterion("OSPVENDORNAME is null");
            return (Criteria) this;
        }

        public Criteria andOspvendornameIsNotNull() {
            addCriterion("OSPVENDORNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOspvendornameEqualTo(String value) {
            addCriterion("OSPVENDORNAME =", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameNotEqualTo(String value) {
            addCriterion("OSPVENDORNAME <>", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameGreaterThan(String value) {
            addCriterion("OSPVENDORNAME >", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameGreaterThanOrEqualTo(String value) {
            addCriterion("OSPVENDORNAME >=", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameLessThan(String value) {
            addCriterion("OSPVENDORNAME <", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameLessThanOrEqualTo(String value) {
            addCriterion("OSPVENDORNAME <=", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameLike(String value) {
            addCriterion("OSPVENDORNAME like", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameNotLike(String value) {
            addCriterion("OSPVENDORNAME not like", value, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameIn(List<String> values) {
            addCriterion("OSPVENDORNAME in", values, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameNotIn(List<String> values) {
            addCriterion("OSPVENDORNAME not in", values, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameBetween(String value1, String value2) {
            addCriterion("OSPVENDORNAME between", value1, value2, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andOspvendornameNotBetween(String value1, String value2) {
            addCriterion("OSPVENDORNAME not between", value1, value2, "ospvendorname");
            return (Criteria) this;
        }

        public Criteria andStepidparentIsNull() {
            addCriterion("STEPIDPARENT is null");
            return (Criteria) this;
        }

        public Criteria andStepidparentIsNotNull() {
            addCriterion("STEPIDPARENT is not null");
            return (Criteria) this;
        }

        public Criteria andStepidparentEqualTo(String value) {
            addCriterion("STEPIDPARENT =", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentNotEqualTo(String value) {
            addCriterion("STEPIDPARENT <>", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentGreaterThan(String value) {
            addCriterion("STEPIDPARENT >", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentGreaterThanOrEqualTo(String value) {
            addCriterion("STEPIDPARENT >=", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentLessThan(String value) {
            addCriterion("STEPIDPARENT <", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentLessThanOrEqualTo(String value) {
            addCriterion("STEPIDPARENT <=", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentLike(String value) {
            addCriterion("STEPIDPARENT like", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentNotLike(String value) {
            addCriterion("STEPIDPARENT not like", value, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentIn(List<String> values) {
            addCriterion("STEPIDPARENT in", values, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentNotIn(List<String> values) {
            addCriterion("STEPIDPARENT not in", values, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentBetween(String value1, String value2) {
            addCriterion("STEPIDPARENT between", value1, value2, "stepidparent");
            return (Criteria) this;
        }

        public Criteria andStepidparentNotBetween(String value1, String value2) {
            addCriterion("STEPIDPARENT not between", value1, value2, "stepidparent");
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