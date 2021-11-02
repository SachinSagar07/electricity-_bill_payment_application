package com.ebp.in.service;

import java.util.Date;
import java.util.List;
import com.ebp.in.entity.Bill;
import com.ebp.in.entity.ConnectionType;
import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;

public interface IBillService 
{
	public Bill generateBill(Reading reading);
	public Bill viewBillByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException;
	public Bill viewBillByMobileNumber(String mobile) throws NoSuchCustomerException;
	public Bill viewBillByEmail(String email) throws NoSuchCustomerException;
	public List<Bill> viewBillForDateRange(Date from, Date to) throws NoSuchCustomerException;
	public double enrgeyBillCalculator(ConnectionType type, double unitsConsumed);
	public void emailBillToCustomer(Long consumerNumber, String email)throws NoSuchCustomerException;

}
