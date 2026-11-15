package com.jcd.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeederExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeederExample() {
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

        public Criteria andFeederidIsNull() {
            addCriterion("FEEDERID is null");
            return (Criteria) this;
        }

        public Criteria andFeederidIsNotNull() {
            addCriterion("FEEDERID is not null");
            return (Criteria) this;
        }

        public Criteria andFeederidEqualTo(String value) {
            addCriterion("FEEDERID =", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidNotEqualTo(String value) {
            addCriterion("FEEDERID <>", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidGreaterThan(String value) {
            addCriterion("FEEDERID >", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDERID >=", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidLessThan(String value) {
            addCriterion("FEEDERID <", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidLessThanOrEqualTo(String value) {
            addCriterion("FEEDERID <=", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidLike(String value) {
            addCriterion("FEEDERID like", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidNotLike(String value) {
            addCriterion("FEEDERID not like", value, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidIn(List<String> values) {
            addCriterion("FEEDERID in", values, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidNotIn(List<String> values) {
            addCriterion("FEEDERID not in", values, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidBetween(String value1, String value2) {
            addCriterion("FEEDERID between", value1, value2, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeederidNotBetween(String value1, String value2) {
            addCriterion("FEEDERID not between", value1, value2, "feederid");
            return (Criteria) this;
        }

        public Criteria andFeedernameIsNull() {
            addCriterion("FEEDERNAME is null");
            return (Criteria) this;
        }

        public Criteria andFeedernameIsNotNull() {
            addCriterion("FEEDERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFeedernameEqualTo(String value) {
            addCriterion("FEEDERNAME =", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameNotEqualTo(String value) {
            addCriterion("FEEDERNAME <>", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameGreaterThan(String value) {
            addCriterion("FEEDERNAME >", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDERNAME >=", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameLessThan(String value) {
            addCriterion("FEEDERNAME <", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameLessThanOrEqualTo(String value) {
            addCriterion("FEEDERNAME <=", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameLike(String value) {
            addCriterion("FEEDERNAME like", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameNotLike(String value) {
            addCriterion("FEEDERNAME not like", value, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameIn(List<String> values) {
            addCriterion("FEEDERNAME in", values, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameNotIn(List<String> values) {
            addCriterion("FEEDERNAME not in", values, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameBetween(String value1, String value2) {
            addCriterion("FEEDERNAME between", value1, value2, "feedername");
            return (Criteria) this;
        }

        public Criteria andFeedernameNotBetween(String value1, String value2) {
            addCriterion("FEEDERNAME not between", value1, value2, "feedername");
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

        public Criteria andFeedertypeIsNull() {
            addCriterion("FEEDERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andFeedertypeIsNotNull() {
            addCriterion("FEEDERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFeedertypeEqualTo(String value) {
            addCriterion("FEEDERTYPE =", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeNotEqualTo(String value) {
            addCriterion("FEEDERTYPE <>", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeGreaterThan(String value) {
            addCriterion("FEEDERTYPE >", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDERTYPE >=", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeLessThan(String value) {
            addCriterion("FEEDERTYPE <", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeLessThanOrEqualTo(String value) {
            addCriterion("FEEDERTYPE <=", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeLike(String value) {
            addCriterion("FEEDERTYPE like", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeNotLike(String value) {
            addCriterion("FEEDERTYPE not like", value, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeIn(List<String> values) {
            addCriterion("FEEDERTYPE in", values, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeNotIn(List<String> values) {
            addCriterion("FEEDERTYPE not in", values, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeBetween(String value1, String value2) {
            addCriterion("FEEDERTYPE between", value1, value2, "feedertype");
            return (Criteria) this;
        }

        public Criteria andFeedertypeNotBetween(String value1, String value2) {
            addCriterion("FEEDERTYPE not between", value1, value2, "feedertype");
            return (Criteria) this;
        }

        public Criteria andEqptypeidIsNull() {
            addCriterion("EQPTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andEqptypeidIsNotNull() {
            addCriterion("EQPTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andEqptypeidEqualTo(String value) {
            addCriterion("EQPTYPEID =", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidNotEqualTo(String value) {
            addCriterion("EQPTYPEID <>", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidGreaterThan(String value) {
            addCriterion("EQPTYPEID >", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidGreaterThanOrEqualTo(String value) {
            addCriterion("EQPTYPEID >=", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidLessThan(String value) {
            addCriterion("EQPTYPEID <", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidLessThanOrEqualTo(String value) {
            addCriterion("EQPTYPEID <=", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidLike(String value) {
            addCriterion("EQPTYPEID like", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidNotLike(String value) {
            addCriterion("EQPTYPEID not like", value, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidIn(List<String> values) {
            addCriterion("EQPTYPEID in", values, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidNotIn(List<String> values) {
            addCriterion("EQPTYPEID not in", values, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidBetween(String value1, String value2) {
            addCriterion("EQPTYPEID between", value1, value2, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andEqptypeidNotBetween(String value1, String value2) {
            addCriterion("EQPTYPEID not between", value1, value2, "eqptypeid");
            return (Criteria) this;
        }

        public Criteria andNeedpmIsNull() {
            addCriterion("NEEDPM is null");
            return (Criteria) this;
        }

        public Criteria andNeedpmIsNotNull() {
            addCriterion("NEEDPM is not null");
            return (Criteria) this;
        }

        public Criteria andNeedpmEqualTo(String value) {
            addCriterion("NEEDPM =", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmNotEqualTo(String value) {
            addCriterion("NEEDPM <>", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmGreaterThan(String value) {
            addCriterion("NEEDPM >", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmGreaterThanOrEqualTo(String value) {
            addCriterion("NEEDPM >=", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmLessThan(String value) {
            addCriterion("NEEDPM <", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmLessThanOrEqualTo(String value) {
            addCriterion("NEEDPM <=", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmLike(String value) {
            addCriterion("NEEDPM like", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmNotLike(String value) {
            addCriterion("NEEDPM not like", value, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmIn(List<String> values) {
            addCriterion("NEEDPM in", values, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmNotIn(List<String> values) {
            addCriterion("NEEDPM not in", values, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmBetween(String value1, String value2) {
            addCriterion("NEEDPM between", value1, value2, "needpm");
            return (Criteria) this;
        }

        public Criteria andNeedpmNotBetween(String value1, String value2) {
            addCriterion("NEEDPM not between", value1, value2, "needpm");
            return (Criteria) this;
        }

        public Criteria andMaxqtyIsNull() {
            addCriterion("MAXQTY is null");
            return (Criteria) this;
        }

        public Criteria andMaxqtyIsNotNull() {
            addCriterion("MAXQTY is not null");
            return (Criteria) this;
        }

        public Criteria andMaxqtyEqualTo(BigDecimal value) {
            addCriterion("MAXQTY =", value, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyNotEqualTo(BigDecimal value) {
            addCriterion("MAXQTY <>", value, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyGreaterThan(BigDecimal value) {
            addCriterion("MAXQTY >", value, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXQTY >=", value, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyLessThan(BigDecimal value) {
            addCriterion("MAXQTY <", value, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAXQTY <=", value, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyIn(List<BigDecimal> values) {
            addCriterion("MAXQTY in", values, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyNotIn(List<BigDecimal> values) {
            addCriterion("MAXQTY not in", values, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXQTY between", value1, value2, "maxqty");
            return (Criteria) this;
        }

        public Criteria andMaxqtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAXQTY not between", value1, value2, "maxqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyIsNull() {
            addCriterion("USEDQTY is null");
            return (Criteria) this;
        }

        public Criteria andUsedqtyIsNotNull() {
            addCriterion("USEDQTY is not null");
            return (Criteria) this;
        }

        public Criteria andUsedqtyEqualTo(BigDecimal value) {
            addCriterion("USEDQTY =", value, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyNotEqualTo(BigDecimal value) {
            addCriterion("USEDQTY <>", value, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyGreaterThan(BigDecimal value) {
            addCriterion("USEDQTY >", value, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USEDQTY >=", value, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyLessThan(BigDecimal value) {
            addCriterion("USEDQTY <", value, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USEDQTY <=", value, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyIn(List<BigDecimal> values) {
            addCriterion("USEDQTY in", values, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyNotIn(List<BigDecimal> values) {
            addCriterion("USEDQTY not in", values, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USEDQTY between", value1, value2, "usedqty");
            return (Criteria) this;
        }

        public Criteria andUsedqtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USEDQTY not between", value1, value2, "usedqty");
            return (Criteria) this;
        }

        public Criteria andMoidIsNull() {
            addCriterion("MOID is null");
            return (Criteria) this;
        }

        public Criteria andMoidIsNotNull() {
            addCriterion("MOID is not null");
            return (Criteria) this;
        }

        public Criteria andMoidEqualTo(String value) {
            addCriterion("MOID =", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotEqualTo(String value) {
            addCriterion("MOID <>", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidGreaterThan(String value) {
            addCriterion("MOID >", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidGreaterThanOrEqualTo(String value) {
            addCriterion("MOID >=", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidLessThan(String value) {
            addCriterion("MOID <", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidLessThanOrEqualTo(String value) {
            addCriterion("MOID <=", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidLike(String value) {
            addCriterion("MOID like", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotLike(String value) {
            addCriterion("MOID not like", value, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidIn(List<String> values) {
            addCriterion("MOID in", values, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotIn(List<String> values) {
            addCriterion("MOID not in", values, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidBetween(String value1, String value2) {
            addCriterion("MOID between", value1, value2, "moid");
            return (Criteria) this;
        }

        public Criteria andMoidNotBetween(String value1, String value2) {
            addCriterion("MOID not between", value1, value2, "moid");
            return (Criteria) this;
        }

        public Criteria andEqpidIsNull() {
            addCriterion("EQPID is null");
            return (Criteria) this;
        }

        public Criteria andEqpidIsNotNull() {
            addCriterion("EQPID is not null");
            return (Criteria) this;
        }

        public Criteria andEqpidEqualTo(String value) {
            addCriterion("EQPID =", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidNotEqualTo(String value) {
            addCriterion("EQPID <>", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidGreaterThan(String value) {
            addCriterion("EQPID >", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidGreaterThanOrEqualTo(String value) {
            addCriterion("EQPID >=", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidLessThan(String value) {
            addCriterion("EQPID <", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidLessThanOrEqualTo(String value) {
            addCriterion("EQPID <=", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidLike(String value) {
            addCriterion("EQPID like", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidNotLike(String value) {
            addCriterion("EQPID not like", value, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidIn(List<String> values) {
            addCriterion("EQPID in", values, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidNotIn(List<String> values) {
            addCriterion("EQPID not in", values, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidBetween(String value1, String value2) {
            addCriterion("EQPID between", value1, value2, "eqpid");
            return (Criteria) this;
        }

        public Criteria andEqpidNotBetween(String value1, String value2) {
            addCriterion("EQPID not between", value1, value2, "eqpid");
            return (Criteria) this;
        }

        public Criteria andStageIsNull() {
            addCriterion("STAGE is null");
            return (Criteria) this;
        }

        public Criteria andStageIsNotNull() {
            addCriterion("STAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStageEqualTo(String value) {
            addCriterion("STAGE =", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotEqualTo(String value) {
            addCriterion("STAGE <>", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThan(String value) {
            addCriterion("STAGE >", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThanOrEqualTo(String value) {
            addCriterion("STAGE >=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThan(String value) {
            addCriterion("STAGE <", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThanOrEqualTo(String value) {
            addCriterion("STAGE <=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLike(String value) {
            addCriterion("STAGE like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotLike(String value) {
            addCriterion("STAGE not like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageIn(List<String> values) {
            addCriterion("STAGE in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotIn(List<String> values) {
            addCriterion("STAGE not in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageBetween(String value1, String value2) {
            addCriterion("STAGE between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotBetween(String value1, String value2) {
            addCriterion("STAGE not between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andSlotIsNull() {
            addCriterion("SLOT is null");
            return (Criteria) this;
        }

        public Criteria andSlotIsNotNull() {
            addCriterion("SLOT is not null");
            return (Criteria) this;
        }

        public Criteria andSlotEqualTo(String value) {
            addCriterion("SLOT =", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotEqualTo(String value) {
            addCriterion("SLOT <>", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotGreaterThan(String value) {
            addCriterion("SLOT >", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotGreaterThanOrEqualTo(String value) {
            addCriterion("SLOT >=", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotLessThan(String value) {
            addCriterion("SLOT <", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotLessThanOrEqualTo(String value) {
            addCriterion("SLOT <=", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotLike(String value) {
            addCriterion("SLOT like", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotLike(String value) {
            addCriterion("SLOT not like", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotIn(List<String> values) {
            addCriterion("SLOT in", values, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotIn(List<String> values) {
            addCriterion("SLOT not in", values, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotBetween(String value1, String value2) {
            addCriterion("SLOT between", value1, value2, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotBetween(String value1, String value2) {
            addCriterion("SLOT not between", value1, value2, "slot");
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

        public Criteria andWarningqtyIsNull() {
            addCriterion("WARNINGQTY is null");
            return (Criteria) this;
        }

        public Criteria andWarningqtyIsNotNull() {
            addCriterion("WARNINGQTY is not null");
            return (Criteria) this;
        }

        public Criteria andWarningqtyEqualTo(Integer value) {
            addCriterion("WARNINGQTY =", value, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyNotEqualTo(Integer value) {
            addCriterion("WARNINGQTY <>", value, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyGreaterThan(Integer value) {
            addCriterion("WARNINGQTY >", value, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("WARNINGQTY >=", value, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyLessThan(Integer value) {
            addCriterion("WARNINGQTY <", value, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyLessThanOrEqualTo(Integer value) {
            addCriterion("WARNINGQTY <=", value, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyIn(List<Integer> values) {
            addCriterion("WARNINGQTY in", values, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyNotIn(List<Integer> values) {
            addCriterion("WARNINGQTY not in", values, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyBetween(Integer value1, Integer value2) {
            addCriterion("WARNINGQTY between", value1, value2, "warningqty");
            return (Criteria) this;
        }

        public Criteria andWarningqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("WARNINGQTY not between", value1, value2, "warningqty");
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