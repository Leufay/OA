package com.myjava.entity;

import java.io.Serializable;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * 权限
 * @author mr.lxf
 * @data 2017年3月21日 下午3:08:45
 */
public class Privilege implements Serializable{
	private Long id ;			//主键
	private Long pid ;    		//父节点
	private String name ;		//节点的名称
	private String flag ; 		//"1"为菜单，2为 功能
	private String icon ;		//图标
	private Boolean isParent ;
	private Set<Role> roles ;
	@JSON(serialize=false)
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
}
