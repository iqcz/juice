<%@ page import="com.demo.javabean.UserBean" %>
<%
	//get parameters
	String username = request.getParameter("username");
	String password1 = request.getParameter("password1");
	String password2 = request.getParameter("password2");
	String email = request.getParameter("email");
	
	
	//check null
	if (username == null || password1 == null || password2 == null || !password1.equals(password2)) {
		response.sendRedirect("register.jsp");
	}
	
	
	//validate
	UserBean userBean = new UserBean();
	boolean isExist = userBean.isExist(username);
	if(!isExist) {
		userBean.add(username, password1, email);
		response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("register.jsp");
	}

%>