package com.ebp.in.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ebp.in.entity.Bill;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long>  
{
	@Query(value = "SELECT b.* FROM bill b,Connection c where c.consumer_number=?1",nativeQuery = true)
	public Optional<Bill> viewBillByConsumerNumber(Long consumerNumber);

	@Query(value = "SELECT b.* FROM bill b,Customer c where c.mobile_number=?1",nativeQuery = true)
	public Optional<Bill> viewBillByMobileNumber(String mobileNumber);

	@Query(value = "SELECT b.* FROM bill b,Customer c where c.email=?1",nativeQuery = true)
	public Optional<Bill> viewBillByEmail(String email);


	List<Bill> findAllByBillDateBetween(Date from, Date to);
}
