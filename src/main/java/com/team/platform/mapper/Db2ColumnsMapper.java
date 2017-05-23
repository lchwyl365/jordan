package com.team.platform.mapper;

import com.team.platform.pojo.Columns;
import com.team.platform.pojo.Db2ColumnsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Db2ColumnsMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(Db2ColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(Db2ColumnsExample example);

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
    List<Columns> selectByExample(Db2ColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Columns record, @Param("example") Db2ColumnsExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Columns record, @Param("example") Db2ColumnsExample example);
}