package com.lee.bsc.action.exception;

import com.lee.bsc.action.BIBaseAction;

public class NotAuthorizedAction extends BIBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4102018419889762295L;

	public NotAuthorizedAction() {

	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
