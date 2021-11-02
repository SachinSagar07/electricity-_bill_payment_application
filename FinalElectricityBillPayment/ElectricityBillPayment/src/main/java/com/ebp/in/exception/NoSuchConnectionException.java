package com.ebp.in.exception;

public class NoSuchConnectionException extends RuntimeException{
	private String message;
	
	public NoSuchConnectionException(String message) {
		super(message);
		this.message=message;
	}
     
	public NoSuchConnectionException() {
		
	}

}
