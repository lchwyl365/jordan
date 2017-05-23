package com.team.platform.mapper;

import com.team.platform.pojo.SysDictEntry;
import com.team.platform.pojo.SysDictEntryExample;
import com.team.platform.pojo.SysDictEntryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictEntryMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysDictEntryExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysDictEntryExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SysDictEntryKey key);

    /**
     *
     * @mbg.generated
     */
    int insert(SysDictEntry record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysDictEntry record);

    /**
     *
     * @mbg.generated
     */
    List<SysDictEntry> selectByExample(SysDictEntryExample example);

    /**
     *
     * @mbg.generated
     */
    SysDictEntry selectByPrimaryKey(SysDictEntryKey key);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysDictEntry record, @Param("example") SysDictEntryExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysDictEntry record, @Param("example") SysDictEntryExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysDictEntry record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysDictEntry record);
}