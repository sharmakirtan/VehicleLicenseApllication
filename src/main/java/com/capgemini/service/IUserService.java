package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.DuplicateRequestException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public interface IUserService {
	public List<User> findAllUsers() throws NoRecordsFoundException;
	public String userRegistration(User user) throws NullInputException, DuplicateRequestException;
	public String userLogin(User user) throws InvalidLoginCredentialsException, UserNotFoundException;
	public String changePassword(User user) throws UserNotFoundException, NullInputException;
	public String forgotPassword(User user) throws UserNotFoundException;
	public int sendOtp();
}
