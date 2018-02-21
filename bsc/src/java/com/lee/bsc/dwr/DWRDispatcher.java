package com.lee.bsc.dwr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lee.bsc.bean.ErrorMessage;
import com.lee.bsc.bean.SearchPageBean;
import com.lee.bsc.bean.UserBean;
import com.lee.bsc.common.Constant;

public class DWRDispatcher extends DWRBase {

	private WebApplicationContext webApplicationContext;

	public DWRDispatcher() {
		setWebApplicationContext(WebApplicationContextUtils.getRequiredWebApplicationContext(WebContextFactory.get()
				.getServletContext()));
	}

	private HttpSession getSession() {
		WebContext wctx = WebContextFactory.get();

		return wctx.getSession();
	}

	private UserBean getUserBean() {
		String sessionId = this.getSession().getId();

		return (UserBean) this.getSession().getAttribute(sessionId);
	}

	/**
	 * This method is communication between client and server with DWR AJAX
	 * technology for all AJAX request.
	 * 
	 * @param actionName
	 * @param methodName
	 * @param parameter
	 * @return
	 */
	public Object invoke(String actionName, String methodName, SearchPageBean parameter) {
		Object action = this.getWebApplicationContext().getBean(actionName);

		try {
			Method setUserMethod = null;
			Method getErrorMethod = null;

			if (action.getClass().getSuperclass().getName().contains("BIBaseAction")) {
				setUserMethod = action.getClass().getSuperclass().getDeclaredMethod("setUser", UserBean.class);
				getErrorMethod = action.getClass().getSuperclass().getSuperclass().getDeclaredMethod("getActionErrors");
			} else if (action.getClass().getSuperclass().getName().contains("BIMultiLayoutAction")) {
				setUserMethod = action.getClass().getSuperclass().getSuperclass()
						.getDeclaredMethod("setUser", UserBean.class);
				getErrorMethod = action.getClass().getSuperclass().getSuperclass().getSuperclass()
						.getDeclaredMethod("getActionErrors");
			}

			Method method = null;

			if (null == parameter) {
				method = action.getClass().getDeclaredMethod(methodName, new Class[] {});
				// method = action.getClass().getDeclaredMethod(methodName);
			} else {
				method = action.getClass().getDeclaredMethod(methodName, parameter.getClass());
				parameter.setUserBean(this.getUserBean());
			}

			try {
				setUserMethod.invoke(action, this.getUserBean());
				String result = null;
				if (null == parameter) {
					result = method.invoke(action).toString();
				} else {
					result = method.invoke(action, parameter).toString();
				}

				if (result.toLowerCase() == Constant.BI_SUCCESS) {
					@SuppressWarnings("unchecked")
					List<String> errors = (List<String>) getErrorMethod.invoke(action);
					List<ErrorMessage> emsgs = new ArrayList<ErrorMessage>();
					for (String item : errors) {
						ErrorMessage msg = new ErrorMessage();
						msg.setErrorMsg(item);
						emsgs.add(msg);
					}
					parameter.setErrors(emsgs);
					return parameter;
				} else {
					return getErrorMethod.invoke(action);
				}
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}

	public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		this.webApplicationContext = webApplicationContext;
	}

}
