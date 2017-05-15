package cn.javass.user.dao;

import cn.javass.user.dao.dao.UserDAO;
import cn.javass.user.dao.impl.UserDAOJdbcImpl;

public class UserDAOFactory {

	public static UserDAO getUserDAO(){
		return new UserDAOJdbcImpl();
	}
}
