package com.myjava.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myjava.dao.RoleDao;
import com.myjava.dao.UserDao;
import com.myjava.entity.Privilege;
import com.myjava.entity.Role;
import com.myjava.entity.User;
import com.myjava.service.PrivilegeService;
import com.myjava.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleDao roleDao ;
	@Resource
	private UserDao userDao ;
	@Resource
	private PrivilegeService privilegeService ;
	@Override
	public Collection<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public Role get(Serializable id) {
		return roleDao.get(id);
	}

	@Override
	public void save(Role role) {
		roleDao.insert(role);
	}

	@Override
	public void deleteById(Serializable id) {
		Role role = roleDao.get(id) ;
		Set<User> users = role.getUsers() ;
		for(User u : users){
			u.getRoles().remove(role);
		}
		roleDao.delete(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
		
	}

	@Override
	public void setPrivilege(Long roleId, String privilIds) {
		String[] ids = privilIds.split(",") ;
		Long[] pIds = new Long[ids.length] ;
		for(int i =0;i<ids.length;i++){
			pIds[i] = Long.parseLong(ids[i]) ;
		}
		Role role = roleDao.get(roleId) ;
		Set<Privilege> privileges = (Set<Privilege>) privilegeService.findByIds(pIds) ;
		role.setPrivileges(privileges);
		roleDao.update(role);
	}

}
