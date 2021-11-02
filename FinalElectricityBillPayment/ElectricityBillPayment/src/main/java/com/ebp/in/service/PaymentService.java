package com.ebp.in.service;

import java.util.List;
import java.util.Optional;
import java.util.*;
import com.ebp.in.entity.Bill;
import com.ebp.in.entity.PaymentStatus;
import com.ebp.in.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebp.in.entity.Payment;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.PaymentRepository;


@Service

public class PaymentService implements IPaymentService
{
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private IBillService billService;

	@Autowired
	private BillRepository billRepository;


	@Override
	public PaymentStatus payBill(Payment payment) {
		Long billId=payment.getBillPayment().getBillId();
		System.out.println("Bill ID:"+billId);
		Optional<Bill> bill=billRepository.findById(billId);
		Double amount=bill.get().getBillAmount();
		payment.setStatus(new Random().nextBoolean()?PaymentStatus.SUCCESS:PaymentStatus.FAILED);
		payment.setPaymentDate(new Date());
		payment.setLatePaymentCharges(0.0);
		payment.setTotalPaid(amount);
		Payment savedPayment=paymentRepository.save(payment);

		return savedPayment.getStatus();
	}

	@Override
	public void sendEmailOnPaymentCompletion(Long consumerId, String email) {

	}

	@Override
	public List<Payment> viewHistoricalPayment(Long consumerNumber) throws NoSuchCustomerException {
		List<Payment> payment=paymentRepository.readHistoricalPaymentByConsumerNumber(consumerNumber);
		if(payment==null)
		{
			throw new NoSuchCustomerException("Reading is not available for this consumer number"+consumerNumber);
		}else
		{
			return payment;
		}
		
	}

	
}