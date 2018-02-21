package com.lee.bsc.db.dao.impl;

import java.sql.SQLException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lee.bsc.db.bo.BIConfiguration;
import com.lee.bsc.db.dao.DataPersisterDao;

public class DataPersisterDaoImpl extends HibernateDaoSupport implements DataPersisterDao {

	@Override
	public void updateBIConfiguration(final BIConfiguration biConfig) throws Exception {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.getNamedQuery("updateBIConfiguration");
				query.setString(0, biConfig.getKeyValue());
				query.setString(1, biConfig.getKey1());
				query.setString(2, biConfig.getKey2());
				query.setString(3, biConfig.getKey3());

				return null;
			}

		});
	}

	@Override
	public void updateBIConfigurationEX(final BIConfiguration biConfig) throws Exception {
		Session session = getSession(true);
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.update(biConfig);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(ExceptionUtils.getStackTrace(e), e);
		} finally {
			releaseSession(session);
		}
	}

	@Override
	public int insertOrUpdateBIConfiguration(BIConfiguration biConfig) throws Exception {
		int ret = 0;
		Session session = getSession(true);
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			session.saveOrUpdate(biConfig);

			trans.commit();
			ret = 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(ExceptionUtils.getStackTrace(e), e);
		} finally {
			releaseSession(session);
		}
		return ret;
	}

}
