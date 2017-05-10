package com.demo.struts2.common;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.demo.struts2.util.Constants;
import com.opensymphony.xwork2.ActionContext;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = -7509152655359967096L;

	// ȡ�õ�ǰ��¼���û���
	protected String getLoginUsername() {
		return (String) ActionContext.getContext().getSession().get(Constants.USERNAME_KEY);
	}

	// �жϵ�ǰ�û��Ƿ�ʱ
	protected boolean isTimeout() {
		if (ActionContext.getContext().getSession().get(Constants.USERNAME_KEY) == null) {
			return true;
		} else {
			return false;
		}
	}

	// ���Session�����Ƿ����
	protected boolean isExistSession(String key) {
		if (ActionContext.getContext().getSession().get(key) != null) {
			return true;
		} else {
			return false;
		}
	}

	// ����Session����
	protected void setSession(String key, Object obj) {
		ActionContext.getContext().getSession().put(key, obj);
	}

	// ȡ��Session����
	protected Object getSession(String key) {
		return ActionContext.getContext().getSession().get(key);
	}

	// ����һ������
	protected void saveActionError(String key) {
		super.addActionError(super.getText(key));
	}

	// ����һ����Ϣ
	protected void saveActionMessage(String key) {
		super.addActionMessage(super.getText(key));
	}

	// ȡ�ò�ѯ��URL
	protected String getRequestPath() {
		return (String) ServletActionContext.getRequest().getServletPath();
	}
}
