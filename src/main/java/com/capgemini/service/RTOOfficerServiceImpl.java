package com.capgemini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.ApplicationNotFoundException;
import com.capgemini.exception.CannotGenerateDrivingLicenseException;
import com.capgemini.exception.CannotGenerateLearnerLicenseException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.RTOOfficerNotFoundException;
import com.capgemini.model.Application;
import com.capgemini.model.DrivingLicense;
import com.capgemini.model.RTOOfficer;
import com.capgemini.repository.IApplicationJpaRepository;
import com.capgemini.repository.IDrivingLicenseJpaRepository;
import com.capgemini.repository.IRTOOfficerJpaRepository;

@Service
public class RTOOfficerServiceImpl implements IRTOOfficerService {
	@Autowired
	private IDrivingLicenseJpaRepository dlrepos;
	@Autowired
	private IRTOOfficerJpaRepository officerrepos;
	@Autowired
	private IApplicationJpaRepository apprepos;
	
	@Override
	public String officerLogin(RTOOfficer officer) throws RTOOfficerNotFoundException, InvalidLoginCredentialsException {
		if(officerrepos.existsById(officer.getUsername()))
        {      
//			RTOOfficer u=officerrepos.findById(officer.getUsername()).get();
			RTOOfficer u=officerrepos.getOne(officer.getUsername());
	        if(officer.getPassword().equals(u.getPassword()))
            {
	        	System.out.println("Correct credentials");
                return "Login Successful";
                
            }   	
        	throw new InvalidLoginCredentialsException("Incorrect Password entered");
        }
        throw new RTOOfficerNotFoundException("Incorrect Officer username entered");
	}

	@Override
	public String viewAllPendingApplications() throws NoRecordsFoundException {
		System.out.println(officerrepos.findAllPendingApplications());
		if(officerrepos.findAllPendingApplications().isEmpty())
			throw new NoRecordsFoundException("No Pending Applications found");
		return officerrepos.findAllPendingApplications().toString();
	}

	@Override
	public String viewAllRejectedApplications() throws NoRecordsFoundException{
		if(officerrepos.findAllRejectedApplications().isEmpty())
			throw new NoRecordsFoundException("No Rejected Applications found");
		return officerrepos.findAllRejectedApplications().toString();
	}

	@Override
	public String viewAllApprovedApplications() throws NoRecordsFoundException {
		if(officerrepos.findAllApprovedApplications().isEmpty())
			throw new NoRecordsFoundException("No Approved Applications found");
		return officerrepos.findAllApprovedApplications().toString();
	}

	@Override
	public Application viewApplicationById(int applicationNumber) {
		System.out.println(apprepos.findById(applicationNumber).get());
		return apprepos.findById(applicationNumber).get();
	}

	public String modifyTestresultById(int applicationno,String testResult) throws ApplicationNotFoundException, NullInputException
    {
        if(applicationno==0)
            throw new NullInputException("Empty Input");
        else
        {
        return "Result Succesfully Updated";
        }
    }
	
	@Override
	public String modifyTestResultById(int applicationNumber,String result) throws ApplicationNotFoundException, NullInputException {
		if(applicationNumber!=0 && result!=null)
		{
			Optional<Application> optapp=apprepos.findById(applicationNumber);
			if(optapp.isPresent())
			{
				optapp.get().getAppointment().setTestResult(result);	
				apprepos.save(optapp.get());
				return "Result Succesfully Updated";
			}
			throw new ApplicationNotFoundException("Application with applicationNumber "+applicationNumber+"not found");
		}
		throw new NullInputException("Values entered are invalid");
}

	@Override
	public String generateLearnerLicense(int applicationNumber) throws CannotGenerateLearnerLicenseException 
	{
			Application app = apprepos.findById(applicationNumber).get();
			DrivingLicense dl1 = new DrivingLicense();		
			String res = app.getAppointment().getTestResult();
				if(res.equalsIgnoreCase("passed")) 
				{
				dl1.setApplication(app);
				dl1.setDrivingLicenseNumber("LL-MH"+applicationNumber);
				dlrepos.save(dl1);
				return "Driving License generated successfully";
				}
				throw new CannotGenerateLearnerLicenseException("Driving Test needs to be passed");
	}

	@Override
	public String generateDrivingLicense(int applicationNumber) throws CannotGenerateDrivingLicenseException
		{
			Application app = apprepos.findById(applicationNumber).get();
			DrivingLicense dl1 = new DrivingLicense();		
			String res = app.getAppointment().getTestResult();
				if(res.equalsIgnoreCase("passed")) 
				{
				dl1.setApplication(app);
				dl1.setDrivingLicenseNumber("MH"+applicationNumber);
				dlrepos.save(dl1);
				return "Driving License generated successfully";
				}
				throw new CannotGenerateDrivingLicenseException("Driving Test needs to be passed");
	}
	   
}
