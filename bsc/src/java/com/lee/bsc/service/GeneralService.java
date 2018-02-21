package com.lee.bsc.service;

import java.util.Date;
import java.util.List;

import com.lee.bsc.db.bo.BIConfiguration;

public interface GeneralService {

	public Object getBIConfiguration(Object inputObj) throws Exception;
	
	public List<BIConfiguration> getBIConfigurationEx(Object inputObj) throws Exception;
	
	public Object updateBIConfiguration(Object inputObj) throws Exception;
	
//	public DateValidityBean getDateValidity4PearlHierarchy() throws Exception;
	
//	public DateValidityBean getDateValidity4Estimation() throws Exception;
	
	public Date getPerviousMonthFromBusinessDay() throws Exception;
	
}
