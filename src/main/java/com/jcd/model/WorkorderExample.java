package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkorderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("ORDERID is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("ORDERID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("ORDERID =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("ORDERID <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("ORDERID >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERID >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("ORDERID <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("ORDERID <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("ORDERID like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("ORDERID not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("ORDERID in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("ORDERID not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("ORDERID between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("ORDERID not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrdernameIsNull() {
            addCriterion("ORDERNAME is null");
            return (Criteria) this;
        }

        public Criteria andOrdernameIsNotNull() {
            addCriterion("ORDERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernameEqualTo(String value) {
            addCriterion("ORDERNAME =", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotEqualTo(String value) {
            addCriterion("ORDERNAME <>", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThan(String value) {
            addCriterion("ORDERNAME >", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERNAME >=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThan(String value) {
            addCriterion("ORDERNAME <", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThanOrEqualTo(String value) {
            addCriterion("ORDERNAME <=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLike(String value) {
            addCriterion("ORDERNAME like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotLike(String value) {
            addCriterion("ORDERNAME not like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameIn(List<String> values) {
            addCriterion("ORDERNAME in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotIn(List<String> values) {
            addCriterion("ORDERNAME not in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameBetween(String value1, String value2) {
            addCriterion("ORDERNAME between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotBetween(String value1, String value2) {
            addCriterion("ORDERNAME not between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIsNull() {
            addCriterion("ORGANIZATIONCODE is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIsNotNull() {
            addCriterion("ORGANIZATIONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE =", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE <>", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeGreaterThan(String value) {
            addCriterion("ORGANIZATIONCODE >", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE >=", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLessThan(String value) {
            addCriterion("ORGANIZATIONCODE <", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZATIONCODE <=", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeLike(String value) {
            addCriterion("ORGANIZATIONCODE like", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotLike(String value) {
            addCriterion("ORGANIZATIONCODE not like", value, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeIn(List<String> values) {
            addCriterion("ORGANIZATIONCODE in", values, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotIn(List<String> values) {
            addCriterion("ORGANIZATIONCODE not in", values, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONCODE between", value1, value2, "organizationcode");
            return (Criteria) this;
        }

        public Criteria andOrganizationcodeNotBetween(String value1, String value2) {
            addCriterion("ORGANIZATIONCODE not between", value1, value2, "organizationcode");
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

        public Criteria andProductnameIsNull() {
            addCriterion("PRODUCTNAME is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("PRODUCTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("PRODUCTNAME =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("PRODUCTNAME <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("PRODUCTNAME >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTNAME >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("PRODUCTNAME <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTNAME <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("PRODUCTNAME like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("PRODUCTNAME not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("PRODUCTNAME in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("PRODUCTNAME not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("PRODUCTNAME between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("PRODUCTNAME not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andSalesnumberIsNull() {
            addCriterion("SALESNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSalesnumberIsNotNull() {
            addCriterion("SALESNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSalesnumberEqualTo(String value) {
            addCriterion("SALESNUMBER =", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberNotEqualTo(String value) {
            addCriterion("SALESNUMBER <>", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberGreaterThan(String value) {
            addCriterion("SALESNUMBER >", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberGreaterThanOrEqualTo(String value) {
            addCriterion("SALESNUMBER >=", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberLessThan(String value) {
            addCriterion("SALESNUMBER <", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberLessThanOrEqualTo(String value) {
            addCriterion("SALESNUMBER <=", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberLike(String value) {
            addCriterion("SALESNUMBER like", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberNotLike(String value) {
            addCriterion("SALESNUMBER not like", value, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberIn(List<String> values) {
            addCriterion("SALESNUMBER in", values, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberNotIn(List<String> values) {
            addCriterion("SALESNUMBER not in", values, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberBetween(String value1, String value2) {
            addCriterion("SALESNUMBER between", value1, value2, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andSalesnumberNotBetween(String value1, String value2) {
            addCriterion("SALESNUMBER not between", value1, value2, "salesnumber");
            return (Criteria) this;
        }

        public Criteria andCustomercodeIsNull() {
            addCriterion("CUSTOMERCODE is null");
            return (Criteria) this;
        }

        public Criteria andCustomercodeIsNotNull() {
            addCriterion("CUSTOMERCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomercodeEqualTo(String value) {
            addCriterion("CUSTOMERCODE =", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeNotEqualTo(String value) {
            addCriterion("CUSTOMERCODE <>", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeGreaterThan(String value) {
            addCriterion("CUSTOMERCODE >", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMERCODE >=", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeLessThan(String value) {
            addCriterion("CUSTOMERCODE <", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMERCODE <=", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeLike(String value) {
            addCriterion("CUSTOMERCODE like", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeNotLike(String value) {
            addCriterion("CUSTOMERCODE not like", value, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeIn(List<String> values) {
            addCriterion("CUSTOMERCODE in", values, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeNotIn(List<String> values) {
            addCriterion("CUSTOMERCODE not in", values, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeBetween(String value1, String value2) {
            addCriterion("CUSTOMERCODE between", value1, value2, "customercode");
            return (Criteria) this;
        }

        public Criteria andCustomercodeNotBetween(String value1, String value2) {
            addCriterion("CUSTOMERCODE not between", value1, value2, "customercode");
            return (Criteria) this;
        }

        public Criteria andTotalqtyIsNull() {
            addCriterion("TOTALQTY is null");
            return (Criteria) this;
        }

        public Criteria andTotalqtyIsNotNull() {
            addCriterion("TOTALQTY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalqtyEqualTo(Short value) {
            addCriterion("TOTALQTY =", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyNotEqualTo(Short value) {
            addCriterion("TOTALQTY <>", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyGreaterThan(Short value) {
            addCriterion("TOTALQTY >", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyGreaterThanOrEqualTo(Short value) {
            addCriterion("TOTALQTY >=", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyLessThan(Short value) {
            addCriterion("TOTALQTY <", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyLessThanOrEqualTo(Short value) {
            addCriterion("TOTALQTY <=", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyIn(List<Short> values) {
            addCriterion("TOTALQTY in", values, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyNotIn(List<Short> values) {
            addCriterion("TOTALQTY not in", values, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyBetween(Short value1, Short value2) {
            addCriterion("TOTALQTY between", value1, value2, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyNotBetween(Short value1, Short value2) {
            addCriterion("TOTALQTY not between", value1, value2, "totalqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyIsNull() {
            addCriterion("STARTQTY is null");
            return (Criteria) this;
        }

        public Criteria andStartqtyIsNotNull() {
            addCriterion("STARTQTY is not null");
            return (Criteria) this;
        }

        public Criteria andStartqtyEqualTo(Short value) {
            addCriterion("STARTQTY =", value, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyNotEqualTo(Short value) {
            addCriterion("STARTQTY <>", value, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyGreaterThan(Short value) {
            addCriterion("STARTQTY >", value, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyGreaterThanOrEqualTo(Short value) {
            addCriterion("STARTQTY >=", value, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyLessThan(Short value) {
            addCriterion("STARTQTY <", value, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyLessThanOrEqualTo(Short value) {
            addCriterion("STARTQTY <=", value, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyIn(List<Short> values) {
            addCriterion("STARTQTY in", values, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyNotIn(List<Short> values) {
            addCriterion("STARTQTY not in", values, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyBetween(Short value1, Short value2) {
            addCriterion("STARTQTY between", value1, value2, "startqty");
            return (Criteria) this;
        }

        public Criteria andStartqtyNotBetween(Short value1, Short value2) {
            addCriterion("STARTQTY not between", value1, value2, "startqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyIsNull() {
            addCriterion("REMAINQTY is null");
            return (Criteria) this;
        }

        public Criteria andRemainqtyIsNotNull() {
            addCriterion("REMAINQTY is not null");
            return (Criteria) this;
        }

        public Criteria andRemainqtyEqualTo(Short value) {
            addCriterion("REMAINQTY =", value, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyNotEqualTo(Short value) {
            addCriterion("REMAINQTY <>", value, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyGreaterThan(Short value) {
            addCriterion("REMAINQTY >", value, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyGreaterThanOrEqualTo(Short value) {
            addCriterion("REMAINQTY >=", value, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyLessThan(Short value) {
            addCriterion("REMAINQTY <", value, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyLessThanOrEqualTo(Short value) {
            addCriterion("REMAINQTY <=", value, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyIn(List<Short> values) {
            addCriterion("REMAINQTY in", values, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyNotIn(List<Short> values) {
            addCriterion("REMAINQTY not in", values, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyBetween(Short value1, Short value2) {
            addCriterion("REMAINQTY between", value1, value2, "remainqty");
            return (Criteria) this;
        }

        public Criteria andRemainqtyNotBetween(Short value1, Short value2) {
            addCriterion("REMAINQTY not between", value1, value2, "remainqty");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIsNull() {
            addCriterion("ORDERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIsNotNull() {
            addCriterion("ORDERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeEqualTo(String value) {
            addCriterion("ORDERTYPE =", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotEqualTo(String value) {
            addCriterion("ORDERTYPE <>", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThan(String value) {
            addCriterion("ORDERTYPE >", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERTYPE >=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThan(String value) {
            addCriterion("ORDERTYPE <", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThanOrEqualTo(String value) {
            addCriterion("ORDERTYPE <=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLike(String value) {
            addCriterion("ORDERTYPE like", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotLike(String value) {
            addCriterion("ORDERTYPE not like", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIn(List<String> values) {
            addCriterion("ORDERTYPE in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotIn(List<String> values) {
            addCriterion("ORDERTYPE not in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeBetween(String value1, String value2) {
            addCriterion("ORDERTYPE between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotBetween(String value1, String value2) {
            addCriterion("ORDERTYPE not between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeIsNull() {
            addCriterion("BONDERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBondertypeIsNotNull() {
            addCriterion("BONDERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBondertypeEqualTo(String value) {
            addCriterion("BONDERTYPE =", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeNotEqualTo(String value) {
            addCriterion("BONDERTYPE <>", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeGreaterThan(String value) {
            addCriterion("BONDERTYPE >", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeGreaterThanOrEqualTo(String value) {
            addCriterion("BONDERTYPE >=", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeLessThan(String value) {
            addCriterion("BONDERTYPE <", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeLessThanOrEqualTo(String value) {
            addCriterion("BONDERTYPE <=", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeLike(String value) {
            addCriterion("BONDERTYPE like", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeNotLike(String value) {
            addCriterion("BONDERTYPE not like", value, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeIn(List<String> values) {
            addCriterion("BONDERTYPE in", values, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeNotIn(List<String> values) {
            addCriterion("BONDERTYPE not in", values, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeBetween(String value1, String value2) {
            addCriterion("BONDERTYPE between", value1, value2, "bondertype");
            return (Criteria) this;
        }

        public Criteria andBondertypeNotBetween(String value1, String value2) {
            addCriterion("BONDERTYPE not between", value1, value2, "bondertype");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("CATEGORY =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("CATEGORY <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("CATEGORY >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("CATEGORY <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("CATEGORY like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("CATEGORY not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("CATEGORY in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("CATEGORY not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("CATEGORY between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("CATEGORY not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andPanellengthIsNull() {
            addCriterion("PANELLENGTH is null");
            return (Criteria) this;
        }

        public Criteria andPanellengthIsNotNull() {
            addCriterion("PANELLENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andPanellengthEqualTo(Short value) {
            addCriterion("PANELLENGTH =", value, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthNotEqualTo(Short value) {
            addCriterion("PANELLENGTH <>", value, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthGreaterThan(Short value) {
            addCriterion("PANELLENGTH >", value, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthGreaterThanOrEqualTo(Short value) {
            addCriterion("PANELLENGTH >=", value, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthLessThan(Short value) {
            addCriterion("PANELLENGTH <", value, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthLessThanOrEqualTo(Short value) {
            addCriterion("PANELLENGTH <=", value, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthIn(List<Short> values) {
            addCriterion("PANELLENGTH in", values, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthNotIn(List<Short> values) {
            addCriterion("PANELLENGTH not in", values, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthBetween(Short value1, Short value2) {
            addCriterion("PANELLENGTH between", value1, value2, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanellengthNotBetween(Short value1, Short value2) {
            addCriterion("PANELLENGTH not between", value1, value2, "panellength");
            return (Criteria) this;
        }

        public Criteria andPanelwidthIsNull() {
            addCriterion("PANELWIDTH is null");
            return (Criteria) this;
        }

        public Criteria andPanelwidthIsNotNull() {
            addCriterion("PANELWIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andPanelwidthEqualTo(Short value) {
            addCriterion("PANELWIDTH =", value, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthNotEqualTo(Short value) {
            addCriterion("PANELWIDTH <>", value, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthGreaterThan(Short value) {
            addCriterion("PANELWIDTH >", value, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthGreaterThanOrEqualTo(Short value) {
            addCriterion("PANELWIDTH >=", value, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthLessThan(Short value) {
            addCriterion("PANELWIDTH <", value, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthLessThanOrEqualTo(Short value) {
            addCriterion("PANELWIDTH <=", value, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthIn(List<Short> values) {
            addCriterion("PANELWIDTH in", values, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthNotIn(List<Short> values) {
            addCriterion("PANELWIDTH not in", values, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthBetween(Short value1, Short value2) {
            addCriterion("PANELWIDTH between", value1, value2, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelwidthNotBetween(Short value1, Short value2) {
            addCriterion("PANELWIDTH not between", value1, value2, "panelwidth");
            return (Criteria) this;
        }

        public Criteria andPanelpcsIsNull() {
            addCriterion("PANELPCS is null");
            return (Criteria) this;
        }

        public Criteria andPanelpcsIsNotNull() {
            addCriterion("PANELPCS is not null");
            return (Criteria) this;
        }

        public Criteria andPanelpcsEqualTo(Short value) {
            addCriterion("PANELPCS =", value, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsNotEqualTo(Short value) {
            addCriterion("PANELPCS <>", value, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsGreaterThan(Short value) {
            addCriterion("PANELPCS >", value, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsGreaterThanOrEqualTo(Short value) {
            addCriterion("PANELPCS >=", value, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsLessThan(Short value) {
            addCriterion("PANELPCS <", value, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsLessThanOrEqualTo(Short value) {
            addCriterion("PANELPCS <=", value, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsIn(List<Short> values) {
            addCriterion("PANELPCS in", values, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsNotIn(List<Short> values) {
            addCriterion("PANELPCS not in", values, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsBetween(Short value1, Short value2) {
            addCriterion("PANELPCS between", value1, value2, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelpcsNotBetween(Short value1, Short value2) {
            addCriterion("PANELPCS not between", value1, value2, "panelpcs");
            return (Criteria) this;
        }

        public Criteria andPanelareaIsNull() {
            addCriterion("PANELAREA is null");
            return (Criteria) this;
        }

        public Criteria andPanelareaIsNotNull() {
            addCriterion("PANELAREA is not null");
            return (Criteria) this;
        }

        public Criteria andPanelareaEqualTo(Short value) {
            addCriterion("PANELAREA =", value, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaNotEqualTo(Short value) {
            addCriterion("PANELAREA <>", value, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaGreaterThan(Short value) {
            addCriterion("PANELAREA >", value, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaGreaterThanOrEqualTo(Short value) {
            addCriterion("PANELAREA >=", value, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaLessThan(Short value) {
            addCriterion("PANELAREA <", value, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaLessThanOrEqualTo(Short value) {
            addCriterion("PANELAREA <=", value, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaIn(List<Short> values) {
            addCriterion("PANELAREA in", values, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaNotIn(List<Short> values) {
            addCriterion("PANELAREA not in", values, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaBetween(Short value1, Short value2) {
            addCriterion("PANELAREA between", value1, value2, "panelarea");
            return (Criteria) this;
        }

        public Criteria andPanelareaNotBetween(Short value1, Short value2) {
            addCriterion("PANELAREA not between", value1, value2, "panelarea");
            return (Criteria) this;
        }

        public Criteria andBomversionIsNull() {
            addCriterion("BOMVERSION is null");
            return (Criteria) this;
        }

        public Criteria andBomversionIsNotNull() {
            addCriterion("BOMVERSION is not null");
            return (Criteria) this;
        }

        public Criteria andBomversionEqualTo(String value) {
            addCriterion("BOMVERSION =", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionNotEqualTo(String value) {
            addCriterion("BOMVERSION <>", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionGreaterThan(String value) {
            addCriterion("BOMVERSION >", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionGreaterThanOrEqualTo(String value) {
            addCriterion("BOMVERSION >=", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionLessThan(String value) {
            addCriterion("BOMVERSION <", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionLessThanOrEqualTo(String value) {
            addCriterion("BOMVERSION <=", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionLike(String value) {
            addCriterion("BOMVERSION like", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionNotLike(String value) {
            addCriterion("BOMVERSION not like", value, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionIn(List<String> values) {
            addCriterion("BOMVERSION in", values, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionNotIn(List<String> values) {
            addCriterion("BOMVERSION not in", values, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionBetween(String value1, String value2) {
            addCriterion("BOMVERSION between", value1, value2, "bomversion");
            return (Criteria) this;
        }

        public Criteria andBomversionNotBetween(String value1, String value2) {
            addCriterion("BOMVERSION not between", value1, value2, "bomversion");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateIsNull() {
            addCriterion("PLANSTARTDATE is null");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateIsNotNull() {
            addCriterion("PLANSTARTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateEqualTo(Date value) {
            addCriterion("PLANSTARTDATE =", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateNotEqualTo(Date value) {
            addCriterion("PLANSTARTDATE <>", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateGreaterThan(Date value) {
            addCriterion("PLANSTARTDATE >", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("PLANSTARTDATE >=", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateLessThan(Date value) {
            addCriterion("PLANSTARTDATE <", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateLessThanOrEqualTo(Date value) {
            addCriterion("PLANSTARTDATE <=", value, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateIn(List<Date> values) {
            addCriterion("PLANSTARTDATE in", values, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateNotIn(List<Date> values) {
            addCriterion("PLANSTARTDATE not in", values, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateBetween(Date value1, Date value2) {
            addCriterion("PLANSTARTDATE between", value1, value2, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanstartdateNotBetween(Date value1, Date value2) {
            addCriterion("PLANSTARTDATE not between", value1, value2, "planstartdate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateIsNull() {
            addCriterion("PLANENDDATE is null");
            return (Criteria) this;
        }

        public Criteria andPlanenddateIsNotNull() {
            addCriterion("PLANENDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andPlanenddateEqualTo(Date value) {
            addCriterion("PLANENDDATE =", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateNotEqualTo(Date value) {
            addCriterion("PLANENDDATE <>", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateGreaterThan(Date value) {
            addCriterion("PLANENDDATE >", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("PLANENDDATE >=", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateLessThan(Date value) {
            addCriterion("PLANENDDATE <", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateLessThanOrEqualTo(Date value) {
            addCriterion("PLANENDDATE <=", value, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateIn(List<Date> values) {
            addCriterion("PLANENDDATE in", values, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateNotIn(List<Date> values) {
            addCriterion("PLANENDDATE not in", values, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateBetween(Date value1, Date value2) {
            addCriterion("PLANENDDATE between", value1, value2, "planenddate");
            return (Criteria) this;
        }

        public Criteria andPlanenddateNotBetween(Date value1, Date value2) {
            addCriterion("PLANENDDATE not between", value1, value2, "planenddate");
            return (Criteria) this;
        }

        public Criteria andOrdercommentIsNull() {
            addCriterion("ORDERCOMMENT is null");
            return (Criteria) this;
        }

        public Criteria andOrdercommentIsNotNull() {
            addCriterion("ORDERCOMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercommentEqualTo(String value) {
            addCriterion("ORDERCOMMENT =", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentNotEqualTo(String value) {
            addCriterion("ORDERCOMMENT <>", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentGreaterThan(String value) {
            addCriterion("ORDERCOMMENT >", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERCOMMENT >=", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentLessThan(String value) {
            addCriterion("ORDERCOMMENT <", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentLessThanOrEqualTo(String value) {
            addCriterion("ORDERCOMMENT <=", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentLike(String value) {
            addCriterion("ORDERCOMMENT like", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentNotLike(String value) {
            addCriterion("ORDERCOMMENT not like", value, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentIn(List<String> values) {
            addCriterion("ORDERCOMMENT in", values, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentNotIn(List<String> values) {
            addCriterion("ORDERCOMMENT not in", values, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentBetween(String value1, String value2) {
            addCriterion("ORDERCOMMENT between", value1, value2, "ordercomment");
            return (Criteria) this;
        }

        public Criteria andOrdercommentNotBetween(String value1, String value2) {
            addCriterion("ORDERCOMMENT not between", value1, value2, "ordercomment");
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

        public Criteria andAuditorIsNull() {
            addCriterion("AUDITOR is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("AUDITOR is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("AUDITOR =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("AUDITOR <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("AUDITOR >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("AUDITOR >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("AUDITOR <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("AUDITOR <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("AUDITOR like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("AUDITOR not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("AUDITOR in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("AUDITOR not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("AUDITOR between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("AUDITOR not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditdateIsNull() {
            addCriterion("AUDITDATE is null");
            return (Criteria) this;
        }

        public Criteria andAuditdateIsNotNull() {
            addCriterion("AUDITDATE is not null");
            return (Criteria) this;
        }

        public Criteria andAuditdateEqualTo(Date value) {
            addCriterion("AUDITDATE =", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateNotEqualTo(Date value) {
            addCriterion("AUDITDATE <>", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateGreaterThan(Date value) {
            addCriterion("AUDITDATE >", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDITDATE >=", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateLessThan(Date value) {
            addCriterion("AUDITDATE <", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateLessThanOrEqualTo(Date value) {
            addCriterion("AUDITDATE <=", value, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateIn(List<Date> values) {
            addCriterion("AUDITDATE in", values, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateNotIn(List<Date> values) {
            addCriterion("AUDITDATE not in", values, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateBetween(Date value1, Date value2) {
            addCriterion("AUDITDATE between", value1, value2, "auditdate");
            return (Criteria) this;
        }

        public Criteria andAuditdateNotBetween(Date value1, Date value2) {
            addCriterion("AUDITDATE not between", value1, value2, "auditdate");
            return (Criteria) this;
        }

        public Criteria andCustomerPnIsNull() {
            addCriterion("CUSTOMER_PN is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPnIsNotNull() {
            addCriterion("CUSTOMER_PN is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPnEqualTo(String value) {
            addCriterion("CUSTOMER_PN =", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotEqualTo(String value) {
            addCriterion("CUSTOMER_PN <>", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnGreaterThan(String value) {
            addCriterion("CUSTOMER_PN >", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_PN >=", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnLessThan(String value) {
            addCriterion("CUSTOMER_PN <", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_PN <=", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnLike(String value) {
            addCriterion("CUSTOMER_PN like", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotLike(String value) {
            addCriterion("CUSTOMER_PN not like", value, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnIn(List<String> values) {
            addCriterion("CUSTOMER_PN in", values, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotIn(List<String> values) {
            addCriterion("CUSTOMER_PN not in", values, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnBetween(String value1, String value2) {
            addCriterion("CUSTOMER_PN between", value1, value2, "customerPn");
            return (Criteria) this;
        }

        public Criteria andCustomerPnNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_PN not between", value1, value2, "customerPn");
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

        public Criteria andAttribute4IsNull() {
            addCriterion("ATTRIBUTE4 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute4IsNotNull() {
            addCriterion("ATTRIBUTE4 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute4EqualTo(String value) {
            addCriterion("ATTRIBUTE4 =", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4NotEqualTo(String value) {
            addCriterion("ATTRIBUTE4 <>", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4GreaterThan(String value) {
            addCriterion("ATTRIBUTE4 >", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE4 >=", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4LessThan(String value) {
            addCriterion("ATTRIBUTE4 <", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE4 <=", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4Like(String value) {
            addCriterion("ATTRIBUTE4 like", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4NotLike(String value) {
            addCriterion("ATTRIBUTE4 not like", value, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4In(List<String> values) {
            addCriterion("ATTRIBUTE4 in", values, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4NotIn(List<String> values) {
            addCriterion("ATTRIBUTE4 not in", values, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4Between(String value1, String value2) {
            addCriterion("ATTRIBUTE4 between", value1, value2, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute4NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE4 not between", value1, value2, "attribute4");
            return (Criteria) this;
        }

        public Criteria andAttribute5IsNull() {
            addCriterion("ATTRIBUTE5 is null");
            return (Criteria) this;
        }

        public Criteria andAttribute5IsNotNull() {
            addCriterion("ATTRIBUTE5 is not null");
            return (Criteria) this;
        }

        public Criteria andAttribute5EqualTo(String value) {
            addCriterion("ATTRIBUTE5 =", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5NotEqualTo(String value) {
            addCriterion("ATTRIBUTE5 <>", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5GreaterThan(String value) {
            addCriterion("ATTRIBUTE5 >", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5GreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE5 >=", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5LessThan(String value) {
            addCriterion("ATTRIBUTE5 <", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5LessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE5 <=", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5Like(String value) {
            addCriterion("ATTRIBUTE5 like", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5NotLike(String value) {
            addCriterion("ATTRIBUTE5 not like", value, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5In(List<String> values) {
            addCriterion("ATTRIBUTE5 in", values, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5NotIn(List<String> values) {
            addCriterion("ATTRIBUTE5 not in", values, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5Between(String value1, String value2) {
            addCriterion("ATTRIBUTE5 between", value1, value2, "attribute5");
            return (Criteria) this;
        }

        public Criteria andAttribute5NotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE5 not between", value1, value2, "attribute5");
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