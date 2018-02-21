package com.lee.bsc.db.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lee.bsc.db.bo.BIConfiguration;
import com.lee.bsc.db.dao.DateFinderDao;

public class DateFinderDaoImpl extends HibernateDaoSupport implements DateFinderDao {

	@Override
	public List<BIConfiguration> getBIConfiguration(final BIConfiguration biConfig) throws Exception {
		@SuppressWarnings("unchecked")
		List<BIConfiguration> list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.getNamedQuery("queryBIConfiguration");
				QueryHelper.fillParams4GetBIConfig(query, biConfig);
				
				List<?> list = query.list();
				return list;
			}
			
		});
		return list;
	}

	@Override
	public List<BIConfiguration> getBIConfigurationEx(final BIConfiguration biConfig) throws Exception {

		@SuppressWarnings("unchecked")
		List<BIConfiguration> list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.getNamedQuery("queryBIConfigurationEX");
				QueryHelper.fillParams4GetBIConfigEX(query, biConfig);
				
				List<?> list = query.list();
				return list;
			}
			
		});
		return list;
	}

//	@Override
//	public List<Date> getPreviousMonthDateFromBusinessDay() throws Exception {
//		return null;
//	}

}
