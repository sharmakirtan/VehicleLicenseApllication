package com.capgemini.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class DrivingLicense {
	@Id
	private String drivingLicenseNumber;
	@OneToOne
	@JoinColumn(name="applicationnumber")
	private Application application;
	@JsonIgnore
	private LocalDate dateOfIssue=LocalDate.now();
	@JsonIgnore
	private LocalDate validTill=dateOfIssue.plusYears(20);
	@ManyToOne
	@JoinColumn(name="rtoid")
	private RTOOffice issuedBy;
	
	
	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}
	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public LocalDate getValidTill() {
		return validTill;
	}
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	public RTOOffice getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(RTOOffice issuedBy) {
		this.issuedBy = issuedBy;
	}
	
	
	public DrivingLicense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DrivingLicense(String drivingLicenseNumber, Application application, LocalDate dateOfIssue, LocalDate validTill,
			RTOOffice issuedBy) {
		super();
		this.drivingLicenseNumber = drivingLicenseNumber;
		this.application = application;
		this.dateOfIssue = dateOfIssue;
		this.validTill = validTill;
		this.issuedBy = issuedBy;
	}
	
	
	@Override
	public String toString() {
		return "DrivingLicense [drivingLicenseNumber=" + drivingLicenseNumber + ", application=" + application
				+ ", dateOfIssue=" + dateOfIssue + ", validTill=" + validTill + ", issuedBy=" + issuedBy + "]";
	}
	
	
	
	
}
