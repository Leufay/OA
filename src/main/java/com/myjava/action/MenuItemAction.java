package com.myjava.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.myjava.entity.MenuItem;
import com.myjava.service.MenuItemService;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class MenuItemAction extends BaseAction<MenuItem>{
	@Resource
	private MenuItemService menuItemService ;
	private List<MenuItem> oList = new ArrayList<>() ;
	public String findAll(){
		oList = (List<MenuItem>) menuItemService.findAll() ;
		return SUCCESS ;
	}
	public List<MenuItem> getoList() {
		return oList;
	}
	public void setoList(List<MenuItem> oList) {
		this.oList = oList;
	}
}
