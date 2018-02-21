package com.lee.bsc.db.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lee.bsc.BIException;
import com.lee.bsc.common.Constant;
import com.lee.bsc.db.bo.SecurityFunctionPoints;
import com.lee.bsc.db.bo.SecurityPermissions;
import com.lee.bsc.db.bo.SecurityUserLoginBean;
import com.lee.bsc.db.dao.PermissionDao;


public class PermissionDaoImpl extends HibernateDaoSupport implements PermissionDao {

	@Override
	public List<?> getGroupPermission(String groupId) throws Exception {
		return null;
	}

	@Override
	public List<SecurityFunctionPoints> gerUserPermission(String userId) throws Exception {
		return null;
	}

	@Override
	public List<SecurityPermissions> getPermissions(String action, Boolean hasUser, String user) throws BIException {
		List<SecurityPermissions> list = new ArrayList<SecurityPermissions>();
		Session session = getSession(true);
		
		try {
			Connection conn = session.connection();
			CallableStatement proc = null;
			proc = conn.prepareCall("{ call SecurityPkg.GetPermissions(?, ?, ?)}");
			
			proc.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			if(null == action || action.equalsIgnoreCase(Constant.EMPTY)) {
				proc.setNull(2, java.sql.Types.NULL);
			} else {
				proc.setString(2, action);
			}
			
			if(hasUser && user != null && !user.equalsIgnoreCase(Constant.EMPTY)) {
				proc.setString(3, user);
			} else {
				proc.setNull(3, java.sql.Types.NULL);
			}
			
			proc.execute();
			
			ResultSet rs = (ResultSet) proc.getObject(1);
			while(rs.next()) {
				list.add(loadSecurityPermissions(rs));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new BIException(e);
		} finally {
			this.releaseSession(session);
		}
		
		return list;
	}

	private SecurityPermissions loadSecurityPermissions(ResultSet rs) throws SQLException {
		SecurityPermissions bean = new SecurityPermissions();
		
		bean.setUserId(rs.getString("userId"));
		bean.setFunctionId(rs.getInt("functionId"));
		bean.setAction(rs.getString("action"));
		bean.setFunctionName(rs.getString("functionName"));
		bean.setOperation(rs.getString("operation"));
		
		return bean;
	}

	@Override
	public int getInactive(String userId) throws BIException {
		return 0;
	}

	@Override
	public void saveUserLoginInfo(SecurityUserLoginBean login) {
		
	}

}
