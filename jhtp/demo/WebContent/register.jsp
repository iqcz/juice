<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="register.page.title" /></title>
</head>
<body>


<form name="form1" action="register!register.do" method="post">
<table width="300" border="1">
	<tr>
		<td colspan="2"><s:text name="register.page.title" /></td>
	</tr>
	<tr>
		<td><s:text name="register.page.username" /></td>
		<td><s:textfield name="username" /><s:fielderror><s:param>username</s:param></s:fielderror></td>
	</tr>
	<tr>
		<td><s:text name="register.page.password1" /></td>
		<td><s:password name="password1" /><s:fielderror><s:param>password1</s:param></s:fielderror></td>
	</tr>
	<tr>
		<td><s:text name="register.page.password2" /></td>
		<td><s:password name="password2" /><s:fielderror><s:param>password2</s:param></s:fielderror></td>
	</tr>
	<tr>
		<td><s:text name="register.page.email" /></td>
		<td><s:textfield name="email" /><s:fielderror><s:param>email</s:param></s:fielderror></td>
	</tr>
	<tr>
		<td colspan="2"><s:submit key="register.page.register" /><a href="index.do"><s:text name="register.page.back" /></a></td>
	</tr>
</table>
<br>
<br>
<s:actionerror /> <s:actionmessage /></form>
</body>
</html>
