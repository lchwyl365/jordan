package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class DB2KeyColuseExample {
    /**
     * SYSCAT.KEYCOLUSE
     */
    protected String orderByClause;

    /**
     * SYSCAT.KEYCOLUSE
     */
    protected boolean distinct;

    /**
     * SYSCAT.KEYCOLUSE
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public DB2KeyColuseExample() {
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
     * SYSCAT.KEYCOLUSE null
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

        public Criteria andConstnameIsNull() {
            addCriterion("CONSTNAME is null");
            return (Criteria) this;
        }

        public Criteria andConstnameIsNotNull() {
            addCriterion("CONSTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andConstnameEqualTo(String value) {
            addCriterion("CONSTNAME =", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameNotEqualTo(String value) {
            addCriterion("CONSTNAME <>", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameGreaterThan(String value) {
            addCriterion("CONSTNAME >", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTNAME >=", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameLessThan(String value) {
            addCriterion("CONSTNAME <", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameLessThanOrEqualTo(String value) {
            addCriterion("CONSTNAME <=", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameLike(String value) {
            addCriterion("CONSTNAME like", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameNotLike(String value) {
            addCriterion("CONSTNAME not like", value, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameIn(List<String> values) {
            addCriterion("CONSTNAME in", values, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameNotIn(List<String> values) {
            addCriterion("CONSTNAME not in", values, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameBetween(String value1, String value2) {
            addCriterion("CONSTNAME between", value1, value2, "constname");
            return (Criteria) this;
        }

        public Criteria andConstnameNotBetween(String value1, String value2) {
            addCriterion("CONSTNAME not between", value1, value2, "constname");
            return (Criteria) this;
        }

        public Criteria andTabschemaIsNull() {
            addCriterion("TABSCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andTabschemaIsNotNull() {
            addCriterion("TABSCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andTabschemaEqualTo(String value) {
            addCriterion("TABSCHEMA =", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaNotEqualTo(String value) {
            addCriterion("TABSCHEMA <>", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaGreaterThan(String value) {
            addCriterion("TABSCHEMA >", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaGreaterThanOrEqualTo(String value) {
            addCriterion("TABSCHEMA >=", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaLessThan(String value) {
            addCriterion("TABSCHEMA <", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaLessThanOrEqualTo(String value) {
            addCriterion("TABSCHEMA <=", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaLike(String value) {
            addCriterion("TABSCHEMA like", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaNotLike(String value) {
            addCriterion("TABSCHEMA not like", value, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaIn(List<String> values) {
            addCriterion("TABSCHEMA in", values, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaNotIn(List<String> values) {
            addCriterion("TABSCHEMA not in", values, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaBetween(String value1, String value2) {
            addCriterion("TABSCHEMA between", value1, value2, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabschemaNotBetween(String value1, String value2) {
            addCriterion("TABSCHEMA not between", value1, value2, "tabschema");
            return (Criteria) this;
        }

        public Criteria andTabnameIsNull() {
            addCriterion("TABNAME is null");
            return (Criteria) this;
        }

        public Criteria andTabnameIsNotNull() {
            addCriterion("TABNAME is not null");
            return (Criteria) this;
        }

        public Criteria andTabnameEqualTo(String value) {
            addCriterion("TABNAME =", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameNotEqualTo(String value) {
            addCriterion("TABNAME <>", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameGreaterThan(String value) {
            addCriterion("TABNAME >", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameGreaterThanOrEqualTo(String value) {
            addCriterion("TABNAME >=", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameLessThan(String value) {
            addCriterion("TABNAME <", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameLessThanOrEqualTo(String value) {
            addCriterion("TABNAME <=", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameLike(String value) {
            addCriterion("TABNAME like", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameNotLike(String value) {
            addCriterion("TABNAME not like", value, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameIn(List<String> values) {
            addCriterion("TABNAME in", values, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameNotIn(List<String> values) {
            addCriterion("TABNAME not in", values, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameBetween(String value1, String value2) {
            addCriterion("TABNAME between", value1, value2, "tabname");
            return (Criteria) this;
        }

        public Criteria andTabnameNotBetween(String value1, String value2) {
            addCriterion("TABNAME not between", value1, value2, "tabname");
            return (Criteria) this;
        }

        public Criteria andColnameIsNull() {
            addCriterion("COLNAME is null");
            return (Criteria) this;
        }

        public Criteria andColnameIsNotNull() {
            addCriterion("COLNAME is not null");
            return (Criteria) this;
        }

        public Criteria andColnameEqualTo(String value) {
            addCriterion("COLNAME =", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotEqualTo(String value) {
            addCriterion("COLNAME <>", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameGreaterThan(String value) {
            addCriterion("COLNAME >", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameGreaterThanOrEqualTo(String value) {
            addCriterion("COLNAME >=", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameLessThan(String value) {
            addCriterion("COLNAME <", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameLessThanOrEqualTo(String value) {
            addCriterion("COLNAME <=", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameLike(String value) {
            addCriterion("COLNAME like", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotLike(String value) {
            addCriterion("COLNAME not like", value, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameIn(List<String> values) {
            addCriterion("COLNAME in", values, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotIn(List<String> values) {
            addCriterion("COLNAME not in", values, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameBetween(String value1, String value2) {
            addCriterion("COLNAME between", value1, value2, "colname");
            return (Criteria) this;
        }

        public Criteria andColnameNotBetween(String value1, String value2) {
            addCriterion("COLNAME not between", value1, value2, "colname");
            return (Criteria) this;
        }

        public Criteria andColseqIsNull() {
            addCriterion("COLSEQ is null");
            return (Criteria) this;
        }

        public Criteria andColseqIsNotNull() {
            addCriterion("COLSEQ is not null");
            return (Criteria) this;
        }

        public Criteria andColseqEqualTo(Short value) {
            addCriterion("COLSEQ =", value, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqNotEqualTo(Short value) {
            addCriterion("COLSEQ <>", value, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqGreaterThan(Short value) {
            addCriterion("COLSEQ >", value, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqGreaterThanOrEqualTo(Short value) {
            addCriterion("COLSEQ >=", value, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqLessThan(Short value) {
            addCriterion("COLSEQ <", value, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqLessThanOrEqualTo(Short value) {
            addCriterion("COLSEQ <=", value, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqIn(List<Short> values) {
            addCriterion("COLSEQ in", values, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqNotIn(List<Short> values) {
            addCriterion("COLSEQ not in", values, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqBetween(Short value1, Short value2) {
            addCriterion("COLSEQ between", value1, value2, "colseq");
            return (Criteria) this;
        }

        public Criteria andColseqNotBetween(Short value1, Short value2) {
            addCriterion("COLSEQ not between", value1, value2, "colseq");
            return (Criteria) this;
        }
    }

    /**
     * SYSCAT.KEYCOLUSE
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * SYSCAT.KEYCOLUSE null
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