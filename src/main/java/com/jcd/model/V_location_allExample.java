package com.jcd.model;

import java.util.ArrayList;
import java.util.List;

public class V_location_allExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public V_location_allExample() {
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

        public Criteria andLocIdIsNull() {
            addCriterion("LOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andLocIdIsNotNull() {
            addCriterion("LOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLocIdEqualTo(String value) {
            addCriterion("LOC_ID =", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotEqualTo(String value) {
            addCriterion("LOC_ID <>", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdGreaterThan(String value) {
            addCriterion("LOC_ID >", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOC_ID >=", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLessThan(String value) {
            addCriterion("LOC_ID <", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLessThanOrEqualTo(String value) {
            addCriterion("LOC_ID <=", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLike(String value) {
            addCriterion("LOC_ID like", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotLike(String value) {
            addCriterion("LOC_ID not like", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdIn(List<String> values) {
            addCriterion("LOC_ID in", values, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotIn(List<String> values) {
            addCriterion("LOC_ID not in", values, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdBetween(String value1, String value2) {
            addCriterion("LOC_ID between", value1, value2, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotBetween(String value1, String value2) {
            addCriterion("LOC_ID not between", value1, value2, "locId");
            return (Criteria) this;
        }

        public Criteria andLocNameIsNull() {
            addCriterion("LOC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLocNameIsNotNull() {
            addCriterion("LOC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLocNameEqualTo(String value) {
            addCriterion("LOC_NAME =", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameNotEqualTo(String value) {
            addCriterion("LOC_NAME <>", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameGreaterThan(String value) {
            addCriterion("LOC_NAME >", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOC_NAME >=", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameLessThan(String value) {
            addCriterion("LOC_NAME <", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameLessThanOrEqualTo(String value) {
            addCriterion("LOC_NAME <=", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameLike(String value) {
            addCriterion("LOC_NAME like", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameNotLike(String value) {
            addCriterion("LOC_NAME not like", value, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameIn(List<String> values) {
            addCriterion("LOC_NAME in", values, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameNotIn(List<String> values) {
            addCriterion("LOC_NAME not in", values, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameBetween(String value1, String value2) {
            addCriterion("LOC_NAME between", value1, value2, "locName");
            return (Criteria) this;
        }

        public Criteria andLocNameNotBetween(String value1, String value2) {
            addCriterion("LOC_NAME not between", value1, value2, "locName");
            return (Criteria) this;
        }

        public Criteria andLocTypeIsNull() {
            addCriterion("LOC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLocTypeIsNotNull() {
            addCriterion("LOC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLocTypeEqualTo(String value) {
            addCriterion("LOC_TYPE =", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeNotEqualTo(String value) {
            addCriterion("LOC_TYPE <>", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeGreaterThan(String value) {
            addCriterion("LOC_TYPE >", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LOC_TYPE >=", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeLessThan(String value) {
            addCriterion("LOC_TYPE <", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeLessThanOrEqualTo(String value) {
            addCriterion("LOC_TYPE <=", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeLike(String value) {
            addCriterion("LOC_TYPE like", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeNotLike(String value) {
            addCriterion("LOC_TYPE not like", value, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeIn(List<String> values) {
            addCriterion("LOC_TYPE in", values, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeNotIn(List<String> values) {
            addCriterion("LOC_TYPE not in", values, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeBetween(String value1, String value2) {
            addCriterion("LOC_TYPE between", value1, value2, "locType");
            return (Criteria) this;
        }

        public Criteria andLocTypeNotBetween(String value1, String value2) {
            addCriterion("LOC_TYPE not between", value1, value2, "locType");
            return (Criteria) this;
        }

        public Criteria andLocStatusIsNull() {
            addCriterion("LOC_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLocStatusIsNotNull() {
            addCriterion("LOC_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLocStatusEqualTo(String value) {
            addCriterion("LOC_STATUS =", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusNotEqualTo(String value) {
            addCriterion("LOC_STATUS <>", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusGreaterThan(String value) {
            addCriterion("LOC_STATUS >", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusGreaterThanOrEqualTo(String value) {
            addCriterion("LOC_STATUS >=", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusLessThan(String value) {
            addCriterion("LOC_STATUS <", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusLessThanOrEqualTo(String value) {
            addCriterion("LOC_STATUS <=", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusLike(String value) {
            addCriterion("LOC_STATUS like", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusNotLike(String value) {
            addCriterion("LOC_STATUS not like", value, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusIn(List<String> values) {
            addCriterion("LOC_STATUS in", values, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusNotIn(List<String> values) {
            addCriterion("LOC_STATUS not in", values, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusBetween(String value1, String value2) {
            addCriterion("LOC_STATUS between", value1, value2, "locStatus");
            return (Criteria) this;
        }

        public Criteria andLocStatusNotBetween(String value1, String value2) {
            addCriterion("LOC_STATUS not between", value1, value2, "locStatus");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNull() {
            addCriterion("WAREHOUSE is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNotNull() {
            addCriterion("WAREHOUSE is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEqualTo(String value) {
            addCriterion("WAREHOUSE =", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotEqualTo(String value) {
            addCriterion("WAREHOUSE <>", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThan(String value) {
            addCriterion("WAREHOUSE >", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE >=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThan(String value) {
            addCriterion("WAREHOUSE <", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE <=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLike(String value) {
            addCriterion("WAREHOUSE like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotLike(String value) {
            addCriterion("WAREHOUSE not like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseIn(List<String> values) {
            addCriterion("WAREHOUSE in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotIn(List<String> values) {
            addCriterion("WAREHOUSE not in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseBetween(String value1, String value2) {
            addCriterion("WAREHOUSE between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE not between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWhareaIsNull() {
            addCriterion("WHAREA is null");
            return (Criteria) this;
        }

        public Criteria andWhareaIsNotNull() {
            addCriterion("WHAREA is not null");
            return (Criteria) this;
        }

        public Criteria andWhareaEqualTo(String value) {
            addCriterion("WHAREA =", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaNotEqualTo(String value) {
            addCriterion("WHAREA <>", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaGreaterThan(String value) {
            addCriterion("WHAREA >", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaGreaterThanOrEqualTo(String value) {
            addCriterion("WHAREA >=", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaLessThan(String value) {
            addCriterion("WHAREA <", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaLessThanOrEqualTo(String value) {
            addCriterion("WHAREA <=", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaLike(String value) {
            addCriterion("WHAREA like", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaNotLike(String value) {
            addCriterion("WHAREA not like", value, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaIn(List<String> values) {
            addCriterion("WHAREA in", values, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaNotIn(List<String> values) {
            addCriterion("WHAREA not in", values, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaBetween(String value1, String value2) {
            addCriterion("WHAREA between", value1, value2, "wharea");
            return (Criteria) this;
        }

        public Criteria andWhareaNotBetween(String value1, String value2) {
            addCriterion("WHAREA not between", value1, value2, "wharea");
            return (Criteria) this;
        }

        public Criteria andRackIsNull() {
            addCriterion("RACK is null");
            return (Criteria) this;
        }

        public Criteria andRackIsNotNull() {
            addCriterion("RACK is not null");
            return (Criteria) this;
        }

        public Criteria andRackEqualTo(String value) {
            addCriterion("RACK =", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackNotEqualTo(String value) {
            addCriterion("RACK <>", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackGreaterThan(String value) {
            addCriterion("RACK >", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackGreaterThanOrEqualTo(String value) {
            addCriterion("RACK >=", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackLessThan(String value) {
            addCriterion("RACK <", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackLessThanOrEqualTo(String value) {
            addCriterion("RACK <=", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackLike(String value) {
            addCriterion("RACK like", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackNotLike(String value) {
            addCriterion("RACK not like", value, "rack");
            return (Criteria) this;
        }

        public Criteria andRackIn(List<String> values) {
            addCriterion("RACK in", values, "rack");
            return (Criteria) this;
        }

        public Criteria andRackNotIn(List<String> values) {
            addCriterion("RACK not in", values, "rack");
            return (Criteria) this;
        }

        public Criteria andRackBetween(String value1, String value2) {
            addCriterion("RACK between", value1, value2, "rack");
            return (Criteria) this;
        }

        public Criteria andRackNotBetween(String value1, String value2) {
            addCriterion("RACK not between", value1, value2, "rack");
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