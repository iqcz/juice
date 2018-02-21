package com.lee.bsc.action.exception;

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

public class KickOutAction extends BIBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3723452434537934429L;

	private Logger logger = Logger.getLogger(KickOutAction.class);
	
	private String action;
	
	private String target;

	
	public String executeInit() throws Exception {
		HttpServletRequest request = this.getHttpRequest();
		
		String target = request.getParameter("target");
		if(target!= null && target.toString().contains("action")) {
			this.target = target;
		}
		return SUCCESS;
	}
	
	public String executeKickOut() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// kick out action.
		if(Constant.KICK_FORCE.equalsIgnoreCase(action)) {
			// get current user session and user id.
			ServletContext context = ServletActionContext.getServletContext();
			@SuppressWarnings("unchecked")
			ConcurrentHashMap<String, HttpSession> userMap = (ConcurrentHashMap<String, HttpSession>) context.getAttribute(Constant.BI_LOGIN_USER);
			
			HttpSession newSessionUser = getHttpRequest().getSession();
			UserBean user = (UserBean) newSessionUser.getAttribute(newSessionUser.getId());
			String userId = null;
			
			if(null != user) {
				userId = user.getUserId();
			} else {
				userId = Constant.EMPTY;
			}
			
			// remove old session and invalidate it.
			if(null != userMap) {
				HttpSession oldSessionUser = userMap.get(userId);
				if(oldSessionUser != null && oldSessionUser.getId() != newSessionUser.getId()) {
					// user login using different PC
					// invalid previous session and remove user from cache.
					if(null != oldSessionUser) {
						try {
							logger.debug("Invalid old session: " + oldSessionUser.getId());
							oldSessionUser.invalidate();
						} catch (Exception ex) {
							ex.printStackTrace();
							logger.error("Exception happened when invalidating old session, please check.");
						}
					}
				}
				
				AuthUserHelper.clearSessionUser(userMap, newSessionUser, userId);
				
				// add new user.
				userMap.put(userId, newSessionUser);
			}
			
			// set login flag.
			if(null != user) {
				user.setLogin(true);
			}
			
			if(this.target != null && this.target.contains("action")) {
				String target = this.target;
				this.target = null;
				response.sendRedirect(target);
			}
		} else if(Constant.KICK_CONTINUE.equalsIgnoreCase("action")) {
			return Action.LOGIN;
		} else {
			return ERROR;
		}
		
		logger.debug("end to implement KickOutAction::executeKickOut()...");
		return SUCCESS;
	}
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
