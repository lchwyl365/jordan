package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysTablesExample {
    /**
     * HDMS.SYS_TABLES
     */
    protected String orderByClause;

    /**
     * HDMS.SYS_TABLES
     */
    protected boolean distinct;

    /**
     * HDMS.SYS_TABLES
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public SysTablesExample() {
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
     * HDMS.SYS_TABLES null
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

        public Criteria andTableNameIsNull() {
            addCriterion("TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("TABLE_NAME =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("TABLE_NAME <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("TABLE_NAME >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("TABLE_NAME <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("TABLE_NAME like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("TABLE_NAME not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("TABLE_NAME in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("TABLE_NAME not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("TABLE_NAME between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("TABLE_NAME not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameIsNull() {
            addCriterion("SCHEMA_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSchemaNameIsNotNull() {
            addCriterion("SCHEMA_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSchemaNameEqualTo(String value) {
            addCriterion("SCHEMA_NAME =", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotEqualTo(String value) {
            addCriterion("SCHEMA_NAME <>", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameGreaterThan(String value) {
            addCriterion("SCHEMA_NAME >", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEMA_NAME >=", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameLessThan(String value) {
            addCriterion("SCHEMA_NAME <", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameLessThanOrEqualTo(String value) {
            addCriterion("SCHEMA_NAME <=", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameLike(String value) {
            addCriterion("SCHEMA_NAME like", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotLike(String value) {
            addCriterion("SCHEMA_NAME not like", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameIn(List<String> values) {
            addCriterion("SCHEMA_NAME in", values, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotIn(List<String> values) {
            addCriterion("SCHEMA_NAME not in", values, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameBetween(String value1, String value2) {
            addCriterion("SCHEMA_NAME between", value1, value2, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotBetween(String value1, String value2) {
            addCriterion("SCHEMA_NAME not between", value1, value2, "schemaName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Short value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Short value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Short value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Short value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Short value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Short value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Short> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Short> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Short value1, Short value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Short value1, Short value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsIsNull() {
            addCriterion("KEYCOLUMNS is null");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsIsNotNull() {
            addCriterion("KEYCOLUMNS is not null");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsEqualTo(Short value) {
            addCriterion("KEYCOLUMNS =", value, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsNotEqualTo(Short value) {
            addCriterion("KEYCOLUMNS <>", value, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsGreaterThan(Short value) {
            addCriterion("KEYCOLUMNS >", value, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsGreaterThanOrEqualTo(Short value) {
            addCriterion("KEYCOLUMNS >=", value, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsLessThan(Short value) {
            addCriterion("KEYCOLUMNS <", value, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsLessThanOrEqualTo(Short value) {
            addCriterion("KEYCOLUMNS <=", value, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsIn(List<Short> values) {
            addCriterion("KEYCOLUMNS in", values, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsNotIn(List<Short> values) {
            addCriterion("KEYCOLUMNS not in", values, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsBetween(Short value1, Short value2) {
            addCriterion("KEYCOLUMNS between", value1, value2, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andKeycolumnsNotBetween(Short value1, Short value2) {
            addCriterion("KEYCOLUMNS not between", value1, value2, "keycolumns");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("CTIME is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("CTIME is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("CTIME =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("CTIME <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("CTIME >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CTIME >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("CTIME <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("CTIME <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("CTIME in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("CTIME not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("CTIME between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("CTIME not between", value1, value2, "ctime");
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

        public Criteria andGenerateIsNull() {
            addCriterion("GENERATE is null");
            return (Criteria) this;
        }

        public Criteria andGenerateIsNotNull() {
            addCriterion("GENERATE is not null");
            return (Criteria) this;
        }

        public Criteria andGenerateEqualTo(String value) {
            addCriterion("GENERATE =", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateNotEqualTo(String value) {
            addCriterion("GENERATE <>", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateGreaterThan(String value) {
            addCriterion("GENERATE >", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateGreaterThanOrEqualTo(String value) {
            addCriterion("GENERATE >=", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateLessThan(String value) {
            addCriterion("GENERATE <", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateLessThanOrEqualTo(String value) {
            addCriterion("GENERATE <=", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateLike(String value) {
            addCriterion("GENERATE like", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateNotLike(String value) {
            addCriterion("GENERATE not like", value, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateIn(List<String> values) {
            addCriterion("GENERATE in", values, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateNotIn(List<String> values) {
            addCriterion("GENERATE not in", values, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateBetween(String value1, String value2) {
            addCriterion("GENERATE between", value1, value2, "generate");
            return (Criteria) this;
        }

        public Criteria andGenerateNotBetween(String value1, String value2) {
            addCriterion("GENERATE not between", value1, value2, "generate");
            return (Criteria) this;
        }

        public Criteria andGentypeIsNull() {
            addCriterion("GENTYPE is null");
            return (Criteria) this;
        }

        public Criteria andGentypeIsNotNull() {
            addCriterion("GENTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andGentypeEqualTo(String value) {
            addCriterion("GENTYPE =", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeNotEqualTo(String value) {
            addCriterion("GENTYPE <>", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeGreaterThan(String value) {
            addCriterion("GENTYPE >", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeGreaterThanOrEqualTo(String value) {
            addCriterion("GENTYPE >=", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeLessThan(String value) {
            addCriterion("GENTYPE <", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeLessThanOrEqualTo(String value) {
            addCriterion("GENTYPE <=", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeLike(String value) {
            addCriterion("GENTYPE like", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeNotLike(String value) {
            addCriterion("GENTYPE not like", value, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeIn(List<String> values) {
            addCriterion("GENTYPE in", values, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeNotIn(List<String> values) {
            addCriterion("GENTYPE not in", values, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeBetween(String value1, String value2) {
            addCriterion("GENTYPE between", value1, value2, "gentype");
            return (Criteria) this;
        }

        public Criteria andGentypeNotBetween(String value1, String value2) {
            addCriterion("GENTYPE not between", value1, value2, "gentype");
            return (Criteria) this;
        }

        public Criteria andGtimeIsNull() {
            addCriterion("GTIME is null");
            return (Criteria) this;
        }

        public Criteria andGtimeIsNotNull() {
            addCriterion("GTIME is not null");
            return (Criteria) this;
        }

        public Criteria andGtimeEqualTo(Date value) {
            addCriterion("GTIME =", value, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeNotEqualTo(Date value) {
            addCriterion("GTIME <>", value, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeGreaterThan(Date value) {
            addCriterion("GTIME >", value, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("GTIME >=", value, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeLessThan(Date value) {
            addCriterion("GTIME <", value, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeLessThanOrEqualTo(Date value) {
            addCriterion("GTIME <=", value, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeIn(List<Date> values) {
            addCriterion("GTIME in", values, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeNotIn(List<Date> values) {
            addCriterion("GTIME not in", values, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeBetween(Date value1, Date value2) {
            addCriterion("GTIME between", value1, value2, "gtime");
            return (Criteria) this;
        }

        public Criteria andGtimeNotBetween(Date value1, Date value2) {
            addCriterion("GTIME not between", value1, value2, "gtime");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("PATH is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("PATH is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("PATH =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("PATH <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("PATH >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("PATH >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("PATH <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("PATH <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("PATH like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("PATH not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("PATH in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("PATH not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("PATH between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("PATH not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("MENU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("MENU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("MENU_NAME =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("MENU_NAME <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("MENU_NAME >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_NAME >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("MENU_NAME <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("MENU_NAME <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("MENU_NAME like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("MENU_NAME not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("MENU_NAME in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("MENU_NAME not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("MENU_NAME between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("MENU_NAME not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNull() {
            addCriterion("BUSINESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNotNull() {
            addCriterion("BUSINESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameEqualTo(String value) {
            addCriterion("BUSINESS_NAME =", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotEqualTo(String value) {
            addCriterion("BUSINESS_NAME <>", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThan(String value) {
            addCriterion("BUSINESS_NAME >", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME >=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThan(String value) {
            addCriterion("BUSINESS_NAME <", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NAME <=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLike(String value) {
            addCriterion("BUSINESS_NAME like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotLike(String value) {
            addCriterion("BUSINESS_NAME not like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIn(List<String> values) {
            addCriterion("BUSINESS_NAME in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotIn(List<String> values) {
            addCriterion("BUSINESS_NAME not in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_NAME not between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameIsNull() {
            addCriterion("DOMAIN_OBJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameIsNotNull() {
            addCriterion("DOMAIN_OBJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameEqualTo(String value) {
            addCriterion("DOMAIN_OBJECT_NAME =", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameNotEqualTo(String value) {
            addCriterion("DOMAIN_OBJECT_NAME <>", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameGreaterThan(String value) {
            addCriterion("DOMAIN_OBJECT_NAME >", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("DOMAIN_OBJECT_NAME >=", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameLessThan(String value) {
            addCriterion("DOMAIN_OBJECT_NAME <", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameLessThanOrEqualTo(String value) {
            addCriterion("DOMAIN_OBJECT_NAME <=", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameLike(String value) {
            addCriterion("DOMAIN_OBJECT_NAME like", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameNotLike(String value) {
            addCriterion("DOMAIN_OBJECT_NAME not like", value, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameIn(List<String> values) {
            addCriterion("DOMAIN_OBJECT_NAME in", values, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameNotIn(List<String> values) {
            addCriterion("DOMAIN_OBJECT_NAME not in", values, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameBetween(String value1, String value2) {
            addCriterion("DOMAIN_OBJECT_NAME between", value1, value2, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andDomainObjectNameNotBetween(String value1, String value2) {
            addCriterion("DOMAIN_OBJECT_NAME not between", value1, value2, "domainObjectName");
            return (Criteria) this;
        }

        public Criteria andVariableNameIsNull() {
            addCriterion("VARIABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andVariableNameIsNotNull() {
            addCriterion("VARIABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andVariableNameEqualTo(String value) {
            addCriterion("VARIABLE_NAME =", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotEqualTo(String value) {
            addCriterion("VARIABLE_NAME <>", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameGreaterThan(String value) {
            addCriterion("VARIABLE_NAME >", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameGreaterThanOrEqualTo(String value) {
            addCriterion("VARIABLE_NAME >=", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameLessThan(String value) {
            addCriterion("VARIABLE_NAME <", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameLessThanOrEqualTo(String value) {
            addCriterion("VARIABLE_NAME <=", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameLike(String value) {
            addCriterion("VARIABLE_NAME like", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotLike(String value) {
            addCriterion("VARIABLE_NAME not like", value, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameIn(List<String> values) {
            addCriterion("VARIABLE_NAME in", values, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotIn(List<String> values) {
            addCriterion("VARIABLE_NAME not in", values, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameBetween(String value1, String value2) {
            addCriterion("VARIABLE_NAME between", value1, value2, "variableName");
            return (Criteria) this;
        }

        public Criteria andVariableNameNotBetween(String value1, String value2) {
            addCriterion("VARIABLE_NAME not between", value1, value2, "variableName");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageIsNull() {
            addCriterion("POJO_TARGET_PACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageIsNotNull() {
            addCriterion("POJO_TARGET_PACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageEqualTo(String value) {
            addCriterion("POJO_TARGET_PACKAGE =", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageNotEqualTo(String value) {
            addCriterion("POJO_TARGET_PACKAGE <>", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageGreaterThan(String value) {
            addCriterion("POJO_TARGET_PACKAGE >", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageGreaterThanOrEqualTo(String value) {
            addCriterion("POJO_TARGET_PACKAGE >=", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageLessThan(String value) {
            addCriterion("POJO_TARGET_PACKAGE <", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageLessThanOrEqualTo(String value) {
            addCriterion("POJO_TARGET_PACKAGE <=", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageLike(String value) {
            addCriterion("POJO_TARGET_PACKAGE like", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageNotLike(String value) {
            addCriterion("POJO_TARGET_PACKAGE not like", value, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageIn(List<String> values) {
            addCriterion("POJO_TARGET_PACKAGE in", values, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageNotIn(List<String> values) {
            addCriterion("POJO_TARGET_PACKAGE not in", values, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageBetween(String value1, String value2) {
            addCriterion("POJO_TARGET_PACKAGE between", value1, value2, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andPojoTargetPackageNotBetween(String value1, String value2) {
            addCriterion("POJO_TARGET_PACKAGE not between", value1, value2, "pojoTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageIsNull() {
            addCriterion("MAPPER_TARGET_PACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageIsNotNull() {
            addCriterion("MAPPER_TARGET_PACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageEqualTo(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE =", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageNotEqualTo(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE <>", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageGreaterThan(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE >", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageGreaterThanOrEqualTo(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE >=", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageLessThan(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE <", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageLessThanOrEqualTo(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE <=", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageLike(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE like", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageNotLike(String value) {
            addCriterion("MAPPER_TARGET_PACKAGE not like", value, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageIn(List<String> values) {
            addCriterion("MAPPER_TARGET_PACKAGE in", values, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageNotIn(List<String> values) {
            addCriterion("MAPPER_TARGET_PACKAGE not in", values, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageBetween(String value1, String value2) {
            addCriterion("MAPPER_TARGET_PACKAGE between", value1, value2, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andMapperTargetPackageNotBetween(String value1, String value2) {
            addCriterion("MAPPER_TARGET_PACKAGE not between", value1, value2, "mapperTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageIsNull() {
            addCriterion("SERVICE_TARGET_PACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageIsNotNull() {
            addCriterion("SERVICE_TARGET_PACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageEqualTo(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE =", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageNotEqualTo(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE <>", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageGreaterThan(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE >", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE >=", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageLessThan(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE <", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE <=", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageLike(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE like", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageNotLike(String value) {
            addCriterion("SERVICE_TARGET_PACKAGE not like", value, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageIn(List<String> values) {
            addCriterion("SERVICE_TARGET_PACKAGE in", values, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageNotIn(List<String> values) {
            addCriterion("SERVICE_TARGET_PACKAGE not in", values, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageBetween(String value1, String value2) {
            addCriterion("SERVICE_TARGET_PACKAGE between", value1, value2, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andServiceTargetPackageNotBetween(String value1, String value2) {
            addCriterion("SERVICE_TARGET_PACKAGE not between", value1, value2, "serviceTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageIsNull() {
            addCriterion("CONTROLLER_TARGET_PACKAGE is null");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageIsNotNull() {
            addCriterion("CONTROLLER_TARGET_PACKAGE is not null");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageEqualTo(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE =", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageNotEqualTo(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE <>", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageGreaterThan(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE >", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageGreaterThanOrEqualTo(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE >=", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageLessThan(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE <", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageLessThanOrEqualTo(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE <=", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageLike(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE like", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageNotLike(String value) {
            addCriterion("CONTROLLER_TARGET_PACKAGE not like", value, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageIn(List<String> values) {
            addCriterion("CONTROLLER_TARGET_PACKAGE in", values, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageNotIn(List<String> values) {
            addCriterion("CONTROLLER_TARGET_PACKAGE not in", values, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageBetween(String value1, String value2) {
            addCriterion("CONTROLLER_TARGET_PACKAGE between", value1, value2, "controllerTargetPackage");
            return (Criteria) this;
        }

        public Criteria andControllerTargetPackageNotBetween(String value1, String value2) {
            addCriterion("CONTROLLER_TARGET_PACKAGE not between", value1, value2, "controllerTargetPackage");
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

        public Criteria andIsdeleteIsNull() {
            addCriterion("ISDELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("ISDELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(String value) {
            addCriterion("ISDELETE =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(String value) {
            addCriterion("ISDELETE <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(String value) {
            addCriterion("ISDELETE >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("ISDELETE >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(String value) {
            addCriterion("ISDELETE <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(String value) {
            addCriterion("ISDELETE <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLike(String value) {
            addCriterion("ISDELETE like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotLike(String value) {
            addCriterion("ISDELETE not like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<String> values) {
            addCriterion("ISDELETE in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<String> values) {
            addCriterion("ISDELETE not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(String value1, String value2) {
            addCriterion("ISDELETE between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(String value1, String value2) {
            addCriterion("ISDELETE not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIdFieldIsNull() {
            addCriterion("ID_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andIdFieldIsNotNull() {
            addCriterion("ID_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andIdFieldEqualTo(String value) {
            addCriterion("ID_FIELD =", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldNotEqualTo(String value) {
            addCriterion("ID_FIELD <>", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldGreaterThan(String value) {
            addCriterion("ID_FIELD >", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldGreaterThanOrEqualTo(String value) {
            addCriterion("ID_FIELD >=", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldLessThan(String value) {
            addCriterion("ID_FIELD <", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldLessThanOrEqualTo(String value) {
            addCriterion("ID_FIELD <=", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldLike(String value) {
            addCriterion("ID_FIELD like", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldNotLike(String value) {
            addCriterion("ID_FIELD not like", value, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldIn(List<String> values) {
            addCriterion("ID_FIELD in", values, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldNotIn(List<String> values) {
            addCriterion("ID_FIELD not in", values, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldBetween(String value1, String value2) {
            addCriterion("ID_FIELD between", value1, value2, "idField");
            return (Criteria) this;
        }

        public Criteria andIdFieldNotBetween(String value1, String value2) {
            addCriterion("ID_FIELD not between", value1, value2, "idField");
            return (Criteria) this;
        }

        public Criteria andParentFieldIsNull() {
            addCriterion("PARENT_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andParentFieldIsNotNull() {
            addCriterion("PARENT_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andParentFieldEqualTo(String value) {
            addCriterion("PARENT_FIELD =", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldNotEqualTo(String value) {
            addCriterion("PARENT_FIELD <>", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldGreaterThan(String value) {
            addCriterion("PARENT_FIELD >", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_FIELD >=", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldLessThan(String value) {
            addCriterion("PARENT_FIELD <", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldLessThanOrEqualTo(String value) {
            addCriterion("PARENT_FIELD <=", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldLike(String value) {
            addCriterion("PARENT_FIELD like", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldNotLike(String value) {
            addCriterion("PARENT_FIELD not like", value, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldIn(List<String> values) {
            addCriterion("PARENT_FIELD in", values, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldNotIn(List<String> values) {
            addCriterion("PARENT_FIELD not in", values, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldBetween(String value1, String value2) {
            addCriterion("PARENT_FIELD between", value1, value2, "parentField");
            return (Criteria) this;
        }

        public Criteria andParentFieldNotBetween(String value1, String value2) {
            addCriterion("PARENT_FIELD not between", value1, value2, "parentField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldIsNull() {
            addCriterion("TREE_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andTreeFieldIsNotNull() {
            addCriterion("TREE_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andTreeFieldEqualTo(String value) {
            addCriterion("TREE_FIELD =", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldNotEqualTo(String value) {
            addCriterion("TREE_FIELD <>", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldGreaterThan(String value) {
            addCriterion("TREE_FIELD >", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldGreaterThanOrEqualTo(String value) {
            addCriterion("TREE_FIELD >=", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldLessThan(String value) {
            addCriterion("TREE_FIELD <", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldLessThanOrEqualTo(String value) {
            addCriterion("TREE_FIELD <=", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldLike(String value) {
            addCriterion("TREE_FIELD like", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldNotLike(String value) {
            addCriterion("TREE_FIELD not like", value, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldIn(List<String> values) {
            addCriterion("TREE_FIELD in", values, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldNotIn(List<String> values) {
            addCriterion("TREE_FIELD not in", values, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldBetween(String value1, String value2) {
            addCriterion("TREE_FIELD between", value1, value2, "treeField");
            return (Criteria) this;
        }

        public Criteria andTreeFieldNotBetween(String value1, String value2) {
            addCriterion("TREE_FIELD not between", value1, value2, "treeField");
            return (Criteria) this;
        }
    }

    /**
     * HDMS.SYS_TABLES
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * HDMS.SYS_TABLES null
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