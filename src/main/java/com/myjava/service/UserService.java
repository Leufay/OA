package com.myjava.service;

import java.io.Serializable;
import java.util.Collection;

import com.myjava.entity.User;

public interface UserService {
	public Collection<User> findAll() ;
	public User get(Serializable id) ;
	public void save(User user,Serializable deptId ,Serializable[] roleIds);
	public void deleteById(Serializable id) ;
	public void update(User user,Serializable deptId ,Serializable[] roleIds) ;
	public User getByUsername(String username) ;
}
