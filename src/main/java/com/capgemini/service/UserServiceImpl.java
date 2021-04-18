package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.DuplicateRequestException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;
import com.capgemini.repository.IUserJpaRepository;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserJpaRepository userjparepos;
	
	@Override
	public List<User> findAllUsers() throws NoRecordsFoundException {
		if(userjparepos.findAll().isEmpty())
			throw new NoRecordsFoundException("No Users found");
		else
			return userjparepos.findAll();
	}

	@Override
	public String userRegistration(User user) throws NullInputException, DuplicateRequestException {
		if(user!=null)
		{
			if(userjparepos.existsById(user.getEmail()))
				throw new DuplicateRequestException("User with this email already exists");
			else {
				userjparepos.save(user);
				return "User registered successfully";
			}
		}
		throw new NullInputException("User input cannot be null");
	}

	@Override
	public String userLogin(User user) throws InvalidLoginCredentialsException, UserNotFoundException
	{
		if(userjparepos.existsById(user.getEmail()))
        {      
//			User u=userjparepos.findById(user.getEmail());
			User u=userjparepos.getOne(user.getEmail());
	        if(user.getPassword().equals(u.getPassword()))
            {
	        	System.out.println("Correct credentials");
                return "Login Successful";
                
            }   	
        	throw new InvalidLoginCredentialsException("Incorrect Password entered");
        }
        throw new UserNotFoundException("Incorrect email entered");
	}

	@Override
	public String changePassword(User user) throws UserNotFoundException, NullInputException {
		if(user!=null)
		{
			if(userjparepos.existsById(user.getEmail()))
			{
				userjparepos.save(user);
				return "Password changed successfully";
			}
			throw new UserNotFoundException("No user with this email id exists");
		}
		throw new NullInputException("User input cannot be null");
			
	}

	@Override
	public String forgotPassword(User user) {
		int otp=sendOtp();
		//validateOtp();
		
		return "Forget password Otp sent";
	}

	@Override
	public int sendOtp() {
		int otp=(int)(Math.random()*(999999 - 100000) + 100000);
		System.out.println("OTP Sent");
		return otp;
		//send to email
	}

}
