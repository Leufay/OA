package com.myjava.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myjava.dao.PersonDao;
import com.myjava.entity.Person;
import com.myjava.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService{
	@Resource
	private PersonDao personDao ;

	@Override
	public void save(Person person) {
		personDao.insert(person);
	}

	@Override
	public void delete(Serializable id) {
		personDao.delete(id);
	}

	@Override
	public void update(Person person) {
		personDao.update(person);
	}

	@Override
	public Collection<Person> find() {
		return personDao.findAll();
	}

	@Override
	public Person get(Serializable id) {
		return personDao.get(id);
	}

}
