package com.ebp.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebp.in.entity.Payment;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

	@Query(value = "SELECT p.* FROM payment p,Connection c where c.consumerNumber=?1",nativeQuery = true)
	public List<Payment> readHistoricalPaymentByConsumerNumber(Long consumerNumber);
	
}
