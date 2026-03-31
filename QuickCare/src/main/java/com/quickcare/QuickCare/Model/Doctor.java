package com.quickcare.QuickCare.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString




@Entity
public class Doctor {
	
	@Id
	private int doctor_id;
	private String doctor_name;
	private String doctor_specialization;
	private String doctor_hospital;
	private String doctor_availability;
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_specialization() {
		return doctor_specialization;
	}
	public void setDoctor_specialization(String doctor_specialization) {
		this.doctor_specialization = doctor_specialization;
	}
	public String getDoctor_hospital() {
		return doctor_hospital;
	}
	public void setDoctor_hospital(String doctor_hospital) {
		this.doctor_hospital = doctor_hospital;
	}
	public String getDoctor_availability() {
		return doctor_availability;
	}
	public void setDoctor_availability(String doctor_availability) {
		this.doctor_availability = doctor_availability;
	}

}
