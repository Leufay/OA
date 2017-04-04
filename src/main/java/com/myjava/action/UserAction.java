package com.myjava.action;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.myjava.entity.Dept;
import com.myjava.entity.Role;
import com.myjava.entity.User;
import com.myjava.service.DeptService;
import com.myjava.service.RoleService;
import com.myjava.service.UserService;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Resource
	private UserService userService ;
	@Resource
	private DeptService deptService ;
	@Resource
	private RoleService roleService ;
	
	private Long deptId ;				//属性驱动封装页面部门Id
	private Long[] roleIds ;			//属性驱动封装角色Ids
	
	
	public Serializable getDeptId() {
		return deptId;
	}
	
	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String list(){
		List<User> oList = (List<User>) userService.findAll() ;
		ActionContext.getContext().put("oList", oList);
		return listAction ;
	}
	public String toAdd(){
		List<Dept> oList = (List<Dept>) deptService.findAll() ;
		List<Role> roleList = (List<Role>) roleService.findAll() ;
		ActionContext.getContext().put("oList", oList);
		ActionContext.getContext().put("roleList", roleList);
		return addUI ;
	}
	public String add(){
		User user = new User() ;
		BeanUtils.copyProperties(getModel(), user);
		userService.save(user,deptId ,roleIds);
		return toList ;
	}
	public String toUpdate(){
		User user = userService.get(this.getModel().getUserId()) ;
		
		List<Dept> oList = (List<Dept>) deptService.findAll() ;
		List<Role> roleList = (List<Role>) roleService.findAll() ;
		ActionContext.getContext().put("oList", oList);
		ActionContext.getContext().put("roleList", roleList);
		
		ActionContext.getContext().getValueStack().push(user);				//user对象放到栈顶用于数据回显
		if(user.getDept()!=null){
			this.deptId = user.getDept().getDeptId() ;
		}
		if(user.getRoles()!=null){
			this.roleIds = new Long[user.getRoles().size()] ;					//后台往页面传数据需要自己初始化数组(或集合)
			int index = 0;
			for(Role role:user.getRoles()){
				roleIds[index] = role.getRoleId() ;
				index++ ;
			}
		}
		return updateUI ;
	}
	public String update(){
		User user = new User() ;
		BeanUtils.copyProperties(getModel(), user);
		userService.update(user,deptId ,roleIds);
		return toList ;
	}
	public String delete(){
		userService.deleteById(this.getModel().getUserId());
		return toList ;
	}
}
