package com.myjava.entity;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable{
	private Long roleId ;				//角色ID
	private String roleName ;			//角色名称
	private String roleDescr ;			//角色说明
	private Set<User> users ;			//一个角色对应多个用户
	
	private Set<Privilege> privileges ;	//一个角色对应多个权限
	
	
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescr() {
		return roleDescr;
	}
	public void setRoleDescr(String roleDescr) {
		this.roleDescr = roleDescr;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
