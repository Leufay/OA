package com.myjava.service;

import java.io.Serializable;
import java.util.Collection;

import com.myjava.entity.Role;

public interface RoleService {
	public Collection<Role> findAll() ;
	public Role get(Serializable id) ;
	public void save(Role role);
	public void deleteById(Serializable id) ;
	public void update(Role role) ;
	public void setPrivilege(Long roleId,String privilIds) ;
}
