<%@ page import="com.demo.javabean.UserBean" %>
<%
	//get parameters
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	//check null
	if (username == null || password == null) {
		response.sendRedirect("login.jsp");
	}
	
	//validate
	UserBean userBean = new UserBean();
	boolean isValid = userBean.valid(username, password);
	
	if (isValid) {
		session.setAttribute("username", username);
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>