package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.AgeNotValidException;
import com.capgemini.exception.DuplicateRequestException;
import com.capgemini.exception.NullInputException;
import com.capgemini.model.*;
import com.capgemini.service.LicenseServiceImpl;

@RestController
public class LicenseController {
	@Autowired
	private LicenseServiceImpl licenseserv;
	
	@PostMapping(path = "/applyforll")
	public void applyForLL(@Valid @RequestBody Application llApplication) throws DuplicateRequestException, NullInputException, AgeNotValidException
	{
		System.out.println("Inside applyForLL()");
		String str=licenseserv.applyForLL(llApplication);
		System.out.println(str);
	}
	
	@PostMapping(path = "/applyfordl")
	public void applyForDL(@Valid @RequestBody Application dlApplication) throws DuplicateRequestException, NullInputException, AgeNotValidException
	{
		System.out.println("Inside applyForDL()");
		String str=licenseserv.applyForDL(dlApplication);
		System.out.println(str);
	}
	
	@PostMapping(path = "/uploaddocuments")
	public String uploadDocuments(@Valid @RequestBody int appnumber,Documents documents) throws NullInputException
	{
		System.out.println("Inside uploadDocuments()");
		return licenseserv.uploadDocuments(appnumber,documents);
	}
	
	@GetMapping(path="/license/appointments")
	public List<Appointment> getAvailableSlots() 
	{
		System.out.println("Inside List<Appointment> getAvailableSlots() of LicenseController");
		return licenseserv.getAvailableSlots();
	}
	
	@PostMapping(path = "/bookslotlltest")
	public String bookSlotLLTest(@Valid @RequestBody int applicationNumber, Appointment appointment)
	{
		System.out.println("Inside bookSlotLLTest()");
		return licenseserv.bookSlotLLTest(applicationNumber, appointment);
	}
	
	@PostMapping(path = "/bookslotdltest")
	public String bookSlotDLTest(@Valid @RequestBody int applicationNumber,  Appointment appointment)
	{
		System.out.println("Inside bookSlotDLTest()");
		return licenseserv.bookSlotDLTest(applicationNumber, appointment);
	}
	
	@PostMapping(path = "/renewll")
	public String renewLL(@Valid @RequestBody Application llApplication) throws DuplicateRequestException, NullInputException
	{
		System.out.println("Inside renewll()");
		return licenseserv.renewLL(llApplication);
	}
	
	@PostMapping(path = "/renewdl")
	public String renewDL(@Valid @RequestBody Application dlApplication) throws DuplicateRequestException, NullInputException
	{
		System.out.println("Inside renewdl()");
		return licenseserv.renewDL(dlApplication);
	}
	

	@DeleteMapping(path ="/cancelappointment/{applicationnumber}")
	public String cancelAppointment(@PathVariable("applicationnumber") int appno) throws NullInputException {
		System.out.println("Inside cancelAppointment()");
		licenseserv.cancelAppointment(appno);
		return "Delete Succesfull";
		
	}
}
