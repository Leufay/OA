package com.myjava.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * @author mr.lxf
 * @data 2017年3月18日 下午12:49:12
 * @param <T>
 */
@SuppressWarnings("serial")
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private Class<T> clazz ; 
	private T t ;
	
	public static final String TO_LOGIN = "toLogin" ;
	public static String toLogin = TO_LOGIN ;
	
	public static final String TO_INDEX = "toIndex" ;
	public static String toIndex = TO_INDEX ;
	
	public static final String INDEX = "index" ;
	public static String index = INDEX ;
	
	public static final String LEFT = "left" ;
	public static String left = LEFT ;
	
	public static final String RIGHT= "right" ;
	public static String right = RIGHT ;
	
	public static final String BOTTOM = "bottom" ;
	public static String bottom = BOTTOM ;
	
	public static final String TOP = "top" ;
	public static String top = TOP ;
	/**
	 * 跳转到列表页面
	 */
	public static final String LIST_ACTION = "list";
	public static String listAction = LIST_ACTION ;
	/**
	 * 跳转到增加页面
	 */
	public static final String ADD_UI = "addUI" ;
	public static String addUI = ADD_UI ;
	/**
	 * 跳转到更新页面
	 */
	public static final String UPDATE_UI = "updateUI" ;
	public static String updateUI =UPDATE_UI ;
	/**
	 * 重定向到列表页面
	 */
	public static final String TO_LIST = "toList" ;
	public static String toList = TO_LIST ;
	
	@SuppressWarnings("unchecked")
	public BaseAction(){
		//获取实际类型
		ParameterizedType type =  (ParameterizedType) this.getClass().getGenericSuperclass(); //这里的this代表子类
		this.clazz = (Class<T>) type.getActualTypeArguments()[0] ;
		try {
			//利用反射机制产生实例对象
			this.t = (T) this.clazz.newInstance() ;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	@Override
	public T getModel() {
		return t;
	}
}
