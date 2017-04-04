package com.myjava.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.myjava.entity.Privilege;
import com.myjava.entity.Role;
import com.myjava.service.PrivilegeService;
import com.myjava.service.RoleService;

@Controller
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege>{
	@Resource
	private PrivilegeService privilegeService ;
	@Resource
	private RoleService roleService ;
	private List<Privilege> oList = new ArrayList<>() ;
	private Long[] pIds ;
	private Long roleId ;
	public String findAll(){
		oList  = (List<Privilege>) privilegeService.findAll() ;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SUCCESS ;
	}
	public String findExistPrivilege(){
		Role role = roleService.get(roleId) ;
		Set<Privilege> privils = role.getPrivileges() ;
		List<Privilege> pList = new ArrayList<>(privils) ;
		pIds = new Long[privils.size()] ;
		for(int i=0;i<privils.size();i++){
			pIds[i] = pList.get(i).getId() ;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return SUCCESS ;
	}
	public List<Privilege> getoList() {
		return oList;
	}
	public void setoList(List<Privilege> oList) {
		this.oList = oList;
	}
	public Long[] getpIds() {
		return pIds;
	}
	public void setpIds(Long[] pIds) {
		this.pIds = pIds;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}
