package com.lee.bsc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lee.bsc.BIException;
import com.lee.bsc.bean.SelectBoxBean;
import com.lee.bsc.db.bo.BalanceSheet;
import com.lee.bsc.db.dao.BalanceSheetDao;
import com.lee.bsc.service.BalanceSheetService;
import com.lee.bsc.service.GeneralService;

public class BalanceSheetServiceImpl implements BalanceSheetService {

	private static Logger logger = Logger.getLogger(BalanceSheetServiceImpl.class);

	private GeneralService generalService;

	private BalanceSheetDao balanceSheetDao;

	public GeneralService getGeneralService() {
		return generalService;
	}

	public void setGeneralService(GeneralService generalService) {
		this.generalService = generalService;
	}

	public BalanceSheetDao getBalanceSheetDao() {
		return balanceSheetDao;
	}

	public void setBalanceSheetDao(BalanceSheetDao balanceSheetDao) {
		this.balanceSheetDao = balanceSheetDao;
	}

	@Override
	public List<BalanceSheet> getAllBalanceSheet(String loginId) throws BIException {
		logger.debug("Start to get all the balance sheet from db.");
		
		List<BalanceSheet> list = new ArrayList<BalanceSheet>();
		
		try {
			list = balanceSheetDao.getAllBalanceSheet(loginId);
		} catch(Exception ex) {
			try{
				throw new BIException(2002, 0);
			} catch(BIException e) {
				e.printStackTrace();
			}
		}
 		
		logger.debug("End to get all the balance sheet from db.");
		
		return list;
	}

	@Override
	public void addBalanceSheet(BalanceSheet balanceSheet) throws BIException {
		logger.debug("");
		
		balanceSheetDao.addBalanceSheet(balanceSheet);
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
	public List<SelectBoxBean> getAllOrgUnitNames(String loginId) throws BIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SelectBoxBean> getAllBIDeskNames(String loginId) throws BIException {
		// TODO Auto-generated method stub
		return null;
	}
}
