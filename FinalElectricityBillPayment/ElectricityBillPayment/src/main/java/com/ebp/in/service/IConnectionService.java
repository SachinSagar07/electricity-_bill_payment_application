package com.ebp.in.service;

import java.util.List;


import com.ebp.in.entity.Connection;
import com.ebp.in.entity.Customer;
import com.ebp.in.exception.NoSuchConnectionException;
import com.ebp.in.exception.NoSuchCustomerException;


public interface IConnectionService {
	public Connection newConnectionRequest(Connection newConnection);
	public Customer searchCustomerByConsumerNumber(Long consumerNumber)throws NoSuchCustomerException;

	//public Connection modifyConnectionAddress(Connection connection);
	// suspend or activate connection
	//public Connection modifyConnection(Connection connection);

	public List<Connection> findActiveConnectionsByVillage(String village)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByTaluk(String taluk)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByDistrict(String district)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByPincode(String pincode)throws NoSuchConnectionException;

	//public List<Connection> findInactiveConnectionsByVillage(String village)throws NoSuchConnectionException;
	//public List<Connection> findInactiveConnectionsByTaluk(String taluk)throws NoSuchConnectionException;
	//public List<Connection> findInactiveConnectionsByDistrict(String district)throws NoSuchConnectionException;
	//public List<Connection> findInactiveConnectionsByPincode(String pincode)throws NoSuchConnectionException;

}
