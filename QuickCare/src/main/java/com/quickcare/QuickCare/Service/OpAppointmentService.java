package com.quickcare.QuickCare.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.quickcare.QuickCare.Model.OpAppointment;
import com.quickcare.QuickCare.Repository.OpAppointmentRepository;


@Service
public class OpAppointmentService {

    @Autowired
    private  OpAppointmentRepository repo;

    public OpAppointment saveAppointment(OpAppointment appointment) {
        return repo.save(appointment);
    }

	public  List<OpAppointment> getAllBookings() {
		return repo.findAll();
	}
}
