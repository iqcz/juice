<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/common/css/css.css" rel="stylesheet" type="text/css">
</head>
<body>

<table width="100%" border="0" cellpadding="0" cellspacing="1">
	<tr>
		<td align="center"><b>用户列表</b></td>
	</tr>
</table>
  
<table width="100%" border="0" cellpadding="0" cellspacing="1" class="tableLine DoubleColorTable" >
	<tr>
		<td align="center"  class="tableLineBge">用户编号</td>
		<td align='center'  class='tableLineBge'>用户姓名</td>
		<td align='center'  class='tableLineBge'>性别</td>
		<td align='center'  class='tableLineBge'>年龄</td>
		<td align="center"  class="tableLineBge">操作</td>
   	</tr>
   	<s:iterator value="users">
  	<tr>
		<td align="center"><s:property value="userId"/> </td>
		<td align="center"><s:property value="name"/> </td>
		<td align="center"><s:property value="sex"/> </td>
		<td align="center"><s:property value="age"/> </td>
		<td>
			<a href='${pageContext.request.contextPath}/crud1/userToUpdate.action?user.userId=<s:property value="userId"/>'>修改</a>
			<a href="javascript: if (confirm('是否确认删除?')) window.location.href='${pageContext.request.contextPath}/crud1/userDelete.action?user.userId=<s:property value="userId"/>'">删除</a>
		</td>
    </tr>
    </s:iterator>
</table>


<table width="100%" border="0" cellpadding="0" cellspacing="1" align=center>
<tr>
	<td align="center">	
		  <input type="button" value="转到查询" onClick="window.navigate('${pageContext.request.contextPath}/crud1/userToQuery.action');"  class="button">
  	</td>
  </tr>
</table>
</body>

</html>
