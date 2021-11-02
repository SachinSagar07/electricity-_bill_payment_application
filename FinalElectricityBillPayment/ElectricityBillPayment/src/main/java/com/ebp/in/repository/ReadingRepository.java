package com.ebp.in.repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ebp.in.entity.Reading;
import org.springframework.data.jpa.repository.Query;


public interface ReadingRepository extends JpaRepository<Reading,Long> {

	@Query(value = "SELECT R.* FROM READING R,CONNECTION C WHERE C.CONSUMER_NUMBER=?1",nativeQuery = true)
	public Optional<Reading> findMeterReadingByConsumerNumber(Long consumerNumber);

	//public Reading findByConsumerNumberAndBillDate(Long consumerNumber, Date billDate);

}
