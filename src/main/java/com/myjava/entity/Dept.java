package com.myjava.entity;

import java.io.Serializable;
import java.util.Set;

public class Dept implements Serializable{
	private Long deptId ;				//部门ID
	private String deptName ;			//部门名称
	private String deptDescr ;			//部门说明
	private Dept parent ;				//上级部门
	private Set<User> users ;			//一个部门有多个用户
	private Set<Dept> childrens ;		//下级部门
	
	public Dept getParent() {
		return parent;
	}
	public void setParent(Dept parent) {
		this.parent = parent;
	}
	public Set<Dept> getChildrens() {
		return childrens;
	}
	public void setChildrens(Set<Dept> childrens) {
		this.childrens = childrens;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptDescr() {
		return deptDescr;
	}
	public void setDeptDescr(String deptDescr) {
		this.deptDescr = deptDescr;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
