package com.lee.bsc.dwr;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.extend.Calls;
import org.directwebremoting.extend.Replies;
import org.directwebremoting.impl.DefaultRemoter;
import org.directwebremoting.proxy.dwr.Util;

import com.lee.bsc.bean.UserBean;

public class DWRSessionFilter extends DefaultRemoter {

	private static Logger logger = Logger.getLogger(DWRSessionFilter.class);
	
	@Override
	public Replies execute(Calls calls) {
		HttpSession session = WebContextFactory.get().getSession();
		String sessionId = session.getId();
		UserBean userBean = (UserBean) session.getAttribute(sessionId);
		
		if(null == userBean) {
			logOut();
			return super.execute(new Calls());
		}
		return super.execute(calls);
	}
	
	private void logOut() {
		WebContext wct = WebContextFactory.get();
		logger.debug("Session: " + wct.getSession().getId() + " has expired, redirect to logout screen.");
		Util util = new Util(wct.getScriptSession());
		util.addScript(new ScriptBuffer("logour()"));
	}

}
