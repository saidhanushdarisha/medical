package com.quickcare.QuickCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickcare.QuickCare.Model.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

}
