package com.myjava.dao;

import com.myjava.entity.User;

public interface UserDao extends BaseDao<User>{
	public User getByUsername(String username) ;
}
