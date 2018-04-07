package com.toptal.exception;

public class UserInfoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserInfoException() {
		super();
	}

	public UserInfoException(String message) {
		super(message);
	}

	public UserInfoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInfoException(Throwable cause) {
		super(cause);
	}

}
