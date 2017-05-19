package com.demo.struts2.actions;

import com.demo.hibernate.beans.Meeting;
import com.demo.hibernate.dao.MeetingDAO;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.Pager;

public class MeetingAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private MeetingDAO meetingDAO;

	protected String id = null;

	protected String sender = null;

	protected String starttime = null;

	protected String endtime = null;

	protected String address = null;

	protected String title = null;

	protected String content = null;


	// �������޸�ʱִ�б���֤
	public void validate() {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ���������
		String queryString = getRequestPath();
		if (queryString.indexOf("meetingadd!insert") != -1
				|| queryString.indexOf("meetingedit!update") != -1) {
			// �����ֶ�title
			if (title == null || title.equals("")) {
				addFieldError("title",getText("meeting.error.title"));
			}

			// �����ֶ�content
			if (content == null || content.equals("")) {
				addFieldError("content", getText("meeting.error.content"));
			}
		}
	}

	// ����meetingInit.do�Ĵ�����
	public String init() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �����ҳ����
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getMeetingDAO().findPager(super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_MEETING, super.pager);

		return Constants.LIST_KEY;
	}

	// ����meetingList.do�Ĵ�����
	public String list() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getMeetingDAO().findPager(super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_MEETING, super.pager);

		return Constants.LIST_KEY;
	}

	// ����meetingAdd.do�Ĵ�����
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
		setStarttime(null);
		setEndtime(null);
		setAddress(null);
		setTitle(null);
		setContent(null);
	}

	// �����ֶθ�ֵ
	private void bean2Form(Meeting meeting) {
		setId(meeting.getId().toString());
		setSender(meeting.getSender());
		setStarttime(meeting.getStarttime());
		setEndtime(meeting.getEndtime());
		setAddress(meeting.getAddress());
		setTitle(meeting.getTitle());
		setContent(meeting.getContent());
	}

	// ����meetingEdit.do�Ĵ�����
	public String edit() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("meeting.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ��ѯ���ݱ�
			Meeting meeting = this.getMeetingDAO().findById(id);

			// ������ʱ���ش���
			if (meeting == null) {
				saveActionError("meeting.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// �����ֶθ�ֵ
				bean2Form(meeting);
				return Constants.EDIT_KEY;
			}
		}
	}

	// ����meetingInsert.do�Ĵ�����
	public String insert() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();
		
		// �������ݱ�
		Meeting meeting = new Meeting();
		meeting.setSender(super.getLoginUsername());
		meeting.setStarttime(this.getStarttime());
		meeting.setEndtime(this.getEndtime());
		meeting.setAddress(this.getAddress());
		meeting.setTitle(this.getTitle());
		meeting.setContent(this.getContent());
		this.getMeetingDAO().insert(meeting);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_MEETING);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getMeetingDAO().findPager(super.pageSize, super.pageNo);
		
		// ����ɹ���Ϣ
		saveActionMessage("meeting.message.add.success");
		return Constants.LIST_KEY;
	}

	// ����meetingUpdate.do�Ĵ�����
	public String update() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �������ݱ�
		Meeting meeting = new Meeting();
		meeting.setId(new Integer(id));
		meeting.setSender(super.getLoginUsername());
		meeting.setStarttime(this.getStarttime());
		meeting.setEndtime(this.getEndtime());
		meeting.setAddress(this.getAddress());
		meeting.setTitle(this.getTitle());
		meeting.setContent(this.getContent());
		this.getMeetingDAO().update(meeting);

		// �����ֶθ�ֵ
		bean2Form(meeting);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_MEETING);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getMeetingDAO().findPager(super.pageSize, super.pageNo);

		saveActionMessage("meeting.message.edit.success");
		return Constants.LIST_KEY;

	}

	// ����meetingDelete.do�Ĵ�����
	public String delete() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("meeting.message.edit.notexist");
		} else {
			// ɾ������
			this.getMeetingDAO().delete(id);
			saveActionMessage("meeting.message.delete.success");
		}
		// ȡ�õ�ǰҳ������
		super.pager = this.getMeetingDAO().findPager(super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public MeetingDAO getMeetingDAO() {
		return meetingDAO;
	}

	public void setMeetingDAO(MeetingDAO meetingDAO) {
		this.meetingDAO = meetingDAO;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
