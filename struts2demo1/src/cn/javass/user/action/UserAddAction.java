package cn.javass.user.action;

import cn.javass.user.business.ebi.UserEbi;
import cn.javass.user.business.factory.UserEbiFactory;
import cn.javass.user.model.UserModel;

import com.opensymphony.xwork2.ActionSupport;

public class UserAddAction extends ActionSupport{
	
	/**
     * 
     */
    private static final long serialVersionUID = 4314963171938067180L;
	private UserModel user;
	private boolean flag;

	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		
		UserEbi ebi = UserEbiFactory.getUserEbi();
		flag = ebi.create(user);
		
		return super.execute();
	}
}
