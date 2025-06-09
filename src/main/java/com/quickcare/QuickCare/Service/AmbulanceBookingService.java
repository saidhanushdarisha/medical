package com.quickcare.QuickCare.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickcare.QuickCare.Model.AmbulanceBooking;
import com.quickcare.QuickCare.Repository.AmbulanceBookingRepository;


@Service
public class AmbulanceBookingService {

    @Autowired
    private AmbulanceBookingRepository repository;

    public AmbulanceBooking saveBooking(AmbulanceBooking booking) {
        return repository.save(booking);
    }

	public List<AmbulanceBooking> getAllBookings() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}

