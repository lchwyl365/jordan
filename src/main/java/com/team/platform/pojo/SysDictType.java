package com.team.platform.pojo;

public class SysDictType {
    /**
     * 字典编号
     */
    private String dicttypeid;

    /**
     * 字典名称
     */
    private String dicttypename;

    /**
     * 字典等级
     */
    private String rank;

    /**
     * 上级编号
     */
    private String parentid;

    /**
     * 字典编号
     * @return DICTTYPEID 字典编号
     */
    public String getDicttypeid() {
        return dicttypeid;
    }

    /**
     * 字典编号
     * @param dicttypeid 字典编号
     */
    public void setDicttypeid(String dicttypeid) {
        this.dicttypeid = dicttypeid == null ? null : dicttypeid.trim();
    }

    /**
     * 字典名称
     * @return DICTTYPENAME 字典名称
     */
    public String getDicttypename() {
        return dicttypename;
    }

    /**
     * 字典名称
     * @param dicttypename 字典名称
     */
    public void setDicttypename(String dicttypename) {
        this.dicttypename = dicttypename == null ? null : dicttypename.trim();
    }

    /**
     * 字典等级
     * @return RANK 字典等级
     */
    public String getRank() {
        return rank;
    }

    /**
     * 字典等级
     * @param rank 字典等级
     */
    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    /**
     * 上级编号
     * @return PARENTID 上级编号
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 上级编号
     * @param parentid 上级编号
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }
}