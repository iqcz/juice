package com.lee.bsc.db.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lee.bsc.BIException;
import com.lee.bsc.db.bo.BalanceSheet;
import com.lee.bsc.db.dao.BalanceSheetDao;
import com.lee.bsc.db.dao.dbEnum.EnumSPErrorCode;

public class BalanceSheetDaoImpl extends HibernateDaoSupport implements BalanceSheetDao {

	@Override
	public List<BalanceSheet> getAllBalanceSheet(String loginId) throws BIException {
		List<BalanceSheet> list = new ArrayList<BalanceSheet>();

		Session session = this.getSession(true);
		Connection conn = session.connection();
		CallableStatement proc = null;

		try {
			
			proc = conn.prepareCall("{ call BalanceSheetPkg.GetAllBalanceSheet(?, ?) }");
			proc.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			proc.setString(2, loginId);
			proc.execute();

			ResultSet rs = (ResultSet) proc.getObject(1);
			while (rs.next()) {
				list.add(loadBalanceSheet(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BIException(e);
		} finally {
			if (null != session) {
				this.releaseSession(session);
			}
		}
		return list;
	}

	@Override
	public void addBalanceSheet(BalanceSheet balanceSheet) throws BIException {
		Session session = null;
		Connection conn = null;
		CallableStatement proc = null;
		Transaction trans = null;

		try {
			session = this.getSession(true);
			trans = session.beginTransaction();
			conn = session.connection();
			
			proc = conn.prepareCall("{ call BalanceSheetPkg.AddBalanceSheet(?, ?, ?, ?, ?, ?, ?) }");
			proc.setString("v_orgUnitName", balanceSheet.getOrgUnitName());
			proc.setString("v_biDeskName", balanceSheet.getBiDeskName());
			proc.setString("v_product", balanceSheet.getProduct());
			proc.setFloat("v_balanceLimit", balanceSheet.getBalanceLimit());
			proc.setString("v_dailyDollar", balanceSheet.getDailyDollar());
			proc.setString("v_note", balanceSheet.getNote());
			proc.setString("v_updateUserId", balanceSheet.getUpdateUserId());
			proc.execute();
			
			trans.commit();
		} catch(SQLException sqle) {
			if(null != trans) {
				trans.rollback();
			}
			
			sqle.printStackTrace();
			
			if(sqle.getErrorCode() == EnumSPErrorCode.c_SELECT_FAILED_ERR) {
				throw new BIException(1001);
			} else {
				throw new BIException(sqle);
			}
		} catch (Exception e) {

		} finally {
			this.releaseSession(session);
		}
	}

	@Override
	public void updateBalanceSheet(BalanceSheet balanceSheet) throws BIException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBalanceSheet(BalanceSheet balanceSheet) throws BIException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, String>> getAllOrgUnitNames(String loginId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> getAllBiDeskNames(String loginId) {
		// TODO Auto-generated method stub
		return null;
	}

	private BalanceSheet loadBalanceSheet(ResultSet rs) throws Exception {
		BalanceSheet bs = new BalanceSheet();

		bs.setSeqNo(rs.getInt("seqNo"));
		bs.setOrgUnitName(rs.getString("orgUnitName"));
		bs.setBiDeskName(rs.getString("biDeskName"));
		bs.setProduct(rs.getString("product"));
		bs.setBalanceLimit(rs.getFloat("balanceLimit"));
		bs.setDailyDollar(rs.getString("dailyDollar"));
		bs.setNote(rs.getString("note"));
		bs.setUpdateUserId(rs.getString("updateUserId"));
		bs.setRecordTimestamp(rs.getDate("recordTimestamp"));

		return bs;
	}

}
