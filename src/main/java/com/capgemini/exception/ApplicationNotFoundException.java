package com.capgemini.exception;

public class ApplicationNotFoundException extends Exception{
	private String s;

	public  ApplicationNotFoundException (String s) {
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
