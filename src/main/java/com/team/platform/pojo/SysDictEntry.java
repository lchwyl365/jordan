package com.team.platform.pojo;

public class SysDictEntry extends SysDictEntryKey {
    /**
     * 字典项名称
     */
    private String dictname;

    /**
     * 状态
     */
    private String status;

    /**
     * 序号
     */
    private Integer sortno;

    /**
     * 字典等级
     */
    private String rank;

    /**
     * 上级编号
     */
    private String parentid;

    /**
     * 字典项名称
     * @return DICTNAME 字典项名称
     */
    public String getDictname() {
        return dictname;
    }

    /**
     * 字典项名称
     * @param dictname 字典项名称
     */
    public void setDictname(String dictname) {
        this.dictname = dictname == null ? null : dictname.trim();
    }

    /**
     * 状态
     * @return STATUS 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 序号
     * @return SORTNO 序号
     */
    public Integer getSortno() {
        return sortno;
    }

    /**
     * 序号
     * @param sortno 序号
     */
    public void setSortno(Integer sortno) {
        this.sortno = sortno;
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