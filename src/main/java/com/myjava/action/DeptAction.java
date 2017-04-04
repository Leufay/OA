package com.myjava.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.myjava.entity.Dept;
import com.myjava.service.DeptService;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DeptAction extends BaseAction<Dept>{
	@Resource(name="deptService")
	private DeptService deptService ;
	public String list(){
		List<Dept> oList = (List<Dept>) deptService.findAll() ;
		ActionContext.getContext().put("oList", oList);
		return listAction ;
	}
	public String toAdd(){
		List<Dept> oList = (List<Dept>) deptService.findAll() ;
		ActionContext.getContext().put("oList", oList);
		return addUI;
	}
	public String add(){
		Dept dept = new Dept() ;
		BeanUtils.copyProperties(this.getModel(), dept);
		deptService.save(dept);
		return toList;
	}
	public String toUpdate(){
		ActionContext.getContext().put("oList" ,deptService.findAll());
		//将dept对象放到对象栈栈顶，可以利用struts标签的name属性进行回显
		ActionContext.getContext().getValueStack().push(deptService.get(this.getModel().getDeptId()));
		return updateUI ;
	}
	public String update(){
		//deptService.update(getModel());                           //这种方法不推荐，防止hibernate出现NoUniqueBeanException
		
		Dept dept = new Dept() ;									//模型驱动必须自己实例化对象
		BeanUtils.copyProperties(this.getModel(), dept);			//将Model中的属性赋值给dept
		deptService.update(dept);									//更新
		return toList ;
	}
	public String delete(){
		deptService.deleteById(getModel().getDeptId());
		return toList ;
	}
}
