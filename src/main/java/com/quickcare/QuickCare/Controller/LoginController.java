package com.quickcare.QuickCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.quickcare.QuickCare.Model.User;
import com.quickcare.QuickCare.Service.AmbulanceBookingService;
import com.quickcare.QuickCare.Service.DoctorAppointmentService;
import com.quickcare.QuickCare.Service.MedicineBookingService;
import com.quickcare.QuickCare.Service.OpAppointmentService;
import com.quickcare.QuickCare.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @Autowired
    private OpAppointmentService opService;

    @Autowired
    private AmbulanceBookingService ambulanceService;

    @Autowired
    private MedicineBookingService medicineService;

    @Autowired
    private DoctorAppointmentService doctorAppointmentService;

    // Show login page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Process signup form
    @PostMapping("/signup")
    public String processSignup(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // points to signup.html
    }

    // Show user home
    @GetMapping("/userhome")
    public String userHome(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "home";
    }

    // Process login
    @GetMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        if (email.equals("alice123@gmail.com") && password.equals("passAlice@1")) {
            session.setAttribute("role", "admin");
            session.setAttribute("email", email);
            model.addAttribute("opBookings", opService.getAllBookings());
            model.addAttribute("medicineBookings", medicineService.getAllBookings());
            model.addAttribute("ambulanceBookings", ambulanceService.getAllBookings());
            return "Admin";
        }

        if (service.checkUser(email, password)) {
            session.setAttribute("role", "user");
            session.setAttribute("email", email);
            String username = service.getUserNameByEmail(email);
            session.setAttribute("username", username);
            return "redirect:/home";  // changed redirect here
        }


        return "badCredentials";
    }

    // Logout and destroy session
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    // Optional success page
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
