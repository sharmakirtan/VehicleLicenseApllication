package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.exception.NoRecordsFoundException;
import com.capgemini.model.Application;
import com.capgemini.model.RTOOfficer;
@Repository
public interface IRTOOfficerJpaRepository extends JpaRepository<RTOOfficer, String> {
	 @Query("Select a from Application a where a.status='PENDING'")
	 List<Application> findAllPendingApplications() throws NoRecordsFoundException;
	 @Query("Select a from Application a where a.status='APPROVED'")
	 List<Application> findAllApprovedApplications() throws NoRecordsFoundException;
	 @Query("Select a from Application a where a.status='REJECTED'")
	 List<Application> findAllRejectedApplications() throws NoRecordsFoundException;
}
