package com.lee.bsc.bean;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.lee.util.StringUtil;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3761328140585117680L;

	private String userId;

	private boolean login;

	public UserBean() {

	}

	public UserBean(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public boolean isLogin() {
		return login;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(userId).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof UserBean)) {
			return false;
		}

		UserBean castOther = new UserBean();
		return new EqualsBuilder().append(this.getUserId(), castOther.getUserId()).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, StringUtil.getToStringStyle())
						.append("userId", userId)
						.append("login", login).toString();
	}

}
