package com.team.platform.mapper;

import com.team.platform.pojo.SysComboBox;
import com.team.platform.pojo.SysComboBoxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysComboBoxMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysComboBoxExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysComboBoxExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String comboid);

    /**
     *
     * @mbg.generated
     */
    int insert(SysComboBox record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysComboBox record);

    /**
     *
     * @mbg.generated
     */
    List<SysComboBox> selectByExample(SysComboBoxExample example);

    /**
     *
     * @mbg.generated
     */
    SysComboBox selectByPrimaryKey(String comboid);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysComboBox record, @Param("example") SysComboBoxExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysComboBox record, @Param("example") SysComboBoxExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysComboBox record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysComboBox record);
}