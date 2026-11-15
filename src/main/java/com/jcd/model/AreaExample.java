package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaExample() {
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

        public Criteria andAreaidIsNull() {
            addCriterion("AREAID is null");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNotNull() {
            addCriterion("AREAID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaidEqualTo(String value) {
            addCriterion("AREAID =", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotEqualTo(String value) {
            addCriterion("AREAID <>", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThan(String value) {
            addCriterion("AREAID >", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThanOrEqualTo(String value) {
            addCriterion("AREAID >=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThan(String value) {
            addCriterion("AREAID <", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThanOrEqualTo(String value) {
            addCriterion("AREAID <=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLike(String value) {
            addCriterion("AREAID like", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotLike(String value) {
            addCriterion("AREAID not like", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidIn(List<String> values) {
            addCriterion("AREAID in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotIn(List<String> values) {
            addCriterion("AREAID not in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidBetween(String value1, String value2) {
            addCriterion("AREAID between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotBetween(String value1, String value2) {
            addCriterion("AREAID not between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNull() {
            addCriterion("AREANAME is null");
            return (Criteria) this;
        }

        public Criteria andAreanameIsNotNull() {
            addCriterion("AREANAME is not null");
            return (Criteria) this;
        }

        public Criteria andAreanameEqualTo(String value) {
            addCriterion("AREANAME =", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotEqualTo(String value) {
            addCriterion("AREANAME <>", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThan(String value) {
            addCriterion("AREANAME >", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameGreaterThanOrEqualTo(String value) {
            addCriterion("AREANAME >=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThan(String value) {
            addCriterion("AREANAME <", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLessThanOrEqualTo(String value) {
            addCriterion("AREANAME <=", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameLike(String value) {
            addCriterion("AREANAME like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotLike(String value) {
            addCriterion("AREANAME not like", value, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameIn(List<String> values) {
            addCriterion("AREANAME in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotIn(List<String> values) {
            addCriterion("AREANAME not in", values, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameBetween(String value1, String value2) {
            addCriterion("AREANAME between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreanameNotBetween(String value1, String value2) {
            addCriterion("AREANAME not between", value1, value2, "areaname");
            return (Criteria) this;
        }

        public Criteria andAreatypeIsNull() {
            addCriterion("AREATYPE is null");
            return (Criteria) this;
        }

        public Criteria andAreatypeIsNotNull() {
            addCriterion("AREATYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAreatypeEqualTo(String value) {
            addCriterion("AREATYPE =", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotEqualTo(String value) {
            addCriterion("AREATYPE <>", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeGreaterThan(String value) {
            addCriterion("AREATYPE >", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeGreaterThanOrEqualTo(String value) {
            addCriterion("AREATYPE >=", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeLessThan(String value) {
            addCriterion("AREATYPE <", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeLessThanOrEqualTo(String value) {
            addCriterion("AREATYPE <=", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeLike(String value) {
            addCriterion("AREATYPE like", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotLike(String value) {
            addCriterion("AREATYPE not like", value, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeIn(List<String> values) {
            addCriterion("AREATYPE in", values, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotIn(List<String> values) {
            addCriterion("AREATYPE not in", values, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeBetween(String value1, String value2) {
            addCriterion("AREATYPE between", value1, value2, "areatype");
            return (Criteria) this;
        }

        public Criteria andAreatypeNotBetween(String value1, String value2) {
            addCriterion("AREATYPE not between", value1, value2, "areatype");
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

        public Criteria andParentareaidIsNull() {
            addCriterion("PARENTAREAID is null");
            return (Criteria) this;
        }

        public Criteria andParentareaidIsNotNull() {
            addCriterion("PARENTAREAID is not null");
            return (Criteria) this;
        }

        public Criteria andParentareaidEqualTo(String value) {
            addCriterion("PARENTAREAID =", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidNotEqualTo(String value) {
            addCriterion("PARENTAREAID <>", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidGreaterThan(String value) {
            addCriterion("PARENTAREAID >", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTAREAID >=", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidLessThan(String value) {
            addCriterion("PARENTAREAID <", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidLessThanOrEqualTo(String value) {
            addCriterion("PARENTAREAID <=", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidLike(String value) {
            addCriterion("PARENTAREAID like", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidNotLike(String value) {
            addCriterion("PARENTAREAID not like", value, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidIn(List<String> values) {
            addCriterion("PARENTAREAID in", values, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidNotIn(List<String> values) {
            addCriterion("PARENTAREAID not in", values, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidBetween(String value1, String value2) {
            addCriterion("PARENTAREAID between", value1, value2, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andParentareaidNotBetween(String value1, String value2) {
            addCriterion("PARENTAREAID not between", value1, value2, "parentareaid");
            return (Criteria) this;
        }

        public Criteria andSectionIsNull() {
            addCriterion("SECTION is null");
            return (Criteria) this;
        }

        public Criteria andSectionIsNotNull() {
            addCriterion("SECTION is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEqualTo(String value) {
            addCriterion("SECTION =", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotEqualTo(String value) {
            addCriterion("SECTION <>", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThan(String value) {
            addCriterion("SECTION >", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThanOrEqualTo(String value) {
            addCriterion("SECTION >=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThan(String value) {
            addCriterion("SECTION <", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThanOrEqualTo(String value) {
            addCriterion("SECTION <=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLike(String value) {
            addCriterion("SECTION like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotLike(String value) {
            addCriterion("SECTION not like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionIn(List<String> values) {
            addCriterion("SECTION in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotIn(List<String> values) {
            addCriterion("SECTION not in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionBetween(String value1, String value2) {
            addCriterion("SECTION between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotBetween(String value1, String value2) {
            addCriterion("SECTION not between", value1, value2, "section");
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