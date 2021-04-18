package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.model.*;

public interface IApplicantJpaRepository extends JpaRepository<Applicant, Integer> {
	
	@Query("select c from Applicant c join c.user where c.user.email=:em")
	public Applicant getApplicantnoByEmail(@Param("em") String em);
	
}
