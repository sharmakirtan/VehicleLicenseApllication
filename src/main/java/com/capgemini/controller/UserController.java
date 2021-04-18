package com.capgemini.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.exception.DuplicateRequestException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;
import com.capgemini.service.UserServiceImpl;
@Validated
@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userservice;
	
	@PostMapping(path = "/adduser")
	public String createUser(@Valid @RequestBody User user) throws NullInputException, DuplicateRequestException
	{
		System.out.println("Inside create of createUser()");
		return userservice.userRegistration(user);
	}
	
	@PostMapping(path = "/userlogin")
	public String userLogin(@Valid @RequestBody User user) throws InvalidLoginCredentialsException, UserNotFoundException
	{
		userservice.userLogin(user);
		return "Login Successful";
	}
	
	@GetMapping(path="/allusers")
	public List<User> retreiveAllUsers() throws NoRecordsFoundException {
		System.out.println("Inside retrieveAllUsers() of UserController");
		return userservice.findAllUsers();
	}
	
	@GetMapping(path="/user/otp")
	public int sendOtp() {
		System.out.println("Inside retrieveAllUsers() of UserController");
		return userservice.sendOtp();
	}
	
	
	@PutMapping(path = "/user/updatepassword")
	public String updatePassword(@Valid @RequestBody User user) throws UserNotFoundException, NullInputException 
	{
		return userservice.changePassword(user);
	}
}
