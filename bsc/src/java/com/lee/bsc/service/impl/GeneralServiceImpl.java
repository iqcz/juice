package com.lee.bsc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.lee.bsc.db.bo.BIConfiguration;
import com.lee.bsc.db.dao.DataPersisterDao;
import com.lee.bsc.db.dao.DateFinderDao;
import com.lee.bsc.service.GeneralService;

public class GeneralServiceImpl implements GeneralService {
	
	private static Logger logger = Logger.getLogger(GeneralServiceImpl.class);
	
	private DateFinderDao dateFinderDao;
	
	private DataPersisterDao dataPersisterDao;

	@Override
	public Object getBIConfiguration(Object inputObj) throws Exception {
		return null;
	}

	@Override
	public List<BIConfiguration> getBIConfigurationEx(Object inputObj) throws Exception {
		return null;
	}

	@Override
	public Object updateBIConfiguration(Object inputObj) throws Exception {
		return null;
	}

	@Override
	public Date getPerviousMonthFromBusinessDay() throws Exception {
		return null;
	}

	public DateFinderDao getDateFinderDao() {
		return dateFinderDao;
	}

	public DataPersisterDao getDataPersisterDao() {
		return dataPersisterDao;
	}

	public void setDateFinderDao(DateFinderDao dateFinderDao) {
		this.dateFinderDao = dateFinderDao;
	}

	public void setDataPersisterDao(DataPersisterDao dataPersisterDao) {
		this.dataPersisterDao = dataPersisterDao;
	}
	
}
