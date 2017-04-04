package com.myjava.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.myjava.entity.Person;
import com.myjava.service.PersonService;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PersonAction extends BaseAction<Person>{
	@Resource
	private PersonService personService ;
	public String add(){
		Person p = getModel() ;
		p.setName("李");
		personService.save(p);
		return null;
	}
}
