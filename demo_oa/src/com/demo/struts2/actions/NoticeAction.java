package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.hibernate.beans.Notice;
import com.demo.hibernate.dao.NoticeDAO;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.Pager;

public class NoticeAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private NoticeDAO noticeDAO;

	protected String id = null;

	protected String sender = null;

	protected String title = null;

	protected String content = null;

	protected String sendtime = null;


	// �������޸�ʱִ�б���֤
	public void validate() {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ���������
		String queryString = getRequestPath();
		if (queryString.indexOf("noticeadd!insert") != -1
				|| queryString.indexOf("noticeedit!update") != -1) {
			// �����ֶ�title
			if (title == null || title.equals("")) {
				addFieldError("title",getText("notice.error.title"));
			}

			// �����ֶ�content
			if (content == null || content.equals("")) {
				addFieldError("content", getText("notice.error.content"));
			}
		}
	}

	// ����noticeInit.do�Ĵ�����
	public String init() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �����ҳ����
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getNoticeDAO().findPager(super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_NOTICE, super.pager);

		return Constants.LIST_KEY;
	}

	// ����noticeList.do�Ĵ�����
	public String list() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getNoticeDAO().findPager(super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_NOTICE, super.pager);

		return Constants.LIST_KEY;
	}

	// ����noticeAdd.do�Ĵ�����
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
		setSender(null);
		setTitle(null);
		setContent(null);
		setSendtime(null);
	}

	// �����ֶθ�ֵ
	private void bean2Form(Notice notice) {
		setId(notice.getId().toString());
		setSender(notice.getSender());
		setTitle(notice.getTitle());
		setContent(notice.getContent());
		setSendtime(notice.getSendtime());
	}

	// ����noticeEdit.do�Ĵ�����
	public String edit() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("notice.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ��ѯ���ݱ�
			Notice notice = this.getNoticeDAO().findById(id);

			// ������ʱ���ش���
			if (notice == null) {
				saveActionError("notice.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// �����ֶθ�ֵ
				bean2Form(notice);
				return Constants.EDIT_KEY;
			}
		}
	}

	// ����noticeInsert.do�Ĵ�����
	public String insert() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();
		
		// �������ݱ�
		Notice notice = new Notice();
		notice.setSender(super.getLoginUsername());
		notice.setTitle(this.getTitle());
		notice.setContent(this.getContent());
		notice.setSendtime(this.getSendtime());
		this.getNoticeDAO().insert(notice);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_NOTICE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getNoticeDAO().findPager(super.pageSize, super.pageNo);
		
		// ����ɹ���Ϣ
		saveActionMessage("notice.message.add.success");
		return Constants.LIST_KEY;
	}

	// ����noticeUpdate.do�Ĵ�����
	public String update() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �������ݱ�
		Notice notice = new Notice();
		notice.setId(new Integer(id));
		notice.setSender(super.getLoginUsername());
		notice.setTitle(this.getTitle());
		notice.setContent(this.getContent());
		notice.setSendtime(this.getSendtime());
		this.getNoticeDAO().update(notice);

		// �����ֶθ�ֵ
		bean2Form(notice);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_NOTICE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getNoticeDAO().findPager(super.pageSize, super.pageNo);

		saveActionMessage("notice.message.edit.success");
		return Constants.LIST_KEY;

	}

	// ����noticeDelete.do�Ĵ�����
	public String delete() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("notice.message.edit.notexist");
		} else {
			// ɾ������
			this.getNoticeDAO().delete(id);
			saveActionMessage("notice.message.delete.success");
		}
		// ȡ�õ�ǰҳ������
		super.pager = this.getNoticeDAO().findPager(super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public String getSendtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		sendtime = f.format(new Date());
		return sendtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
