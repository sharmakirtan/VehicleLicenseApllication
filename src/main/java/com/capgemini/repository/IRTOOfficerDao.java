package com.capgemini.repository;

import java.util.List;

import com.capgemini.exception.ApplicationNotFoundException;
import com.capgemini.exception.RTOOfficerNotFoundException;
import com.capgemini.model.Application;
import com.capgemini.model.DrivingLicense;
import com.capgemini.model.RTOOfficer;

public interface IRTOOfficerDao {
	public String login(RTOOfficer officer) throws RTOOfficerNotFoundException;
	public List<Application> getAllPendingApplications();
	public List<Application> getAllRejectedApplications();
	public List<Application> getAllApprovedApplications();
	public Application getApplicationById(int applicationNumber);
	public Application updateApplication(Application application) throws ApplicationNotFoundException;
}
