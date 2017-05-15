package cn.javass.user.business.factory;

import cn.javass.user.business.ebi.UserEbi;
import cn.javass.user.business.ebo.UserEbo;

public class UserEbiFactory {

	public static UserEbi getUserEbi(){
		return new UserEbo();
	}
}
