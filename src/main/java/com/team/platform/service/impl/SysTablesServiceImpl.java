package com.team.platform.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.common.pojo.EUDataGridModel;
import com.team.common.pojo.EUDataGridResult;
import com.team.common.pojo.ResponseResult;
import com.team.common.util.ExceptionUtil;
import com.team.common.util.gencode.GeneratorModel;
import com.team.common.util.gencode.GeneratorProperty;
import com.team.common.util.gencode.GeneratorService;
import com.team.common.util.gencode.MybatisXMLDOM;
import com.team.platform.mapper.SysTablesMapper;
import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.Columns;
import com.team.platform.pojo.SysColumns;
import com.team.platform.pojo.SysTables;
import com.team.platform.pojo.SysTablesExample;
import com.team.platform.pojo.SysTablesExample.Criteria;
import com.team.platform.pojo.SysTablesKey;
import com.team.platform.service.AuthMenuService;
import com.team.platform.service.SysColumnsService;
import com.team.platform.service.SysTablesService;

/**
 * Created by liuchao on 2017/02/21 0021.
 */
@Service
public class SysTablesServiceImpl implements SysTablesService {

	@Autowired
	private SysTablesMapper sysTablesMapper;

	@Autowired
	private SysColumnsService sysColumnsService;
	
	@Autowired
	private GeneratorService generatorService;
	
	@Autowired
	private AuthMenuService authMenuService;
	
	@Autowired
	private MybatisXMLDOM mybatisXMLDOM;
	
	private static final Logger logger = Logger.getLogger(SysTablesServiceImpl.class);

	@Override
	public SysTables selectByPrimaryKey(String tableName, String schema,
			String type) {
		SysTablesKey key = new SysTablesKey();
		key.setTableName(tableName);
		key.setSchemaName(schema);
		key.setType(type);
		SysTables sysTables = sysTablesMapper.selectByPrimaryKey(key);
		return sysTables;
	}

