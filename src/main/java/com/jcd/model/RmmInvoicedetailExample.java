package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RmmInvoicedetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RmmInvoicedetailExample() {
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

        public Criteria andInvoicedetailidIsNull() {
            addCriterion("INVOICEDETAILID is null");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidIsNotNull() {
            addCriterion("INVOICEDETAILID is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidEqualTo(String value) {
            addCriterion("INVOICEDETAILID =", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidNotEqualTo(String value) {
            addCriterion("INVOICEDETAILID <>", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidGreaterThan(String value) {
            addCriterion("INVOICEDETAILID >", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICEDETAILID >=", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidLessThan(String value) {
            addCriterion("INVOICEDETAILID <", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidLessThanOrEqualTo(String value) {
            addCriterion("INVOICEDETAILID <=", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidLike(String value) {
            addCriterion("INVOICEDETAILID like", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidNotLike(String value) {
            addCriterion("INVOICEDETAILID not like", value, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidIn(List<String> values) {
            addCriterion("INVOICEDETAILID in", values, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidNotIn(List<String> values) {
            addCriterion("INVOICEDETAILID not in", values, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidBetween(String value1, String value2) {
            addCriterion("INVOICEDETAILID between", value1, value2, "invoicedetailid");
            return (Criteria) this;
        }

        public Criteria andInvoicedetailidNotBetween(String value1, String value2) {
            addCriterion("INVOICEDETAILID not between", value1, value2, "invoicedetailid");
            return (Criteria) this;
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

        public Criteria andMaterialtypeIsNull() {
            addCriterion("MATERIALTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeIsNotNull() {
            addCriterion("MATERIALTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeEqualTo(String value) {
            addCriterion("MATERIALTYPE =", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotEqualTo(String value) {
            addCriterion("MATERIALTYPE <>", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeGreaterThan(String value) {
            addCriterion("MATERIALTYPE >", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIALTYPE >=", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeLessThan(String value) {
            addCriterion("MATERIALTYPE <", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeLessThanOrEqualTo(String value) {
            addCriterion("MATERIALTYPE <=", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeLike(String value) {
            addCriterion("MATERIALTYPE like", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotLike(String value) {
            addCriterion("MATERIALTYPE not like", value, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeIn(List<String> values) {
            addCriterion("MATERIALTYPE in", values, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotIn(List<String> values) {
            addCriterion("MATERIALTYPE not in", values, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeBetween(String value1, String value2) {
            addCriterion("MATERIALTYPE between", value1, value2, "materialtype");
            return (Criteria) this;
        }

        public Criteria andMaterialtypeNotBetween(String value1, String value2) {
            addCriterion("MATERIALTYPE not between", value1, value2, "materialtype");
            return (Criteria) this;
        }

        public Criteria andDelivernumberIsNull() {
            addCriterion("DELIVERNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDelivernumberIsNotNull() {
            addCriterion("DELIVERNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDelivernumberEqualTo(String value) {
            addCriterion("DELIVERNUMBER =", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberNotEqualTo(String value) {
            addCriterion("DELIVERNUMBER <>", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberGreaterThan(String value) {
            addCriterion("DELIVERNUMBER >", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERNUMBER >=", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberLessThan(String value) {
            addCriterion("DELIVERNUMBER <", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberLessThanOrEqualTo(String value) {
            addCriterion("DELIVERNUMBER <=", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberLike(String value) {
            addCriterion("DELIVERNUMBER like", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberNotLike(String value) {
            addCriterion("DELIVERNUMBER not like", value, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberIn(List<String> values) {
            addCriterion("DELIVERNUMBER in", values, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberNotIn(List<String> values) {
            addCriterion("DELIVERNUMBER not in", values, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberBetween(String value1, String value2) {
            addCriterion("DELIVERNUMBER between", value1, value2, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andDelivernumberNotBetween(String value1, String value2) {
            addCriterion("DELIVERNUMBER not between", value1, value2, "delivernumber");
            return (Criteria) this;
        }

        public Criteria andPoIsNull() {
            addCriterion("PO is null");
            return (Criteria) this;
        }

        public Criteria andPoIsNotNull() {
            addCriterion("PO is not null");
            return (Criteria) this;
        }

        public Criteria andPoEqualTo(String value) {
            addCriterion("PO =", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoNotEqualTo(String value) {
            addCriterion("PO <>", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoGreaterThan(String value) {
            addCriterion("PO >", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoGreaterThanOrEqualTo(String value) {
            addCriterion("PO >=", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoLessThan(String value) {
            addCriterion("PO <", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoLessThanOrEqualTo(String value) {
            addCriterion("PO <=", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoLike(String value) {
            addCriterion("PO like", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoNotLike(String value) {
            addCriterion("PO not like", value, "po");
            return (Criteria) this;
        }

        public Criteria andPoIn(List<String> values) {
            addCriterion("PO in", values, "po");
            return (Criteria) this;
        }

        public Criteria andPoNotIn(List<String> values) {
            addCriterion("PO not in", values, "po");
            return (Criteria) this;
        }

        public Criteria andPoBetween(String value1, String value2) {
            addCriterion("PO between", value1, value2, "po");
            return (Criteria) this;
        }

        public Criteria andPoNotBetween(String value1, String value2) {
            addCriterion("PO not between", value1, value2, "po");
            return (Criteria) this;
        }

        public Criteria andPnIsNull() {
            addCriterion("PN is null");
            return (Criteria) this;
        }

        public Criteria andPnIsNotNull() {
            addCriterion("PN is not null");
            return (Criteria) this;
        }

        public Criteria andPnEqualTo(String value) {
            addCriterion("PN =", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotEqualTo(String value) {
            addCriterion("PN <>", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnGreaterThan(String value) {
            addCriterion("PN >", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnGreaterThanOrEqualTo(String value) {
            addCriterion("PN >=", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLessThan(String value) {
            addCriterion("PN <", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLessThanOrEqualTo(String value) {
            addCriterion("PN <=", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnLike(String value) {
            addCriterion("PN like", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotLike(String value) {
            addCriterion("PN not like", value, "pn");
            return (Criteria) this;
        }

        public Criteria andPnIn(List<String> values) {
            addCriterion("PN in", values, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotIn(List<String> values) {
            addCriterion("PN not in", values, "pn");
            return (Criteria) this;
        }

        public Criteria andPnBetween(String value1, String value2) {
            addCriterion("PN between", value1, value2, "pn");
            return (Criteria) this;
        }

        public Criteria andPnNotBetween(String value1, String value2) {
            addCriterion("PN not between", value1, value2, "pn");
            return (Criteria) this;
        }

        public Criteria andVendorcodeIsNull() {
            addCriterion("VENDORCODE is null");
            return (Criteria) this;
        }

        public Criteria andVendorcodeIsNotNull() {
            addCriterion("VENDORCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVendorcodeEqualTo(String value) {
            addCriterion("VENDORCODE =", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotEqualTo(String value) {
            addCriterion("VENDORCODE <>", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeGreaterThan(String value) {
            addCriterion("VENDORCODE >", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VENDORCODE >=", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeLessThan(String value) {
            addCriterion("VENDORCODE <", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeLessThanOrEqualTo(String value) {
            addCriterion("VENDORCODE <=", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeLike(String value) {
            addCriterion("VENDORCODE like", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotLike(String value) {
            addCriterion("VENDORCODE not like", value, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeIn(List<String> values) {
            addCriterion("VENDORCODE in", values, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotIn(List<String> values) {
            addCriterion("VENDORCODE not in", values, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeBetween(String value1, String value2) {
            addCriterion("VENDORCODE between", value1, value2, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendorcodeNotBetween(String value1, String value2) {
            addCriterion("VENDORCODE not between", value1, value2, "vendorcode");
            return (Criteria) this;
        }

        public Criteria andVendornameIsNull() {
            addCriterion("VENDORNAME is null");
            return (Criteria) this;
        }

        public Criteria andVendornameIsNotNull() {
            addCriterion("VENDORNAME is not null");
            return (Criteria) this;
        }

        public Criteria andVendornameEqualTo(String value) {
            addCriterion("VENDORNAME =", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameNotEqualTo(String value) {
            addCriterion("VENDORNAME <>", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameGreaterThan(String value) {
            addCriterion("VENDORNAME >", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameGreaterThanOrEqualTo(String value) {
            addCriterion("VENDORNAME >=", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameLessThan(String value) {
            addCriterion("VENDORNAME <", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameLessThanOrEqualTo(String value) {
            addCriterion("VENDORNAME <=", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameLike(String value) {
            addCriterion("VENDORNAME like", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameNotLike(String value) {
            addCriterion("VENDORNAME not like", value, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameIn(List<String> values) {
            addCriterion("VENDORNAME in", values, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameNotIn(List<String> values) {
            addCriterion("VENDORNAME not in", values, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameBetween(String value1, String value2) {
            addCriterion("VENDORNAME between", value1, value2, "vendorname");
            return (Criteria) this;
        }

        public Criteria andVendornameNotBetween(String value1, String value2) {
            addCriterion("VENDORNAME not between", value1, value2, "vendorname");
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

        public Criteria andRemainingqtyIsNull() {
            addCriterion("REMAININGQTY is null");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyIsNotNull() {
            addCriterion("REMAININGQTY is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyEqualTo(Short value) {
            addCriterion("REMAININGQTY =", value, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyNotEqualTo(Short value) {
            addCriterion("REMAININGQTY <>", value, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyGreaterThan(Short value) {
            addCriterion("REMAININGQTY >", value, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyGreaterThanOrEqualTo(Short value) {
            addCriterion("REMAININGQTY >=", value, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyLessThan(Short value) {
            addCriterion("REMAININGQTY <", value, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyLessThanOrEqualTo(Short value) {
            addCriterion("REMAININGQTY <=", value, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyIn(List<Short> values) {
            addCriterion("REMAININGQTY in", values, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyNotIn(List<Short> values) {
            addCriterion("REMAININGQTY not in", values, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyBetween(Short value1, Short value2) {
            addCriterion("REMAININGQTY between", value1, value2, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andRemainingqtyNotBetween(Short value1, Short value2) {
            addCriterion("REMAININGQTY not between", value1, value2, "remainingqty");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIsNull() {
            addCriterion("CHECKSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIsNotNull() {
            addCriterion("CHECKSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusEqualTo(String value) {
            addCriterion("CHECKSTATUS =", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotEqualTo(String value) {
            addCriterion("CHECKSTATUS <>", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThan(String value) {
            addCriterion("CHECKSTATUS >", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKSTATUS >=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThan(String value) {
            addCriterion("CHECKSTATUS <", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThanOrEqualTo(String value) {
            addCriterion("CHECKSTATUS <=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLike(String value) {
            addCriterion("CHECKSTATUS like", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotLike(String value) {
            addCriterion("CHECKSTATUS not like", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIn(List<String> values) {
            addCriterion("CHECKSTATUS in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotIn(List<String> values) {
            addCriterion("CHECKSTATUS not in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusBetween(String value1, String value2) {
            addCriterion("CHECKSTATUS between", value1, value2, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotBetween(String value1, String value2) {
            addCriterion("CHECKSTATUS not between", value1, value2, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoIsNull() {
            addCriterion("VENDORLOTNO is null");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoIsNotNull() {
            addCriterion("VENDORLOTNO is not null");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoEqualTo(String value) {
            addCriterion("VENDORLOTNO =", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoNotEqualTo(String value) {
            addCriterion("VENDORLOTNO <>", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoGreaterThan(String value) {
            addCriterion("VENDORLOTNO >", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoGreaterThanOrEqualTo(String value) {
            addCriterion("VENDORLOTNO >=", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoLessThan(String value) {
            addCriterion("VENDORLOTNO <", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoLessThanOrEqualTo(String value) {
            addCriterion("VENDORLOTNO <=", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoLike(String value) {
            addCriterion("VENDORLOTNO like", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoNotLike(String value) {
            addCriterion("VENDORLOTNO not like", value, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoIn(List<String> values) {
            addCriterion("VENDORLOTNO in", values, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoNotIn(List<String> values) {
            addCriterion("VENDORLOTNO not in", values, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoBetween(String value1, String value2) {
            addCriterion("VENDORLOTNO between", value1, value2, "vendorlotno");
            return (Criteria) this;
        }

        public Criteria andVendorlotnoNotBetween(String value1, String value2) {
            addCriterion("VENDORLOTNO not between", value1, value2, "vendorlotno");
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

        public Criteria andCheckresultIsNull() {
            addCriterion("CHECKRESULT is null");
            return (Criteria) this;
        }

        public Criteria andCheckresultIsNotNull() {
            addCriterion("CHECKRESULT is not null");
            return (Criteria) this;
        }

        public Criteria andCheckresultEqualTo(String value) {
            addCriterion("CHECKRESULT =", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultNotEqualTo(String value) {
            addCriterion("CHECKRESULT <>", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultGreaterThan(String value) {
            addCriterion("CHECKRESULT >", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKRESULT >=", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultLessThan(String value) {
            addCriterion("CHECKRESULT <", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultLessThanOrEqualTo(String value) {
            addCriterion("CHECKRESULT <=", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultLike(String value) {
            addCriterion("CHECKRESULT like", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultNotLike(String value) {
            addCriterion("CHECKRESULT not like", value, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultIn(List<String> values) {
            addCriterion("CHECKRESULT in", values, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultNotIn(List<String> values) {
            addCriterion("CHECKRESULT not in", values, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultBetween(String value1, String value2) {
            addCriterion("CHECKRESULT between", value1, value2, "checkresult");
            return (Criteria) this;
        }

        public Criteria andCheckresultNotBetween(String value1, String value2) {
            addCriterion("CHECKRESULT not between", value1, value2, "checkresult");
            return (Criteria) this;
        }

        public Criteria andPolinenumIsNull() {
            addCriterion("POLINENUM is null");
            return (Criteria) this;
        }

        public Criteria andPolinenumIsNotNull() {
            addCriterion("POLINENUM is not null");
            return (Criteria) this;
        }

        public Criteria andPolinenumEqualTo(Short value) {
            addCriterion("POLINENUM =", value, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumNotEqualTo(Short value) {
            addCriterion("POLINENUM <>", value, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumGreaterThan(Short value) {
            addCriterion("POLINENUM >", value, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumGreaterThanOrEqualTo(Short value) {
            addCriterion("POLINENUM >=", value, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumLessThan(Short value) {
            addCriterion("POLINENUM <", value, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumLessThanOrEqualTo(Short value) {
            addCriterion("POLINENUM <=", value, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumIn(List<Short> values) {
            addCriterion("POLINENUM in", values, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumNotIn(List<Short> values) {
            addCriterion("POLINENUM not in", values, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumBetween(Short value1, Short value2) {
            addCriterion("POLINENUM between", value1, value2, "polinenum");
            return (Criteria) this;
        }

        public Criteria andPolinenumNotBetween(Short value1, Short value2) {
            addCriterion("POLINENUM not between", value1, value2, "polinenum");
            return (Criteria) this;
        }

        public Criteria andHeaderidIsNull() {
            addCriterion("HEADERID is null");
            return (Criteria) this;
        }

        public Criteria andHeaderidIsNotNull() {
            addCriterion("HEADERID is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderidEqualTo(Short value) {
            addCriterion("HEADERID =", value, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidNotEqualTo(Short value) {
            addCriterion("HEADERID <>", value, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidGreaterThan(Short value) {
            addCriterion("HEADERID >", value, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidGreaterThanOrEqualTo(Short value) {
            addCriterion("HEADERID >=", value, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidLessThan(Short value) {
            addCriterion("HEADERID <", value, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidLessThanOrEqualTo(Short value) {
            addCriterion("HEADERID <=", value, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidIn(List<Short> values) {
            addCriterion("HEADERID in", values, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidNotIn(List<Short> values) {
            addCriterion("HEADERID not in", values, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidBetween(Short value1, Short value2) {
            addCriterion("HEADERID between", value1, value2, "headerid");
            return (Criteria) this;
        }

        public Criteria andHeaderidNotBetween(Short value1, Short value2) {
            addCriterion("HEADERID not between", value1, value2, "headerid");
            return (Criteria) this;
        }

        public Criteria andTransactionidIsNull() {
            addCriterion("TRANSACTIONID is null");
            return (Criteria) this;
        }

        public Criteria andTransactionidIsNotNull() {
            addCriterion("TRANSACTIONID is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionidEqualTo(String value) {
            addCriterion("TRANSACTIONID =", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotEqualTo(String value) {
            addCriterion("TRANSACTIONID <>", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidGreaterThan(String value) {
            addCriterion("TRANSACTIONID >", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSACTIONID >=", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLessThan(String value) {
            addCriterion("TRANSACTIONID <", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLessThanOrEqualTo(String value) {
            addCriterion("TRANSACTIONID <=", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLike(String value) {
            addCriterion("TRANSACTIONID like", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotLike(String value) {
            addCriterion("TRANSACTIONID not like", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidIn(List<String> values) {
            addCriterion("TRANSACTIONID in", values, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotIn(List<String> values) {
            addCriterion("TRANSACTIONID not in", values, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidBetween(String value1, String value2) {
            addCriterion("TRANSACTIONID between", value1, value2, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotBetween(String value1, String value2) {
            addCriterion("TRANSACTIONID not between", value1, value2, "transactionid");
            return (Criteria) this;
        }

        public Criteria andLineidIsNull() {
            addCriterion("LINEID is null");
            return (Criteria) this;
        }

        public Criteria andLineidIsNotNull() {
            addCriterion("LINEID is not null");
            return (Criteria) this;
        }

        public Criteria andLineidEqualTo(Short value) {
            addCriterion("LINEID =", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotEqualTo(Short value) {
            addCriterion("LINEID <>", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThan(Short value) {
            addCriterion("LINEID >", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidGreaterThanOrEqualTo(Short value) {
            addCriterion("LINEID >=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThan(Short value) {
            addCriterion("LINEID <", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidLessThanOrEqualTo(Short value) {
            addCriterion("LINEID <=", value, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidIn(List<Short> values) {
            addCriterion("LINEID in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotIn(List<Short> values) {
            addCriterion("LINEID not in", values, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidBetween(Short value1, Short value2) {
            addCriterion("LINEID between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andLineidNotBetween(Short value1, Short value2) {
            addCriterion("LINEID not between", value1, value2, "lineid");
            return (Criteria) this;
        }

        public Criteria andSonumberIsNull() {
            addCriterion("SONUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSonumberIsNotNull() {
            addCriterion("SONUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSonumberEqualTo(String value) {
            addCriterion("SONUMBER =", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberNotEqualTo(String value) {
            addCriterion("SONUMBER <>", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberGreaterThan(String value) {
            addCriterion("SONUMBER >", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberGreaterThanOrEqualTo(String value) {
            addCriterion("SONUMBER >=", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberLessThan(String value) {
            addCriterion("SONUMBER <", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberLessThanOrEqualTo(String value) {
            addCriterion("SONUMBER <=", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberLike(String value) {
            addCriterion("SONUMBER like", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberNotLike(String value) {
            addCriterion("SONUMBER not like", value, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberIn(List<String> values) {
            addCriterion("SONUMBER in", values, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberNotIn(List<String> values) {
            addCriterion("SONUMBER not in", values, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberBetween(String value1, String value2) {
            addCriterion("SONUMBER between", value1, value2, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSonumberNotBetween(String value1, String value2) {
            addCriterion("SONUMBER not between", value1, value2, "sonumber");
            return (Criteria) this;
        }

        public Criteria andSolinenumIsNull() {
            addCriterion("SOLINENUM is null");
            return (Criteria) this;
        }

        public Criteria andSolinenumIsNotNull() {
            addCriterion("SOLINENUM is not null");
            return (Criteria) this;
        }

        public Criteria andSolinenumEqualTo(String value) {
            addCriterion("SOLINENUM =", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumNotEqualTo(String value) {
            addCriterion("SOLINENUM <>", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumGreaterThan(String value) {
            addCriterion("SOLINENUM >", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumGreaterThanOrEqualTo(String value) {
            addCriterion("SOLINENUM >=", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumLessThan(String value) {
            addCriterion("SOLINENUM <", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumLessThanOrEqualTo(String value) {
            addCriterion("SOLINENUM <=", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumLike(String value) {
            addCriterion("SOLINENUM like", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumNotLike(String value) {
            addCriterion("SOLINENUM not like", value, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumIn(List<String> values) {
            addCriterion("SOLINENUM in", values, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumNotIn(List<String> values) {
            addCriterion("SOLINENUM not in", values, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumBetween(String value1, String value2) {
            addCriterion("SOLINENUM between", value1, value2, "solinenum");
            return (Criteria) this;
        }

        public Criteria andSolinenumNotBetween(String value1, String value2) {
            addCriterion("SOLINENUM not between", value1, value2, "solinenum");
            return (Criteria) this;
        }

        public Criteria andRmapoIsNull() {
            addCriterion("RMAPO is null");
            return (Criteria) this;
        }

        public Criteria andRmapoIsNotNull() {
            addCriterion("RMAPO is not null");
            return (Criteria) this;
        }

        public Criteria andRmapoEqualTo(String value) {
            addCriterion("RMAPO =", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoNotEqualTo(String value) {
            addCriterion("RMAPO <>", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoGreaterThan(String value) {
            addCriterion("RMAPO >", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoGreaterThanOrEqualTo(String value) {
            addCriterion("RMAPO >=", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoLessThan(String value) {
            addCriterion("RMAPO <", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoLessThanOrEqualTo(String value) {
            addCriterion("RMAPO <=", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoLike(String value) {
            addCriterion("RMAPO like", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoNotLike(String value) {
            addCriterion("RMAPO not like", value, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoIn(List<String> values) {
            addCriterion("RMAPO in", values, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoNotIn(List<String> values) {
            addCriterion("RMAPO not in", values, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoBetween(String value1, String value2) {
            addCriterion("RMAPO between", value1, value2, "rmapo");
            return (Criteria) this;
        }

        public Criteria andRmapoNotBetween(String value1, String value2) {
            addCriterion("RMAPO not between", value1, value2, "rmapo");
            return (Criteria) this;
        }

        public Criteria andMoIsNull() {
            addCriterion("MO is null");
            return (Criteria) this;
        }

        public Criteria andMoIsNotNull() {
            addCriterion("MO is not null");
            return (Criteria) this;
        }

        public Criteria andMoEqualTo(String value) {
            addCriterion("MO =", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotEqualTo(String value) {
            addCriterion("MO <>", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThan(String value) {
            addCriterion("MO >", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThanOrEqualTo(String value) {
            addCriterion("MO >=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThan(String value) {
            addCriterion("MO <", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThanOrEqualTo(String value) {
            addCriterion("MO <=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLike(String value) {
            addCriterion("MO like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotLike(String value) {
            addCriterion("MO not like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoIn(List<String> values) {
            addCriterion("MO in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotIn(List<String> values) {
            addCriterion("MO not in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoBetween(String value1, String value2) {
            addCriterion("MO between", value1, value2, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotBetween(String value1, String value2) {
            addCriterion("MO not between", value1, value2, "mo");
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

        public Criteria andVerdorsiteidIsNull() {
            addCriterion("VERDORSITEID is null");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidIsNotNull() {
            addCriterion("VERDORSITEID is not null");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidEqualTo(Short value) {
            addCriterion("VERDORSITEID =", value, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidNotEqualTo(Short value) {
            addCriterion("VERDORSITEID <>", value, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidGreaterThan(Short value) {
            addCriterion("VERDORSITEID >", value, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidGreaterThanOrEqualTo(Short value) {
            addCriterion("VERDORSITEID >=", value, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidLessThan(Short value) {
            addCriterion("VERDORSITEID <", value, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidLessThanOrEqualTo(Short value) {
            addCriterion("VERDORSITEID <=", value, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidIn(List<Short> values) {
            addCriterion("VERDORSITEID in", values, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidNotIn(List<Short> values) {
            addCriterion("VERDORSITEID not in", values, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidBetween(Short value1, Short value2) {
            addCriterion("VERDORSITEID between", value1, value2, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVerdorsiteidNotBetween(Short value1, Short value2) {
            addCriterion("VERDORSITEID not between", value1, value2, "verdorsiteid");
            return (Criteria) this;
        }

        public Criteria andVmiIsNull() {
            addCriterion("VMI is null");
            return (Criteria) this;
        }

        public Criteria andVmiIsNotNull() {
            addCriterion("VMI is not null");
            return (Criteria) this;
        }

        public Criteria andVmiEqualTo(String value) {
            addCriterion("VMI =", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiNotEqualTo(String value) {
            addCriterion("VMI <>", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiGreaterThan(String value) {
            addCriterion("VMI >", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiGreaterThanOrEqualTo(String value) {
            addCriterion("VMI >=", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiLessThan(String value) {
            addCriterion("VMI <", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiLessThanOrEqualTo(String value) {
            addCriterion("VMI <=", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiLike(String value) {
            addCriterion("VMI like", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiNotLike(String value) {
            addCriterion("VMI not like", value, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiIn(List<String> values) {
            addCriterion("VMI in", values, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiNotIn(List<String> values) {
            addCriterion("VMI not in", values, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiBetween(String value1, String value2) {
            addCriterion("VMI between", value1, value2, "vmi");
            return (Criteria) this;
        }

        public Criteria andVmiNotBetween(String value1, String value2) {
            addCriterion("VMI not between", value1, value2, "vmi");
            return (Criteria) this;
        }

        public Criteria andObj01IsNull() {
            addCriterion("OBJ01 is null");
            return (Criteria) this;
        }

        public Criteria andObj01IsNotNull() {
            addCriterion("OBJ01 is not null");
            return (Criteria) this;
        }

        public Criteria andObj01EqualTo(String value) {
            addCriterion("OBJ01 =", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotEqualTo(String value) {
            addCriterion("OBJ01 <>", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01GreaterThan(String value) {
            addCriterion("OBJ01 >", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ01 >=", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01LessThan(String value) {
            addCriterion("OBJ01 <", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01LessThanOrEqualTo(String value) {
            addCriterion("OBJ01 <=", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01Like(String value) {
            addCriterion("OBJ01 like", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotLike(String value) {
            addCriterion("OBJ01 not like", value, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01In(List<String> values) {
            addCriterion("OBJ01 in", values, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotIn(List<String> values) {
            addCriterion("OBJ01 not in", values, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01Between(String value1, String value2) {
            addCriterion("OBJ01 between", value1, value2, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj01NotBetween(String value1, String value2) {
            addCriterion("OBJ01 not between", value1, value2, "obj01");
            return (Criteria) this;
        }

        public Criteria andObj02IsNull() {
            addCriterion("OBJ02 is null");
            return (Criteria) this;
        }

        public Criteria andObj02IsNotNull() {
            addCriterion("OBJ02 is not null");
            return (Criteria) this;
        }

        public Criteria andObj02EqualTo(String value) {
            addCriterion("OBJ02 =", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotEqualTo(String value) {
            addCriterion("OBJ02 <>", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02GreaterThan(String value) {
            addCriterion("OBJ02 >", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02GreaterThanOrEqualTo(String value) {
            addCriterion("OBJ02 >=", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02LessThan(String value) {
            addCriterion("OBJ02 <", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02LessThanOrEqualTo(String value) {
            addCriterion("OBJ02 <=", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02Like(String value) {
            addCriterion("OBJ02 like", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotLike(String value) {
            addCriterion("OBJ02 not like", value, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02In(List<String> values) {
            addCriterion("OBJ02 in", values, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotIn(List<String> values) {
            addCriterion("OBJ02 not in", values, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02Between(String value1, String value2) {
            addCriterion("OBJ02 between", value1, value2, "obj02");
            return (Criteria) this;
        }

        public Criteria andObj02NotBetween(String value1, String value2) {
            addCriterion("OBJ02 not between", value1, value2, "obj02");
            return (Criteria) this;
        }

        public Criteria andLimiteddayIsNull() {
            addCriterion("LIMITEDDAY is null");
            return (Criteria) this;
        }

        public Criteria andLimiteddayIsNotNull() {
            addCriterion("LIMITEDDAY is not null");
            return (Criteria) this;
        }

        public Criteria andLimiteddayEqualTo(Date value) {
            addCriterion("LIMITEDDAY =", value, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayNotEqualTo(Date value) {
            addCriterion("LIMITEDDAY <>", value, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayGreaterThan(Date value) {
            addCriterion("LIMITEDDAY >", value, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayGreaterThanOrEqualTo(Date value) {
            addCriterion("LIMITEDDAY >=", value, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayLessThan(Date value) {
            addCriterion("LIMITEDDAY <", value, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayLessThanOrEqualTo(Date value) {
            addCriterion("LIMITEDDAY <=", value, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayIn(List<Date> values) {
            addCriterion("LIMITEDDAY in", values, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayNotIn(List<Date> values) {
            addCriterion("LIMITEDDAY not in", values, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayBetween(Date value1, Date value2) {
            addCriterion("LIMITEDDAY between", value1, value2, "limitedday");
            return (Criteria) this;
        }

        public Criteria andLimiteddayNotBetween(Date value1, Date value2) {
            addCriterion("LIMITEDDAY not between", value1, value2, "limitedday");
            return (Criteria) this;
        }

        public Criteria andPackstyleIsNull() {
            addCriterion("PACKSTYLE is null");
            return (Criteria) this;
        }

        public Criteria andPackstyleIsNotNull() {
            addCriterion("PACKSTYLE is not null");
            return (Criteria) this;
        }

        public Criteria andPackstyleEqualTo(String value) {
            addCriterion("PACKSTYLE =", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleNotEqualTo(String value) {
            addCriterion("PACKSTYLE <>", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleGreaterThan(String value) {
            addCriterion("PACKSTYLE >", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleGreaterThanOrEqualTo(String value) {
            addCriterion("PACKSTYLE >=", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleLessThan(String value) {
            addCriterion("PACKSTYLE <", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleLessThanOrEqualTo(String value) {
            addCriterion("PACKSTYLE <=", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleLike(String value) {
            addCriterion("PACKSTYLE like", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleNotLike(String value) {
            addCriterion("PACKSTYLE not like", value, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleIn(List<String> values) {
            addCriterion("PACKSTYLE in", values, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleNotIn(List<String> values) {
            addCriterion("PACKSTYLE not in", values, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleBetween(String value1, String value2) {
            addCriterion("PACKSTYLE between", value1, value2, "packstyle");
            return (Criteria) this;
        }

        public Criteria andPackstyleNotBetween(String value1, String value2) {
            addCriterion("PACKSTYLE not between", value1, value2, "packstyle");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeIsNull() {
            addCriterion("VENDORWEEKCODE is null");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeIsNotNull() {
            addCriterion("VENDORWEEKCODE is not null");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeEqualTo(String value) {
            addCriterion("VENDORWEEKCODE =", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeNotEqualTo(String value) {
            addCriterion("VENDORWEEKCODE <>", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeGreaterThan(String value) {
            addCriterion("VENDORWEEKCODE >", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeGreaterThanOrEqualTo(String value) {
            addCriterion("VENDORWEEKCODE >=", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeLessThan(String value) {
            addCriterion("VENDORWEEKCODE <", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeLessThanOrEqualTo(String value) {
            addCriterion("VENDORWEEKCODE <=", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeLike(String value) {
            addCriterion("VENDORWEEKCODE like", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeNotLike(String value) {
            addCriterion("VENDORWEEKCODE not like", value, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeIn(List<String> values) {
            addCriterion("VENDORWEEKCODE in", values, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeNotIn(List<String> values) {
            addCriterion("VENDORWEEKCODE not in", values, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeBetween(String value1, String value2) {
            addCriterion("VENDORWEEKCODE between", value1, value2, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andVendorweekcodeNotBetween(String value1, String value2) {
            addCriterion("VENDORWEEKCODE not between", value1, value2, "vendorweekcode");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageIsNull() {
            addCriterion("MATERIALSTORAGE is null");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageIsNotNull() {
            addCriterion("MATERIALSTORAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageEqualTo(String value) {
            addCriterion("MATERIALSTORAGE =", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageNotEqualTo(String value) {
            addCriterion("MATERIALSTORAGE <>", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageGreaterThan(String value) {
            addCriterion("MATERIALSTORAGE >", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIALSTORAGE >=", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageLessThan(String value) {
            addCriterion("MATERIALSTORAGE <", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageLessThanOrEqualTo(String value) {
            addCriterion("MATERIALSTORAGE <=", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageLike(String value) {
            addCriterion("MATERIALSTORAGE like", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageNotLike(String value) {
            addCriterion("MATERIALSTORAGE not like", value, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageIn(List<String> values) {
            addCriterion("MATERIALSTORAGE in", values, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageNotIn(List<String> values) {
            addCriterion("MATERIALSTORAGE not in", values, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageBetween(String value1, String value2) {
            addCriterion("MATERIALSTORAGE between", value1, value2, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMaterialstorageNotBetween(String value1, String value2) {
            addCriterion("MATERIALSTORAGE not between", value1, value2, "materialstorage");
            return (Criteria) this;
        }

        public Criteria andMsdIsNull() {
            addCriterion("MSD is null");
            return (Criteria) this;
        }

        public Criteria andMsdIsNotNull() {
            addCriterion("MSD is not null");
            return (Criteria) this;
        }

        public Criteria andMsdEqualTo(String value) {
            addCriterion("MSD =", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdNotEqualTo(String value) {
            addCriterion("MSD <>", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdGreaterThan(String value) {
            addCriterion("MSD >", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdGreaterThanOrEqualTo(String value) {
            addCriterion("MSD >=", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdLessThan(String value) {
            addCriterion("MSD <", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdLessThanOrEqualTo(String value) {
            addCriterion("MSD <=", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdLike(String value) {
            addCriterion("MSD like", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdNotLike(String value) {
            addCriterion("MSD not like", value, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdIn(List<String> values) {
            addCriterion("MSD in", values, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdNotIn(List<String> values) {
            addCriterion("MSD not in", values, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdBetween(String value1, String value2) {
            addCriterion("MSD between", value1, value2, "msd");
            return (Criteria) this;
        }

        public Criteria andMsdNotBetween(String value1, String value2) {
            addCriterion("MSD not between", value1, value2, "msd");
            return (Criteria) this;
        }

        public Criteria andEsdIsNull() {
            addCriterion("ESD is null");
            return (Criteria) this;
        }

        public Criteria andEsdIsNotNull() {
            addCriterion("ESD is not null");
            return (Criteria) this;
        }

        public Criteria andEsdEqualTo(String value) {
            addCriterion("ESD =", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdNotEqualTo(String value) {
            addCriterion("ESD <>", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdGreaterThan(String value) {
            addCriterion("ESD >", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdGreaterThanOrEqualTo(String value) {
            addCriterion("ESD >=", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdLessThan(String value) {
            addCriterion("ESD <", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdLessThanOrEqualTo(String value) {
            addCriterion("ESD <=", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdLike(String value) {
            addCriterion("ESD like", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdNotLike(String value) {
            addCriterion("ESD not like", value, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdIn(List<String> values) {
            addCriterion("ESD in", values, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdNotIn(List<String> values) {
            addCriterion("ESD not in", values, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdBetween(String value1, String value2) {
            addCriterion("ESD between", value1, value2, "esd");
            return (Criteria) this;
        }

        public Criteria andEsdNotBetween(String value1, String value2) {
            addCriterion("ESD not between", value1, value2, "esd");
            return (Criteria) this;
        }

        public Criteria andVendorsnIsNull() {
            addCriterion("VENDORSN is null");
            return (Criteria) this;
        }

        public Criteria andVendorsnIsNotNull() {
            addCriterion("VENDORSN is not null");
            return (Criteria) this;
        }

        public Criteria andVendorsnEqualTo(String value) {
            addCriterion("VENDORSN =", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnNotEqualTo(String value) {
            addCriterion("VENDORSN <>", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnGreaterThan(String value) {
            addCriterion("VENDORSN >", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnGreaterThanOrEqualTo(String value) {
            addCriterion("VENDORSN >=", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnLessThan(String value) {
            addCriterion("VENDORSN <", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnLessThanOrEqualTo(String value) {
            addCriterion("VENDORSN <=", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnLike(String value) {
            addCriterion("VENDORSN like", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnNotLike(String value) {
            addCriterion("VENDORSN not like", value, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnIn(List<String> values) {
            addCriterion("VENDORSN in", values, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnNotIn(List<String> values) {
            addCriterion("VENDORSN not in", values, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnBetween(String value1, String value2) {
            addCriterion("VENDORSN between", value1, value2, "vendorsn");
            return (Criteria) this;
        }

        public Criteria andVendorsnNotBetween(String value1, String value2) {
            addCriterion("VENDORSN not between", value1, value2, "vendorsn");
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