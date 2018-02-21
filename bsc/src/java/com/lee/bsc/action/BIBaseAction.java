package com.lee.bsc.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.lee.bsc.bean.BIBaseBean;
import com.lee.bsc.bean.ErrorMessage;
import com.lee.bsc.bean.UserBean;
import com.lee.bsc.common.Constant;
import com.opensymphony.xwork2.ActionSupport;

public class BIBaseAction extends ActionSupport implements ServletRequestAware, ServletContextAware {

	/**
     * 
     */
	private static final long serialVersionUID = 1350185850695676637L;

	private HttpServletRequest httpRequest;

	private ServletContext servletContext;

	private UserBean user;

	public BIBaseAction() {

	}

	/**
	 * init data model, will be invoked before any execute method.
	 */
	public void init() {
		BIBaseBean bean = getModel();
		if (null != bean) {
			bean.setUserBean(this.getUser());
		}
	}

	/**
	 * get model bean
	 * 
	 * @return
	 */
	public BIBaseBean getModel() {
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpRequest) {
		this.setHttpRequest(httpRequest);
	}

	@Override
	public void validate() {
		this.init();
		super.validate();
	}

	/**
	 * Convert BI error message to action error message in order to display them
	 * in the jsp page by struts tag.
	 * 
	 * @param list
	 */
	public void convertErrors(List<ErrorMessage> list) {
		if (null == list) {
			return;
		}

		for (int i = 0; i < list.size(); ++i) {
			ErrorMessage em = list.get(i);
			if (null == em) {
				continue;
			}

			if (em.getErrorLevel() == Constant.ERROR_LEVEL) {
				if (null == em.getErrorMsg()) {
					if (null == em.getParams() || em.getParams().length == 0) {
						// add message without parameters
						addActionError(this.getErrorMessage(em.getErrorCode()));
					} else {
						// add message with parameters
						addActionError(this.getErrorMessage(em.getErrorCode(), em.getParams()));
					}
				} else {
					addActionError(em.getErrorMsg());
				}
			} else if (em.getErrorLevel() == Constant.WARNING_LEVEL) {
				// normal message
				if (null == em.getParams() || em.getParams().length == 0) {
					// add message without parameters.
					addActionMessage(getErrorMessage(em.getErrorCode()));
				} else {
					addActionMessage(getErrorMessage(em.getErrorCode(), em.getParams()));
				}
			}
		}
	}

	/**
	 * Convert error message from error code
	 * 
	 * @param errorCode
	 * @return
	 */
	public String getErrorMessage(Integer errorCode) {
		return this.getText("sysError." + errorCode);
	}

	public String getErrorMessage(Integer errorCode, String[] params) {
		return this.getText("sysError." + errorCode, params);
	}

	public void addActionError(Integer errorCode) {
		super.addActionError(this.getText(Constant.SYS_ERROR_PREFIX + errorCode));
	}

	public void addActionMessage(Integer errorCode) {
		super.addActionMessage(this.getText(Constant.SYS_ERROR_PREFIX + errorCode));
	}

	public void addActionMessage(String key) {
		super.addActionMessage(this.getText(key));
	}

	// below are getter and setter.

	public HttpServletRequest getHttpRequest() {
		return httpRequest;
	}

	public void setHttpRequest(HttpServletRequest httpRequest) {
		this.httpRequest = httpRequest;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {

	}

	public UserBean getUser() {
		UserBean user = new UserBean();

		if (null != httpRequest) {
			HttpSession session = httpRequest.getSession();
			if (null != session) {
				user = (UserBean) session.getAttribute(session.getId());
			}
		}
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

}
