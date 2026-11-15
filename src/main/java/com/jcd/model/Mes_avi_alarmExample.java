package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mes_avi_alarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Mes_avi_alarmExample() {
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

        public Criteria andAlarmDescriptionIsNull() {
            addCriterion("ALARM_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionIsNotNull() {
            addCriterion("ALARM_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionEqualTo(String value) {
            addCriterion("ALARM_DESCRIPTION =", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionNotEqualTo(String value) {
            addCriterion("ALARM_DESCRIPTION <>", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionGreaterThan(String value) {
            addCriterion("ALARM_DESCRIPTION >", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("ALARM_DESCRIPTION >=", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionLessThan(String value) {
            addCriterion("ALARM_DESCRIPTION <", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionLessThanOrEqualTo(String value) {
            addCriterion("ALARM_DESCRIPTION <=", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionLike(String value) {
            addCriterion("ALARM_DESCRIPTION like", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionNotLike(String value) {
            addCriterion("ALARM_DESCRIPTION not like", value, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionIn(List<String> values) {
            addCriterion("ALARM_DESCRIPTION in", values, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionNotIn(List<String> values) {
            addCriterion("ALARM_DESCRIPTION not in", values, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionBetween(String value1, String value2) {
            addCriterion("ALARM_DESCRIPTION between", value1, value2, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmDescriptionNotBetween(String value1, String value2) {
            addCriterion("ALARM_DESCRIPTION not between", value1, value2, "alarmDescription");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNull() {
            addCriterion("ALARM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNotNull() {
            addCriterion("ALARM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeEqualTo(Date value) {
            addCriterion("ALARM_TIME =", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotEqualTo(Date value) {
            addCriterion("ALARM_TIME <>", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThan(Date value) {
            addCriterion("ALARM_TIME >", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ALARM_TIME >=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThan(Date value) {
            addCriterion("ALARM_TIME <", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("ALARM_TIME <=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIn(List<Date> values) {
            addCriterion("ALARM_TIME in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotIn(List<Date> values) {
            addCriterion("ALARM_TIME not in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("ALARM_TIME between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("ALARM_TIME not between", value1, value2, "alarmTime");
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