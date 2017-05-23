package com.team.common.util.gencode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;
import com.team.platform.service.impl.SysTablesServiceImpl;

@Component
public class MybatisXMLDOM {
    
	@Value("${jdbc.driver}")
	private String JDBC_DRIVER;
	
	@Value("${jdbc.url}")
	private String JDBC_URL;
	
	@Value("${jdbc.username}")
	private String JDBC_USERNAME;
	
	@Value("${jdbc.password}")
	private String JDBC_PASSWORD;
	
	private static final Logger logger = Logger.getLogger(SysTablesServiceImpl.class);

	public void generator(SysTables sysTables,List<SysColumns> sysColumnsList) throws Exception {
		File xmlFile = ResourceUtils.getFile("classpath:gencode/generatorConfig-template.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            //1.更新数据库连接
            Map<String,String> jdbcMap = new HashMap<String,String>();
            jdbcMap.put("connectionURL", JDBC_URL);
            jdbcMap.put("driverClass", JDBC_DRIVER);
            jdbcMap.put("userId", JDBC_USERNAME);
            jdbcMap.put("password", JDBC_PASSWORD);
            updateElementAttribute(doc,"jdbcConnection",jdbcMap);
            String businessName = sysTables.getBusinessName();
    		//2.更新javaModelGenerator
    		updateElementAttribute(doc,"javaModelGenerator","targetPackage",sysTables.getPojoTargetPackage());
    		//3.更新sqlMapGenerator
    		updateElementAttribute(doc,"sqlMapGenerator","targetPackage",sysTables.getMapperTargetPackage());
    		//4.更新javaClientGenerator
    		updateElementAttribute(doc,"javaClientGenerator","targetPackage",sysTables.getMapperTargetPackage());
    		//< ="HDMS" ="AUTH_ROLE" ="AuthRole">
    		//5.更新表结构
            Map<String,String> tableMap = new HashMap<String,String>();
            tableMap.put("schema", sysTables.getSchemaName());
            tableMap.put("tableName", sysTables.getTableName());
            tableMap.put("domainObjectName", sysTables.getDomainObjectName());
            updateElementAttribute(doc,"table",tableMap);
            //6.更新列信息 <columnOverride column="ROLEID" property="roleid" />
            for (SysColumns sysColumns : sysColumnsList) {
            	Map<String,String> attrMap = new HashMap<String,String>();
            	attrMap.put("column", sysColumns.getColumnName());
            	attrMap.put("property", sysColumns.getPropertyName());
            	addElementAttribute(doc,"table","columnOverride",attrMap);
			}
    		
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            String dtdpath = xmlFile.getParentFile().getPath().replaceAll("\\\\", "/") + "/mybatis-generator-config_1_0.dtd";
            System.out.println(dtdpath);
            DOMImplementation domImpl = doc.getImplementation();
            DocumentType doctype = domImpl.createDocumentType( "doctype","-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN","mybatis-generator-config_1_0.dtd");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(xmlFile.getParentFile().getPath(),"generatorConfig.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            logger.info("generatorConfig XML file updated successfully");
            
        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
	}
	
	private void addElementAttribute(Document doc, String parent, String element,Map<String,String> attrMap) {
		NodeList employees = doc.getElementsByTagName(parent);
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Element childElement = doc.createElement(element);
            for (Map.Entry<String,String> entry:attrMap.entrySet()) {
            	childElement.setAttribute(entry.getKey() , entry.getValue());
            } 
            emp.appendChild(childElement);
        }
	}

	private void updateElementAttribute(Document doc,String elementName,Map<String,String> attrMap) {
		NodeList nodelist = doc.getElementsByTagName(elementName);
        Element emp = null;
        for(int i=0; i<nodelist.getLength();i++){
            emp = (Element) nodelist.item(i);
            for (Map.Entry<String,String> entry:attrMap.entrySet()) {
                emp.setAttribute(entry.getKey() , entry.getValue());
            } 
        }
	}
	private void updateElementAttribute(Document doc,String elementName,String attributeName,String  attributeValue) {
		NodeList nodelist = doc.getElementsByTagName(elementName);
        Element emp = null;
        for(int i=0; i<nodelist.getLength();i++){
            emp = (Element) nodelist.item(i);
            emp.setAttribute(attributeName, attributeValue);
        }
	}
}