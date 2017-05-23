package com.team.platform.mapper;

import com.team.platform.pojo.SysDictType;
import com.team.platform.pojo.SysDictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictTypeMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysDictTypeExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysDictTypeExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String dicttypeid);

    /**
     *
     * @mbg.generated
     */
    int insert(SysDictType record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysDictType record);

    /**
     *
     * @mbg.generated
     */
    List<SysDictType> selectByExample(SysDictTypeExample example);

    /**
     *
     * @mbg.generated
     */
    SysDictType selectByPrimaryKey(String dicttypeid);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysDictType record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysDictType record);
}