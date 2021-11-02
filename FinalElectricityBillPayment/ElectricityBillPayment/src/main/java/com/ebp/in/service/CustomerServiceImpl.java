package com.ebp.in.service;

import java.util.List;
import java.util.Optional;

import com.ebp.in.exception.DuplicateCustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Customer;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.CustomerRepository;
import com.ebp.in.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public Customer registerCustomer(Customer customer) throws DuplicateCustomerException {
		return customerRepository.save(customer);
	}

	@Override
	public Customer viewCustomerProfile(int customerId) throws NoSuchCustomerException {
		return searchCustomerByCustomerId((long)customerId);
	}

	@Override
	public Customer editCustomerProfile(int customerId) throws NoSuchCustomerException {
		Customer customer=searchCustomerByCustomerId((long)customerId);
		return customerRepository.save(customer);
	}

	@Override
	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException {
		return customerRepository.findById(customerId)
				.orElseThrow(()-> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByEmail(String email) throws NoSuchCustomerException {
		return customerRepository.findByEmail(email)
				.orElseThrow(()-> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByAadhaar(Long aadhaarNumber) throws NoSuchCustomerException {
		return customerRepository.findByAadhaarNumber(aadhaarNumber)
				.orElseThrow(()-> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByMobile(String mobile) throws NoSuchCustomerException {
		return customerRepository.findByMobileNumber(mobile).orElseThrow(()-> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public List<Customer> searchCustomerByName(String firstName) throws NoSuchCustomerException {
		try {
		List<Customer> byName = customerRepository.findByFirstName(firstName);
		return byName;
		}
		catch (Exception e) {
			throw new NoSuchCustomerException("Customer with name:"+firstName+"not present");
		}
			
		}
		
		
	

}

/*
	@Override
	public Customer registerCustomer(Customer customer) {
		Customer registeredCustomer = customerRepository.save(customer);
		return registeredCustomer;
	}
	
	
	@Override
	public List<Customer> viewCustomersProfile() {
		List<Customer> viewCustomerProfile = customerRepository.findAll();
		return viewCustomerProfile;
		
	}

	@Override
	public Customer editCustomerProfile(Long customerId,Customer customer) {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent()) {
		Customer customer1=opt.get();
		customer1.setAddharNumber(customer.getAddharNumber());
		customer1.setFirstName(customer.getFirstName());
		customer1.setMiddleName(customer.getMiddleName());
		customer1.setLastName(customer.getLastName());
		customer1.setMobileNumber(customer.getMobileNumber());
		customer1.setEmail(customer.getEmail());
		customer1.setGender(customer.getGender());
		return customerRepository.save(customer1);
		
	}
	else {
		return customerRepository.save(customer);
	
	}
	}
	
	@Override
	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException  {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if (opt.isPresent()) {
			Customer searchCustomerByCustomerId = opt.get();
			return searchCustomerByCustomerId;
		}
		else {
			throw new NoSuchCustomerException("Customer with given Details: "+customerId+" is not present");
		}
	}

	@Override
	public Customer searchCustomerByEmail(String email) throws NoSuchCustomerException {
		Customer byEmail= customerRepository.findByEmail(email);
		return byEmail;
		
		
	}

	@Override
	public Customer searchCustomerByAadhaar(Long aadhaarNumber) throws NoSuchCustomerException {
		Customer byAadhar= customerRepository.findByAadhaarNumber(aadhaarNumber);
		return byAadhar;
	}

	@Override
	public Customer searchCustomerByMobile(String mobileNumber) throws NoSuchCustomerException {
		Customer byMobile= customerRepository.findByMobileNumber(mobileNumber);
		return byMobile;
	}


	  */

	
	
	
