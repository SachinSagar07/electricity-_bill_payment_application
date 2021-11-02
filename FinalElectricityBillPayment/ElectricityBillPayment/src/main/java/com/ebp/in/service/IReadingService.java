package com.ebp.in.service;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;


import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;

public interface IReadingService {
	
	public Reading selfSubmit(Reading reading);
	public Reading findMeterReadingByConsumerNumber(Long consumerNumber)throws NoSuchCustomerException;
	//public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, Date billDate)throws NoSuchCustomerException;
}



