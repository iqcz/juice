package com.lee.bsc.action;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.lee.bsc.bean.UserBean;
import com.lee.bsc.common.Constant;

public class LogoutAction extends BIBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4550204771060933224L;

	private static Logger logger = Logger.getLogger(LogoutAction.class);

	public LogoutAction() {

	}

	@Override
	public String execute() throws Exception {
		logger.debug("*** LogoutAction executed success.");

		// get current session.
		HttpSession session = this.getHttpRequest().getSession();

		// get current user session and user id.
		UserBean user = (UserBean) session.getAttribute(session.getId());
		String userId = null;
		if (null != user) {
			userId = user.getUserId();
		}
		ServletContext context = ServletActionContext.getServletContext();
		@SuppressWarnings("unchecked")
		ConcurrentHashMap<String, HttpSession> userMap = (ConcurrentHashMap<String, HttpSession>) context
				.getAttribute(Constant.BI_LOGIN_USER);

		// invalidate session
		try {
			logger.debug("Invalid old session: " + session.getId());
			session.invalidate();
		} catch (Exception e) {
			logger.error("Exception happened when inalidating old session, please check.");
		}

		AuthUserHelper.clearSessionUser(userMap, session, userId);

		return SUCCESS;
	}

}
