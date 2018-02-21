package com.lee.bsc.db.bo;

import java.util.Date;

import com.lee.bsc.bean.BIBaseBean;

public class SecurityUserLoginBean extends BIBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8365463353202486159L;

	private String userId;

	private String loginIp;

	private String loginType; // 1-BI; 2-BP;

	private Date loginTime;

	private Date logoutTime;

	public String getUserId() {
		return userId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public String getLoginType() {
		return loginType;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

}
