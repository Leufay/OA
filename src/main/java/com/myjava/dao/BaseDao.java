package com.myjava.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface BaseDao<T> {
	public void insert(T entity);				//增加
	public void delete(Serializable id);		//删除
	public List<T> findAll();					//查询所有
	public T get(Serializable id);				//查找指定
	public void update(T entity);				//更新
	public Set<T> findByIds(Serializable[] ids) ;		
}
