package com.ebp.in.exception;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid
	(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request){
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map((error->error.getDefaultMessage()))
.collect(Collectors.toList());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
}

	
	//NoSuchCustomerException
	@ExceptionHandler(NoSuchCustomerException.class)
		public ResponseEntity<Object> handleNoSuchCustomerException
		(NoSuchCustomerException exception,WebRequest request){
		
		ErrorDetails errorDetails= new ErrorDetails
				(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	/*
	@ExceptionHandler(value= {CustomerIdNotFoundException.class})
	public ResponseEntity<Object> handleCustomerIdNotFoundException(CustomerIdNotFoundException ex,WebRequest request)
	{
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription==null) errorMessageDescription=ex.toString();
		return new ResponseEntity<>(errorMessageDescription,new HttpHeaders(),HttpStatus.BAD_REQUEST);
	}

*/	
	//DuplicateCustomerException
		@ExceptionHandler(DuplicateCustomerException.class)
			public ResponseEntity<Object> handleDuplicateCustomerException
			(DuplicateCustomerException exception,WebRequest request){
			
			ErrorDetails errorDetails= new ErrorDetails
					(new Date(),exception.getMessage(),request.getDescription(false));
			return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		}
		
		//DuplicateUserException
				@ExceptionHandler(DuplicateUserException.class)
					public ResponseEntity<Object> handleDuplicateUserException
					(DuplicateUserException exception,WebRequest request){
					
					ErrorDetails errorDetails= new ErrorDetails
							(new Date(),exception.getMessage(),request.getDescription(false));
					return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
				}
				
		//InvaliLoginCredentialException
				@ExceptionHandler(InvalidLoginCredentialException.class)
					public ResponseEntity<Object> handleInvalidLoginCredentialException
					(InvalidLoginCredentialException exception,WebRequest request){
					
					ErrorDetails errorDetails= new ErrorDetails
							(new Date(),exception.getMessage(),request.getDescription(false));
					return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
				}
				
				//NoSuchConnectionException
				@ExceptionHandler(NoSuchConnectionException.class)
					public ResponseEntity<Object> handleNoSuchConnectionException
					(NoSuchConnectionException exception,WebRequest request){
					
					ErrorDetails errorDetails= new ErrorDetails
							(new Date(),exception.getMessage(),request.getDescription(false));
					return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
				}
				
				//NoSuchUseException
				@ExceptionHandler(NoSuchUserException.class)
					public ResponseEntity<Object> handleNoSuchUserException
					(NoSuchUserException exception,WebRequest request){
					
					ErrorDetails errorDetails= new ErrorDetails
							(new Date(),exception.getMessage(),request.getDescription(false));
					return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
				}
	
	
	//GlobalException
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException
	(Exception exception,WebRequest request){
	
	ErrorDetails errorDetails= new ErrorDetails
			(new Date(),exception.getMessage(),request.getDescription(false));
	return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
}
		
		
	
}
