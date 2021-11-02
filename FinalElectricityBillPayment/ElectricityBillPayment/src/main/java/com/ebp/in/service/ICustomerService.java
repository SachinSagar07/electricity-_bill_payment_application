package com.ebp.in.service;

import java.util.List;


import com.ebp.in.entity.Customer;
import com.ebp.in.exception.DuplicateCustomerException;
import com.ebp.in.exception.NoSuchCustomerException;



public interface ICustomerService {

	public Customer registerCustomer(Customer customer)throws DuplicateCustomerException;
	public Customer viewCustomerProfile(int customerId)throws NoSuchCustomerException;
	public Customer editCustomerProfile(int customerId)throws NoSuchCustomerException;
	public Customer searchCustomerByCustomerId(Long customerId)throws NoSuchCustomerException;
	public Customer searchCustomerByEmail(String email)throws NoSuchCustomerException;
	public Customer searchCustomerByAadhaar(Long aadhaarNumber) throws NoSuchCustomerException;
	public Customer searchCustomerByMobile(String mobile)throws NoSuchCustomerException;
	public List<Customer> searchCustomerByName(String customerName)throws NoSuchCustomerException;
}


/*public Customer editCustomerProfile(Long customerId,Customer customer);

	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException;*/