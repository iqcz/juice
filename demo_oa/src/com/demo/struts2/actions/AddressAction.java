package com.demo.struts2.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.Address;
import com.demo.hibernate.dao.AddressDAO;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.struts2.util.Pager;
import com.demo.struts2.util.RegExpression;

public class AddressAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private AddressDAO addressDAO;

	protected String id = null;

	protected String username = null;

	protected String name = null;

	protected String sex = null;

	protected String mobile = null;

	protected String email = null;

	protected String qq = null;

	protected String company = null;

	protected String address = null;

	protected String postcode = null;

	// �������޸�ʱִ�б���֤
	public void validate() {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ���������
		String queryString = getRequestPath();
		if (queryString.indexOf("addressadd!insert") != -1
				|| queryString.indexOf("addressedit!update") != -1) {
			// �����ֶ�name
			if (name == null || name.equals("")) {
				addFieldError("name", getText("address.error.name"));
			}

			// �����ֶ�mobile
			if (mobile != null && !mobile.equals("")) {
				Pattern p_mobile = Pattern.compile(RegExpression.REG_mobile);
				Matcher m_mobile = p_mobile.matcher(mobile);
				if (!m_mobile.find()) {
					addFieldError("mobile", getText("address.error.mobile"));
				}
			}

			// �����ֶ�email
			if (email != null && !email.equals("")) {
				Pattern p_email = Pattern.compile(RegExpression.REG_email);
				Matcher m_email = p_email.matcher(email);
				if (!m_email.find()) {
					addFieldError("email", getText("address.error.email"));
				}
			}

			// �����ֶ�postcode
			if (postcode != null && !postcode.equals("")) {
				Pattern p_postcode = Pattern
						.compile(RegExpression.REG_postcode);
				Matcher m_postcode = p_postcode.matcher(postcode);
				if (!m_postcode.find()) {
					addFieldError("postcode", getText("address.error.postcode"));
				}
			}
		}
	}

	// ����addressInit.do�Ĵ�����
	public String init() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �����ҳ����
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getAddressDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_ADDRESS, super.pager);

		return Constants.LIST_KEY;
	}

	// ����addressList.do�Ĵ�����
	public String list() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// ȡ�õ�ǰ��ҳ����
		super.pager = this.getAddressDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// �����ҳ����
		setSession(Constants.PAGER_ADDRESS, super.pager);

		return Constants.LIST_KEY;
	}

	// ����addressAdd.do�Ĵ�����
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
		setName(null);
		setSex(null);
		setMobile(null);
		setEmail(null);
		setQq(null);
		setCompany(null);
		setAddress(null);
		setPostcode(null);
	}

	// �����ֶθ�ֵ
	private void bean2Form(Address address) {
		setId(address.getId().toString());
		setUsername(address.getUsername());
		setName(address.getName());
		setSex(address.getSex());
		setMobile(address.getMobile());
		setEmail(address.getEmail());
		setQq(address.getQq());
		setCompany(address.getCompany());
		setAddress(address.getAddress());
		setPostcode(address.getPostcode());
	}

	// ����addressEdit.do�Ĵ�����
	public String edit() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("address.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ��ѯ���ݱ�
			Address address = this.getAddressDAO().findById(id);

			// ������ʱ���ش���
			if (address == null) {
				saveActionError("address.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// �����ֶθ�ֵ
				bean2Form(address);
				return Constants.EDIT_KEY;
			}
		}
	}

	// ����addressInsert.do�Ĵ�����
	public String insert() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �ж������Ƿ��Ѿ�����
		boolean b = this.getAddressDAO().isExist(super.getLoginUsername(), this.getName());
		if (!b) {
			// �������ݱ�
			Address address = new Address();
			address.setUsername(super.getLoginUsername());
			address.setName(this.getName());
			address.setSex(this.getSex());
			address.setMobile(this.getMobile());
			address.setEmail(this.getEmail());
			address.setQq(this.getQq());
			address.setCompany(this.getCompany());
			address.setAddress(this.getAddress());
			address.setPostcode(this.getPostcode());
			this.getAddressDAO().insert(address);
		}

		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_ADDRESS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getAddressDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		if (!b) {
			// ����ɹ���Ϣ
			saveActionMessage("address.message.add.success");
			return Constants.LIST_KEY;
		} else {
			// ����ʧ����Ϣ
			saveActionError("address.message.add.failed");
			return Constants.ADD_KEY;
		}

	}

	// ����addressUpdate.do�Ĵ�����
	public String update() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// �������ݱ�
		Address address = new Address();
		address.setId(new Integer(id));
		address.setUsername(super.getLoginUsername());
		address.setName(this.getName());
		address.setSex(this.getSex());
		address.setMobile(this.getMobile());
		address.setEmail(this.getEmail());
		address.setQq(this.getQq());
		address.setCompany(this.getCompany());
		address.setAddress(this.getAddress());
		address.setPostcode(this.getPostcode());
		this.getAddressDAO().update(address);

		// �����ֶθ�ֵ
		bean2Form(address);
		
		// ȡ�û���ķ�ҳ����
		Pager pagerSession = (Pager) getSession(Constants.PAGER_ADDRESS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// ��ѯ��ǰҳ������
		super.pager = this.getAddressDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("address.message.edit.success");
		return Constants.LIST_KEY;

	}

	// ����addressDelete.do�Ĵ�����
	public String delete() throws Exception {
		// ���������Ϣ
		clearErrorsAndMessages();

		// idΪ��ʱ���ش���
		if (this.getId() == null) {
			saveActionError("address.message.edit.notexist");
		} else {
			// ɾ������
			this.getAddressDAO().delete(id);
			saveActionMessage("address.message.delete.success");
		}
		// ȡ�õ�ǰҳ������
		super.pager = this.getAddressDAO().findPagerByUsername(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
