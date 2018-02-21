package com.lee.bsc.service;

import java.util.List;

import com.lee.bsc.BIException;
import com.lee.bsc.bean.SelectBoxBean;
import com.lee.bsc.db.bo.BalanceSheet;

public interface BalanceSheetService {

	public List<BalanceSheet> getAllBalanceSheet(String loginId) throws BIException;
	
	public void addBalanceSheet(BalanceSheet balanceSheet) throws BIException;
	
	public void updateBalanceSheet(BalanceSheet balanceSheet) throws BIException;
	
	public void deleteBalanceSheet(BalanceSheet balanceSheet) throws BIException;
	
	public List<SelectBoxBean> getAllOrgUnitNames(String loginId) throws BIException;
	
	public List<SelectBoxBean> getAllBIDeskNames(String loginId) throws BIException;
}
