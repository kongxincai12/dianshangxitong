package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mes_defect_presetsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Mes_defect_presetsExample() {
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

        public Criteria andSiteNameIsNull() {
            addCriterion("SITE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("SITE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("SITE_NAME =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("SITE_NAME <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("SITE_NAME >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("SITE_NAME >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("SITE_NAME <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("SITE_NAME <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("SITE_NAME like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("SITE_NAME not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("SITE_NAME in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("SITE_NAME not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("SITE_NAME between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("SITE_NAME not between", value1, value2, "siteName");
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

        public Criteria andDisplayOrderIsNull() {
            addCriterion("DISPLAY_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNotNull() {
            addCriterion("DISPLAY_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderEqualTo(Long value) {
            addCriterion("DISPLAY_ORDER =", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotEqualTo(Long value) {
            addCriterion("DISPLAY_ORDER <>", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThan(Long value) {
            addCriterion("DISPLAY_ORDER >", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThanOrEqualTo(Long value) {
            addCriterion("DISPLAY_ORDER >=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThan(Long value) {
            addCriterion("DISPLAY_ORDER <", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThanOrEqualTo(Long value) {
            addCriterion("DISPLAY_ORDER <=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIn(List<Long> values) {
            addCriterion("DISPLAY_ORDER in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotIn(List<Long> values) {
            addCriterion("DISPLAY_ORDER not in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderBetween(Long value1, Long value2) {
            addCriterion("DISPLAY_ORDER between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotBetween(Long value1, Long value2) {
            addCriterion("DISPLAY_ORDER not between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("IS_ENABLED is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("IS_ENABLED is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Short value) {
            addCriterion("IS_ENABLED =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Short value) {
            addCriterion("IS_ENABLED <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Short value) {
            addCriterion("IS_ENABLED >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_ENABLED >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Short value) {
            addCriterion("IS_ENABLED <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Short value) {
            addCriterion("IS_ENABLED <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Short> values) {
            addCriterion("IS_ENABLED in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Short> values) {
            addCriterion("IS_ENABLED not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Short value1, Short value2) {
            addCriterion("IS_ENABLED between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Short value1, Short value2) {
            addCriterion("IS_ENABLED not between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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

        public Criteria andAttribute2IsNull() {
            addCriterion("ATTRIBUTE2 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute2IsNotNull() {
            addCriterion("ATTRIBUTE2 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute2EqualTo(String value) {
            addCriterion("ATTRIBUTE2 =", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotEqualTo(String value) {
            addCriterion("ATTRIBUTE2 <>", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2GreaterThan(String value) {
            addCriterion("ATTRIBUTE2 >", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE2 >=", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2LessThan(String value) {
            addCriterion("ATTRIBUTE2 <", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE2 <=", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2Like(String value) {
            addCriterion("ATTRIBUTE2 like", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotLike(String value) {
            addCriterion("ATTRIBUTE2 not like", value, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2In(List<String> values) {
            addCriterion("ATTRIBUTE2 in", values, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotIn(List<String> values) {
            addCriterion("ATTRIBUTE2 not in", values, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2Between(String value1, String value2) {
            addCriterion("ATTRIBUTE2 between", value1, value2, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute2NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE2 not between", value1, value2, "attribute2");
            return (Criteria) this;
        }

        public Criteria andAttribute3IsNull() {
            addCriterion("ATTRIBUTE3 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute3IsNotNull() {
            addCriterion("ATTRIBUTE3 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute3EqualTo(String value) {
            addCriterion("ATTRIBUTE3 =", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotEqualTo(String value) {
            addCriterion("ATTRIBUTE3 <>", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3GreaterThan(String value) {
            addCriterion("ATTRIBUTE3 >", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE3 >=", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3LessThan(String value) {
            addCriterion("ATTRIBUTE3 <", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE3 <=", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3Like(String value) {
            addCriterion("ATTRIBUTE3 like", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotLike(String value) {
            addCriterion("ATTRIBUTE3 not like", value, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3In(List<String> values) {
            addCriterion("ATTRIBUTE3 in", values, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotIn(List<String> values) {
            addCriterion("ATTRIBUTE3 not in", values, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3Between(String value1, String value2) {
            addCriterion("ATTRIBUTE3 between", value1, value2, "attribute3");
            return (Criteria) this;
        }

        public Criteria andAttribute3NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE3 not between", value1, value2, "attribute3");
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

        public Criteria andAttributeNum2IsNull() {
            addCriterion("ATTRIBUTE_NUM2 is null");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2IsNotNull() {
            addCriterion("ATTRIBUTE_NUM2 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2EqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM2 =", value, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2NotEqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM2 <>", value, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2GreaterThan(Short value) {
            addCriterion("ATTRIBUTE_NUM2 >", value, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2GreaterThanOrEqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM2 >=", value, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2LessThan(Short value) {
            addCriterion("ATTRIBUTE_NUM2 <", value, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2LessThanOrEqualTo(Short value) {
            addCriterion("ATTRIBUTE_NUM2 <=", value, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2In(List<Short> values) {
            addCriterion("ATTRIBUTE_NUM2 in", values, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2NotIn(List<Short> values) {
            addCriterion("ATTRIBUTE_NUM2 not in", values, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2Between(Short value1, Short value2) {
            addCriterion("ATTRIBUTE_NUM2 between", value1, value2, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeNum2NotBetween(Short value1, Short value2) {
            addCriterion("ATTRIBUTE_NUM2 not between", value1, value2, "attributeNum2");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1IsNull() {
            addCriterion("ATTRIBUTE_DATE1 is null");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1IsNotNull() {
            addCriterion("ATTRIBUTE_DATE1 is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1EqualTo(Date value) {
            addCriterion("ATTRIBUTE_DATE1 =", value, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1NotEqualTo(Date value) {
            addCriterion("ATTRIBUTE_DATE1 <>", value, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1GreaterThan(Date value) {
            addCriterion("ATTRIBUTE_DATE1 >", value, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1GreaterThanOrEqualTo(Date value) {
            addCriterion("ATTRIBUTE_DATE1 >=", value, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1LessThan(Date value) {
            addCriterion("ATTRIBUTE_DATE1 <", value, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1LessThanOrEqualTo(Date value) {
            addCriterion("ATTRIBUTE_DATE1 <=", value, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1In(List<Date> values) {
            addCriterion("ATTRIBUTE_DATE1 in", values, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1NotIn(List<Date> values) {
            addCriterion("ATTRIBUTE_DATE1 not in", values, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1Between(Date value1, Date value2) {
            addCriterion("ATTRIBUTE_DATE1 between", value1, value2, "attributeDate1");
            return (Criteria) this;
        }

        public Criteria andAttributeDate1NotBetween(Date value1, Date value2) {
            addCriterion("ATTRIBUTE_DATE1 not between", value1, value2, "attributeDate1");
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