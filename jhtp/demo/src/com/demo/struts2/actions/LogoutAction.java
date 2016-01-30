package com.demo.struts2.actions;

import com.demo.hibernate.dao.UserDAO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;

	public String execute() throws Exception {
		ActionContext.getContext().getSession().clear();
		return Action.SUCCESS;			
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}	
}
