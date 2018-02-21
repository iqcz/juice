package com.lee.bsc;

import com.lee.bsc.bean.ErrorMessage;

public class BIException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 3508291345217031865L;

    private int errorCode = 0;

    private int errorLevel = 0;

    private ErrorMessage errorMessage;

    public BIException() {

    }

    public BIException(int errorCode) {
	this.errorCode = errorCode;
    }

    public BIException(String message) {
	super(message);
    }

    public BIException(int errorCode, String message) {
	super(message);
	this.errorCode = errorCode;
    }

    public BIException(int errorCode, int errorLevel) {
	this.errorCode = errorCode;
	this.errorLevel = errorLevel;
    }

    public BIException(Throwable cause) {
	super(cause);
    }

    public BIException(String message, Throwable cause) {
	super(message, cause);
    }

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

    public ErrorMessage getErrorMessage() {
	return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
    }
}
