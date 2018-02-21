package com.lee.bsc.db.dao;

import java.util.Date;
import java.util.List;

import com.lee.bsc.db.bo.BIConfiguration;

public interface DateFinderDao {

	public List<BIConfiguration> getBIConfiguration(final BIConfiguration biConfig) throws Exception;
	
	public List<BIConfiguration> getBIConfigurationEx(final BIConfiguration biConfig) throws Exception;
	
//	public List<Date> getDateValidity(EnumDateValidity type) throws Exception;
	
//	public List<Date> getPreviousMonthDateFromBusinessDay() throws Exception;
}
