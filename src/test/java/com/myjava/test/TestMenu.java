package com.myjava.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myjava.entity.MenuItem;

public class TestMenu {
	@Test
	public void createSession(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sessionFactory.openSession() ;
		Transaction trans = session.beginTransaction() ;				//开启事务
		MenuItem m0 = new MenuItem() ;
		m0.setMenuId(0L);
		m0.setName("自动化办公");
		//-------------------------------------个人办公--------------------------------
		MenuItem m1 = new MenuItem() ;
		m1.setMenuId(1L);
		m1.setIcon("../style/images/MenuIcon/FUNC241000.gif");
		m1.setName("个人办公");
		m1.setIsParent(true);
		m1.setParentId(0L);
		
		MenuItem m11 = new MenuItem() ;
		m11.setMenuId(11L);
		m11.setParentId(1L);
		m11.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m11.setIsParent(false);
		m11.setName("日程安排");
		
		MenuItem m12 = new MenuItem() ;
		m12.setMenuId(12L);
		m12.setParentId(1L);
		m12.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m12.setIsParent(false);
		m12.setName("工作计划");
		
		MenuItem m13 = new MenuItem() ;
		m13.setMenuId(13L);
		m13.setParentId(1L);
		m13.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m13.setIsParent(false);
		m13.setName("工作日记");
		
		//-----------------------------------------审批流转--------------------------------
		
		MenuItem m2  = new MenuItem() ;
		m2.setMenuId(2L);
		m2.setParentId(0L);
		m2.setIcon("../style/images/MenuIcon/FUNC20057.gif");
		m2.setName("审批流转");
		m2.setIsParent(true);
		
		MenuItem m21 = new MenuItem() ;
		m21.setMenuId(21L);
		m21.setParentId(2L);
		m21.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m21.setIsParent(false);
		m21.setName("审批流转管理");
		m21.setTarget("right");
		
		MenuItem m22= new MenuItem() ;
		m22.setMenuId(22L);
		m22.setParentId(2L);
		m22.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m22.setIsParent(false);
		m22.setTarget("right");
		m22.setName("表单模板管理");
		
		MenuItem m23 = new MenuItem() ;
		m23.setMenuId(23L);
		m23.setParentId(2L);
		m23.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m23.setIsParent(false);
		m23.setName("待我审批");
		m23.setTarget("right");
		
		MenuItem m24 = new MenuItem() ;
		m24.setMenuId(24L);
		m24.setParentId(2L);
		m24.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m24.setIsParent(false);
		m24.setName("我的申请查询");
		m24.setTarget("right");
		
		//----------------------------------------网上交流---------------------------
		
		MenuItem m3 = new MenuItem() ;
		m3.setMenuId(3L);
		m3.setIsParent(true);
		m3.setIcon("../style/images/MenuIcon/FUNC20064.gif");
		m3.setName("网上交流");
		m3.setParentId(0L);
		
		MenuItem m31 = new MenuItem() ;
		m31.setIsParent(false);
		m31.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m31.setMenuId(31L);
		m31.setName("论坛");
		m31.setTarget("right");
		m31.setParentId(3L);
		
		MenuItem m32 = new MenuItem() ;
		m32.setIsParent(false);
		m32.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m32.setMenuId(32L);
		m32.setName("论坛管理");
		m32.setTarget("right");
		m32.setParentId(3L);
		
		
		//----------------------------------------系统管理-------------------------------
		
		MenuItem m4 = new MenuItem() ;
		m4.setMenuId(4L);
		m4.setIsParent(true);
		m4.setIcon("../style/images/MenuIcon/FUNC20082.gif");
		m4.setName("系统管理");
		m4.setParentId(0L);
	
		MenuItem m41 = new MenuItem() ;
		m41.setIsParent(false);
		m41.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m41.setMenuId(41L);
		m41.setName("部门管理");
		m41.setTarget("right");
		m41.setParentId(4L);
		
		MenuItem m42 = new MenuItem() ;
		m42.setIsParent(false);
		m42.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m42.setMenuId(42L);
		m42.setName("用户管理");
		m42.setTarget("right");
		m42.setParentId(4L);
		
		MenuItem m43 = new MenuItem() ;
		m43.setIsParent(false);
		m43.setIcon("../style/images/MenuIcon/menu_arrow_single.gif");
		m43.setMenuId(43L);
		m43.setName("角色管理");
		m43.setTarget("right");
		m43.setUrl("../role/roleAction_list.action");
		m43.setParentId(4L);
		
		session.save(m0);
		session.save(m1);
		session.save(m11);
		session.save(m12);
		session.save(m13);
		
		
		session.save(m2);
		session.save(m21);
		session.save(m22);
		session.save(m23);
		session.save(m24);
		
		session.save(m3);
		session.save(m31);
		session.save(m32);
		
		session.save(m4);
		session.save(m41);
		session.save(m42);
		session.save(m43);
		
		trans.commit(); 
		session.close();
	}
}
