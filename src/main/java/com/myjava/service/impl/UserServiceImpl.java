package com.myjava.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myjava.dao.DeptDao;
import com.myjava.dao.RoleDao;
import com.myjava.dao.UserDao;
import com.myjava.entity.Dept;
import com.myjava.entity.Role;
import com.myjava.entity.User;
import com.myjava.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao ;
	@Resource
	private DeptDao deptDao ;
	@Resource
	private RoleDao roleDao ;
	public Collection<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User get(Serializable id) {
		return userDao.get(id);
	}

	@Override
	public void save(User user,Serializable deptId ,Serializable[] roleIds) {
		if(deptId!=null){
			Dept dept = deptDao.get(deptId) ;
			user.setDept(dept);								//设置用户和部门之间的关系
		}
		Set<Role> roles = roleDao.findByIds(roleIds) ;
		user.setRoles(roles);								//设置用户和角色之间的关系
		userDao.insert(user);
	}

	@Override
	public void deleteById(Serializable id) {
		userDao.delete(id);
	}

	@Override
	public void update(User user,Serializable deptId , Serializable[] roleIds) {
		if(deptId==null){
			user.setDept(null);
		}else{
			user.setDept(deptDao.get(deptId));
		}
		user.setRoles(roleDao.findByIds(roleIds));
		userDao.update(user);
	}

	@Override
	public User getByUsername(String username) {
		return userDao.getByUsername(username) ;
	}

}
