package com.team.common.util.gencode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.team.platform.service.impl.Db2DataServiceImpl;
import com.team.platform.service.impl.MysqlDataServiceImpl;

/**
 * @author liuchao
 * @email 463182580@qq.com
 * This class used to initialize data / load data ON the application started 
 */
@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent> {
    
	private static final Logger logger = Logger.getLogger(InitData.class);
	
	@Value("${DIALECT}")
	private String DIALECT;
	
	@Autowired
	private Db2DataServiceImpl db2DataServiceImpl;
	
	@Autowired
	private MysqlDataServiceImpl mysqlDataServiceImpl;
	
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	
    	if(event.getApplicationContext().getParent() == null){
        	logger.info("Initialize DB2SysTable data");
        	
        	switch (DIALECT.toLowerCase()){
        		case "db2":
        			db2DataServiceImpl.initDatabase();
        			break;
        		case "mysql":
        			mysqlDataServiceImpl.initDatabase();
        			break;
        	}
        	
    	}
    	
    }
    
}