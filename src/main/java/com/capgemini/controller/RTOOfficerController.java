package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.capgemini.service.RTOOfficerServiceImpl;

@RestController
public class RTOOfficerController {
	@Autowired
	private RTOOfficerServiceImpl officerserv;
	
	@PostMapping(path = "/officerlogin")
	public String officerLogin(@Valid @RequestBody RTOOfficer officer) throws RTOOfficerNotFoundException, InvalidLoginCredentialsException
	{
		officerserv.officerLogin(officer);
		return "Login Successful";
	}
	
	@GetMapping(path="/applications/pending")
	public String viewAllPendingApplications() throws NoRecordsFoundException
	{
		System.out.println(officerserv.viewAllPendingApplications());
		return officerserv.viewAllPendingApplications().toString();
	}
	
	@GetMapping(path="/applications/rejected")
	public String viewAllRejectedApplications() throws NoRecordsFoundException
	{
		return officerserv.viewAllRejectedApplications();
	}
	
	@GetMapping(path="/applications/approved")
	public String viewAllApprovedApplications() throws NoRecordsFoundException
	{
		return officerserv.viewAllApprovedApplications().toString();
	}
	
	@GetMapping(path="/applications/{id}")
	public String viewApplicationById(@PathVariable("id") int a)
	{
		return officerserv.viewApplicationById(a).toString();
	}
	
	
	@PostMapping(path = "/application/modifyresult")
	public String modifyResult(@Valid @RequestBody int a,String result) throws ApplicationNotFoundException, NullInputException
	{
		return officerserv.modifyTestResultById(a,result);
	}
	
	@PostMapping(path="/license/generatell")
	public String generateLearnerLicense(@Valid @RequestBody int appno) throws CannotGenerateLearnerLicenseException
	{
		return officerserv.generateLearnerLicense(appno);
	}
	
	@PostMapping(path="/license/generatedl")
	public String generateDrivingLicense(@Valid @RequestBody int appno) throws CannotGenerateDrivingLicenseException
	{
		return officerserv.generateDrivingLicense(appno);
	}
}
