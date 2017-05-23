package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class KeyColumnUsageExample {
    /**
     * KEY_COLUMN_USAGE
     */
    protected String orderByClause;

    /**
     * KEY_COLUMN_USAGE
     */
    protected boolean distinct;

    /**
     * KEY_COLUMN_USAGE
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public KeyColumnUsageExample() {
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
     * KEY_COLUMN_USAGE null
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

        public Criteria andConstraintCatalogIsNull() {
            addCriterion("CONSTRAINT_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogIsNotNull() {
            addCriterion("CONSTRAINT_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG =", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG <>", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogGreaterThan(String value) {
            addCriterion("CONSTRAINT_CATALOG >", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG >=", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogLessThan(String value) {
            addCriterion("CONSTRAINT_CATALOG <", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogLessThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG <=", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogLike(String value) {
            addCriterion("CONSTRAINT_CATALOG like", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotLike(String value) {
            addCriterion("CONSTRAINT_CATALOG not like", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogIn(List<String> values) {
            addCriterion("CONSTRAINT_CATALOG in", values, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotIn(List<String> values) {
            addCriterion("CONSTRAINT_CATALOG not in", values, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_CATALOG between", value1, value2, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_CATALOG not between", value1, value2, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaIsNull() {
            addCriterion("CONSTRAINT_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaIsNotNull() {
            addCriterion("CONSTRAINT_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA =", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA <>", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaGreaterThan(String value) {
            addCriterion("CONSTRAINT_SCHEMA >", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA >=", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaLessThan(String value) {
            addCriterion("CONSTRAINT_SCHEMA <", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaLessThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA <=", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaLike(String value) {
            addCriterion("CONSTRAINT_SCHEMA like", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotLike(String value) {
            addCriterion("CONSTRAINT_SCHEMA not like", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaIn(List<String> values) {
            addCriterion("CONSTRAINT_SCHEMA in", values, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotIn(List<String> values) {
            addCriterion("CONSTRAINT_SCHEMA not in", values, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_SCHEMA between", value1, value2, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_SCHEMA not between", value1, value2, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintNameIsNull() {
            addCriterion("CONSTRAINT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andConstraintNameIsNotNull() {
            addCriterion("CONSTRAINT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintNameEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME =", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME <>", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameGreaterThan(String value) {
            addCriterion("CONSTRAINT_NAME >", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME >=", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameLessThan(String value) {
            addCriterion("CONSTRAINT_NAME <", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameLessThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME <=", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameLike(String value) {
            addCriterion("CONSTRAINT_NAME like", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotLike(String value) {
            addCriterion("CONSTRAINT_NAME not like", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameIn(List<String> values) {
            addCriterion("CONSTRAINT_NAME in", values, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotIn(List<String> values) {
            addCriterion("CONSTRAINT_NAME not in", values, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_NAME between", value1, value2, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_NAME not between", value1, value2, "constraintName");
            return (Criteria) this;
        }

        public Criteria andTableCatalogIsNull() {
            addCriterion("TABLE_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andTableCatalogIsNotNull() {
            addCriterion("TABLE_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andTableCatalogEqualTo(String value) {
            addCriterion("TABLE_CATALOG =", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotEqualTo(String value) {
            addCriterion("TABLE_CATALOG <>", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogGreaterThan(String value) {
            addCriterion("TABLE_CATALOG >", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_CATALOG >=", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogLessThan(String value) {
            addCriterion("TABLE_CATALOG <", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogLessThanOrEqualTo(String value) {
            addCriterion("TABLE_CATALOG <=", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogLike(String value) {
            addCriterion("TABLE_CATALOG like", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotLike(String value) {
            addCriterion("TABLE_CATALOG not like", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogIn(List<String> values) {
            addCriterion("TABLE_CATALOG in", values, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotIn(List<String> values) {
            addCriterion("TABLE_CATALOG not in", values, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogBetween(String value1, String value2) {
            addCriterion("TABLE_CATALOG between", value1, value2, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotBetween(String value1, String value2) {
            addCriterion("TABLE_CATALOG not between", value1, value2, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableSchemaIsNull() {
            addCriterion("TABLE_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andTableSchemaIsNotNull() {
            addCriterion("TABLE_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andTableSchemaEqualTo(String value) {
            addCriterion("TABLE_SCHEMA =", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotEqualTo(String value) {
            addCriterion("TABLE_SCHEMA <>", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaGreaterThan(String value) {
            addCriterion("TABLE_SCHEMA >", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_SCHEMA >=", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaLessThan(String value) {
            addCriterion("TABLE_SCHEMA <", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaLessThanOrEqualTo(String value) {
            addCriterion("TABLE_SCHEMA <=", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaLike(String value) {
            addCriterion("TABLE_SCHEMA like", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotLike(String value) {
            addCriterion("TABLE_SCHEMA not like", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaIn(List<String> values) {
            addCriterion("TABLE_SCHEMA in", values, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotIn(List<String> values) {
            addCriterion("TABLE_SCHEMA not in", values, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaBetween(String value1, String value2) {
            addCriterion("TABLE_SCHEMA between", value1, value2, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotBetween(String value1, String value2) {
            addCriterion("TABLE_SCHEMA not between", value1, value2, "tableSchema");
            return (Criteria) this;
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

        public Criteria andOrdinalPositionIsNull() {
            addCriterion("ORDINAL_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionIsNotNull() {
            addCriterion("ORDINAL_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionEqualTo(Long value) {
            addCriterion("ORDINAL_POSITION =", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionNotEqualTo(Long value) {
            addCriterion("ORDINAL_POSITION <>", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionGreaterThan(Long value) {
            addCriterion("ORDINAL_POSITION >", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDINAL_POSITION >=", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionLessThan(Long value) {
            addCriterion("ORDINAL_POSITION <", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionLessThanOrEqualTo(Long value) {
            addCriterion("ORDINAL_POSITION <=", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionIn(List<Long> values) {
            addCriterion("ORDINAL_POSITION in", values, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionNotIn(List<Long> values) {
            addCriterion("ORDINAL_POSITION not in", values, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionBetween(Long value1, Long value2) {
            addCriterion("ORDINAL_POSITION between", value1, value2, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionNotBetween(Long value1, Long value2) {
            addCriterion("ORDINAL_POSITION not between", value1, value2, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintIsNull() {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT is null");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintIsNotNull() {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT is not null");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintEqualTo(Long value) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT =", value, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintNotEqualTo(Long value) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT <>", value, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintGreaterThan(Long value) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT >", value, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintGreaterThanOrEqualTo(Long value) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT >=", value, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintLessThan(Long value) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT <", value, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintLessThanOrEqualTo(Long value) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT <=", value, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintIn(List<Long> values) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT in", values, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintNotIn(List<Long> values) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT not in", values, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintBetween(Long value1, Long value2) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT between", value1, value2, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andPositionInUniqueConstraintNotBetween(Long value1, Long value2) {
            addCriterion("POSITION_IN_UNIQUE_CONSTRAINT not between", value1, value2, "positionInUniqueConstraint");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaIsNull() {
            addCriterion("REFERENCED_TABLE_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaIsNotNull() {
            addCriterion("REFERENCED_TABLE_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA =", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaNotEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA <>", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaGreaterThan(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA >", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA >=", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaLessThan(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA <", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaLessThanOrEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA <=", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaLike(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA like", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaNotLike(String value) {
            addCriterion("REFERENCED_TABLE_SCHEMA not like", value, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaIn(List<String> values) {
            addCriterion("REFERENCED_TABLE_SCHEMA in", values, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaNotIn(List<String> values) {
            addCriterion("REFERENCED_TABLE_SCHEMA not in", values, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaBetween(String value1, String value2) {
            addCriterion("REFERENCED_TABLE_SCHEMA between", value1, value2, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableSchemaNotBetween(String value1, String value2) {
            addCriterion("REFERENCED_TABLE_SCHEMA not between", value1, value2, "referencedTableSchema");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameIsNull() {
            addCriterion("REFERENCED_TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameIsNotNull() {
            addCriterion("REFERENCED_TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME =", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME <>", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameGreaterThan(String value) {
            addCriterion("REFERENCED_TABLE_NAME >", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME >=", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameLessThan(String value) {
            addCriterion("REFERENCED_TABLE_NAME <", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameLessThanOrEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME <=", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameLike(String value) {
            addCriterion("REFERENCED_TABLE_NAME like", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotLike(String value) {
            addCriterion("REFERENCED_TABLE_NAME not like", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameIn(List<String> values) {
            addCriterion("REFERENCED_TABLE_NAME in", values, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotIn(List<String> values) {
            addCriterion("REFERENCED_TABLE_NAME not in", values, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameBetween(String value1, String value2) {
            addCriterion("REFERENCED_TABLE_NAME between", value1, value2, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotBetween(String value1, String value2) {
            addCriterion("REFERENCED_TABLE_NAME not between", value1, value2, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameIsNull() {
            addCriterion("REFERENCED_COLUMN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameIsNotNull() {
            addCriterion("REFERENCED_COLUMN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameEqualTo(String value) {
            addCriterion("REFERENCED_COLUMN_NAME =", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameNotEqualTo(String value) {
            addCriterion("REFERENCED_COLUMN_NAME <>", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameGreaterThan(String value) {
            addCriterion("REFERENCED_COLUMN_NAME >", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("REFERENCED_COLUMN_NAME >=", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameLessThan(String value) {
            addCriterion("REFERENCED_COLUMN_NAME <", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameLessThanOrEqualTo(String value) {
            addCriterion("REFERENCED_COLUMN_NAME <=", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameLike(String value) {
            addCriterion("REFERENCED_COLUMN_NAME like", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameNotLike(String value) {
            addCriterion("REFERENCED_COLUMN_NAME not like", value, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameIn(List<String> values) {
            addCriterion("REFERENCED_COLUMN_NAME in", values, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameNotIn(List<String> values) {
            addCriterion("REFERENCED_COLUMN_NAME not in", values, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameBetween(String value1, String value2) {
            addCriterion("REFERENCED_COLUMN_NAME between", value1, value2, "referencedColumnName");
            return (Criteria) this;
        }

        public Criteria andReferencedColumnNameNotBetween(String value1, String value2) {
            addCriterion("REFERENCED_COLUMN_NAME not between", value1, value2, "referencedColumnName");
            return (Criteria) this;
        }
    }

    /**
     * KEY_COLUMN_USAGE
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * KEY_COLUMN_USAGE null
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