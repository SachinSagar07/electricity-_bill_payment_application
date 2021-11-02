package com.ebp.in.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.ebp.in.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Connection;
//import com.ebp.in.entity.Customer;
import com.ebp.in.exception.NoSuchConnectionException;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.ConnectionRepository;
import com.ebp.in.repository.CustomerRepository;
//import com.ebp.in.repository.CustomerRepository;

@Service
public class ConnectionServiceImplementation implements IConnectionService {
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
    public Connection newConnectionRequest(Connection newConnection) {
        Customer customer=newConnection.getCustomerConnection();
        Long userId=customer.getUserId();
        Connection con=null;
        if(userId==0)
        {
            newConnection.setConnectionDate(new Date());
            Random random=new Random();
            Integer randonNumber=random.nextInt(12);
            Long random1=(long)((int)Math.random()*randonNumber);

            newConnection.setConsumerNumber(random1);
            newConnection.setApplicationDate(new Date());
            con=connectionRepository.save(newConnection);
        }
        else
        {
            Customer existingCustomer=newConnection.getCustomerConnection();
            newConnection.setCustomerConnection(existingCustomer);
            newConnection.setConnectionDate(new Date());
            newConnection.setConsumerNumber(new Random().nextLong()+new Random(1000).nextInt());
            newConnection.setApplicationDate(new Date());
            con=connectionRepository.save(newConnection);

        }


        return con;
    }


	@Override
	public Customer searchCustomerByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return connectionRepository.findByConsumerNumber(consumerNumber)
				.orElseThrow(()->new NoSuchConnectionException("No Connection Exists!"));
	}


	@Override
	public List<Connection> findActiveConnectionsByVillage(String village) throws NoSuchConnectionException {
		List<Connection> connection=connectionRepository.getActiveConnectionsByVillage(village);
		if(connection==null)
		{
			throw new NoSuchConnectionException("connections are not available for this village name:"+village);
		}else
		{
			return connection;
		}

	}

	@Override
	public List<Connection> findActiveConnectionsByTaluk(String taluk) throws NoSuchConnectionException {
		return connectionRepository.getActiveConnectionsByTaluk(taluk);
	}

	@Override
	public List<Connection> findActiveConnectionsByDistrict(String district) throws NoSuchConnectionException {
		return connectionRepository.getActiveConnectionsByDistrict(district);
	}

	@Override
	public List<Connection> findActiveConnectionsByPincode(String pincode) throws NoSuchConnectionException {
		return connectionRepository.getActiveConnectionsByPincode(pincode);
	}
/*
	@Override
	public List<Connection> findInactiveConnectionsByVillage(String village) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByVillage(village);
	}

	@Override
	public List<Connection> findInactiveConnectionsByTaluk(String taluk) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByTaluk(taluk);
	}

	@Override
	public List<Connection> findInactiveConnectionsByDistrict(String district) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByDistrict(district);
	}

	@Override
	public List<Connection> findInactiveConnectionsByPincode(String pincode) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByPincode(pincode);
	}

	@Override
	public Connection modifyConnectionAddress(Connection connection) {
		return null;
	}

	@Override
	public Connection modifyConnection(Connection connection) {
		return null;
	}

	
	
	@Override
	public Connection updateConnectionAddress(Connection connection) {
		Connection modifyConnection=connectionRepository.updateConnectionAddress(connection);
		return modifyConnection;
	
	}



	  @Override
	public List<Connection> findConnectionsByVillage(String villageName) throws NoSuchConnectionException {
		List<Connection> connection=connectionRepository.findConnectionsByVillage(villageName);
		if(connection==null)
		{
			throw new NoSuchConnectionException("connections are not available for this village name:"+villageName);
		}else
		{
			return connection;
		}
	}
	  
	  @Override
		public List<Connection> findConnectionsByTaluka(String taluka) throws NoSuchConnectionException {
			List<Connection> connection=connectionRepository.findConnectionsByTaluka(taluka);
			if(connection==null)
			{
				throw new NoSuchConnectionException("connections are not available for this taluka"+taluka);
			}else
			{
				return connection;
			}
		}
	  
	  @Override
		public List<Connection> findConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
			List<Connection> connection=connectionRepository.findConnectionsByDistrict(districtName);
			if(connection==null)
			{
				throw new NoSuchConnectionException("connections are not available for this District"+districtName);
			}else
			{
				return connection;
			}
		}
	  
	  @Override
		public List<Connection> findConnectionsByPincode(String pincode) throws NoSuchConnectionException {
			List<Connection> connection=connectionRepository.findConnectionsByPincode(pincode);
			if(connection==null)
			{
				throw new NoSuchConnectionException("connections are not available for this Pincode"+pincode);
			}else
			{
				return connection;
			}
		}

	*/

}
