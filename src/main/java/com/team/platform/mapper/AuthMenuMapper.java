package com.team.platform.mapper;

import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.AuthMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthMenuMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AuthMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(AuthMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String menuid);

    /**
     *
     * @mbg.generated
     */
    int insert(AuthMenu record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AuthMenu record);

    /**
     *
     * @mbg.generated
     */
    List<AuthMenu> selectByExample(AuthMenuExample example);

    /**
     *
     * @mbg.generated
     */
    AuthMenu selectByPrimaryKey(String menuid);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AuthMenu record, @Param("example") AuthMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AuthMenu record, @Param("example") AuthMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AuthMenu record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AuthMenu record);
}