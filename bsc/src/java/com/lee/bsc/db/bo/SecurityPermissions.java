package com.lee.bsc.db.bo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.lee.bsc.bean.BIBaseBean;

public class SecurityPermissions extends BIBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4614521347157366896L;

	private String userId;

	private Integer roleId;

	private Integer functionId;

	private String action;

	private String functionName;

	private String operation;

	public String getUserId() {
		return userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public Integer getFunctionId() {
		return functionId;
	}

	public String getAction() {
		return action;
	}

	public String getFunctionName() {
		return functionName;
	}

	public String getOperation() {
		return operation;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("userId", userId).append("roleId", roleId)
				.append("functionId", functionId).append("action", action).append("functionName", functionName)
				.append("operation", operation).toString();
	}
}
