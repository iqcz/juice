package com.lee.bsc.common;

import com.opensymphony.xwork2.Action;

// 可以考虑把所有的常量定义在一个interface里，可是省去写： public static final.
public interface Constant {

	int ERROR_LEVEL = 0;

	int WARNING_LEVEL = 1;

	String SYS_ERROR_PREFIX = "sysError.";

	String BI_SUCCESS = Action.SUCCESS;

	String BI_NONE = Action.NONE;

	String BI_ERROR = Action.ERROR;

	String BI_INPUT = Action.INPUT;

	String BI_LOGIN = Action.LOGIN;

	String BI_MAIN = "main";
	// modify this.
	String BI_LOGIN_USER = "jp.co.citi.biweb.loginUser";

	// 单词拼写错误
	String[] AUTHORIZED_URI_PAGE = { "", "login.html", "BI_WEB", "index.html", "AuthUser", "NotAuthorised.jsp" };
	String SUCCESSED_URI = "MainMenu.action";
	// 单词拼写错误
	String FAILED_URI = "NotAuthorised.action";
	String KICKOUT_URI = "InitKickOut.action";

	String DEFAULT_ENCODING = "UTF-8";

	String EMPTY = "";

	String OPERATE_TYPE_ADD = "ADD";
	String OPERATE_TYPE_COPY = "COPY";
	String OPERATE_TYPE_UPDATE = "UPDATE";
	String OPERATE_TYPE_DELETE = "DELETE";
	
	String KICK_FORCE = "force";
	String KICK_CONTINUE = "continue";

}
