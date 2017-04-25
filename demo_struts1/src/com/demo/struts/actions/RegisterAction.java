package com.demo.struts.actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.demo.struts.forms.RegisterForm;
import com.demo.struts.util.Constants;

public class RegisterAction extends DispatchAction {

	Logger log = Logger.getLogger(this.getClass());

	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = mapping.findForward(Constants.FAILURE_KEY);
		return (forward);
	}

	@SuppressWarnings("deprecation")
	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		RegisterForm registerForm = (RegisterForm) form;

		try {
			// if exist
			boolean isExist = isExist(request, registerForm);

			if (isExist) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
						"register.message.failed"));
			} else {
				insert(request, registerForm);
				log.info("User " + registerForm.getUsername() + " register.");
			}

		} catch (Exception e) {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(
					"register.message.failed"));

		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			request.setAttribute("registerFormBean", registerForm);
			forward = mapping.findForward(Constants.FAILURE_KEY);
		} else {
			forward = mapping.findForward(Constants.SUCCESS_KEY);
		}

		// Finish with
		return (forward);
	}

	private boolean isExist(HttpServletRequest request,
			RegisterForm registerForm) {
		DataSource ds = null;
		Connection cn = null;
		boolean b = false;
		try {
			ds = getDataSource(request);
			cn = ds.getConnection();
			Statement st = cn.createStatement();
			ResultSet rs = st
					.executeQuery("select * from user where username='"
							+ registerForm.getUsername() + "'");
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

	private void insert(HttpServletRequest request, RegisterForm registerForm) {
		DataSource ds = null;
		Connection cn = null;
		try {
			ds = getDataSource(request);
			cn = ds.getConnection();
			Statement st = cn.createStatement();
			st.executeUpdate("insert into user(username,password,email) values('"
					+ registerForm.getUsername() + "', '"
					+ registerForm.getPassword1() + "', '"
					+ registerForm.getEmail() + "')");
			cn.commit();
			st.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
