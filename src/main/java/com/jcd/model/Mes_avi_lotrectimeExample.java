package com.jcd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mes_avi_lotrectimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Mes_avi_lotrectimeExample() {
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

        public Criteria andEqpNoIsNull() {
            addCriterion("EQP_NO is null");
            return (Criteria) this;
        }

        public Criteria andEqpNoIsNotNull() {
            addCriterion("EQP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andEqpNoEqualTo(String value) {
            addCriterion("EQP_NO =", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoNotEqualTo(String value) {
            addCriterion("EQP_NO <>", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoGreaterThan(String value) {
            addCriterion("EQP_NO >", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoGreaterThanOrEqualTo(String value) {
            addCriterion("EQP_NO >=", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoLessThan(String value) {
            addCriterion("EQP_NO <", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoLessThanOrEqualTo(String value) {
            addCriterion("EQP_NO <=", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoLike(String value) {
            addCriterion("EQP_NO like", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoNotLike(String value) {
            addCriterion("EQP_NO not like", value, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoIn(List<String> values) {
            addCriterion("EQP_NO in", values, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoNotIn(List<String> values) {
            addCriterion("EQP_NO not in", values, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoBetween(String value1, String value2) {
            addCriterion("EQP_NO between", value1, value2, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andEqpNoNotBetween(String value1, String value2) {
            addCriterion("EQP_NO not between", value1, value2, "eqpNo");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNull() {
            addCriterion("PRODUCT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNotNull() {
            addCriterion("PRODUCT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumberEqualTo(String value) {
            addCriterion("PRODUCT_NUMBER =", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotEqualTo(String value) {
            addCriterion("PRODUCT_NUMBER <>", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThan(String value) {
            addCriterion("PRODUCT_NUMBER >", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NUMBER >=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThan(String value) {
            addCriterion("PRODUCT_NUMBER <", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NUMBER <=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLike(String value) {
            addCriterion("PRODUCT_NUMBER like", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotLike(String value) {
            addCriterion("PRODUCT_NUMBER not like", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberIn(List<String> values) {
            addCriterion("PRODUCT_NUMBER in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotIn(List<String> values) {
            addCriterion("PRODUCT_NUMBER not in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberBetween(String value1, String value2) {
            addCriterion("PRODUCT_NUMBER between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NUMBER not between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andLotIsNull() {
            addCriterion("LOT is null");
            return (Criteria) this;
        }

        public Criteria andLotIsNotNull() {
            addCriterion("LOT is not null");
            return (Criteria) this;
        }

        public Criteria andLotEqualTo(String value) {
            addCriterion("LOT =", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotEqualTo(String value) {
            addCriterion("LOT <>", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotGreaterThan(String value) {
            addCriterion("LOT >", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotGreaterThanOrEqualTo(String value) {
            addCriterion("LOT >=", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotLessThan(String value) {
            addCriterion("LOT <", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotLessThanOrEqualTo(String value) {
            addCriterion("LOT <=", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotLike(String value) {
            addCriterion("LOT like", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotLike(String value) {
            addCriterion("LOT not like", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotIn(List<String> values) {
            addCriterion("LOT in", values, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotIn(List<String> values) {
            addCriterion("LOT not in", values, "lot");
            return (Criteria) this;
        }

        public Criteria andLotBetween(String value1, String value2) {
            addCriterion("LOT between", value1, value2, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotBetween(String value1, String value2) {
            addCriterion("LOT not between", value1, value2, "lot");
            return (Criteria) this;
        }

        public Criteria andScanTotalIsNull() {
            addCriterion("SCAN_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andScanTotalIsNotNull() {
            addCriterion("SCAN_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andScanTotalEqualTo(Long value) {
            addCriterion("SCAN_TOTAL =", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalNotEqualTo(Long value) {
            addCriterion("SCAN_TOTAL <>", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalGreaterThan(Long value) {
            addCriterion("SCAN_TOTAL >", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("SCAN_TOTAL >=", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalLessThan(Long value) {
            addCriterion("SCAN_TOTAL <", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalLessThanOrEqualTo(Long value) {
            addCriterion("SCAN_TOTAL <=", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalIn(List<Long> values) {
            addCriterion("SCAN_TOTAL in", values, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalNotIn(List<Long> values) {
            addCriterion("SCAN_TOTAL not in", values, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalBetween(Long value1, Long value2) {
            addCriterion("SCAN_TOTAL between", value1, value2, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalNotBetween(Long value1, Long value2) {
            addCriterion("SCAN_TOTAL not between", value1, value2, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("TOTAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("TOTAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TIME =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TIME <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_TIME >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TIME >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(BigDecimal value) {
            addCriterion("TOTAL_TIME <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TIME <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<BigDecimal> values) {
            addCriterion("TOTAL_TIME in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_TIME not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_TIME between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_TIME not between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeIsNull() {
            addCriterion("OPERATOR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeIsNotNull() {
            addCriterion("OPERATOR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeEqualTo(String value) {
            addCriterion("OPERATOR_CODE =", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeNotEqualTo(String value) {
            addCriterion("OPERATOR_CODE <>", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeGreaterThan(String value) {
            addCriterion("OPERATOR_CODE >", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_CODE >=", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeLessThan(String value) {
            addCriterion("OPERATOR_CODE <", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_CODE <=", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeLike(String value) {
            addCriterion("OPERATOR_CODE like", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeNotLike(String value) {
            addCriterion("OPERATOR_CODE not like", value, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeIn(List<String> values) {
            addCriterion("OPERATOR_CODE in", values, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeNotIn(List<String> values) {
            addCriterion("OPERATOR_CODE not in", values, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeBetween(String value1, String value2) {
            addCriterion("OPERATOR_CODE between", value1, value2, "operatorCode");
            return (Criteria) this;
        }

        public Criteria andOperatorCodeNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_CODE not between", value1, value2, "operatorCode");
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