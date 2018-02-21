package com.lee.bsc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lee.bsc.bean.enumeration.EnumErrorLocation;
import com.lee.bsc.common.DBConstant;
import com.opensymphony.xwork2.Action;

/**
 * <tt>BIBaseBean</tt> is used to store the common data for all data.
 * 
 * @author Administrator
 * 
 */
public class BIBaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7108944293423621761L;

	/**
	 * hold all error code and error info and error level.
	 */
	private List<ErrorMessage> errors = new ArrayList<ErrorMessage>();

	/**
	 * get operation result: SUCCESS, ERROR and so on;
	 */
	private String operResult = Action.SUCCESS;

	/**
	 * stores login user info.
	 */
	private UserBean userBean;

	/**
	 * 
	 */
	private Map<String, Boolean> permissionMap = new HashMap<String, Boolean>();

	public BIBaseBean() {

	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorMessage> errors) {
		this.errors = errors;
	}

	public void addErrors(ErrorMessage em) {
		if (null == errors) {
			errors = new ArrayList<ErrorMessage>();
		}
		errors.add(em);
	}

	public void addErrors(Integer errorCode) {
		if (null == errors) {
			errors = new ArrayList<ErrorMessage>();
		}
		ErrorMessage em = new ErrorMessage(errorCode);
		errors.add(em);
	}

	public void addErrors(Integer errorCode, String[] params) {
		if (null == errors) {
			errors = new ArrayList<ErrorMessage>();
		}
		ErrorMessage em = new ErrorMessage(errorCode, params);
		errors.add(em);
	}

	public void addErrors(Integer errorCode, String[] params, EnumErrorLocation errorLocation) {
		if (null == errors) {
			errors = new ArrayList<ErrorMessage>();
		}
		ErrorMessage em = new ErrorMessage(errorCode, params, errorLocation);
		errors.add(em);
	}

	public void addErrors(Integer errorCode, String errorMsg) {
		if (null == errors) {
			errors = new ArrayList<ErrorMessage>();
		}
		ErrorMessage em = new ErrorMessage(errorCode, errorMsg);
		errors.add(em);
	}

	public void addErrors(Integer errorCode, String errorMsg, EnumErrorLocation errorLocation) {
		if (null == errors) {
			errors = new ArrayList<ErrorMessage>();
		}
		ErrorMessage em = new ErrorMessage(errorCode, errorMsg, errorLocation);
		errors.add(em);
	}

	public String getOperResult() {
		return operResult;
	}

	public void setOperResult(String operResult) {
		this.operResult = operResult;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String getLoginUserID() {
		if (null == userBean) {
			return DBConstant.BICONF_NA;
		}

		if (null != userBean.getUserId()) {
			return userBean.getUserId();
		} else {
			return DBConstant.BICONF_NA;
		}
	}

	public void addPermissionKey(String key) {
		permissionMap.put(key, false);
	}

	public void removePermissionKey(String key) {
		permissionMap.remove(key);
	}

	public void setPermission(String key, boolean value) {
		permissionMap.put(key, value);
	}
	
	public boolean getPermission(String key) {
		Boolean value = permissionMap.get(key);

		return value != null ? value.booleanValue() : false;
	}

	public Set<String> getPermissionKeySet() {
		return permissionMap.keySet();
	}

	public void cleanPermissionMap() {
		permissionMap.clear();
	}

	/**
	 * reset all key values to false.
	 */
	public void resetPermissionMap() {
		for (String key : permissionMap.keySet()) {
			boolean value = permissionMap.get(key);
			permissionMap.put(key, value);
		}
	}
}
