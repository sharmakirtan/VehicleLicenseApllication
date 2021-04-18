package com.capgemini;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.exception.NullInputException;
import com.capgemini.model.Applicant;
import com.capgemini.model.Application;
import com.capgemini.model.Appointment;
import com.capgemini.model.Documents;
import com.capgemini.model.RTOOffice;
import com.capgemini.model.RTOOfficer;
import com.capgemini.repository.IApplicationJpaRepository;
import com.capgemini.repository.IAppointmentJpaRepository;
import com.capgemini.repository.IUserJpaRepository;
import com.capgemini.service.LicenseServiceImpl;

@SpringBootTest(classes = VehicleLicense2Application.class)
public class LicenseServiceImplTest{
	@Autowired
	private LicenseServiceImpl service;
	@MockBean
	private IUserJpaRepository userrepos;
	@MockBean
	private IApplicationJpaRepository apprepos;
	@MockBean
	private IAppointmentJpaRepository apptrepos;
	@Test
	public void  testUploadDocuments() throws NullInputException
	{
		Documents documents=getDocument();
		Application application=getApplication();
		//int applicantionNo=application.getApplicationNumber();
		when(apprepos.findById(102)).thenReturn(Optional.of(application));
		when(apprepos.save(application)).thenReturn(application);
		assertEquals("Documents uploaded Successfully",service.uploadDocuments(102, documents));
	}
	
	@Test
	public void testPayFees() {
		assertEquals("Fees paid successfully",service.payFees(100));
	}
	
	@Test
	public void testEmailFeesReceipt() {
		assertEquals("Email Receipt sent to your email",service.emailFeesReceipt("kirtansharma@gmail.com"));
	}
	
	@Test
	public void testBookSlotLLTest()
	{
		Application llapplication=getApplication();
		Appointment appointment=getAppointment();
		Optional<Application> optapp=Optional.of(llapplication);
		when(apprepos.findById(102)).thenReturn(optapp);
		when(apprepos.save(llapplication)).thenReturn(llapplication);
		assertEquals("Update successful",service.bookSlotDLTest(102, appointment));
	}
	
	@Test
	public void testBookSlotDLTest()
	{
		Application llapplication=getApplication();
		Appointment appointment=getAppointment();
		Optional<Application> optapp=Optional.of(llapplication);
		when(apprepos.findById(102)).thenReturn(optapp);
		when(apprepos.save(llapplication)).thenReturn(llapplication);
		assertEquals("Update successful",service.bookSlotDLTest(102, appointment));
	}
	
	@Test
	public void testGetAvailableSlots() {
		Appointment a = getAppointment(),b=getAppointment(),c=getAppointment(),d=getAppointment();
		List<Appointment> appointmentList=new ArrayList<>();
		appointmentList.add(a);
		appointmentList.add(b);
		appointmentList.add(c);
		appointmentList.add(d);
		when(apptrepos.findAll()).thenReturn(appointmentList);
		assertEquals(4,service.getAvailableSlots().size());
		
	}
	private Appointment getAppointment() {
		return new Appointment(2, "19-04-2021", "12:00:00","pass", getOfficer());
	}
	private RTOOfficer getOfficer()
	{
		return new RTOOfficer("prasad12@gmail.com","prasad",getOffice()) ;
	}
	private RTOOffice getOffice()
	{
		return new RTOOffice(10,"goa");
	}

	public Documents getDocument()
	{
		return new  Documents(1,"photo","idproof","addressProof");
	}

	public Applicant getApplicant()
	{
		Applicant applicant = new Applicant();
		applicant.setApplicantId(10);
		applicant.setFullName("Jeev");
		applicant.setMobile("879645890");
		applicant.setDateOfBirth(LocalDate.of(1998, Month.DECEMBER, 20));
		return applicant;
	}
	public Application getApplication()
	{
		Application application=new Application();
		application.setApplicationNumber(102);
		application.setApplicationDate(LocalDate.now());
		application.setApplicant(getApplicant());
		return application;
	}
}