package com.lee.bsc.db.bo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.lee.util.StringUtil;

public class BIConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4881612656119707962L;

	private String key1;

	private String key2;

	private String key3;

	private String keyValue;

	private Date recordTimestamp;

	public String getKey1() {
		return key1;
	}

	public String getKey2() {
		return key2;
	}

	public String getKey3() {
		return key3;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public Date getRecordTimestamp() {
		return recordTimestamp;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public void setRecordTimestamp(Date recordTimestamp) {
		this.recordTimestamp = recordTimestamp;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(key1).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (null == other) {
			return false;
		}
		if (!(other instanceof BIConfiguration)) {
			return false;
		}
		if (this == other) {
			return true;
		}

		BIConfiguration castOther = (BIConfiguration) other;

		return new EqualsBuilder().append(this.getKey1(), castOther.getKey1()).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, StringUtil.getToStringStyle()).append("key1", key1).append("key2", key2)
				.append("key3", key3).append("keyValue", keyValue).toString();
	}

}
