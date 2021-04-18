package com.capgemini.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Applicant {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="applicant_seq")
	@SequenceGenerator(name="applicant_seq",sequenceName="applicant_seq", allocationSize=1)
	private int applicantId;
	@NotBlank(message = "Name cannot be empty")
	private String fullName;
	@Enumerated(value=EnumType.STRING)
	private Gender gender;
	private LocalDate dateOfBirth;
	@NotBlank(message="Please enter your phone number")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Mobile number entered")
	private String mobile;
	private String nationality;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="addrid")
	private Address address;
	private String vehicleType;
	@OneToOne
	private User user;
	public Applicant(int applicantId, String fullName, Gender gender, LocalDate dateOfBirth, String mobile,String nationality, Address address, String vehicleType, User user) {
		super();
		this.applicantId = applicantId;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;

		this.nationality = nationality;
		this.address = address;
		this.vehicleType = vehicleType;
		this.user = user;
	}
	public Applicant() {
		super();
	}
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId=applicantId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", fullName=" + fullName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", mobile=" + mobile + ", nationality="
				+ nationality + ", address=" + address + ", vehicleType=" + vehicleType + ", user=" + user + "]";
	}
	
	
}
