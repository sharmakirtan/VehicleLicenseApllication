package com.capgemini.exception;

 

public class FailedToSendEmailException extends Exception {

 

	private String message;
	public FailedToSendEmailException(String string) {
		this.setMessage(string);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

 

}