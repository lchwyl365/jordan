package com.team.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.jdom2.JDOMException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataExportXml {

	private ApplicationContext applicationContext;
	
	@Test
	public void testExport() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		DataExportXml dataExportXml = applicationContext.getBean(DataExportXml.class);
		try {
			dataExportXml.export();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testImport() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		DataExportXml dataExportXml = applicationContext.getBean(DataExportXml.class);

		try {
			System.out.println("import success ...");
			dataExportXml.importXml();
			System.out.println("import complete ...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
