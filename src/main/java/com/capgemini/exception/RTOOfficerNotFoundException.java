package com.capgemini.exception;

public class RTOOfficerNotFoundException extends Exception{

	public RTOOfficerNotFoundException(Exception e) {
		super(e);
	}

	public RTOOfficerNotFoundException(String string) {
		super(string);
	}
}
