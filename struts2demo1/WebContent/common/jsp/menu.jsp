<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/common/css/css.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function showsubmenu1(sid) {
		whichEl = eval("submenu" + sid);
		if (whichEl.style.display == "none") {
			eval("submenu" + sid + ".style.display=\"\";");
		} else {
			eval("submenu" + sid + ".style.display=\"none\";");
		}
	}
	function showsubmenu(subMenu) {
		var displayFlag = document.getElementById(subMenu);
		if (displayFlag.style.display == 'none') {
			displayFlag.style.display = '';
		} else {
			displayFlag.style.display = 'none';
		}

	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
	<table width=100% cellpadding=0 cellspacing=0 border=0 align=left>
		<tr>
			<td valign=top>
				<table width=158 border="0" align=center cellpadding=0 cellspacing=0
					bgcolor="#0099CC">
					<tr>
						<td width="158" height=35 valign=bottom align="center">菜单</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign=top>
				<table width=158 align=center cellpadding=0 cellspacing=0>
					<tr>
						<td valign=top height=25 style="cursor: hand;"
							onclick="showsubmenu('submenu1')" bgcolor="#cccccc"><span>用户中心</span></td>
					</tr>
					<tr>
						<td height="0" id='submenu1' style="display: none; cursor: hand;">
							<table>
								<!--  -->
								<tr>
									<td onclick="showsubmenu('submenu101')">
										&nbsp;&nbsp;&nbsp;&nbsp;用户管理</td>
								</tr>
								<tr>
									<td id='submenu101' style="display: none">
										<div style="width: 150">
											<table cellpadding=0 cellspacing=0 align=center width=131>
												<tr>
													<td width="150" height=20><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
														<a
														href="${pageContext.request.contextPath}/crud1/userToAdd.action"
														target="mainFrame">用户新增</a></td>
												</tr>
												<tr>
													<td width="150" height=20><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
														<a
														href="${pageContext.request.contextPath}/crud1/userToList.action"
														target="mainFrame">用户列表</a></td>
												</tr>


											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>



				<table width=158 align=center cellpadding=0 cellspacing=0>
					<tr>
						<td valign=top height=25 style="cursor: hand;"
							onclick="showsubmenu('submenu2')" bgcolor="#cccccc"><span>系统中心</span></td>
					</tr>
					<tr>
						<td height="0" id='submenu2' style="display: none; cursor: hand;">
							<table>
								<!--  -->
								<tr>
									<td onclick="showsubmenu('submenu102')">
										&nbsp;&nbsp;&nbsp;&nbsp;部门管理</td>
								</tr>
								<tr>
									<td id='submenu102' style="display: none">
										<div style="width: 150">
											<table cellpadding=0 cellspacing=0 align=center width=131>
												<tr>
													<td width="150" height=20><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
														<a href="<%=request.getContextPath()%>/user/UserAdd.jsp"
														target="mainFrame">部门新增</a></td>
												</tr>
												<tr>
													<td width="150" height=20><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
														<a href="<%=request.getContextPath()%>/user/UserList.jsp"
														target="mainFrame">部门列表</a></td>
												</tr>


											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>


			</td>
		</tr>
	</table>
</body>
</html>
