package com.ebp.in.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import com.ebp.in.entity.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.ReadingRepository;


@Service
public class ReadingService implements IReadingService {
	
	@Autowired
	private ReadingRepository read;
	
	@Autowired
	private IBillService billService;

	@Override
	public Reading selfSubmit(Reading reading) {
		Double pricePerUnit=4.5;
		Reading reading1=null;
		Connection existingConnection=reading.getReadingForConnection();
		Long connectionId=existingConnection.getConnectionId();
		if(connectionId==0)
		{
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1=read.save(reading);
			billService.generateBill(reading1);
		}
		else
		{
			reading.setReadingForConnection(existingConnection);
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1=read.save(reading);
			billService.generateBill(reading1);
		}


		return reading1;
	}

	@Override
	public Reading findMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return read.findMeterReadingByConsumerNumber(consumerNumber)
				.orElseThrow(()->new NoSuchCustomerException("Customer Not Exist!"));
	}

	/*@Override
	public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, Date billDate)throws NoSuchCustomerException {
	    Reading readingcnbd=read.findByConsumerNumberAndBillDate(consumerNumber, billDate);
	    if(readingcnbd==null)
	    {
	    	throw new NoSuchCustomerException("Reading is not available for these consmer number"+consumerNumber+"and bill date"+billDate);
	    }else
	    {
	    	return readingcnbd;
	    }


		
	}

	*/
}
	