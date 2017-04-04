package com.myjava.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myjava.dao.MenuItemDao;
import com.myjava.entity.MenuItem;
import com.myjava.service.MenuItemService;
@Service
public class MenuItemServiceImpl implements MenuItemService{
	@Resource
	private MenuItemDao menuItemDao ;
	@Override
	public Collection<MenuItem> findAll() {
		return menuItemDao.findAll();
	}

}
