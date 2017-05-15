package cn.javass.user.action;

import cn.javass.user.UserConstant;
import cn.javass.user.business.ebi.UserEbi;
import cn.javass.user.business.factory.UserEbiFactory;
import cn.javass.user.model.UserModel;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 跳转到添加页面之前
 * 给添加页面准备一些下拉框的值
 * @author Administrator
 *
 */
public class UserToUpdateAction extends ActionSupport{

	private String[] sexes = UserConstant.sexes;
	private UserModel user;
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public String[] getSexes() {
		return sexes;
	}
	public void setSexes(String[] sexes) {
		this.sexes = sexes;
	}
	
	@Override
	public String execute() throws Exception {
		
		int userId = user.getUserId();
		UserEbi ebi = UserEbiFactory.getUserEbi();
		user = ebi.getSingle(userId);
		
		return super.execute();
	}

	
}
