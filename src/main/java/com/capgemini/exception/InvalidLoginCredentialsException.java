package com.capgemini.exception;

public class InvalidLoginCredentialsException extends Exception{
	private String s;

	public InvalidLoginCredentialsException(String s) {
        super(s);
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
