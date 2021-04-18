package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Documents;
@Repository
public interface IDocumentsJpaRepository extends JpaRepository<Documents, Integer> {

}
