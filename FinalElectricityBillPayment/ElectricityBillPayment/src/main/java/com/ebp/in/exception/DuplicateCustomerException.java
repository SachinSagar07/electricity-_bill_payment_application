package com.ebp.in.exception;

public class DuplicateCustomerException extends RuntimeException{
	private String message;
	
	public  DuplicateCustomerException(String message) {
		super(message);
		this.message=message;
	}
     
	public  DuplicateCustomerException() {
		
	}

}
