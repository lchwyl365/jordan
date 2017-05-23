package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysDictTypeExample {
    /**
     * HDMS.SYS_DICT_TYPE
     */
    protected String orderByClause;

    /**
     * HDMS.SYS_DICT_TYPE
     */
    protected boolean distinct;

    /**
     * HDMS.SYS_DICT_TYPE
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public SysDictTypeExample() {
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
     * HDMS.SYS_DICT_TYPE null
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

        public Criteria andDicttypenameIsNull() {
            addCriterion("DICTTYPENAME is null");
            return (Criteria) this;
        }

        public Criteria andDicttypenameIsNotNull() {
            addCriterion("DICTTYPENAME is not null");
            return (Criteria) this;
        }

        public Criteria andDicttypenameEqualTo(String value) {
            addCriterion("DICTTYPENAME =", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotEqualTo(String value) {
            addCriterion("DICTTYPENAME <>", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameGreaterThan(String value) {
            addCriterion("DICTTYPENAME >", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameGreaterThanOrEqualTo(String value) {
            addCriterion("DICTTYPENAME >=", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameLessThan(String value) {
            addCriterion("DICTTYPENAME <", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameLessThanOrEqualTo(String value) {
            addCriterion("DICTTYPENAME <=", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameLike(String value) {
            addCriterion("DICTTYPENAME like", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotLike(String value) {
            addCriterion("DICTTYPENAME not like", value, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameIn(List<String> values) {
            addCriterion("DICTTYPENAME in", values, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotIn(List<String> values) {
            addCriterion("DICTTYPENAME not in", values, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameBetween(String value1, String value2) {
            addCriterion("DICTTYPENAME between", value1, value2, "dicttypename");
            return (Criteria) this;
        }

        public Criteria andDicttypenameNotBetween(String value1, String value2) {
            addCriterion("DICTTYPENAME not between", value1, value2, "dicttypename");
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
     * HDMS.SYS_DICT_TYPE
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * HDMS.SYS_DICT_TYPE null
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