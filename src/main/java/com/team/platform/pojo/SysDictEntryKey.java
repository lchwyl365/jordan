package com.team.platform.pojo;

public class SysDictEntryKey {
    /**
     * 字典编号
     */
    private String dicttypeid;

    /**
     * 字典项编号
     */
    private String dictid;

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
     * 字典项编号
     * @return DICTID 字典项编号
     */
    public String getDictid() {
        return dictid;
    }

    /**
     * 字典项编号
     * @param dictid 字典项编号
     */
    public void setDictid(String dictid) {
        this.dictid = dictid == null ? null : dictid.trim();
    }
}