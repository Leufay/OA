package com.myjava.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myjava.dao.DeptDao;
import com.myjava.entity.Dept;
import com.myjava.entity.User;
import com.myjava.service.DeptService;
@Service(value="deptService")
public class DeptServiceImpl implements DeptService{
	@Resource
	private DeptDao deptDao ;
	@Override
	public Collection<Dept> findAll() {
		return deptDao.findAll();
	}

	@Override
	public Dept get(Serializable id) {
		return deptDao.get(id);
	}

	@Override
	public void save(Dept dept) {
		deptDao.insert(dept);
		
	}

	@Override
	public void deleteById(Serializable id) {
		//由于Hibernate对外键的维护
		Dept dept = deptDao.get(id);
		Set<User> users = dept.getUsers();
		for(User user :users){
			user.setDept(null);							//设置用户的部门为NULL
		}
		deptDao.delete(id);
	}

	@Override
	public void update(Dept dept) {
		deptDao.update(dept);
	}

}
