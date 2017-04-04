package com.myjava.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSession {
	@Test
	public void createSession(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory") ;
		System.out.println(sf);
	}
}
