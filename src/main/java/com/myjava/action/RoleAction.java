package com.myjava.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.myjava.entity.Role;
import com.myjava.service.RoleService;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	@Resource
	private RoleService roleService ;
	private String privilIds ;					//权限ID的字符串
	private Long roleId ;						//角色ID
	public String list(){
		List<Role> oList = (List<Role>) roleService.findAll() ;
		ActionContext.getContext().put("oList", oList);
		return listAction ;
	}
	public String toAdd(){
		return addUI ;
	}
	public String add(){
		Role role = new Role() ;
		BeanUtils.copyProperties(getModel(), role);
		roleService.save(role);
		return toList ;
	}
	public String delete(){
		roleService.deleteById(getModel().getRoleId());
		return toList ;
	}
	public String toUpdate(){
		Role role = roleService.get(getModel().getRoleId()) ;
		ActionContext.getContext().getValueStack().push(role) ;
		return updateUI ;
	}
	public String update(){
		Role role = new Role() ;
		BeanUtils.copyProperties(getModel(), role);
		roleService.update(role);
		return toList ;
	}
	/**
	 * 设置权限
	 * @return
	 */
	public String setPrivilege(){
		roleService.setPrivilege(getModel().getRoleId(),privilIds) ;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SUCCESS ;
	}
	public String getPrivilIds() {
		return privilIds;
	}
	public void setPrivilIds(String privilIds) {
		this.privilIds = privilIds;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
