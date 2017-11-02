package com.oracle.exception;

/**
 * 
 * 系统自定义异常类 针对预期的异常，需要在程序中抛出此类的异常
 * 
 * @author L
 *
 */
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public CustomException() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
