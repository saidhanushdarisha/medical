package com.quickcare.QuickCare.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Hospital {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	private int hospital_id;
	private String hospital_name;
	private String hospital_address;
	private String hospital_availability;
	private String hospital_phone;
	private String hospital_facilities;
	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + ", hospital_address="
				+ hospital_address + ", hospital_availability=" + hospital_availability + ", hospital_phone="
				+ hospital_phone + ", hospital_facilities=" + hospital_facilities + "]";
	}
	public Hospital(int hospital_id, String hospital_name, String hospital_address, String hospital_availability,
			String hospital_phone, String hospital_facilities) {
		super();
		this.hospital_id = hospital_id;
		this.hospital_name = hospital_name;
		this.hospital_address = hospital_address;
		this.hospital_availability = hospital_availability;
		this.hospital_phone = hospital_phone;
		this.hospital_facilities = hospital_facilities;
	}
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getHospital_address() {
		return hospital_address;
	}
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}
	public String getHospital_availability() {
		return hospital_availability;
	}
	public void setHospital_availability(String hospital_availability) {
		this.hospital_availability = hospital_availability;
	}
	public String getHospital_phone() {
		return hospital_phone;
	}
	public void setHospital_phone(String hospital_phone) {
		this.hospital_phone = hospital_phone;
	}
	public String getHospital_facilities() {
		return hospital_facilities;
	}
	public void setHospital_facilities(String hospital_facilities) {
		this.hospital_facilities = hospital_facilities;
	}

}
