<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- include CSS -->
<link rel="stylesheet" type="text/css" href="<s:url value='/stylesheets/common.css' />" >
<link rel="stylesheet" type="text/css" href="<s:url value='/stylesheets/ext/ext-all.css'/>">
<link rel="stylesheet" type="text/css" href="<s:url value='/stylesheets/ext/RowEditor.css'/>">

<script type="text/javascript" src="<s:url value='/script/ext/ext-base.js'/>"></script>
<script type="text/javascript" src="<s:url value='/script/ext/ext-base-debug.js'/>"></script>
<!--  not add yet -->
<script type="text/javascript" src="<s:url value='/script/ext/PagingStore.js'/>"></script>
<script type="text/javascript" src="<s:url value='/script/ext/RowEditor.js'/>"></script>


<script type="text/javascript" src="<s:url value='/dwr/interface/dwrDispatcher.js'/>"></script>
<script type="text/javascript" src="<s:url value='/dwr/engine.js'/>"></script>
<script type="text/javascript" src="<s:url value='/dwr/util.js'/>"></script>
<!-- not add yet -->
<script type="text/javascript" src="<s:url value='/script/ext/DwrProxy.js'/>"></script>

<!-- security control scripts -->

<title><s:text name="balanceSheet.text.head" /></title>
</head>
<body>
	<%--<s:include value="../PageHead.jsp" /> --%>
	<div class="x-box-blue" style="width: 1250px; margin: 10px auto;">
		<div class="x-box-tl">
			<div class="x-box-tr">
				<div class="x-box-tc">
				</div>
			</div>
		</div>
	
		<div class="x-box-ml">
			<div class="x-box-mr">
				<div class="x-box-mc">
					<div>
						<span style="font-weight: bold; font-size:15px; margin-left: 10px;">
							<s:text name="balanceSheet.text.head" />
						</span>
						<span style="margin-left: 875px;">
							<span style="">
								<s:url id="main" action="%{getText('page.link.backMain')}" />
								<s:a href="%{main]"><s:text name="page.text.back"/></s:a>
							</span>
							<span style="margin-left: 10px;">
								<s:url id="main" action="%{getText(page.link.backMain')}" />
								<s:a href="#">Help</s:a>
							</span>
						</span>
					</div>
					<div style="margin: 10px 10px;"></div>
					<div>
						<div id="panel-div" style="margin-left: 10px;"></div>
					</div>
					<div style="margin: 10px 10px;"></div>
				</div>
			</div>
		</div>
		
		<div class="x-box-bl">
			<div class="x-box-br">
				<div class="x-box-bc">
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>