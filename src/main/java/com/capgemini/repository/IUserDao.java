package com.capgemini.repository;

import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;

public interface IUserDao{
	public String createUser(User user) throws NullInputException;
	public boolean validateLogin(User user) throws InvalidLoginCredentialsException;
	public String updateUser(User user) throws UserNotFoundException;
	
}
