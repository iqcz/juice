package cn.javass.user.action;

import cn.javass.user.UserConstant;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 跳转到添加页面之前
 * 给添加页面准备一些下拉框的值
 * @author Administrator
 *
 */
public class UserToQueryAction extends ActionSupport{

	private String[] sexes = UserConstant.sexes;
	public String[] getSexes() {
		return sexes;
	}
	public void setSexes(String[] sexes) {
		this.sexes = sexes;
	}

}
