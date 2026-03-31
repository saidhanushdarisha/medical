package com.quickcare.QuickCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.quickcare.QuickCare.Model.Doctor;
import com.quickcare.QuickCare.Model.Hospital;
import com.quickcare.QuickCare.Repository.DoctorRepo;
import com.quickcare.QuickCare.Repository.HospitalRepo;
import com.quickcare.QuickCare.Repository.UserRepo;
import com.quickcare.QuickCare.Service.DoctorService;

@Controller
public class adminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private HospitalRepo hospitalRepo;

    @Autowired
    private UserRepo userRepo;

    // ✅ Admin Home Page
    @GetMapping("/Adminhome")
    public String adminHome() {
        return "Admin";  // HTML: admin-home.html
    }

    // ✅ Doctors List
    @GetMapping("/DoctorsList")
    public String getDoctors(Model model) {
        model.addAttribute("doctors", doctorService.findAll());
        return "doctors-list";  // HTML: doctors-list.html
    }

    // ✅ Doctor Update Form
    @GetMapping("/doctor/update/{id}")
    public String updateDoctorForm(@PathVariable int id, Model model) {
        model.addAttribute("doctor", doctorService.findById(id));
        return "update-doctor";  // shows the form pre-filled with doctor data
    }
    
    
    @PostMapping("/doctor/update")
    public String updateDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.save(doctor);  // save() will either update or insert based on ID
        return "redirect:/DoctorsList";  // go back to the list after update
    }

    // ✅ Delete Doctor
    @GetMapping("/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorService.deleteById(id);
        return "redirect:/DoctorsList";
    }

    // ✅ Hospitals List
    @GetMapping("/HospitalsList")
    public String getHospitals(Model model) {
        model.addAttribute("hospitals", hospitalRepo.findAll());
        return "hospitals-list";  // HTML: hospitals-list.html
    }
    @GetMapping("/hospital/update/{id}")
    public String updateHospitalForm(@PathVariable int id, Model model) {
        model.addAttribute("hospital", hospitalRepo.findById(id).orElse(null));
        return "update-hospital";  // points to update-hospital.html
    }

    // ✅ Delete Hospital
    @GetMapping("/hospital/delete/{id}")
    public String deleteHospital(@PathVariable int id) {
        hospitalRepo.deleteById(id);
        return "redirect:/HospitalsList";
    }

    // ✅ Users List
    @GetMapping("/usersList")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "users-list";  // HTML: users-list.html
    }
    
    @PostMapping("/hospital/update")
    public String updateHospital(@ModelAttribute("hospital") Hospital hospital) {
        hospitalRepo.save(hospital);  // updates existing hospital by ID
        return "redirect:/HospitalsList";  // redirects to hospital list after update
    }

    // ✅ Delete User
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepo.deleteById(id);
        return "redirect:/usersList";
    }
}
