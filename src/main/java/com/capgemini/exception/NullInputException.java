package com.capgemini.exception;

public class NullInputException extends Exception{

	public NullInputException(Exception e) {
		super(e);
	}

	public NullInputException(String string) {
		super(string);
	}
}
