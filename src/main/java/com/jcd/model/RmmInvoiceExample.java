package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RmmInvoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RmmInvoiceExample() {
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

        public Criteria andInvoiceidIsNull() {
            addCriterion("INVOICEID is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceidIsNotNull() {
            addCriterion("INVOICEID is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceidEqualTo(String value) {
            addCriterion("INVOICEID =", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidNotEqualTo(String value) {
            addCriterion("INVOICEID <>", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidGreaterThan(String value) {
            addCriterion("INVOICEID >", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICEID >=", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidLessThan(String value) {
            addCriterion("INVOICEID <", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidLessThanOrEqualTo(String value) {
            addCriterion("INVOICEID <=", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidLike(String value) {
            addCriterion("INVOICEID like", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidNotLike(String value) {
            addCriterion("INVOICEID not like", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidIn(List<String> values) {
            addCriterion("INVOICEID in", values, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidNotIn(List<String> values) {
            addCriterion("INVOICEID not in", values, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidBetween(String value1, String value2) {
            addCriterion("INVOICEID between", value1, value2, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidNotBetween(String value1, String value2) {
            addCriterion("INVOICEID not between", value1, value2, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberIsNull() {
            addCriterion("INVOICENUMBER is null");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberIsNotNull() {
            addCriterion("INVOICENUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberEqualTo(String value) {
            addCriterion("INVOICENUMBER =", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotEqualTo(String value) {
            addCriterion("INVOICENUMBER <>", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberGreaterThan(String value) {
            addCriterion("INVOICENUMBER >", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICENUMBER >=", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberLessThan(String value) {
            addCriterion("INVOICENUMBER <", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberLessThanOrEqualTo(String value) {
            addCriterion("INVOICENUMBER <=", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberLike(String value) {
            addCriterion("INVOICENUMBER like", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotLike(String value) {
            addCriterion("INVOICENUMBER not like", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberIn(List<String> values) {
            addCriterion("INVOICENUMBER in", values, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotIn(List<String> values) {
            addCriterion("INVOICENUMBER not in", values, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberBetween(String value1, String value2) {
            addCriterion("INVOICENUMBER between", value1, value2, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotBetween(String value1, String value2) {
            addCriterion("INVOICENUMBER not between", value1, value2, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberIsNull() {
            addCriterion("SUBMITNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberIsNotNull() {
            addCriterion("SUBMITNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberEqualTo(String value) {
            addCriterion("SUBMITNUMBER =", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberNotEqualTo(String value) {
            addCriterion("SUBMITNUMBER <>", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberGreaterThan(String value) {
            addCriterion("SUBMITNUMBER >", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberGreaterThanOrEqualTo(String value) {
            addCriterion("SUBMITNUMBER >=", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberLessThan(String value) {
            addCriterion("SUBMITNUMBER <", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberLessThanOrEqualTo(String value) {
            addCriterion("SUBMITNUMBER <=", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberLike(String value) {
            addCriterion("SUBMITNUMBER like", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberNotLike(String value) {
            addCriterion("SUBMITNUMBER not like", value, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberIn(List<String> values) {
            addCriterion("SUBMITNUMBER in", values, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberNotIn(List<String> values) {
            addCriterion("SUBMITNUMBER not in", values, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberBetween(String value1, String value2) {
            addCriterion("SUBMITNUMBER between", value1, value2, "submitnumber");
            return (Criteria) this;
        }

        public Criteria andSubmitnumberNotBetween(String value1, String value2) {
            addCriterion("SUBMITNUMBER not between", value1, value2, "submitnumber");
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

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("VERSION like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("VERSION not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("VERSION not between", value1, value2, "version");
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

        public Criteria andBlnoIsNull() {
            addCriterion("BLNO is null");
            return (Criteria) this;
        }

        public Criteria andBlnoIsNotNull() {
            addCriterion("BLNO is not null");
            return (Criteria) this;
        }

        public Criteria andBlnoEqualTo(Short value) {
            addCriterion("BLNO =", value, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoNotEqualTo(Short value) {
            addCriterion("BLNO <>", value, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoGreaterThan(Short value) {
            addCriterion("BLNO >", value, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoGreaterThanOrEqualTo(Short value) {
            addCriterion("BLNO >=", value, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoLessThan(Short value) {
            addCriterion("BLNO <", value, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoLessThanOrEqualTo(Short value) {
            addCriterion("BLNO <=", value, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoIn(List<Short> values) {
            addCriterion("BLNO in", values, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoNotIn(List<Short> values) {
            addCriterion("BLNO not in", values, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoBetween(Short value1, Short value2) {
            addCriterion("BLNO between", value1, value2, "blno");
            return (Criteria) this;
        }

        public Criteria andBlnoNotBetween(Short value1, Short value2) {
            addCriterion("BLNO not between", value1, value2, "blno");
            return (Criteria) this;
        }

        public Criteria andErpuserIsNull() {
            addCriterion("ERPUSER is null");
            return (Criteria) this;
        }

        public Criteria andErpuserIsNotNull() {
            addCriterion("ERPUSER is not null");
            return (Criteria) this;
        }

        public Criteria andErpuserEqualTo(String value) {
            addCriterion("ERPUSER =", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserNotEqualTo(String value) {
            addCriterion("ERPUSER <>", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserGreaterThan(String value) {
            addCriterion("ERPUSER >", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserGreaterThanOrEqualTo(String value) {
            addCriterion("ERPUSER >=", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserLessThan(String value) {
            addCriterion("ERPUSER <", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserLessThanOrEqualTo(String value) {
            addCriterion("ERPUSER <=", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserLike(String value) {
            addCriterion("ERPUSER like", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserNotLike(String value) {
            addCriterion("ERPUSER not like", value, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserIn(List<String> values) {
            addCriterion("ERPUSER in", values, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserNotIn(List<String> values) {
            addCriterion("ERPUSER not in", values, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserBetween(String value1, String value2) {
            addCriterion("ERPUSER between", value1, value2, "erpuser");
            return (Criteria) this;
        }

        public Criteria andErpuserNotBetween(String value1, String value2) {
            addCriterion("ERPUSER not between", value1, value2, "erpuser");
            return (Criteria) this;
        }

        public Criteria andBatchprintIsNull() {
            addCriterion("BATCHPRINT is null");
            return (Criteria) this;
        }

        public Criteria andBatchprintIsNotNull() {
            addCriterion("BATCHPRINT is not null");
            return (Criteria) this;
        }

        public Criteria andBatchprintEqualTo(String value) {
            addCriterion("BATCHPRINT =", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintNotEqualTo(String value) {
            addCriterion("BATCHPRINT <>", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintGreaterThan(String value) {
            addCriterion("BATCHPRINT >", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintGreaterThanOrEqualTo(String value) {
            addCriterion("BATCHPRINT >=", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintLessThan(String value) {
            addCriterion("BATCHPRINT <", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintLessThanOrEqualTo(String value) {
            addCriterion("BATCHPRINT <=", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintLike(String value) {
            addCriterion("BATCHPRINT like", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintNotLike(String value) {
            addCriterion("BATCHPRINT not like", value, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintIn(List<String> values) {
            addCriterion("BATCHPRINT in", values, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintNotIn(List<String> values) {
            addCriterion("BATCHPRINT not in", values, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintBetween(String value1, String value2) {
            addCriterion("BATCHPRINT between", value1, value2, "batchprint");
            return (Criteria) this;
        }

        public Criteria andBatchprintNotBetween(String value1, String value2) {
            addCriterion("BATCHPRINT not between", value1, value2, "batchprint");
            return (Criteria) this;
        }

        public Criteria andPrinterIsNull() {
            addCriterion("PRINTER is null");
            return (Criteria) this;
        }

        public Criteria andPrinterIsNotNull() {
            addCriterion("PRINTER is not null");
            return (Criteria) this;
        }

        public Criteria andPrinterEqualTo(String value) {
            addCriterion("PRINTER =", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotEqualTo(String value) {
            addCriterion("PRINTER <>", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterGreaterThan(String value) {
            addCriterion("PRINTER >", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterGreaterThanOrEqualTo(String value) {
            addCriterion("PRINTER >=", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterLessThan(String value) {
            addCriterion("PRINTER <", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterLessThanOrEqualTo(String value) {
            addCriterion("PRINTER <=", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterLike(String value) {
            addCriterion("PRINTER like", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotLike(String value) {
            addCriterion("PRINTER not like", value, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterIn(List<String> values) {
            addCriterion("PRINTER in", values, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotIn(List<String> values) {
            addCriterion("PRINTER not in", values, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterBetween(String value1, String value2) {
            addCriterion("PRINTER between", value1, value2, "printer");
            return (Criteria) this;
        }

        public Criteria andPrinterNotBetween(String value1, String value2) {
            addCriterion("PRINTER not between", value1, value2, "printer");
            return (Criteria) this;
        }

        public Criteria andPrintdateIsNull() {
            addCriterion("PRINTDATE is null");
            return (Criteria) this;
        }

        public Criteria andPrintdateIsNotNull() {
            addCriterion("PRINTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andPrintdateEqualTo(Date value) {
            addCriterion("PRINTDATE =", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateNotEqualTo(Date value) {
            addCriterion("PRINTDATE <>", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateGreaterThan(Date value) {
            addCriterion("PRINTDATE >", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateGreaterThanOrEqualTo(Date value) {
            addCriterion("PRINTDATE >=", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateLessThan(Date value) {
            addCriterion("PRINTDATE <", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateLessThanOrEqualTo(Date value) {
            addCriterion("PRINTDATE <=", value, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateIn(List<Date> values) {
            addCriterion("PRINTDATE in", values, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateNotIn(List<Date> values) {
            addCriterion("PRINTDATE not in", values, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateBetween(Date value1, Date value2) {
            addCriterion("PRINTDATE between", value1, value2, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintdateNotBetween(Date value1, Date value2) {
            addCriterion("PRINTDATE not between", value1, value2, "printdate");
            return (Criteria) this;
        }

        public Criteria andPrintcntIsNull() {
            addCriterion("PRINTCNT is null");
            return (Criteria) this;
        }

        public Criteria andPrintcntIsNotNull() {
            addCriterion("PRINTCNT is not null");
            return (Criteria) this;
        }

        public Criteria andPrintcntEqualTo(Short value) {
            addCriterion("PRINTCNT =", value, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntNotEqualTo(Short value) {
            addCriterion("PRINTCNT <>", value, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntGreaterThan(Short value) {
            addCriterion("PRINTCNT >", value, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntGreaterThanOrEqualTo(Short value) {
            addCriterion("PRINTCNT >=", value, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntLessThan(Short value) {
            addCriterion("PRINTCNT <", value, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntLessThanOrEqualTo(Short value) {
            addCriterion("PRINTCNT <=", value, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntIn(List<Short> values) {
            addCriterion("PRINTCNT in", values, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntNotIn(List<Short> values) {
            addCriterion("PRINTCNT not in", values, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntBetween(Short value1, Short value2) {
            addCriterion("PRINTCNT between", value1, value2, "printcnt");
            return (Criteria) this;
        }

        public Criteria andPrintcntNotBetween(Short value1, Short value2) {
            addCriterion("PRINTCNT not between", value1, value2, "printcnt");
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

        public Criteria andErpheaderidIsNull() {
            addCriterion("ERPHEADERID is null");
            return (Criteria) this;
        }

        public Criteria andErpheaderidIsNotNull() {
            addCriterion("ERPHEADERID is not null");
            return (Criteria) this;
        }

        public Criteria andErpheaderidEqualTo(Short value) {
            addCriterion("ERPHEADERID =", value, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidNotEqualTo(Short value) {
            addCriterion("ERPHEADERID <>", value, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidGreaterThan(Short value) {
            addCriterion("ERPHEADERID >", value, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidGreaterThanOrEqualTo(Short value) {
            addCriterion("ERPHEADERID >=", value, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidLessThan(Short value) {
            addCriterion("ERPHEADERID <", value, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidLessThanOrEqualTo(Short value) {
            addCriterion("ERPHEADERID <=", value, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidIn(List<Short> values) {
            addCriterion("ERPHEADERID in", values, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidNotIn(List<Short> values) {
            addCriterion("ERPHEADERID not in", values, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidBetween(Short value1, Short value2) {
            addCriterion("ERPHEADERID between", value1, value2, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andErpheaderidNotBetween(Short value1, Short value2) {
            addCriterion("ERPHEADERID not between", value1, value2, "erpheaderid");
            return (Criteria) this;
        }

        public Criteria andInvoicedateIsNull() {
            addCriterion("INVOICEDATE is null");
            return (Criteria) this;
        }

        public Criteria andInvoicedateIsNotNull() {
            addCriterion("INVOICEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicedateEqualTo(Date value) {
            addCriterion("INVOICEDATE =", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateNotEqualTo(Date value) {
            addCriterion("INVOICEDATE <>", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateGreaterThan(Date value) {
            addCriterion("INVOICEDATE >", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateGreaterThanOrEqualTo(Date value) {
            addCriterion("INVOICEDATE >=", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateLessThan(Date value) {
            addCriterion("INVOICEDATE <", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateLessThanOrEqualTo(Date value) {
            addCriterion("INVOICEDATE <=", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateIn(List<Date> values) {
            addCriterion("INVOICEDATE in", values, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateNotIn(List<Date> values) {
            addCriterion("INVOICEDATE not in", values, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateBetween(Date value1, Date value2) {
            addCriterion("INVOICEDATE between", value1, value2, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateNotBetween(Date value1, Date value2) {
            addCriterion("INVOICEDATE not between", value1, value2, "invoicedate");
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