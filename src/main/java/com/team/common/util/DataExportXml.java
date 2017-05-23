package com.team.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team.platform.pojo.AuthMenu;
import com.team.platform.pojo.AuthRole;
import com.team.platform.pojo.AuthRoleMenu;
import com.team.platform.pojo.AuthUser;
import com.team.platform.pojo.AuthUserRole;
import com.team.platform.pojo.SysComboBox;
import com.team.platform.pojo.SysDictEntry;
import com.team.platform.pojo.SysDictType;
import com.team.platform.service.AuthMenuService;
import com.team.platform.service.AuthRoleMenuService;
import com.team.platform.service.AuthRoleService;
import com.team.platform.service.AuthUserRoleService;
import com.team.platform.service.AuthUserService;
import com.team.platform.service.SysComboBoxService;
import com.team.platform.service.SysDictEntryService;
import com.team.platform.service.SysDictTypeService;

@Component
public class DataExportXml {

	@Autowired
	private AuthUserService authUserService;
	@Autowired
	private AuthRoleService authRoleService;
	@Autowired
	private AuthUserRoleService authUserRoleService;
	@Autowired
	private AuthRoleMenuService authRoleMenuService;
	@Autowired
	private AuthMenuService authMenuService;
	@Autowired
	private SysComboBoxService sysComboBoxService;
	@Autowired
	private SysDictEntryService sysDictEntryService;
	@Autowired
	private SysDictTypeService sysDictTypeService;
	
	public void export() throws FileNotFoundException, IOException{
		//取得根目录路径  
		String path = System.getProperty("user.dir");//user.dir指定了当前的路径

		System.out.println("正在生成 datas.xml 文件...");   
		List<AuthUser> users = authUserService.selectList();
		List<AuthRole> roles = authRoleService.selectList();
		List<AuthMenu> menus = authMenuService.selectList();
		List<AuthUserRole> userRoles = authUserRoleService.selectList();
		List<AuthRoleMenu> roleMenus = authRoleMenuService.selectList();
		List<SysComboBox> comboBoxs = sysComboBoxService.selectAll();
		List<SysDictEntry> dictEntrys = sysDictEntryService.selectList();
		List<SysDictType> dictTypes = sysDictTypeService.selectList();
		
		// 创建根节点 并设置它的属性 ;     
        Element root = new Element("datas");     
        // 将根节点添加到文档中；     
        Document Doc = new Document(root);     
        
        addUsers(root,users);
        addRoles(root,roles);
        addMenus(root,menus);
        addUserRoles(root,userRoles);
        addRoleMenus(root,roleMenus);
        addComboBox(root,comboBoxs);
        addDictEntrys(root,dictEntrys);
        addDictTypes(root,dictTypes);
        
        // 输出 books.xml 文件；    
        // 使xml文件 缩进效果  
        Format format = Format.getPrettyFormat();  
        XMLOutputter XMLOut = new XMLOutputter(format);  
        XMLOut.output(Doc, new FileOutputStream(path+"/src/main/resources/gencode/datas.xml")); 
        System.out.println("success ...");   
	}
	
	public void importXml() throws Exception{
		//取得根目录路径  
		String path = System.getProperty("user.dir");//user.dir指定了当前的路径
		File file = new File(path+"/src/main/resources/gencode/datas.xml"); 
	
		// 建立解析器  
        SAXBuilder builder = new SAXBuilder();  
        
        // 将解析器与文档关联  
        Document document = builder.build(file);  

        // 读取根元素  
        Element root = document.getRootElement();  

        // 读取元素集合  
        Element userEle =root.getChild("users");
        insertUser(userEle);
        
        // 读取元素集合  
        Element roleEle =root.getChild("roles");
        insertRole(roleEle);
        
        // 读取元素集合  
        Element userRoleEle =root.getChild("user_roles");
        insertUserRole(userRoleEle);
        
        // 读取元素集合  
        Element menuEle =root.getChild("menus");
        insertMenu(menuEle);
        
        // 读取元素集合  
        Element roleMenuEle =root.getChild("role_menus");
        insertRoleMenus(roleMenuEle);
        
        Element combobox =root.getChild("comboboxs");
        insertComboBox(root,combobox);
        
        Element dictEntry =root.getChild("dict_entrys");
        insertDictEntrys(root,dictEntry);
        
        Element dictType =root.getChild("dict_types");
        insertDictTypes(root,dictType);
        
	}

	private void addDictTypes(Element root, List<SysDictType> dictTypes) {
		Element ele = new Element("dict_types");  
        for (int i = 0; i < dictTypes.size(); i++) {    
           Element elements = new Element("dict_type");       
           elements.addContent(new Element("dicttypeid").setText(dictTypes.get(i).getDicttypeid()));    
           elements.addContent(new Element("dicttypename").setText(dictTypes.get(i).getDicttypename()));
           elements.addContent(new Element("parentid").setText(dictTypes.get(i).getParentid()));
           elements.addContent(new Element("rank").setText(dictTypes.get(i).getRank()));
           ele.addContent(elements);    
       }
       root.addContent(ele);
	}

