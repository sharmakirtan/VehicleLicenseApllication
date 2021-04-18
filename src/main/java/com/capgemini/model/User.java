package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 
 * This class will have details of application user
 *
 */

@Entity
public class User {
	
	@Id
	@Email(message = "Email should be valid")
	@NotBlank(message="Should not be blank")
	private String email;
	@NotBlank(message="Should not be blank")
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	
	
}
