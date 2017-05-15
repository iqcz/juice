<%@ page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
 <link href="${pageContext.request.contextPath}/common/css/css.css" rel="stylesheet" type="text/css">

<s:actionerror/>

<s:form action="/crud1/userQuery.action" method="post" theme="simple">
<table width="80%" border="0" cellpadding="0" cellspacing="1" class="tableLine DoubleColorTable" >
	<tr>
    	<td colspan="4" align="center"><s:text name="jsp.query.title"/> </td>
  	</tr>
  	<tr>
    	<td><s:text name="jsp.query.userId"/></td>
    	<td>
    		<s:textfield name="uqm.userId" cssClass="input"></s:textfield>
    	</td>
		<td><s:text name="jsp.query.name"/></td>
		<td>
			<s:textfield name="uqm.name" cssClass="input"></s:textfield>
		</td>
	</tr>
  	<tr>
    	<td><s:text name="jsp.query.sex"/></td>
    	<td>
    		<s:select list="sexes" name="uqm.sex"
    			headerKey="" headerValue="%{getText('jsp.query.noselect')}"
    		 	cssClass="input"></s:select>
    	</td>
		<td><s:text name="jsp.query.age"/></td>
		<td>
			<s:textfield name="uqm.age" cssClass="input"></s:textfield>
			<s:text name="jsp.query.to"/>
			<s:textfield name="uqm.age2" cssClass="input"></s:textfield>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="<s:text name="jsp.query.submit"/>" class="button"/>
		</td>
	</tr>
</table>
</s:form>