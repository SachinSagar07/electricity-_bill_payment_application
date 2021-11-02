package com.ebp.in.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebp.in.entity.User;
import com.ebp.in.exception.NoSuchUserException;


@Repository

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username,String password);

	@Query(value = "select * from user where username=?1",nativeQuery = true)
	Optional<User> getUserByUsername(String username);

}




/*
public void changePassword(User user);
public void forgotPassword(String userName);
public User findByUserName(String userName);
public User findByUserId(Long userId);*/