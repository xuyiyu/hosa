package com.mexp.core.exceptions;

import java.util.List;

/**
 * 
 * @author allennb
 *
 */
public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6480884112630990740L;
	String errorInfo;
	String errorCode;
	List<?> args;
	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		this.errorInfo = arg0;
	}
	
	public ServiceException(String arg0, String arg1) {
		super(arg0);
		this.errorCode = arg1;
		this.errorInfo = arg0;
	}
	
	public ServiceException(String arg0, String arg1, Throwable arg2) {
		super(arg0, arg2);
		this.errorCode = arg1;
		this.errorInfo = arg0;
	}

	public ServiceException(String arg0, List<?> args) {
		super(arg0);
		this.errorInfo = arg0;
		this.args = args;
	}
	public ServiceException(String arg0) {
		super(arg0);
		this.errorInfo = arg0;
	}

	

	public ServiceException(Throwable t) {
		super(t);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<?> getArgs() {
		return args;
	}

	public void setArgs(List<?> args) {
		this.args = args;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
}
