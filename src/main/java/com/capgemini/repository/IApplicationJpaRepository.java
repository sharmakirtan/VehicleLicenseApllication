package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.model.Application;

@Repository
public interface IApplicationJpaRepository extends JpaRepository<Application, Integer>
{
	@Query("select a from Application a where appointmentNumber=:appointmentNumber")
	public Application getAppbyappointmentno(int appointmentNumber);
 
}
