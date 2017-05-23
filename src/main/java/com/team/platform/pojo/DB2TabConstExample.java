package com.team.platform.pojo;

import java.util.ArrayList;
import java.util.List;

public class DB2TabConstExample {
    /**
     * SYSCAT.TABCONST
     */
    protected String orderByClause;

    /**
     * SYSCAT.TABCONST
     */
    protected boolean distinct;

    /**
     * SYSCAT.TABCONST
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public DB2TabConstExample() {
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
     * SYSCAT.TABCONST null
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

        public Criteria andOwnerIsNull() {
            addCriterion("OWNER is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("OWNER is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("OWNER =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("OWNER <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("OWNER >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("OWNER <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("OWNER <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("OWNER like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("OWNER not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("OWNER in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("OWNER not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("OWNER between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("OWNER not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNull() {
            addCriterion("OWNERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNotNull() {
            addCriterion("OWNERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeEqualTo(String value) {
            addCriterion("OWNERTYPE =", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotEqualTo(String value) {
            addCriterion("OWNERTYPE <>", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThan(String value) {
            addCriterion("OWNERTYPE >", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThanOrEqualTo(String value) {
            addCriterion("OWNERTYPE >=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThan(String value) {
            addCriterion("OWNERTYPE <", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThanOrEqualTo(String value) {
            addCriterion("OWNERTYPE <=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLike(String value) {
            addCriterion("OWNERTYPE like", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotLike(String value) {
            addCriterion("OWNERTYPE not like", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIn(List<String> values) {
            addCriterion("OWNERTYPE in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotIn(List<String> values) {
            addCriterion("OWNERTYPE not in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeBetween(String value1, String value2) {
            addCriterion("OWNERTYPE between", value1, value2, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotBetween(String value1, String value2) {
            addCriterion("OWNERTYPE not between", value1, value2, "ownertype");
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

        public Criteria andEnforcedIsNull() {
            addCriterion("ENFORCED is null");
            return (Criteria) this;
        }

        public Criteria andEnforcedIsNotNull() {
            addCriterion("ENFORCED is not null");
            return (Criteria) this;
        }

        public Criteria andEnforcedEqualTo(String value) {
            addCriterion("ENFORCED =", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedNotEqualTo(String value) {
            addCriterion("ENFORCED <>", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedGreaterThan(String value) {
            addCriterion("ENFORCED >", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedGreaterThanOrEqualTo(String value) {
            addCriterion("ENFORCED >=", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedLessThan(String value) {
            addCriterion("ENFORCED <", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedLessThanOrEqualTo(String value) {
            addCriterion("ENFORCED <=", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedLike(String value) {
            addCriterion("ENFORCED like", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedNotLike(String value) {
            addCriterion("ENFORCED not like", value, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedIn(List<String> values) {
            addCriterion("ENFORCED in", values, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedNotIn(List<String> values) {
            addCriterion("ENFORCED not in", values, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedBetween(String value1, String value2) {
            addCriterion("ENFORCED between", value1, value2, "enforced");
            return (Criteria) this;
        }

        public Criteria andEnforcedNotBetween(String value1, String value2) {
            addCriterion("ENFORCED not between", value1, value2, "enforced");
            return (Criteria) this;
        }

        public Criteria andTrustedIsNull() {
            addCriterion("TRUSTED is null");
            return (Criteria) this;
        }

        public Criteria andTrustedIsNotNull() {
            addCriterion("TRUSTED is not null");
            return (Criteria) this;
        }

        public Criteria andTrustedEqualTo(String value) {
            addCriterion("TRUSTED =", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotEqualTo(String value) {
            addCriterion("TRUSTED <>", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedGreaterThan(String value) {
            addCriterion("TRUSTED >", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedGreaterThanOrEqualTo(String value) {
            addCriterion("TRUSTED >=", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedLessThan(String value) {
            addCriterion("TRUSTED <", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedLessThanOrEqualTo(String value) {
            addCriterion("TRUSTED <=", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedLike(String value) {
            addCriterion("TRUSTED like", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotLike(String value) {
            addCriterion("TRUSTED not like", value, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedIn(List<String> values) {
            addCriterion("TRUSTED in", values, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotIn(List<String> values) {
            addCriterion("TRUSTED not in", values, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedBetween(String value1, String value2) {
            addCriterion("TRUSTED between", value1, value2, "trusted");
            return (Criteria) this;
        }

        public Criteria andTrustedNotBetween(String value1, String value2) {
            addCriterion("TRUSTED not between", value1, value2, "trusted");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataIsNull() {
            addCriterion("CHECKEXISTINGDATA is null");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataIsNotNull() {
            addCriterion("CHECKEXISTINGDATA is not null");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataEqualTo(String value) {
            addCriterion("CHECKEXISTINGDATA =", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataNotEqualTo(String value) {
            addCriterion("CHECKEXISTINGDATA <>", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataGreaterThan(String value) {
            addCriterion("CHECKEXISTINGDATA >", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKEXISTINGDATA >=", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataLessThan(String value) {
            addCriterion("CHECKEXISTINGDATA <", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataLessThanOrEqualTo(String value) {
            addCriterion("CHECKEXISTINGDATA <=", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataLike(String value) {
            addCriterion("CHECKEXISTINGDATA like", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataNotLike(String value) {
            addCriterion("CHECKEXISTINGDATA not like", value, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataIn(List<String> values) {
            addCriterion("CHECKEXISTINGDATA in", values, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataNotIn(List<String> values) {
            addCriterion("CHECKEXISTINGDATA not in", values, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataBetween(String value1, String value2) {
            addCriterion("CHECKEXISTINGDATA between", value1, value2, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andCheckexistingdataNotBetween(String value1, String value2) {
            addCriterion("CHECKEXISTINGDATA not between", value1, value2, "checkexistingdata");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptIsNull() {
            addCriterion("ENABLEQUERYOPT is null");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptIsNotNull() {
            addCriterion("ENABLEQUERYOPT is not null");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptEqualTo(String value) {
            addCriterion("ENABLEQUERYOPT =", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptNotEqualTo(String value) {
            addCriterion("ENABLEQUERYOPT <>", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptGreaterThan(String value) {
            addCriterion("ENABLEQUERYOPT >", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptGreaterThanOrEqualTo(String value) {
            addCriterion("ENABLEQUERYOPT >=", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptLessThan(String value) {
            addCriterion("ENABLEQUERYOPT <", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptLessThanOrEqualTo(String value) {
            addCriterion("ENABLEQUERYOPT <=", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptLike(String value) {
            addCriterion("ENABLEQUERYOPT like", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptNotLike(String value) {
            addCriterion("ENABLEQUERYOPT not like", value, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptIn(List<String> values) {
            addCriterion("ENABLEQUERYOPT in", values, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptNotIn(List<String> values) {
            addCriterion("ENABLEQUERYOPT not in", values, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptBetween(String value1, String value2) {
            addCriterion("ENABLEQUERYOPT between", value1, value2, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andEnablequeryoptNotBetween(String value1, String value2) {
            addCriterion("ENABLEQUERYOPT not between", value1, value2, "enablequeryopt");
            return (Criteria) this;
        }

        public Criteria andDefinerIsNull() {
            addCriterion("DEFINER is null");
            return (Criteria) this;
        }

        public Criteria andDefinerIsNotNull() {
            addCriterion("DEFINER is not null");
            return (Criteria) this;
        }

        public Criteria andDefinerEqualTo(String value) {
            addCriterion("DEFINER =", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotEqualTo(String value) {
            addCriterion("DEFINER <>", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerGreaterThan(String value) {
            addCriterion("DEFINER >", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerGreaterThanOrEqualTo(String value) {
            addCriterion("DEFINER >=", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerLessThan(String value) {
            addCriterion("DEFINER <", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerLessThanOrEqualTo(String value) {
            addCriterion("DEFINER <=", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerLike(String value) {
            addCriterion("DEFINER like", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotLike(String value) {
            addCriterion("DEFINER not like", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerIn(List<String> values) {
            addCriterion("DEFINER in", values, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotIn(List<String> values) {
            addCriterion("DEFINER not in", values, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerBetween(String value1, String value2) {
            addCriterion("DEFINER between", value1, value2, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotBetween(String value1, String value2) {
            addCriterion("DEFINER not between", value1, value2, "definer");
            return (Criteria) this;
        }

        public Criteria andPeriodnameIsNull() {
            addCriterion("PERIODNAME is null");
            return (Criteria) this;
        }

        public Criteria andPeriodnameIsNotNull() {
            addCriterion("PERIODNAME is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodnameEqualTo(String value) {
            addCriterion("PERIODNAME =", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameNotEqualTo(String value) {
            addCriterion("PERIODNAME <>", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameGreaterThan(String value) {
            addCriterion("PERIODNAME >", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameGreaterThanOrEqualTo(String value) {
            addCriterion("PERIODNAME >=", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameLessThan(String value) {
            addCriterion("PERIODNAME <", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameLessThanOrEqualTo(String value) {
            addCriterion("PERIODNAME <=", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameLike(String value) {
            addCriterion("PERIODNAME like", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameNotLike(String value) {
            addCriterion("PERIODNAME not like", value, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameIn(List<String> values) {
            addCriterion("PERIODNAME in", values, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameNotIn(List<String> values) {
            addCriterion("PERIODNAME not in", values, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameBetween(String value1, String value2) {
            addCriterion("PERIODNAME between", value1, value2, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodnameNotBetween(String value1, String value2) {
            addCriterion("PERIODNAME not between", value1, value2, "periodname");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyIsNull() {
            addCriterion("PERIODPOLICY is null");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyIsNotNull() {
            addCriterion("PERIODPOLICY is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyEqualTo(String value) {
            addCriterion("PERIODPOLICY =", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyNotEqualTo(String value) {
            addCriterion("PERIODPOLICY <>", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyGreaterThan(String value) {
            addCriterion("PERIODPOLICY >", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyGreaterThanOrEqualTo(String value) {
            addCriterion("PERIODPOLICY >=", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyLessThan(String value) {
            addCriterion("PERIODPOLICY <", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyLessThanOrEqualTo(String value) {
            addCriterion("PERIODPOLICY <=", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyLike(String value) {
            addCriterion("PERIODPOLICY like", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyNotLike(String value) {
            addCriterion("PERIODPOLICY not like", value, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyIn(List<String> values) {
            addCriterion("PERIODPOLICY in", values, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyNotIn(List<String> values) {
            addCriterion("PERIODPOLICY not in", values, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyBetween(String value1, String value2) {
            addCriterion("PERIODPOLICY between", value1, value2, "periodpolicy");
            return (Criteria) this;
        }

        public Criteria andPeriodpolicyNotBetween(String value1, String value2) {
            addCriterion("PERIODPOLICY not between", value1, value2, "periodpolicy");
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
    }

    /**
     * SYSCAT.TABCONST
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * SYSCAT.TABCONST null
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