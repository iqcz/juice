<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="welcome.page.title" /></title>
</head>
<body>

<form name="form1" action="logout.do" method="post">
<table width="200" border="1">
	<tr>
		<td colspan="2"><s:text name="welcome.page.title" /></td>
	<tr>
		<td><s:text name="welcome.page.username" /></td>
		<td><%=(String) session.getAttribute("username")%></td>
	</tr>
	<tr>
		<td colspan="2"><s:submit key="welcome.page.logout" /></td>
	</tr>
</table>
</form>
</body>
</html>