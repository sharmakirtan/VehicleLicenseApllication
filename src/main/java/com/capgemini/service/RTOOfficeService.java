package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.repository.IRTOOfficeJpaRepository;
import com.capgemini.model.RTOOffice;

@Service
public class RTOOfficeService {
	@Autowired
	private IRTOOfficeJpaRepository officedao;
	
	public String addRTOOffice(RTOOffice office)
	{
		officedao.save(office);
		return "Office added successfully";
	}
	
	public List<RTOOffice> findAllOffices()
	{
		return officedao.findAll();
	}
	
}
