package cn.javass.user.business.ebi;

import java.util.List;

import cn.javass.user.model.UserModel;
import cn.javass.user.model.UserQueryModel;

public interface UserEbi {

	public boolean create(UserModel user);
	public boolean update(UserModel user);
	public boolean delete(int userId);
	
	public UserModel getSingle(int userId);
	public int getAllCount();
	public List<UserModel> getAll(int firstRecord,int maxRecords);
	public int getByConditionCount(UserQueryModel uqm);
	public List<UserModel> getByCondition(UserQueryModel uqm,int firstRecord,int maxRecords);
}
