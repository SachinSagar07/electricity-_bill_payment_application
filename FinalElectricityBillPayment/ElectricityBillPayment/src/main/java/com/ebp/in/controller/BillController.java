package com.ebp.in.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.ebp.in.entity.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebp.in.entity.Bill;
//import com.ebp.in.entity.Customer;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.service.IBillService;

@CrossOrigin("*")
@RestController
@RequestMapping("/bill")
public class BillController 
{
	@Autowired
	private IBillService billService;

	@PostMapping(value = "/generateBill")
	public ResponseEntity<Bill> generateBill(@RequestBody Reading reading)
	{
		Bill generatedBill=billService.generateBill(reading);
		return new ResponseEntity<Bill>(generatedBill, HttpStatus.CREATED);
	}


	@GetMapping(value="/consumernumber/{consumerNumber}")
		public ResponseEntity<Bill> viewBillByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return new ResponseEntity<Bill>(billService.viewBillByConsumerNumber(consumerNumber),HttpStatus.OK);

	}
	
	@GetMapping(value="/mobilenumber/{mobileNumber}")
	public ResponseEntity<Bill> viewBillByMobileNumber(String mobileNumber) throws NoSuchCustomerException
	{
		Bill billByMobileNumber = billService.viewBillByMobileNumber(mobileNumber);
				return new ResponseEntity<Bill>(billByMobileNumber, HttpStatus.OK);
	}
	
	@GetMapping(value="/email/{email}")
	public ResponseEntity<Bill> viewBillByEmail(String email) throws NoSuchCustomerException
	{
		Bill billByEmail = billService.viewBillByEmail(email);
				return new ResponseEntity<Bill>(billByEmail, HttpStatus.OK);
	}
	
	@GetMapping(value="/dateRange")
	public ResponseEntity<List<Bill>> viewBillForDateRange(Date from, Date to) throws NoSuchCustomerException
	{
		List<Bill> billForDateRange = billService.viewBillForDateRange(from, to);
		return new ResponseEntity<List<Bill>>(billForDateRange, HttpStatus.OK);
	}
	

}
