package com.jcd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentTypeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeIsNull() {
            addCriterion("EQP_TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeIsNotNull() {
            addCriterion("EQP_TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeEqualTo(String value) {
            addCriterion("EQP_TYPE_CODE =", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeNotEqualTo(String value) {
            addCriterion("EQP_TYPE_CODE <>", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeGreaterThan(String value) {
            addCriterion("EQP_TYPE_CODE >", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EQP_TYPE_CODE >=", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeLessThan(String value) {
            addCriterion("EQP_TYPE_CODE <", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("EQP_TYPE_CODE <=", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeLike(String value) {
            addCriterion("EQP_TYPE_CODE like", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeNotLike(String value) {
            addCriterion("EQP_TYPE_CODE not like", value, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeIn(List<String> values) {
            addCriterion("EQP_TYPE_CODE in", values, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeNotIn(List<String> values) {
            addCriterion("EQP_TYPE_CODE not in", values, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeBetween(String value1, String value2) {
            addCriterion("EQP_TYPE_CODE between", value1, value2, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeCodeNotBetween(String value1, String value2) {
            addCriterion("EQP_TYPE_CODE not between", value1, value2, "eqpTypeCode");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameIsNull() {
            addCriterion("EQP_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameIsNotNull() {
            addCriterion("EQP_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameEqualTo(String value) {
            addCriterion("EQP_TYPE_NAME =", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameNotEqualTo(String value) {
            addCriterion("EQP_TYPE_NAME <>", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameGreaterThan(String value) {
            addCriterion("EQP_TYPE_NAME >", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("EQP_TYPE_NAME >=", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameLessThan(String value) {
            addCriterion("EQP_TYPE_NAME <", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameLessThanOrEqualTo(String value) {
            addCriterion("EQP_TYPE_NAME <=", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameLike(String value) {
            addCriterion("EQP_TYPE_NAME like", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameNotLike(String value) {
            addCriterion("EQP_TYPE_NAME not like", value, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameIn(List<String> values) {
            addCriterion("EQP_TYPE_NAME in", values, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameNotIn(List<String> values) {
            addCriterion("EQP_TYPE_NAME not in", values, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameBetween(String value1, String value2) {
            addCriterion("EQP_TYPE_NAME between", value1, value2, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andEqpTypeNameNotBetween(String value1, String value2) {
            addCriterion("EQP_TYPE_NAME not between", value1, value2, "eqpTypeName");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("IMG_URL =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("IMG_URL <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("IMG_URL >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IMG_URL >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("IMG_URL <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("IMG_URL <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("IMG_URL like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("IMG_URL not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("IMG_URL in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("IMG_URL not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("IMG_URL between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("IMG_URL not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryIsNull() {
            addCriterion("EQP_CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryIsNotNull() {
            addCriterion("EQP_CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryEqualTo(String value) {
            addCriterion("EQP_CATEGORY =", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryNotEqualTo(String value) {
            addCriterion("EQP_CATEGORY <>", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryGreaterThan(String value) {
            addCriterion("EQP_CATEGORY >", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("EQP_CATEGORY >=", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryLessThan(String value) {
            addCriterion("EQP_CATEGORY <", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryLessThanOrEqualTo(String value) {
            addCriterion("EQP_CATEGORY <=", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryLike(String value) {
            addCriterion("EQP_CATEGORY like", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryNotLike(String value) {
            addCriterion("EQP_CATEGORY not like", value, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryIn(List<String> values) {
            addCriterion("EQP_CATEGORY in", values, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryNotIn(List<String> values) {
            addCriterion("EQP_CATEGORY not in", values, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryBetween(String value1, String value2) {
            addCriterion("EQP_CATEGORY between", value1, value2, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andEqpCategoryNotBetween(String value1, String value2) {
            addCriterion("EQP_CATEGORY not between", value1, value2, "eqpCategory");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("OWNER is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("OWNER =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("OWNER <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("OWNER >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("OWNER <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("OWNER <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("OWNER like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("OWNER not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("OWNER in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("OWNER not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("OWNER between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("OWNER not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andSiteCodeIsNull() {
            addCriterion("SITE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSiteCodeIsNotNull() {
            addCriterion("SITE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSiteCodeEqualTo(String value) {
            addCriterion("SITE_CODE =", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeNotEqualTo(String value) {
            addCriterion("SITE_CODE <>", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeGreaterThan(String value) {
            addCriterion("SITE_CODE >", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SITE_CODE >=", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeLessThan(String value) {
            addCriterion("SITE_CODE <", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeLessThanOrEqualTo(String value) {
            addCriterion("SITE_CODE <=", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeLike(String value) {
            addCriterion("SITE_CODE like", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeNotLike(String value) {
            addCriterion("SITE_CODE not like", value, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeIn(List<String> values) {
            addCriterion("SITE_CODE in", values, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeNotIn(List<String> values) {
            addCriterion("SITE_CODE not in", values, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeBetween(String value1, String value2) {
            addCriterion("SITE_CODE between", value1, value2, "siteCode");
            return (Criteria) this;
        }

        public Criteria andSiteCodeNotBetween(String value1, String value2) {
            addCriterion("SITE_CODE not between", value1, value2, "siteCode");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIsNull() {
            addCriterion("ENABLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIsNotNull() {
            addCriterion("ENABLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEnableFlagEqualTo(String value) {
            addCriterion("ENABLE_FLAG =", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotEqualTo(String value) {
            addCriterion("ENABLE_FLAG <>", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagGreaterThan(String value) {
            addCriterion("ENABLE_FLAG >", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagGreaterThanOrEqualTo(String value) {
            addCriterion("ENABLE_FLAG >=", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLessThan(String value) {
            addCriterion("ENABLE_FLAG <", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLessThanOrEqualTo(String value) {
            addCriterion("ENABLE_FLAG <=", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagLike(String value) {
            addCriterion("ENABLE_FLAG like", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotLike(String value) {
            addCriterion("ENABLE_FLAG not like", value, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagIn(List<String> values) {
            addCriterion("ENABLE_FLAG in", values, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotIn(List<String> values) {
            addCriterion("ENABLE_FLAG not in", values, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagBetween(String value1, String value2) {
            addCriterion("ENABLE_FLAG between", value1, value2, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andEnableFlagNotBetween(String value1, String value2) {
            addCriterion("ENABLE_FLAG not between", value1, value2, "enableFlag");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("UPDATE_BY like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("UPDATE_BY not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNull() {
            addCriterion("REVISION is null");
            return (Criteria) this;
        }

        public Criteria andRevisionIsNotNull() {
            addCriterion("REVISION is not null");
            return (Criteria) this;
        }

        public Criteria andRevisionEqualTo(BigDecimal value) {
            addCriterion("REVISION =", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotEqualTo(BigDecimal value) {
            addCriterion("REVISION <>", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThan(BigDecimal value) {
            addCriterion("REVISION >", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REVISION >=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThan(BigDecimal value) {
            addCriterion("REVISION <", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REVISION <=", value, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionIn(List<BigDecimal> values) {
            addCriterion("REVISION in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotIn(List<BigDecimal> values) {
            addCriterion("REVISION not in", values, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REVISION between", value1, value2, "revision");
            return (Criteria) this;
        }

        public Criteria andRevisionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REVISION not between", value1, value2, "revision");
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