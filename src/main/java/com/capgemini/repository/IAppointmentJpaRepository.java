package com.capgemini.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.Appointment;
import com.capgemini.model.RTOOfficer;
@Repository
public interface IAppointmentJpaRepository extends JpaRepository<Appointment, Integer> {

//	@Modifying
//	@Transactional
//	@Query("UPDATE Application a SET a.testDate=:testDate,a.timeSlot=:timeSlot WHERE a.appointmentNumber=:appointmentNumber")
//	public void updateSlotTest(@Param("testDate") Date testDate,@Param("timeSlot") String timeSlot,@Param("appointmentNumber") int appointmentNumber );
//	@Modifying
//	@Transactional
//	@Query("UPDATE Application a SET a.testDate=:testDate,a.timeSlot=:timeSlot,a.testResult=:testResult,a.approver=:approver WHERE a.appointmentNumber=:appointmentNumber")
//	public void updateLicense(@Param("testDate") Date testDate,@Param("timeSlot") String timeSlot,@Param("appointmentNumber") int appointmentNumber,@Param("testResult") String testResult,@Param("approver") RTOOfficer approver );

}
