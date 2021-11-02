package com.ebp.in.controller;

import java.util.List;

import javax.validation.Valid;

import com.ebp.in.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebp.in.entity.Connection;
//import com.ebp.in.entity.Customer;
import com.ebp.in.exception.NoSuchConnectionException;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.service.IConnectionService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value =  "/connection")
public class ConnectionController {
	
	@Autowired
	private IConnectionService connectionService;

	
	@PostMapping(value="/newRequest")
	public ResponseEntity<Connection> newConnectionRequest(@Valid @RequestBody Connection newConnection)
	{
		Connection requestedConnection= connectionService.newConnectionRequest(newConnection);
		return new ResponseEntity<Connection>(requestedConnection,HttpStatus.CREATED);
	}

	
	@GetMapping(value = "consumernumber/{consumerNumber}")
	public ResponseEntity<Customer> searchCustomerByConsumerNumber(@PathVariable Long consumerNumber) throws NoSuchCustomerException
	{
		Customer cn=connectionService.searchCustomerByConsumerNumber(consumerNumber);
		return new ResponseEntity<Customer>(cn,HttpStatus.OK);
	}
/*
	@PutMapping("/modifyConnectionAddress")
	public ResponseEntity<Connection> modifyConnectionAddress(@RequestBody Connection connection)
	{
		Connection modifyConnectionAddress=connectionService.modifyConnectionAddress(connection);
		return new ResponseEntity<Connection>(modifyConnectionAddress,HttpStatus.CREATED);
	}
	*/

	@GetMapping(value="/village/{village}")
	public ResponseEntity<List<Connection>> findActiveConnectionsByVillage(String village)throws NoSuchCustomerException
	{
		List<Connection> connectionByVillage=connectionService.findActiveConnectionsByVillage(village);
		return new ResponseEntity<List<Connection>>(connectionByVillage,HttpStatus.OK);				
	}

	
	@GetMapping(value="/taluka/{taluk}")
	public ResponseEntity<List<Connection>> findActiveConnectionsByTaluk(String taluk)throws NoSuchCustomerException
	{
		List<Connection> connectionByTaluk=connectionService.findActiveConnectionsByTaluk(taluk);
		return new ResponseEntity<List<Connection>>(connectionByTaluk,HttpStatus.OK);
	}
	
	@GetMapping(value="/district/{district}")
	public ResponseEntity<List<Connection>> findActiveConnectionsByDistrict(String district)throws NoSuchCustomerException
	{
		List<Connection> connectionByDistrict=connectionService.findActiveConnectionsByDistrict(district);
		return new ResponseEntity<List<Connection>>(connectionByDistrict,HttpStatus.OK);				
	}
	
	@GetMapping(value="/pincode/{pincode}")
	public ResponseEntity<List<Connection>> findActiveConnectionsBypincode(String pincode)throws NoSuchCustomerException
	{
		List<Connection> connectionByPincode=connectionService.findActiveConnectionsByPincode(pincode);
		return new ResponseEntity<List<Connection>>(connectionByPincode,HttpStatus.OK);				
	}
	
	
	
	
	
	
}

