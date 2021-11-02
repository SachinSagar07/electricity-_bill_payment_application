package com.ebp.in.exception;

public class NoSuchUserException extends RuntimeException{
	private String message;
	
	public NoSuchUserException(String message) {
		super(message);
		this.message=message;
	}
     
	public NoSuchUserException() {
		
	}

	
}
