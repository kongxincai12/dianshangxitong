package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wip_storage_hisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Wip_storage_hisExample() {
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

        public Criteria andStoragehisidIsNull() {
            addCriterion("STORAGEHISID is null");
            return (Criteria) this;
        }

        public Criteria andStoragehisidIsNotNull() {
            addCriterion("STORAGEHISID is not null");
            return (Criteria) this;
        }

        public Criteria andStoragehisidEqualTo(String value) {
            addCriterion("STORAGEHISID =", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidNotEqualTo(String value) {
            addCriterion("STORAGEHISID <>", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidGreaterThan(String value) {
            addCriterion("STORAGEHISID >", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidGreaterThanOrEqualTo(String value) {
            addCriterion("STORAGEHISID >=", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidLessThan(String value) {
            addCriterion("STORAGEHISID <", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidLessThanOrEqualTo(String value) {
            addCriterion("STORAGEHISID <=", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidLike(String value) {
            addCriterion("STORAGEHISID like", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidNotLike(String value) {
            addCriterion("STORAGEHISID not like", value, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidIn(List<String> values) {
            addCriterion("STORAGEHISID in", values, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidNotIn(List<String> values) {
            addCriterion("STORAGEHISID not in", values, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidBetween(String value1, String value2) {
            addCriterion("STORAGEHISID between", value1, value2, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andStoragehisidNotBetween(String value1, String value2) {
            addCriterion("STORAGEHISID not between", value1, value2, "storagehisid");
            return (Criteria) this;
        }

        public Criteria andGiftcodeIsNull() {
            addCriterion("GIFTCODE is null");
            return (Criteria) this;
        }

        public Criteria andGiftcodeIsNotNull() {
            addCriterion("GIFTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andGiftcodeEqualTo(String value) {
            addCriterion("GIFTCODE =", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotEqualTo(String value) {
            addCriterion("GIFTCODE <>", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeGreaterThan(String value) {
            addCriterion("GIFTCODE >", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeGreaterThanOrEqualTo(String value) {
            addCriterion("GIFTCODE >=", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeLessThan(String value) {
            addCriterion("GIFTCODE <", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeLessThanOrEqualTo(String value) {
            addCriterion("GIFTCODE <=", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeLike(String value) {
            addCriterion("GIFTCODE like", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotLike(String value) {
            addCriterion("GIFTCODE not like", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeIn(List<String> values) {
            addCriterion("GIFTCODE in", values, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotIn(List<String> values) {
            addCriterion("GIFTCODE not in", values, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeBetween(String value1, String value2) {
            addCriterion("GIFTCODE between", value1, value2, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotBetween(String value1, String value2) {
            addCriterion("GIFTCODE not between", value1, value2, "giftcode");
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

        public Criteria andQtyIsNull() {
            addCriterion("QTY is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("QTY is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Short value) {
            addCriterion("QTY =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Short value) {
            addCriterion("QTY <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Short value) {
            addCriterion("QTY >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Short value) {
            addCriterion("QTY >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Short value) {
            addCriterion("QTY <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Short value) {
            addCriterion("QTY <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Short> values) {
            addCriterion("QTY in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Short> values) {
            addCriterion("QTY not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Short value1, Short value2) {
            addCriterion("QTY between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Short value1, Short value2) {
            addCriterion("QTY not between", value1, value2, "qty");
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

        public Criteria andObj04IsNull() {
            addCriterion("OBJ04 is null");
            return (Criteria) this;
        }

        public Criteria andObj04IsNotNull() {
            addCriterion("OBJ04 is not null");
            return (Criteria) this;
        }

        public Criteria andObj04EqualTo(String value) {
            addCriterion("OBJ04 =", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotEqualTo(String value) {
            addCriterion("OBJ04 <>", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04GreaterThan(String value) {
            addCriterion("OBJ04 >", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ04 >=", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04LessThan(String value) {
            addCriterion("OBJ04 <", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04LessThanOrEqualTo(String value) {
            addCriterion("OBJ04 <=", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04Like(String value) {
            addCriterion("OBJ04 like", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotLike(String value) {
            addCriterion("OBJ04 not like", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04In(List<String> values) {
            addCriterion("OBJ04 in", values, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotIn(List<String> values) {
            addCriterion("OBJ04 not in", values, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04Between(String value1, String value2) {
            addCriterion("OBJ04 between", value1, value2, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotBetween(String value1, String value2) {
            addCriterion("OBJ04 not between", value1, value2, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj05IsNull() {
            addCriterion("OBJ05 is null");
            return (Criteria) this;
        }

        public Criteria andObj05IsNotNull() {
            addCriterion("OBJ05 is not null");
            return (Criteria) this;
        }

        public Criteria andObj05EqualTo(String value) {
            addCriterion("OBJ05 =", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotEqualTo(String value) {
            addCriterion("OBJ05 <>", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05GreaterThan(String value) {
            addCriterion("OBJ05 >", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ05 >=", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05LessThan(String value) {
            addCriterion("OBJ05 <", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05LessThanOrEqualTo(String value) {
            addCriterion("OBJ05 <=", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05Like(String value) {
            addCriterion("OBJ05 like", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotLike(String value) {
            addCriterion("OBJ05 not like", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05In(List<String> values) {
            addCriterion("OBJ05 in", values, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotIn(List<String> values) {
            addCriterion("OBJ05 not in", values, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05Between(String value1, String value2) {
            addCriterion("OBJ05 between", value1, value2, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotBetween(String value1, String value2) {
            addCriterion("OBJ05 not between", value1, value2, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj06IsNull() {
            addCriterion("OBJ06 is null");
            return (Criteria) this;
        }

        public Criteria andObj06IsNotNull() {
            addCriterion("OBJ06 is not null");
            return (Criteria) this;
        }

        public Criteria andObj06EqualTo(String value) {
            addCriterion("OBJ06 =", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotEqualTo(String value) {
            addCriterion("OBJ06 <>", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06GreaterThan(String value) {
            addCriterion("OBJ06 >", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ06 >=", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06LessThan(String value) {
            addCriterion("OBJ06 <", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06LessThanOrEqualTo(String value) {
            addCriterion("OBJ06 <=", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06Like(String value) {
            addCriterion("OBJ06 like", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotLike(String value) {
            addCriterion("OBJ06 not like", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06In(List<String> values) {
            addCriterion("OBJ06 in", values, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotIn(List<String> values) {
            addCriterion("OBJ06 not in", values, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06Between(String value1, String value2) {
            addCriterion("OBJ06 between", value1, value2, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotBetween(String value1, String value2) {
            addCriterion("OBJ06 not between", value1, value2, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj07IsNull() {
            addCriterion("OBJ07 is null");
            return (Criteria) this;
        }

        public Criteria andObj07IsNotNull() {
            addCriterion("OBJ07 is not null");
            return (Criteria) this;
        }

        public Criteria andObj07EqualTo(String value) {
            addCriterion("OBJ07 =", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotEqualTo(String value) {
            addCriterion("OBJ07 <>", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07GreaterThan(String value) {
            addCriterion("OBJ07 >", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ07 >=", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07LessThan(String value) {
            addCriterion("OBJ07 <", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07LessThanOrEqualTo(String value) {
            addCriterion("OBJ07 <=", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07Like(String value) {
            addCriterion("OBJ07 like", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotLike(String value) {
            addCriterion("OBJ07 not like", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07In(List<String> values) {
            addCriterion("OBJ07 in", values, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotIn(List<String> values) {
            addCriterion("OBJ07 not in", values, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07Between(String value1, String value2) {
            addCriterion("OBJ07 between", value1, value2, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotBetween(String value1, String value2) {
            addCriterion("OBJ07 not between", value1, value2, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj08IsNull() {
            addCriterion("OBJ08 is null");
            return (Criteria) this;
        }

        public Criteria andObj08IsNotNull() {
            addCriterion("OBJ08 is not null");
            return (Criteria) this;
        }

        public Criteria andObj08EqualTo(String value) {
            addCriterion("OBJ08 =", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotEqualTo(String value) {
            addCriterion("OBJ08 <>", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08GreaterThan(String value) {
            addCriterion("OBJ08 >", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ08 >=", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08LessThan(String value) {
            addCriterion("OBJ08 <", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08LessThanOrEqualTo(String value) {
            addCriterion("OBJ08 <=", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08Like(String value) {
            addCriterion("OBJ08 like", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotLike(String value) {
            addCriterion("OBJ08 not like", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08In(List<String> values) {
            addCriterion("OBJ08 in", values, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotIn(List<String> values) {
            addCriterion("OBJ08 not in", values, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08Between(String value1, String value2) {
            addCriterion("OBJ08 between", value1, value2, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotBetween(String value1, String value2) {
            addCriterion("OBJ08 not between", value1, value2, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj09IsNull() {
            addCriterion("OBJ09 is null");
            return (Criteria) this;
        }

        public Criteria andObj09IsNotNull() {
            addCriterion("OBJ09 is not null");
            return (Criteria) this;
        }

        public Criteria andObj09EqualTo(String value) {
            addCriterion("OBJ09 =", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotEqualTo(String value) {
            addCriterion("OBJ09 <>", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09GreaterThan(String value) {
            addCriterion("OBJ09 >", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ09 >=", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09LessThan(String value) {
            addCriterion("OBJ09 <", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09LessThanOrEqualTo(String value) {
            addCriterion("OBJ09 <=", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09Like(String value) {
            addCriterion("OBJ09 like", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotLike(String value) {
            addCriterion("OBJ09 not like", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09In(List<String> values) {
            addCriterion("OBJ09 in", values, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotIn(List<String> values) {
            addCriterion("OBJ09 not in", values, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09Between(String value1, String value2) {
            addCriterion("OBJ09 between", value1, value2, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotBetween(String value1, String value2) {
            addCriterion("OBJ09 not between", value1, value2, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj10IsNull() {
            addCriterion("OBJ10 is null");
            return (Criteria) this;
        }

        public Criteria andObj10IsNotNull() {
            addCriterion("OBJ10 is not null");
            return (Criteria) this;
        }

        public Criteria andObj10EqualTo(String value) {
            addCriterion("OBJ10 =", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotEqualTo(String value) {
            addCriterion("OBJ10 <>", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10GreaterThan(String value) {
            addCriterion("OBJ10 >", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ10 >=", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10LessThan(String value) {
            addCriterion("OBJ10 <", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10LessThanOrEqualTo(String value) {
            addCriterion("OBJ10 <=", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10Like(String value) {
            addCriterion("OBJ10 like", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotLike(String value) {
            addCriterion("OBJ10 not like", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10In(List<String> values) {
            addCriterion("OBJ10 in", values, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotIn(List<String> values) {
            addCriterion("OBJ10 not in", values, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10Between(String value1, String value2) {
            addCriterion("OBJ10 between", value1, value2, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotBetween(String value1, String value2) {
            addCriterion("OBJ10 not between", value1, value2, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj11IsNull() {
            addCriterion("OBJ11 is null");
            return (Criteria) this;
        }

        public Criteria andObj11IsNotNull() {
            addCriterion("OBJ11 is not null");
            return (Criteria) this;
        }

        public Criteria andObj11EqualTo(String value) {
            addCriterion("OBJ11 =", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotEqualTo(String value) {
            addCriterion("OBJ11 <>", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11GreaterThan(String value) {
            addCriterion("OBJ11 >", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ11 >=", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11LessThan(String value) {
            addCriterion("OBJ11 <", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11LessThanOrEqualTo(String value) {
            addCriterion("OBJ11 <=", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11Like(String value) {
            addCriterion("OBJ11 like", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotLike(String value) {
            addCriterion("OBJ11 not like", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11In(List<String> values) {
            addCriterion("OBJ11 in", values, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotIn(List<String> values) {
            addCriterion("OBJ11 not in", values, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11Between(String value1, String value2) {
            addCriterion("OBJ11 between", value1, value2, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotBetween(String value1, String value2) {
            addCriterion("OBJ11 not between", value1, value2, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj12IsNull() {
            addCriterion("OBJ12 is null");
            return (Criteria) this;
        }

        public Criteria andObj12IsNotNull() {
            addCriterion("OBJ12 is not null");
            return (Criteria) this;
        }

        public Criteria andObj12EqualTo(String value) {
            addCriterion("OBJ12 =", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12NotEqualTo(String value) {
            addCriterion("OBJ12 <>", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12GreaterThan(String value) {
            addCriterion("OBJ12 >", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ12 >=", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12LessThan(String value) {
            addCriterion("OBJ12 <", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12LessThanOrEqualTo(String value) {
            addCriterion("OBJ12 <=", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12Like(String value) {
            addCriterion("OBJ12 like", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12NotLike(String value) {
            addCriterion("OBJ12 not like", value, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12In(List<String> values) {
            addCriterion("OBJ12 in", values, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12NotIn(List<String> values) {
            addCriterion("OBJ12 not in", values, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12Between(String value1, String value2) {
            addCriterion("OBJ12 between", value1, value2, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj12NotBetween(String value1, String value2) {
            addCriterion("OBJ12 not between", value1, value2, "obj12");
            return (Criteria) this;
        }

        public Criteria andObj13IsNull() {
            addCriterion("OBJ13 is null");
            return (Criteria) this;
        }

        public Criteria andObj13IsNotNull() {
            addCriterion("OBJ13 is not null");
            return (Criteria) this;
        }

        public Criteria andObj13EqualTo(String value) {
            addCriterion("OBJ13 =", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13NotEqualTo(String value) {
            addCriterion("OBJ13 <>", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13GreaterThan(String value) {
            addCriterion("OBJ13 >", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ13 >=", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13LessThan(String value) {
            addCriterion("OBJ13 <", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13LessThanOrEqualTo(String value) {
            addCriterion("OBJ13 <=", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13Like(String value) {
            addCriterion("OBJ13 like", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13NotLike(String value) {
            addCriterion("OBJ13 not like", value, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13In(List<String> values) {
            addCriterion("OBJ13 in", values, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13NotIn(List<String> values) {
            addCriterion("OBJ13 not in", values, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13Between(String value1, String value2) {
            addCriterion("OBJ13 between", value1, value2, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj13NotBetween(String value1, String value2) {
            addCriterion("OBJ13 not between", value1, value2, "obj13");
            return (Criteria) this;
        }

        public Criteria andObj14IsNull() {
            addCriterion("OBJ14 is null");
            return (Criteria) this;
        }

        public Criteria andObj14IsNotNull() {
            addCriterion("OBJ14 is not null");
            return (Criteria) this;
        }

        public Criteria andObj14EqualTo(String value) {
            addCriterion("OBJ14 =", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14NotEqualTo(String value) {
            addCriterion("OBJ14 <>", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14GreaterThan(String value) {
            addCriterion("OBJ14 >", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ14 >=", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14LessThan(String value) {
            addCriterion("OBJ14 <", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14LessThanOrEqualTo(String value) {
            addCriterion("OBJ14 <=", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14Like(String value) {
            addCriterion("OBJ14 like", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14NotLike(String value) {
            addCriterion("OBJ14 not like", value, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14In(List<String> values) {
            addCriterion("OBJ14 in", values, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14NotIn(List<String> values) {
            addCriterion("OBJ14 not in", values, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14Between(String value1, String value2) {
            addCriterion("OBJ14 between", value1, value2, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj14NotBetween(String value1, String value2) {
            addCriterion("OBJ14 not between", value1, value2, "obj14");
            return (Criteria) this;
        }

        public Criteria andObj15IsNull() {
            addCriterion("OBJ15 is null");
            return (Criteria) this;
        }

        public Criteria andObj15IsNotNull() {
            addCriterion("OBJ15 is not null");
            return (Criteria) this;
        }

        public Criteria andObj15EqualTo(String value) {
            addCriterion("OBJ15 =", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15NotEqualTo(String value) {
            addCriterion("OBJ15 <>", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15GreaterThan(String value) {
            addCriterion("OBJ15 >", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ15 >=", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15LessThan(String value) {
            addCriterion("OBJ15 <", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15LessThanOrEqualTo(String value) {
            addCriterion("OBJ15 <=", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15Like(String value) {
            addCriterion("OBJ15 like", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15NotLike(String value) {
            addCriterion("OBJ15 not like", value, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15In(List<String> values) {
            addCriterion("OBJ15 in", values, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15NotIn(List<String> values) {
            addCriterion("OBJ15 not in", values, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15Between(String value1, String value2) {
            addCriterion("OBJ15 between", value1, value2, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj15NotBetween(String value1, String value2) {
            addCriterion("OBJ15 not between", value1, value2, "obj15");
            return (Criteria) this;
        }

        public Criteria andObj16IsNull() {
            addCriterion("OBJ16 is null");
            return (Criteria) this;
        }

        public Criteria andObj16IsNotNull() {
            addCriterion("OBJ16 is not null");
            return (Criteria) this;
        }

        public Criteria andObj16EqualTo(String value) {
            addCriterion("OBJ16 =", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16NotEqualTo(String value) {
            addCriterion("OBJ16 <>", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16GreaterThan(String value) {
            addCriterion("OBJ16 >", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ16 >=", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16LessThan(String value) {
            addCriterion("OBJ16 <", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16LessThanOrEqualTo(String value) {
            addCriterion("OBJ16 <=", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16Like(String value) {
            addCriterion("OBJ16 like", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16NotLike(String value) {
            addCriterion("OBJ16 not like", value, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16In(List<String> values) {
            addCriterion("OBJ16 in", values, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16NotIn(List<String> values) {
            addCriterion("OBJ16 not in", values, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16Between(String value1, String value2) {
            addCriterion("OBJ16 between", value1, value2, "obj16");
            return (Criteria) this;
        }

        public Criteria andObj16NotBetween(String value1, String value2) {
            addCriterion("OBJ16 not between", value1, value2, "obj16");
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