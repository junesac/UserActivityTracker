package com.toptal.exception;

public class UserActivityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserActivityException() {
		super();
	}

	public UserActivityException(String message) {
		super(message);
	}

	public UserActivityException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserActivityException(Throwable cause) {
		super(cause);
	}

}
