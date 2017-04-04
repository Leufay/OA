package com.myjava.service;

import java.util.Collection;

import com.myjava.entity.Privilege;

public interface PrivilegeService {
	public Collection<Privilege> findAll() ;
	public Collection<Privilege> findByIds(Long[] ids) ;
}
