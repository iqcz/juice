package com.lee.bsc.db.dao;

import com.lee.bsc.db.bo.BIConfiguration;

public interface DataPersisterDao {

	public void updateBIConfiguration(final BIConfiguration biConfig) throws Exception;
	
	public void updateBIConfigurationEX(final BIConfiguration biConfig) throws Exception;
	
	public int insertOrUpdateBIConfiguration(final BIConfiguration biConfig) throws Exception;
}
