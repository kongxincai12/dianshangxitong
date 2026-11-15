package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wip_storageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Wip_storageExample() {
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

        public Criteria andStorageidIsNull() {
            addCriterion("STORAGEID is null");
            return (Criteria) this;
        }

        public Criteria andStorageidIsNotNull() {
            addCriterion("STORAGEID is not null");
            return (Criteria) this;
        }

        public Criteria andStorageidEqualTo(String value) {
            addCriterion("STORAGEID =", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidNotEqualTo(String value) {
            addCriterion("STORAGEID <>", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidGreaterThan(String value) {
            addCriterion("STORAGEID >", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidGreaterThanOrEqualTo(String value) {
            addCriterion("STORAGEID >=", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidLessThan(String value) {
            addCriterion("STORAGEID <", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidLessThanOrEqualTo(String value) {
            addCriterion("STORAGEID <=", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidLike(String value) {
            addCriterion("STORAGEID like", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidNotLike(String value) {
            addCriterion("STORAGEID not like", value, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidIn(List<String> values) {
            addCriterion("STORAGEID in", values, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidNotIn(List<String> values) {
            addCriterion("STORAGEID not in", values, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidBetween(String value1, String value2) {
            addCriterion("STORAGEID between", value1, value2, "storageid");
            return (Criteria) this;
        }

        public Criteria andStorageidNotBetween(String value1, String value2) {
            addCriterion("STORAGEID not between", value1, value2, "storageid");
            return (Criteria) this;
        }

        public Criteria andCartoncodeIsNull() {
            addCriterion("CARTONCODE is null");
            return (Criteria) this;
        }

        public Criteria andCartoncodeIsNotNull() {
            addCriterion("CARTONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCartoncodeEqualTo(String value) {
            addCriterion("CARTONCODE =", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotEqualTo(String value) {
            addCriterion("CARTONCODE <>", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeGreaterThan(String value) {
            addCriterion("CARTONCODE >", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeGreaterThanOrEqualTo(String value) {
            addCriterion("CARTONCODE >=", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeLessThan(String value) {
            addCriterion("CARTONCODE <", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeLessThanOrEqualTo(String value) {
            addCriterion("CARTONCODE <=", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeLike(String value) {
            addCriterion("CARTONCODE like", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotLike(String value) {
            addCriterion("CARTONCODE not like", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeIn(List<String> values) {
            addCriterion("CARTONCODE in", values, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotIn(List<String> values) {
            addCriterion("CARTONCODE not in", values, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeBetween(String value1, String value2) {
            addCriterion("CARTONCODE between", value1, value2, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotBetween(String value1, String value2) {
            addCriterion("CARTONCODE not between", value1, value2, "cartoncode");
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

        public Criteria andObj01IsNull() {
            addCriterion("OBJ01 is null");
            return (Criteria) this;
        }

        public Criteria andObj01IsNotNull() {
            addCriterion("OBJ01 is not null");
            return (Criteria) this;
        }

        public Criteria andObj01EqualTo(String value) {
            addCriterion("OBJ01 =", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotEqualTo(String value) {
            addCriterion("OBJ01 <>", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01GreaterThan(String value) {
            addCriterion("OBJ01 >", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ01 >=", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01LessThan(String value) {
            addCriterion("OBJ01 <", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01LessThanOrEqualTo(String value) {
            addCriterion("OBJ01 <=", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01Like(String value) {
            addCriterion("OBJ01 like", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotLike(String value) {
            addCriterion("OBJ01 not like", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01In(List<String> values) {
            addCriterion("OBJ01 in", values, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotIn(List<String> values) {
            addCriterion("OBJ01 not in", values, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01Between(String value1, String value2) {
            addCriterion("OBJ01 between", value1, value2, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotBetween(String value1, String value2) {
            addCriterion("OBJ01 not between", value1, value2, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj02IsNull() {
            addCriterion("OBJ02 is null");
            return (Criteria) this;
        }

        public Criteria andObj02IsNotNull() {
            addCriterion("OBJ02 is not null");
            return (Criteria) this;
        }

        public Criteria andObj02EqualTo(String value) {
            addCriterion("OBJ02 =", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotEqualTo(String value) {
            addCriterion("OBJ02 <>", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02GreaterThan(String value) {
            addCriterion("OBJ02 >", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ02 >=", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02LessThan(String value) {
            addCriterion("OBJ02 <", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02LessThanOrEqualTo(String value) {
            addCriterion("OBJ02 <=", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02Like(String value) {
            addCriterion("OBJ02 like", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotLike(String value) {
            addCriterion("OBJ02 not like", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02In(List<String> values) {
            addCriterion("OBJ02 in", values, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotIn(List<String> values) {
            addCriterion("OBJ02 not in", values, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02Between(String value1, String value2) {
            addCriterion("OBJ02 between", value1, value2, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotBetween(String value1, String value2) {
            addCriterion("OBJ02 not between", value1, value2, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj03IsNull() {
            addCriterion("OBJ03 is null");
            return (Criteria) this;
        }

        public Criteria andObj03IsNotNull() {
            addCriterion("OBJ03 is not null");
            return (Criteria) this;
        }

        public Criteria andObj03EqualTo(String value) {
            addCriterion("OBJ03 =", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotEqualTo(String value) {
            addCriterion("OBJ03 <>", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03GreaterThan(String value) {
            addCriterion("OBJ03 >", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ03 >=", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03LessThan(String value) {
            addCriterion("OBJ03 <", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03LessThanOrEqualTo(String value) {
            addCriterion("OBJ03 <=", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03Like(String value) {
            addCriterion("OBJ03 like", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotLike(String value) {
            addCriterion("OBJ03 not like", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03In(List<String> values) {
            addCriterion("OBJ03 in", values, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotIn(List<String> values) {
            addCriterion("OBJ03 not in", values, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03Between(String value1, String value2) {
            addCriterion("OBJ03 between", value1, value2, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotBetween(String value1, String value2) {
            addCriterion("OBJ03 not between", value1, value2, "obj03");
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