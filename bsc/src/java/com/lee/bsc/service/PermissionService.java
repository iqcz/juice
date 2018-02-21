package com.lee.bsc.service;

import java.util.List;

import com.lee.bsc.BIException;
import com.lee.bsc.bean.BIBaseBean;
import com.lee.bsc.db.bo.GroupPermissionConfigure;
import com.lee.bsc.db.bo.SecurityFunctionPoints;
import com.lee.bsc.db.bo.SecurityPermissions;
import com.lee.bsc.db.bo.SecurityUserLoginBean;

/**
 * <tt>PermissionService</tt>
 * check user permission
 * @author Administrator
 *
 */
public interface PermissionService {

	public BIBaseBean checkPermission(BIBaseBean bean);
	
	public List<GroupPermissionConfigure> getGroupPermission(String groupId);
	
	public List<SecurityFunctionPoints> getUserPermission(String userId);
	
	public List<SecurityPermissions> getPermissions(String action, Boolean hasUser, String user) throws BIException;
	
	public int getInactive(String userId) throws BIException;
	
	public void saveUserLoginInfo(SecurityUserLoginBean login);
}


