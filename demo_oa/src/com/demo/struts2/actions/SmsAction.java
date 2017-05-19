package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.hibernate.beans.Sms;
import com.demo.hibernate.dao.SmsDAO;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.Pager;

public class SmsAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private SmsDAO smsDAO;

	protected String id = null;

	protected String username = null;

	protected String sender = null;

	protected String message = null;

	protected String sendtime = null;

	protected String isread = null;

	// �������޸�ʱִ�б���֤
	public void validate() {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ���������
		String queryString = getRequestPath();
		if (queryString.indexOf("smsadd!insert") != -1
				|| queryString.indexOf("smsedit!update") != -1) {
			// �����ֶ�username
			if (username == null || username.equals("")) {
				addFieldError("username",getText("sms.error.username"));
			}

			// �����ֶ�message
			if (message == null || message.equals("")) {
				addFieldError("message", getText("sms.error.message"));
			}
		}
	}

	// ����smsInit.do�Ĵ�����
	public String init() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �����ҳ����
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getSmsDAO().findPagerByUsername(super.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_SMS, super.pager);

		return Constants.LIST_KEY;
	}

	// ����smsList.do�Ĵ�����
	public String list() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getSmsDAO().findPagerByUsername(super.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_SMS, super.pager);

		return Constants.LIST_KEY;
	}

	// ����smsAdd.do�Ĵ�����
	public String add() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ��������ֶ�
		reset();
		return Constants.ADD_KEY;
	}

	// ��������ֶ�
	private void reset() {
		setId(null);
		setUsername(null);
		setSender(null);
		setMessage(null);
		setSendtime(null);
		setIsread(null);
	}

	// ����smsInsert.do�Ĵ�����
	public String insert() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();
		
		// �������ݱ�
		Sms sms = new Sms();
		sms.setUsername(this.getUsername());
		sms.setSender(super.getLoginUsername());
		sms.setMessage(this.getMessage());
		sms.setSendtime(this.getSendtime());
		sms.setIsread("0");
		this.getSmsDAO().insert(sms);		
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SMS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getSmsDAO().findPagerByUsername(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ����ɹ���Ϣ
		saveActionMessage("sms.message.add.success");
		return Constants.LIST_KEY;
	}

	// ����smsRead.do�Ĵ�����
	public String read() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("sms.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ��ѯ���ݱ�
			Sms sms = this.getSmsDAO().findById(id);

			// ������ʱ���ش���
			if (sms == null) {
				saveActionError("sms.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// �����ֶθ�ֵ
				sms.setIsread("1");
				this.getSmsDAO().update(sms);
				
				// ȡ�û���ķ�ҳ����
				Pager pagerSession = (Pager) getSession(Constants.PAGER_SMS);
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();

				// ��ѯ��ǰҳ������
				super.pager = this.getSmsDAO().findPagerByUsername(super.getLoginUsername(), super.pageSize, super.pageNo);
				
				return Constants.LIST_KEY;
			}
		}
	}	

	// ����smsDelete.do�Ĵ�����
	public String delete() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("sms.message.edit.notexist");
		} else {
			// ɾ������
			this.getSmsDAO().delete(id);
			saveActionMessage("sms.message.delete.success");
		}
		// ȡ�õ�ǰҳ������
		super.pager = this.getSmsDAO().findPagerByUsername(super.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public SmsDAO getSmsDAO() {
		return smsDAO;
	}

	public void setSmsDAO(SmsDAO smsDAO) {
		this.smsDAO = smsDAO;
	}

	public String getSendtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		sendtime = f.format(new Date());
		return sendtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
