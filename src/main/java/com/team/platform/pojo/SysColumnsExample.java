package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysColumnsExample {
    /**
     * HDMS.SYS_COLUMNS
     */
    protected String orderByClause;

    /**
     * HDMS.SYS_COLUMNS
     */
    protected boolean distinct;

    /**
     * HDMS.SYS_COLUMNS
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public SysColumnsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * HDMS.SYS_COLUMNS null
     */
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

        public Criteria andColumnNameIsNull() {
            addCriterion("COLUMN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("COLUMN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(String value) {
            addCriterion("COLUMN_NAME =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(String value) {
            addCriterion("COLUMN_NAME <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(String value) {
            addCriterion("COLUMN_NAME >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_NAME >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(String value) {
            addCriterion("COLUMN_NAME <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_NAME <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLike(String value) {
            addCriterion("COLUMN_NAME like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotLike(String value) {
            addCriterion("COLUMN_NAME not like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<String> values) {
            addCriterion("COLUMN_NAME in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<String> values) {
            addCriterion("COLUMN_NAME not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(String value1, String value2) {
            addCriterion("COLUMN_NAME between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(String value1, String value2) {
            addCriterion("COLUMN_NAME not between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andTbnameIsNull() {
            addCriterion("TBNAME is null");
            return (Criteria) this;
        }

        public Criteria andTbnameIsNotNull() {
            addCriterion("TBNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTbnameEqualTo(String value) {
            addCriterion("TBNAME =", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotEqualTo(String value) {
            addCriterion("TBNAME <>", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameGreaterThan(String value) {
            addCriterion("TBNAME >", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameGreaterThanOrEqualTo(String value) {
            addCriterion("TBNAME >=", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameLessThan(String value) {
            addCriterion("TBNAME <", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameLessThanOrEqualTo(String value) {
            addCriterion("TBNAME <=", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameLike(String value) {
            addCriterion("TBNAME like", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotLike(String value) {
            addCriterion("TBNAME not like", value, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameIn(List<String> values) {
            addCriterion("TBNAME in", values, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotIn(List<String> values) {
            addCriterion("TBNAME not in", values, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameBetween(String value1, String value2) {
            addCriterion("TBNAME between", value1, value2, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbnameNotBetween(String value1, String value2) {
            addCriterion("TBNAME not between", value1, value2, "tbname");
            return (Criteria) this;
        }

        public Criteria andTbcreatorIsNull() {
            addCriterion("TBCREATOR is null");
            return (Criteria) this;
        }

        public Criteria andTbcreatorIsNotNull() {
            addCriterion("TBCREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andTbcreatorEqualTo(String value) {
            addCriterion("TBCREATOR =", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorNotEqualTo(String value) {
            addCriterion("TBCREATOR <>", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorGreaterThan(String value) {
            addCriterion("TBCREATOR >", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorGreaterThanOrEqualTo(String value) {
            addCriterion("TBCREATOR >=", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorLessThan(String value) {
            addCriterion("TBCREATOR <", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorLessThanOrEqualTo(String value) {
            addCriterion("TBCREATOR <=", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorLike(String value) {
            addCriterion("TBCREATOR like", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorNotLike(String value) {
            addCriterion("TBCREATOR not like", value, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorIn(List<String> values) {
            addCriterion("TBCREATOR in", values, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorNotIn(List<String> values) {
            addCriterion("TBCREATOR not in", values, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorBetween(String value1, String value2) {
            addCriterion("TBCREATOR between", value1, value2, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andTbcreatorNotBetween(String value1, String value2) {
            addCriterion("TBCREATOR not between", value1, value2, "tbcreator");
            return (Criteria) this;
        }

        public Criteria andColnoIsNull() {
            addCriterion("COLNO is null");
            return (Criteria) this;
        }

        public Criteria andColnoIsNotNull() {
            addCriterion("COLNO is not null");
            return (Criteria) this;
        }

        public Criteria andColnoEqualTo(Short value) {
            addCriterion("COLNO =", value, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoNotEqualTo(Short value) {
            addCriterion("COLNO <>", value, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoGreaterThan(Short value) {
            addCriterion("COLNO >", value, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoGreaterThanOrEqualTo(Short value) {
            addCriterion("COLNO >=", value, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoLessThan(Short value) {
            addCriterion("COLNO <", value, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoLessThanOrEqualTo(Short value) {
            addCriterion("COLNO <=", value, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoIn(List<Short> values) {
            addCriterion("COLNO in", values, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoNotIn(List<Short> values) {
            addCriterion("COLNO not in", values, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoBetween(Short value1, Short value2) {
            addCriterion("COLNO between", value1, value2, "colno");
            return (Criteria) this;
        }

        public Criteria andColnoNotBetween(Short value1, Short value2) {
            addCriterion("COLNO not between", value1, value2, "colno");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andColtypeIsNull() {
            addCriterion("COLTYPE is null");
            return (Criteria) this;
        }

        public Criteria andColtypeIsNotNull() {
            addCriterion("COLTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andColtypeEqualTo(String value) {
            addCriterion("COLTYPE =", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeNotEqualTo(String value) {
            addCriterion("COLTYPE <>", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeGreaterThan(String value) {
            addCriterion("COLTYPE >", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeGreaterThanOrEqualTo(String value) {
            addCriterion("COLTYPE >=", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeLessThan(String value) {
            addCriterion("COLTYPE <", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeLessThanOrEqualTo(String value) {
            addCriterion("COLTYPE <=", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeLike(String value) {
            addCriterion("COLTYPE like", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeNotLike(String value) {
            addCriterion("COLTYPE not like", value, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeIn(List<String> values) {
            addCriterion("COLTYPE in", values, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeNotIn(List<String> values) {
            addCriterion("COLTYPE not in", values, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeBetween(String value1, String value2) {
            addCriterion("COLTYPE between", value1, value2, "coltype");
            return (Criteria) this;
        }

        public Criteria andColtypeNotBetween(String value1, String value2) {
            addCriterion("COLTYPE not between", value1, value2, "coltype");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthIsNull() {
            addCriterion("PROPERTY_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthIsNotNull() {
            addCriterion("PROPERTY_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthEqualTo(Short value) {
            addCriterion("PROPERTY_LENGTH =", value, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthNotEqualTo(Short value) {
            addCriterion("PROPERTY_LENGTH <>", value, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthGreaterThan(Short value) {
            addCriterion("PROPERTY_LENGTH >", value, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthGreaterThanOrEqualTo(Short value) {
            addCriterion("PROPERTY_LENGTH >=", value, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthLessThan(Short value) {
            addCriterion("PROPERTY_LENGTH <", value, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthLessThanOrEqualTo(Short value) {
            addCriterion("PROPERTY_LENGTH <=", value, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthIn(List<Short> values) {
            addCriterion("PROPERTY_LENGTH in", values, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthNotIn(List<Short> values) {
            addCriterion("PROPERTY_LENGTH not in", values, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthBetween(Short value1, Short value2) {
            addCriterion("PROPERTY_LENGTH between", value1, value2, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andPropertyLengthNotBetween(Short value1, Short value2) {
            addCriterion("PROPERTY_LENGTH not between", value1, value2, "propertyLength");
            return (Criteria) this;
        }

        public Criteria andNullsIsNull() {
            addCriterion("NULLS is null");
            return (Criteria) this;
        }

        public Criteria andNullsIsNotNull() {
            addCriterion("NULLS is not null");
            return (Criteria) this;
        }

        public Criteria andNullsEqualTo(String value) {
            addCriterion("NULLS =", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsNotEqualTo(String value) {
            addCriterion("NULLS <>", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsGreaterThan(String value) {
            addCriterion("NULLS >", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsGreaterThanOrEqualTo(String value) {
            addCriterion("NULLS >=", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsLessThan(String value) {
            addCriterion("NULLS <", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsLessThanOrEqualTo(String value) {
            addCriterion("NULLS <=", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsLike(String value) {
            addCriterion("NULLS like", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsNotLike(String value) {
            addCriterion("NULLS not like", value, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsIn(List<String> values) {
            addCriterion("NULLS in", values, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsNotIn(List<String> values) {
            addCriterion("NULLS not in", values, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsBetween(String value1, String value2) {
            addCriterion("NULLS between", value1, value2, "nulls");
            return (Criteria) this;
        }

        public Criteria andNullsNotBetween(String value1, String value2) {
            addCriterion("NULLS not between", value1, value2, "nulls");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNull() {
            addCriterion("PROPERTY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNotNull() {
            addCriterion("PROPERTY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameEqualTo(String value) {
            addCriterion("PROPERTY_NAME =", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotEqualTo(String value) {
            addCriterion("PROPERTY_NAME <>", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThan(String value) {
            addCriterion("PROPERTY_NAME >", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY_NAME >=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThan(String value) {
            addCriterion("PROPERTY_NAME <", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanOrEqualTo(String value) {
            addCriterion("PROPERTY_NAME <=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLike(String value) {
            addCriterion("PROPERTY_NAME like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotLike(String value) {
            addCriterion("PROPERTY_NAME not like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIn(List<String> values) {
            addCriterion("PROPERTY_NAME in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotIn(List<String> values) {
            addCriterion("PROPERTY_NAME not in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameBetween(String value1, String value2) {
            addCriterion("PROPERTY_NAME between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotBetween(String value1, String value2) {
            addCriterion("PROPERTY_NAME not between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNull() {
            addCriterion("PROPERTY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNotNull() {
            addCriterion("PROPERTY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeEqualTo(String value) {
            addCriterion("PROPERTY_TYPE =", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotEqualTo(String value) {
            addCriterion("PROPERTY_TYPE <>", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThan(String value) {
            addCriterion("PROPERTY_TYPE >", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY_TYPE >=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThan(String value) {
            addCriterion("PROPERTY_TYPE <", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThanOrEqualTo(String value) {
            addCriterion("PROPERTY_TYPE <=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLike(String value) {
            addCriterion("PROPERTY_TYPE like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotLike(String value) {
            addCriterion("PROPERTY_TYPE not like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIn(List<String> values) {
            addCriterion("PROPERTY_TYPE in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotIn(List<String> values) {
            addCriterion("PROPERTY_TYPE not in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeBetween(String value1, String value2) {
            addCriterion("PROPERTY_TYPE between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotBetween(String value1, String value2) {
            addCriterion("PROPERTY_TYPE not between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleIsNull() {
            addCriterion("PROPERTY_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleIsNotNull() {
            addCriterion("PROPERTY_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleEqualTo(String value) {
            addCriterion("PROPERTY_TITLE =", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleNotEqualTo(String value) {
            addCriterion("PROPERTY_TITLE <>", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleGreaterThan(String value) {
            addCriterion("PROPERTY_TITLE >", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY_TITLE >=", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleLessThan(String value) {
            addCriterion("PROPERTY_TITLE <", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleLessThanOrEqualTo(String value) {
            addCriterion("PROPERTY_TITLE <=", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleLike(String value) {
            addCriterion("PROPERTY_TITLE like", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleNotLike(String value) {
            addCriterion("PROPERTY_TITLE not like", value, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleIn(List<String> values) {
            addCriterion("PROPERTY_TITLE in", values, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleNotIn(List<String> values) {
            addCriterion("PROPERTY_TITLE not in", values, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleBetween(String value1, String value2) {
            addCriterion("PROPERTY_TITLE between", value1, value2, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andPropertyTitleNotBetween(String value1, String value2) {
            addCriterion("PROPERTY_TITLE not between", value1, value2, "propertyTitle");
            return (Criteria) this;
        }

        public Criteria andIsprimaryIsNull() {
            addCriterion("ISPRIMARY is null");
            return (Criteria) this;
        }

        public Criteria andIsprimaryIsNotNull() {
            addCriterion("ISPRIMARY is not null");
            return (Criteria) this;
        }

        public Criteria andIsprimaryEqualTo(String value) {
            addCriterion("ISPRIMARY =", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryNotEqualTo(String value) {
            addCriterion("ISPRIMARY <>", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryGreaterThan(String value) {
            addCriterion("ISPRIMARY >", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryGreaterThanOrEqualTo(String value) {
            addCriterion("ISPRIMARY >=", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryLessThan(String value) {
            addCriterion("ISPRIMARY <", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryLessThanOrEqualTo(String value) {
            addCriterion("ISPRIMARY <=", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryLike(String value) {
            addCriterion("ISPRIMARY like", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryNotLike(String value) {
            addCriterion("ISPRIMARY not like", value, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryIn(List<String> values) {
            addCriterion("ISPRIMARY in", values, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryNotIn(List<String> values) {
            addCriterion("ISPRIMARY not in", values, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryBetween(String value1, String value2) {
            addCriterion("ISPRIMARY between", value1, value2, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsprimaryNotBetween(String value1, String value2) {
            addCriterion("ISPRIMARY not between", value1, value2, "isprimary");
            return (Criteria) this;
        }

        public Criteria andIsselectIsNull() {
            addCriterion("ISSELECT is null");
            return (Criteria) this;
        }

        public Criteria andIsselectIsNotNull() {
            addCriterion("ISSELECT is not null");
            return (Criteria) this;
        }

        public Criteria andIsselectEqualTo(String value) {
            addCriterion("ISSELECT =", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotEqualTo(String value) {
            addCriterion("ISSELECT <>", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectGreaterThan(String value) {
            addCriterion("ISSELECT >", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectGreaterThanOrEqualTo(String value) {
            addCriterion("ISSELECT >=", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectLessThan(String value) {
            addCriterion("ISSELECT <", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectLessThanOrEqualTo(String value) {
            addCriterion("ISSELECT <=", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectLike(String value) {
            addCriterion("ISSELECT like", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotLike(String value) {
            addCriterion("ISSELECT not like", value, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectIn(List<String> values) {
            addCriterion("ISSELECT in", values, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotIn(List<String> values) {
            addCriterion("ISSELECT not in", values, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectBetween(String value1, String value2) {
            addCriterion("ISSELECT between", value1, value2, "isselect");
            return (Criteria) this;
        }

        public Criteria andIsselectNotBetween(String value1, String value2) {
            addCriterion("ISSELECT not between", value1, value2, "isselect");
            return (Criteria) this;
        }

        public Criteria andIslikeIsNull() {
            addCriterion("ISLIKE is null");
            return (Criteria) this;
        }

        public Criteria andIslikeIsNotNull() {
            addCriterion("ISLIKE is not null");
            return (Criteria) this;
        }

        public Criteria andIslikeEqualTo(String value) {
            addCriterion("ISLIKE =", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeNotEqualTo(String value) {
            addCriterion("ISLIKE <>", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeGreaterThan(String value) {
            addCriterion("ISLIKE >", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeGreaterThanOrEqualTo(String value) {
            addCriterion("ISLIKE >=", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeLessThan(String value) {
            addCriterion("ISLIKE <", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeLessThanOrEqualTo(String value) {
            addCriterion("ISLIKE <=", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeLike(String value) {
            addCriterion("ISLIKE like", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeNotLike(String value) {
            addCriterion("ISLIKE not like", value, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeIn(List<String> values) {
            addCriterion("ISLIKE in", values, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeNotIn(List<String> values) {
            addCriterion("ISLIKE not in", values, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeBetween(String value1, String value2) {
            addCriterion("ISLIKE between", value1, value2, "islike");
            return (Criteria) this;
        }

        public Criteria andIslikeNotBetween(String value1, String value2) {
            addCriterion("ISLIKE not between", value1, value2, "islike");
            return (Criteria) this;
        }

        public Criteria andIsdisplayIsNull() {
            addCriterion("ISDISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andIsdisplayIsNotNull() {
            addCriterion("ISDISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andIsdisplayEqualTo(String value) {
            addCriterion("ISDISPLAY =", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayNotEqualTo(String value) {
            addCriterion("ISDISPLAY <>", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayGreaterThan(String value) {
            addCriterion("ISDISPLAY >", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayGreaterThanOrEqualTo(String value) {
            addCriterion("ISDISPLAY >=", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayLessThan(String value) {
            addCriterion("ISDISPLAY <", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayLessThanOrEqualTo(String value) {
            addCriterion("ISDISPLAY <=", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayLike(String value) {
            addCriterion("ISDISPLAY like", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayNotLike(String value) {
            addCriterion("ISDISPLAY not like", value, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayIn(List<String> values) {
            addCriterion("ISDISPLAY in", values, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayNotIn(List<String> values) {
            addCriterion("ISDISPLAY not in", values, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayBetween(String value1, String value2) {
            addCriterion("ISDISPLAY between", value1, value2, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsdisplayNotBetween(String value1, String value2) {
            addCriterion("ISDISPLAY not between", value1, value2, "isdisplay");
            return (Criteria) this;
        }

        public Criteria andIsaddIsNull() {
            addCriterion("ISADD is null");
            return (Criteria) this;
        }

        public Criteria andIsaddIsNotNull() {
            addCriterion("ISADD is not null");
            return (Criteria) this;
        }

        public Criteria andIsaddEqualTo(String value) {
            addCriterion("ISADD =", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotEqualTo(String value) {
            addCriterion("ISADD <>", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddGreaterThan(String value) {
            addCriterion("ISADD >", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddGreaterThanOrEqualTo(String value) {
            addCriterion("ISADD >=", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLessThan(String value) {
            addCriterion("ISADD <", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLessThanOrEqualTo(String value) {
            addCriterion("ISADD <=", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddLike(String value) {
            addCriterion("ISADD like", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotLike(String value) {
            addCriterion("ISADD not like", value, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddIn(List<String> values) {
            addCriterion("ISADD in", values, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotIn(List<String> values) {
            addCriterion("ISADD not in", values, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddBetween(String value1, String value2) {
            addCriterion("ISADD between", value1, value2, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsaddNotBetween(String value1, String value2) {
            addCriterion("ISADD not between", value1, value2, "isadd");
            return (Criteria) this;
        }

        public Criteria andIsupdateIsNull() {
            addCriterion("ISUPDATE is null");
            return (Criteria) this;
        }

        public Criteria andIsupdateIsNotNull() {
            addCriterion("ISUPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andIsupdateEqualTo(String value) {
            addCriterion("ISUPDATE =", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateNotEqualTo(String value) {
            addCriterion("ISUPDATE <>", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateGreaterThan(String value) {
            addCriterion("ISUPDATE >", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateGreaterThanOrEqualTo(String value) {
            addCriterion("ISUPDATE >=", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateLessThan(String value) {
            addCriterion("ISUPDATE <", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateLessThanOrEqualTo(String value) {
            addCriterion("ISUPDATE <=", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateLike(String value) {
            addCriterion("ISUPDATE like", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateNotLike(String value) {
            addCriterion("ISUPDATE not like", value, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateIn(List<String> values) {
            addCriterion("ISUPDATE in", values, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateNotIn(List<String> values) {
            addCriterion("ISUPDATE not in", values, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateBetween(String value1, String value2) {
            addCriterion("ISUPDATE between", value1, value2, "isupdate");
            return (Criteria) this;
        }

        public Criteria andIsupdateNotBetween(String value1, String value2) {
            addCriterion("ISUPDATE not between", value1, value2, "isupdate");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("WIDTH is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("WIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Short value) {
            addCriterion("WIDTH =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Short value) {
            addCriterion("WIDTH <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Short value) {
            addCriterion("WIDTH >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Short value) {
            addCriterion("WIDTH >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Short value) {
            addCriterion("WIDTH <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Short value) {
            addCriterion("WIDTH <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Short> values) {
            addCriterion("WIDTH in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Short> values) {
            addCriterion("WIDTH not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Short value1, Short value2) {
            addCriterion("WIDTH between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Short value1, Short value2) {
            addCriterion("WIDTH not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andSortableIsNull() {
            addCriterion("SORTABLE is null");
            return (Criteria) this;
        }

        public Criteria andSortableIsNotNull() {
            addCriterion("SORTABLE is not null");
            return (Criteria) this;
        }

        public Criteria andSortableEqualTo(String value) {
            addCriterion("SORTABLE =", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotEqualTo(String value) {
            addCriterion("SORTABLE <>", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableGreaterThan(String value) {
            addCriterion("SORTABLE >", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableGreaterThanOrEqualTo(String value) {
            addCriterion("SORTABLE >=", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableLessThan(String value) {
            addCriterion("SORTABLE <", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableLessThanOrEqualTo(String value) {
            addCriterion("SORTABLE <=", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableLike(String value) {
            addCriterion("SORTABLE like", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotLike(String value) {
            addCriterion("SORTABLE not like", value, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableIn(List<String> values) {
            addCriterion("SORTABLE in", values, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotIn(List<String> values) {
            addCriterion("SORTABLE not in", values, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableBetween(String value1, String value2) {
            addCriterion("SORTABLE between", value1, value2, "sortable");
            return (Criteria) this;
        }

        public Criteria andSortableNotBetween(String value1, String value2) {
            addCriterion("SORTABLE not between", value1, value2, "sortable");
            return (Criteria) this;
        }

        public Criteria andComponentIsNull() {
            addCriterion("COMPONENT is null");
            return (Criteria) this;
        }

        public Criteria andComponentIsNotNull() {
            addCriterion("COMPONENT is not null");
            return (Criteria) this;
        }

        public Criteria andComponentEqualTo(String value) {
            addCriterion("COMPONENT =", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotEqualTo(String value) {
            addCriterion("COMPONENT <>", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThan(String value) {
            addCriterion("COMPONENT >", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThanOrEqualTo(String value) {
            addCriterion("COMPONENT >=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThan(String value) {
            addCriterion("COMPONENT <", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThanOrEqualTo(String value) {
            addCriterion("COMPONENT <=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLike(String value) {
            addCriterion("COMPONENT like", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotLike(String value) {
            addCriterion("COMPONENT not like", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentIn(List<String> values) {
            addCriterion("COMPONENT in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotIn(List<String> values) {
            addCriterion("COMPONENT not in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentBetween(String value1, String value2) {
            addCriterion("COMPONENT between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotBetween(String value1, String value2) {
            addCriterion("COMPONENT not between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andDataOptionsIsNull() {
            addCriterion("DATA_OPTIONS is null");
            return (Criteria) this;
        }

        public Criteria andDataOptionsIsNotNull() {
            addCriterion("DATA_OPTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andDataOptionsEqualTo(String value) {
            addCriterion("DATA_OPTIONS =", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsNotEqualTo(String value) {
            addCriterion("DATA_OPTIONS <>", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsGreaterThan(String value) {
            addCriterion("DATA_OPTIONS >", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_OPTIONS >=", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsLessThan(String value) {
            addCriterion("DATA_OPTIONS <", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsLessThanOrEqualTo(String value) {
            addCriterion("DATA_OPTIONS <=", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsLike(String value) {
            addCriterion("DATA_OPTIONS like", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsNotLike(String value) {
            addCriterion("DATA_OPTIONS not like", value, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsIn(List<String> values) {
            addCriterion("DATA_OPTIONS in", values, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsNotIn(List<String> values) {
            addCriterion("DATA_OPTIONS not in", values, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsBetween(String value1, String value2) {
            addCriterion("DATA_OPTIONS between", value1, value2, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andDataOptionsNotBetween(String value1, String value2) {
            addCriterion("DATA_OPTIONS not between", value1, value2, "dataOptions");
            return (Criteria) this;
        }

        public Criteria andFormatterIsNull() {
            addCriterion("FORMATTER is null");
            return (Criteria) this;
        }

        public Criteria andFormatterIsNotNull() {
            addCriterion("FORMATTER is not null");
            return (Criteria) this;
        }

        public Criteria andFormatterEqualTo(String value) {
            addCriterion("FORMATTER =", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotEqualTo(String value) {
            addCriterion("FORMATTER <>", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterGreaterThan(String value) {
            addCriterion("FORMATTER >", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterGreaterThanOrEqualTo(String value) {
            addCriterion("FORMATTER >=", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterLessThan(String value) {
            addCriterion("FORMATTER <", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterLessThanOrEqualTo(String value) {
            addCriterion("FORMATTER <=", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterLike(String value) {
            addCriterion("FORMATTER like", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotLike(String value) {
            addCriterion("FORMATTER not like", value, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterIn(List<String> values) {
            addCriterion("FORMATTER in", values, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotIn(List<String> values) {
            addCriterion("FORMATTER not in", values, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterBetween(String value1, String value2) {
            addCriterion("FORMATTER between", value1, value2, "formatter");
            return (Criteria) this;
        }

        public Criteria andFormatterNotBetween(String value1, String value2) {
            addCriterion("FORMATTER not between", value1, value2, "formatter");
            return (Criteria) this;
        }

        public Criteria andComboidIsNull() {
            addCriterion("COMBOID is null");
            return (Criteria) this;
        }

        public Criteria andComboidIsNotNull() {
            addCriterion("COMBOID is not null");
            return (Criteria) this;
        }

        public Criteria andComboidEqualTo(String value) {
            addCriterion("COMBOID =", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotEqualTo(String value) {
            addCriterion("COMBOID <>", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidGreaterThan(String value) {
            addCriterion("COMBOID >", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidGreaterThanOrEqualTo(String value) {
            addCriterion("COMBOID >=", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidLessThan(String value) {
            addCriterion("COMBOID <", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidLessThanOrEqualTo(String value) {
            addCriterion("COMBOID <=", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidLike(String value) {
            addCriterion("COMBOID like", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotLike(String value) {
            addCriterion("COMBOID not like", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidIn(List<String> values) {
            addCriterion("COMBOID in", values, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotIn(List<String> values) {
            addCriterion("COMBOID not in", values, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidBetween(String value1, String value2) {
            addCriterion("COMBOID between", value1, value2, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotBetween(String value1, String value2) {
            addCriterion("COMBOID not between", value1, value2, "comboid");
            return (Criteria) this;
        }
    }

    /**
     * HDMS.SYS_COLUMNS
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * HDMS.SYS_COLUMNS null
     */
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