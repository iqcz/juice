package com.lee.bsc.db.dao;

import java.util.List;

import com.lee.bsc.BIException;
import com.lee.bsc.db.bo.SecurityFunctionPoints;
import com.lee.bsc.db.bo.SecurityPermissions;
import com.lee.bsc.db.bo.SecurityUserLoginBean;

public interface PermissionDao {

//	public List<PermissionConfig> getPermission(PermissionConfig permissionConfig) throws Excption;
	
	public List<?> getGroupPermission(final String groupId) throws Exception;
	
	public List<SecurityFunctionPoints> gerUserPermission(final String userId) throws Exception;
	
	public List<SecurityPermissions> getPermissions(String action, Boolean hasUser, String user) throws BIException;
	
	public int getInactive(String userId) throws BIException;
	
	public void saveUserLoginInfo(SecurityUserLoginBean login);
}
