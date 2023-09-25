package com.insurance.HealthInsurance.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Claim {

	 private int patientId;
	    private String patientName;
	    private Date dateOfBirth;
	    private String gender;
	    private String contactNumber;
	    private String address;
	    private Date joinedDate;
	    private String disease;
	    private String diagnosis;
	    private String treatment;
	    private double roomCharges;
	    private double medicineBill;
	    private String documentPath;
	    
	    
	    
		public String getDocumentPath() {
			return documentPath;
		}

		
		public void setDocumentPath(String documentPath) {
			this.documentPath = documentPath;
		}
		public int getPatientId() {
			return patientId;
		}
		public String getPatientName() {
			return patientName;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public String getGender() {
			return gender;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public String getAddress() {
			return address;
		}
		public Date getJoinedDate() {
			return joinedDate;
		}
		public String getDisease() {
			return disease;
		}
		public String getDiagnosis() {
			return diagnosis;
		}
		public String getTreatment() {
			return treatment;
		}
		public double getRoomCharges() {
			return roomCharges;
		}
		public double getMedicineBill() {
			return medicineBill;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public void setDateOfBirth(String dateOfBirth) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = dateFormat.parse(dateOfBirth);
				this.dateOfBirth = new Date(utilDate.getTime());
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setJoinedDate(String joinedDate) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = dateFormat.parse(joinedDate);
				this.joinedDate = new Date(utilDate.getTime());
			} catch (Exception e) {

				e.printStackTrace();
			}
			
		}
		public void setDisease(String disease) {
			this.disease = disease;
		}
		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}
		public void setTreatment(String treatment) {
			this.treatment = treatment;
		}
		public void setRoomCharges(double roomCharges) {
			this.roomCharges = roomCharges;
		}
		public void setMedicineBill(double medicineBill) {
			this.medicineBill = medicineBill;
		}
	
	
	
	
	
}
