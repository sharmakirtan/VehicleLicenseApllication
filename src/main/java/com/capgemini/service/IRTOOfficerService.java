package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.ApplicationNotFoundException;
import com.capgemini.exception.CannotGenerateDrivingLicenseException;
import com.capgemini.exception.CannotGenerateLearnerLicenseException;
import com.capgemini.exception.CannotUpdateApplicationException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.exception.NullInputException;
import com.capgemini.exception.RTOOfficerNotFoundException;
import com.capgemini.model.Application;
import com.capgemini.model.DrivingLicense;
import com.capgemini.model.RTOOfficer;

public interface IRTOOfficerService {
	public String officerLogin(RTOOfficer officer) throws InvalidLoginCredentialsException, RTOOfficerNotFoundException;;
	public String viewAllPendingApplications() throws NoRecordsFoundException;
	public String viewAllRejectedApplications() throws NoRecordsFoundException;
	public String viewAllApprovedApplications()  throws NoRecordsFoundException;
	public Application viewApplicationById(int applicationNumber)  throws ApplicationNotFoundException;
	public String modifyTestResultById(int applicationNumber,String result) throws CannotUpdateApplicationException, ApplicationNotFoundException, NullInputException;
	public String generateLearnerLicense(int applicationNumber) throws CannotGenerateLearnerLicenseException;
	public String generateDrivingLicense(int applicationNumber) throws CannotGenerateDrivingLicenseException;
}
