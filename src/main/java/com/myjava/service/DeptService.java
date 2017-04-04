package com.myjava.service;

import java.io.Serializable;
import java.util.Collection;

import com.myjava.entity.Dept;

public interface DeptService {
	public Collection<Dept> findAll() ;
	public Dept get(Serializable id) ;
	public void save(Dept dept);
	public void deleteById(Serializable id) ;
	public void update(Dept dept) ;
}
