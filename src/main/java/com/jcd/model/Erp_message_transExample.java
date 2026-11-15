package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Erp_message_transExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Erp_message_transExample() {
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

        public Criteria andTransactionsIsNull() {
            addCriterion("TRANSACTIONS is null");
            return (Criteria) this;
        }

        public Criteria andTransactionsIsNotNull() {
            addCriterion("TRANSACTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionsEqualTo(String value) {
            addCriterion("TRANSACTIONS =", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsNotEqualTo(String value) {
            addCriterion("TRANSACTIONS <>", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsGreaterThan(String value) {
            addCriterion("TRANSACTIONS >", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSACTIONS >=", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsLessThan(String value) {
            addCriterion("TRANSACTIONS <", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsLessThanOrEqualTo(String value) {
            addCriterion("TRANSACTIONS <=", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsLike(String value) {
            addCriterion("TRANSACTIONS like", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsNotLike(String value) {
            addCriterion("TRANSACTIONS not like", value, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsIn(List<String> values) {
            addCriterion("TRANSACTIONS in", values, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsNotIn(List<String> values) {
            addCriterion("TRANSACTIONS not in", values, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsBetween(String value1, String value2) {
            addCriterion("TRANSACTIONS between", value1, value2, "transactions");
            return (Criteria) this;
        }

        public Criteria andTransactionsNotBetween(String value1, String value2) {
            addCriterion("TRANSACTIONS not between", value1, value2, "transactions");
            return (Criteria) this;
        }

        public Criteria andLogtableIsNull() {
            addCriterion("LOGTABLE is null");
            return (Criteria) this;
        }

        public Criteria andLogtableIsNotNull() {
            addCriterion("LOGTABLE is not null");
            return (Criteria) this;
        }

        public Criteria andLogtableEqualTo(String value) {
            addCriterion("LOGTABLE =", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableNotEqualTo(String value) {
            addCriterion("LOGTABLE <>", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableGreaterThan(String value) {
            addCriterion("LOGTABLE >", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableGreaterThanOrEqualTo(String value) {
            addCriterion("LOGTABLE >=", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableLessThan(String value) {
            addCriterion("LOGTABLE <", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableLessThanOrEqualTo(String value) {
            addCriterion("LOGTABLE <=", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableLike(String value) {
            addCriterion("LOGTABLE like", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableNotLike(String value) {
            addCriterion("LOGTABLE not like", value, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableIn(List<String> values) {
            addCriterion("LOGTABLE in", values, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableNotIn(List<String> values) {
            addCriterion("LOGTABLE not in", values, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableBetween(String value1, String value2) {
            addCriterion("LOGTABLE between", value1, value2, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableNotBetween(String value1, String value2) {
            addCriterion("LOGTABLE not between", value1, value2, "logtable");
            return (Criteria) this;
        }

        public Criteria andLogtableidIsNull() {
            addCriterion("LOGTABLEID is null");
            return (Criteria) this;
        }

        public Criteria andLogtableidIsNotNull() {
            addCriterion("LOGTABLEID is not null");
            return (Criteria) this;
        }

        public Criteria andLogtableidEqualTo(String value) {
            addCriterion("LOGTABLEID =", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidNotEqualTo(String value) {
            addCriterion("LOGTABLEID <>", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidGreaterThan(String value) {
            addCriterion("LOGTABLEID >", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidGreaterThanOrEqualTo(String value) {
            addCriterion("LOGTABLEID >=", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidLessThan(String value) {
            addCriterion("LOGTABLEID <", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidLessThanOrEqualTo(String value) {
            addCriterion("LOGTABLEID <=", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidLike(String value) {
            addCriterion("LOGTABLEID like", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidNotLike(String value) {
            addCriterion("LOGTABLEID not like", value, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidIn(List<String> values) {
            addCriterion("LOGTABLEID in", values, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidNotIn(List<String> values) {
            addCriterion("LOGTABLEID not in", values, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidBetween(String value1, String value2) {
            addCriterion("LOGTABLEID between", value1, value2, "logtableid");
            return (Criteria) this;
        }

        public Criteria andLogtableidNotBetween(String value1, String value2) {
            addCriterion("LOGTABLEID not between", value1, value2, "logtableid");
            return (Criteria) this;
        }

        public Criteria andTransFlagIsNull() {
            addCriterion("TRANS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andTransFlagIsNotNull() {
            addCriterion("TRANS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTransFlagEqualTo(String value) {
            addCriterion("TRANS_FLAG =", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagNotEqualTo(String value) {
            addCriterion("TRANS_FLAG <>", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagGreaterThan(String value) {
            addCriterion("TRANS_FLAG >", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagGreaterThanOrEqualTo(String value) {
            addCriterion("TRANS_FLAG >=", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagLessThan(String value) {
            addCriterion("TRANS_FLAG <", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagLessThanOrEqualTo(String value) {
            addCriterion("TRANS_FLAG <=", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagLike(String value) {
            addCriterion("TRANS_FLAG like", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagNotLike(String value) {
            addCriterion("TRANS_FLAG not like", value, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagIn(List<String> values) {
            addCriterion("TRANS_FLAG in", values, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagNotIn(List<String> values) {
            addCriterion("TRANS_FLAG not in", values, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagBetween(String value1, String value2) {
            addCriterion("TRANS_FLAG between", value1, value2, "transFlag");
            return (Criteria) this;
        }

        public Criteria andTransFlagNotBetween(String value1, String value2) {
            addCriterion("TRANS_FLAG not between", value1, value2, "transFlag");
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