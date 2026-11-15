package com.jcd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParamOverrideExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParamOverrideExample() {
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

        public Criteria andEqpIdIsNull() {
            addCriterion("EQP_ID is null");
            return (Criteria) this;
        }

        public Criteria andEqpIdIsNotNull() {
            addCriterion("EQP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEqpIdEqualTo(String value) {
            addCriterion("EQP_ID =", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdNotEqualTo(String value) {
            addCriterion("EQP_ID <>", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdGreaterThan(String value) {
            addCriterion("EQP_ID >", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdGreaterThanOrEqualTo(String value) {
            addCriterion("EQP_ID >=", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdLessThan(String value) {
            addCriterion("EQP_ID <", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdLessThanOrEqualTo(String value) {
            addCriterion("EQP_ID <=", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdLike(String value) {
            addCriterion("EQP_ID like", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdNotLike(String value) {
            addCriterion("EQP_ID not like", value, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdIn(List<String> values) {
            addCriterion("EQP_ID in", values, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdNotIn(List<String> values) {
            addCriterion("EQP_ID not in", values, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdBetween(String value1, String value2) {
            addCriterion("EQP_ID between", value1, value2, "eqpId");
            return (Criteria) this;
        }

        public Criteria andEqpIdNotBetween(String value1, String value2) {
            addCriterion("EQP_ID not between", value1, value2, "eqpId");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("PRODUCT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("PRODUCT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("PRODUCT_CODE =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("PRODUCT_CODE <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("PRODUCT_CODE >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("PRODUCT_CODE <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("PRODUCT_CODE like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("PRODUCT_CODE not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("PRODUCT_CODE in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("PRODUCT_CODE not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andParamKeyIsNull() {
            addCriterion("PARAM_KEY is null");
            return (Criteria) this;
        }

        public Criteria andParamKeyIsNotNull() {
            addCriterion("PARAM_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andParamKeyEqualTo(String value) {
            addCriterion("PARAM_KEY =", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotEqualTo(String value) {
            addCriterion("PARAM_KEY <>", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyGreaterThan(String value) {
            addCriterion("PARAM_KEY >", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_KEY >=", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLessThan(String value) {
            addCriterion("PARAM_KEY <", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLessThanOrEqualTo(String value) {
            addCriterion("PARAM_KEY <=", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyLike(String value) {
            addCriterion("PARAM_KEY like", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotLike(String value) {
            addCriterion("PARAM_KEY not like", value, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyIn(List<String> values) {
            addCriterion("PARAM_KEY in", values, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotIn(List<String> values) {
            addCriterion("PARAM_KEY not in", values, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyBetween(String value1, String value2) {
            addCriterion("PARAM_KEY between", value1, value2, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamKeyNotBetween(String value1, String value2) {
            addCriterion("PARAM_KEY not between", value1, value2, "paramKey");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("PARAM_NAME =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("PARAM_NAME <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("PARAM_NAME >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("PARAM_NAME <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("PARAM_NAME like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("PARAM_NAME not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("PARAM_NAME in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("PARAM_NAME not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("PARAM_NAME between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("PARAM_NAME not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamOrderIsNull() {
            addCriterion("PARAM_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andParamOrderIsNotNull() {
            addCriterion("PARAM_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andParamOrderEqualTo(BigDecimal value) {
            addCriterion("PARAM_ORDER =", value, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderNotEqualTo(BigDecimal value) {
            addCriterion("PARAM_ORDER <>", value, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderGreaterThan(BigDecimal value) {
            addCriterion("PARAM_ORDER >", value, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PARAM_ORDER >=", value, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderLessThan(BigDecimal value) {
            addCriterion("PARAM_ORDER <", value, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PARAM_ORDER <=", value, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderIn(List<BigDecimal> values) {
            addCriterion("PARAM_ORDER in", values, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderNotIn(List<BigDecimal> values) {
            addCriterion("PARAM_ORDER not in", values, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARAM_ORDER between", value1, value2, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andParamOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PARAM_ORDER not between", value1, value2, "paramOrder");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayIsNull() {
            addCriterion("STANDARD_DISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayIsNotNull() {
            addCriterion("STANDARD_DISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayEqualTo(String value) {
            addCriterion("STANDARD_DISPLAY =", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayNotEqualTo(String value) {
            addCriterion("STANDARD_DISPLAY <>", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayGreaterThan(String value) {
            addCriterion("STANDARD_DISPLAY >", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("STANDARD_DISPLAY >=", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayLessThan(String value) {
            addCriterion("STANDARD_DISPLAY <", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayLessThanOrEqualTo(String value) {
            addCriterion("STANDARD_DISPLAY <=", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayLike(String value) {
            addCriterion("STANDARD_DISPLAY like", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayNotLike(String value) {
            addCriterion("STANDARD_DISPLAY not like", value, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayIn(List<String> values) {
            addCriterion("STANDARD_DISPLAY in", values, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayNotIn(List<String> values) {
            addCriterion("STANDARD_DISPLAY not in", values, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayBetween(String value1, String value2) {
            addCriterion("STANDARD_DISPLAY between", value1, value2, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andStandardDisplayNotBetween(String value1, String value2) {
            addCriterion("STANDARD_DISPLAY not between", value1, value2, "standardDisplay");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("DATA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("DATA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("DATA_TYPE =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("DATA_TYPE <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("DATA_TYPE >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("DATA_TYPE <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("DATA_TYPE like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("DATA_TYPE not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("DATA_TYPE in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("DATA_TYPE not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("DATA_TYPE between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("DATA_TYPE not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeIsNull() {
            addCriterion("VALIDATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andValidationTypeIsNotNull() {
            addCriterion("VALIDATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andValidationTypeEqualTo(String value) {
            addCriterion("VALIDATION_TYPE =", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeNotEqualTo(String value) {
            addCriterion("VALIDATION_TYPE <>", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeGreaterThan(String value) {
            addCriterion("VALIDATION_TYPE >", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("VALIDATION_TYPE >=", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeLessThan(String value) {
            addCriterion("VALIDATION_TYPE <", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeLessThanOrEqualTo(String value) {
            addCriterion("VALIDATION_TYPE <=", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeLike(String value) {
            addCriterion("VALIDATION_TYPE like", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeNotLike(String value) {
            addCriterion("VALIDATION_TYPE not like", value, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeIn(List<String> values) {
            addCriterion("VALIDATION_TYPE in", values, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeNotIn(List<String> values) {
            addCriterion("VALIDATION_TYPE not in", values, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeBetween(String value1, String value2) {
            addCriterion("VALIDATION_TYPE between", value1, value2, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationTypeNotBetween(String value1, String value2) {
            addCriterion("VALIDATION_TYPE not between", value1, value2, "validationType");
            return (Criteria) this;
        }

        public Criteria andValidationRuleIsNull() {
            addCriterion("VALIDATION_RULE is null");
            return (Criteria) this;
        }

        public Criteria andValidationRuleIsNotNull() {
            addCriterion("VALIDATION_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andValidationRuleEqualTo(String value) {
            addCriterion("VALIDATION_RULE =", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleNotEqualTo(String value) {
            addCriterion("VALIDATION_RULE <>", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleGreaterThan(String value) {
            addCriterion("VALIDATION_RULE >", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleGreaterThanOrEqualTo(String value) {
            addCriterion("VALIDATION_RULE >=", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleLessThan(String value) {
            addCriterion("VALIDATION_RULE <", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleLessThanOrEqualTo(String value) {
            addCriterion("VALIDATION_RULE <=", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleLike(String value) {
            addCriterion("VALIDATION_RULE like", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleNotLike(String value) {
            addCriterion("VALIDATION_RULE not like", value, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleIn(List<String> values) {
            addCriterion("VALIDATION_RULE in", values, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleNotIn(List<String> values) {
            addCriterion("VALIDATION_RULE not in", values, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleBetween(String value1, String value2) {
            addCriterion("VALIDATION_RULE between", value1, value2, "validationRule");
            return (Criteria) this;
        }

        public Criteria andValidationRuleNotBetween(String value1, String value2) {
            addCriterion("VALIDATION_RULE not between", value1, value2, "validationRule");
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