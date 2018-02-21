package com.lee.bsc.interceptor;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.lee.bsc.action.AuthUserHelper;
import com.lee.bsc.action.BIBaseAction;
import com.lee.bsc.bean.UserBean;
import com.lee.bsc.common.Constant;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * This class aims at session timeout check before processing of client HTTP
 * request, and which will be invoked for every HTTP request only(no including
 * AJAX request) by struts framework automatically, so this class will make page
 * performance bad if it covers many functionalities(for example, many DB query
 * operations and so on);
 * 
 * Below are the detail logic for this class:
 * 1. get request and response from action invocation.
 * 2. get the session from request.
 * 3. check and add the login user bean from and to session, login user SOEID is sent by SSO HTTP request.
 * 4. set login user object(only login id in this object now) into attribute of servletContext of application.
 * 
 * @author Administrator
 * 
 */
public class SessionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7156866853058044708L;

	private Logger logger = Logger.getLogger(SessionInterceptor.class);
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = Action.SUCCESS;
		
		/*
		// 1. obtain request and response from action invocation object.
		BIBaseAction action = (BIBaseAction) invocation.getAction();
		HttpServletRequest request = action.getHttpRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 2. get session and user bean Objects.
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		logger.info("Session id = " + sessionId);
		UserBean user = (UserBean) session.getAttribute(sessionId);
		
		// 3. process 1st time request for login user - generate user bean and add it to session.
		if(null == user && null != request.getHeader("SM_USER")) {
			// 3.1 get user id from request header, which is set by SSO HTTP request only one time.
			String userId = request.getHeader("SM_User");
			if(null == userId || 0 == userId.length()) {
				logger.error("Not found login user from header method with header name: SM_USER!");
				response.sendRedirect(Constant.FAILED_URI);
				return result;
			}
			
			userId = userId.trim().toLowerCase();
			logger.info("Current login user is: " + userId);
			
			// 3.2 extract user info from DB as per user id.
			user = new UserBean(userId);
			session.setAttribute(sessionId, user);
			
			// 3.3 check whether user has logged on.
			ServletContext servletContext = ServletActionContext.getServletContext();
			@SuppressWarnings("unchecked")
			ConcurrentHashMap<String, HttpSession> userMap = (ConcurrentHashMap<String, HttpSession>) servletContext.getAttribute(Constant.BI_LOGIN_USER);
			boolean hasUserSession = true;
			if(null != userMap) {
				HttpSession oldSession = userMap.get(user.getUserId());
				if(null != oldSession) {
					// user re-login in a different PC
					String target = request.getRequestURI().toString().substring(request.getRequestURI().toString().lastIndexOf("/") + 1);
					target = target.contains(".action") ? target : "";
					logger.error("Target: " + target);
					if(null == target || 0 == target.length()) {
						response.sendRedirect(Constant.KICKOUT_URI);
						logger.error("Found previous login user in session, redirect to: " + Constant.KICKOUT_URI);
					} else {
						response.sendRedirect(Constant.KICKOUT_URI + "?target=" + target);
						logger.error("Found previous login user in session, redirect to: " + Constant.KICKOUT_URI + "?target=" + target);
					}
					return result;
				} else {
					hasUserSession = false;
				}
			} else {
				userMap = new ConcurrentHashMap<String, HttpSession>();
				hasUserSession = false;
			}
			
			// 3.4 user first login or re-login in the same PC, remove any login id from login cache
			if(!hasUserSession) {
				AuthUserHelper.clearSessionUser(userMap, session, user.getUserId());
				userMap.put(user.getUserId(), session);
				servletContext.setAttribute(Constant.BI_LOGIN, userMap);
				
				logger.debug("User validation passed, redirect to " + request.getRequestURI().toString());
				user.setLogin(true);
			}
		} 
		
		if(null == session.getAttribute(sessionId)) {
			logger.debug("Session: " + sessionId + " has expired.");
			result = Action.LOGIN;
		} else {
			result = invocation.invoke();
		}
		*/
		return result;
	}
	
}
