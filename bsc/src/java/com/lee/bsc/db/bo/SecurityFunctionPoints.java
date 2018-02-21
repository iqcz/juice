package com.lee.bsc.db.bo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.lee.bsc.bean.BIBaseBean;
import com.lee.util.StringUtil;

public class SecurityFunctionPoints extends BIBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3208609324972041408L;

	private Integer functionId;

	private String functionName;

	private Integer type;

	private String action;

	private Integer inactive;

	private String description;

	private String updateUserId;

	private Date recordTimestamp;

	public Integer getFunctionId() {
		return functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public Integer getType() {
		return type;
	}

	public String getAction() {
		return action;
	}

	public Integer getInactive() {
		return inactive;
	}

	public String getDescription() {
		return description;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public Date getRecordTimestamp() {
		return recordTimestamp;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public void setRecordTimestamp(Date recordTimestamp) {
		this.recordTimestamp = recordTimestamp;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(functionId).append(functionName).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (null == other) {
			return false;
		}
		if (!(other instanceof SecurityFunctionPoints)) {
			return false;
		}
		if (this == other) {
			return true;
		}

		SecurityFunctionPoints castOther = (SecurityFunctionPoints) other;

		return new EqualsBuilder().append(this.getFunctionId(), castOther.getFunctionId())
				.append(this.getFunctionName(), castOther.getFunctionName()).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, StringUtil.getToStringStyle()).append("functionId", functionId)
				.append("functionName", functionName).toString();
	}

}
