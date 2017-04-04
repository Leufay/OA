package com.myjava.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.myjava.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	@Resource
	//设置为protected是为了当前方法满足不了时提供HibernateTemplate给具体实现类实现
	protected HibernateTemplate hibernateTemplate ;
	private ClassMetadata classMetadata ;								//持久化对象类的数据字典
	/**
	 * 用来保存当前T的类型
	 * 为HQL语句服务
	 */
	private Class<T> clazz ;
	
	public BaseDaoImpl(){
		/**
		 * 1.this可以代表当前类或者子类
		 * 2.不能把BaseImpl在Spring容器实例化，因为在Spring中实例化就不会是泛型了
		 * 3.所以根据以上两点可以得出以下的this代表子类
		 * 4.this.getClass().getGenericSuperclass()代表就是当前类：泛型
		 * 5.不能让BaseDaoImpl让Spring容器实例化
		 */
		ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass() ;
		//获取实际T代表的类型
		this.clazz = (Class)type.getActualTypeArguments()[0] ;
	}
	/**
	 * 表示在执行构造器之后立即执行此方法
	 */
	@PostConstruct
	public void init(){
		this.classMetadata = this.hibernateTemplate.getSessionFactory().getClassMetadata(this.clazz) ;
	}
	/**
	 * 更新
	 */
	@Override
	public void update(Object entity) {
		hibernateTemplate.update(entity);
	}
	
	@Override
	public void insert(T entity) {
		hibernateTemplate.save(entity);
	}
	
	@Override
	public void delete(Serializable id) {
		//先查找出来要删除的对象
		T entity = this.get(id);
		hibernateTemplate.delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return hibernateTemplate.find("from "+clazz.getName());
	}
	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id) {
		//获取唯一标识符名称(主键)
		//String identityName = classMetadata.getIdentifierPropertyName();
		//return  (T) hibernateTemplate.find("from "+clazz.getName()+" where "+identityName+"=?",id).get(0);
		return (T) hibernateTemplate.get(clazz.getName(), id) ;
	}
	
	@Override
	public Set<T> findByIds(Serializable[] ids) {
		StringBuilder builder = new StringBuilder() ;
		builder.append("from ").append(this.clazz.getName()).append(" where ").append(classMetadata.getIdentifierPropertyName()).append(" in(");
		for(int i = 0 ;i<ids.length;i++){
			if(i==ids.length-1){				//如果是最后一个
				builder.append(ids[i]).append(")") ;
			}else{
				builder.append(ids[i]).append(",");
			}
		}
		return new HashSet<T>(hibernateTemplate.find(builder.toString()));
	}
}
