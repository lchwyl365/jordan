package com.team.platform.mapper;

import com.team.platform.pojo.DB2TabConst;
import com.team.platform.pojo.DB2TabConstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DB2TabConstMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(DB2TabConstExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(DB2TabConstExample example);

    /**
     *
     * @mbg.generated
     */
    int insert(DB2TabConst record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(DB2TabConst record);

    /**
     *
     * @mbg.generated
     */
    List<DB2TabConst> selectByExample(DB2TabConstExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DB2TabConst record, @Param("example") DB2TabConstExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DB2TabConst record, @Param("example") DB2TabConstExample example);
}