<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
 <link href="${pageContext.request.contextPath}/common/css/css.css" rel="stylesheet" type="text/css">
 
<s:form action="/crud1/userAdd.action" method="post" theme="simple">
<table width="80%" border="0" cellpadding="0" cellspacing="1" class="tableLine DoubleColorTable" >
	<tr>
    	<td colspan="4" align="center">用户新增</td>
  	</tr>
  	<tr>
    	<td>用户编号</td>
    	<td>
    		<s:textfield name="user.userId" cssClass="input"></s:textfield>
    	</td>
		<td>用户姓名</td>
		<td>
			<s:textfield name="user.name" cssClass="input"></s:textfield>
		</td>
	</tr>
  	<tr>
    	<td>性别</td>
    	<td>
    		<s:select list="sexes" name="user.sex" cssClass="input"></s:select>
    	</td>
		<td>年龄</td>
		<td>
			<s:textfield name="user.age" cssClass="input"></s:textfield>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="新增" class="button"/>
		</td>
	</tr>
</table>
</s:form>