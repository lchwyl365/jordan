package com.team.platform.pojo;

public class DB2KeyColuse {
    /**
     * null
     */
    private String constname;

    /**
     * null
     */
    private String tabschema;

    /**
     * null
     */
    private String tabname;

    /**
     * null
     */
    private String colname;

    /**
     * null
     */
    private Short colseq;

    /**
     * null
     * @return CONSTNAME null
     */
    public String getConstname() {
        return constname;
    }

    /**
     * null
     * @param constname null
     */
    public void setConstname(String constname) {
        this.constname = constname == null ? null : constname.trim();
    }

    /**
     * null
     * @return TABSCHEMA null
     */
    public String getTabschema() {
        return tabschema;
    }

    /**
     * null
     * @param tabschema null
     */
    public void setTabschema(String tabschema) {
        this.tabschema = tabschema == null ? null : tabschema.trim();
    }

    /**
     * null
     * @return TABNAME null
     */
    public String getTabname() {
        return tabname;
    }

    /**
     * null
     * @param tabname null
     */
    public void setTabname(String tabname) {
        this.tabname = tabname == null ? null : tabname.trim();
    }

    /**
     * null
     * @return COLNAME null
     */
    public String getColname() {
        return colname;
    }

    /**
     * null
     * @param colname null
     */
    public void setColname(String colname) {
        this.colname = colname == null ? null : colname.trim();
    }

    /**
     * null
     * @return COLSEQ null
     */
    public Short getColseq() {
        return colseq;
    }

    /**
     * null
     * @param colseq null
     */
    public void setColseq(Short colseq) {
        this.colseq = colseq;
    }
}