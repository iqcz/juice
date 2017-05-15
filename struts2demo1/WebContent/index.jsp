<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<frameset rows="22%,*,5%" border="0">
		<frame src="${pageContext.request.contextPath}/common/jsp/top.jsp" name="topFrame"/>
		<frameset cols="20%,*">
			<frame src="${pageContext.request.contextPath}/common/jsp/menu.jsp" name="menuFrame"/>
			<frame name="mainFrame"/>
		</frameset>
		<frame src="${pageContext.request.contextPath}/common/jsp/footer.jsp" name="footerFrame"/>
	</frameset>
</html> 