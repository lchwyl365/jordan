package com.team.platform.mapper;

import com.team.platform.pojo.Tables;
import com.team.platform.pojo.MysqlTablesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MysqlTablesMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(MysqlTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(MysqlTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int insert(Tables record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Tables record);

    /**
     *
     * @mbg.generated
     */
    List<Tables> selectByExample(MysqlTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Tables record, @Param("example") MysqlTablesExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Tables record, @Param("example") MysqlTablesExample example);
}