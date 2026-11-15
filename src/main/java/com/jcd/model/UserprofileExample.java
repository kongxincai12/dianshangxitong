package com.jcd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserprofileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserprofileExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
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

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNull() {
            addCriterion("FULLNAME is null");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNotNull() {
            addCriterion("FULLNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFullnameEqualTo(String value) {
            addCriterion("FULLNAME =", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotEqualTo(String value) {
            addCriterion("FULLNAME <>", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThan(String value) {
            addCriterion("FULLNAME >", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("FULLNAME >=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThan(String value) {
            addCriterion("FULLNAME <", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThanOrEqualTo(String value) {
            addCriterion("FULLNAME <=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLike(String value) {
            addCriterion("FULLNAME like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotLike(String value) {
            addCriterion("FULLNAME not like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameIn(List<String> values) {
            addCriterion("FULLNAME in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotIn(List<String> values) {
            addCriterion("FULLNAME not in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameBetween(String value1, String value2) {
            addCriterion("FULLNAME between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotBetween(String value1, String value2) {
            addCriterion("FULLNAME not between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andActivationdateIsNull() {
            addCriterion("ACTIVATIONDATE is null");
            return (Criteria) this;
        }

        public Criteria andActivationdateIsNotNull() {
            addCriterion("ACTIVATIONDATE is not null");
            return (Criteria) this;
        }

        public Criteria andActivationdateEqualTo(Date value) {
            addCriterion("ACTIVATIONDATE =", value, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateNotEqualTo(Date value) {
            addCriterion("ACTIVATIONDATE <>", value, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateGreaterThan(Date value) {
            addCriterion("ACTIVATIONDATE >", value, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateGreaterThanOrEqualTo(Date value) {
            addCriterion("ACTIVATIONDATE >=", value, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateLessThan(Date value) {
            addCriterion("ACTIVATIONDATE <", value, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateLessThanOrEqualTo(Date value) {
            addCriterion("ACTIVATIONDATE <=", value, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateIn(List<Date> values) {
            addCriterion("ACTIVATIONDATE in", values, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateNotIn(List<Date> values) {
            addCriterion("ACTIVATIONDATE not in", values, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateBetween(Date value1, Date value2) {
            addCriterion("ACTIVATIONDATE between", value1, value2, "activationdate");
            return (Criteria) this;
        }

        public Criteria andActivationdateNotBetween(Date value1, Date value2) {
            addCriterion("ACTIVATIONDATE not between", value1, value2, "activationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNull() {
            addCriterion("EXPIRATIONDATE is null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIsNotNull() {
            addCriterion("EXPIRATIONDATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationdateEqualTo(Date value) {
            addCriterion("EXPIRATIONDATE =", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotEqualTo(Date value) {
            addCriterion("EXPIRATIONDATE <>", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThan(Date value) {
            addCriterion("EXPIRATIONDATE >", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPIRATIONDATE >=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThan(Date value) {
            addCriterion("EXPIRATIONDATE <", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateLessThanOrEqualTo(Date value) {
            addCriterion("EXPIRATIONDATE <=", value, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateIn(List<Date> values) {
            addCriterion("EXPIRATIONDATE in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotIn(List<Date> values) {
            addCriterion("EXPIRATIONDATE not in", values, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateBetween(Date value1, Date value2) {
            addCriterion("EXPIRATIONDATE between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdateNotBetween(Date value1, Date value2) {
            addCriterion("EXPIRATIONDATE not between", value1, value2, "expirationdate");
            return (Criteria) this;
        }

        public Criteria andAgainperiodIsNull() {
            addCriterion("AGAINPERIOD is null");
            return (Criteria) this;
        }

        public Criteria andAgainperiodIsNotNull() {
            addCriterion("AGAINPERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andAgainperiodEqualTo(String value) {
            addCriterion("AGAINPERIOD =", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodNotEqualTo(String value) {
            addCriterion("AGAINPERIOD <>", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodGreaterThan(String value) {
            addCriterion("AGAINPERIOD >", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodGreaterThanOrEqualTo(String value) {
            addCriterion("AGAINPERIOD >=", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodLessThan(String value) {
            addCriterion("AGAINPERIOD <", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodLessThanOrEqualTo(String value) {
            addCriterion("AGAINPERIOD <=", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodLike(String value) {
            addCriterion("AGAINPERIOD like", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodNotLike(String value) {
            addCriterion("AGAINPERIOD not like", value, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodIn(List<String> values) {
            addCriterion("AGAINPERIOD in", values, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodNotIn(List<String> values) {
            addCriterion("AGAINPERIOD not in", values, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodBetween(String value1, String value2) {
            addCriterion("AGAINPERIOD between", value1, value2, "againperiod");
            return (Criteria) this;
        }

        public Criteria andAgainperiodNotBetween(String value1, String value2) {
            addCriterion("AGAINPERIOD not between", value1, value2, "againperiod");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateIsNull() {
            addCriterion("LASTPASSWORDDATE is null");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateIsNotNull() {
            addCriterion("LASTPASSWORDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateEqualTo(String value) {
            addCriterion("LASTPASSWORDDATE =", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateNotEqualTo(String value) {
            addCriterion("LASTPASSWORDDATE <>", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateGreaterThan(String value) {
            addCriterion("LASTPASSWORDDATE >", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateGreaterThanOrEqualTo(String value) {
            addCriterion("LASTPASSWORDDATE >=", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateLessThan(String value) {
            addCriterion("LASTPASSWORDDATE <", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateLessThanOrEqualTo(String value) {
            addCriterion("LASTPASSWORDDATE <=", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateLike(String value) {
            addCriterion("LASTPASSWORDDATE like", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateNotLike(String value) {
            addCriterion("LASTPASSWORDDATE not like", value, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateIn(List<String> values) {
            addCriterion("LASTPASSWORDDATE in", values, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateNotIn(List<String> values) {
            addCriterion("LASTPASSWORDDATE not in", values, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateBetween(String value1, String value2) {
            addCriterion("LASTPASSWORDDATE between", value1, value2, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andLastpassworddateNotBetween(String value1, String value2) {
            addCriterion("LASTPASSWORDDATE not between", value1, value2, "lastpassworddate");
            return (Criteria) this;
        }

        public Criteria andEmailaddressIsNull() {
            addCriterion("EMAILADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andEmailaddressIsNotNull() {
            addCriterion("EMAILADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andEmailaddressEqualTo(String value) {
            addCriterion("EMAILADDRESS =", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressNotEqualTo(String value) {
            addCriterion("EMAILADDRESS <>", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressGreaterThan(String value) {
            addCriterion("EMAILADDRESS >", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressGreaterThanOrEqualTo(String value) {
            addCriterion("EMAILADDRESS >=", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressLessThan(String value) {
            addCriterion("EMAILADDRESS <", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressLessThanOrEqualTo(String value) {
            addCriterion("EMAILADDRESS <=", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressLike(String value) {
            addCriterion("EMAILADDRESS like", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressNotLike(String value) {
            addCriterion("EMAILADDRESS not like", value, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressIn(List<String> values) {
            addCriterion("EMAILADDRESS in", values, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressNotIn(List<String> values) {
            addCriterion("EMAILADDRESS not in", values, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressBetween(String value1, String value2) {
            addCriterion("EMAILADDRESS between", value1, value2, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailaddressNotBetween(String value1, String value2) {
            addCriterion("EMAILADDRESS not between", value1, value2, "emailaddress");
            return (Criteria) this;
        }

        public Criteria andEmailpwdIsNull() {
            addCriterion("EMAILPWD is null");
            return (Criteria) this;
        }

        public Criteria andEmailpwdIsNotNull() {
            addCriterion("EMAILPWD is not null");
            return (Criteria) this;
        }

        public Criteria andEmailpwdEqualTo(String value) {
            addCriterion("EMAILPWD =", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdNotEqualTo(String value) {
            addCriterion("EMAILPWD <>", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdGreaterThan(String value) {
            addCriterion("EMAILPWD >", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdGreaterThanOrEqualTo(String value) {
            addCriterion("EMAILPWD >=", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdLessThan(String value) {
            addCriterion("EMAILPWD <", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdLessThanOrEqualTo(String value) {
            addCriterion("EMAILPWD <=", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdLike(String value) {
            addCriterion("EMAILPWD like", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdNotLike(String value) {
            addCriterion("EMAILPWD not like", value, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdIn(List<String> values) {
            addCriterion("EMAILPWD in", values, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdNotIn(List<String> values) {
            addCriterion("EMAILPWD not in", values, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdBetween(String value1, String value2) {
            addCriterion("EMAILPWD between", value1, value2, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailpwdNotBetween(String value1, String value2) {
            addCriterion("EMAILPWD not between", value1, value2, "emailpwd");
            return (Criteria) this;
        }

        public Criteria andEmailserverIsNull() {
            addCriterion("EMAILSERVER is null");
            return (Criteria) this;
        }

        public Criteria andEmailserverIsNotNull() {
            addCriterion("EMAILSERVER is not null");
            return (Criteria) this;
        }

        public Criteria andEmailserverEqualTo(String value) {
            addCriterion("EMAILSERVER =", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverNotEqualTo(String value) {
            addCriterion("EMAILSERVER <>", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverGreaterThan(String value) {
            addCriterion("EMAILSERVER >", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverGreaterThanOrEqualTo(String value) {
            addCriterion("EMAILSERVER >=", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverLessThan(String value) {
            addCriterion("EMAILSERVER <", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverLessThanOrEqualTo(String value) {
            addCriterion("EMAILSERVER <=", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverLike(String value) {
            addCriterion("EMAILSERVER like", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverNotLike(String value) {
            addCriterion("EMAILSERVER not like", value, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverIn(List<String> values) {
            addCriterion("EMAILSERVER in", values, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverNotIn(List<String> values) {
            addCriterion("EMAILSERVER not in", values, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverBetween(String value1, String value2) {
            addCriterion("EMAILSERVER between", value1, value2, "emailserver");
            return (Criteria) this;
        }

        public Criteria andEmailserverNotBetween(String value1, String value2) {
            addCriterion("EMAILSERVER not between", value1, value2, "emailserver");
            return (Criteria) this;
        }

        public Criteria andFactorynameIsNull() {
            addCriterion("FACTORYNAME is null");
            return (Criteria) this;
        }

        public Criteria andFactorynameIsNotNull() {
            addCriterion("FACTORYNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFactorynameEqualTo(String value) {
            addCriterion("FACTORYNAME =", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotEqualTo(String value) {
            addCriterion("FACTORYNAME <>", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameGreaterThan(String value) {
            addCriterion("FACTORYNAME >", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameGreaterThanOrEqualTo(String value) {
            addCriterion("FACTORYNAME >=", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameLessThan(String value) {
            addCriterion("FACTORYNAME <", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameLessThanOrEqualTo(String value) {
            addCriterion("FACTORYNAME <=", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameLike(String value) {
            addCriterion("FACTORYNAME like", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotLike(String value) {
            addCriterion("FACTORYNAME not like", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameIn(List<String> values) {
            addCriterion("FACTORYNAME in", values, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotIn(List<String> values) {
            addCriterion("FACTORYNAME not in", values, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameBetween(String value1, String value2) {
            addCriterion("FACTORYNAME between", value1, value2, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotBetween(String value1, String value2) {
            addCriterion("FACTORYNAME not between", value1, value2, "factoryname");
            return (Criteria) this;
        }

        public Criteria andLinenameIsNull() {
            addCriterion("LINENAME is null");
            return (Criteria) this;
        }

        public Criteria andLinenameIsNotNull() {
            addCriterion("LINENAME is not null");
            return (Criteria) this;
        }

        public Criteria andLinenameEqualTo(String value) {
            addCriterion("LINENAME =", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotEqualTo(String value) {
            addCriterion("LINENAME <>", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameGreaterThan(String value) {
            addCriterion("LINENAME >", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameGreaterThanOrEqualTo(String value) {
            addCriterion("LINENAME >=", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameLessThan(String value) {
            addCriterion("LINENAME <", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameLessThanOrEqualTo(String value) {
            addCriterion("LINENAME <=", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameLike(String value) {
            addCriterion("LINENAME like", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotLike(String value) {
            addCriterion("LINENAME not like", value, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameIn(List<String> values) {
            addCriterion("LINENAME in", values, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotIn(List<String> values) {
            addCriterion("LINENAME not in", values, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameBetween(String value1, String value2) {
            addCriterion("LINENAME between", value1, value2, "linename");
            return (Criteria) this;
        }

        public Criteria andLinenameNotBetween(String value1, String value2) {
            addCriterion("LINENAME not between", value1, value2, "linename");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("DEPARTMENT is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("DEPARTMENT is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("DEPARTMENT =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("DEPARTMENT <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("DEPARTMENT >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("DEPARTMENT <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("DEPARTMENT like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("DEPARTMENT not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("DEPARTMENT in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("DEPARTMENT not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("DEPARTMENT between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENT not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andUserpositionIsNull() {
            addCriterion("USERPOSITION is null");
            return (Criteria) this;
        }

        public Criteria andUserpositionIsNotNull() {
            addCriterion("USERPOSITION is not null");
            return (Criteria) this;
        }

        public Criteria andUserpositionEqualTo(String value) {
            addCriterion("USERPOSITION =", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotEqualTo(String value) {
            addCriterion("USERPOSITION <>", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionGreaterThan(String value) {
            addCriterion("USERPOSITION >", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionGreaterThanOrEqualTo(String value) {
            addCriterion("USERPOSITION >=", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionLessThan(String value) {
            addCriterion("USERPOSITION <", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionLessThanOrEqualTo(String value) {
            addCriterion("USERPOSITION <=", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionLike(String value) {
            addCriterion("USERPOSITION like", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotLike(String value) {
            addCriterion("USERPOSITION not like", value, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionIn(List<String> values) {
            addCriterion("USERPOSITION in", values, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotIn(List<String> values) {
            addCriterion("USERPOSITION not in", values, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionBetween(String value1, String value2) {
            addCriterion("USERPOSITION between", value1, value2, "userposition");
            return (Criteria) this;
        }

        public Criteria andUserpositionNotBetween(String value1, String value2) {
            addCriterion("USERPOSITION not between", value1, value2, "userposition");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("PHONENUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("PHONENUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("PHONENUMBER =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("PHONENUMBER <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("PHONENUMBER >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("PHONENUMBER >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("PHONENUMBER <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("PHONENUMBER <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("PHONENUMBER like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("PHONENUMBER not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("PHONENUMBER in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("PHONENUMBER not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("PHONENUMBER between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("PHONENUMBER not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andObject2IsNull() {
            addCriterion("OBJECT2 is null");
            return (Criteria) this;
        }

        public Criteria andObject2IsNotNull() {
            addCriterion("OBJECT2 is not null");
            return (Criteria) this;
        }

        public Criteria andObject2EqualTo(String value) {
            addCriterion("OBJECT2 =", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2NotEqualTo(String value) {
            addCriterion("OBJECT2 <>", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2GreaterThan(String value) {
            addCriterion("OBJECT2 >", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2GreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT2 >=", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2LessThan(String value) {
            addCriterion("OBJECT2 <", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2LessThanOrEqualTo(String value) {
            addCriterion("OBJECT2 <=", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2Like(String value) {
            addCriterion("OBJECT2 like", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2NotLike(String value) {
            addCriterion("OBJECT2 not like", value, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2In(List<String> values) {
            addCriterion("OBJECT2 in", values, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2NotIn(List<String> values) {
            addCriterion("OBJECT2 not in", values, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2Between(String value1, String value2) {
            addCriterion("OBJECT2 between", value1, value2, "object2");
            return (Criteria) this;
        }

        public Criteria andObject2NotBetween(String value1, String value2) {
            addCriterion("OBJECT2 not between", value1, value2, "object2");
            return (Criteria) this;
        }

        public Criteria andObject3IsNull() {
            addCriterion("OBJECT3 is null");
            return (Criteria) this;
        }

        public Criteria andObject3IsNotNull() {
            addCriterion("OBJECT3 is not null");
            return (Criteria) this;
        }

        public Criteria andObject3EqualTo(String value) {
            addCriterion("OBJECT3 =", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3NotEqualTo(String value) {
            addCriterion("OBJECT3 <>", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3GreaterThan(String value) {
            addCriterion("OBJECT3 >", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3GreaterThanOrEqualTo(String value) {
            addCriterion("OBJECT3 >=", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3LessThan(String value) {
            addCriterion("OBJECT3 <", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3LessThanOrEqualTo(String value) {
            addCriterion("OBJECT3 <=", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3Like(String value) {
            addCriterion("OBJECT3 like", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3NotLike(String value) {
            addCriterion("OBJECT3 not like", value, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3In(List<String> values) {
            addCriterion("OBJECT3 in", values, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3NotIn(List<String> values) {
            addCriterion("OBJECT3 not in", values, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3Between(String value1, String value2) {
            addCriterion("OBJECT3 between", value1, value2, "object3");
            return (Criteria) this;
        }

        public Criteria andObject3NotBetween(String value1, String value2) {
            addCriterion("OBJECT3 not between", value1, value2, "object3");
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

        public Criteria andOaaddressIsNull() {
            addCriterion("OAADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andOaaddressIsNotNull() {
            addCriterion("OAADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andOaaddressEqualTo(String value) {
            addCriterion("OAADDRESS =", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressNotEqualTo(String value) {
            addCriterion("OAADDRESS <>", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressGreaterThan(String value) {
            addCriterion("OAADDRESS >", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressGreaterThanOrEqualTo(String value) {
            addCriterion("OAADDRESS >=", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressLessThan(String value) {
            addCriterion("OAADDRESS <", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressLessThanOrEqualTo(String value) {
            addCriterion("OAADDRESS <=", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressLike(String value) {
            addCriterion("OAADDRESS like", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressNotLike(String value) {
            addCriterion("OAADDRESS not like", value, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressIn(List<String> values) {
            addCriterion("OAADDRESS in", values, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressNotIn(List<String> values) {
            addCriterion("OAADDRESS not in", values, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressBetween(String value1, String value2) {
            addCriterion("OAADDRESS between", value1, value2, "oaaddress");
            return (Criteria) this;
        }

        public Criteria andOaaddressNotBetween(String value1, String value2) {
            addCriterion("OAADDRESS not between", value1, value2, "oaaddress");
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