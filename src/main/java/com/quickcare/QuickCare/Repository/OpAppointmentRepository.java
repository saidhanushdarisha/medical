package com.quickcare.QuickCare.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickcare.QuickCare.Model.OpAppointment;

@Repository
public interface OpAppointmentRepository extends JpaRepository<OpAppointment, Integer> {
}

