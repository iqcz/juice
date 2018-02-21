package com.lee.bsc.bean;

import java.io.Serializable;

import com.lee.bsc.bean.enumeration.EnumErrorLocation;
import com.lee.bsc.common.Constant;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ErrorMessage implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 701154815524457977L;

    private int errorCode;

    // 0: errpr; 1: warning
    private int errorLevel;

    private String errorMsg;

    private String[] params;

    private EnumErrorLocation errorLocation = EnumErrorLocation.NONE;

    public ErrorMessage() {
	this.errorCode = 0;
	this.errorLevel = Constant.ERROR_LEVEL;
	this.errorMsg = null;
	this.params = null;
    }

    public ErrorMessage(int errorCode) {
	this(errorCode, Constant.ERROR_LEVEL);
	this.errorMsg = null;
	this.params = null;
    }

    public ErrorMessage(int errorCode, int errorLevel) {
	this.errorCode = errorCode;
	this.errorLevel = errorLevel;
	this.errorMsg = null;
	this.params = null;
    }

    public ErrorMessage(int errorCode, String[] params) {
	this(errorCode);
	this.errorLevel = Constant.ERROR_LEVEL;
	this.errorMsg = null;
	this.params = params;
    }

    public ErrorMessage(int errorCode, String[] params, int errorLevel) {
	this(errorCode, params);
	this.errorLevel = errorLevel;
	this.errorMsg = null;
    }

    public ErrorMessage(int errorCode, String[] params, EnumErrorLocation errorLocation) {
	this(errorCode, params);
	this.errorLevel = Constant.ERROR_LEVEL;
	this.errorMsg = null;
	this.errorLocation = errorLocation;
    }

    public ErrorMessage(int errorCode, String errorMsg) {
	this(errorCode);
	this.errorLevel = Constant.ERROR_LEVEL;
	this.errorMsg = errorMsg;
	this.params = null;
    }

    public ErrorMessage(int errorCode, String errorMsg, EnumErrorLocation errorLocation) {
	this(errorCode, errorMsg);
	this.errorLevel = Constant.ERROR_LEVEL;
	this.errorMsg = errorMsg;
	this.params = null;
	this.errorLocation = errorLocation;
    }

    public ErrorMessage(int errorCode, EnumErrorLocation errorLocation) {
	this(errorCode);
	this.errorLevel = Constant.ERROR_LEVEL;
	this.errorMsg = null;
	this.errorLocation = errorLocation;
    }

    @Override
    public boolean equals(Object other) {
	if (!(other instanceof ErrorMessage)) {
	    return false;
	}

	ErrorMessage castOther = (ErrorMessage) other;

	return new EqualsBuilder().append(this.getErrorCode(), castOther.getErrorCode()).isEquals();
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(this.errorCode).toHashCode();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this).append("errorCode", this.getErrorCode())
		.append("errorLevel", this.getErrorLevel()).append("errorMsg", this.getErrorMsg())
		.append("errorLocation", this.getErrorLocation()).toString();
    }

    // get and set method.
    public int getErrorCode() {
	return errorCode;
    }

    public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
    }

    public int getErrorLevel() {
	return errorLevel;
    }

    public void setErrorLevel(int errorLevel) {
	this.errorLevel = errorLevel;
    }

    public String getErrorMsg() {
	return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
	this.errorMsg = errorMsg;
    }

    public String[] getParams() {
	return params;
    }

    public void setParams(String[] params) {
	this.params = params;
    }

    public EnumErrorLocation getErrorLocation() {
	return errorLocation;
    }

    public void setErrorLocation(EnumErrorLocation errorLocation) {
	this.errorLocation = errorLocation;
    }
}
