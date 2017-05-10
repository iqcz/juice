package com.demo.struts2.actions;

import java.util.Map;

import com.demo.hibernate.dao.UserDAO;
import com.demo.struts2.util.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	private String username;

	private String password;

	public void validate() {
		clearErrorsAndMessages();
		if (username == null || username.equals("")) {
			addFieldError("username", getText("login.error.username"));
		}
		if (password == null || password.equals("")) {
			addFieldError("password", getText("login.error.password"));
		}
	}

	public String execute() throws Exception {
		if (this.userDAO.isValid(username, password)) {
			
			ActionContext context = ActionContext.getContext();
			Map<String, String> session = context.getSession();
			session.put(Constants.USERNAME_KEY, username);
			
			return Action.SUCCESS;
		} else {
			super.addActionError(super.getText("login.message.failed"));
			
			return Action.INPUT;
		}
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
