package com.myjava.exceptionresolver;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 全局异常处理Action
 * 
 * @author mrlxf
 *
 */
public class ExceptionResolverAction extends ActionSupport{
	private Exception exception ;
	public String execute(){
		ActionContext.getContext().getValueStack().push(exception.getMessage());
		return "error";
	}
	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
}
