package com.lee.bsc.db.bo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.lee.bsc.bean.BIBaseBean;
import com.lee.util.StringUtil;

public class BalanceSheet extends BIBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9150949715563318211L;

	private int seqNo;

	private String orgUnitName;

	private String biDeskName;

	private String product;

	private float balanceLimit;

	private String dailyDollar;

	private String note;

	private String updateUserId;

	private Date recordTimestamp;

	public int getSeqNo() {
		return seqNo;
	}

	public String getOrgUnitName() {
		return orgUnitName;
	}

	public String getBiDeskName() {
		return biDeskName;
	}

	public String getProduct() {
		return product;
	}

	public float getBalanceLimit() {
		return balanceLimit;
	}

	public String getDailyDollar() {
		return dailyDollar;
	}

	public String getNote() {
		return note;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public Date getRecordTimestamp() {
		return recordTimestamp;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public void setOrgUnitName(String orgUnitName) {
		this.orgUnitName = orgUnitName;
	}

	public void setBiDeskName(String biDeskName) {
		this.biDeskName = biDeskName;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setBalanceLimit(float balanceLimit) {
		this.balanceLimit = balanceLimit;
	}

	public void setDailyDollar(String dailyDollar) {
		this.dailyDollar = dailyDollar;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public void setRecordTimestamp(Date recordTimestamp) {
		this.recordTimestamp = recordTimestamp;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(seqNo).append(seqNo).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (null == other) {
			return false;
		}
		if (!(other instanceof BalanceSheet)) {
			return false;
		}
		if (this == other) {
			return true;
		}

		BalanceSheet castOther = (BalanceSheet) other;

		return new EqualsBuilder().append(this.getSeqNo(), castOther.getSeqNo()).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, StringUtil.getToStringStyle()).append("orgUniName", orgUnitName)
				.append("biDeskName", biDeskName).append("product", product).toString();
	}

}
