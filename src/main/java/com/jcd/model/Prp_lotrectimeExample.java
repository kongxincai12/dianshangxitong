package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prp_lotrectimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Prp_lotrectimeExample() {
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

        public Criteria andLotidIsNull() {
            addCriterion("LOTID is null");
            return (Criteria) this;
        }

        public Criteria andLotidIsNotNull() {
            addCriterion("LOTID is not null");
            return (Criteria) this;
        }

        public Criteria andLotidEqualTo(String value) {
            addCriterion("LOTID =", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotEqualTo(String value) {
            addCriterion("LOTID <>", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidGreaterThan(String value) {
            addCriterion("LOTID >", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidGreaterThanOrEqualTo(String value) {
            addCriterion("LOTID >=", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidLessThan(String value) {
            addCriterion("LOTID <", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidLessThanOrEqualTo(String value) {
            addCriterion("LOTID <=", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidLike(String value) {
            addCriterion("LOTID like", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotLike(String value) {
            addCriterion("LOTID not like", value, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidIn(List<String> values) {
            addCriterion("LOTID in", values, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotIn(List<String> values) {
            addCriterion("LOTID not in", values, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidBetween(String value1, String value2) {
            addCriterion("LOTID between", value1, value2, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotidNotBetween(String value1, String value2) {
            addCriterion("LOTID not between", value1, value2, "lotid");
            return (Criteria) this;
        }

        public Criteria andLotnameIsNull() {
            addCriterion("LOTNAME is null");
            return (Criteria) this;
        }

        public Criteria andLotnameIsNotNull() {
            addCriterion("LOTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andLotnameEqualTo(String value) {
            addCriterion("LOTNAME =", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameNotEqualTo(String value) {
            addCriterion("LOTNAME <>", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameGreaterThan(String value) {
            addCriterion("LOTNAME >", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameGreaterThanOrEqualTo(String value) {
            addCriterion("LOTNAME >=", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameLessThan(String value) {
            addCriterion("LOTNAME <", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameLessThanOrEqualTo(String value) {
            addCriterion("LOTNAME <=", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameLike(String value) {
            addCriterion("LOTNAME like", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameNotLike(String value) {
            addCriterion("LOTNAME not like", value, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameIn(List<String> values) {
            addCriterion("LOTNAME in", values, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameNotIn(List<String> values) {
            addCriterion("LOTNAME not in", values, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameBetween(String value1, String value2) {
            addCriterion("LOTNAME between", value1, value2, "lotname");
            return (Criteria) this;
        }

        public Criteria andLotnameNotBetween(String value1, String value2) {
            addCriterion("LOTNAME not between", value1, value2, "lotname");
            return (Criteria) this;
        }

        public Criteria andProductpnIsNull() {
            addCriterion("PRODUCTPN is null");
            return (Criteria) this;
        }

        public Criteria andProductpnIsNotNull() {
            addCriterion("PRODUCTPN is not null");
            return (Criteria) this;
        }

        public Criteria andProductpnEqualTo(String value) {
            addCriterion("PRODUCTPN =", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotEqualTo(String value) {
            addCriterion("PRODUCTPN <>", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnGreaterThan(String value) {
            addCriterion("PRODUCTPN >", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTPN >=", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnLessThan(String value) {
            addCriterion("PRODUCTPN <", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTPN <=", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnLike(String value) {
            addCriterion("PRODUCTPN like", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotLike(String value) {
            addCriterion("PRODUCTPN not like", value, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnIn(List<String> values) {
            addCriterion("PRODUCTPN in", values, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotIn(List<String> values) {
            addCriterion("PRODUCTPN not in", values, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnBetween(String value1, String value2) {
            addCriterion("PRODUCTPN between", value1, value2, "productpn");
            return (Criteria) this;
        }

        public Criteria andProductpnNotBetween(String value1, String value2) {
            addCriterion("PRODUCTPN not between", value1, value2, "productpn");
            return (Criteria) this;
        }

        public Criteria andStepidIsNull() {
            addCriterion("STEPID is null");
            return (Criteria) this;
        }

        public Criteria andStepidIsNotNull() {
            addCriterion("STEPID is not null");
            return (Criteria) this;
        }

        public Criteria andStepidEqualTo(String value) {
            addCriterion("STEPID =", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotEqualTo(String value) {
            addCriterion("STEPID <>", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidGreaterThan(String value) {
            addCriterion("STEPID >", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidGreaterThanOrEqualTo(String value) {
            addCriterion("STEPID >=", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLessThan(String value) {
            addCriterion("STEPID <", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLessThanOrEqualTo(String value) {
            addCriterion("STEPID <=", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidLike(String value) {
            addCriterion("STEPID like", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotLike(String value) {
            addCriterion("STEPID not like", value, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidIn(List<String> values) {
            addCriterion("STEPID in", values, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotIn(List<String> values) {
            addCriterion("STEPID not in", values, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidBetween(String value1, String value2) {
            addCriterion("STEPID between", value1, value2, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepidNotBetween(String value1, String value2) {
            addCriterion("STEPID not between", value1, value2, "stepid");
            return (Criteria) this;
        }

        public Criteria andStepnameIsNull() {
            addCriterion("STEPNAME is null");
            return (Criteria) this;
        }

        public Criteria andStepnameIsNotNull() {
            addCriterion("STEPNAME is not null");
            return (Criteria) this;
        }

        public Criteria andStepnameEqualTo(String value) {
            addCriterion("STEPNAME =", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameNotEqualTo(String value) {
            addCriterion("STEPNAME <>", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameGreaterThan(String value) {
            addCriterion("STEPNAME >", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameGreaterThanOrEqualTo(String value) {
            addCriterion("STEPNAME >=", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameLessThan(String value) {
            addCriterion("STEPNAME <", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameLessThanOrEqualTo(String value) {
            addCriterion("STEPNAME <=", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameLike(String value) {
            addCriterion("STEPNAME like", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameNotLike(String value) {
            addCriterion("STEPNAME not like", value, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameIn(List<String> values) {
            addCriterion("STEPNAME in", values, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameNotIn(List<String> values) {
            addCriterion("STEPNAME not in", values, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameBetween(String value1, String value2) {
            addCriterion("STEPNAME between", value1, value2, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepnameNotBetween(String value1, String value2) {
            addCriterion("STEPNAME not between", value1, value2, "stepname");
            return (Criteria) this;
        }

        public Criteria andStepintimeIsNull() {
            addCriterion("STEPINTIME is null");
            return (Criteria) this;
        }

        public Criteria andStepintimeIsNotNull() {
            addCriterion("STEPINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStepintimeEqualTo(Date value) {
            addCriterion("STEPINTIME =", value, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeNotEqualTo(Date value) {
            addCriterion("STEPINTIME <>", value, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeGreaterThan(Date value) {
            addCriterion("STEPINTIME >", value, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STEPINTIME >=", value, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeLessThan(Date value) {
            addCriterion("STEPINTIME <", value, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeLessThanOrEqualTo(Date value) {
            addCriterion("STEPINTIME <=", value, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeIn(List<Date> values) {
            addCriterion("STEPINTIME in", values, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeNotIn(List<Date> values) {
            addCriterion("STEPINTIME not in", values, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeBetween(Date value1, Date value2) {
            addCriterion("STEPINTIME between", value1, value2, "stepintime");
            return (Criteria) this;
        }

        public Criteria andStepintimeNotBetween(Date value1, Date value2) {
            addCriterion("STEPINTIME not between", value1, value2, "stepintime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeIsNull() {
            addCriterion("STEPPASSTIME is null");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeIsNotNull() {
            addCriterion("STEPPASSTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeEqualTo(Date value) {
            addCriterion("STEPPASSTIME =", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeNotEqualTo(Date value) {
            addCriterion("STEPPASSTIME <>", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeGreaterThan(Date value) {
            addCriterion("STEPPASSTIME >", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STEPPASSTIME >=", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeLessThan(Date value) {
            addCriterion("STEPPASSTIME <", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeLessThanOrEqualTo(Date value) {
            addCriterion("STEPPASSTIME <=", value, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeIn(List<Date> values) {
            addCriterion("STEPPASSTIME in", values, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeNotIn(List<Date> values) {
            addCriterion("STEPPASSTIME not in", values, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeBetween(Date value1, Date value2) {
            addCriterion("STEPPASSTIME between", value1, value2, "steppasstime");
            return (Criteria) this;
        }

        public Criteria andSteppasstimeNotBetween(Date value1, Date value2) {
            addCriterion("STEPPASSTIME not between", value1, value2, "steppasstime");
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

        public Criteria andObj1IsNull() {
            addCriterion("OBJ1 is null");
            return (Criteria) this;
        }

        public Criteria andObj1IsNotNull() {
            addCriterion("OBJ1 is not null");
            return (Criteria) this;
        }

        public Criteria andObj1EqualTo(String value) {
            addCriterion("OBJ1 =", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1NotEqualTo(String value) {
            addCriterion("OBJ1 <>", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1GreaterThan(String value) {
            addCriterion("OBJ1 >", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ1 >=", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1LessThan(String value) {
            addCriterion("OBJ1 <", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1LessThanOrEqualTo(String value) {
            addCriterion("OBJ1 <=", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1Like(String value) {
            addCriterion("OBJ1 like", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1NotLike(String value) {
            addCriterion("OBJ1 not like", value, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1In(List<String> values) {
            addCriterion("OBJ1 in", values, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1NotIn(List<String> values) {
            addCriterion("OBJ1 not in", values, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1Between(String value1, String value2) {
            addCriterion("OBJ1 between", value1, value2, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj1NotBetween(String value1, String value2) {
            addCriterion("OBJ1 not between", value1, value2, "obj1");
            return (Criteria) this;
        }

        public Criteria andObj2IsNull() {
            addCriterion("OBJ2 is null");
            return (Criteria) this;
        }

        public Criteria andObj2IsNotNull() {
            addCriterion("OBJ2 is not null");
            return (Criteria) this;
        }

        public Criteria andObj2EqualTo(String value) {
            addCriterion("OBJ2 =", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2NotEqualTo(String value) {
            addCriterion("OBJ2 <>", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2GreaterThan(String value) {
            addCriterion("OBJ2 >", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ2 >=", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2LessThan(String value) {
            addCriterion("OBJ2 <", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2LessThanOrEqualTo(String value) {
            addCriterion("OBJ2 <=", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2Like(String value) {
            addCriterion("OBJ2 like", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2NotLike(String value) {
            addCriterion("OBJ2 not like", value, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2In(List<String> values) {
            addCriterion("OBJ2 in", values, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2NotIn(List<String> values) {
            addCriterion("OBJ2 not in", values, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2Between(String value1, String value2) {
            addCriterion("OBJ2 between", value1, value2, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj2NotBetween(String value1, String value2) {
            addCriterion("OBJ2 not between", value1, value2, "obj2");
            return (Criteria) this;
        }

        public Criteria andObj3IsNull() {
            addCriterion("OBJ3 is null");
            return (Criteria) this;
        }

        public Criteria andObj3IsNotNull() {
            addCriterion("OBJ3 is not null");
            return (Criteria) this;
        }

        public Criteria andObj3EqualTo(String value) {
            addCriterion("OBJ3 =", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3NotEqualTo(String value) {
            addCriterion("OBJ3 <>", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3GreaterThan(String value) {
            addCriterion("OBJ3 >", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ3 >=", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3LessThan(String value) {
            addCriterion("OBJ3 <", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3LessThanOrEqualTo(String value) {
            addCriterion("OBJ3 <=", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3Like(String value) {
            addCriterion("OBJ3 like", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3NotLike(String value) {
            addCriterion("OBJ3 not like", value, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3In(List<String> values) {
            addCriterion("OBJ3 in", values, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3NotIn(List<String> values) {
            addCriterion("OBJ3 not in", values, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3Between(String value1, String value2) {
            addCriterion("OBJ3 between", value1, value2, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj3NotBetween(String value1, String value2) {
            addCriterion("OBJ3 not between", value1, value2, "obj3");
            return (Criteria) this;
        }

        public Criteria andObj4IsNull() {
            addCriterion("OBJ4 is null");
            return (Criteria) this;
        }

        public Criteria andObj4IsNotNull() {
            addCriterion("OBJ4 is not null");
            return (Criteria) this;
        }

        public Criteria andObj4EqualTo(String value) {
            addCriterion("OBJ4 =", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4NotEqualTo(String value) {
            addCriterion("OBJ4 <>", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4GreaterThan(String value) {
            addCriterion("OBJ4 >", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ4 >=", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4LessThan(String value) {
            addCriterion("OBJ4 <", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4LessThanOrEqualTo(String value) {
            addCriterion("OBJ4 <=", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4Like(String value) {
            addCriterion("OBJ4 like", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4NotLike(String value) {
            addCriterion("OBJ4 not like", value, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4In(List<String> values) {
            addCriterion("OBJ4 in", values, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4NotIn(List<String> values) {
            addCriterion("OBJ4 not in", values, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4Between(String value1, String value2) {
            addCriterion("OBJ4 between", value1, value2, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj4NotBetween(String value1, String value2) {
            addCriterion("OBJ4 not between", value1, value2, "obj4");
            return (Criteria) this;
        }

        public Criteria andObj5IsNull() {
            addCriterion("OBJ5 is null");
            return (Criteria) this;
        }

        public Criteria andObj5IsNotNull() {
            addCriterion("OBJ5 is not null");
            return (Criteria) this;
        }

        public Criteria andObj5EqualTo(String value) {
            addCriterion("OBJ5 =", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5NotEqualTo(String value) {
            addCriterion("OBJ5 <>", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5GreaterThan(String value) {
            addCriterion("OBJ5 >", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ5 >=", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5LessThan(String value) {
            addCriterion("OBJ5 <", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5LessThanOrEqualTo(String value) {
            addCriterion("OBJ5 <=", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5Like(String value) {
            addCriterion("OBJ5 like", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5NotLike(String value) {
            addCriterion("OBJ5 not like", value, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5In(List<String> values) {
            addCriterion("OBJ5 in", values, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5NotIn(List<String> values) {
            addCriterion("OBJ5 not in", values, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5Between(String value1, String value2) {
            addCriterion("OBJ5 between", value1, value2, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj5NotBetween(String value1, String value2) {
            addCriterion("OBJ5 not between", value1, value2, "obj5");
            return (Criteria) this;
        }

        public Criteria andObj6IsNull() {
            addCriterion("OBJ6 is null");
            return (Criteria) this;
        }

        public Criteria andObj6IsNotNull() {
            addCriterion("OBJ6 is not null");
            return (Criteria) this;
        }

        public Criteria andObj6EqualTo(String value) {
            addCriterion("OBJ6 =", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6NotEqualTo(String value) {
            addCriterion("OBJ6 <>", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6GreaterThan(String value) {
            addCriterion("OBJ6 >", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ6 >=", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6LessThan(String value) {
            addCriterion("OBJ6 <", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6LessThanOrEqualTo(String value) {
            addCriterion("OBJ6 <=", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6Like(String value) {
            addCriterion("OBJ6 like", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6NotLike(String value) {
            addCriterion("OBJ6 not like", value, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6In(List<String> values) {
            addCriterion("OBJ6 in", values, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6NotIn(List<String> values) {
            addCriterion("OBJ6 not in", values, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6Between(String value1, String value2) {
            addCriterion("OBJ6 between", value1, value2, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj6NotBetween(String value1, String value2) {
            addCriterion("OBJ6 not between", value1, value2, "obj6");
            return (Criteria) this;
        }

        public Criteria andObj7IsNull() {
            addCriterion("OBJ7 is null");
            return (Criteria) this;
        }

        public Criteria andObj7IsNotNull() {
            addCriterion("OBJ7 is not null");
            return (Criteria) this;
        }

        public Criteria andObj7EqualTo(String value) {
            addCriterion("OBJ7 =", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7NotEqualTo(String value) {
            addCriterion("OBJ7 <>", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7GreaterThan(String value) {
            addCriterion("OBJ7 >", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ7 >=", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7LessThan(String value) {
            addCriterion("OBJ7 <", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7LessThanOrEqualTo(String value) {
            addCriterion("OBJ7 <=", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7Like(String value) {
            addCriterion("OBJ7 like", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7NotLike(String value) {
            addCriterion("OBJ7 not like", value, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7In(List<String> values) {
            addCriterion("OBJ7 in", values, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7NotIn(List<String> values) {
            addCriterion("OBJ7 not in", values, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7Between(String value1, String value2) {
            addCriterion("OBJ7 between", value1, value2, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj7NotBetween(String value1, String value2) {
            addCriterion("OBJ7 not between", value1, value2, "obj7");
            return (Criteria) this;
        }

        public Criteria andObj8IsNull() {
            addCriterion("OBJ8 is null");
            return (Criteria) this;
        }

        public Criteria andObj8IsNotNull() {
            addCriterion("OBJ8 is not null");
            return (Criteria) this;
        }

        public Criteria andObj8EqualTo(String value) {
            addCriterion("OBJ8 =", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8NotEqualTo(String value) {
            addCriterion("OBJ8 <>", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8GreaterThan(String value) {
            addCriterion("OBJ8 >", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ8 >=", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8LessThan(String value) {
            addCriterion("OBJ8 <", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8LessThanOrEqualTo(String value) {
            addCriterion("OBJ8 <=", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8Like(String value) {
            addCriterion("OBJ8 like", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8NotLike(String value) {
            addCriterion("OBJ8 not like", value, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8In(List<String> values) {
            addCriterion("OBJ8 in", values, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8NotIn(List<String> values) {
            addCriterion("OBJ8 not in", values, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8Between(String value1, String value2) {
            addCriterion("OBJ8 between", value1, value2, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj8NotBetween(String value1, String value2) {
            addCriterion("OBJ8 not between", value1, value2, "obj8");
            return (Criteria) this;
        }

        public Criteria andObj9IsNull() {
            addCriterion("OBJ9 is null");
            return (Criteria) this;
        }

        public Criteria andObj9IsNotNull() {
            addCriterion("OBJ9 is not null");
            return (Criteria) this;
        }

        public Criteria andObj9EqualTo(String value) {
            addCriterion("OBJ9 =", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9NotEqualTo(String value) {
            addCriterion("OBJ9 <>", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9GreaterThan(String value) {
            addCriterion("OBJ9 >", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ9 >=", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9LessThan(String value) {
            addCriterion("OBJ9 <", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9LessThanOrEqualTo(String value) {
            addCriterion("OBJ9 <=", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9Like(String value) {
            addCriterion("OBJ9 like", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9NotLike(String value) {
            addCriterion("OBJ9 not like", value, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9In(List<String> values) {
            addCriterion("OBJ9 in", values, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9NotIn(List<String> values) {
            addCriterion("OBJ9 not in", values, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9Between(String value1, String value2) {
            addCriterion("OBJ9 between", value1, value2, "obj9");
            return (Criteria) this;
        }

        public Criteria andObj9NotBetween(String value1, String value2) {
            addCriterion("OBJ9 not between", value1, value2, "obj9");
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

        public Criteria andObj11IsNull() {
            addCriterion("OBJ11 is null");
            return (Criteria) this;
        }

        public Criteria andObj11IsNotNull() {
            addCriterion("OBJ11 is not null");
            return (Criteria) this;
        }

        public Criteria andObj11EqualTo(String value) {
            addCriterion("OBJ11 =", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotEqualTo(String value) {
            addCriterion("OBJ11 <>", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11GreaterThan(String value) {
            addCriterion("OBJ11 >", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ11 >=", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11LessThan(String value) {
            addCriterion("OBJ11 <", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11LessThanOrEqualTo(String value) {
            addCriterion("OBJ11 <=", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11Like(String value) {
            addCriterion("OBJ11 like", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotLike(String value) {
            addCriterion("OBJ11 not like", value, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11In(List<String> values) {
            addCriterion("OBJ11 in", values, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotIn(List<String> values) {
            addCriterion("OBJ11 not in", values, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11Between(String value1, String value2) {
            addCriterion("OBJ11 between", value1, value2, "obj11");
            return (Criteria) this;
        }

        public Criteria andObj11NotBetween(String value1, String value2) {
            addCriterion("OBJ11 not between", value1, value2, "obj11");
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