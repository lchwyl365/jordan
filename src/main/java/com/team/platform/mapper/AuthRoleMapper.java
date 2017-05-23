package com.team.platform.mapper;

import com.team.platform.pojo.AuthRole;
import com.team.platform.pojo.AuthRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthRoleMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AuthRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(AuthRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String roleid);

    /**
     *
     * @mbg.generated
     */
    int insert(AuthRole record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AuthRole record);

    /**
     *
     * @mbg.generated
     */
    List<AuthRole> selectByExample(AuthRoleExample example);

    /**
     *
     * @mbg.generated
     */
    AuthRole selectByPrimaryKey(String roleid);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AuthRole record, @Param("example") AuthRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AuthRole record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AuthRole record);
}