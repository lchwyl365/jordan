package com.team.platform.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;

public class TestSysTablesService {

	private ApplicationContext applicationContext;
	
	@Test
	public void testGenerate() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		SysTablesService sysTablesService = applicationContext.getBean(SysTablesService.class);
		String tbname = "AUTH_TEST";
		String tbcreator = "HDMS";
		//获取表信息
		SysTables sysTables = sysTablesService.selectByPrimaryKey(tbname, tbcreator, "T");
		//获取表的列信息
		SysColumnsService sysColumnsService = applicationContext.getBean(SysColumnsService.class);
		SysColumns sysColumns = new SysColumns();
		sysColumns.setTbcreator(tbcreator);
		sysColumns.setTbname(tbname);
		List<SysColumns> sysColumnsList = sysColumnsService.selectByExample(sysColumns);
		//生成表的后台代码
		sysTablesService.generateAll(sysTables, sysColumnsList);
	}

}
