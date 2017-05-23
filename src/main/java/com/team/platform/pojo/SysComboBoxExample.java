package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysComboBoxExample {
    /**
     * HDMS.SYS_COMBO_BOX
     */
    protected String orderByClause;

    /**
     * HDMS.SYS_COMBO_BOX
     */
    protected boolean distinct;

    /**
     * HDMS.SYS_COMBO_BOX
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public SysComboBoxExample() {
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
     * HDMS.SYS_COMBO_BOX null
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
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

        public Criteria andValueFieldIsNull() {
            addCriterion("VALUE_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andValueFieldIsNotNull() {
            addCriterion("VALUE_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andValueFieldEqualTo(String value) {
            addCriterion("VALUE_FIELD =", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotEqualTo(String value) {
            addCriterion("VALUE_FIELD <>", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldGreaterThan(String value) {
            addCriterion("VALUE_FIELD >", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE_FIELD >=", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldLessThan(String value) {
            addCriterion("VALUE_FIELD <", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldLessThanOrEqualTo(String value) {
            addCriterion("VALUE_FIELD <=", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldLike(String value) {
            addCriterion("VALUE_FIELD like", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotLike(String value) {
            addCriterion("VALUE_FIELD not like", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldIn(List<String> values) {
            addCriterion("VALUE_FIELD in", values, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotIn(List<String> values) {
            addCriterion("VALUE_FIELD not in", values, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldBetween(String value1, String value2) {
            addCriterion("VALUE_FIELD between", value1, value2, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotBetween(String value1, String value2) {
            addCriterion("VALUE_FIELD not between", value1, value2, "valueField");
            return (Criteria) this;
        }

        public Criteria andTextFieldIsNull() {
            addCriterion("TEXT_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andTextFieldIsNotNull() {
            addCriterion("TEXT_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andTextFieldEqualTo(String value) {
            addCriterion("TEXT_FIELD =", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldNotEqualTo(String value) {
            addCriterion("TEXT_FIELD <>", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldGreaterThan(String value) {
            addCriterion("TEXT_FIELD >", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldGreaterThanOrEqualTo(String value) {
            addCriterion("TEXT_FIELD >=", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldLessThan(String value) {
            addCriterion("TEXT_FIELD <", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldLessThanOrEqualTo(String value) {
            addCriterion("TEXT_FIELD <=", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldLike(String value) {
            addCriterion("TEXT_FIELD like", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldNotLike(String value) {
            addCriterion("TEXT_FIELD not like", value, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldIn(List<String> values) {
            addCriterion("TEXT_FIELD in", values, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldNotIn(List<String> values) {
            addCriterion("TEXT_FIELD not in", values, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldBetween(String value1, String value2) {
            addCriterion("TEXT_FIELD between", value1, value2, "textField");
            return (Criteria) this;
        }

        public Criteria andTextFieldNotBetween(String value1, String value2) {
            addCriterion("TEXT_FIELD not between", value1, value2, "textField");
            return (Criteria) this;
        }

        public Criteria andWhereConditionIsNull() {
            addCriterion("WHERE_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andWhereConditionIsNotNull() {
            addCriterion("WHERE_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andWhereConditionEqualTo(String value) {
            addCriterion("WHERE_CONDITION =", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionNotEqualTo(String value) {
            addCriterion("WHERE_CONDITION <>", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionGreaterThan(String value) {
            addCriterion("WHERE_CONDITION >", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionGreaterThanOrEqualTo(String value) {
            addCriterion("WHERE_CONDITION >=", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionLessThan(String value) {
            addCriterion("WHERE_CONDITION <", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionLessThanOrEqualTo(String value) {
            addCriterion("WHERE_CONDITION <=", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionLike(String value) {
            addCriterion("WHERE_CONDITION like", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionNotLike(String value) {
            addCriterion("WHERE_CONDITION not like", value, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionIn(List<String> values) {
            addCriterion("WHERE_CONDITION in", values, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionNotIn(List<String> values) {
            addCriterion("WHERE_CONDITION not in", values, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionBetween(String value1, String value2) {
            addCriterion("WHERE_CONDITION between", value1, value2, "whereCondition");
            return (Criteria) this;
        }

        public Criteria andWhereConditionNotBetween(String value1, String value2) {
            addCriterion("WHERE_CONDITION not between", value1, value2, "whereCondition");
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

        public Criteria andRootValueIsNull() {
            addCriterion("ROOT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andRootValueIsNotNull() {
            addCriterion("ROOT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andRootValueEqualTo(String value) {
            addCriterion("ROOT_VALUE =", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueNotEqualTo(String value) {
            addCriterion("ROOT_VALUE <>", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueGreaterThan(String value) {
            addCriterion("ROOT_VALUE >", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueGreaterThanOrEqualTo(String value) {
            addCriterion("ROOT_VALUE >=", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueLessThan(String value) {
            addCriterion("ROOT_VALUE <", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueLessThanOrEqualTo(String value) {
            addCriterion("ROOT_VALUE <=", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueLike(String value) {
            addCriterion("ROOT_VALUE like", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueNotLike(String value) {
            addCriterion("ROOT_VALUE not like", value, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueIn(List<String> values) {
            addCriterion("ROOT_VALUE in", values, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueNotIn(List<String> values) {
            addCriterion("ROOT_VALUE not in", values, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueBetween(String value1, String value2) {
            addCriterion("ROOT_VALUE between", value1, value2, "rootValue");
            return (Criteria) this;
        }

        public Criteria andRootValueNotBetween(String value1, String value2) {
            addCriterion("ROOT_VALUE not between", value1, value2, "rootValue");
            return (Criteria) this;
        }
    }

    /**
     * HDMS.SYS_COMBO_BOX
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * HDMS.SYS_COMBO_BOX null
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