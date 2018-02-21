package com.lee.bsc.db.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.lee.bsc.db.bo.BIConfiguration;

public class QueryHelper {

	private static Logger logger = Logger.getLogger(QueryHelper.class);

	private static enum WildChar {
		Prefix, Suffix, Both
	};

	public static void fillParams4GetBIConfig(Query query, BIConfiguration biConfig) {
		query.setString(0, biConfig.getKey1());
		query.setString(1, biConfig.getKey2());
		query.setString(2, biConfig.getKey3());
	}

	public static void fillParams4GetBIConfigEX(Query query, BIConfiguration biConfig) {
		query.setString("key1", biConfig.getKey1());
		query.setString("key2", biConfig.getKey2());
		query.setString("key3", biConfig.getKey3());
	}

}
