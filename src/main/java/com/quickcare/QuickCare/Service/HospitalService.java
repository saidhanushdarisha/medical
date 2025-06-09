package com.quickcare.QuickCare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickcare.QuickCare.Model.Hospital;
import com.quickcare.QuickCare.Repository.HospitalRepo;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepo repo;

	public List<Hospital> getHospitals() {
		
		
		return repo.findAll();
	}
	
	
	

}
