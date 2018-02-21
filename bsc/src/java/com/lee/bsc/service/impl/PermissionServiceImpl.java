package com.lee.bsc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.lee.bsc.BIException;
import com.lee.bsc.bean.BIBaseBean;
import com.lee.bsc.db.bo.GroupPermissionConfigure;
import com.lee.bsc.db.bo.SecurityFunctionPoints;
import com.lee.bsc.db.bo.SecurityPermissions;
import com.lee.bsc.db.bo.SecurityUserLoginBean;
import com.lee.bsc.db.dao.PermissionDao;
import com.lee.bsc.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {

	private Logger logger = Logger.getLogger(PermissionServiceImpl.class);
	
	private PermissionDao permissionDao;
	
	@Override
	public BIBaseBean checkPermission(BIBaseBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupPermissionConfigure> getGroupPermission(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityFunctionPoints> getUserPermission(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityPermissions> getPermissions(String action, Boolean hasUser, String user) throws BIException {
		List<SecurityPermissions> list = null;
		try {
			list = permissionDao.getPermissions(action, hasUser, user);
		} catch(Exception ex) {
			logger.error("");
			throw new BIException(2002, 0);
		}
		
		return list;
	}

	@Override
	public int getInactive(String userId) throws BIException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void saveUserLoginInfo(SecurityUserLoginBean login) {
		// TODO Auto-generated method stub
		
	}

	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

}
