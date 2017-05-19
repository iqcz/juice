<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="login.page.title" /></title>
</head>
<body>

<form name="form1" action="login.do" method="post">
<table width="300" border="1">
	<tr>
		<td colspan="2"><s:text name="login.page.title" /></td>
	</tr>
	<tr>
		<td><s:text name="login.page.username" /></td>
		<td><s:textfield name="username" /><s:fielderror><s:param>username</s:param></s:fielderror></td>
	</tr>
	<tr>
		<td><s:text name="login.page.password" /></td>
		<td><s:password name="password" /><s:fielderror><s:param>password</s:param></s:fielderror></td>
	</tr>
	<tr>
		<td colspan="2"><s:submit key="login.page.login" /><a href="register!init.do"><s:text name="login.page.register" /></a></td>
	</tr>
</table>
<br><br><s:actionerror /> <s:actionmessage /></form>


</body>
</html>
