package com.lee.bsc.db.bo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.lee.util.StringUtil;

public class GroupPermissionConfigure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7109658310880766387L;

	private String groupId;

	private String category;

	private String value;

	private String updateUserId;

	private Date recordTimestamp;

	public String getGroupId() {
		return groupId;
	}

	public String getCategory() {
		return category;
	}

	public String getValue() {
		return value;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public Date getRecordTimestamp() {
		return recordTimestamp;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public void setRecordTimestamp(Date recordTimestamp) {
		this.recordTimestamp = recordTimestamp;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(groupId).append(category).append(value).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if(null == other) {
			return false;
		}
		if (!(other instanceof GroupPermissionConfigure)) {
			return false;
		}
		if(this == other) {
			return true;
		}

		GroupPermissionConfigure castOther = (GroupPermissionConfigure) other;

		return new EqualsBuilder().append(this.getGroupId(), castOther.getGroupId())
				.append(this.getCategory(), castOther.getCategory()).append(this.getValue(), castOther.getValue())
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, StringUtil.getToStringStyle()).append("groupId", groupId)
				.append("category", category).append("value", value).toString();
	}

}
