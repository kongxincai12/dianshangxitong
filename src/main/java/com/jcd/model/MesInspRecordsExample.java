package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MesInspRecordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MesInspRecordsExample() {
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

        public Criteria andLotCodeIsNull() {
            addCriterion("LOT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andLotCodeIsNotNull() {
            addCriterion("LOT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andLotCodeEqualTo(String value) {
            addCriterion("LOT_CODE =", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeNotEqualTo(String value) {
            addCriterion("LOT_CODE <>", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeGreaterThan(String value) {
            addCriterion("LOT_CODE >", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeGreaterThanOrEqualTo(String value) {
            addCriterion("LOT_CODE >=", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeLessThan(String value) {
            addCriterion("LOT_CODE <", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeLessThanOrEqualTo(String value) {
            addCriterion("LOT_CODE <=", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeLike(String value) {
            addCriterion("LOT_CODE like", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeNotLike(String value) {
            addCriterion("LOT_CODE not like", value, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeIn(List<String> values) {
            addCriterion("LOT_CODE in", values, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeNotIn(List<String> values) {
            addCriterion("LOT_CODE not in", values, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeBetween(String value1, String value2) {
            addCriterion("LOT_CODE between", value1, value2, "lotCode");
            return (Criteria) this;
        }

        public Criteria andLotCodeNotBetween(String value1, String value2) {
            addCriterion("LOT_CODE not between", value1, value2, "lotCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNull() {
            addCriterion("EQUIPMENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNotNull() {
            addCriterion("EQUIPMENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeEqualTo(String value) {
            addCriterion("EQUIPMENT_CODE =", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotEqualTo(String value) {
            addCriterion("EQUIPMENT_CODE <>", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThan(String value) {
            addCriterion("EQUIPMENT_CODE >", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EQUIPMENT_CODE >=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThan(String value) {
            addCriterion("EQUIPMENT_CODE <", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThanOrEqualTo(String value) {
            addCriterion("EQUIPMENT_CODE <=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLike(String value) {
            addCriterion("EQUIPMENT_CODE like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotLike(String value) {
            addCriterion("EQUIPMENT_CODE not like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIn(List<String> values) {
            addCriterion("EQUIPMENT_CODE in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotIn(List<String> values) {
            addCriterion("EQUIPMENT_CODE not in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeBetween(String value1, String value2) {
            addCriterion("EQUIPMENT_CODE between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotBetween(String value1, String value2) {
            addCriterion("EQUIPMENT_CODE not between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andInspectorIdIsNull() {
            addCriterion("INSPECTOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andInspectorIdIsNotNull() {
            addCriterion("INSPECTOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInspectorIdEqualTo(String value) {
            addCriterion("INSPECTOR_ID =", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdNotEqualTo(String value) {
            addCriterion("INSPECTOR_ID <>", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdGreaterThan(String value) {
            addCriterion("INSPECTOR_ID >", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdGreaterThanOrEqualTo(String value) {
            addCriterion("INSPECTOR_ID >=", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdLessThan(String value) {
            addCriterion("INSPECTOR_ID <", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdLessThanOrEqualTo(String value) {
            addCriterion("INSPECTOR_ID <=", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdLike(String value) {
            addCriterion("INSPECTOR_ID like", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdNotLike(String value) {
            addCriterion("INSPECTOR_ID not like", value, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdIn(List<String> values) {
            addCriterion("INSPECTOR_ID in", values, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdNotIn(List<String> values) {
            addCriterion("INSPECTOR_ID not in", values, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdBetween(String value1, String value2) {
            addCriterion("INSPECTOR_ID between", value1, value2, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andInspectorIdNotBetween(String value1, String value2) {
            addCriterion("INSPECTOR_ID not between", value1, value2, "inspectorId");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("SITE is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("SITE is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("SITE =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("SITE <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("SITE >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("SITE >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("SITE <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("SITE <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("SITE like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("SITE not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("SITE in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("SITE not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("SITE between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("SITE not between", value1, value2, "site");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeIsNull() {
            addCriterion("INSPECTION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeIsNotNull() {
            addCriterion("INSPECTION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeEqualTo(Date value) {
            addCriterion("INSPECTION_TIME =", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeNotEqualTo(Date value) {
            addCriterion("INSPECTION_TIME <>", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeGreaterThan(Date value) {
            addCriterion("INSPECTION_TIME >", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INSPECTION_TIME >=", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeLessThan(Date value) {
            addCriterion("INSPECTION_TIME <", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeLessThanOrEqualTo(Date value) {
            addCriterion("INSPECTION_TIME <=", value, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeIn(List<Date> values) {
            addCriterion("INSPECTION_TIME in", values, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeNotIn(List<Date> values) {
            addCriterion("INSPECTION_TIME not in", values, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeBetween(Date value1, Date value2) {
            addCriterion("INSPECTION_TIME between", value1, value2, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andInspectionTimeNotBetween(Date value1, Date value2) {
            addCriterion("INSPECTION_TIME not between", value1, value2, "inspectionTime");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonIsNull() {
            addCriterion("REJECTION_REASON is null");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonIsNotNull() {
            addCriterion("REJECTION_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonEqualTo(String value) {
            addCriterion("REJECTION_REASON =", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonNotEqualTo(String value) {
            addCriterion("REJECTION_REASON <>", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonGreaterThan(String value) {
            addCriterion("REJECTION_REASON >", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REJECTION_REASON >=", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonLessThan(String value) {
            addCriterion("REJECTION_REASON <", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonLessThanOrEqualTo(String value) {
            addCriterion("REJECTION_REASON <=", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonLike(String value) {
            addCriterion("REJECTION_REASON like", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonNotLike(String value) {
            addCriterion("REJECTION_REASON not like", value, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonIn(List<String> values) {
            addCriterion("REJECTION_REASON in", values, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonNotIn(List<String> values) {
            addCriterion("REJECTION_REASON not in", values, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonBetween(String value1, String value2) {
            addCriterion("REJECTION_REASON between", value1, value2, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andRejectionReasonNotBetween(String value1, String value2) {
            addCriterion("REJECTION_REASON not between", value1, value2, "rejectionReason");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
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

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("UPDATE_BY like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("UPDATE_BY not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
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