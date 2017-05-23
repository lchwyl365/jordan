package com.team.platform.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.CookieUtils;
import com.team.common.util.ExceptionUtil;
import com.team.common.util.JsonUtils;
import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.dao.JedisClient;
import com.team.platform.mapper.AuthUserMapper;
import com.team.platform.mapper.CommonMapper;
import com.team.platform.pojo.AuthUser;
import com.team.platform.pojo.AuthUserExample;
import com.team.platform.pojo.AuthUserExample.Criteria;
import com.team.platform.pojo.AuthUserRole;
import com.team.platform.service.AuthUserService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

	@Autowired
	private AuthUserMapper authUserMapper;
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;
	
	public EUDataGridResult selectList(EUDataGridModel dgm, AuthUser authUser) {
		
		//查询列表
		AuthUserExample example = new AuthUserExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(authUser.getUsername())){
			criteria.andUsernameLike("%"+authUser.getUsername()+"%");
		}
		if(StringUtils.isNotEmpty(authUser.getOperatorname())){
			criteria.andOperatornameLike("%"+authUser.getOperatorname()+"%");
		}
		//排序
		if(StringUtils.isNotEmpty(dgm.getSort())){
			example.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<AuthUser> list = authUserMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<AuthUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public ResponseResult insert(AuthUser user) {
		try {
			//补全pojo内容
			user.setUserid(PrimaryKeyFactory.generatePK(""));
			user.setCreatetime(new Date());
			user.setAltertime(new Date());
			user.setStatus(StringUtils.isEmpty(user.getStatus()) ? "F" :"T");
			//md5加密
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			authUserMapper.insert(user);
			return ResponseResult.ok();
		} catch (Exception e) {
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
		
	}

	@Override
	public ResponseResult delete(List<String> userids) {
		try {
			for (String userid : userids) {
				authUserMapper.deleteByPrimaryKey(userid);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public AuthUser selectByPrimaryKey(String userid) {
		return authUserMapper.selectByPrimaryKey(userid);
	}

	@Override
	public ResponseResult update(AuthUser authUser) {
		try {
			AuthUser temp = authUserMapper.selectByPrimaryKey(authUser.getUserid());
			temp.setAltertime(new Date());
			temp.setOperatorname(authUser.getOperatorname());
			temp.setUsername(authUser.getUsername());
			temp.setPassword(DigestUtils.md5DigestAsHex(authUser.getPassword().getBytes()));
			temp.setStatus(StringUtils.isEmpty(authUser.getStatus()) ? "F" :"T");
			authUserMapper.updateByPrimaryKey(temp);
			return ResponseResult.ok();
		} catch (Exception e) {
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public ResponseResult userLogin(String username, String password,HttpServletRequest request, HttpServletResponse response) {
		//查询列表
		AuthUserExample example = new AuthUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<AuthUser> list = authUserMapper.selectByExample(example);
		//如果没有此用户名
		if (null == list || list.size() == 0) {
			return ResponseResult.build(400, "用户名或密码错误");
		}
		AuthUser user = list.get(0);
		//比对密码
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			return ResponseResult.build(400, "用户名或密码错误");
		}
		//生成token
		String token = UUID.randomUUID().toString();
		//保存用户之前，把用户对象中的密码清空。
		user.setPassword(null);
		//把用户信息写入redis
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//设置session的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		
		//写入cookie
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);

		//返回token
		return ResponseResult.ok(token);
	}

	@Override
	public AuthUser getUserByToken(String token) {
		//根据token从redis中查询用户信息
		String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
		//判断是否为空
		if (StringUtils.isBlank(json)) {
			return null;
		}
		//更新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		//返回用户信息
		return JsonUtils.jsonToPojo(json, AuthUser.class);
	}

	@Override
	public EUDataGridResult selectListByRole(EUDataGridModel dgm,AuthUser user, String roleid) {
		if(StringUtils.isEmpty(roleid)){
			return null;
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<AuthUser> list = commonMapper.selectUserByRole(roleid);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<AuthUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public List<AuthUser> selectList() {
		List<AuthUser> list = authUserMapper.selectByExample(new AuthUserExample());
		return list;
	}

	@Override
	public int insertUser(AuthUser user) {
		return authUserMapper.insert(user);
	}

}