	private void addDictEntrys(Element root, List<SysDictEntry> dictEntrys) {
		Element ele = new Element("dict_entrys");  
        for (int i = 0; i < dictEntrys.size(); i++) {    
           Element elements = new Element("dict_entry");       
           elements.addContent(new Element("dictid").setText(dictEntrys.get(i).getDictid()));    
           elements.addContent(new Element("dictname").setText(dictEntrys.get(i).getDictname()));
           elements.addContent(new Element("dicttypeid").setText(dictEntrys.get(i).getDicttypeid()));
           elements.addContent(new Element("parentid").setText(dictEntrys.get(i).getParentid()));
           elements.addContent(new Element("rank").setText(dictEntrys.get(i).getRank()));
           elements.addContent(new Element("status").setText(dictEntrys.get(i).getStatus()));
           elements.addContent(new Element("sortno").setText(String.valueOf(dictEntrys.get(i).getSortno())));
           ele.addContent(elements);    
       }
       root.addContent(ele);
	}

	private void addComboBox(Element root, List<SysComboBox> comboBoxs) {
		Element ele = new Element("comboboxs");  
        for (int i = 0; i < comboBoxs.size(); i++) {    
           Element elements = new Element("combobox");       
           elements.addContent(new Element("comboid").setText(comboBoxs.get(i).getComboid()));    
           elements.addContent(new Element("whereCondition").setText(comboBoxs.get(i).getWhereCondition()));
           elements.addContent(new Element("name").setText(comboBoxs.get(i).getName()));
           elements.addContent(new Element("parentField").setText(comboBoxs.get(i).getParentField()));
           elements.addContent(new Element("rootValue").setText(comboBoxs.get(i).getRootValue()));
           elements.addContent(new Element("tableName").setText(comboBoxs.get(i).getTableName()));
           elements.addContent(new Element("textField").setText(comboBoxs.get(i).getTextField()));
           elements.addContent(new Element("valueField").setText(comboBoxs.get(i).getValueField()));
           ele.addContent(elements);    
       }
       root.addContent(ele);
	}

	private void addMenus(Element root, List<AuthMenu> menus) {
		Element ele = new Element("menus");  
        for (int i = 0; i < menus.size(); i++) {    
           Element elements = new Element("role_menu");       
           elements.addContent(new Element("display").setText(menus.get(i).getDisplay()));    
           elements.addContent(new Element("href").setText(menus.get(i).getHref()));
           elements.addContent(new Element("iconCls").setText(menus.get(i).getIconCls()));
           elements.addContent(new Element("levelType").setText(menus.get(i).getLevelType()));
           elements.addContent(new Element("menuid").setText(menus.get(i).getMenuid()));
           elements.addContent(new Element("menuPos").setText(menus.get(i).getMenuPos()));
           elements.addContent(new Element("name").setText(menus.get(i).getName()));
           elements.addContent(new Element("orderNum").setText(menus.get(i).getOrderNum()));
           elements.addContent(new Element("pid").setText(menus.get(i).getPid()));
           ele.addContent(elements);    
       }
       root.addContent(ele);
	}

	private void addRoleMenus(Element root, List<AuthRoleMenu> roleMenus) {
		Element ele = new Element("role_menus");  
        for (int i = 0; i < roleMenus.size(); i++) {    
           Element elements = new Element("role_menu");       
           elements.addContent(new Element("roleid").setText(roleMenus.get(i).getRoleId()));    
           elements.addContent(new Element("menuid").setText(roleMenus.get(i).getMenuId()));
           elements.addContent(new Element("role_menu_id").setText(roleMenus.get(i).getRoleMenuId()));
           ele.addContent(elements);    
       }
       root.addContent(ele);
	}

	private void addUserRoles(Element root, List<AuthUserRole> userRoles) {
		Element ele = new Element("user_roles");  
        for (int i = 0; i < userRoles.size(); i++) {    
           Element elements = new Element("user_role");       
           elements.addContent(new Element("roleid").setText(userRoles.get(i).getRoleId()));    
           elements.addContent(new Element("userid").setText(userRoles.get(i).getUserId()));
           elements.addContent(new Element("user_role_id").setText(userRoles.get(i).getUserRoleId()));
           ele.addContent(elements);    
       }
        root.addContent(ele);
	}

