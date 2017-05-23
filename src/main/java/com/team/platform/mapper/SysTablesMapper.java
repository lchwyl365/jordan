package com.team.platform.mapper;

import com.team.platform.pojo.SysTables;
import com.team.platform.pojo.SysTablesExample;
import com.team.platform.pojo.SysTablesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTablesMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SysTablesKey key);

    /**
     *
     * @mbg.generated
     */
    int insert(SysTables record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysTables record);

    /**
     *
     * @mbg.generated
     */
    List<SysTables> selectByExample(SysTablesExample example);

    /**
     *
     * @mbg.generated
     */
    SysTables selectByPrimaryKey(SysTablesKey key);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysTables record, @Param("example") SysTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysTables record, @Param("example") SysTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysTables record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysTables record);
}