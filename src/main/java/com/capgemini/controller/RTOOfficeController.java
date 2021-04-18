package com.capgemini.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.model.RTOOffice;
import com.capgemini.service.RTOOfficeService;

@RestController
public class RTOOfficeController {
	@Autowired
	private RTOOfficeService officeservice;
	
	@GetMapping(path="/alloffices")
	public List<RTOOffice> retreiveAllOffices() 
	{
		System.out.println("Inside retrieveAllUsers() of RTOOfficeController");
		return officeservice.findAllOffices();
	}
	
	@PostMapping(path = "/addoffice")
	public String AddRTOOffice(@Valid @RequestBody RTOOffice office)
	{
		System.out.println("Inside create of addOffice()");
		return officeservice.addRTOOffice(office);
	}
}
