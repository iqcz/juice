package com.lee.bsc.listener;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import com.lee.bsc.action.AuthUserHelper;
import com.lee.bsc.bean.UserBean;
import com.lee.bsc.common.Constant;

public class BIWebListener extends ContextLoaderListener implements HttpSessionListener {

	private static Logger logger = Logger.getLogger(BIWebListener.class);

	private ServletContext servletContext;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.debug("******* Init Session, id: " + session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.debug("****** Destroy Session, id: " + session.getId());

		@SuppressWarnings("unchecked")
		ConcurrentHashMap<String, HttpSession> userMap = (ConcurrentHashMap<String, HttpSession>) servletContext
				.getAttribute(Constant.BI_LOGIN_USER);

		UserBean user = (UserBean) session.getAttribute(session.getId());
		String userId = user == null ? null : user.getUserId();

		// remove user info in cache, and clear the same session login info.
		AuthUserHelper.clearSessionUser(userMap, session, userId);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		servletContext = event.getServletContext();
	}

}
