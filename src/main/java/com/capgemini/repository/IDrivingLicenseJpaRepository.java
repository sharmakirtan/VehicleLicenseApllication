package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.model.DrivingLicense;
@Repository
public interface IDrivingLicenseJpaRepository extends JpaRepository<DrivingLicense, String> {
	
	@Query("Select a from Application a where a.applicationNumber=?1")
	public DrivingLicense getByApplicationNumber(int appnlicationNumber);

}
