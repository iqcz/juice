package cn.javass.user.business.ebo;

import java.util.List;

import cn.javass.user.business.ebi.UserEbi;
import cn.javass.user.dao.UserDAOFactory;
import cn.javass.user.dao.dao.UserDAO;
import cn.javass.user.model.UserModel;
import cn.javass.user.model.UserQueryModel;

/**
 * 最简单的时候，是【转发】【delegate】dao的方法
 * 别人调用ebo的什么方法，ebo就去调用dao的什么方法
 * @author Administrator
 *
 */
public class UserEbo implements UserEbi{

	private final UserDAO dao = UserDAOFactory.getUserDAO();

	public boolean create(UserModel user) {
		return dao.create(user);
	}

	public boolean update(UserModel user) {
		return dao.update(user);
	}

	public boolean delete(int userId) {
		return dao.delete(userId);
	}

	public UserModel getSingle(int userId) {
		return dao.getSingle(userId);
	}

	public int getAllCount() {
		return dao.getAllCount();
	}

	public List<UserModel> getAll(int firstRecord, int maxRecords) {
		return dao.getAll(firstRecord, maxRecords);
	}

	public int getByConditionCount(UserQueryModel uqm) {
		return dao.getByConditionCount(uqm);
	}

	public List<UserModel> getByCondition(UserQueryModel uqm, int firstRecord,
			int maxRecords) {
		return dao.getByCondition(uqm, firstRecord, maxRecords);
	}
	
	
}
