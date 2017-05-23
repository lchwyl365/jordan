package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysDictEntryExample {
    /**
     * HDMS.SYS_DICT_ENTRY
     */
    protected String orderByClause;

    /**
     * HDMS.SYS_DICT_ENTRY
     */
    protected boolean distinct;

    /**
     * HDMS.SYS_DICT_ENTRY
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public SysDictEntryExample() {
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
     * HDMS.SYS_DICT_ENTRY null
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

        public Criteria andDicttypeidIsNull() {
            addCriterion("DICTTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andDicttypeidIsNotNull() {
            addCriterion("DICTTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andDicttypeidEqualTo(String value) {
            addCriterion("DICTTYPEID =", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotEqualTo(String value) {
            addCriterion("DICTTYPEID <>", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidGreaterThan(String value) {
            addCriterion("DICTTYPEID >", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidGreaterThanOrEqualTo(String value) {
            addCriterion("DICTTYPEID >=", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidLessThan(String value) {
            addCriterion("DICTTYPEID <", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidLessThanOrEqualTo(String value) {
            addCriterion("DICTTYPEID <=", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidLike(String value) {
            addCriterion("DICTTYPEID like", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotLike(String value) {
            addCriterion("DICTTYPEID not like", value, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidIn(List<String> values) {
            addCriterion("DICTTYPEID in", values, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotIn(List<String> values) {
            addCriterion("DICTTYPEID not in", values, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidBetween(String value1, String value2) {
            addCriterion("DICTTYPEID between", value1, value2, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDicttypeidNotBetween(String value1, String value2) {
            addCriterion("DICTTYPEID not between", value1, value2, "dicttypeid");
            return (Criteria) this;
        }

        public Criteria andDictidIsNull() {
            addCriterion("DICTID is null");
            return (Criteria) this;
        }

        public Criteria andDictidIsNotNull() {
            addCriterion("DICTID is not null");
            return (Criteria) this;
        }

        public Criteria andDictidEqualTo(String value) {
            addCriterion("DICTID =", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotEqualTo(String value) {
            addCriterion("DICTID <>", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThan(String value) {
            addCriterion("DICTID >", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThanOrEqualTo(String value) {
            addCriterion("DICTID >=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThan(String value) {
            addCriterion("DICTID <", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThanOrEqualTo(String value) {
            addCriterion("DICTID <=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLike(String value) {
            addCriterion("DICTID like", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotLike(String value) {
            addCriterion("DICTID not like", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidIn(List<String> values) {
            addCriterion("DICTID in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotIn(List<String> values) {
            addCriterion("DICTID not in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidBetween(String value1, String value2) {
            addCriterion("DICTID between", value1, value2, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotBetween(String value1, String value2) {
            addCriterion("DICTID not between", value1, value2, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictnameIsNull() {
            addCriterion("DICTNAME is null");
            return (Criteria) this;
        }

        public Criteria andDictnameIsNotNull() {
            addCriterion("DICTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDictnameEqualTo(String value) {
            addCriterion("DICTNAME =", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotEqualTo(String value) {
            addCriterion("DICTNAME <>", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameGreaterThan(String value) {
            addCriterion("DICTNAME >", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameGreaterThanOrEqualTo(String value) {
            addCriterion("DICTNAME >=", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLessThan(String value) {
            addCriterion("DICTNAME <", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLessThanOrEqualTo(String value) {
            addCriterion("DICTNAME <=", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLike(String value) {
            addCriterion("DICTNAME like", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotLike(String value) {
            addCriterion("DICTNAME not like", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameIn(List<String> values) {
            addCriterion("DICTNAME in", values, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotIn(List<String> values) {
            addCriterion("DICTNAME not in", values, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameBetween(String value1, String value2) {
            addCriterion("DICTNAME between", value1, value2, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotBetween(String value1, String value2) {
            addCriterion("DICTNAME not between", value1, value2, "dictname");
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

        public Criteria andSortnoIsNull() {
            addCriterion("SORTNO is null");
            return (Criteria) this;
        }

        public Criteria andSortnoIsNotNull() {
            addCriterion("SORTNO is not null");
            return (Criteria) this;
        }

        public Criteria andSortnoEqualTo(Integer value) {
            addCriterion("SORTNO =", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotEqualTo(Integer value) {
            addCriterion("SORTNO <>", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThan(Integer value) {
            addCriterion("SORTNO >", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORTNO >=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThan(Integer value) {
            addCriterion("SORTNO <", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoLessThanOrEqualTo(Integer value) {
            addCriterion("SORTNO <=", value, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoIn(List<Integer> values) {
            addCriterion("SORTNO in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotIn(List<Integer> values) {
            addCriterion("SORTNO not in", values, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoBetween(Integer value1, Integer value2) {
            addCriterion("SORTNO between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andSortnoNotBetween(Integer value1, Integer value2) {
            addCriterion("SORTNO not between", value1, value2, "sortno");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("RANK is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("RANK is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("RANK =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("RANK <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("RANK >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("RANK >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("RANK <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("RANK <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("RANK like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("RANK not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<String> values) {
            addCriterion("RANK in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<String> values) {
            addCriterion("RANK not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("RANK between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("RANK not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("PARENTID is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("PARENTID is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("PARENTID =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("PARENTID <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("PARENTID >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTID >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("PARENTID <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("PARENTID <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("PARENTID like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("PARENTID not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("PARENTID in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("PARENTID not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("PARENTID between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("PARENTID not between", value1, value2, "parentid");
            return (Criteria) this;
        }
    }

    /**
     * HDMS.SYS_DICT_ENTRY
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * HDMS.SYS_DICT_ENTRY null
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