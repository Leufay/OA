package com.myjava.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.myjava.entity.User;
import com.myjava.service.UserService;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
/**
 * 登陆模块
 * @author mr.lxf
 * @data 2017年3月18日 下午11:52:01
 */
public class LoginAction extends BaseAction<User>{
	@Resource
	private UserService userService ;
	public String toLogin(){
		return toLogin ;
	}
	public String login(){
		User user = userService.getByUsername(getModel().getUsername()) ;
		if(user==null || !user.getPassword().equals(getModel().getPassword()) ){				//如果没有找到则跳转登陆页面
			getModel().setMsg("用户名或密码错误") ;
			ActionContext.getContext().getValueStack().push(getModel());
			return toLogin ;
		}
		ActionContext.getContext().getSession().put("user", getModel()) ;  				//将登陆成功的用户存入session
		//以下为了实现单点登录
		ActionContext.getContext().getApplication().put("sessionId", ServletActionContext.getRequest().getSession().getId());//将当前sessionID存放到Application中
		System.out.println("当前sessionID为:"+ServletActionContext.getRequest().getSession().getId());
		return toIndex ;
	}
	
	public String toIndex(){
		return index ;
	}
	public String left(){
		return left ;
	}
	
	public String right(){
		return right ;
	}
	public String bottom(){
		return bottom ;
	}
	public String top(){
		return top ;
	}
}
