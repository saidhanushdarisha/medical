package com.quickcare.QuickCare.Model;




import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;

@Entity
public class MedicineBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String patientName;
    private String contactNumber;
    private String address;
    private String medicineNames;
    private int quantity;
    private String deliveryDate;
    private String deliveryTime;

    @Transient // Will not be persisted in DB
    private MultipartFile prescriptionFile;

    @Lob // This will store the file as BLOB in DB
    private byte[] prescriptionFileData;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMedicineNames() { return medicineNames; }
    public void setMedicineNames(String medicineNames) { this.medicineNames = medicineNames; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime(String deliveryTime) { this.deliveryTime = deliveryTime; }

    public MultipartFile getPrescriptionFile() { return prescriptionFile; }
    public void setPrescriptionFile(MultipartFile prescriptionFile) { this.prescriptionFile = prescriptionFile; }

    public byte[] getPrescriptionFileData() { return prescriptionFileData; }
    public void setPrescriptionFileData(byte[] prescriptionFileData) { this.prescriptionFileData = prescriptionFileData; }
}
