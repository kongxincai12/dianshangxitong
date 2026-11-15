package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LqcRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LqcRecordExample() {
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

        public Criteria andCheckDateIsNull() {
            addCriterion("CHECK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("CHECK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterion("CHECK_DATE =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterion("CHECK_DATE <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterion("CHECK_DATE >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterion("CHECK_DATE <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterion("CHECK_DATE in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterion("CHECK_DATE not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andShiftIsNull() {
            addCriterion("SHIFT is null");
            return (Criteria) this;
        }

        public Criteria andShiftIsNotNull() {
            addCriterion("SHIFT is not null");
            return (Criteria) this;
        }

        public Criteria andShiftEqualTo(String value) {
            addCriterion("SHIFT =", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotEqualTo(String value) {
            addCriterion("SHIFT <>", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftGreaterThan(String value) {
            addCriterion("SHIFT >", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftGreaterThanOrEqualTo(String value) {
            addCriterion("SHIFT >=", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLessThan(String value) {
            addCriterion("SHIFT <", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLessThanOrEqualTo(String value) {
            addCriterion("SHIFT <=", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftLike(String value) {
            addCriterion("SHIFT like", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotLike(String value) {
            addCriterion("SHIFT not like", value, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftIn(List<String> values) {
            addCriterion("SHIFT in", values, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotIn(List<String> values) {
            addCriterion("SHIFT not in", values, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftBetween(String value1, String value2) {
            addCriterion("SHIFT between", value1, value2, "shift");
            return (Criteria) this;
        }

        public Criteria andShiftNotBetween(String value1, String value2) {
            addCriterion("SHIFT not between", value1, value2, "shift");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameIsNull() {
            addCriterion("INSPECTOR_USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameIsNotNull() {
            addCriterion("INSPECTOR_USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameEqualTo(String value) {
            addCriterion("INSPECTOR_USERNAME =", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameNotEqualTo(String value) {
            addCriterion("INSPECTOR_USERNAME <>", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameGreaterThan(String value) {
            addCriterion("INSPECTOR_USERNAME >", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("INSPECTOR_USERNAME >=", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameLessThan(String value) {
            addCriterion("INSPECTOR_USERNAME <", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameLessThanOrEqualTo(String value) {
            addCriterion("INSPECTOR_USERNAME <=", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameLike(String value) {
            addCriterion("INSPECTOR_USERNAME like", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameNotLike(String value) {
            addCriterion("INSPECTOR_USERNAME not like", value, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameIn(List<String> values) {
            addCriterion("INSPECTOR_USERNAME in", values, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameNotIn(List<String> values) {
            addCriterion("INSPECTOR_USERNAME not in", values, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameBetween(String value1, String value2) {
            addCriterion("INSPECTOR_USERNAME between", value1, value2, "inspectorUsername");
            return (Criteria) this;
        }

        public Criteria andInspectorUsernameNotBetween(String value1, String value2) {
            addCriterion("INSPECTOR_USERNAME not between", value1, value2, "inspectorUsername");
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

        public Criteria andLotNameIsNull() {
            addCriterion("LOT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLotNameIsNotNull() {
            addCriterion("LOT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLotNameEqualTo(String value) {
            addCriterion("LOT_NAME =", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameNotEqualTo(String value) {
            addCriterion("LOT_NAME <>", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameGreaterThan(String value) {
            addCriterion("LOT_NAME >", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOT_NAME >=", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameLessThan(String value) {
            addCriterion("LOT_NAME <", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameLessThanOrEqualTo(String value) {
            addCriterion("LOT_NAME <=", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameLike(String value) {
            addCriterion("LOT_NAME like", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameNotLike(String value) {
            addCriterion("LOT_NAME not like", value, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameIn(List<String> values) {
            addCriterion("LOT_NAME in", values, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameNotIn(List<String> values) {
            addCriterion("LOT_NAME not in", values, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameBetween(String value1, String value2) {
            addCriterion("LOT_NAME between", value1, value2, "lotName");
            return (Criteria) this;
        }

        public Criteria andLotNameNotBetween(String value1, String value2) {
            addCriterion("LOT_NAME not between", value1, value2, "lotName");
            return (Criteria) this;
        }

        public Criteria andProductPnIsNull() {
            addCriterion("PRODUCT_PN is null");
            return (Criteria) this;
        }

        public Criteria andProductPnIsNotNull() {
            addCriterion("PRODUCT_PN is not null");
            return (Criteria) this;
        }

        public Criteria andProductPnEqualTo(String value) {
            addCriterion("PRODUCT_PN =", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnNotEqualTo(String value) {
            addCriterion("PRODUCT_PN <>", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnGreaterThan(String value) {
            addCriterion("PRODUCT_PN >", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_PN >=", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnLessThan(String value) {
            addCriterion("PRODUCT_PN <", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_PN <=", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnLike(String value) {
            addCriterion("PRODUCT_PN like", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnNotLike(String value) {
            addCriterion("PRODUCT_PN not like", value, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnIn(List<String> values) {
            addCriterion("PRODUCT_PN in", values, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnNotIn(List<String> values) {
            addCriterion("PRODUCT_PN not in", values, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnBetween(String value1, String value2) {
            addCriterion("PRODUCT_PN between", value1, value2, "productPn");
            return (Criteria) this;
        }

        public Criteria andProductPnNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_PN not between", value1, value2, "productPn");
            return (Criteria) this;
        }

        public Criteria andTotalQtyIsNull() {
            addCriterion("TOTAL_QTY is null");
            return (Criteria) this;
        }

        public Criteria andTotalQtyIsNotNull() {
            addCriterion("TOTAL_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalQtyEqualTo(Long value) {
            addCriterion("TOTAL_QTY =", value, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyNotEqualTo(Long value) {
            addCriterion("TOTAL_QTY <>", value, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyGreaterThan(Long value) {
            addCriterion("TOTAL_QTY >", value, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_QTY >=", value, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyLessThan(Long value) {
            addCriterion("TOTAL_QTY <", value, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_QTY <=", value, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyIn(List<Long> values) {
            addCriterion("TOTAL_QTY in", values, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyNotIn(List<Long> values) {
            addCriterion("TOTAL_QTY not in", values, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyBetween(Long value1, Long value2) {
            addCriterion("TOTAL_QTY between", value1, value2, "totalQty");
            return (Criteria) this;
        }

        public Criteria andTotalQtyNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_QTY not between", value1, value2, "totalQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyIsNull() {
            addCriterion("SAMPLE_QTY is null");
            return (Criteria) this;
        }

        public Criteria andSampleQtyIsNotNull() {
            addCriterion("SAMPLE_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andSampleQtyEqualTo(Long value) {
            addCriterion("SAMPLE_QTY =", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyNotEqualTo(Long value) {
            addCriterion("SAMPLE_QTY <>", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyGreaterThan(Long value) {
            addCriterion("SAMPLE_QTY >", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyGreaterThanOrEqualTo(Long value) {
            addCriterion("SAMPLE_QTY >=", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyLessThan(Long value) {
            addCriterion("SAMPLE_QTY <", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyLessThanOrEqualTo(Long value) {
            addCriterion("SAMPLE_QTY <=", value, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyIn(List<Long> values) {
            addCriterion("SAMPLE_QTY in", values, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyNotIn(List<Long> values) {
            addCriterion("SAMPLE_QTY not in", values, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyBetween(Long value1, Long value2) {
            addCriterion("SAMPLE_QTY between", value1, value2, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andSampleQtyNotBetween(Long value1, Long value2) {
            addCriterion("SAMPLE_QTY not between", value1, value2, "sampleQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyIsNull() {
            addCriterion("TOTAL_DEFECT_QTY is null");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyIsNotNull() {
            addCriterion("TOTAL_DEFECT_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyEqualTo(Long value) {
            addCriterion("TOTAL_DEFECT_QTY =", value, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyNotEqualTo(Long value) {
            addCriterion("TOTAL_DEFECT_QTY <>", value, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyGreaterThan(Long value) {
            addCriterion("TOTAL_DEFECT_QTY >", value, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_DEFECT_QTY >=", value, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyLessThan(Long value) {
            addCriterion("TOTAL_DEFECT_QTY <", value, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_DEFECT_QTY <=", value, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyIn(List<Long> values) {
            addCriterion("TOTAL_DEFECT_QTY in", values, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyNotIn(List<Long> values) {
            addCriterion("TOTAL_DEFECT_QTY not in", values, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyBetween(Long value1, Long value2) {
            addCriterion("TOTAL_DEFECT_QTY between", value1, value2, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andTotalDefectQtyNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_DEFECT_QTY not between", value1, value2, "totalDefectQty");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNull() {
            addCriterion("RECORD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("RECORD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(String value) {
            addCriterion("RECORD_STATUS =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(String value) {
            addCriterion("RECORD_STATUS <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(String value) {
            addCriterion("RECORD_STATUS >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(String value) {
            addCriterion("RECORD_STATUS >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(String value) {
            addCriterion("RECORD_STATUS <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(String value) {
            addCriterion("RECORD_STATUS <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLike(String value) {
            addCriterion("RECORD_STATUS like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotLike(String value) {
            addCriterion("RECORD_STATUS not like", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<String> values) {
            addCriterion("RECORD_STATUS in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<String> values) {
            addCriterion("RECORD_STATUS not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(String value1, String value2) {
            addCriterion("RECORD_STATUS between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(String value1, String value2) {
            addCriterion("RECORD_STATUS not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByIsNull() {
            addCriterion("SHIFT_CONFIRMED_BY is null");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByIsNotNull() {
            addCriterion("SHIFT_CONFIRMED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByEqualTo(String value) {
            addCriterion("SHIFT_CONFIRMED_BY =", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByNotEqualTo(String value) {
            addCriterion("SHIFT_CONFIRMED_BY <>", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByGreaterThan(String value) {
            addCriterion("SHIFT_CONFIRMED_BY >", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByGreaterThanOrEqualTo(String value) {
            addCriterion("SHIFT_CONFIRMED_BY >=", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByLessThan(String value) {
            addCriterion("SHIFT_CONFIRMED_BY <", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByLessThanOrEqualTo(String value) {
            addCriterion("SHIFT_CONFIRMED_BY <=", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByLike(String value) {
            addCriterion("SHIFT_CONFIRMED_BY like", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByNotLike(String value) {
            addCriterion("SHIFT_CONFIRMED_BY not like", value, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByIn(List<String> values) {
            addCriterion("SHIFT_CONFIRMED_BY in", values, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByNotIn(List<String> values) {
            addCriterion("SHIFT_CONFIRMED_BY not in", values, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByBetween(String value1, String value2) {
            addCriterion("SHIFT_CONFIRMED_BY between", value1, value2, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmedByNotBetween(String value1, String value2) {
            addCriterion("SHIFT_CONFIRMED_BY not between", value1, value2, "shiftConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateIsNull() {
            addCriterion("SHIFT_CONFIRMATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateIsNotNull() {
            addCriterion("SHIFT_CONFIRMATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateEqualTo(Date value) {
            addCriterion("SHIFT_CONFIRMATION_DATE =", value, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateNotEqualTo(Date value) {
            addCriterion("SHIFT_CONFIRMATION_DATE <>", value, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateGreaterThan(Date value) {
            addCriterion("SHIFT_CONFIRMATION_DATE >", value, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SHIFT_CONFIRMATION_DATE >=", value, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateLessThan(Date value) {
            addCriterion("SHIFT_CONFIRMATION_DATE <", value, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateLessThanOrEqualTo(Date value) {
            addCriterion("SHIFT_CONFIRMATION_DATE <=", value, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateIn(List<Date> values) {
            addCriterion("SHIFT_CONFIRMATION_DATE in", values, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateNotIn(List<Date> values) {
            addCriterion("SHIFT_CONFIRMATION_DATE not in", values, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateBetween(Date value1, Date value2) {
            addCriterion("SHIFT_CONFIRMATION_DATE between", value1, value2, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andShiftConfirmationDateNotBetween(Date value1, Date value2) {
            addCriterion("SHIFT_CONFIRMATION_DATE not between", value1, value2, "shiftConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByIsNull() {
            addCriterion("LEADER_CONFIRMED_BY is null");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByIsNotNull() {
            addCriterion("LEADER_CONFIRMED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByEqualTo(String value) {
            addCriterion("LEADER_CONFIRMED_BY =", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByNotEqualTo(String value) {
            addCriterion("LEADER_CONFIRMED_BY <>", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByGreaterThan(String value) {
            addCriterion("LEADER_CONFIRMED_BY >", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByGreaterThanOrEqualTo(String value) {
            addCriterion("LEADER_CONFIRMED_BY >=", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByLessThan(String value) {
            addCriterion("LEADER_CONFIRMED_BY <", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByLessThanOrEqualTo(String value) {
            addCriterion("LEADER_CONFIRMED_BY <=", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByLike(String value) {
            addCriterion("LEADER_CONFIRMED_BY like", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByNotLike(String value) {
            addCriterion("LEADER_CONFIRMED_BY not like", value, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByIn(List<String> values) {
            addCriterion("LEADER_CONFIRMED_BY in", values, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByNotIn(List<String> values) {
            addCriterion("LEADER_CONFIRMED_BY not in", values, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByBetween(String value1, String value2) {
            addCriterion("LEADER_CONFIRMED_BY between", value1, value2, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmedByNotBetween(String value1, String value2) {
            addCriterion("LEADER_CONFIRMED_BY not between", value1, value2, "leaderConfirmedBy");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateIsNull() {
            addCriterion("LEADER_CONFIRMATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateIsNotNull() {
            addCriterion("LEADER_CONFIRMATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateEqualTo(Date value) {
            addCriterion("LEADER_CONFIRMATION_DATE =", value, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateNotEqualTo(Date value) {
            addCriterion("LEADER_CONFIRMATION_DATE <>", value, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateGreaterThan(Date value) {
            addCriterion("LEADER_CONFIRMATION_DATE >", value, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LEADER_CONFIRMATION_DATE >=", value, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateLessThan(Date value) {
            addCriterion("LEADER_CONFIRMATION_DATE <", value, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateLessThanOrEqualTo(Date value) {
            addCriterion("LEADER_CONFIRMATION_DATE <=", value, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateIn(List<Date> values) {
            addCriterion("LEADER_CONFIRMATION_DATE in", values, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateNotIn(List<Date> values) {
            addCriterion("LEADER_CONFIRMATION_DATE not in", values, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateBetween(Date value1, Date value2) {
            addCriterion("LEADER_CONFIRMATION_DATE between", value1, value2, "leaderConfirmationDate");
            return (Criteria) this;
        }

        public Criteria andLeaderConfirmationDateNotBetween(Date value1, Date value2) {
            addCriterion("LEADER_CONFIRMATION_DATE not between", value1, value2, "leaderConfirmationDate");
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

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("CREATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("CREATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(Date value) {
            addCriterion("CREATION_DATE =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(Date value) {
            addCriterion("CREATION_DATE <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(Date value) {
            addCriterion("CREATION_DATE >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATION_DATE >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(Date value) {
            addCriterion("CREATION_DATE <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATION_DATE <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<Date> values) {
            addCriterion("CREATION_DATE in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<Date> values) {
            addCriterion("CREATION_DATE not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(Date value1, Date value2) {
            addCriterion("CREATION_DATE between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATION_DATE not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNull() {
            addCriterion("LAST_UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNotNull() {
            addCriterion("LAST_UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY =", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY <>", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThan(String value) {
            addCriterion("LAST_UPDATED_BY >", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY >=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThan(String value) {
            addCriterion("LAST_UPDATED_BY <", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATED_BY <=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLike(String value) {
            addCriterion("LAST_UPDATED_BY like", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotLike(String value) {
            addCriterion("LAST_UPDATED_BY not like", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIn(List<String> values) {
            addCriterion("LAST_UPDATED_BY in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotIn(List<String> values) {
            addCriterion("LAST_UPDATED_BY not in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByBetween(String value1, String value2) {
            addCriterion("LAST_UPDATED_BY between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATED_BY not between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNull() {
            addCriterion("LAST_UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNotNull() {
            addCriterion("LAST_UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATE =", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATE <>", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThan(Date value) {
            addCriterion("LAST_UPDATE_DATE >", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATE >=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThan(Date value) {
            addCriterion("LAST_UPDATE_DATE <", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_DATE <=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIn(List<Date> values) {
            addCriterion("LAST_UPDATE_DATE in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotIn(List<Date> values) {
            addCriterion("LAST_UPDATE_DATE not in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_DATE between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_DATE not between", value1, value2, "lastUpdateDate");
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