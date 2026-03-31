package com.quickcare.QuickCare.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.quickcare.QuickCare.Model.AmbulanceBooking;
import com.quickcare.QuickCare.Model.Doctor;
import com.quickcare.QuickCare.Model.DoctorAppointment;
import com.quickcare.QuickCare.Model.MedicineBooking;
import com.quickcare.QuickCare.Model.OpAppointment;
import com.quickcare.QuickCare.Service.AmbulanceBookingService;
import com.quickcare.QuickCare.Service.DoctorAppointmentService;
import com.quickcare.QuickCare.Service.DoctorService;
import com.quickcare.QuickCare.Service.MedicineBookingService;
import com.quickcare.QuickCare.Service.OpAppointmentService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private OpAppointmentService opService;

    @Autowired
    private AmbulanceBookingService ambulanceService;

    @Autowired
    private MedicineBookingService medicineService;

    @Autowired
    private DoctorAppointmentService doctorAppointmentService;

    // ------------------------ SAVE METHODS -----------------------------

    @PostMapping("/ambulancebooking/save")
    public String bookAmbulance(@ModelAttribute AmbulanceBooking booking) {
        ambulanceService.saveBooking(booking);
        return "final";
    }

    @PostMapping("/doctorAppointment/save")
    public String saveAppointment(@ModelAttribute DoctorAppointment appointment) {
        doctorAppointmentService.saveBooking(appointment);
        return "final";
    }

    @PostMapping("/opbooking/save")
    public String bookOp(@ModelAttribute OpAppointment appointment) {
        opService.saveAppointment(appointment);
        return "final";
    }

    @PostMapping(value = "/Medicinesbooking/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String bookMedicineWithBlob(@ModelAttribute MedicineBooking booking) {
        try {
            if (booking.getPrescriptionFile() != null && !booking.getPrescriptionFile().isEmpty()) {
                booking.setPrescriptionFileData(booking.getPrescriptionFile().getBytes());
            }
            medicineService.saveBooking(booking);
            return "final";
        } catch (IOException e) {
            return "error-page";
        }
    }

    // ------------------------ DISPLAY PAGES -----------------------------

    // ✅ All Bookings (OP + Medicine + Ambulance)
    @GetMapping("/all")
    public String viewAllBookings(Model model) {
        model.addAttribute("opBookings", opService.getAllBookings());
        model.addAttribute("medicineBookings", medicineService.getAllBookings());
        model.addAttribute("ambulanceBookings", ambulanceService.getAllBookings());
        return "allBookings";
    }

    // ✅ OP Bookings
    @GetMapping("/op")
    public String viewOPBookings(Model model) {
        model.addAttribute("bookings", opService.getAllBookings());
        System.out.println("sdih");
        return "opBookings";
    }

    // ✅ Medicine Bookings
    @GetMapping("/medicine")
    public String viewMedicineBookings(Model model) {
        model.addAttribute("bookings", medicineService.getAllBookings());
        return "medicineBookings";
    }

    // ✅ Ambulance Bookings
    @GetMapping("/ambulance")
    public String viewAmbulanceBookings(Model model) {
        model.addAttribute("bookings", ambulanceService.getAllBookings());
        return "ambulanceBookings";
    }
}
