package com.capgemini.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(Exception e) {
		super(e);
	}

	public UserNotFoundException(String string) {
		super(string);
	}
}
