package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlmappinginfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlmappinginfoExample() {
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

        public Criteria andMlmiidIsNull() {
            addCriterion("MLMIID is null");
            return (Criteria) this;
        }

        public Criteria andMlmiidIsNotNull() {
            addCriterion("MLMIID is not null");
            return (Criteria) this;
        }

        public Criteria andMlmiidEqualTo(String value) {
            addCriterion("MLMIID =", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidNotEqualTo(String value) {
            addCriterion("MLMIID <>", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidGreaterThan(String value) {
            addCriterion("MLMIID >", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidGreaterThanOrEqualTo(String value) {
            addCriterion("MLMIID >=", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidLessThan(String value) {
            addCriterion("MLMIID <", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidLessThanOrEqualTo(String value) {
            addCriterion("MLMIID <=", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidLike(String value) {
            addCriterion("MLMIID like", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidNotLike(String value) {
            addCriterion("MLMIID not like", value, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidIn(List<String> values) {
            addCriterion("MLMIID in", values, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidNotIn(List<String> values) {
            addCriterion("MLMIID not in", values, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidBetween(String value1, String value2) {
            addCriterion("MLMIID between", value1, value2, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andMlmiidNotBetween(String value1, String value2) {
            addCriterion("MLMIID not between", value1, value2, "mlmiid");
            return (Criteria) this;
        }

        public Criteria andPntypeIsNull() {
            addCriterion("PNTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPntypeIsNotNull() {
            addCriterion("PNTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPntypeEqualTo(String value) {
            addCriterion("PNTYPE =", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotEqualTo(String value) {
            addCriterion("PNTYPE <>", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeGreaterThan(String value) {
            addCriterion("PNTYPE >", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeGreaterThanOrEqualTo(String value) {
            addCriterion("PNTYPE >=", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeLessThan(String value) {
            addCriterion("PNTYPE <", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeLessThanOrEqualTo(String value) {
            addCriterion("PNTYPE <=", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeLike(String value) {
            addCriterion("PNTYPE like", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotLike(String value) {
            addCriterion("PNTYPE not like", value, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeIn(List<String> values) {
            addCriterion("PNTYPE in", values, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotIn(List<String> values) {
            addCriterion("PNTYPE not in", values, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeBetween(String value1, String value2) {
            addCriterion("PNTYPE between", value1, value2, "pntype");
            return (Criteria) this;
        }

        public Criteria andPntypeNotBetween(String value1, String value2) {
            addCriterion("PNTYPE not between", value1, value2, "pntype");
            return (Criteria) this;
        }

        public Criteria andPartnumberIsNull() {
            addCriterion("PARTNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPartnumberIsNotNull() {
            addCriterion("PARTNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPartnumberEqualTo(String value) {
            addCriterion("PARTNUMBER =", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberNotEqualTo(String value) {
            addCriterion("PARTNUMBER <>", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberGreaterThan(String value) {
            addCriterion("PARTNUMBER >", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberGreaterThanOrEqualTo(String value) {
            addCriterion("PARTNUMBER >=", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberLessThan(String value) {
            addCriterion("PARTNUMBER <", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberLessThanOrEqualTo(String value) {
            addCriterion("PARTNUMBER <=", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberLike(String value) {
            addCriterion("PARTNUMBER like", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberNotLike(String value) {
            addCriterion("PARTNUMBER not like", value, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberIn(List<String> values) {
            addCriterion("PARTNUMBER in", values, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberNotIn(List<String> values) {
            addCriterion("PARTNUMBER not in", values, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberBetween(String value1, String value2) {
            addCriterion("PARTNUMBER between", value1, value2, "partnumber");
            return (Criteria) this;
        }

        public Criteria andPartnumberNotBetween(String value1, String value2) {
            addCriterion("PARTNUMBER not between", value1, value2, "partnumber");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("LOCATION =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("LOCATION >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("LOCATION <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("LOCATION like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("LOCATION not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("LOCATION in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("LOCATION not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationtypeIsNull() {
            addCriterion("LOCATIONTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLocationtypeIsNotNull() {
            addCriterion("LOCATIONTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLocationtypeEqualTo(String value) {
            addCriterion("LOCATIONTYPE =", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeNotEqualTo(String value) {
            addCriterion("LOCATIONTYPE <>", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeGreaterThan(String value) {
            addCriterion("LOCATIONTYPE >", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATIONTYPE >=", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeLessThan(String value) {
            addCriterion("LOCATIONTYPE <", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeLessThanOrEqualTo(String value) {
            addCriterion("LOCATIONTYPE <=", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeLike(String value) {
            addCriterion("LOCATIONTYPE like", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeNotLike(String value) {
            addCriterion("LOCATIONTYPE not like", value, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeIn(List<String> values) {
            addCriterion("LOCATIONTYPE in", values, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeNotIn(List<String> values) {
            addCriterion("LOCATIONTYPE not in", values, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeBetween(String value1, String value2) {
            addCriterion("LOCATIONTYPE between", value1, value2, "locationtype");
            return (Criteria) this;
        }

        public Criteria andLocationtypeNotBetween(String value1, String value2) {
            addCriterion("LOCATIONTYPE not between", value1, value2, "locationtype");
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