	@Override
	public int insert(SysTables sysTables, List<Columns> columns) {
		SysColumns temp = new SysColumns();
		boolean flag = false;
		for (Columns db2SysColumn : columns) {
			//1.查看是否已存在该字段
			temp.setTbname(db2SysColumn.getTableName());
			temp.setTbcreator(db2SysColumn.getTableSchema());
			List<SysColumns> list = sysColumnsService.selectByExample(temp);
			flag = false;
			for (SysColumns sysColumns : list) {
				if (db2SysColumn.getColumnName().equals(sysColumns.getColumnName())
						&& db2SysColumn.getTableName().equals(sysColumns.getTbname())
						&& db2SysColumn.getTableSchema().equals(sysColumns.getTbcreator())) {
					flag = true;
				}
			}
			if(flag){ //2.1 已存在更新
				sysColumnsService.update(db2SysColumn);
			}else{//2.2 不存在添加
				sysColumnsService.insert(db2SysColumn);
			}
		}
		//path
		String tableName = sysTables.getTableName();
		int lastIndex = tableName.lastIndexOf("_");
		String path = (lastIndex == -1) ? tableName : tableName.substring(lastIndex+1).toLowerCase();
		sysTables.setPath(path);
		//DOMAIN_OBJECT_NAME
		String[] names = tableName.split("_");
		StringBuilder domainObjectName = new StringBuilder();
		StringBuilder variableName = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			String sname = names[i].toLowerCase();
			String headUpperCase =  sname.substring(0,1).toUpperCase() + sname.substring(1);
			domainObjectName.append(headUpperCase);
			if(i == 0){
				variableName.append(sname);
			}else{
				variableName.append(headUpperCase);
			}
		}
		sysTables.setDomainObjectName(domainObjectName.toString());
		sysTables.setVariableName(variableName.toString());
		sysTables.setMenuName(StringUtils.isNotEmpty(sysTables.getRemarks())?sysTables.getRemarks():tableName);
		//POJO_TARGET_PACKAGE
		sysTables.setPojoTargetPackage("com.team."+sysTables.getBusinessName()+".pojo");
		//MAPPER_TARGET_PACKAGE
		sysTables.setMapperTargetPackage("com.team."+sysTables.getBusinessName()+".mapper");
		//SERVICE_TARGET_PACKAGE
		sysTables.setServiceTargetPackage("com.team."+sysTables.getBusinessName()+".service");
		//CONTROLLER_TARGET_PACKAGE
		sysTables.setControllerTargetPackage("com.team."+sysTables.getBusinessName()+".controller");
		sysTables.setIsadd("T");
		sysTables.setIsupdate("T");
		sysTables.setIsdelete("T");
		sysTables.setGentype("DataGrid");
		//TODO ADD sysTables COLUMN
		return sysTablesMapper.insert(sysTables);
	}
	public ResponseResult update(SysTables sysTables) {
		try {
			sysTablesMapper.updateByPrimaryKeySelective(sysTables);
			return ResponseResult.ok();
		} catch (Exception e) {
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}
	public ResponseResult updateIdField(SysTables sysTables) {
		try {
			if(StringUtils.isNotEmpty(sysTables.getIdField())){
				sysTablesMapper.updateByPrimaryKeySelective(sysTables);
			}
			return ResponseResult.ok();
		} catch (Exception e) {
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}
	public EUDataGridResult selectList(EUDataGridModel dgm, SysTables sysTables) {
		//查询列表
		SysTablesExample sysTablesExample = new SysTablesExample();
		Criteria criteria = sysTablesExample.createCriteria();
		if(StringUtils.isNotEmpty(sysTables.getTableName())){
			criteria.andTableNameLike("%"+sysTables.getTableName()+"%");
		}
		//排序
		if(StringUtils.isNotEmpty(dgm.getSort())){
			sysTablesExample.setOrderByClause(dgm.getSort() + " " + dgm.getOrder());
		}
		//分页处理
		PageHelper.startPage(dgm.getPage(), dgm.getRows());
		List<SysTables> list = sysTablesMapper.selectByExample(sysTablesExample);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<SysTables> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public ResponseResult generateMapper(SysTables sysTables, List<SysColumns> sysColumnsList){
		try {
			//根据表信息生成generatorConfiguration.xml文件
			mybatisXMLDOM.generator(sysTables,sysColumnsList);
			
			//查看Mapper文件是否已存在，存在删除该文件
			String path = System.getProperty("user.dir").replaceAll("\\\\", "/") + "/src/main/java";
			String mapperPackage = sysTables.getMapperTargetPackage();
			mapperPackage = mapperPackage.replace(".", "/");
			String filePath = path+"/"+mapperPackage+"/"+sysTables.getDomainObjectName()+ "Mapper.xml";
			deleteFile(filePath);
			
			//生成mybatis代码
			generatorMybatisCode();
			
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}
	
	public void generatorMybatisCode() throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//指定 逆向工程配置文件
		File configFile = ResourceUtils.getFile("classpath:gencode/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}

	@Override
	public ResponseResult generateAll(SysTables sysTables,List<SysColumns> sysColumnsList) {
		
		try {
			//添加菜单
			AuthMenu menu = new AuthMenu();
			menu.setName(sysTables.getMenuName());
			List<AuthMenu> list = authMenuService.selectList(menu);
			if(list.size() > 0){ menu.setName(sysTables.getMenuName()+"2");}
			menu.setMenuPos("left");
			menu.setDisplay("on");
			menu.setIconCls("icon-sys");
			menu.setOrderNum("1");
			menu.setPid("4929836951411131");
			menu.setHref("/platform/"+sysTables.getPath()+"/list");
			authMenuService.insert(menu);
			//生成代码
			ResponseResult result = this.generateMapper(sysTables, sysColumnsList);
			if(ResponseResult.SUCCESS.equals(result.getStatus())){
				GeneratorModel generatorModel = getGeneratorModel(sysTables, sysColumnsList);
				return this.generateWeb(generatorModel);
			}else{
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}

	public ResponseResult generateWeb(GeneratorModel generatorModel) {
		try{
			generatorService.generateWeb(generatorModel);
			return ResponseResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public List<SysTables> selectAll() {
		//查询列表
		SysTablesExample sysTablesExample = new SysTablesExample();
		//排序
		sysTablesExample.setOrderByClause("FID ASC");
		//分页处理
		List<SysTables> list = sysTablesMapper.selectByExample(sysTablesExample);
		return list;
	}

	@Override
	public ResponseResult generateJava(SysTables sysTables,List<SysColumns> sysColumnsList) {
		
		//生成代码
		ResponseResult result = this.generateMapper(sysTables, sysColumnsList);
		try {
			if(ResponseResult.SUCCESS.equals(result.getStatus())){
				GeneratorModel generatorModel = getGeneratorModel(sysTables, sysColumnsList);
				generatorService.generateJava(generatorModel,"Service");
				generatorService.generateJava(generatorModel,"ServiceImpl");
				return ResponseResult.ok();
			}else{
				return result;
			}
		} catch (IOException e) {
			return ResponseResult.build(ResponseResult.ERROR, ExceptionUtil.getStackTrace(e));
		}
	}

	private GeneratorModel getGeneratorModel(SysTables sysTables,
			List<SysColumns> sysColumnsList) {
			GeneratorModel generatorModel = new GeneratorModel();
			generatorModel.setTableName(sysTables.getTableName());
			generatorModel.setMenuName(sysTables.getMenuName());
			generatorModel.setDomainObjectName(sysTables.getDomainObjectName());
			generatorModel.setVariableName(sysTables.getVariableName());
			generatorModel.setPath(sysTables.getPath());
			generatorModel.setPojoTargetPackage(sysTables.getPojoTargetPackage());
			generatorModel.setControllerTargetPackage(sysTables.getControllerTargetPackage());
			generatorModel.setServiceTargetPackage(sysTables.getServiceTargetPackage());
			generatorModel.setMapperTargetPackage(sysTables.getMapperTargetPackage());
			generatorModel.setKeycolumns(sysTables.getKeycolumns());
			generatorModel.setIsadd(sysTables.getIsadd());
			generatorModel.setIsupdate(sysTables.getIsupdate());
			generatorModel.setIsdelete(sysTables.getIsdelete());
			generatorModel.setGentype(sysTables.getGentype());
			generatorModel.setIdField(sysTables.getIdField());
			generatorModel.setParentField(sysTables.getParentField());
			generatorModel.setBusinessName(sysTables.getBusinessName());
			generatorModel.setTreeField(sysTables.getTreeField());
			Boolean useCombo = false;
			
			List<GeneratorProperty> propertys = new ArrayList<GeneratorProperty>();
			for (SysColumns sysColumns : sysColumnsList) {
				GeneratorProperty property = new GeneratorProperty();
				property.setColumnName(sysColumns.getColumnName());
				property.setPropertyName(sysColumns.getPropertyName());
				property.setPropertyType(sysColumns.getPropertyType());
				property.setPropertyTitle(sysColumns.getPropertyTitle());
				property.setPropertyLength(sysColumns.getPropertyLength());
				property.setIslike(sysColumns.getIslike());
				property.setIsprimary(sysColumns.getIsprimary());
				property.setIsselect(sysColumns.getIsselect());
				property.setNulls(sysColumns.getNulls());
				property.setIsadd(sysColumns.getIsadd());
				property.setIsupdate(sysColumns.getIsupdate());
				property.setIsdisplay(sysColumns.getIsdisplay());
				property.setWidth(sysColumns.getWidth());
				property.setSortable(sysColumns.getSortable());
				property.setFormatter(sysColumns.getFormatter());
				property.setDataOptions(sysColumns.getDataOptions());
				property.setComponent(sysColumns.getComponent());
				property.setComboid(sysColumns.getComboid());
				//TODO add cloumn
				propertys.add(property);
				
				if("easyui-combotree".equals(property.getComponent()) && StringUtils.isNotEmpty(property.getComboid())){
					useCombo = true;
				}
			}
			generatorModel.setPropertys(propertys);
			generatorModel.setUseCombo(useCombo);
			return generatorModel;
	}
}
