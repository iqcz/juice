package com.demo.struts.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;

import com.demo.struts.forms.LoginForm;
import com.demo.struts.util.Constants;

public class LoginAction extends DispatchAction {

    Logger log = Logger.getLogger(this.getClass());

    @SuppressWarnings("deprecation")
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

	ActionErrors errors = new ActionErrors();
	ActionForward forward = new ActionForward();
	LoginForm loginForm = (LoginForm) form;

	try {
	    // get parameters
	    String username = loginForm.getUsername();

	    // invalidate the original session if exists
	    HttpSession session = request.getSession(false);
	    if (session != null) {
		session.invalidate();
	    }

	    // create a new session for the user
	    session = request.getSession(true);

	    // login
	    boolean isValid = valid(request, loginForm);
	    if (isValid) {
		session.setAttribute(Constants.USERNAME_KEY, username);

		log.info("User " + username + " login.");
	    } else {
		errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("login.message.failed"));
	    }

	} catch (Exception e) {
	    errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("login.message.failed"));

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);
	    request.setAttribute("loginFormBean", loginForm);
	    forward = mapping.findForward(Constants.FAILURE_KEY);
	} else {
	    forward = mapping.findForward(Constants.SUCCESS_KEY);
	}

	// Finish with
	return (forward);
    }

    private boolean valid(HttpServletRequest request, LoginForm loginForm) {
	DataSource ds = null;
	Connection cn = null;
	boolean b = false;
	try {
	    ds = getDataSource(request);
	    cn = ds.getConnection();
	    Statement st = cn.createStatement();
	    ResultSet rs = st.executeQuery("select * from user where username='" + loginForm.getUsername()
		    + "' and password='" + loginForm.getPassword() + "'");
	    if (rs.next()) {
		b = true;
	    }
	    rs.close();
	    st.close();
	    cn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return b;
    }
}
