<%@page language="java" contentType="text/html;charset=gb2312"%>
<%@ include file="inc.jsp"%>
<%
	String sql = "select * from user";

	Class.forName(drv).newInstance();
	Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	ResultSetMetaData rsmd = null;
	
	try {
	    conn = DriverManager.getConnection(url, usr, pwd);
		stm = conn.createStatement();
		rs = stm.executeQuery(sql);
		rsmd = rs.getMetaData();
	    
		int cols = rsmd.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= cols; i++) {
				String field = (String) (rsmd.getColumnName(i));
				String value = (String) (rs.getString(i));
				out.print(field + " = " + value + ";");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		out.println(e);
	} finally {
	    rs.close();
		stm.close();
		conn.close();
	}
%>
