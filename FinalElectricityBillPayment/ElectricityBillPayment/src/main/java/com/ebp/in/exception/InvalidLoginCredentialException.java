package com.ebp.in.exception;


public class InvalidLoginCredentialException extends RuntimeException{
	private String message;
	
	public  InvalidLoginCredentialException(String message) {
		super(message);
		this.message=message;
	}
     
	public  InvalidLoginCredentialException() {
		
	}

}