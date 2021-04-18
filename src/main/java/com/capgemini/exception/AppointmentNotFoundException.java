package com.capgemini.exception;

public class AppointmentNotFoundException extends Exception {
	
	private String message;
	public AppointmentNotFoundException(String string) {
		this.setMessage(string);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
