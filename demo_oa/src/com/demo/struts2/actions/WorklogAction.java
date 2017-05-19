package com.demo.struts2.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.Worklog;
import com.demo.hibernate.dao.WorklogDAO;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.Pager;
import com.demo.struts2.util.RegExpression;

public class WorklogAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private WorklogDAO worklogDAO;

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String title = null;

	protected String description = null;

	protected String logtime = null;
	
	// �������޸�ʱִ�б���֤
	public void validate() {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ���������
		String queryString = getRequestPath();
		if (queryString.indexOf("worklogadd!insert") != -1
				|| queryString.indexOf("worklogedit!update") != -1) {
			// �����ֶ�year
			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				addFieldError("year", getText("worklog.error.year"));
			}

			// �����ֶ�month
			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				addFieldError("month", getText("worklog.error.month"));
			}

			// �����ֶ�day
			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				addFieldError("day", getText("worklog.error.day"));
			}

			// �����ֶ�title
			if (title == null || title.equals("")) {
				addFieldError("title", getText("worklog.error.title"));
			}

			// �����ֶ�description
			if (description == null || description.equals("")) {
				addFieldError("description", getText("worklog.error.description"));
			}
		}
	}

	// ����worklogInit.do�Ĵ�����
	public String init() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �����ҳ����
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getWorklogDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_WORKLOG, super.pager);

		return Constants.LIST_KEY;
	}

	// ����worklogList.do�Ĵ�����
	public String list() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getWorklogDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_WORKLOG, super.pager);

		return Constants.LIST_KEY;
	}

	// ����worklogAdd.do�Ĵ�����
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
		setYear(null);
		setMonth(null);
		setDay(null);
		setTitle(null);
		setDescription(null);
		setLogtime(null);
	}

	// �����ֶθ�ֵ
	private void bean2Form(Worklog worklog) {
		setId(worklog.getId().toString());
		setUsername(worklog.getUsername());
		setYear(worklog.getYear().toString());
		setMonth(worklog.getMonth().toString());
		setDay(worklog.getDay().toString());
		setTitle(worklog.getTitle());
		setDescription(worklog.getDescription());
		setLogtime(worklog.getLogtime());
	}

	// ����worklogEdit.do�Ĵ�����
	public String edit() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("worklog.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ��ѯ���ݱ�
			Worklog worklog = this.getWorklogDAO().findById(id);

			// ������ʱ���ش���
			if (worklog == null) {
				saveActionError("worklog.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// �����ֶθ�ֵ
				bean2Form(worklog);
				return Constants.EDIT_KEY;
			}
		}
	}

	// ����worklogInsert.do�Ĵ�����
	public String insert() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();
		
		// �������ݱ�
		Worklog worklog = new Worklog();
		worklog.setUsername(super.getLoginUsername());
		worklog.setYear(Integer.valueOf(this.year));
		worklog.setMonth(Integer.valueOf(this.month));
		worklog.setDay(Integer.valueOf(this.day));
		worklog.setTitle(this.title);
		worklog.setDescription(this.description);
		worklog.setLogtime(getLogtime());
		this.getWorklogDAO().insert(worklog);		

		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_WORKLOG);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getWorklogDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);
	
		// ����ɹ���Ϣ
		saveActionMessage("worklog.message.add.success");
		return Constants.LIST_KEY;
	}

	// ����worklogUpdate.do�Ĵ�����
	public String update() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �������ݱ�
		Worklog worklog = new Worklog();
		worklog.setId(new Integer(id));
		worklog.setUsername(super.getLoginUsername());
		worklog.setYear(Integer.valueOf(this.getYear()));
		worklog.setMonth(Integer.valueOf(this.getMonth()));
		worklog.setDay(Integer.valueOf(this.getDay()));
		worklog.setTitle(this.getTitle());
		worklog.setDescription(this.getDescription());
		worklog.setLogtime(this.getLogtime());
		worklogDAO.update(worklog);

		// �����ֶθ�ֵ
		bean2Form(worklog);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_WORKLOG);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.worklogDAO.findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("worklog.message.edit.success");
		return Constants.LIST_KEY;

	}

	// ����worklogDelete.do�Ĵ�����
	public String delete() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("worklog.message.edit.notexist");
		} else {
			// ɾ������
			this.getWorklogDAO().delete(id);
			saveActionMessage("worklog.message.delete.success");
		}
		// ȡ�õ�ǰҳ������
		super.pager = this.getWorklogDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public WorklogDAO getWorklogDAO() {
		return worklogDAO;
	}

	public void setWorklogDAO(WorklogDAO worklogDAO) {
		this.worklogDAO = worklogDAO;
	}

	public String getLogtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		logtime = f.format(new Date());
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
