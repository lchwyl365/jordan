package com.team.common.util.gencode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class GeneratorService {

	/*****
     * 根据Model类产生Controller Service Mapper类代码，如UserController.java
     */
    public void generateJava(GeneratorModel generatorModel,String filetype) throws IOException{

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", generatorModel);
        
        String path = System.getProperty("user.dir").replaceAll("\\\\", "/") + "/src/main/java";
        String className = "";
		String mapperPackage = "";
		if("Service".equals(filetype)){
			mapperPackage = generatorModel.getServiceTargetPackage();
			className = generatorModel.getDomainObjectName()+filetype;
		}
		if("ServiceImpl".equals(filetype)){
			mapperPackage = generatorModel.getServiceTargetPackage()+".impl";
			className = generatorModel.getDomainObjectName()+filetype;
		}
		if("Controller".equals(filetype)){
			mapperPackage = generatorModel.getControllerTargetPackage();
			className = generatorModel.getDomainObjectName()+filetype;
		}
		if("Vo".equals(filetype)){
			mapperPackage = "com.team."+generatorModel.getBusinessName()+".vo";
			className = generatorModel.getDomainObjectName()+filetype;
		}
		mapperPackage = mapperPackage.replace(".", "/");
		String dirpath = path+"/"+mapperPackage+"/";
		
        FileUtils.forceMkdir(new File(dirpath));
        FreemarkerUtil.getInstance().fprint("Java"+filetype+".ftl", data, dirpath+ className +".java");
    }
    
    public void generateJsp(GeneratorModel generatorModel,String filetype) throws IOException{

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("model", generatorModel);
        
        String path = System.getProperty("user.dir").replaceAll("\\\\", "/") + "/src/main/webapp/WEB-INF/jsp";
		String dirpath = path+"/"+generatorModel.getPath()+"/";
		
        FileUtils.forceMkdir(new File(dirpath));
        FreemarkerUtil.getInstance().fprint("jsp_"+filetype+".ftl", data, dirpath+filetype+".jsp");
    }

	public void generateWeb(GeneratorModel generatorModel) throws Exception {
		generateJava(generatorModel,"Service");
		generateJava(generatorModel,"ServiceImpl");
		generateJava(generatorModel,"Controller");
		if("TreeGrid".equals(generatorModel.getGentype())){
			generateJava(generatorModel,"Vo");
		}
		generateJsp(generatorModel,"list");
		generateJsp(generatorModel,"add");
		generateJsp(generatorModel,"update");
	}
}
