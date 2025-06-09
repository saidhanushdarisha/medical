package com.quickcare.QuickCare.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


	
	@Entity
	public class DoctorAppointment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String doctorName;
	    private String specialization;
	    private String hospital;
	    private String availability;

	    private String patientName;
	    private String contactNumber;
	    private String appointmentDate;
	    // Getters & setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDoctorName() {
			return doctorName;
		}
		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
		public String getHospital() {
			return hospital;
		}
		public void setHospital(String hospital) {
			this.hospital = hospital;
		}
		public String getAvailability() {
			return availability;
		}
		public void setAvailability(String availability) {
			this.availability = availability;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(String appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public DoctorAppointment(int id, String doctorName, String specialization, String hospital, String availability,
				String patientName, String contactNumber, String appointmentDate) {
			super();
			this.id = id;
			this.doctorName = doctorName;
			this.specialization = specialization;
			this.hospital = hospital;
			this.availability = availability;
			this.patientName = patientName;
			this.contactNumber = contactNumber;
			this.appointmentDate = appointmentDate;
		}
		public DoctorAppointment() {
			super();
			// TODO Auto-generated constructor stub
		}
	}



