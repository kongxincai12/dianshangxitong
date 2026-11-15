package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mes_aviExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Mes_aviExample() {
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

        public Criteria andProductnumberIsNull() {
            addCriterion("PRODUCTNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andProductnumberIsNotNull() {
            addCriterion("PRODUCTNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andProductnumberEqualTo(String value) {
            addCriterion("PRODUCTNUMBER =", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberNotEqualTo(String value) {
            addCriterion("PRODUCTNUMBER <>", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberGreaterThan(String value) {
            addCriterion("PRODUCTNUMBER >", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTNUMBER >=", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberLessThan(String value) {
            addCriterion("PRODUCTNUMBER <", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTNUMBER <=", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberLike(String value) {
            addCriterion("PRODUCTNUMBER like", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberNotLike(String value) {
            addCriterion("PRODUCTNUMBER not like", value, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberIn(List<String> values) {
            addCriterion("PRODUCTNUMBER in", values, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberNotIn(List<String> values) {
            addCriterion("PRODUCTNUMBER not in", values, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberBetween(String value1, String value2) {
            addCriterion("PRODUCTNUMBER between", value1, value2, "productnumber");
            return (Criteria) this;
        }

        public Criteria andProductnumberNotBetween(String value1, String value2) {
            addCriterion("PRODUCTNUMBER not between", value1, value2, "productnumber");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNull() {
            addCriterion("QRCODE is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNotNull() {
            addCriterion("QRCODE is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEqualTo(String value) {
            addCriterion("QRCODE =", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotEqualTo(String value) {
            addCriterion("QRCODE <>", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThan(String value) {
            addCriterion("QRCODE >", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("QRCODE >=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThan(String value) {
            addCriterion("QRCODE <", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThanOrEqualTo(String value) {
            addCriterion("QRCODE <=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLike(String value) {
            addCriterion("QRCODE like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotLike(String value) {
            addCriterion("QRCODE not like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeIn(List<String> values) {
            addCriterion("QRCODE in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotIn(List<String> values) {
            addCriterion("QRCODE not in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeBetween(String value1, String value2) {
            addCriterion("QRCODE between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotBetween(String value1, String value2) {
            addCriterion("QRCODE not between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andLotIsNull() {
            addCriterion("LOT is null");
            return (Criteria) this;
        }

        public Criteria andLotIsNotNull() {
            addCriterion("LOT is not null");
            return (Criteria) this;
        }

        public Criteria andLotEqualTo(String value) {
            addCriterion("LOT =", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotEqualTo(String value) {
            addCriterion("LOT <>", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotGreaterThan(String value) {
            addCriterion("LOT >", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotGreaterThanOrEqualTo(String value) {
            addCriterion("LOT >=", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotLessThan(String value) {
            addCriterion("LOT <", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotLessThanOrEqualTo(String value) {
            addCriterion("LOT <=", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotLike(String value) {
            addCriterion("LOT like", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotLike(String value) {
            addCriterion("LOT not like", value, "lot");
            return (Criteria) this;
        }

        public Criteria andLotIn(List<String> values) {
            addCriterion("LOT in", values, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotIn(List<String> values) {
            addCriterion("LOT not in", values, "lot");
            return (Criteria) this;
        }

        public Criteria andLotBetween(String value1, String value2) {
            addCriterion("LOT between", value1, value2, "lot");
            return (Criteria) this;
        }

        public Criteria andLotNotBetween(String value1, String value2) {
            addCriterion("LOT not between", value1, value2, "lot");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrIsNull() {
            addCriterion("CREATETIMESTR is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrIsNotNull() {
            addCriterion("CREATETIMESTR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrEqualTo(String value) {
            addCriterion("CREATETIMESTR =", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrNotEqualTo(String value) {
            addCriterion("CREATETIMESTR <>", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrGreaterThan(String value) {
            addCriterion("CREATETIMESTR >", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrGreaterThanOrEqualTo(String value) {
            addCriterion("CREATETIMESTR >=", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrLessThan(String value) {
            addCriterion("CREATETIMESTR <", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrLessThanOrEqualTo(String value) {
            addCriterion("CREATETIMESTR <=", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrLike(String value) {
            addCriterion("CREATETIMESTR like", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrNotLike(String value) {
            addCriterion("CREATETIMESTR not like", value, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrIn(List<String> values) {
            addCriterion("CREATETIMESTR in", values, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrNotIn(List<String> values) {
            addCriterion("CREATETIMESTR not in", values, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrBetween(String value1, String value2) {
            addCriterion("CREATETIMESTR between", value1, value2, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreatetimestrNotBetween(String value1, String value2) {
            addCriterion("CREATETIMESTR not between", value1, value2, "createtimestr");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("CREATER is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("CREATER is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("CREATER =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("CREATER <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("CREATER >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("CREATER >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("CREATER <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("CREATER <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("CREATER like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("CREATER not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("CREATER in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("CREATER not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("CREATER between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("CREATER not between", value1, value2, "creater");
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

        public Criteria andSegment1IsNull() {
            addCriterion("SEGMENT1 is null");
            return (Criteria) this;
        }

        public Criteria andSegment1IsNotNull() {
            addCriterion("SEGMENT1 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment1EqualTo(String value) {
            addCriterion("SEGMENT1 =", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotEqualTo(String value) {
            addCriterion("SEGMENT1 <>", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1GreaterThan(String value) {
            addCriterion("SEGMENT1 >", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1GreaterThanOrEqualTo(String value) {
            addCriterion("SEGMENT1 >=", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1LessThan(String value) {
            addCriterion("SEGMENT1 <", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1LessThanOrEqualTo(String value) {
            addCriterion("SEGMENT1 <=", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1Like(String value) {
            addCriterion("SEGMENT1 like", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotLike(String value) {
            addCriterion("SEGMENT1 not like", value, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1In(List<String> values) {
            addCriterion("SEGMENT1 in", values, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotIn(List<String> values) {
            addCriterion("SEGMENT1 not in", values, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1Between(String value1, String value2) {
            addCriterion("SEGMENT1 between", value1, value2, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment1NotBetween(String value1, String value2) {
            addCriterion("SEGMENT1 not between", value1, value2, "segment1");
            return (Criteria) this;
        }

        public Criteria andSegment2IsNull() {
            addCriterion("SEGMENT2 is null");
            return (Criteria) this;
        }

        public Criteria andSegment2IsNotNull() {
            addCriterion("SEGMENT2 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment2EqualTo(String value) {
            addCriterion("SEGMENT2 =", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotEqualTo(String value) {
            addCriterion("SEGMENT2 <>", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2GreaterThan(String value) {
            addCriterion("SEGMENT2 >", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2GreaterThanOrEqualTo(String value) {
            addCriterion("SEGMENT2 >=", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2LessThan(String value) {
            addCriterion("SEGMENT2 <", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2LessThanOrEqualTo(String value) {
            addCriterion("SEGMENT2 <=", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2Like(String value) {
            addCriterion("SEGMENT2 like", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotLike(String value) {
            addCriterion("SEGMENT2 not like", value, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2In(List<String> values) {
            addCriterion("SEGMENT2 in", values, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotIn(List<String> values) {
            addCriterion("SEGMENT2 not in", values, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2Between(String value1, String value2) {
            addCriterion("SEGMENT2 between", value1, value2, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment2NotBetween(String value1, String value2) {
            addCriterion("SEGMENT2 not between", value1, value2, "segment2");
            return (Criteria) this;
        }

        public Criteria andSegment3IsNull() {
            addCriterion("SEGMENT3 is null");
            return (Criteria) this;
        }

        public Criteria andSegment3IsNotNull() {
            addCriterion("SEGMENT3 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment3EqualTo(String value) {
            addCriterion("SEGMENT3 =", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotEqualTo(String value) {
            addCriterion("SEGMENT3 <>", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3GreaterThan(String value) {
            addCriterion("SEGMENT3 >", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3GreaterThanOrEqualTo(String value) {
            addCriterion("SEGMENT3 >=", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3LessThan(String value) {
            addCriterion("SEGMENT3 <", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3LessThanOrEqualTo(String value) {
            addCriterion("SEGMENT3 <=", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3Like(String value) {
            addCriterion("SEGMENT3 like", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotLike(String value) {
            addCriterion("SEGMENT3 not like", value, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3In(List<String> values) {
            addCriterion("SEGMENT3 in", values, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotIn(List<String> values) {
            addCriterion("SEGMENT3 not in", values, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3Between(String value1, String value2) {
            addCriterion("SEGMENT3 between", value1, value2, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment3NotBetween(String value1, String value2) {
            addCriterion("SEGMENT3 not between", value1, value2, "segment3");
            return (Criteria) this;
        }

        public Criteria andSegment4IsNull() {
            addCriterion("SEGMENT4 is null");
            return (Criteria) this;
        }

        public Criteria andSegment4IsNotNull() {
            addCriterion("SEGMENT4 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment4EqualTo(String value) {
            addCriterion("SEGMENT4 =", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotEqualTo(String value) {
            addCriterion("SEGMENT4 <>", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4GreaterThan(String value) {
            addCriterion("SEGMENT4 >", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4GreaterThanOrEqualTo(String value) {
            addCriterion("SEGMENT4 >=", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4LessThan(String value) {
            addCriterion("SEGMENT4 <", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4LessThanOrEqualTo(String value) {
            addCriterion("SEGMENT4 <=", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4Like(String value) {
            addCriterion("SEGMENT4 like", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotLike(String value) {
            addCriterion("SEGMENT4 not like", value, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4In(List<String> values) {
            addCriterion("SEGMENT4 in", values, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotIn(List<String> values) {
            addCriterion("SEGMENT4 not in", values, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4Between(String value1, String value2) {
            addCriterion("SEGMENT4 between", value1, value2, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment4NotBetween(String value1, String value2) {
            addCriterion("SEGMENT4 not between", value1, value2, "segment4");
            return (Criteria) this;
        }

        public Criteria andSegment5IsNull() {
            addCriterion("SEGMENT5 is null");
            return (Criteria) this;
        }

        public Criteria andSegment5IsNotNull() {
            addCriterion("SEGMENT5 is not null");
            return (Criteria) this;
        }

        public Criteria andSegment5EqualTo(String value) {
            addCriterion("SEGMENT5 =", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5NotEqualTo(String value) {
            addCriterion("SEGMENT5 <>", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5GreaterThan(String value) {
            addCriterion("SEGMENT5 >", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5GreaterThanOrEqualTo(String value) {
            addCriterion("SEGMENT5 >=", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5LessThan(String value) {
            addCriterion("SEGMENT5 <", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5LessThanOrEqualTo(String value) {
            addCriterion("SEGMENT5 <=", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5Like(String value) {
            addCriterion("SEGMENT5 like", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5NotLike(String value) {
            addCriterion("SEGMENT5 not like", value, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5In(List<String> values) {
            addCriterion("SEGMENT5 in", values, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5NotIn(List<String> values) {
            addCriterion("SEGMENT5 not in", values, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5Between(String value1, String value2) {
            addCriterion("SEGMENT5 between", value1, value2, "segment5");
            return (Criteria) this;
        }

        public Criteria andSegment5NotBetween(String value1, String value2) {
            addCriterion("SEGMENT5 not between", value1, value2, "segment5");
            return (Criteria) this;
        }

        public Criteria andScanTotalIsNull() {
            addCriterion("SCAN_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andScanTotalIsNotNull() {
            addCriterion("SCAN_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andScanTotalEqualTo(Short value) {
            addCriterion("SCAN_TOTAL =", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalNotEqualTo(Short value) {
            addCriterion("SCAN_TOTAL <>", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalGreaterThan(Short value) {
            addCriterion("SCAN_TOTAL >", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("SCAN_TOTAL >=", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalLessThan(Short value) {
            addCriterion("SCAN_TOTAL <", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalLessThanOrEqualTo(Short value) {
            addCriterion("SCAN_TOTAL <=", value, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalIn(List<Short> values) {
            addCriterion("SCAN_TOTAL in", values, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalNotIn(List<Short> values) {
            addCriterion("SCAN_TOTAL not in", values, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalBetween(Short value1, Short value2) {
            addCriterion("SCAN_TOTAL between", value1, value2, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andScanTotalNotBetween(Short value1, Short value2) {
            addCriterion("SCAN_TOTAL not between", value1, value2, "scanTotal");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNull() {
            addCriterion("GOOD_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNotNull() {
            addCriterion("GOOD_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodCountEqualTo(Short value) {
            addCriterion("GOOD_COUNT =", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotEqualTo(Short value) {
            addCriterion("GOOD_COUNT <>", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThan(Short value) {
            addCriterion("GOOD_COUNT >", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThanOrEqualTo(Short value) {
            addCriterion("GOOD_COUNT >=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThan(Short value) {
            addCriterion("GOOD_COUNT <", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThanOrEqualTo(Short value) {
            addCriterion("GOOD_COUNT <=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountIn(List<Short> values) {
            addCriterion("GOOD_COUNT in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotIn(List<Short> values) {
            addCriterion("GOOD_COUNT not in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountBetween(Short value1, Short value2) {
            addCriterion("GOOD_COUNT between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotBetween(Short value1, Short value2) {
            addCriterion("GOOD_COUNT not between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountIsNull() {
            addCriterion("DEFECTIVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountIsNotNull() {
            addCriterion("DEFECTIVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountEqualTo(Short value) {
            addCriterion("DEFECTIVE_COUNT =", value, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountNotEqualTo(Short value) {
            addCriterion("DEFECTIVE_COUNT <>", value, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountGreaterThan(Short value) {
            addCriterion("DEFECTIVE_COUNT >", value, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountGreaterThanOrEqualTo(Short value) {
            addCriterion("DEFECTIVE_COUNT >=", value, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountLessThan(Short value) {
            addCriterion("DEFECTIVE_COUNT <", value, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountLessThanOrEqualTo(Short value) {
            addCriterion("DEFECTIVE_COUNT <=", value, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountIn(List<Short> values) {
            addCriterion("DEFECTIVE_COUNT in", values, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountNotIn(List<Short> values) {
            addCriterion("DEFECTIVE_COUNT not in", values, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountBetween(Short value1, Short value2) {
            addCriterion("DEFECTIVE_COUNT between", value1, value2, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andDefectiveCountNotBetween(Short value1, Short value2) {
            addCriterion("DEFECTIVE_COUNT not between", value1, value2, "defectiveCount");
            return (Criteria) this;
        }

        public Criteria andPassRateIsNull() {
            addCriterion("PASS_RATE is null");
            return (Criteria) this;
        }

        public Criteria andPassRateIsNotNull() {
            addCriterion("PASS_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andPassRateEqualTo(Short value) {
            addCriterion("PASS_RATE =", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateNotEqualTo(Short value) {
            addCriterion("PASS_RATE <>", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateGreaterThan(Short value) {
            addCriterion("PASS_RATE >", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateGreaterThanOrEqualTo(Short value) {
            addCriterion("PASS_RATE >=", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateLessThan(Short value) {
            addCriterion("PASS_RATE <", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateLessThanOrEqualTo(Short value) {
            addCriterion("PASS_RATE <=", value, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateIn(List<Short> values) {
            addCriterion("PASS_RATE in", values, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateNotIn(List<Short> values) {
            addCriterion("PASS_RATE not in", values, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateBetween(Short value1, Short value2) {
            addCriterion("PASS_RATE between", value1, value2, "passRate");
            return (Criteria) this;
        }

        public Criteria andPassRateNotBetween(Short value1, Short value2) {
            addCriterion("PASS_RATE not between", value1, value2, "passRate");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("TOTAL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("TOTAL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(Short value) {
            addCriterion("TOTAL_TIME =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(Short value) {
            addCriterion("TOTAL_TIME <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(Short value) {
            addCriterion("TOTAL_TIME >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(Short value) {
            addCriterion("TOTAL_TIME >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(Short value) {
            addCriterion("TOTAL_TIME <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(Short value) {
            addCriterion("TOTAL_TIME <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<Short> values) {
            addCriterion("TOTAL_TIME in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<Short> values) {
            addCriterion("TOTAL_TIME not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(Short value1, Short value2) {
            addCriterion("TOTAL_TIME between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(Short value1, Short value2) {
            addCriterion("TOTAL_TIME not between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceIsNull() {
            addCriterion("AVG_TIME_PER_PIECE is null");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceIsNotNull() {
            addCriterion("AVG_TIME_PER_PIECE is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceEqualTo(Short value) {
            addCriterion("AVG_TIME_PER_PIECE =", value, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceNotEqualTo(Short value) {
            addCriterion("AVG_TIME_PER_PIECE <>", value, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceGreaterThan(Short value) {
            addCriterion("AVG_TIME_PER_PIECE >", value, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceGreaterThanOrEqualTo(Short value) {
            addCriterion("AVG_TIME_PER_PIECE >=", value, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceLessThan(Short value) {
            addCriterion("AVG_TIME_PER_PIECE <", value, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceLessThanOrEqualTo(Short value) {
            addCriterion("AVG_TIME_PER_PIECE <=", value, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceIn(List<Short> values) {
            addCriterion("AVG_TIME_PER_PIECE in", values, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceNotIn(List<Short> values) {
            addCriterion("AVG_TIME_PER_PIECE not in", values, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceBetween(Short value1, Short value2) {
            addCriterion("AVG_TIME_PER_PIECE between", value1, value2, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andAvgTimePerPieceNotBetween(Short value1, Short value2) {
            addCriterion("AVG_TIME_PER_PIECE not between", value1, value2, "avgTimePerPiece");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountIsNull() {
            addCriterion("SIDE_AB_DEFECT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountIsNotNull() {
            addCriterion("SIDE_AB_DEFECT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountEqualTo(Short value) {
            addCriterion("SIDE_AB_DEFECT_COUNT =", value, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountNotEqualTo(Short value) {
            addCriterion("SIDE_AB_DEFECT_COUNT <>", value, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountGreaterThan(Short value) {
            addCriterion("SIDE_AB_DEFECT_COUNT >", value, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountGreaterThanOrEqualTo(Short value) {
            addCriterion("SIDE_AB_DEFECT_COUNT >=", value, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountLessThan(Short value) {
            addCriterion("SIDE_AB_DEFECT_COUNT <", value, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountLessThanOrEqualTo(Short value) {
            addCriterion("SIDE_AB_DEFECT_COUNT <=", value, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountIn(List<Short> values) {
            addCriterion("SIDE_AB_DEFECT_COUNT in", values, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountNotIn(List<Short> values) {
            addCriterion("SIDE_AB_DEFECT_COUNT not in", values, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountBetween(Short value1, Short value2) {
            addCriterion("SIDE_AB_DEFECT_COUNT between", value1, value2, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andSideAbDefectCountNotBetween(Short value1, Short value2) {
            addCriterion("SIDE_AB_DEFECT_COUNT not between", value1, value2, "sideAbDefectCount");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoIsNull() {
            addCriterion("DEVICE_EXCEPTION_INFO is null");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoIsNotNull() {
            addCriterion("DEVICE_EXCEPTION_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoEqualTo(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO =", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoNotEqualTo(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO <>", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoGreaterThan(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO >", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO >=", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoLessThan(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO <", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO <=", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoLike(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO like", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoNotLike(String value) {
            addCriterion("DEVICE_EXCEPTION_INFO not like", value, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoIn(List<String> values) {
            addCriterion("DEVICE_EXCEPTION_INFO in", values, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoNotIn(List<String> values) {
            addCriterion("DEVICE_EXCEPTION_INFO not in", values, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoBetween(String value1, String value2) {
            addCriterion("DEVICE_EXCEPTION_INFO between", value1, value2, "deviceExceptionInfo");
            return (Criteria) this;
        }

        public Criteria andDeviceExceptionInfoNotBetween(String value1, String value2) {
            addCriterion("DEVICE_EXCEPTION_INFO not between", value1, value2, "deviceExceptionInfo");
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