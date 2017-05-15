package cn.javass.user.action;

import java.util.List;

import cn.javass.user.business.ebi.UserEbi;
import cn.javass.user.business.factory.UserEbiFactory;
import cn.javass.user.model.UserModel;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 全部
 * @author Administrator
 *
 */
public class UserToListAction extends ActionSupport{

	
	private List<UserModel> users;
	public List<UserModel> getUsers() {
		return users;
	}

	//无论传值还是接值，都新建外边看得到的属性【private 属性+getter/setter】
	@Override
	public String execute() throws Exception {
		
		UserEbi ebi = UserEbiFactory.getUserEbi();
		users = ebi.getAll(1, 99);
		
		return super.execute();
	}
}
