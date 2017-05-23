package com.team.platform.mapper;

import com.team.platform.pojo.KeyColumnUsage;
import com.team.platform.pojo.KeyColumnUsageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeyColumnUsageMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(KeyColumnUsageExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(KeyColumnUsageExample example);

    /**
     *
     * @mbg.generated
     */
    int insert(KeyColumnUsage record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(KeyColumnUsage record);

    /**
     *
     * @mbg.generated
     */
    List<KeyColumnUsage> selectByExample(KeyColumnUsageExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") KeyColumnUsage record, @Param("example") KeyColumnUsageExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") KeyColumnUsage record, @Param("example") KeyColumnUsageExample example);
}