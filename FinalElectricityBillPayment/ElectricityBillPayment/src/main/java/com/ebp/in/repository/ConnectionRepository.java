package com.ebp.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebp.in.entity.Connection;
import com.ebp.in.entity.Customer;


@Repository

public interface ConnectionRepository extends JpaRepository<Connection, Long> {


	public Optional<Customer> findByConsumerNumber(Long consumerNumber);


	@Query(value = "SELECT c.* FROM connection c,Address a where c.connectionStatus='ACTIVE' and a.village=?1",nativeQuery = true)
	public List<Connection> getActiveConnectionsByVillage(String village);

	@Query(value = "select * from connection where connectionStatus='INACTIVE' and village=?1",nativeQuery = true)
	public List<Connection> getInActiveConnectionsByVillage(String village);

	@Query(value = "SELECT c.* FROM connection c where c.connectionStatus='ACTIVE' and c.taluk=?1",nativeQuery = true)
	public List<Connection> getActiveConnectionsByTaluk(String taluk);

	@Query(value = "select * from connection where connectionStatus='INACTIVE' and taluk=?1",nativeQuery = true)
	public List<Connection> getInActiveConnectionsByTaluk(String taluk);

	@Query(value = "select * from connection where connectionStatus='ACTIVE' and district=?1",nativeQuery = true)
	public List<Connection> getActiveConnectionsByDistrict(String district);

	@Query(value = "select * from connection where connectionStatus='INACTIVE' and district=?1",nativeQuery = true)
	public List<Connection> getInActiveConnectionsByDistrict(String district);

	@Query(value = "select * from connection where connectionStatus='ACTIVE' and pincode=?1",nativeQuery = true)
	public List<Connection> getActiveConnectionsByPincode(String pincode);

	@Query(value = "select * from connection where connectionStatus='INACTIVE' and pincode=?1",nativeQuery = true)
	public List<Connection> getInActiveConnectionsByPincode(String pincode);
	
	
/*	@Query("select c from Customer c where c.consumerNumber=?1")
	public Customer readCustomerByConsumerNumber(Long consumerNumber);
	
	@Query("select c from Connection c where c.villageName=?1")
	public List<Connection> readActiveConnectionsByVillage(String villageName);
	
	@Query("select c from Connection c where c.taluka=?1")
	public List<Connection> readActiveConnectionsByTaluka(String taluka);
	
	@Query("select c from Connection c where c.districtName=?1")
	public List<Connection> readActiveConnectionsByDistrict(String districtName);
	
	@Query("select c from Connection c where c.pincode=?1")
	public List<Connection> readActiveConnectionsByPincode(String pincode);
	
	@Query("select c from Connection c where c.villageName=?1")
	public List<Connection> readInactiveConnectionsByVillage(String villageName);
	
	@Query("select c from Connection c where c.taluka=?1")
	public List<Connection> readInactiveConnectionsByTaluka(String taluka);
	
	@Query("select c from Connection c where c.districtName=?1")
	public List<Connection> readInactiveConnectionsByDistrict(String districtName);
	
	@Query("select c from Connection c where c.pincode=?1")
	public List<Connection> readInactiveConnectionsByPincode(String pincode);
	
	
*/

}
