package com.demo.javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

    private String drv = "com.mysql.jdbc.Driver";

    private String url = "jdbc:mysql://localhost:3306/demo";

    private String usr = "root";

    private String pwd = "admin";

    private Connection conn = null;

    private Statement stm = null;

    private ResultSet rs = null;

    public boolean createConn() {
	boolean isConnectted = false;
	
	try {
	    Class.forName(drv).newInstance();
	    conn = DriverManager.getConnection(url, usr, pwd);
	    
	    isConnectted = true;
	} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	}
	return isConnectted;
    }

    public boolean update(String sql) {
	boolean isUpdated = false;
	try {
	    stm = conn.createStatement();
	    stm.execute(sql);
	    
	    isUpdated = true;
	} catch (Exception e) {
	    System.out.println(e.toString());
	}
	
	return isUpdated;
    }

    public void query(String sql) {
	try {
	    stm = conn.createStatement();
	    rs = stm.executeQuery(sql);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public boolean next() {
	boolean hasNext = false;
	
	try {
	    if (rs.next())
		hasNext = true;
	} catch (Exception e) {
	}
	return hasNext;
    }

    public String getValue(String field) {
	String value = "";
	try {
	    if (rs != null) {
		value = rs.getString(field);
	    }
	} catch (Exception e) {
	}
	return value;
    }

    public void closeConn() {
	try {
	    if (conn != null)
		conn.close();
	} catch (SQLException e) {
	}
    }

    public void closeStm() {
	try {
	    if (stm != null)
		stm.close();
	} catch (SQLException e) {
	}
    }

    public void closeRs() {
	try {
	    if (rs != null)
		rs.close();
	} catch (SQLException e) {
	}
    }

    public Connection getConn() {
	return conn;
    }

    public void setConn(Connection conn) {
	this.conn = conn;
    }

    public String getDrv() {
	return drv;
    }

    public void setDrv(String drv) {
	this.drv = drv;
    }

    public String getPwd() {
	return pwd;
    }

    public void setPwd(String pwd) {
	this.pwd = pwd;
    }

    public ResultSet getRs() {
	return rs;
    }

    public void setRs(ResultSet rs) {
	this.rs = rs;
    }

    public Statement getStm() {
	return stm;
    }

    public void setStm(Statement stm) {
	this.stm = stm;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getUsr() {
	return usr;
    }

    public void setUsr(String usr) {
	this.usr = usr;
    }
}
