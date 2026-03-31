package com.quickcare.QuickCare.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.quickcare.QuickCare.Model.AmbulanceBooking;

public interface AmbulanceBookingRepository extends JpaRepository<AmbulanceBooking, Integer> {
}

