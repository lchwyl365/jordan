package com.team.platform.mapper;

import com.team.platform.pojo.Columns;
import com.team.platform.pojo.MysqlColumnsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MysqlColumnsMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(MysqlColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(MysqlColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int insert(Columns record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Columns record);

    /**
     *
     * @mbg.generated
     */
    List<Columns> selectByExampleWithBLOBs(MysqlColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    List<Columns> selectByExample(MysqlColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Columns record, @Param("example") MysqlColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") Columns record, @Param("example") MysqlColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Columns record, @Param("example") MysqlColumnsExample example);
}