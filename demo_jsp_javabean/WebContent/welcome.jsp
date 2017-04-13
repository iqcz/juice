
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'welcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<table width="100%">
	
	<tr>
		<td>
		<form name="form1" action="logout.jsp" method="post">
		<table width="200" border="1">
			<tr>
				<td colspan="2">登录成功</td>
			</tr>
			<tr>
				<td>欢迎你，</td>
				<td><%=(String) session.getAttribute("username")%></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit" value="退出"></td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>







</body>
</html>
