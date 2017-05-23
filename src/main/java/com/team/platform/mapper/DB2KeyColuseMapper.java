package com.team.platform.mapper;

import com.team.platform.pojo.DB2KeyColuse;
import com.team.platform.pojo.DB2KeyColuseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DB2KeyColuseMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(DB2KeyColuseExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(DB2KeyColuseExample example);

    /**
     *
     * @mbg.generated
     */
    int insert(DB2KeyColuse record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(DB2KeyColuse record);

    /**
     *
     * @mbg.generated
     */
    List<DB2KeyColuse> selectByExample(DB2KeyColuseExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DB2KeyColuse record, @Param("example") DB2KeyColuseExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DB2KeyColuse record, @Param("example") DB2KeyColuseExample example);
}