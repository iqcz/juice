<%@ include file="inc.jsp"%>
<%
	//get parameters
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	//check null
	if (username == null || password == null) {
		response.sendRedirect("login.jsp");
	}
	
	Class.forName(drv).newInstance();
	Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	//validate
	boolean isValid = false;
	String sql = "select * from user where username='" + username + "' and password='" + password+"'";
	try {
		conn = DriverManager.getConnection(url, usr, pwd);
		stm = conn.createStatement();
		rs = stm.executeQuery(sql);
		
		if(rs.next()) {
		    isValid = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
		out.println(e);
	} finally {
	    rs.close();
		stm.close();
		conn.close();
	}
	
	if (isValid) {
		session.setAttribute("username", username);
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>