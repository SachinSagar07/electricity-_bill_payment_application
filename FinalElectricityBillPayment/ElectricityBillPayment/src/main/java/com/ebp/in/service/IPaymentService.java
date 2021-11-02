package com.ebp.in.service;

import java.util.List;
import com.ebp.in.entity.Payment;
import com.ebp.in.entity.PaymentStatus;
import com.ebp.in.exception.NoSuchCustomerException;

public interface IPaymentService
{
	public PaymentStatus payBill(Payment payment);
	public void sendEmailOnPaymentCompletion(Long consumerId, String email);
	public List<Payment> viewHistoricalPayment(Long consumerNumber)throws NoSuchCustomerException;
	

}
