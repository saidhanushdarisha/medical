package com.quickcare.QuickCare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickcare.QuickCare.Model.Doctor;
import com.quickcare.QuickCare.Repository.DoctorRepo;

@Service
public class DoctorService {

	
	@Autowired
	DoctorRepo repo;

	public List<Doctor> getDoctors() {
		
		return repo.findAll();
	}

	@SuppressWarnings("deprecation")
	public Doctor getDoctorById(int doctorId) {

		return repo.getById(doctorId);
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void deleteById(int id) {
      repo.deleteById(id);		
	}

	public Object findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public void save(Doctor doctor) {
		// TODO Auto-generated method stub
		repo.save(doctor);
		
	}

	

	
	
}
