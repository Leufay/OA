package com.myjava.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 权限拦截器
 * @author mr.lxf
 * @data 2017年3月19日 上午2:14:37
 */
@SuppressWarnings("serial")
public class PrivilegeInterceptor implements Interceptor{

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getActionName() ;
		String namespace = invocation.getProxy().getNamespace() ;
		Object applicationSessionId = ActionContext.getContext().getApplication().get("sessionId") ;		//application中的sessionId
		String currentSessionId = ServletActionContext.getRequest().getSession().getId() ;							//当前sessionid
		//String requestUri = ServletActionContext.getRequest().getRequestURI() ;
		//requestUri = requestUri.substring(requestUri.indexOf("/",requestUri.indexOf("/")+1)) ;
		Object obj = ActionContext.getContext().getSession().get("user") ;
		//过滤登录相关url
		if((namespace+"/"+actionName).equals("/login/loginAction_login") || (namespace+"/"+actionName).equals("/login/loginAction_toLogin")){
			invocation.invoke();
		}
		if(obj==null){				//如果session中用户为null则跳转到登陆界面
			return "toLogin";
		}else{
			//单点登录判断
			if(applicationSessionId!=null){
				if(!currentSessionId.equals(applicationSessionId.toString())){			//如果application中的sessionId和当前sessionID不一致则重新登录
					return "toLogin" ;
				}
			}
			//进行权限判断
			invocation.invoke() ;
		}
		return null;
	
	}

}
