package com.lee.bsc.dwr;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.lee.bsc.bean.UserBean;

public class DWRBase {

	private HttpSession getSession() {
		WebContext wctx = WebContextFactory.get();
		HttpSession session = wctx.getSession();

		return session;
	}

	public String gerLoginUserId() {
		String sessionId = this.getSession().getId();
		UserBean user = (UserBean) this.getSession().getAttribute(sessionId);

		return user.getUserId();
	}
}
