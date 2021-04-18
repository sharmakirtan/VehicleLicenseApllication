package com.capgemini.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.AgeNotValidException;
import com.capgemini.exception.DuplicateRequestException;
import com.capgemini.exception.NullInputException;
import com.capgemini.model.Application;
import com.capgemini.model.Appointment;
import com.capgemini.model.Documents;
import com.capgemini.repository.IApplicationJpaRepository;
import com.capgemini.repository.IAppointmentJpaRepository;
import com.capgemini.repository.IUserJpaRepository;

@Service
public class LicenseServiceImpl implements ILicenseService {
	@Autowired
	private IAppointmentJpaRepository apptrepos;
	@Autowired
	private IApplicationJpaRepository apprepos;
	@Autowired
	private IUserJpaRepository userrepos;
	
	
	@Override
	public String applyForLL(Application llApplication)  throws DuplicateRequestException, NullInputException, AgeNotValidException
	{
		if(llApplication!=null)
		{
			LocalDate dob=llApplication.getApplicant().getDateOfBirth();
			if(Period.between(dob, LocalDate.now()).getYears()>=16)
			{	
//				if(userrepos.existsById(llApplication.getApplicant().getUser().getEmail()))
//				throw new DuplicateRequestException("LL Application already exists");
//				else 
//				{
					apprepos.save(llApplication);
					return "LL application created successfully";
//				}
			}
			throw new AgeNotValidException("Minimum Age requirement is 16");
		}
		throw new NullInputException("Null Application cannot be accepted");
	}
	
	
	@Override
	public String applyForDL(Application dlApplication)  throws DuplicateRequestException, NullInputException, AgeNotValidException
	{
		System.out.println("inside applyDL");
		if(dlApplication!=null)
		{
			LocalDate dob=dlApplication.getApplicant().getDateOfBirth();
			if(Period.between(dob, LocalDate.now()).getYears()>=18)
			{
//				if(userrepos.existsById(dlApplication.getApplicant().getUser().getEmail()))
//				throw new DuplicateRequestException("DL Application already exists");
//				else 
//				{
					apprepos.save(dlApplication);
					return "DL application created successfully";
//				}
			}
			throw new AgeNotValidException("Minimum Age requirement is 18");
		}
		throw new NullInputException("Null Application cannot be accepted");
	}

	@Override
	public String uploadDocuments(int applicantionNo,Documents documents) throws NullInputException {
		if(documents!=null && applicantionNo!=0)
		{
			Optional<Application> optapp=apprepos.findById(applicantionNo);
			Application app=optapp.get();
			documents.setDocId(applicantionNo);
			app.setDocuments(documents);
			app.setApplicationNumber(applicantionNo);
			apprepos.save(app);
			return "Documents uploaded Successfully";
		}
		else
		throw new NullInputException("No Documents uploaded");
	}

	@Override
	public String payFees(int amount) {
		//logic for fees payment
		return "Fees paid successfully";
	}

	@Override
	public String emailFeesReceipt(String email) {
		//logic for fees sending
		return "Email Receipt sent to your email";
	}

	@Override
	public String bookSlotLLTest(int applicationno, Appointment appointment) {
		{
			Optional<Application> optapp=apprepos.findById(applicationno);
			Application llapplication=optapp.get();
			appointment.setAppointmentNumber(applicationno);
			llapplication.setAppointment(appointment);
			apprepos.save(llapplication);
			return "Update successful";
		}
	}

	@Override
	public String bookSlotDLTest(int applicationno, Appointment appointment) {
		Optional<Application> optapp=apprepos.findById(applicationno);
		Application app=optapp.get();
		appointment.setAppointmentNumber(applicationno);
		app.setAppointment(appointment);
		apprepos.save(app);
		return "Update successful";
	}

	@Override
	public List<Appointment> getAvailableSlots() {
		return apptrepos.findAll();
		
	}

	@Override
	public String renewLL(Application llApplication) throws DuplicateRequestException, NullInputException
	{
		if(llApplication!=null)
		{
			if(userrepos.existsById(llApplication.getApplicant().getUser().getEmail()))
			{
				apprepos.save(llApplication);
				return "LL application created successfully";
			}
				else 
				{
					throw new DuplicateRequestException("LL Application does not exist");
				}
		}
		throw new NullInputException("Null Application cannot be accepted");
	}

	@Override
	public String renewDL(Application dlApplication) throws DuplicateRequestException, NullInputException
	{
		if(dlApplication!=null)
		{
			if(userrepos.existsById(dlApplication.getApplicant().getUser().getEmail()))
			{
				apprepos.save(dlApplication);
				return "DL application created successfully";
			}
				else 
					throw new DuplicateRequestException("DL Application does not exist");
		}
		throw new NullInputException("Null Application cannot be accepted");
	}

	@Override
	public String cancelAppointment(int applicationno) throws NullInputException 
	{
		if(applicationno>=0)
		{
			if(apprepos.existsById(applicationno))
			{
				Application app=apprepos.findById(applicationno).get();
				int apptno=app.getAppointment().getAppointmentNumber();
				Appointment appt=new Appointment(apptno,null,null,null,null);
				app.setAppointment(appt);
				apprepos.save(app);
				return "Appointment cancelled";
			}
		}
		throw new NullInputException("Invalid input entered");
	}
	
}