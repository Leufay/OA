package com.myjava.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myjava.dao.PrivilegeDao;
import com.myjava.entity.Privilege;
import com.myjava.service.PrivilegeService;
@Service
public class PrivilegeServiceImpl implements PrivilegeService{
	@Resource
	private PrivilegeDao privilegeDao ;
	@Override
	public Collection<Privilege> findAll() {
		return privilegeDao.findAll() ;
	}
	@Override
	public Collection<Privilege> findByIds(Long[] ids) {
		return privilegeDao.findByIds(ids);
	}

}
