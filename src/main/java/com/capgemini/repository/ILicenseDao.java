package com.capgemini.repository;

import java.util.List;
import com.capgemini.model.*;

public interface ILicenseDao {
	public String createLLRequest(Application llApplication);
	public String createDLRequest(Application dlApplication);
	public String saveDocuments(int appno, Documents documents);
	public String payFees(int amount);
	public String updateSlotLLTest(int appno,Appointment appointment);
	public String updateSlotDLTest(int appno,Appointment appointment);
	public List<Appointment> readAvailableSlots();
	public String updateLL(Application llApplication);
	public String updateDL(Application dlApplication);
	public String cancelAppointment(int appno,Appointment appointment);
}