package com.ebp.in.exception;

public class DuplicateUserException extends RuntimeException{
	private String message;
	
	public  DuplicateUserException(String message) {
		super(message);
		this.message=message;
	}
     
	public  DuplicateUserException() {
		
	}

}