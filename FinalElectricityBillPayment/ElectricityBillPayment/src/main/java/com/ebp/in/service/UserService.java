package com.ebp.in.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebp.in.entity.User;
import com.ebp.in.exception.DuplicateUserException;
import com.ebp.in.exception.InvalidLoginCredentialException;
import com.ebp.in.exception.NoSuchUserException;
import com.ebp.in.repository.UserRepository;

import java.util.Optional;

@Service
public  class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) throws DuplicateUserException {
		Optional<User> opt=userRepository.getUserByUsername(user.getUsername());
		if(opt.isPresent())
		{
			throw new DuplicateUserException("User Already Exists!");
		}
		else
		{
			return userRepository.save(user);
		}

	}
	
	@Override
	public User loginUser(User user) throws InvalidLoginCredentialException {

		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword())
				.orElseThrow(()->new InvalidLoginCredentialException("Invalid Credentials"));

	}

	@Override
	public void changePassword(User user) {
		Optional<User> opt=userRepository.findByUsername(user.getUsername());
		if(opt.isPresent())
		{
			User existingUser=opt.get();
			System.out.println(existingUser);
			existingUser.setPassword(user.getPassword());
			userRepository.save(existingUser);
		}
		else
		{
			throw new NoSuchUserException("No User Exists!");
		}

	}

	@Override
	public void forgotPassword(String username) {

	}

	@Override
	public void emailPassword(String email) {

	}


	@Override
	public User searchUserByUsername(String username) throws NoSuchUserException {

		return userRepository.findByUsername(username)
				.orElseThrow(()->new NoSuchUserException("No User Exists!"));

	}

	@Override
	public User searchUserByUserId(int userId) throws NoSuchUserException {
		return userRepository.findById((long)userId)
				.orElseThrow(()->new NoSuchUserException("No User Exists!"));
	}



	

	
}
	




/*

@Override
public void forgotPassword(String userName) {
	Optional<User> l = userrepo.findByName(userName);
	
	if (!l.isPresent())
	 {
				
	throw new NoSuchUserException("No User is found with loginId:" + userName);
		
		}
			
	System.out.println("Password for your Account is" + userrepo.getPassword());
	
}


}*/

	