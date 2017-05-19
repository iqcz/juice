package com.demo.struts2.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.Schedule;
import com.demo.hibernate.dao.ScheduleDAO;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.Pager;
import com.demo.struts2.util.RegExpression;

public class ScheduleAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private ScheduleDAO scheduleDAO;

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String plan = null;


	// �������޸�ʱִ�б���֤
	public void validate() {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ���������
		String queryString = getRequestPath();
		if (queryString.indexOf("scheduleadd!insert") != -1
				|| queryString.indexOf("scheduleedit!update") != -1) {
			
			// �����ֶ�year
			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				addFieldError("year", getText("schedule.error.year"));
			}
			
			// �����ֶ�month
			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				addFieldError("month", getText("schedule.error.month"));
			}
			
			// �����ֶ�day
			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				addFieldError("day", getText("schedule.error.day"));
			}

			// �����ֶ�plan
			if (plan == null || plan.equals("")) {
				addFieldError("plan", getText("schedule.error.plan"));
			}
		}
	}

	// ����scheduleInit.do�Ĵ�����
	public String init() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �����ҳ����
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getScheduleDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_SCHEDULE, super.pager);

		return Constants.LIST_KEY;
	}

	// ����scheduleList.do�Ĵ�����
	public String list() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getScheduleDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_SCHEDULE, super.pager);

		return Constants.LIST_KEY;
	}

	// ����scheduleAdd.do�Ĵ�����
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
		setPlan(null);
	}

	// �����ֶθ�ֵ
	private void bean2Form(Schedule schedule) {
		setId(schedule.getId().toString());
		setUsername(schedule.getUsername());
		setYear(schedule.getYear().toString());
		setMonth(schedule.getMonth().toString());
		setDay(schedule.getDay().toString());
		setPlan(schedule.getPlan());
	}

	// ����scheduleEdit.do�Ĵ�����
	public String edit() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("schedule.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ��ѯ���ݱ�
			Schedule schedule = this.getScheduleDAO().findById(id);

			// ������ʱ���ش���
			if (schedule == null) {
				saveActionError("schedule.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// �����ֶθ�ֵ
				bean2Form(schedule);
				return Constants.EDIT_KEY;
			}
		}
	}

	// ����scheduleInsert.do�Ĵ�����
	public String insert() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();
		
		// �������ݱ�
		Schedule schedule = new Schedule();
		schedule.setUsername(super.getLoginUsername());
		schedule.setYear(Integer.valueOf(this.getYear()));
		schedule.setMonth(Integer.valueOf(this.getMonth()));
		schedule.setDay(Integer.valueOf(this.getDay()));
		schedule.setPlan(this.getPlan());
		this.getScheduleDAO().insert(schedule);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SCHEDULE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getScheduleDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		
		// ����ɹ���Ϣ
		saveActionMessage("schedule.message.add.success");
		return Constants.LIST_KEY;
	}

	// ����scheduleUpdate.do�Ĵ�����
	public String update() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �������ݱ�
		Schedule schedule = new Schedule();
		schedule.setId(new Integer(id));
		schedule.setUsername(super.getLoginUsername());
		schedule.setYear(Integer.valueOf(this.getYear()));
		schedule.setMonth(Integer.valueOf(this.getMonth()));
		schedule.setDay(Integer.valueOf(this.getDay()));
		schedule.setPlan(this.getPlan());
		this.getScheduleDAO().update(schedule);

		// �����ֶθ�ֵ
		bean2Form(schedule);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SCHEDULE);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getScheduleDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("schedule.message.edit.success");
		return Constants.LIST_KEY;

	}

	// ����scheduleDelete.do�Ĵ�����
	public String delete() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("schedule.message.edit.notexist");
		} else {
			// ɾ������
			scheduleDAO.delete(id);
			saveActionMessage("schedule.message.delete.success");
		}
		// ȡ�õ�ǰҳ������
		super.pager = this.getScheduleDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
