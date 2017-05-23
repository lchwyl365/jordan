package com.team.platform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.common.pojo.ResponseResult;
import com.team.common.util.AesCBC;
import com.team.common.util.CookieUtils;
import com.team.platform.dao.JedisClient;
import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.AuthUser;
import com.team.platform.service.AuthMenuService;
import com.team.platform.service.AuthUserService;

@Controller
@RequestMapping("/")
public class WebController {
	
	@Autowired
	private AuthMenuService authMenuService;
	
	@Autowired
	private AuthUserService authUserService;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;

	@RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		//从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		//根据token换取用户信息，调用sso系统的接口。
		AuthUser user = authUserService.getUserByToken(token);
		List<AuthMenu> topMenus = authMenuService.selectListByAuth(user.getUserid(),"4758592868910319","top");
		model.addAttribute("topMenus", topMenus);
    	return "index";
    }
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		//AES 加密使用
		model.addAttribute("key",AesCBC.CBC_KEY);
		model.addAttribute("iv",AesCBC.CBC_IV);
    	return "login";
    }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult login(@RequestParam String username,@RequestParam String password,HttpServletRequest request, HttpServletResponse response) {
		try {
			//对密码解密
			password = AesCBC.getInstance().decrypt(password,"utf-8",AesCBC.CBC_KEY,AesCBC.CBC_IV);
			ResponseResult result = authUserService.userLogin(username, password,request,response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(500, e.getMessage());
		}
	}
	
	@RequestMapping(value="/loginout", method=RequestMethod.GET)
	public String loginout(HttpServletRequest request, HttpServletResponse response,Model model) {
		//从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		jedisClient.del(REDIS_USER_SESSION_KEY + ":"+ token);
    	return "redirect:/login";
	}
}
