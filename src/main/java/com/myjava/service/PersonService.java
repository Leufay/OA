package com.myjava.service;

import java.io.Serializable;
import java.util.Collection;

import com.myjava.entity.Person;

public interface PersonService {
	public void save(Person person) ;
	public void delete(Serializable id) ;
	public void update(Person person) ;
	public Collection<Person> find() ;
	public Person get(Serializable id) ;
}
