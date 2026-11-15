package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PackcartonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PackcartonExample() {
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

        public Criteria andCartonidIsNull() {
            addCriterion("CARTONID is null");
            return (Criteria) this;
        }

        public Criteria andCartonidIsNotNull() {
            addCriterion("CARTONID is not null");
            return (Criteria) this;
        }

        public Criteria andCartonidEqualTo(String value) {
            addCriterion("CARTONID =", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidNotEqualTo(String value) {
            addCriterion("CARTONID <>", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidGreaterThan(String value) {
            addCriterion("CARTONID >", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidGreaterThanOrEqualTo(String value) {
            addCriterion("CARTONID >=", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidLessThan(String value) {
            addCriterion("CARTONID <", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidLessThanOrEqualTo(String value) {
            addCriterion("CARTONID <=", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidLike(String value) {
            addCriterion("CARTONID like", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidNotLike(String value) {
            addCriterion("CARTONID not like", value, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidIn(List<String> values) {
            addCriterion("CARTONID in", values, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidNotIn(List<String> values) {
            addCriterion("CARTONID not in", values, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidBetween(String value1, String value2) {
            addCriterion("CARTONID between", value1, value2, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartonidNotBetween(String value1, String value2) {
            addCriterion("CARTONID not between", value1, value2, "cartonid");
            return (Criteria) this;
        }

        public Criteria andCartoncodeIsNull() {
            addCriterion("CARTONCODE is null");
            return (Criteria) this;
        }

        public Criteria andCartoncodeIsNotNull() {
            addCriterion("CARTONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCartoncodeEqualTo(String value) {
            addCriterion("CARTONCODE =", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotEqualTo(String value) {
            addCriterion("CARTONCODE <>", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeGreaterThan(String value) {
            addCriterion("CARTONCODE >", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeGreaterThanOrEqualTo(String value) {
            addCriterion("CARTONCODE >=", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeLessThan(String value) {
            addCriterion("CARTONCODE <", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeLessThanOrEqualTo(String value) {
            addCriterion("CARTONCODE <=", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeLike(String value) {
            addCriterion("CARTONCODE like", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotLike(String value) {
            addCriterion("CARTONCODE not like", value, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeIn(List<String> values) {
            addCriterion("CARTONCODE in", values, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotIn(List<String> values) {
            addCriterion("CARTONCODE not in", values, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeBetween(String value1, String value2) {
            addCriterion("CARTONCODE between", value1, value2, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartoncodeNotBetween(String value1, String value2) {
            addCriterion("CARTONCODE not between", value1, value2, "cartoncode");
            return (Criteria) this;
        }

        public Criteria andCartonqtyIsNull() {
            addCriterion("CARTONQTY is null");
            return (Criteria) this;
        }

        public Criteria andCartonqtyIsNotNull() {
            addCriterion("CARTONQTY is not null");
            return (Criteria) this;
        }

        public Criteria andCartonqtyEqualTo(Integer value) {
            addCriterion("CARTONQTY =", value, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyNotEqualTo(Integer value) {
            addCriterion("CARTONQTY <>", value, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyGreaterThan(Integer value) {
            addCriterion("CARTONQTY >", value, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("CARTONQTY >=", value, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyLessThan(Integer value) {
            addCriterion("CARTONQTY <", value, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyLessThanOrEqualTo(Integer value) {
            addCriterion("CARTONQTY <=", value, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyIn(List<Integer> values) {
            addCriterion("CARTONQTY in", values, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyNotIn(List<Integer> values) {
            addCriterion("CARTONQTY not in", values, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyBetween(Integer value1, Integer value2) {
            addCriterion("CARTONQTY between", value1, value2, "cartonqty");
            return (Criteria) this;
        }

        public Criteria andCartonqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("CARTONQTY not between", value1, value2, "cartonqty");
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

        public Criteria andStationidIsNull() {
            addCriterion("STATIONID is null");
            return (Criteria) this;
        }

        public Criteria andStationidIsNotNull() {
            addCriterion("STATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andStationidEqualTo(String value) {
            addCriterion("STATIONID =", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotEqualTo(String value) {
            addCriterion("STATIONID <>", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThan(String value) {
            addCriterion("STATIONID >", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThanOrEqualTo(String value) {
            addCriterion("STATIONID >=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThan(String value) {
            addCriterion("STATIONID <", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThanOrEqualTo(String value) {
            addCriterion("STATIONID <=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLike(String value) {
            addCriterion("STATIONID like", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotLike(String value) {
            addCriterion("STATIONID not like", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidIn(List<String> values) {
            addCriterion("STATIONID in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotIn(List<String> values) {
            addCriterion("STATIONID not in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidBetween(String value1, String value2) {
            addCriterion("STATIONID between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotBetween(String value1, String value2) {
            addCriterion("STATIONID not between", value1, value2, "stationid");
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

        public Criteria andGiftcodeIsNull() {
            addCriterion("GIFTCODE is null");
            return (Criteria) this;
        }

        public Criteria andGiftcodeIsNotNull() {
            addCriterion("GIFTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andGiftcodeEqualTo(String value) {
            addCriterion("GIFTCODE =", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotEqualTo(String value) {
            addCriterion("GIFTCODE <>", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeGreaterThan(String value) {
            addCriterion("GIFTCODE >", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeGreaterThanOrEqualTo(String value) {
            addCriterion("GIFTCODE >=", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeLessThan(String value) {
            addCriterion("GIFTCODE <", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeLessThanOrEqualTo(String value) {
            addCriterion("GIFTCODE <=", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeLike(String value) {
            addCriterion("GIFTCODE like", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotLike(String value) {
            addCriterion("GIFTCODE not like", value, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeIn(List<String> values) {
            addCriterion("GIFTCODE in", values, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotIn(List<String> values) {
            addCriterion("GIFTCODE not in", values, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeBetween(String value1, String value2) {
            addCriterion("GIFTCODE between", value1, value2, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftcodeNotBetween(String value1, String value2) {
            addCriterion("GIFTCODE not between", value1, value2, "giftcode");
            return (Criteria) this;
        }

        public Criteria andGiftqtyIsNull() {
            addCriterion("GIFTQTY is null");
            return (Criteria) this;
        }

        public Criteria andGiftqtyIsNotNull() {
            addCriterion("GIFTQTY is not null");
            return (Criteria) this;
        }

        public Criteria andGiftqtyEqualTo(Integer value) {
            addCriterion("GIFTQTY =", value, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyNotEqualTo(Integer value) {
            addCriterion("GIFTQTY <>", value, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyGreaterThan(Integer value) {
            addCriterion("GIFTQTY >", value, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("GIFTQTY >=", value, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyLessThan(Integer value) {
            addCriterion("GIFTQTY <", value, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyLessThanOrEqualTo(Integer value) {
            addCriterion("GIFTQTY <=", value, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyIn(List<Integer> values) {
            addCriterion("GIFTQTY in", values, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyNotIn(List<Integer> values) {
            addCriterion("GIFTQTY not in", values, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyBetween(Integer value1, Integer value2) {
            addCriterion("GIFTQTY between", value1, value2, "giftqty");
            return (Criteria) this;
        }

        public Criteria andGiftqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("GIFTQTY not between", value1, value2, "giftqty");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("COMMENTS is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("COMMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("COMMENTS =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("COMMENTS <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("COMMENTS >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTS >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("COMMENTS <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("COMMENTS <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("COMMENTS like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("COMMENTS not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("COMMENTS in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("COMMENTS not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("COMMENTS between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("COMMENTS not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNull() {
            addCriterion("DELETEFLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNotNull() {
            addCriterion("DELETEFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagEqualTo(String value) {
            addCriterion("DELETEFLAG =", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotEqualTo(String value) {
            addCriterion("DELETEFLAG <>", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThan(String value) {
            addCriterion("DELETEFLAG >", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThanOrEqualTo(String value) {
            addCriterion("DELETEFLAG >=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThan(String value) {
            addCriterion("DELETEFLAG <", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThanOrEqualTo(String value) {
            addCriterion("DELETEFLAG <=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLike(String value) {
            addCriterion("DELETEFLAG like", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotLike(String value) {
            addCriterion("DELETEFLAG not like", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIn(List<String> values) {
            addCriterion("DELETEFLAG in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotIn(List<String> values) {
            addCriterion("DELETEFLAG not in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagBetween(String value1, String value2) {
            addCriterion("DELETEFLAG between", value1, value2, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotBetween(String value1, String value2) {
            addCriterion("DELETEFLAG not between", value1, value2, "deleteflag");
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

        public Criteria andConsumeqtyIsNull() {
            addCriterion("CONSUMEQTY is null");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyIsNotNull() {
            addCriterion("CONSUMEQTY is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyEqualTo(Integer value) {
            addCriterion("CONSUMEQTY =", value, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyNotEqualTo(Integer value) {
            addCriterion("CONSUMEQTY <>", value, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyGreaterThan(Integer value) {
            addCriterion("CONSUMEQTY >", value, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("CONSUMEQTY >=", value, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyLessThan(Integer value) {
            addCriterion("CONSUMEQTY <", value, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyLessThanOrEqualTo(Integer value) {
            addCriterion("CONSUMEQTY <=", value, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyIn(List<Integer> values) {
            addCriterion("CONSUMEQTY in", values, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyNotIn(List<Integer> values) {
            addCriterion("CONSUMEQTY not in", values, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyBetween(Integer value1, Integer value2) {
            addCriterion("CONSUMEQTY between", value1, value2, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andConsumeqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("CONSUMEQTY not between", value1, value2, "consumeqty");
            return (Criteria) this;
        }

        public Criteria andCartonObj01IsNull() {
            addCriterion("CARTON_OBJ01 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj01IsNotNull() {
            addCriterion("CARTON_OBJ01 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj01EqualTo(String value) {
            addCriterion("CARTON_OBJ01 =", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01NotEqualTo(String value) {
            addCriterion("CARTON_OBJ01 <>", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01GreaterThan(String value) {
            addCriterion("CARTON_OBJ01 >", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ01 >=", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01LessThan(String value) {
            addCriterion("CARTON_OBJ01 <", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ01 <=", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01Like(String value) {
            addCriterion("CARTON_OBJ01 like", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01NotLike(String value) {
            addCriterion("CARTON_OBJ01 not like", value, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01In(List<String> values) {
            addCriterion("CARTON_OBJ01 in", values, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01NotIn(List<String> values) {
            addCriterion("CARTON_OBJ01 not in", values, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01Between(String value1, String value2) {
            addCriterion("CARTON_OBJ01 between", value1, value2, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj01NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ01 not between", value1, value2, "cartonObj01");
            return (Criteria) this;
        }

        public Criteria andCartonObj02IsNull() {
            addCriterion("CARTON_OBJ02 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj02IsNotNull() {
            addCriterion("CARTON_OBJ02 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj02EqualTo(String value) {
            addCriterion("CARTON_OBJ02 =", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02NotEqualTo(String value) {
            addCriterion("CARTON_OBJ02 <>", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02GreaterThan(String value) {
            addCriterion("CARTON_OBJ02 >", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ02 >=", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02LessThan(String value) {
            addCriterion("CARTON_OBJ02 <", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ02 <=", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02Like(String value) {
            addCriterion("CARTON_OBJ02 like", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02NotLike(String value) {
            addCriterion("CARTON_OBJ02 not like", value, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02In(List<String> values) {
            addCriterion("CARTON_OBJ02 in", values, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02NotIn(List<String> values) {
            addCriterion("CARTON_OBJ02 not in", values, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02Between(String value1, String value2) {
            addCriterion("CARTON_OBJ02 between", value1, value2, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj02NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ02 not between", value1, value2, "cartonObj02");
            return (Criteria) this;
        }

        public Criteria andCartonObj03IsNull() {
            addCriterion("CARTON_OBJ03 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj03IsNotNull() {
            addCriterion("CARTON_OBJ03 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj03EqualTo(String value) {
            addCriterion("CARTON_OBJ03 =", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03NotEqualTo(String value) {
            addCriterion("CARTON_OBJ03 <>", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03GreaterThan(String value) {
            addCriterion("CARTON_OBJ03 >", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ03 >=", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03LessThan(String value) {
            addCriterion("CARTON_OBJ03 <", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ03 <=", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03Like(String value) {
            addCriterion("CARTON_OBJ03 like", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03NotLike(String value) {
            addCriterion("CARTON_OBJ03 not like", value, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03In(List<String> values) {
            addCriterion("CARTON_OBJ03 in", values, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03NotIn(List<String> values) {
            addCriterion("CARTON_OBJ03 not in", values, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03Between(String value1, String value2) {
            addCriterion("CARTON_OBJ03 between", value1, value2, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj03NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ03 not between", value1, value2, "cartonObj03");
            return (Criteria) this;
        }

        public Criteria andCartonObj04IsNull() {
            addCriterion("CARTON_OBJ04 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj04IsNotNull() {
            addCriterion("CARTON_OBJ04 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj04EqualTo(String value) {
            addCriterion("CARTON_OBJ04 =", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04NotEqualTo(String value) {
            addCriterion("CARTON_OBJ04 <>", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04GreaterThan(String value) {
            addCriterion("CARTON_OBJ04 >", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ04 >=", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04LessThan(String value) {
            addCriterion("CARTON_OBJ04 <", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ04 <=", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04Like(String value) {
            addCriterion("CARTON_OBJ04 like", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04NotLike(String value) {
            addCriterion("CARTON_OBJ04 not like", value, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04In(List<String> values) {
            addCriterion("CARTON_OBJ04 in", values, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04NotIn(List<String> values) {
            addCriterion("CARTON_OBJ04 not in", values, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04Between(String value1, String value2) {
            addCriterion("CARTON_OBJ04 between", value1, value2, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj04NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ04 not between", value1, value2, "cartonObj04");
            return (Criteria) this;
        }

        public Criteria andCartonObj05IsNull() {
            addCriterion("CARTON_OBJ05 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj05IsNotNull() {
            addCriterion("CARTON_OBJ05 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj05EqualTo(String value) {
            addCriterion("CARTON_OBJ05 =", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05NotEqualTo(String value) {
            addCriterion("CARTON_OBJ05 <>", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05GreaterThan(String value) {
            addCriterion("CARTON_OBJ05 >", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ05 >=", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05LessThan(String value) {
            addCriterion("CARTON_OBJ05 <", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ05 <=", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05Like(String value) {
            addCriterion("CARTON_OBJ05 like", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05NotLike(String value) {
            addCriterion("CARTON_OBJ05 not like", value, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05In(List<String> values) {
            addCriterion("CARTON_OBJ05 in", values, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05NotIn(List<String> values) {
            addCriterion("CARTON_OBJ05 not in", values, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05Between(String value1, String value2) {
            addCriterion("CARTON_OBJ05 between", value1, value2, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj05NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ05 not between", value1, value2, "cartonObj05");
            return (Criteria) this;
        }

        public Criteria andCartonObj06IsNull() {
            addCriterion("CARTON_OBJ06 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj06IsNotNull() {
            addCriterion("CARTON_OBJ06 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj06EqualTo(String value) {
            addCriterion("CARTON_OBJ06 =", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06NotEqualTo(String value) {
            addCriterion("CARTON_OBJ06 <>", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06GreaterThan(String value) {
            addCriterion("CARTON_OBJ06 >", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ06 >=", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06LessThan(String value) {
            addCriterion("CARTON_OBJ06 <", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ06 <=", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06Like(String value) {
            addCriterion("CARTON_OBJ06 like", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06NotLike(String value) {
            addCriterion("CARTON_OBJ06 not like", value, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06In(List<String> values) {
            addCriterion("CARTON_OBJ06 in", values, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06NotIn(List<String> values) {
            addCriterion("CARTON_OBJ06 not in", values, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06Between(String value1, String value2) {
            addCriterion("CARTON_OBJ06 between", value1, value2, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj06NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ06 not between", value1, value2, "cartonObj06");
            return (Criteria) this;
        }

        public Criteria andCartonObj07IsNull() {
            addCriterion("CARTON_OBJ07 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj07IsNotNull() {
            addCriterion("CARTON_OBJ07 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj07EqualTo(String value) {
            addCriterion("CARTON_OBJ07 =", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07NotEqualTo(String value) {
            addCriterion("CARTON_OBJ07 <>", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07GreaterThan(String value) {
            addCriterion("CARTON_OBJ07 >", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ07 >=", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07LessThan(String value) {
            addCriterion("CARTON_OBJ07 <", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ07 <=", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07Like(String value) {
            addCriterion("CARTON_OBJ07 like", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07NotLike(String value) {
            addCriterion("CARTON_OBJ07 not like", value, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07In(List<String> values) {
            addCriterion("CARTON_OBJ07 in", values, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07NotIn(List<String> values) {
            addCriterion("CARTON_OBJ07 not in", values, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07Between(String value1, String value2) {
            addCriterion("CARTON_OBJ07 between", value1, value2, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj07NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ07 not between", value1, value2, "cartonObj07");
            return (Criteria) this;
        }

        public Criteria andCartonObj08IsNull() {
            addCriterion("CARTON_OBJ08 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj08IsNotNull() {
            addCriterion("CARTON_OBJ08 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj08EqualTo(String value) {
            addCriterion("CARTON_OBJ08 =", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08NotEqualTo(String value) {
            addCriterion("CARTON_OBJ08 <>", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08GreaterThan(String value) {
            addCriterion("CARTON_OBJ08 >", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ08 >=", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08LessThan(String value) {
            addCriterion("CARTON_OBJ08 <", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ08 <=", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08Like(String value) {
            addCriterion("CARTON_OBJ08 like", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08NotLike(String value) {
            addCriterion("CARTON_OBJ08 not like", value, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08In(List<String> values) {
            addCriterion("CARTON_OBJ08 in", values, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08NotIn(List<String> values) {
            addCriterion("CARTON_OBJ08 not in", values, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08Between(String value1, String value2) {
            addCriterion("CARTON_OBJ08 between", value1, value2, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj08NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ08 not between", value1, value2, "cartonObj08");
            return (Criteria) this;
        }

        public Criteria andCartonObj09IsNull() {
            addCriterion("CARTON_OBJ09 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj09IsNotNull() {
            addCriterion("CARTON_OBJ09 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj09EqualTo(String value) {
            addCriterion("CARTON_OBJ09 =", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09NotEqualTo(String value) {
            addCriterion("CARTON_OBJ09 <>", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09GreaterThan(String value) {
            addCriterion("CARTON_OBJ09 >", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ09 >=", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09LessThan(String value) {
            addCriterion("CARTON_OBJ09 <", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ09 <=", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09Like(String value) {
            addCriterion("CARTON_OBJ09 like", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09NotLike(String value) {
            addCriterion("CARTON_OBJ09 not like", value, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09In(List<String> values) {
            addCriterion("CARTON_OBJ09 in", values, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09NotIn(List<String> values) {
            addCriterion("CARTON_OBJ09 not in", values, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09Between(String value1, String value2) {
            addCriterion("CARTON_OBJ09 between", value1, value2, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj09NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ09 not between", value1, value2, "cartonObj09");
            return (Criteria) this;
        }

        public Criteria andCartonObj10IsNull() {
            addCriterion("CARTON_OBJ10 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj10IsNotNull() {
            addCriterion("CARTON_OBJ10 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj10EqualTo(String value) {
            addCriterion("CARTON_OBJ10 =", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10NotEqualTo(String value) {
            addCriterion("CARTON_OBJ10 <>", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10GreaterThan(String value) {
            addCriterion("CARTON_OBJ10 >", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ10 >=", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10LessThan(String value) {
            addCriterion("CARTON_OBJ10 <", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ10 <=", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10Like(String value) {
            addCriterion("CARTON_OBJ10 like", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10NotLike(String value) {
            addCriterion("CARTON_OBJ10 not like", value, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10In(List<String> values) {
            addCriterion("CARTON_OBJ10 in", values, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10NotIn(List<String> values) {
            addCriterion("CARTON_OBJ10 not in", values, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10Between(String value1, String value2) {
            addCriterion("CARTON_OBJ10 between", value1, value2, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj10NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ10 not between", value1, value2, "cartonObj10");
            return (Criteria) this;
        }

        public Criteria andCartonObj11IsNull() {
            addCriterion("CARTON_OBJ11 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj11IsNotNull() {
            addCriterion("CARTON_OBJ11 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj11EqualTo(String value) {
            addCriterion("CARTON_OBJ11 =", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11NotEqualTo(String value) {
            addCriterion("CARTON_OBJ11 <>", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11GreaterThan(String value) {
            addCriterion("CARTON_OBJ11 >", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ11 >=", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11LessThan(String value) {
            addCriterion("CARTON_OBJ11 <", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ11 <=", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11Like(String value) {
            addCriterion("CARTON_OBJ11 like", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11NotLike(String value) {
            addCriterion("CARTON_OBJ11 not like", value, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11In(List<String> values) {
            addCriterion("CARTON_OBJ11 in", values, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11NotIn(List<String> values) {
            addCriterion("CARTON_OBJ11 not in", values, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11Between(String value1, String value2) {
            addCriterion("CARTON_OBJ11 between", value1, value2, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj11NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ11 not between", value1, value2, "cartonObj11");
            return (Criteria) this;
        }

        public Criteria andCartonObj12IsNull() {
            addCriterion("CARTON_OBJ12 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj12IsNotNull() {
            addCriterion("CARTON_OBJ12 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj12EqualTo(String value) {
            addCriterion("CARTON_OBJ12 =", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12NotEqualTo(String value) {
            addCriterion("CARTON_OBJ12 <>", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12GreaterThan(String value) {
            addCriterion("CARTON_OBJ12 >", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ12 >=", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12LessThan(String value) {
            addCriterion("CARTON_OBJ12 <", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ12 <=", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12Like(String value) {
            addCriterion("CARTON_OBJ12 like", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12NotLike(String value) {
            addCriterion("CARTON_OBJ12 not like", value, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12In(List<String> values) {
            addCriterion("CARTON_OBJ12 in", values, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12NotIn(List<String> values) {
            addCriterion("CARTON_OBJ12 not in", values, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12Between(String value1, String value2) {
            addCriterion("CARTON_OBJ12 between", value1, value2, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj12NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ12 not between", value1, value2, "cartonObj12");
            return (Criteria) this;
        }

        public Criteria andCartonObj13IsNull() {
            addCriterion("CARTON_OBJ13 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj13IsNotNull() {
            addCriterion("CARTON_OBJ13 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj13EqualTo(String value) {
            addCriterion("CARTON_OBJ13 =", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13NotEqualTo(String value) {
            addCriterion("CARTON_OBJ13 <>", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13GreaterThan(String value) {
            addCriterion("CARTON_OBJ13 >", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ13 >=", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13LessThan(String value) {
            addCriterion("CARTON_OBJ13 <", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ13 <=", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13Like(String value) {
            addCriterion("CARTON_OBJ13 like", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13NotLike(String value) {
            addCriterion("CARTON_OBJ13 not like", value, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13In(List<String> values) {
            addCriterion("CARTON_OBJ13 in", values, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13NotIn(List<String> values) {
            addCriterion("CARTON_OBJ13 not in", values, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13Between(String value1, String value2) {
            addCriterion("CARTON_OBJ13 between", value1, value2, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj13NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ13 not between", value1, value2, "cartonObj13");
            return (Criteria) this;
        }

        public Criteria andCartonObj14IsNull() {
            addCriterion("CARTON_OBJ14 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj14IsNotNull() {
            addCriterion("CARTON_OBJ14 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj14EqualTo(String value) {
            addCriterion("CARTON_OBJ14 =", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14NotEqualTo(String value) {
            addCriterion("CARTON_OBJ14 <>", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14GreaterThan(String value) {
            addCriterion("CARTON_OBJ14 >", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ14 >=", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14LessThan(String value) {
            addCriterion("CARTON_OBJ14 <", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ14 <=", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14Like(String value) {
            addCriterion("CARTON_OBJ14 like", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14NotLike(String value) {
            addCriterion("CARTON_OBJ14 not like", value, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14In(List<String> values) {
            addCriterion("CARTON_OBJ14 in", values, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14NotIn(List<String> values) {
            addCriterion("CARTON_OBJ14 not in", values, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14Between(String value1, String value2) {
            addCriterion("CARTON_OBJ14 between", value1, value2, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj14NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ14 not between", value1, value2, "cartonObj14");
            return (Criteria) this;
        }

        public Criteria andCartonObj15IsNull() {
            addCriterion("CARTON_OBJ15 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj15IsNotNull() {
            addCriterion("CARTON_OBJ15 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj15EqualTo(String value) {
            addCriterion("CARTON_OBJ15 =", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15NotEqualTo(String value) {
            addCriterion("CARTON_OBJ15 <>", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15GreaterThan(String value) {
            addCriterion("CARTON_OBJ15 >", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ15 >=", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15LessThan(String value) {
            addCriterion("CARTON_OBJ15 <", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ15 <=", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15Like(String value) {
            addCriterion("CARTON_OBJ15 like", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15NotLike(String value) {
            addCriterion("CARTON_OBJ15 not like", value, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15In(List<String> values) {
            addCriterion("CARTON_OBJ15 in", values, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15NotIn(List<String> values) {
            addCriterion("CARTON_OBJ15 not in", values, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15Between(String value1, String value2) {
            addCriterion("CARTON_OBJ15 between", value1, value2, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj15NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ15 not between", value1, value2, "cartonObj15");
            return (Criteria) this;
        }

        public Criteria andCartonObj16IsNull() {
            addCriterion("CARTON_OBJ16 is null");
            return (Criteria) this;
        }

        public Criteria andCartonObj16IsNotNull() {
            addCriterion("CARTON_OBJ16 is not null");
            return (Criteria) this;
        }

        public Criteria andCartonObj16EqualTo(String value) {
            addCriterion("CARTON_OBJ16 =", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16NotEqualTo(String value) {
            addCriterion("CARTON_OBJ16 <>", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16GreaterThan(String value) {
            addCriterion("CARTON_OBJ16 >", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16GreaterThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ16 >=", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16LessThan(String value) {
            addCriterion("CARTON_OBJ16 <", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16LessThanOrEqualTo(String value) {
            addCriterion("CARTON_OBJ16 <=", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16Like(String value) {
            addCriterion("CARTON_OBJ16 like", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16NotLike(String value) {
            addCriterion("CARTON_OBJ16 not like", value, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16In(List<String> values) {
            addCriterion("CARTON_OBJ16 in", values, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16NotIn(List<String> values) {
            addCriterion("CARTON_OBJ16 not in", values, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16Between(String value1, String value2) {
            addCriterion("CARTON_OBJ16 between", value1, value2, "cartonObj16");
            return (Criteria) this;
        }

        public Criteria andCartonObj16NotBetween(String value1, String value2) {
            addCriterion("CARTON_OBJ16 not between", value1, value2, "cartonObj16");
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