package com.quickcare.QuickCare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickcare.QuickCare.Model.MedicineBooking;
import com.quickcare.QuickCare.Repository.MedicineBookingRepository;

@Service
public class MedicineBookingService {

    @Autowired
    private MedicineBookingRepository repository;

    public MedicineBooking saveBooking(MedicineBooking booking) {
        return repository.save(booking);
    }

	public List<MedicineBooking> getAllBookings() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}

