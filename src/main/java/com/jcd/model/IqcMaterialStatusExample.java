package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IqcMaterialStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IqcMaterialStatusExample() {
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

        public Criteria andStatusidIsNull() {
            addCriterion("STATUSID is null");
            return (Criteria) this;
        }

        public Criteria andStatusidIsNotNull() {
            addCriterion("STATUSID is not null");
            return (Criteria) this;
        }

        public Criteria andStatusidEqualTo(String value) {
            addCriterion("STATUSID =", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidNotEqualTo(String value) {
            addCriterion("STATUSID <>", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidGreaterThan(String value) {
            addCriterion("STATUSID >", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidGreaterThanOrEqualTo(String value) {
            addCriterion("STATUSID >=", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidLessThan(String value) {
            addCriterion("STATUSID <", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidLessThanOrEqualTo(String value) {
            addCriterion("STATUSID <=", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidLike(String value) {
            addCriterion("STATUSID like", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidNotLike(String value) {
            addCriterion("STATUSID not like", value, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidIn(List<String> values) {
            addCriterion("STATUSID in", values, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidNotIn(List<String> values) {
            addCriterion("STATUSID not in", values, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidBetween(String value1, String value2) {
            addCriterion("STATUSID between", value1, value2, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusidNotBetween(String value1, String value2) {
            addCriterion("STATUSID not between", value1, value2, "statusid");
            return (Criteria) this;
        }

        public Criteria andStatusnameIsNull() {
            addCriterion("STATUSNAME is null");
            return (Criteria) this;
        }

        public Criteria andStatusnameIsNotNull() {
            addCriterion("STATUSNAME is not null");
            return (Criteria) this;
        }

        public Criteria andStatusnameEqualTo(String value) {
            addCriterion("STATUSNAME =", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameNotEqualTo(String value) {
            addCriterion("STATUSNAME <>", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameGreaterThan(String value) {
            addCriterion("STATUSNAME >", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameGreaterThanOrEqualTo(String value) {
            addCriterion("STATUSNAME >=", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameLessThan(String value) {
            addCriterion("STATUSNAME <", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameLessThanOrEqualTo(String value) {
            addCriterion("STATUSNAME <=", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameLike(String value) {
            addCriterion("STATUSNAME like", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameNotLike(String value) {
            addCriterion("STATUSNAME not like", value, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameIn(List<String> values) {
            addCriterion("STATUSNAME in", values, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameNotIn(List<String> values) {
            addCriterion("STATUSNAME not in", values, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameBetween(String value1, String value2) {
            addCriterion("STATUSNAME between", value1, value2, "statusname");
            return (Criteria) this;
        }

        public Criteria andStatusnameNotBetween(String value1, String value2) {
            addCriterion("STATUSNAME not between", value1, value2, "statusname");
            return (Criteria) this;
        }

        public Criteria andFifopriorityIsNull() {
            addCriterion("FIFOPRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andFifopriorityIsNotNull() {
            addCriterion("FIFOPRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andFifopriorityEqualTo(String value) {
            addCriterion("FIFOPRIORITY =", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityNotEqualTo(String value) {
            addCriterion("FIFOPRIORITY <>", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityGreaterThan(String value) {
            addCriterion("FIFOPRIORITY >", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityGreaterThanOrEqualTo(String value) {
            addCriterion("FIFOPRIORITY >=", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityLessThan(String value) {
            addCriterion("FIFOPRIORITY <", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityLessThanOrEqualTo(String value) {
            addCriterion("FIFOPRIORITY <=", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityLike(String value) {
            addCriterion("FIFOPRIORITY like", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityNotLike(String value) {
            addCriterion("FIFOPRIORITY not like", value, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityIn(List<String> values) {
            addCriterion("FIFOPRIORITY in", values, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityNotIn(List<String> values) {
            addCriterion("FIFOPRIORITY not in", values, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityBetween(String value1, String value2) {
            addCriterion("FIFOPRIORITY between", value1, value2, "fifopriority");
            return (Criteria) this;
        }

        public Criteria andFifopriorityNotBetween(String value1, String value2) {
            addCriterion("FIFOPRIORITY not between", value1, value2, "fifopriority");
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