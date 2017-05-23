package com.team.common.pojo;

import java.util.List;

/**
 * easyUI树形控件节点格式
 * <p>Title: EUTreeNode</p>
 * <p>Description: </p>
 * @author	刘超
 * @date	2017年02月15日上午9:13:14
 * @version 1.0
 */
public class EUTreeNode {

	private String id;
	private String text;
	private String state;
	private String iconCls;
	private Boolean checked;
	private List<EUTreeNode> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<EUTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<EUTreeNode> children) {
		this.children = children;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
}