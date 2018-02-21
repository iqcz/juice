package com.lee.bsc.db.dao;

import java.util.List;
import java.util.Map;

import com.lee.bsc.BIException;
import com.lee.bsc.db.bo.BalanceSheet;

public interface BalanceSheetDao {

	public List<BalanceSheet> getAllBalanceSheet(String loginId) throws BIException;
	
	public void addBalanceSheet(BalanceSheet balanceSheet) throws BIException;
	
	public void updateBalanceSheet(BalanceSheet balanceSheet) throws BIException;
	
	public void deleteBalanceSheet(BalanceSheet balanceSheet) throws BIException;
	
	public List<Map<String, String>> getAllOrgUnitNames(String loginId);
	
	public List<Map<String, String>> getAllBiDeskNames(String loginId);
}
