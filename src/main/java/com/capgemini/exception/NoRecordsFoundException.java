package com.capgemini.exception;

public class NoRecordsFoundException extends Exception {
	
		public NoRecordsFoundException(Exception e) {
			super(e);
		}

		public NoRecordsFoundException(String string) {
			super(string);
		}

}
