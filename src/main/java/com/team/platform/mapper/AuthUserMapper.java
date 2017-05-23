package com.team.platform.mapper;

import com.team.platform.pojo.AuthUser;
import com.team.platform.pojo.AuthUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthUserMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AuthUserExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(AuthUserExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String userid);

    /**
     *
     * @mbg.generated
     */
    int insert(AuthUser record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AuthUser record);

    /**
     *
     * @mbg.generated
     */
    List<AuthUser> selectByExample(AuthUserExample example);

    /**
     *
     * @mbg.generated
     */
    AuthUser selectByPrimaryKey(String userid);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AuthUser record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AuthUser record);
}