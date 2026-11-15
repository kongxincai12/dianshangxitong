package com.jcd.model;

import java.util.ArrayList;
import java.util.List;

public class LqcRecordDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LqcRecordDetailExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("RECORD_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("RECORD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(String value) {
            addCriterion("RECORD_ID =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(String value) {
            addCriterion("RECORD_ID <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(String value) {
            addCriterion("RECORD_ID >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_ID >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(String value) {
            addCriterion("RECORD_ID <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(String value) {
            addCriterion("RECORD_ID <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLike(String value) {
            addCriterion("RECORD_ID like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotLike(String value) {
            addCriterion("RECORD_ID not like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<String> values) {
            addCriterion("RECORD_ID in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<String> values) {
            addCriterion("RECORD_ID not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(String value1, String value2) {
            addCriterion("RECORD_ID between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(String value1, String value2) {
            addCriterion("RECORD_ID not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andDefectNameIsNull() {
            addCriterion("DEFECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDefectNameIsNotNull() {
            addCriterion("DEFECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDefectNameEqualTo(String value) {
            addCriterion("DEFECT_NAME =", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameNotEqualTo(String value) {
            addCriterion("DEFECT_NAME <>", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameGreaterThan(String value) {
            addCriterion("DEFECT_NAME >", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEFECT_NAME >=", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameLessThan(String value) {
            addCriterion("DEFECT_NAME <", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameLessThanOrEqualTo(String value) {
            addCriterion("DEFECT_NAME <=", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameLike(String value) {
            addCriterion("DEFECT_NAME like", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameNotLike(String value) {
            addCriterion("DEFECT_NAME not like", value, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameIn(List<String> values) {
            addCriterion("DEFECT_NAME in", values, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameNotIn(List<String> values) {
            addCriterion("DEFECT_NAME not in", values, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameBetween(String value1, String value2) {
            addCriterion("DEFECT_NAME between", value1, value2, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectNameNotBetween(String value1, String value2) {
            addCriterion("DEFECT_NAME not between", value1, value2, "defectName");
            return (Criteria) this;
        }

        public Criteria andDefectQtyIsNull() {
            addCriterion("DEFECT_QTY is null");
            return (Criteria) this;
        }

        public Criteria andDefectQtyIsNotNull() {
            addCriterion("DEFECT_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andDefectQtyEqualTo(Long value) {
            addCriterion("DEFECT_QTY =", value, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyNotEqualTo(Long value) {
            addCriterion("DEFECT_QTY <>", value, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyGreaterThan(Long value) {
            addCriterion("DEFECT_QTY >", value, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyGreaterThanOrEqualTo(Long value) {
            addCriterion("DEFECT_QTY >=", value, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyLessThan(Long value) {
            addCriterion("DEFECT_QTY <", value, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyLessThanOrEqualTo(Long value) {
            addCriterion("DEFECT_QTY <=", value, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyIn(List<Long> values) {
            addCriterion("DEFECT_QTY in", values, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyNotIn(List<Long> values) {
            addCriterion("DEFECT_QTY not in", values, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyBetween(Long value1, Long value2) {
            addCriterion("DEFECT_QTY between", value1, value2, "defectQty");
            return (Criteria) this;
        }

        public Criteria andDefectQtyNotBetween(Long value1, Long value2) {
            addCriterion("DEFECT_QTY not between", value1, value2, "defectQty");
            return (Criteria) this;
        }

        public Criteria andAttribute1IsNull() {
            addCriterion("ATTRIBUTE1 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute1IsNotNull() {
            addCriterion("ATTRIBUTE1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute1EqualTo(String value) {
            addCriterion("ATTRIBUTE1 =", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotEqualTo(String value) {
            addCriterion("ATTRIBUTE1 <>", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1GreaterThan(String value) {
            addCriterion("ATTRIBUTE1 >", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE1 >=", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1LessThan(String value) {
            addCriterion("ATTRIBUTE1 <", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE1 <=", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1Like(String value) {
            addCriterion("ATTRIBUTE1 like", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotLike(String value) {
            addCriterion("ATTRIBUTE1 not like", value, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1In(List<String> values) {
            addCriterion("ATTRIBUTE1 in", values, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotIn(List<String> values) {
            addCriterion("ATTRIBUTE1 not in", values, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1Between(String value1, String value2) {
            addCriterion("ATTRIBUTE1 between", value1, value2, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttribute1NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE1 not between", value1, value2, "attribute1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1IsNull() {
            addCriterion("ATTRIBUTE_NUM1 is null");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1IsNotNull() {
            addCriterion("ATTRIBUTE_NUM1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1EqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM1 =", value, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1NotEqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM1 <>", value, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1GreaterThan(Short value) {
            addCriterion("ATTRIBUTE_NUM1 >", value, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1GreaterThanOrEqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM1 >=", value, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1LessThan(Short value) {
            addCriterion("ATTRIBUTE_NUM1 <", value, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1LessThanOrEqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM1 <=", value, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1In(List<Short> values) {
            addCriterion("ATTRIBUTE_NUM1 in", values, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1NotIn(List<Short> values) {
            addCriterion("ATTRIBUTE_NUM1 not in", values, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1Between(Short value1, Short value2) {
            addCriterion("ATTRIBUTE_NUM1 between", value1, value2, "attributeNum1");
            return (Criteria) this;
        }

        public Criteria andAttributeNum1NotBetween(Short value1, Short value2) {
            addCriterion("ATTRIBUTE_NUM1 not between", value1, value2, "attributeNum1");
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