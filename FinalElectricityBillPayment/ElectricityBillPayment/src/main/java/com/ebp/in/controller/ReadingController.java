package com.ebp.in.controller;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.service.IReadingService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/reading")

public class ReadingController {

	@Autowired
	private IReadingService readingService;
	
	@PostMapping(value="/submit")
	public ResponseEntity<Reading> selfSubmit(@RequestBody Reading reading)
	{
		Reading reading1=readingService.selfSubmit(reading);
		return new ResponseEntity<Reading>(reading1, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/consumerNumber/{consumerNumber}")
	public ResponseEntity<Reading> findMeterReadingByConsumerNumber(Long consumerNumber)throws NoSuchCustomerException
	{
		return new ResponseEntity<Reading>(readingService.findMeterReadingByConsumerNumber(consumerNumber),HttpStatus.OK);
	}

	/*
	@GetMapping(value="/consumerNumberbillDate/{consumerNumber},{billDate}")
	public ResponseEntity<Reading> findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, Date billDate)throws NoSuchCustomerException
	{
		Reading readByconsumerNumberAndBillDate=readingService.findMeterReadingByConsumerNumberAndBillDate(consumerNumber, billDate);
		return new ResponseEntity<Reading>(readByconsumerNumberAndBillDate,HttpStatus.OK);
	}

	 */
}
