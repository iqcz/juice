package com.lee.bsc.action;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * 
 * @author Administrator
 * 
 */
public class AuthUserHelper {

	private static Logger logger = Logger.getLogger(AuthUserHelper.class);

	public static void clearSessionUser(ConcurrentHashMap<String, HttpSession> userMap, HttpSession session,
			String kickOutUserId) {
		try {
			if (null != userMap) {
				// remove old user in cache.
				if (null != kickOutUserId && userMap.containsKey(kickOutUserId)) {
					logger.debug("Remove: " + kickOutUserId + " from cache.");
					userMap.remove(kickOutUserId);
				}

				Iterator<String> iter = userMap.keySet().iterator();
				while (iter.hasNext()) {
					String key = iter.next();
					HttpSession oldSession = userMap.get(key);

					// remove any login id from login cache, which login from
					// the same PC
					if (null != oldSession && oldSession.getId() == session.getId()) {
						logger.debug("Remove login user[" + key + "] within the same session.");
						userMap.remove(key);
					}

					if (null != oldSession && null == oldSession.getAttribute(oldSession.getId())) {
						logger.debug("Remove login user[" + key + "] from expired session.");
						userMap.remove(key);
					}
				}

			}

		} catch (Exception e) {
			logger.error("Error while clear user in cache, error is: " + e);
		}
	}
}
