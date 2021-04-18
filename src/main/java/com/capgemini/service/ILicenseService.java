package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.AgeNotValidException;
import com.capgemini.exception.DuplicateRequestException;
import com.capgemini.exception.NullInputException;
import com.capgemini.model.*;

public interface ILicenseService {
	public String applyForLL(Application llApplication) throws DuplicateRequestException, NullInputException, AgeNotValidException;
	public String applyForDL(Application dlApplication) throws DuplicateRequestException, NullInputException, AgeNotValidException;
	public String uploadDocuments(int appno,Documents documents) throws NullInputException;
	public String payFees(int amount);
	public String emailFeesReceipt(String email);
	public String bookSlotLLTest(int applicationno, Appointment appointment);
	public String bookSlotDLTest(int applicationno, Appointment appointment);
	public List<Appointment> getAvailableSlots();
	public String renewLL(Application llApplication) throws DuplicateRequestException, NullInputException;
	public String renewDL(Application dlApplication) throws DuplicateRequestException, NullInputException;
	public String cancelAppointment(int applicationno) throws NullInputException;
}
