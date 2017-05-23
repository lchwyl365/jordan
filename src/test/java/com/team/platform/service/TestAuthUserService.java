package com.team.platform.service;

import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.DigestUtils;

import com.team.common.util.PrimaryKeyFactory;
import com.team.platform.mapper.AuthUserMapper;
import com.team.platform.pojo.AuthUser;

public class TestAuthUserService {

	private ApplicationContext applicationContext;

	@Test
	public void test() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		final AuthUserMapper authUserMapper = applicationContext.getBean(AuthUserMapper.class);
		//执行添加管理员
		final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		int length = 1000;
		final CountDownLatch latch = new CountDownLatch(length);
		Thread[] arr = new Thread[length];
		for(int i=0;i<length;i++){
			arr[i] = new Thread(new Runnable(){
				public void run(){
					HashSet<String> subset = new HashSet<String>();
					for(int j=0; j<500; j++){
						AuthUser user = new AuthUser();
						user.setUserid(PrimaryKeyFactory.generatePK(""));
						user.setUsername("test"+user.getUserid());
						user.setOperatorname("测试用户"+user.getUsername());
						//md5加密
						user.setPassword(""+j);
						user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
						user.setCreatetime(new Date());
						user.setAltertime(new Date());
						user.setStatus("F");
						authUserMapper.insert(user);
						subset.add(user.getUserid());
						System.out.println("添加用户："+user.getUsername());
					}
					latch.countDown();
				}
			});
		}
		for(int i=0;i<length;i++){
			arr[i].start();
		}
		latch.await();
		System.out.println("size:"+ map.size());	
	}

}
