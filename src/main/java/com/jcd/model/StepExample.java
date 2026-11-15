package com.jcd.model;

import java.util.ArrayList;
import java.util.List;

public class StepExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StepExample() {
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

        public Criteria andSteptypeIsNull() {
            addCriterion("STEPTYPE is null");
            return (Criteria) this;
        }

        public Criteria andSteptypeIsNotNull() {
            addCriterion("STEPTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSteptypeEqualTo(String value) {
            addCriterion("STEPTYPE =", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeNotEqualTo(String value) {
            addCriterion("STEPTYPE <>", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeGreaterThan(String value) {
            addCriterion("STEPTYPE >", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeGreaterThanOrEqualTo(String value) {
            addCriterion("STEPTYPE >=", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeLessThan(String value) {
            addCriterion("STEPTYPE <", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeLessThanOrEqualTo(String value) {
            addCriterion("STEPTYPE <=", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeLike(String value) {
            addCriterion("STEPTYPE like", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeNotLike(String value) {
            addCriterion("STEPTYPE not like", value, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeIn(List<String> values) {
            addCriterion("STEPTYPE in", values, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeNotIn(List<String> values) {
            addCriterion("STEPTYPE not in", values, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeBetween(String value1, String value2) {
            addCriterion("STEPTYPE between", value1, value2, "steptype");
            return (Criteria) this;
        }

        public Criteria andSteptypeNotBetween(String value1, String value2) {
            addCriterion("STEPTYPE not between", value1, value2, "steptype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeIsNull() {
            addCriterion("RESOURCETYPE is null");
            return (Criteria) this;
        }

        public Criteria andResourcetypeIsNotNull() {
            addCriterion("RESOURCETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResourcetypeEqualTo(String value) {
            addCriterion("RESOURCETYPE =", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotEqualTo(String value) {
            addCriterion("RESOURCETYPE <>", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeGreaterThan(String value) {
            addCriterion("RESOURCETYPE >", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCETYPE >=", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeLessThan(String value) {
            addCriterion("RESOURCETYPE <", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeLessThanOrEqualTo(String value) {
            addCriterion("RESOURCETYPE <=", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeLike(String value) {
            addCriterion("RESOURCETYPE like", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotLike(String value) {
            addCriterion("RESOURCETYPE not like", value, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeIn(List<String> values) {
            addCriterion("RESOURCETYPE in", values, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotIn(List<String> values) {
            addCriterion("RESOURCETYPE not in", values, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeBetween(String value1, String value2) {
            addCriterion("RESOURCETYPE between", value1, value2, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourcetypeNotBetween(String value1, String value2) {
            addCriterion("RESOURCETYPE not between", value1, value2, "resourcetype");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNull() {
            addCriterion("RESOURCEID is null");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNotNull() {
            addCriterion("RESOURCEID is not null");
            return (Criteria) this;
        }

        public Criteria andResourceidEqualTo(String value) {
            addCriterion("RESOURCEID =", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotEqualTo(String value) {
            addCriterion("RESOURCEID <>", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThan(String value) {
            addCriterion("RESOURCEID >", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCEID >=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThan(String value) {
            addCriterion("RESOURCEID <", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThanOrEqualTo(String value) {
            addCriterion("RESOURCEID <=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLike(String value) {
            addCriterion("RESOURCEID like", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotLike(String value) {
            addCriterion("RESOURCEID not like", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidIn(List<String> values) {
            addCriterion("RESOURCEID in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotIn(List<String> values) {
            addCriterion("RESOURCEID not in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidBetween(String value1, String value2) {
            addCriterion("RESOURCEID between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotBetween(String value1, String value2) {
            addCriterion("RESOURCEID not between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNull() {
            addCriterion("CATEGORYID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("CATEGORYID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(String value) {
            addCriterion("CATEGORYID =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(String value) {
            addCriterion("CATEGORYID <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(String value) {
            addCriterion("CATEGORYID >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORYID >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(String value) {
            addCriterion("CATEGORYID <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(String value) {
            addCriterion("CATEGORYID <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLike(String value) {
            addCriterion("CATEGORYID like", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotLike(String value) {
            addCriterion("CATEGORYID not like", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<String> values) {
            addCriterion("CATEGORYID in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<String> values) {
            addCriterion("CATEGORYID not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(String value1, String value2) {
            addCriterion("CATEGORYID between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(String value1, String value2) {
            addCriterion("CATEGORYID not between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andSectionnameIsNull() {
            addCriterion("SECTIONNAME is null");
            return (Criteria) this;
        }

        public Criteria andSectionnameIsNotNull() {
            addCriterion("SECTIONNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSectionnameEqualTo(String value) {
            addCriterion("SECTIONNAME =", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotEqualTo(String value) {
            addCriterion("SECTIONNAME <>", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameGreaterThan(String value) {
            addCriterion("SECTIONNAME >", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameGreaterThanOrEqualTo(String value) {
            addCriterion("SECTIONNAME >=", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameLessThan(String value) {
            addCriterion("SECTIONNAME <", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameLessThanOrEqualTo(String value) {
            addCriterion("SECTIONNAME <=", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameLike(String value) {
            addCriterion("SECTIONNAME like", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotLike(String value) {
            addCriterion("SECTIONNAME not like", value, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameIn(List<String> values) {
            addCriterion("SECTIONNAME in", values, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotIn(List<String> values) {
            addCriterion("SECTIONNAME not in", values, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameBetween(String value1, String value2) {
            addCriterion("SECTIONNAME between", value1, value2, "sectionname");
            return (Criteria) this;
        }

        public Criteria andSectionnameNotBetween(String value1, String value2) {
            addCriterion("SECTIONNAME not between", value1, value2, "sectionname");
            return (Criteria) this;
        }

        public Criteria andStepcategoryIsNull() {
            addCriterion("STEPCATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andStepcategoryIsNotNull() {
            addCriterion("STEPCATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andStepcategoryEqualTo(String value) {
            addCriterion("STEPCATEGORY =", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryNotEqualTo(String value) {
            addCriterion("STEPCATEGORY <>", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryGreaterThan(String value) {
            addCriterion("STEPCATEGORY >", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("STEPCATEGORY >=", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryLessThan(String value) {
            addCriterion("STEPCATEGORY <", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryLessThanOrEqualTo(String value) {
            addCriterion("STEPCATEGORY <=", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryLike(String value) {
            addCriterion("STEPCATEGORY like", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryNotLike(String value) {
            addCriterion("STEPCATEGORY not like", value, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryIn(List<String> values) {
            addCriterion("STEPCATEGORY in", values, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryNotIn(List<String> values) {
            addCriterion("STEPCATEGORY not in", values, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryBetween(String value1, String value2) {
            addCriterion("STEPCATEGORY between", value1, value2, "stepcategory");
            return (Criteria) this;
        }

        public Criteria andStepcategoryNotBetween(String value1, String value2) {
            addCriterion("STEPCATEGORY not between", value1, value2, "stepcategory");
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

        public Criteria andDatetimeEqualTo(String value) {
            addCriterion("DATETIME =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(String value) {
            addCriterion("DATETIME <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(String value) {
            addCriterion("DATETIME >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("DATETIME >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(String value) {
            addCriterion("DATETIME <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(String value) {
            addCriterion("DATETIME <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLike(String value) {
            addCriterion("DATETIME like", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotLike(String value) {
            addCriterion("DATETIME not like", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<String> values) {
            addCriterion("DATETIME in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<String> values) {
            addCriterion("DATETIME not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(String value1, String value2) {
            addCriterion("DATETIME between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(String value1, String value2) {
            addCriterion("DATETIME not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andIconurlIsNull() {
            addCriterion("ICONURL is null");
            return (Criteria) this;
        }

        public Criteria andIconurlIsNotNull() {
            addCriterion("ICONURL is not null");
            return (Criteria) this;
        }

        public Criteria andIconurlEqualTo(String value) {
            addCriterion("ICONURL =", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlNotEqualTo(String value) {
            addCriterion("ICONURL <>", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlGreaterThan(String value) {
            addCriterion("ICONURL >", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlGreaterThanOrEqualTo(String value) {
            addCriterion("ICONURL >=", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlLessThan(String value) {
            addCriterion("ICONURL <", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlLessThanOrEqualTo(String value) {
            addCriterion("ICONURL <=", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlLike(String value) {
            addCriterion("ICONURL like", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlNotLike(String value) {
            addCriterion("ICONURL not like", value, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlIn(List<String> values) {
            addCriterion("ICONURL in", values, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlNotIn(List<String> values) {
            addCriterion("ICONURL not in", values, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlBetween(String value1, String value2) {
            addCriterion("ICONURL between", value1, value2, "iconurl");
            return (Criteria) this;
        }

        public Criteria andIconurlNotBetween(String value1, String value2) {
            addCriterion("ICONURL not between", value1, value2, "iconurl");
            return (Criteria) this;
        }

        public Criteria andEdcplanidIsNull() {
            addCriterion("EDCPLANID is null");
            return (Criteria) this;
        }

        public Criteria andEdcplanidIsNotNull() {
            addCriterion("EDCPLANID is not null");
            return (Criteria) this;
        }

        public Criteria andEdcplanidEqualTo(String value) {
            addCriterion("EDCPLANID =", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidNotEqualTo(String value) {
            addCriterion("EDCPLANID <>", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidGreaterThan(String value) {
            addCriterion("EDCPLANID >", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidGreaterThanOrEqualTo(String value) {
            addCriterion("EDCPLANID >=", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidLessThan(String value) {
            addCriterion("EDCPLANID <", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidLessThanOrEqualTo(String value) {
            addCriterion("EDCPLANID <=", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidLike(String value) {
            addCriterion("EDCPLANID like", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidNotLike(String value) {
            addCriterion("EDCPLANID not like", value, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidIn(List<String> values) {
            addCriterion("EDCPLANID in", values, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidNotIn(List<String> values) {
            addCriterion("EDCPLANID not in", values, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidBetween(String value1, String value2) {
            addCriterion("EDCPLANID between", value1, value2, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andEdcplanidNotBetween(String value1, String value2) {
            addCriterion("EDCPLANID not between", value1, value2, "edcplanid");
            return (Criteria) this;
        }

        public Criteria andBoardsideIsNull() {
            addCriterion("BOARDSIDE is null");
            return (Criteria) this;
        }

        public Criteria andBoardsideIsNotNull() {
            addCriterion("BOARDSIDE is not null");
            return (Criteria) this;
        }

        public Criteria andBoardsideEqualTo(String value) {
            addCriterion("BOARDSIDE =", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotEqualTo(String value) {
            addCriterion("BOARDSIDE <>", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideGreaterThan(String value) {
            addCriterion("BOARDSIDE >", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideGreaterThanOrEqualTo(String value) {
            addCriterion("BOARDSIDE >=", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideLessThan(String value) {
            addCriterion("BOARDSIDE <", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideLessThanOrEqualTo(String value) {
            addCriterion("BOARDSIDE <=", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideLike(String value) {
            addCriterion("BOARDSIDE like", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotLike(String value) {
            addCriterion("BOARDSIDE not like", value, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideIn(List<String> values) {
            addCriterion("BOARDSIDE in", values, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotIn(List<String> values) {
            addCriterion("BOARDSIDE not in", values, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideBetween(String value1, String value2) {
            addCriterion("BOARDSIDE between", value1, value2, "boardside");
            return (Criteria) this;
        }

        public Criteria andBoardsideNotBetween(String value1, String value2) {
            addCriterion("BOARDSIDE not between", value1, value2, "boardside");
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

        public Criteria andIserpstepIsNull() {
            addCriterion("ISERPSTEP is null");
            return (Criteria) this;
        }

        public Criteria andIserpstepIsNotNull() {
            addCriterion("ISERPSTEP is not null");
            return (Criteria) this;
        }

        public Criteria andIserpstepEqualTo(String value) {
            addCriterion("ISERPSTEP =", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepNotEqualTo(String value) {
            addCriterion("ISERPSTEP <>", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepGreaterThan(String value) {
            addCriterion("ISERPSTEP >", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepGreaterThanOrEqualTo(String value) {
            addCriterion("ISERPSTEP >=", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepLessThan(String value) {
            addCriterion("ISERPSTEP <", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepLessThanOrEqualTo(String value) {
            addCriterion("ISERPSTEP <=", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepLike(String value) {
            addCriterion("ISERPSTEP like", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepNotLike(String value) {
            addCriterion("ISERPSTEP not like", value, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepIn(List<String> values) {
            addCriterion("ISERPSTEP in", values, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepNotIn(List<String> values) {
            addCriterion("ISERPSTEP not in", values, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepBetween(String value1, String value2) {
            addCriterion("ISERPSTEP between", value1, value2, "iserpstep");
            return (Criteria) this;
        }

        public Criteria andIserpstepNotBetween(String value1, String value2) {
            addCriterion("ISERPSTEP not between", value1, value2, "iserpstep");
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