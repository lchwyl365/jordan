package com.team.platform.mapper;

import com.team.platform.pojo.AuthRoleMenu;
import com.team.platform.pojo.AuthRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthRoleMenuMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AuthRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(AuthRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String roleMenuId);

    /**
     *
     * @mbg.generated
     */
    int insert(AuthRoleMenu record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AuthRoleMenu record);

    /**
     *
     * @mbg.generated
     */
    List<AuthRoleMenu> selectByExample(AuthRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    AuthRoleMenu selectByPrimaryKey(String roleMenuId);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AuthRoleMenu record, @Param("example") AuthRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AuthRoleMenu record, @Param("example") AuthRoleMenuExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AuthRoleMenu record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AuthRoleMenu record);
}