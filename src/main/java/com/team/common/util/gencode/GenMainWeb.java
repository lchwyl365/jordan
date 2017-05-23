package com.team.common.util.gencode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Controller代码产生器,根据Controller类模板用FreeMarker产生Controller代码.
 * @author HuangYu , 2013.9 modify by liuchao
 */
@Component
public class GenMainWeb {

    private String outputDir = "D:/workspace-j2ee/xbshop";
    
    private String srcDir = "/src/main/java/";
    
    private String resDir = "/src/main/resources/";
    
    private String webappDir = "/src/main/webapp/WEB-INF/jsp/admin/";
    
    public String uuid;

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
   
    /*****
     * 根据Model类产生Controller Service Mapper类代码，如UserController.java
     * @param className Model类的名字，如：User
     * @param packageName 模块包的名字，如：com.sys
     * @param type Model类的类型，如：Controller Service ServiceImpl
     */
    public void generateJava(String dirpath,String path,String className,String packageName,String type,List<Map<String,String>> attrMap) throws IOException{

    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("className", className);
    	map.put("packageName", packageName);
    	//model.setWeb(true);
    	map.put("attr", attrMap);
        // Build the data-model
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", map);
        
        FileUtils.forceMkdir(new File(dirpath));
        
        FreemarkerUtil.getInstance().fprint("Java"+type + ".ftl", data, path);
        
    }

}