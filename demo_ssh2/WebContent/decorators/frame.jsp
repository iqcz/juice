<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.demo.struts2.util.Constants"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<html>
<head>
<title>Demo - <decorator:title default="Welcome!" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
<decorator:head />
</head>

<body>
<div align="center"><%if (session.getAttribute(Constants.USERNAME_KEY) != null) {%>
<table width="100%">
	<tr>
		<td><img src='images/<s:text name="image.logo" />'></td>
		<td><img src='images/<s:text name="image.banner" />' height="90"></td>
	</tr>
	<tr>
		<td colspan="2">
		<hr>
		</td>
	</tr>
	<tr>
		<td width="160" bgcolor="#EEEEEE" valign="top">
		<table width="100%">
			<tr>
				<td><li><a href="welcome.do"><s:text name="frame.main" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="address.do?method=list"><s:text name="frame.address" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="schedule.do?method=list"><s:text name="frame.schedule" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="worklog.do?method=list"><s:text name="frame.worklog" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="sms.do?method=list"><s:text name="frame.sms" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="notice.do?method=list"><s:text name="frame.notice" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="meeting.do?method=list"><s:text name="frame.meeting" /></a></li></td>
			</tr>
			<tr>
				<td><li><a href="logout.do"><s:text name="frame.logout" /></a></li></td>
			</tr>
		</table>
		</td>
		<td align="left" valign="top"><decorator:body /></td>
	</tr>
</table>
<%} else {%> <decorator:body /> <%}%>
<hr>
2007copyright abc@163.com</div>
</body>
</html>
