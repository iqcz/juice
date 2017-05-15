package cn.javass.user.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceHolder {

    private static final BasicDataSource ds = new BasicDataSource();

    static {

	// this is for oracle driver
	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	ds.setUsername("scott");
	ds.setPassword("TIGER");
	
	// this is for mysql driver
	
//	ds.setDriverClassName("com.mysql.jdbc.Driver");
//	ds.setUrl("jdbc:mysql://localhost:3306/demo");
//	ds.setUsername("root");
//	ds.setPassword("admin");
    }

    public static final DataSource getDs() {
	return ds;
    }
}
