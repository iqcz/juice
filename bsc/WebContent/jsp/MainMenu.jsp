<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<s:url value='/stylesheets/common.css' />">
<title><s:text name="menu.title" /></title>
</head>
<body>

	<%--<s:include value="PageHead.jsp" /> --%>
	<table class="bigger" align="center" border="0">
		<tr>
			<td class="title" colspan="2"><s:text name="menu.title" /></td>
		</tr>
		
		<tr>
			<td colspan="2"><hr></td>
		</tr>
		
		<tr>
			<td colspan="2"><br></td>
		</tr>
		
		<%--
		<s:set name="ec" value="%{ hasErrors() }"/>
		<s:if test="${ec != false }">
			<td class="errorMessage">
				<s:text name="page.text.systemWarning" />
				<s:actionerror/>
			</td>
		</s:if>
		 --%>
		 
		<tr>
			<%--<s:set name="oper" value="%{getModel().getPermission('OperationCategory')}"/> --%>
			<%--<s:if test="${oper == true }" > --%>
				<td valign="top">
					<table align="center" border="0">
						<tr>
							<td valign="top">
								<table align="center" border="0">
									<tr>
										<th class="title"><s:text name="menu.caption.oper" /></th>
									</tr>
									
									<tr>
										<td><hr/></td>
									</tr>
									
									<%--<s:set name="BalanceSheet" value="%{getModel().getPermission('MonthlySignOffAction')}" />
									<s:if test="${BalanceSheet == true }"> --%>
										<tr>
											<td align="center" valign="middle">
											<s:form action="BalanceSheet">
												<s:submit value="getText('menu.button.balanceSheet')" cssClass="menu_button" disabled="%{disableAll}" />
											</s:form>
											</td>
										</tr>
									<%--</s:if> --%>
									
								</table>
							</td>
						</tr>
					</table>
				</td>
			<%--</s:if> --%>
		</tr>
		
	</table>
	
</body>
</html>