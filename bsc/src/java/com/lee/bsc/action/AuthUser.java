package com.lee.bsc.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lee.bsc.bean.UserBean;
import com.lee.bsc.common.Constant;

/**
 * This class is used to create servlet for SiteMinder request, SiteMinder will
 * transfer HTTP request to this servlet attached login user id after login user
 * validation check is done.
 * 
 * @author Administrator
 * 
 */
public class AuthUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 828449370448536547L;

	private static Logger logger = Logger.getLogger(AuthUser.class);

	public void init() {
		logger.info("Initialze AuthUser object.");

		ServletContext servletContext = super.getServletContext();

		@SuppressWarnings("unchecked")
		ConcurrentHashMap<String, HttpSession> userMap = (ConcurrentHashMap<String, HttpSession>) servletContext
				.getAttribute(Constant.BI_LOGIN_USER);

		if (null == userMap) {
			userMap = new ConcurrentHashMap<String, HttpSession>();
			servletContext.setAttribute(Constant.BI_LOGIN_USER, userMap);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Receiving doGet request in AuthUser. request = " + req.toString());
		enumRequestHeaderNames(req);

		// 1. get user id from request.
		String userId = req.getRemoteUser();
		if (null == userId || 0 == userId.length()) {
			logger.error("Not found login user from remote user method.");

			// userId = req.getHeader("HTTP_UID");
			userId = req.getHeader("SM_USER");
			if (null == userId || 0 == userId.length()) {
				logger.error("Not found login user from header method with head name: SM_USER");

				userId = req.getParameter("user");
				if (null == userId || 0 == userId.length()) {
					logger.error("Not found login user from parameter with name: user");
					logger.info("Three ways tried, but not found current login remote user from HttpServletRequest, redirect to No authorized page.");

					resp.sendRedirect(Constant.FAILED_URI);
					return;
				}
			}
		}

		userId = userId.trim().toLowerCase();
		logger.info("Current login user is: " + userId);

		// 2. get session.
		HttpSession session = req.getSession();
		String sid = session.getId();
		logger.info("Session id= " + sid);

		// 3. extract user info from DB as per user id.
		UserBean user = new UserBean(userId);
		session.setAttribute(sid, user);

		// 4. check whether user has logged in.
		ServletContext servletContext = super.getServletContext();

		@SuppressWarnings("unchecked")
		ConcurrentHashMap<String, HttpSession> userMap = (ConcurrentHashMap<String, HttpSession>) servletContext
				.getAttribute(Constant.BI_LOGIN_USER);
		HttpSession oldSession = userMap.get(userId);

		if (null != oldSession) {
			// user re-login in a different PC
			logger.error("Found previous login user in session, redirect to " + Constant.KICKOUT_URI);
			resp.sendRedirect(Constant.KICKOUT_URI);
			return;
		} else {
			// user first login or re-login in a same PC
			// remove any login id from login cache
			AuthUserHelper.clearSessionUser(userMap, session, userId);

			// reset login cache
			userMap.put(userId, session);
			servletContext.setAttribute(Constant.BI_LOGIN_USER, userMap);
		}

		logger.debug("User validation passed, redirect to " + Constant.SUCCESSED_URI);
		user.setLogin(true);
		resp.sendRedirect(Constant.SUCCESSED_URI);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	private void enumRequestHeaderNames(HttpServletRequest req) {
		logger.info("Start to enum request header names...");
		Enumeration<String> enumList = req.getHeaderNames();
		for (Enumeration<String> e = enumList; e.hasMoreElements();) {
			String headerName = e.nextElement();
			logger.info("Found header Name: " + headerName);
			enumRequestHeaderValues(req, headerName);
		}

		logger.info("End to enum request header names...");
	}

	private void enumRequestHeaderValues(HttpServletRequest req, String headerName) {
		logger.info("Start to enum request header values...");
		Enumeration<String> enumList = req.getHeaders(headerName);
		for (Enumeration<String> e = enumList; e.hasMoreElements();) {
			String value = e.nextElement();
			logger.info("Found header value: " + value);
		}

		logger.info("End to enum request header values...");
	}
}
