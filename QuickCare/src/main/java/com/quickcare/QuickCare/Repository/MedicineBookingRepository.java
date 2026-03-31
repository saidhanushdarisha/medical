package com.quickcare.QuickCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickcare.QuickCare.Model.MedicineBooking;

public interface MedicineBookingRepository extends JpaRepository<MedicineBooking, Integer> {
}

