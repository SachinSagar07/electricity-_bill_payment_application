package com.ebp.in.controller;

import javax.validation.Valid;

import com.ebp.in.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ebp.in.entity.User;
import com.ebp.in.exception.InvalidLoginCredentialException;
import com.ebp.in.service.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/user")
public class UserController{
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/registerUser")
	public ResponseEntity<User> registerUser(@Valid @RequestBody Customer customer)
	{
		User registeredUser= userService.registerUser(customer);
		return new ResponseEntity<User>(registeredUser,HttpStatus.CREATED);
	}

	/*@PostMapping("/register")
	public ResponseEntity<User> registerUser(User user)
	{
		User regUser=userService.registerUser(user);
				return new ResponseEntity<User>(regUser,HttpStatus.CREATED);
	}*/


	@PostMapping(value = "/loginUser")
	public ResponseEntity<User> loginUser(@RequestBody User user)
	{
		User registeredUser = userService.loginUser(user);
		return new ResponseEntity<User>(registeredUser, HttpStatus.OK);

	}

	@PostMapping(value = "/changePassword")
	public ResponseEntity<String> changePassword(@RequestBody User user)
	{
		userService.changePassword(user);
		String msg="Password Updated Successfully for User:"+user;
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

	@GetMapping("/searchUserByUserName/{username}")
	public ResponseEntity<User> searchUserByUsername(@PathVariable String username)
	{
		User user=userService.searchUserByUsername(username);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/searchUserByUserId/{userId}")
	public ResponseEntity<User> searchUserByUserId(Integer userId)
	{
		User user=userService.searchUserByUserId(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
}


/*
	@PutMapping("/forgotpassword")
	public void forgotPassword(@PathVariable String userName)
	{
		userService.forgotPassword(userName);
	}

	@PutMapping("emailpassword")
	public void emailPassword(@PathVariable String email)
	{
		userService.emailPassword(email);
	}*/



