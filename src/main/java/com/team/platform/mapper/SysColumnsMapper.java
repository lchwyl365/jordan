package com.team.platform.mapper;

import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysColumnsExample;
import com.team.platform.pojo.SysColumnsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysColumnsMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(SysColumnsKey key);

    /**
     *
     * @mbg.generated
     */
    int insert(SysColumns record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysColumns record);

    /**
     *
     * @mbg.generated
     */
    List<SysColumns> selectByExample(SysColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    SysColumns selectByPrimaryKey(SysColumnsKey key);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysColumns record, @Param("example") SysColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysColumns record, @Param("example") SysColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysColumns record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysColumns record);
}