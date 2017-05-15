package cn.javass.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.javass.user.dao.DataSourceHolder;
import cn.javass.user.dao.dao.UserDAO;
import cn.javass.user.model.UserModel;
import cn.javass.user.model.UserQueryModel;

public class UserDAOJdbcImpl implements UserDAO {

    /**
     * 没写事务
     */
    @Override
    public boolean create(UserModel user) {

	final String sql = "insert into TBL_USER(USERID,NAME,SEX,AGE) values(?,?,?,?)";
	boolean flag = false;

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);

	    int count = 1;
	    ps.setInt(count++, user.getUserId());
	    ps.setString(count++, user.getName());
	    ps.setString(count++, user.getSex());
	    ps.setInt(count++, user.getAge());

	    int result = ps.executeUpdate();
	    if (result == 1) {
		flag = true;
	    }

	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return flag;
    }

    @Override
    public boolean update(UserModel user) {
	final String sql = "update TBL_USER set NAME=?,SEX=?,AGE=? where USERID=?";
	boolean flag = false;

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);

	    int count = 1;
	    ps.setString(count++, user.getName());
	    ps.setString(count++, user.getSex());
	    ps.setInt(count++, user.getAge());
	    ps.setInt(count++, user.getUserId());

	    int result = ps.executeUpdate();
	    if (result == 1) {
		flag = true;
	    }

	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return flag;
    }

    @Override
    public boolean delete(int userId) {
	final String sql = "delete from TBL_USER where USERID=?";
	boolean flag = false;

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);

	    int count = 1;
	    ps.setInt(count++, userId);

	    int result = ps.executeUpdate();
	    if (result == 1) {
		flag = true;
	    }

	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return flag;
    }

    @Override
    public UserModel getSingle(int userId) {

	UserModel user = null;

	final String sql = "select * from TBL_USER where USERID=?";

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);

	    int count = 1;
	    ps.setInt(count++, userId);

	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		user = new UserModel();
		user.setUserId(rs.getInt("userId"));
		user.setName(rs.getString("name"));
		user.setSex(rs.getString("sex"));
		user.setAge(rs.getInt("age"));
	    }

	    rs.close();
	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return user;
    }

    @Override
    /**
     * 聚合函数单用
     */
    public int getAllCount() {

	int count = 0;
	final String sql = "select count(*) cnt from TBL_USER";

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);

	    ResultSet rs = ps.executeQuery();
	    // TODO 聚合函数单用
	    rs.next();
	    count = rs.getInt("cnt");

	    rs.close();
	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return count;
    }

    @Override
    public List<UserModel> getAll(int firstRecord, int maxRecords) {

	List<UserModel> list = new ArrayList<UserModel>();

	final String nestSql = "select * from TBL_USER";
	StringBuffer buffer = new StringBuffer();
	buffer.append("select temp_a.* from(");
	buffer.append("select temp_b.*,rownum r from(");
	buffer.append(nestSql);
	buffer.append(") temp_b ) temp_a ");
	buffer.append(" where r>=? and r<?");

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(buffer.toString());

	    int count = 1;
	    ps.setInt(count++, firstRecord);
	    ps.setInt(count++, firstRecord + maxRecords);

	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		UserModel user = new UserModel();
		user.setUserId(rs.getInt("userId"));
		user.setName(rs.getString("name"));
		user.setSex(rs.getString("sex"));
		user.setAge(rs.getInt("age"));
		list.add(user);
	    }

	    rs.close();
	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return list;
    }

    private String generateWhere(UserQueryModel uqm) {

	StringBuffer buffer = new StringBuffer();

	if (uqm.getUserId() > 0) {
	    buffer.append(" and userId = ?");
	}
	if (uqm.getName() != null && uqm.getName().trim().length() > 0) {
	    buffer.append(" and name like ?");
	}
	if (uqm.getSex() != null && uqm.getSex().trim().length() > 0) {
	    buffer.append(" and sex = ?");
	}
	if (uqm.getAge() > 0) {
	    buffer.append(" and age >= ?");
	}
	if (uqm.getAge2() > 0) {
	    buffer.append(" and age <= ?");
	}

	return buffer.toString();
    }

    private int preparePs(PreparedStatement ps, UserQueryModel uqm) throws SQLException {

	int count = 1;

	if (uqm.getUserId() > 0) {
	    ps.setInt(count++, uqm.getUserId());
	}
	if (uqm.getName() != null && uqm.getName().trim().length() > 0) {
	    ps.setString(count++, "%" + uqm.getName() + "%");
	}
	if (uqm.getSex() != null && uqm.getSex().trim().length() > 0) {
	    ps.setString(count++, uqm.getSex());
	}
	if (uqm.getAge() > 0) {
	    ps.setInt(count++, uqm.getAge());
	}
	if (uqm.getAge2() > 0) {
	    ps.setInt(count++, uqm.getAge2());
	}

	return count;
    }

    @Override
    public int getByConditionCount(UserQueryModel uqm) {
	int count = 0;
	final String sql = "select count(*) cnt from TBL_USER where 1=1" + this.generateWhere(uqm);

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);

	    this.preparePs(ps, uqm);

	    ResultSet rs = ps.executeQuery();
	    // TODO 聚合函数单用
	    rs.next();
	    count = rs.getInt("cnt");

	    rs.close();
	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return count;
    }

    @Override
    public List<UserModel> getByCondition(UserQueryModel uqm, int firstRecord, int maxRecords) {
	List<UserModel> list = new ArrayList<UserModel>();

	final String nestSql = "select * from TBL_USER where 1=1" + this.generateWhere(uqm);
	StringBuffer buffer = new StringBuffer();
	buffer.append("select temp_a.* from(");
	buffer.append("select temp_b.*,rownum r from(");
	buffer.append(nestSql);
	buffer.append(") temp_b ) temp_a ");
	buffer.append(" where r>=? and r<?");

	Connection conn = null;
	try {

	    conn = DataSourceHolder.getDs().getConnection();
	    PreparedStatement ps = conn.prepareStatement(buffer.toString());

	    int count = this.preparePs(ps, uqm);
	    ps.setInt(count++, firstRecord);
	    ps.setInt(count++, firstRecord + maxRecords);

	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		UserModel user = new UserModel();
		user.setUserId(rs.getInt("userId"));
		user.setName(rs.getString("name"));
		user.setSex(rs.getString("sex"));
		user.setAge(rs.getInt("age"));
		list.add(user);
	    }

	    rs.close();
	    ps.close();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		conn.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}

	return list;
    }

    public static void main(String[] args) {

	UserModel user = new UserModel();
	user.setUserId(1);
	user.setName("a");
	user.setAge(11);
	user.setSex("男");

	UserDAO dao = new UserDAOJdbcImpl();
	System.out.println(dao.getAllCount());
	// System.out.println(dao.create(user));
	// for (UserModel temp:dao.getAll(10, 2)){
	// System.out.println(temp.getName());
	// }

    }
}
