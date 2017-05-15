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
		<td align="center">
			<s:if test="flag">
				您已经成功操作
			</s:if>
			<s:else>
				您的操作不成功，请
				<input type="button" value="返回" onclick="history.back();" class="button"/>
			</s:else>
		</td>
	</tr>
</table>
  
</body>

</html>
