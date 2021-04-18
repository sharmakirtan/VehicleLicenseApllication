package com.capgemini.model;

import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {
	// LL - Online Test. DL - Driving Test
	// RTO officer has to set the test result because conducting test is out of scope
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appointment_seq")
	@SequenceGenerator(name="appointment_seq",sequenceName="appointment_seq", allocationSize=1)
	@JsonIgnore
	private int appointmentNumber;
	private String testDate;
	private String timeSlot;
	private String testResult;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "officer_username")
	private RTOOfficer approver;
	
	
	public int getAppointmentNumber() {
		return appointmentNumber;
	}
	public void setAppointmentNumber(int appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public RTOOfficer getApprover() {
		return approver;
	}
	public void setApprover(RTOOfficer approver) {
		this.approver = approver;
	}
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Appointment(int appointmentNumber, String testDate, String timeSlot, String testResult,
			RTOOfficer approver) {
		super();
		this.appointmentNumber = appointmentNumber;
		this.testDate = testDate;
		this.timeSlot = timeSlot;
		this.testResult = testResult;
		this.approver = approver;
	}
	
	
	@Override
	public String toString() {
		return "Appointment [appointmentNumber=" + appointmentNumber + ", testDate=" + testDate + ", timeSlot="
				+ timeSlot + ", testResult=" + testResult + ", approver=" + approver + "]";
	}
	
	
}