	private void addRoles(Element root, List<AuthRole> roles) {
		Element ele = new Element("roles");  
        for (int i = 0; i < roles.size(); i++) {    
           Element elements = new Element("role");       
           elements.addContent(new Element("roleid").setText(roles.get(i).getRoleid()));    
           elements.addContent(new Element("name").setText(roles.get(i).getName()));
           elements.addContent(new Element("type").setText(roles.get(i).getType()));
           ele.addContent(elements);    
       }
        root.addContent(ele);
	}

	private void addUsers(Element root,List<AuthUser> users) {
		Element usersEle = new Element("users");  
        for (int i = 0; i < users.size(); i++) {    
           Element elements = new Element("user");       
           elements.addContent(new Element("userid").setText(users.get(i).getUserid()));    
           elements.addContent(new Element("username").setText(users.get(i).getUsername()));
           elements.addContent(new Element("operatorname").setText(users.get(i).getOperatorname()));
           elements.addContent(new Element("password").setText(users.get(i).getPassword()));
           elements.addContent(new Element("status").setText(users.get(i).getStatus()));
           elements.addContent(new Element("altertime").setText(DateFormatUtils.format(users.get(i).getAltertime(),"yyyy-MM-dd HH:mm:ss")));
           elements.addContent(new Element("createtime").setText(DateFormatUtils.format(users.get(i).getCreatetime(),"yyyy-MM-dd HH:mm:ss")));
           usersEle.addContent(elements);    
       }
        root.addContent(usersEle);
	}
	
