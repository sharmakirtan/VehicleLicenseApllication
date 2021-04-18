package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.model.User;
@Repository
public interface IUserJpaRepository extends JpaRepository<User, String> {
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.email=:email,u.password=:pass WHERE u.email=:email")
	public void updateUser(@Param("email") String email,@Param("pass") String pass);
}
