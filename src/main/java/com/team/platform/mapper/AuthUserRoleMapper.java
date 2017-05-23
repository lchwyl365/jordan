package com.team.platform.mapper;

import com.team.platform.pojo.AuthUserRole;
import com.team.platform.pojo.AuthUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthUserRoleMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AuthUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(AuthUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String userRoleId);

    /**
     *
     * @mbg.generated
     */
    int insert(AuthUserRole record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AuthUserRole record);

    /**
     *
     * @mbg.generated
     */
    List<AuthUserRole> selectByExample(AuthUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    AuthUserRole selectByPrimaryKey(String userRoleId);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AuthUserRole record, @Param("example") AuthUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AuthUserRole record, @Param("example") AuthUserRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AuthUserRole record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AuthUserRole record);
}