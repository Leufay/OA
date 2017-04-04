package com.myjava.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myjava.dao.UserDao;
import com.myjava.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	/**
	 * 登陆时根据用户名查找用户
	 */
	@Override
	public User getByUsername(String username) {
		List<User> user = hibernateTemplate.find("from User u where u.username='"+username+"'") ;
		if(user.size()==0){
			return null ;
		}
		return  user.get(0) ;
	}

}
