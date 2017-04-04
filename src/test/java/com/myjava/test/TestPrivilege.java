package com.myjava.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myjava.entity.Privilege;

public class TestPrivilege {
	
	@Test
	public void install(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) ac
				.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction(); // 开启事务
		this.installMenu(session);
		this.installFunc(session);
		// =========================================功能项（按钮级别）=============================================
		trans.commit();
		session.close();

	}
	/**
	 * 功能项
	 */
	public void installFunc(Session session){
		//部门增加
		Privilege m411= new Privilege() ;
		m411.setId(411L);
		m411.setIsParent(false);
		m411.setFlag("2");
		m411.setIcon(null);
		m411.setName("部门增加");
		m411.setPid(41L);
		//部门删除
		Privilege m412= new Privilege() ;
		m412.setId(412L);
		m412.setIsParent(false);
		m412.setFlag("2");
		m412.setIcon(null);
		m412.setName("部门删除");
		m412.setPid(41L);
		//部门修改
		Privilege m413= new Privilege() ;
		m413.setId(413L);
		m413.setIsParent(false);
		m413.setFlag("2");
		m413.setIcon(null);
		m413.setName("部门修改");
		m413.setPid(41L);
		//用户增加
		Privilege m421= new Privilege() ;
		m421.setId(421L);
		m421.setIsParent(false);
		m421.setFlag("2");
		m421.setIcon(null);
		m421.setName("用户增加");
		m421.setPid(42L);
		//用户删除
		Privilege m422= new Privilege() ;
		m422.setId(422L);
		m422.setIsParent(false);
		m422.setFlag("2");
		m422.setIcon(null);
		m422.setName("用户删除");
		m422.setPid(42L);
		//用户修改
		Privilege m423= new Privilege() ;
		m423.setId(423L);
		m423.setIsParent(false);
		m423.setFlag("2");
		m423.setIcon(null);
		m423.setName("用户修改");
		m423.setPid(42L);
		//角色增加
		Privilege m431= new Privilege() ;
		m431.setId(431L);
		m431.setIsParent(false);
		m431.setFlag("2");
		m431.setIcon(null);
		m431.setName("角色增加");
		m431.setPid(43L);
		// 角色删除
		Privilege m432 = new Privilege();
		m432.setId(432L);
		m432.setIsParent(false);
		m432.setFlag("2");
		m432.setIcon(null);
		m432.setName("角色删除");
		m432.setPid(43L);
		// 角色删除
		Privilege m433 = new Privilege();
		m433.setId(433L);
		m433.setIsParent(false);
		m433.setFlag("2");
		m433.setIcon(null);
		m433.setName("角色修改");
		m433.setPid(43L);
		// 角色删除
		Privilege m434 = new Privilege();
		m434.setId(434L);
		m434.setIsParent(false);
		m434.setFlag("2");
		m434.setIcon(null);
		m434.setName("设置权限");
		m434.setPid(43L);
		
		session.save(m411) ;
		session.save(m412) ;
		session.save(m413) ;
		session.save(m421) ;
		session.save(m422) ;
		session.save(m423) ;
		session.save(m431) ;
		session.save(m432) ;
		session.save(m433) ;
		session.save(m434) ;
		
	}
	/**
	 * 菜单项
	 * @param session
	 */
	public void installMenu(Session session){
		//=====================================左侧菜单项================================================
		Privilege m0 = new Privilege() ;
		m0.setId(0L);
		m0.setName("自动化办公");
		m0.setFlag("1");
		//-------------------------------------个人办公--------------------------------
		Privilege m1 = new Privilege() ;
		m1.setId(1L);
		m1.setIcon("style/images/MenuIcon/FUNC241000.gif");
		m1.setName("个人办公");
		m1.setFlag("1");
		m1.setIsParent(true);
		m1.setPid(0L);
		
		Privilege m11 = new Privilege() ;
		m11.setId(11L);
		m11.setPid(1L);
		m11.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m11.setIsParent(false);
		m11.setFlag("1");
		m11.setName("日程安排");
		
		Privilege m12 = new Privilege() ;
		m12.setId(12L);
		m12.setPid(1L);
		m12.setFlag("1");
		m12.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m12.setIsParent(false);
		m12.setName("工作计划");
		
		Privilege m13 = new Privilege() ;
		m13.setId(13L);
		m13.setPid(1L);
		m13.setFlag("1");
		m13.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m13.setIsParent(false);
		m13.setName("工作日记");
		
		//-----------------------------------------审批流转--------------------------------
		
		Privilege m2  = new Privilege() ;
		m2.setId(2L);
		m2.setPid(0L);
		m2.setFlag("1");
		m2.setIcon("style/images/MenuIcon/FUNC20057.gif");
		m2.setName("审批流转");
		m2.setIsParent(true);
		
		Privilege m21 = new Privilege() ;
		m21.setId(21L);
		m21.setPid(2L);
		m21.setFlag("1");
		m21.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m21.setIsParent(false);
		m21.setName("审批流转管理");
		
		Privilege m22= new Privilege() ;
		m22.setId(22L);
		m22.setPid(2L);
		m22.setFlag("1");
		m22.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m22.setIsParent(false);
		m22.setName("表单模板管理");
		
		Privilege m23 = new Privilege() ;
		m23.setId(23L);
		m23.setPid(2L);
		m23.setFlag("1");
		m23.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m23.setIsParent(false);
		m23.setName("待我审批");
		
		Privilege m24 = new Privilege() ;
		m24.setId(24L);
		m24.setPid(2L);
		m24.setFlag("1");
		m24.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m24.setIsParent(false);
		m24.setName("我的申请查询");
		
		//----------------------------------------网上交流---------------------------
		
		Privilege m3 = new Privilege() ;
		m3.setId(3L);
		m3.setIsParent(true);
		m3.setFlag("1");
		m3.setIcon("style/images/MenuIcon/FUNC20064.gif");
		m3.setName("网上交流");
		m3.setPid(0L);
		
		Privilege m31 = new Privilege() ;
		m31.setIsParent(false);
		m31.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m31.setId(31L);
		m31.setFlag("1");
		m31.setName("论坛");
		m31.setPid(3L);
		
		Privilege m32 = new Privilege() ;
		m32.setIsParent(false);
		m32.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m32.setId(32L);
		m32.setFlag("1");
		m32.setName("论坛管理");
		m32.setPid(3L);
		
		
		//----------------------------------------系统管理-------------------------------
		
		Privilege m4 = new Privilege() ;
		m4.setId(4L);
		m4.setIsParent(true);
		m4.setFlag("1");
		m4.setIcon("style/images/MenuIcon/FUNC20082.gif");
		m4.setName("系统管理");
		m4.setPid(0L);
	
		Privilege m41 = new Privilege() ;
		m41.setIsParent(false);
		m41.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m41.setId(41L);
		m41.setFlag("1");
		m41.setName("部门管理");
		m41.setPid(4L);
		
		Privilege m42 = new Privilege() ;
		m42.setIsParent(false);
		m42.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m42.setId(42L);
		m42.setFlag("1");
		m42.setName("用户管理");
		m42.setPid(4L);
		
		Privilege m43 = new Privilege() ;
		m43.setIsParent(false);
		m43.setIcon("style/images/MenuIcon/menu_arrow_single.gif");
		m43.setId(43L);
		m43.setFlag("1");
		m43.setName("角色管理");
		m43.setPid(4L);
		
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
	}
	
}
