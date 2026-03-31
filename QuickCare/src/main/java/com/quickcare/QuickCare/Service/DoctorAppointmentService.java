package com.quickcare.QuickCare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickcare.QuickCare.Model.AmbulanceBooking;
import com.quickcare.QuickCare.Model.Doctor;
import com.quickcare.QuickCare.Model.DoctorAppointment;
import com.quickcare.QuickCare.Repository.DoctorAppointmentRepo;


@Service
public class DoctorAppointmentService {
	
	@Autowired
	DoctorAppointmentRepo repo;
	
	

	public DoctorAppointment saveBooking(DoctorAppointment booking) {
        return repo.save(booking);
    }
 
}
