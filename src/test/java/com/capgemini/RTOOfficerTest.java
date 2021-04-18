package com.capgemini;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.exception.ApplicationNotFoundException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.RTOOfficerNotFoundException;
import com.capgemini.model.Application;
import com.capgemini.model.RTOOffice;
import com.capgemini.model.RTOOfficer;
import com.capgemini.repository.IApplicationJpaRepository;
import com.capgemini.repository.IAppointmentJpaRepository;
import com.capgemini.repository.IRTOOfficerJpaRepository;
import com.capgemini.service.RTOOfficerServiceImpl;


@SpringBootTest
public class RTOOfficerTest {
	@MockBean
    IRTOOfficerJpaRepository rtoOfficerRepo;
	
	@MockBean
	private IApplicationJpaRepository apprepos;
	
	@MockBean
	private IAppointmentJpaRepository appointrepos;


	@Autowired
	RTOOfficerServiceImpl rtoOfficerServiceImpl;
	@Test
	public void testOfficerLogin() throws RTOOfficerNotFoundException, InvalidLoginCredentialsException {
		RTOOfficer rtoOfficer= getRtoOfficer();
		when(rtoOfficerRepo.getOne(rtoOfficer.getUsername())).thenReturn(rtoOfficer);
		when(rtoOfficerRepo.existsById(rtoOfficer.getUsername())).thenReturn(true);
		assertEquals("Login Successful", rtoOfficerServiceImpl.officerLogin(rtoOfficer));
	}
	@Test
	void testGetAllPendingApplicationShouldThrowNoRecordsFoundException()
			throws NoRecordsFoundException {
		when(rtoOfficerRepo.findAllPendingApplications()).thenThrow(NoRecordsFoundException.class);
		assertThrows(NoRecordsFoundException.class,()->rtoOfficerServiceImpl.viewAllPendingApplications());	
	}

	@Test
	void testGetAllRejectedApplicationShouldThrowNoRecordsFoundException()
			throws NoRecordsFoundException {
		when(rtoOfficerRepo.findAllRejectedApplications()).thenThrow(NoRecordsFoundException.class);
		assertThrows(NoRecordsFoundException.class,()->rtoOfficerServiceImpl.viewAllRejectedApplications());	
	}
	
	@Test
	void testGetAllApprovedApplicationShouldThrowNoRecordsFoundException()
			throws NoRecordsFoundException {
		when(rtoOfficerRepo.findAllApprovedApplications()).thenThrow(NoRecordsFoundException.class);
		assertThrows(NoRecordsFoundException.class,()->rtoOfficerServiceImpl.viewAllApprovedApplications());	
	}

	@Test
	void testToGetTheApplicationByUsingApplicationNumber() throws ApplicationNotFoundException {
		Application a = new Application();
		a.setApplicationNumber(12345);
		when(apprepos.findById(12345)).thenReturn(Optional.of(a));
		assertEquals(a, rtoOfficerServiceImpl.viewApplicationById(a.getApplicationNumber()));
	}
	
	@Test
    public void testModifyTestresultById() throws ApplicationNotFoundException, NullInputException {
        Application application = new Application();
        application.setApplicationNumber(1234);
        application.setApplicationDate(LocalDate.now());
        application.setRemarks("good");
        Optional<Application> optapp=Optional.of(application);
        String result="passed";
        //when(apprepos.findById(1234)).thenReturn(Optional.of(application));
        //when(optapp.isPresent()).thenReturn(true);
        when(apprepos.save(optapp.get())).thenReturn(application);
  
//        String updateApp = rtoOfficerServiceImpl.modifyTestResultById(1234, "passed");
        assertEquals("Result Succesfully Updated", rtoOfficerServiceImpl.modifyTestresultById(1234, "passed"));
    }
	
	
	public RTOOfficer getRtoOfficer()
	{
		String username="prasad6699@gmail.com";
		String password="p12123";
		RTOOffice rtoOffice=getRtoOffice();
		RTOOfficer rtoOfficer=new RTOOfficer(username,password,rtoOffice);
		return rtoOfficer;
	}
	
	public RTOOffice getRtoOffice()
	{
		int rtoID=10;
		String rtoName="mumbai";
		RTOOffice rtoOffice=new RTOOffice(rtoID,rtoName);
		return rtoOffice;
	}
	

}
