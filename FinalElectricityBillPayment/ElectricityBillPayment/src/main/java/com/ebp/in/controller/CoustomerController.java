package com.ebp.in.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebp.in.entity.Customer;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.service.ICustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/customer")
public class CoustomerController {
	
	@Autowired
	private ICustomerService customerService;

	@PostMapping(value = "/edit/{customerId}")
	public ResponseEntity<Customer> editCustomerProfile(int customerId,@RequestBody Customer customer) throws NoSuchCustomerException {
		Customer existingCustomer=customerService.editCustomerProfile(customerId);
		return new ResponseEntity<Customer>(existingCustomer,HttpStatus.OK);
	}

	@GetMapping(value = "/customerId/{customerId}")
	public ResponseEntity<Customer> viewCustomerProfile(int customerId) throws NoSuchCustomerException {
		Customer customer=customerService.viewCustomerProfile(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<Customer> searchCustomerByEmail(String email) throws NoSuchCustomerException {
		Customer customer= customerService.searchCustomerByEmail(email);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

	@GetMapping(value = "/aadhaar/{aadhaar}")
	public ResponseEntity<Customer> searchCustomerByAadhaar(Long aadhaar) throws NoSuchCustomerException {
		Customer customer= customerService.searchCustomerByAadhaar(aadhaar);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

	@GetMapping(value = "/mobile/{mobileNumber}")
	public ResponseEntity<Customer> searchCustomerByMobile(String mobileNumber) throws NoSuchCustomerException {
		Customer customer= customerService.searchCustomerByMobile(mobileNumber);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}




	@GetMapping(value="/byid/{customerId}")
	public ResponseEntity<Customer> searchCustomerByCustomerId(@PathVariable Long customerId) throws NoSuchCustomerException{
		
		Customer byId= customerService.searchCustomerByCustomerId(customerId);
		return new ResponseEntity<Customer>(byId,HttpStatus.OK);
		
	}

	@GetMapping(value="/customerbyfn/{firstName}")
	public ResponseEntity<List<Customer>> searchCustomerByFirstName(@PathVariable String firstName) throws NoSuchCustomerException{
		 
		List<Customer> byName= customerService.searchCustomerByName(firstName);	
		return new ResponseEntity<List<Customer>>(byName,HttpStatus.OK);
		
	}
	
}


/*@PostMapping(value="/register")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer)
	{
		Customer registeredCustomer= customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(registeredCustomer,HttpStatus.CREATED);
	}
	@GetMapping(value="/byemail/{email}")
	public ResponseEntity<Customer> searchCustomerByEmail(@PathVariable String email) throws NoSuchCustomerException{

		Customer byEmail= customerService.searchCustomerByEmail(email);
		return new ResponseEntity<Customer>(byEmail,HttpStatus.OK);

	}*/