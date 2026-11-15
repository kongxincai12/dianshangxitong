package com.jcd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Uf_loadsteppasstimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Uf_loadsteppasstimeExample() {
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

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRequestidIsNull() {
            addCriterion("REQUESTID is null");
            return (Criteria) this;
        }

        public Criteria andRequestidIsNotNull() {
            addCriterion("REQUESTID is not null");
            return (Criteria) this;
        }

        public Criteria andRequestidEqualTo(BigDecimal value) {
            addCriterion("REQUESTID =", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotEqualTo(BigDecimal value) {
            addCriterion("REQUESTID <>", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThan(BigDecimal value) {
            addCriterion("REQUESTID >", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REQUESTID >=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThan(BigDecimal value) {
            addCriterion("REQUESTID <", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REQUESTID <=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidIn(List<BigDecimal> values) {
            addCriterion("REQUESTID in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotIn(List<BigDecimal> values) {
            addCriterion("REQUESTID not in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REQUESTID between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REQUESTID not between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidIsNull() {
            addCriterion("FORMMODEID is null");
            return (Criteria) this;
        }

        public Criteria andFormmodeidIsNotNull() {
            addCriterion("FORMMODEID is not null");
            return (Criteria) this;
        }

        public Criteria andFormmodeidEqualTo(BigDecimal value) {
            addCriterion("FORMMODEID =", value, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidNotEqualTo(BigDecimal value) {
            addCriterion("FORMMODEID <>", value, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidGreaterThan(BigDecimal value) {
            addCriterion("FORMMODEID >", value, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FORMMODEID >=", value, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidLessThan(BigDecimal value) {
            addCriterion("FORMMODEID <", value, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FORMMODEID <=", value, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidIn(List<BigDecimal> values) {
            addCriterion("FORMMODEID in", values, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidNotIn(List<BigDecimal> values) {
            addCriterion("FORMMODEID not in", values, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORMMODEID between", value1, value2, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andFormmodeidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FORMMODEID not between", value1, value2, "formmodeid");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterIsNull() {
            addCriterion("MODEDATACREATER is null");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterIsNotNull() {
            addCriterion("MODEDATACREATER is not null");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATER =", value, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterNotEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATER <>", value, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterGreaterThan(BigDecimal value) {
            addCriterion("MODEDATACREATER >", value, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATER >=", value, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterLessThan(BigDecimal value) {
            addCriterion("MODEDATACREATER <", value, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATER <=", value, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterIn(List<BigDecimal> values) {
            addCriterion("MODEDATACREATER in", values, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterNotIn(List<BigDecimal> values) {
            addCriterion("MODEDATACREATER not in", values, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODEDATACREATER between", value1, value2, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreaterNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODEDATACREATER not between", value1, value2, "modedatacreater");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeIsNull() {
            addCriterion("MODEDATACREATERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeIsNotNull() {
            addCriterion("MODEDATACREATERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATERTYPE =", value, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeNotEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATERTYPE <>", value, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeGreaterThan(BigDecimal value) {
            addCriterion("MODEDATACREATERTYPE >", value, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATERTYPE >=", value, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeLessThan(BigDecimal value) {
            addCriterion("MODEDATACREATERTYPE <", value, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MODEDATACREATERTYPE <=", value, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeIn(List<BigDecimal> values) {
            addCriterion("MODEDATACREATERTYPE in", values, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeNotIn(List<BigDecimal> values) {
            addCriterion("MODEDATACREATERTYPE not in", values, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODEDATACREATERTYPE between", value1, value2, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatertypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODEDATACREATERTYPE not between", value1, value2, "modedatacreatertype");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateIsNull() {
            addCriterion("MODEDATACREATEDATE is null");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateIsNotNull() {
            addCriterion("MODEDATACREATEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateEqualTo(String value) {
            addCriterion("MODEDATACREATEDATE =", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateNotEqualTo(String value) {
            addCriterion("MODEDATACREATEDATE <>", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateGreaterThan(String value) {
            addCriterion("MODEDATACREATEDATE >", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("MODEDATACREATEDATE >=", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateLessThan(String value) {
            addCriterion("MODEDATACREATEDATE <", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateLessThanOrEqualTo(String value) {
            addCriterion("MODEDATACREATEDATE <=", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateLike(String value) {
            addCriterion("MODEDATACREATEDATE like", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateNotLike(String value) {
            addCriterion("MODEDATACREATEDATE not like", value, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateIn(List<String> values) {
            addCriterion("MODEDATACREATEDATE in", values, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateNotIn(List<String> values) {
            addCriterion("MODEDATACREATEDATE not in", values, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateBetween(String value1, String value2) {
            addCriterion("MODEDATACREATEDATE between", value1, value2, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatedateNotBetween(String value1, String value2) {
            addCriterion("MODEDATACREATEDATE not between", value1, value2, "modedatacreatedate");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeIsNull() {
            addCriterion("MODEDATACREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeIsNotNull() {
            addCriterion("MODEDATACREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeEqualTo(String value) {
            addCriterion("MODEDATACREATETIME =", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeNotEqualTo(String value) {
            addCriterion("MODEDATACREATETIME <>", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeGreaterThan(String value) {
            addCriterion("MODEDATACREATETIME >", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("MODEDATACREATETIME >=", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeLessThan(String value) {
            addCriterion("MODEDATACREATETIME <", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeLessThanOrEqualTo(String value) {
            addCriterion("MODEDATACREATETIME <=", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeLike(String value) {
            addCriterion("MODEDATACREATETIME like", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeNotLike(String value) {
            addCriterion("MODEDATACREATETIME not like", value, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeIn(List<String> values) {
            addCriterion("MODEDATACREATETIME in", values, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeNotIn(List<String> values) {
            addCriterion("MODEDATACREATETIME not in", values, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeBetween(String value1, String value2) {
            addCriterion("MODEDATACREATETIME between", value1, value2, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andModedatacreatetimeNotBetween(String value1, String value2) {
            addCriterion("MODEDATACREATETIME not between", value1, value2, "modedatacreatetime");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("STEP is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("STEP is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(String value) {
            addCriterion("STEP =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(String value) {
            addCriterion("STEP <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(String value) {
            addCriterion("STEP >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(String value) {
            addCriterion("STEP >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(String value) {
            addCriterion("STEP <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(String value) {
            addCriterion("STEP <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLike(String value) {
            addCriterion("STEP like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotLike(String value) {
            addCriterion("STEP not like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<String> values) {
            addCriterion("STEP in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<String> values) {
            addCriterion("STEP not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(String value1, String value2) {
            addCriterion("STEP between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(String value1, String value2) {
            addCriterion("STEP not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(BigDecimal value) {
            addCriterion("TIME =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(BigDecimal value) {
            addCriterion("TIME <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(BigDecimal value) {
            addCriterion("TIME >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(BigDecimal value) {
            addCriterion("TIME <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<BigDecimal> values) {
            addCriterion("TIME in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<BigDecimal> values) {
            addCriterion("TIME not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
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