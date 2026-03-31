package com.quickcare.QuickCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickcare.QuickCare.Model.Doctor;
import com.quickcare.QuickCare.Model.DoctorAppointment;


@Repository
public interface DoctorAppointmentRepo extends JpaRepository<DoctorAppointment, Integer> {

	void save(Doctor appointment);

}