	private void insertUser(Element userEle) throws Exception {
		// 读取元素的属性集合   
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Element> children = userEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	AuthUser user = new AuthUser();
        	Element child = (Element) children.get(i);
        	Element userid =child.getChild("userid");
        	user.setUserid(userid.getText());
        	Element username =child.getChild("username");
        	user.setUsername(username.getText());
        	Element operatorname =child.getChild("operatorname");
        	user.setOperatorname(operatorname.getText());
        	Element password =child.getChild("password");
        	user.setPassword(password.getText());
        	Element status =child.getChild("status");
        	user.setStatus(status.getText());
        	Element altertime =child.getChild("altertime");
        	user.setAltertime(sdf.parse(altertime.getText()));
        	Element createtime =child.getChild("createtime");
        	user.setCreatetime(sdf.parse(createtime.getText()));
        	AuthUser temp = authUserService.selectByPrimaryKey(user.getUserid());
        	if(temp == null){
        		authUserService.insertUser(user);
        	}
        }
	}
	

	private void insertRole(Element roleEle) {
		// 读取元素的属性集合  
        List<Element> children = roleEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	AuthRole authRole = new AuthRole();
        	Element child = (Element) children.get(i);
        	Element roleid =child.getChild("roleid");
        	authRole.setRoleid(roleid.getText());
        	Element name =child.getChild("name");
        	authRole.setName(name.getText());
        	Element type =child.getChild("type");
        	authRole.setType(type.getText());
        	
        	AuthRole temp = authRoleService.selectByPrimaryKey(authRole.getRoleid());
        	if(temp == null){
        		authRoleService.insertRole(authRole);
        	}
        }
	}

	private void insertUserRole(Element userRoleEle) {
          
		// 读取元素的属性集合  
        List<Element> children = userRoleEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	AuthUserRole userRole = new AuthUserRole();
        	Element child = (Element) children.get(i);
        	Element roleid =child.getChild("roleid");
        	userRole.setRoleId(roleid.getText());
        	Element userid =child.getChild("userid");
        	userRole.setUserId(userid.getText());
        	Element userRoleId =child.getChild("user_role_id");
        	userRole.setUserRoleId(userRoleId.getText());
        	
        	AuthUserRole temp = authUserRoleService.selectByPrimaryKey(userRole.getUserRoleId());
        	if(temp == null){
        		authUserRoleService.insertUserRole(userRole);
        	}
        }
	}
	
	private void insertMenu(Element menuEle) {
		List<Element> children = menuEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	AuthMenu authMenu = new AuthMenu();
        	Element child = (Element) children.get(i);
        	
        	Element display =child.getChild("display");
        	authMenu.setDisplay(display.getText());
        	
        	Element href =child.getChild("href");
        	authMenu.setHref(href.getText());
        	
        	Element iconCls =child.getChild("iconCls");
        	authMenu.setIconCls(iconCls.getText());
        	
        	Element levelType =child.getChild("levelType");
        	authMenu.setLevelType(levelType.getText());
        	
        	Element menuid =child.getChild("menuid");
        	authMenu.setMenuid(menuid.getText());
        	
        	Element menuPos =child.getChild("menuPos");
        	authMenu.setMenuPos(menuPos.getText());
        	
        	Element name =child.getChild("name");
        	authMenu.setName(name.getText());
        	
        	Element orderNum =child.getChild("orderNum");
        	authMenu.setOrderNum(orderNum.getText());
        	
        	Element pid =child.getChild("pid");
        	authMenu.setPid(pid.getText());
        	
        	AuthMenu temp = authMenuService.selectByPrimaryKey(authMenu.getMenuid());
        	if(temp == null){
        		authMenuService.insertMenu(authMenu);
        	}
        }
	}
	
	private void insertRoleMenus(Element roleMenuEle) {
		// 读取元素的属性集合  
        List<Element> children = roleMenuEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	AuthRoleMenu roleMenu = new AuthRoleMenu();
        	Element child = (Element) children.get(i);
        	Element roleid =child.getChild("roleid");
        	roleMenu.setRoleId(roleid.getText());
        	Element menuid =child.getChild("menuid");
        	roleMenu.setMenuId(menuid.getText());
        	Element roleMenuId =child.getChild("role_menu_id");
        	roleMenu.setRoleMenuId(roleMenuId.getText());
        	
        	AuthRoleMenu temp = authRoleMenuService.selectByPrimaryKey(roleMenu.getRoleMenuId());
        	if(temp == null){
        		authRoleMenuService.insertRoleMenu(roleMenu);
        	}
        }
	}
	
	private void insertDictTypes(Element root, Element dictTypeEle) {
		// 读取元素的属性集合  
        List<Element> children = dictTypeEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	SysDictType sysDictType = new SysDictType();
        	Element child = (Element) children.get(i);
        	Element dicttypeid =child.getChild("dicttypeid");
        	sysDictType.setDicttypeid(dicttypeid.getText());
        	Element dicttypename =child.getChild("dicttypename");
        	sysDictType.setDicttypename(dicttypename.getText());
        	Element parentid =child.getChild("parentid");
        	sysDictType.setParentid(parentid.getText());
        	Element rank =child.getChild("rank");
        	sysDictType.setRank(rank.getText());
        	
        	SysDictType temp = sysDictTypeService.selectByPrimaryKey(sysDictType.getDicttypeid());
        	if(temp == null){
        		sysDictTypeService.insertSysDictType(sysDictType);
        	}
        }
	}

	private void insertDictEntrys(Element root, Element dictEntryEle) {
		// 读取元素的属性集合  
        List<Element> children = dictEntryEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	SysDictEntry sysDictEntry = new SysDictEntry();
        	Element child = (Element) children.get(i);
        	Element dictid =child.getChild("dictid");
        	sysDictEntry.setDictid(dictid.getText());
        	Element dictname =child.getChild("dictname");
        	sysDictEntry.setDictname(dictname.getText());
        	Element dicttypeid =child.getChild("dicttypeid");
        	sysDictEntry.setDicttypeid(dicttypeid.getText());
        	Element parentid =child.getChild("parentid");
        	sysDictEntry.setParentid(parentid.getText());
        	Element rank =child.getChild("rank");
        	sysDictEntry.setRank(rank.getText());
        	Element status =child.getChild("status");
        	sysDictEntry.setStatus(status.getText());
        	Element sortno =child.getChild("sortno");
        	sysDictEntry.setSortno(Integer.valueOf(sortno.getText()));
        	
        	SysDictEntry temp = sysDictEntryService.selectByPrimaryKey(sysDictEntry.getDicttypeid(),sysDictEntry.getDictid());
        	if(temp == null){
        		sysDictEntryService.insertSysDictEntry(sysDictEntry);
        	}
        }
	}

	private void insertComboBox(Element root, Element comboboxEle) {
		List<Element> children = comboboxEle.getChildren();
        for (int i = 0; i <children.size(); i++) {
        	SysComboBox sysComboBox = new SysComboBox();
        	Element child = (Element) children.get(i);
        	Element comboid =child.getChild("comboid");
        	sysComboBox.setComboid(comboid.getText());
        	Element whereCondition =child.getChild("whereCondition");
        	sysComboBox.setWhereCondition(whereCondition.getText());
        	Element name =child.getChild("name");
        	sysComboBox.setName(name.getText());
        	Element parentField =child.getChild("parentField");
        	sysComboBox.setParentField(parentField.getText());
        	Element rootValue =child.getChild("rootValue");
        	sysComboBox.setRootValue(rootValue.getText());
        	Element tableName =child.getChild("tableName");
        	sysComboBox.setTableName(tableName.getText());
        	Element textField =child.getChild("textField");
        	sysComboBox.setTextField(textField.getText());
        	Element valueField =child.getChild("valueField");
        	sysComboBox.setValueField(valueField.getText());
        	
        	SysComboBox temp = sysComboBoxService.selectByPrimaryKey(sysComboBox.getComboid());
        	if(temp == null){
        		try {
					sysComboBoxService.insertSysComboBox(sysComboBox);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
	}
}
