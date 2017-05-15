package cn.javass.user.action;

import java.util.List;

import cn.javass.user.UserConstant;
import cn.javass.user.business.ebi.UserEbi;
import cn.javass.user.business.factory.UserEbiFactory;
import cn.javass.user.model.UserModel;
import cn.javass.user.model.UserQueryModel;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 全部
 * @author Administrator
 *
 */
public class UserQueryAction extends ActionSupport{

	private String[] sexes = UserConstant.sexes;
	public String[] getSexes() {
		return sexes;
	}
	public void setSexes(String[] sexes) {
		this.sexes = sexes;
	}
	
	private UserQueryModel uqm;
	private List<UserModel> users;
	public List<UserModel> getUsers() {
		return users;
	}
	public UserQueryModel getUqm() {
		return uqm;
	}
	public void setUqm(UserQueryModel uqm) {
		this.uqm = uqm;
	}
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}


	//无论传值还是接值，都新建外边看得到的属性【private 属性+getter/setter】
	@Override
	public String execute() throws Exception {
		
		UserEbi ebi = UserEbiFactory.getUserEbi();
		users = ebi.getByCondition(uqm, 1, 99);
		
		return super.execute();
	}
}
