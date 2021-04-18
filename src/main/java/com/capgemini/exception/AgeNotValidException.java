package com.capgemini.exception;

public class AgeNotValidException extends Exception {
	public AgeNotValidException(Exception e) {
		super(e);
	}

	public AgeNotValidException(String string) {
		super(string);
	}
}
