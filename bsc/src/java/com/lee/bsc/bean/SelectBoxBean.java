package com.lee.bsc.bean;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.lee.util.StringUtil;

public class SelectBoxBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1173403217720454028L;

	private String key;

	private String value;

	// construction
	public SelectBoxBean() {

	}

	public SelectBoxBean(String key) {
		this(key, "");
	}

	public SelectBoxBean(String key, String value) {
		this.setKey(key);
		this.setValue(value);
	}

	// getter and setter
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(key).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof SelectBoxBean)) {
			return false;
		}

		SelectBoxBean castOther = (SelectBoxBean) other;

		return new EqualsBuilder().append(this.getKey(), castOther.getKey()).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, StringUtil.getToStringStyle()).append("key", key).append("value", value)
				.toString();
	}

}
