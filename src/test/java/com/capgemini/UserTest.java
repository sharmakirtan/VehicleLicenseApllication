package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.exception.DuplicateRequestException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.model.User;
import com.capgemini.repository.IUserJpaRepository;
import com.capgemini.service.UserServiceImpl;




//@RunWith(MockitoJUnitRunner.class)
//public class UserTest {
//	@Mock
//    IUserJpaRepository dataServiceMock;
//
//	@InjectMocks
//	UserServiceImpl businessImpl;
//	@Test
//	public void testFindAllUsers() throws NoRecordsFoundException {
//		List<User> ulist= new ArrayList<>();
//		ulist.add(new User("pratap6699@gmail.com","pra123"));
//		ulist.add(new User("prasad6699@gmail.com","p12123"));
//		when(dataServiceMock.findAll()).thenReturn(ulist);
//		assertEquals(ulist, businessImpl.findAllUsers());
//	}
//
//
//
//}

@SpringBootTest
public class UserTest {
	@MockBean
    IUserJpaRepository userRepo;

	@Autowired
	UserServiceImpl userServiceImpl;
	@Test
	public void testFindAllUsers() throws NoRecordsFoundException {
		List<User> testUserList= new ArrayList<>();
		testUserList.add(new User("pratap6699@gmail.com","pra123"));
		testUserList.add(new User("prasad6699@gmail.com","p12123"));
		when(userRepo.findAll()).thenReturn(testUserList);
		assertEquals(testUserList, userServiceImpl.findAllUsers());
		assertEquals(userServiceImpl.findAllUsers().size(),2);
	}
	
	@Test
	public void testUserRegistration() throws NullInputException, DuplicateRequestException {
		User user=getuser();
		when(userRepo.save(user)).thenReturn(user);
		assertEquals("User registered successfully", userServiceImpl.userRegistration(user));
	}
	
	@Test
	public void testuserLogin() throws InvalidLoginCredentialsException, UserNotFoundException {
		User user= getuser();
		when(userRepo.getOne(user.getEmail())).thenReturn(user);
		when(userRepo.existsById(user.getEmail())).thenReturn(true);
		assertEquals("Login Successful", userServiceImpl.userLogin(user));
		//verify.times
	}
	@Test
	public void testChangePassword() throws UserNotFoundException, NullInputException  {
		User user= getuser();
		when(userRepo.save(user)).thenReturn(user);
		when(userRepo.existsById(user.getEmail())).thenReturn(true);
		assertEquals("Password changed successfully", userServiceImpl.changePassword(user));
		//verify.times
	}
	
	@Test
	public void testSendOtp()  {
		Integer otp=userServiceImpl.sendOtp();
		assertEquals(6,otp.toString().length());
		//verify.times
	}
	
	public User getuser()
	{
		String email="prasad6699@gmail.com";
		String password="p12123";
		User user=new User(email,password);
		return user;
	}
	
	
	



}
