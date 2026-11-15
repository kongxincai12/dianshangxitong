package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StencilhisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StencilhisExample() {
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

        public Criteria andShidIsNull() {
            addCriterion("SHID is null");
            return (Criteria) this;
        }

        public Criteria andShidIsNotNull() {
            addCriterion("SHID is not null");
            return (Criteria) this;
        }

        public Criteria andShidEqualTo(String value) {
            addCriterion("SHID =", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotEqualTo(String value) {
            addCriterion("SHID <>", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThan(String value) {
            addCriterion("SHID >", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThanOrEqualTo(String value) {
            addCriterion("SHID >=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThan(String value) {
            addCriterion("SHID <", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThanOrEqualTo(String value) {
            addCriterion("SHID <=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLike(String value) {
            addCriterion("SHID like", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotLike(String value) {
            addCriterion("SHID not like", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidIn(List<String> values) {
            addCriterion("SHID in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotIn(List<String> values) {
            addCriterion("SHID not in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidBetween(String value1, String value2) {
            addCriterion("SHID between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotBetween(String value1, String value2) {
            addCriterion("SHID not between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andUsedidIsNull() {
            addCriterion("USEDID is null");
            return (Criteria) this;
        }

        public Criteria andUsedidIsNotNull() {
            addCriterion("USEDID is not null");
            return (Criteria) this;
        }

        public Criteria andUsedidEqualTo(String value) {
            addCriterion("USEDID =", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotEqualTo(String value) {
            addCriterion("USEDID <>", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidGreaterThan(String value) {
            addCriterion("USEDID >", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidGreaterThanOrEqualTo(String value) {
            addCriterion("USEDID >=", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidLessThan(String value) {
            addCriterion("USEDID <", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidLessThanOrEqualTo(String value) {
            addCriterion("USEDID <=", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidLike(String value) {
            addCriterion("USEDID like", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotLike(String value) {
            addCriterion("USEDID not like", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidIn(List<String> values) {
            addCriterion("USEDID in", values, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotIn(List<String> values) {
            addCriterion("USEDID not in", values, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidBetween(String value1, String value2) {
            addCriterion("USEDID between", value1, value2, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotBetween(String value1, String value2) {
            addCriterion("USEDID not between", value1, value2, "usedid");
            return (Criteria) this;
        }

        public Criteria andUpnnameIsNull() {
            addCriterion("UPNNAME is null");
            return (Criteria) this;
        }

        public Criteria andUpnnameIsNotNull() {
            addCriterion("UPNNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpnnameEqualTo(String value) {
            addCriterion("UPNNAME =", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameNotEqualTo(String value) {
            addCriterion("UPNNAME <>", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameGreaterThan(String value) {
            addCriterion("UPNNAME >", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameGreaterThanOrEqualTo(String value) {
            addCriterion("UPNNAME >=", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameLessThan(String value) {
            addCriterion("UPNNAME <", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameLessThanOrEqualTo(String value) {
            addCriterion("UPNNAME <=", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameLike(String value) {
            addCriterion("UPNNAME like", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameNotLike(String value) {
            addCriterion("UPNNAME not like", value, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameIn(List<String> values) {
            addCriterion("UPNNAME in", values, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameNotIn(List<String> values) {
            addCriterion("UPNNAME not in", values, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameBetween(String value1, String value2) {
            addCriterion("UPNNAME between", value1, value2, "upnname");
            return (Criteria) this;
        }

        public Criteria andUpnnameNotBetween(String value1, String value2) {
            addCriterion("UPNNAME not between", value1, value2, "upnname");
            return (Criteria) this;
        }

        public Criteria andLineIsNull() {
            addCriterion("LINE is null");
            return (Criteria) this;
        }

        public Criteria andLineIsNotNull() {
            addCriterion("LINE is not null");
            return (Criteria) this;
        }

        public Criteria andLineEqualTo(String value) {
            addCriterion("LINE =", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotEqualTo(String value) {
            addCriterion("LINE <>", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThan(String value) {
            addCriterion("LINE >", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThanOrEqualTo(String value) {
            addCriterion("LINE >=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThan(String value) {
            addCriterion("LINE <", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThanOrEqualTo(String value) {
            addCriterion("LINE <=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLike(String value) {
            addCriterion("LINE like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotLike(String value) {
            addCriterion("LINE not like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineIn(List<String> values) {
            addCriterion("LINE in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotIn(List<String> values) {
            addCriterion("LINE not in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineBetween(String value1, String value2) {
            addCriterion("LINE between", value1, value2, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotBetween(String value1, String value2) {
            addCriterion("LINE not between", value1, value2, "line");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNull() {
            addCriterion("TASKNAME is null");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNotNull() {
            addCriterion("TASKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTasknameEqualTo(String value) {
            addCriterion("TASKNAME =", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotEqualTo(String value) {
            addCriterion("TASKNAME <>", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThan(String value) {
            addCriterion("TASKNAME >", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThanOrEqualTo(String value) {
            addCriterion("TASKNAME >=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThan(String value) {
            addCriterion("TASKNAME <", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThanOrEqualTo(String value) {
            addCriterion("TASKNAME <=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLike(String value) {
            addCriterion("TASKNAME like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotLike(String value) {
            addCriterion("TASKNAME not like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameIn(List<String> values) {
            addCriterion("TASKNAME in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotIn(List<String> values) {
            addCriterion("TASKNAME not in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameBetween(String value1, String value2) {
            addCriterion("TASKNAME between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotBetween(String value1, String value2) {
            addCriterion("TASKNAME not between", value1, value2, "taskname");
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

        public Criteria andQtyIsNull() {
            addCriterion("QTY is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("QTY is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(Short value) {
            addCriterion("QTY =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Short value) {
            addCriterion("QTY <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Short value) {
            addCriterion("QTY >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Short value) {
            addCriterion("QTY >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Short value) {
            addCriterion("QTY <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Short value) {
            addCriterion("QTY <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Short> values) {
            addCriterion("QTY in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Short> values) {
            addCriterion("QTY not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Short value1, Short value2) {
            addCriterion("QTY between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Short value1, Short value2) {
            addCriterion("QTY not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andObj01IsNull() {
            addCriterion("OBJ01 is null");
            return (Criteria) this;
        }

        public Criteria andObj01IsNotNull() {
            addCriterion("OBJ01 is not null");
            return (Criteria) this;
        }

        public Criteria andObj01EqualTo(String value) {
            addCriterion("OBJ01 =", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotEqualTo(String value) {
            addCriterion("OBJ01 <>", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01GreaterThan(String value) {
            addCriterion("OBJ01 >", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ01 >=", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01LessThan(String value) {
            addCriterion("OBJ01 <", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01LessThanOrEqualTo(String value) {
            addCriterion("OBJ01 <=", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01Like(String value) {
            addCriterion("OBJ01 like", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotLike(String value) {
            addCriterion("OBJ01 not like", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01In(List<String> values) {
            addCriterion("OBJ01 in", values, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotIn(List<String> values) {
            addCriterion("OBJ01 not in", values, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01Between(String value1, String value2) {
            addCriterion("OBJ01 between", value1, value2, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotBetween(String value1, String value2) {
            addCriterion("OBJ01 not between", value1, value2, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj02IsNull() {
            addCriterion("OBJ02 is null");
            return (Criteria) this;
        }

        public Criteria andObj02IsNotNull() {
            addCriterion("OBJ02 is not null");
            return (Criteria) this;
        }

        public Criteria andObj02EqualTo(String value) {
            addCriterion("OBJ02 =", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotEqualTo(String value) {
            addCriterion("OBJ02 <>", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02GreaterThan(String value) {
            addCriterion("OBJ02 >", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ02 >=", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02LessThan(String value) {
            addCriterion("OBJ02 <", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02LessThanOrEqualTo(String value) {
            addCriterion("OBJ02 <=", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02Like(String value) {
            addCriterion("OBJ02 like", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotLike(String value) {
            addCriterion("OBJ02 not like", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02In(List<String> values) {
            addCriterion("OBJ02 in", values, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotIn(List<String> values) {
            addCriterion("OBJ02 not in", values, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02Between(String value1, String value2) {
            addCriterion("OBJ02 between", value1, value2, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotBetween(String value1, String value2) {
            addCriterion("OBJ02 not between", value1, value2, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj03IsNull() {
            addCriterion("OBJ03 is null");
            return (Criteria) this;
        }

        public Criteria andObj03IsNotNull() {
            addCriterion("OBJ03 is not null");
            return (Criteria) this;
        }

        public Criteria andObj03EqualTo(String value) {
            addCriterion("OBJ03 =", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotEqualTo(String value) {
            addCriterion("OBJ03 <>", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03GreaterThan(String value) {
            addCriterion("OBJ03 >", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ03 >=", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03LessThan(String value) {
            addCriterion("OBJ03 <", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03LessThanOrEqualTo(String value) {
            addCriterion("OBJ03 <=", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03Like(String value) {
            addCriterion("OBJ03 like", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotLike(String value) {
            addCriterion("OBJ03 not like", value, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03In(List<String> values) {
            addCriterion("OBJ03 in", values, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotIn(List<String> values) {
            addCriterion("OBJ03 not in", values, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03Between(String value1, String value2) {
            addCriterion("OBJ03 between", value1, value2, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj03NotBetween(String value1, String value2) {
            addCriterion("OBJ03 not between", value1, value2, "obj03");
            return (Criteria) this;
        }

        public Criteria andObj04IsNull() {
            addCriterion("OBJ04 is null");
            return (Criteria) this;
        }

        public Criteria andObj04IsNotNull() {
            addCriterion("OBJ04 is not null");
            return (Criteria) this;
        }

        public Criteria andObj04EqualTo(String value) {
            addCriterion("OBJ04 =", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotEqualTo(String value) {
            addCriterion("OBJ04 <>", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04GreaterThan(String value) {
            addCriterion("OBJ04 >", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ04 >=", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04LessThan(String value) {
            addCriterion("OBJ04 <", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04LessThanOrEqualTo(String value) {
            addCriterion("OBJ04 <=", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04Like(String value) {
            addCriterion("OBJ04 like", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotLike(String value) {
            addCriterion("OBJ04 not like", value, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04In(List<String> values) {
            addCriterion("OBJ04 in", values, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotIn(List<String> values) {
            addCriterion("OBJ04 not in", values, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04Between(String value1, String value2) {
            addCriterion("OBJ04 between", value1, value2, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj04NotBetween(String value1, String value2) {
            addCriterion("OBJ04 not between", value1, value2, "obj04");
            return (Criteria) this;
        }

        public Criteria andObj05IsNull() {
            addCriterion("OBJ05 is null");
            return (Criteria) this;
        }

        public Criteria andObj05IsNotNull() {
            addCriterion("OBJ05 is not null");
            return (Criteria) this;
        }

        public Criteria andObj05EqualTo(String value) {
            addCriterion("OBJ05 =", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotEqualTo(String value) {
            addCriterion("OBJ05 <>", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05GreaterThan(String value) {
            addCriterion("OBJ05 >", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ05 >=", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05LessThan(String value) {
            addCriterion("OBJ05 <", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05LessThanOrEqualTo(String value) {
            addCriterion("OBJ05 <=", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05Like(String value) {
            addCriterion("OBJ05 like", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotLike(String value) {
            addCriterion("OBJ05 not like", value, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05In(List<String> values) {
            addCriterion("OBJ05 in", values, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotIn(List<String> values) {
            addCriterion("OBJ05 not in", values, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05Between(String value1, String value2) {
            addCriterion("OBJ05 between", value1, value2, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj05NotBetween(String value1, String value2) {
            addCriterion("OBJ05 not between", value1, value2, "obj05");
            return (Criteria) this;
        }

        public Criteria andObj06IsNull() {
            addCriterion("OBJ06 is null");
            return (Criteria) this;
        }

        public Criteria andObj06IsNotNull() {
            addCriterion("OBJ06 is not null");
            return (Criteria) this;
        }

        public Criteria andObj06EqualTo(String value) {
            addCriterion("OBJ06 =", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotEqualTo(String value) {
            addCriterion("OBJ06 <>", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06GreaterThan(String value) {
            addCriterion("OBJ06 >", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ06 >=", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06LessThan(String value) {
            addCriterion("OBJ06 <", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06LessThanOrEqualTo(String value) {
            addCriterion("OBJ06 <=", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06Like(String value) {
            addCriterion("OBJ06 like", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotLike(String value) {
            addCriterion("OBJ06 not like", value, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06In(List<String> values) {
            addCriterion("OBJ06 in", values, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotIn(List<String> values) {
            addCriterion("OBJ06 not in", values, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06Between(String value1, String value2) {
            addCriterion("OBJ06 between", value1, value2, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj06NotBetween(String value1, String value2) {
            addCriterion("OBJ06 not between", value1, value2, "obj06");
            return (Criteria) this;
        }

        public Criteria andObj07IsNull() {
            addCriterion("OBJ07 is null");
            return (Criteria) this;
        }

        public Criteria andObj07IsNotNull() {
            addCriterion("OBJ07 is not null");
            return (Criteria) this;
        }

        public Criteria andObj07EqualTo(String value) {
            addCriterion("OBJ07 =", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotEqualTo(String value) {
            addCriterion("OBJ07 <>", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07GreaterThan(String value) {
            addCriterion("OBJ07 >", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ07 >=", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07LessThan(String value) {
            addCriterion("OBJ07 <", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07LessThanOrEqualTo(String value) {
            addCriterion("OBJ07 <=", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07Like(String value) {
            addCriterion("OBJ07 like", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotLike(String value) {
            addCriterion("OBJ07 not like", value, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07In(List<String> values) {
            addCriterion("OBJ07 in", values, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotIn(List<String> values) {
            addCriterion("OBJ07 not in", values, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07Between(String value1, String value2) {
            addCriterion("OBJ07 between", value1, value2, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj07NotBetween(String value1, String value2) {
            addCriterion("OBJ07 not between", value1, value2, "obj07");
            return (Criteria) this;
        }

        public Criteria andObj08IsNull() {
            addCriterion("OBJ08 is null");
            return (Criteria) this;
        }

        public Criteria andObj08IsNotNull() {
            addCriterion("OBJ08 is not null");
            return (Criteria) this;
        }

        public Criteria andObj08EqualTo(String value) {
            addCriterion("OBJ08 =", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotEqualTo(String value) {
            addCriterion("OBJ08 <>", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08GreaterThan(String value) {
            addCriterion("OBJ08 >", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ08 >=", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08LessThan(String value) {
            addCriterion("OBJ08 <", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08LessThanOrEqualTo(String value) {
            addCriterion("OBJ08 <=", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08Like(String value) {
            addCriterion("OBJ08 like", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotLike(String value) {
            addCriterion("OBJ08 not like", value, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08In(List<String> values) {
            addCriterion("OBJ08 in", values, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotIn(List<String> values) {
            addCriterion("OBJ08 not in", values, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08Between(String value1, String value2) {
            addCriterion("OBJ08 between", value1, value2, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj08NotBetween(String value1, String value2) {
            addCriterion("OBJ08 not between", value1, value2, "obj08");
            return (Criteria) this;
        }

        public Criteria andObj09IsNull() {
            addCriterion("OBJ09 is null");
            return (Criteria) this;
        }

        public Criteria andObj09IsNotNull() {
            addCriterion("OBJ09 is not null");
            return (Criteria) this;
        }

        public Criteria andObj09EqualTo(String value) {
            addCriterion("OBJ09 =", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotEqualTo(String value) {
            addCriterion("OBJ09 <>", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09GreaterThan(String value) {
            addCriterion("OBJ09 >", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ09 >=", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09LessThan(String value) {
            addCriterion("OBJ09 <", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09LessThanOrEqualTo(String value) {
            addCriterion("OBJ09 <=", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09Like(String value) {
            addCriterion("OBJ09 like", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotLike(String value) {
            addCriterion("OBJ09 not like", value, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09In(List<String> values) {
            addCriterion("OBJ09 in", values, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotIn(List<String> values) {
            addCriterion("OBJ09 not in", values, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09Between(String value1, String value2) {
            addCriterion("OBJ09 between", value1, value2, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj09NotBetween(String value1, String value2) {
            addCriterion("OBJ09 not between", value1, value2, "obj09");
            return (Criteria) this;
        }

        public Criteria andObj10IsNull() {
            addCriterion("OBJ10 is null");
            return (Criteria) this;
        }

        public Criteria andObj10IsNotNull() {
            addCriterion("OBJ10 is not null");
            return (Criteria) this;
        }

        public Criteria andObj10EqualTo(String value) {
            addCriterion("OBJ10 =", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotEqualTo(String value) {
            addCriterion("OBJ10 <>", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10GreaterThan(String value) {
            addCriterion("OBJ10 >", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ10 >=", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10LessThan(String value) {
            addCriterion("OBJ10 <", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10LessThanOrEqualTo(String value) {
            addCriterion("OBJ10 <=", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10Like(String value) {
            addCriterion("OBJ10 like", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotLike(String value) {
            addCriterion("OBJ10 not like", value, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10In(List<String> values) {
            addCriterion("OBJ10 in", values, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotIn(List<String> values) {
            addCriterion("OBJ10 not in", values, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10Between(String value1, String value2) {
            addCriterion("OBJ10 between", value1, value2, "obj10");
            return (Criteria) this;
        }

        public Criteria andObj10NotBetween(String value1, String value2) {
            addCriterion("OBJ10 not between", value1, value2, "obj10");
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