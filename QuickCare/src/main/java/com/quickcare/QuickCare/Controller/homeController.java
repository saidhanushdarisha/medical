package com.quickcare.QuickCare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quickcare.QuickCare.Model.Doctor;
import com.quickcare.QuickCare.Model.DoctorAppointment;
import com.quickcare.QuickCare.Model.Hospital;
import com.quickcare.QuickCare.Service.AmbulanceBookingService;
import com.quickcare.QuickCare.Service.DoctorAppointmentService;
import com.quickcare.QuickCare.Service.DoctorService;
import com.quickcare.QuickCare.Service.HospitalService;
import com.quickcare.QuickCare.Service.MedicineBookingService;
import com.quickcare.QuickCare.Service.OpAppointmentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class homeController {
	
	
    @Autowired
    private OpAppointmentService opService;

    @Autowired
    private AmbulanceBookingService ambulanceService;

    @Autowired
    private MedicineBookingService medicineService;

    @Autowired
    private DoctorAppointmentService doctorAppointmentService;
    
    @Autowired
    private HospitalService hospitalService;
    
    @Autowired
    private DoctorService doctorService;
    
    @GetMapping("/home")
    public String homepage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "home";
    }



    
    
    

    @GetMapping("/getHospitals")
    public String getHospitals(Model model) {
        List<Hospital> hospitals = hospitalService.getHospitals();
        model.addAttribute("hospitals", hospitals);
        return "Hospitals"; // Ensure you have a Hospitals.html template
    }

    @GetMapping("/getDoctors")
    public String getDoctors(Model model) {
        List<Doctor> doctors = doctorService.getDoctors();
        model.addAttribute("doctors", doctors);
        return "doctors"; // Ensure you have a doctors.html template
    }

    @GetMapping("/opbooking")
    public String showBookingForm(Model model) {
        return "opbooking"; // Ensure you have an opbooking.html template
    }
    
    
    
    @GetMapping("/Ambulance")
    public String showAmbulanceBookingForm(Model model) {
        return "Ambulance"; // Ensure you have an opbooking.html template
    }
    
    @GetMapping("/Medicines")
    public String showMedicinesBookingForm(Model model) {
        return "Medicines"; // Ensure you have an opbooking.html template
    }
    @GetMapping("/book-appointment/{doctorId}")
    public String showBookingForm(@PathVariable int doctorId, Model model) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        model.addAttribute("doctor", doctor);
        model.addAttribute("appointment", new DoctorAppointment()); // form-binding object
        return "doctorAppointment"; // Thymeleaf form page
    }
    
    
    @GetMapping("/ordersHistory")
    public String ordersHistory(Model model) {
    	model.addAttribute("opBookings", opService.getAllBookings());
        model.addAttribute("medicineBookings", medicineService.getAllBookings());
        model.addAttribute("ambulanceBookings", ambulanceService.getAllBookings());
        return "ordersHistory"; // Ensure you have an opbooking.html template
    }
    
}
