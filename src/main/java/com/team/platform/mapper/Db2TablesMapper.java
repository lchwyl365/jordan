package com.team.platform.mapper;

import com.team.platform.pojo.Tables;
import com.team.platform.pojo.Db2TablesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Db2TablesMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(Db2TablesExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(Db2TablesExample example);

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
    List<Tables> selectByExample(Db2TablesExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Tables record, @Param("example") Db2TablesExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Tables record, @Param("example") Db2TablesExample example);
}