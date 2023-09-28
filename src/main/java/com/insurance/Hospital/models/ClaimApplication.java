package com.insurance.Hospital.models;


import java.sql.Date;
import java.text.SimpleDateFormat;

public class ClaimApplication {

	private int clamIplcId;
	int memberIndex;
	String relation;
	private Date joinedDate;
	private String patientName;
	private Date dateOfBirth;
	private String gender;
	private String contactNumber;
	private String address;
	private String disease;
	private String diagnosis;
	private String treatment;
	private double claimAmountRequested;

	public int getClamIplcId() {
		return clamIplcId;
	}

	public void setClamIplcId(int clamIplcId) {
		this.clamIplcId = clamIplcId;
	}

	public int getMemberIndex() {
		return memberIndex;
	}

	public void setMemberIndex(String memberIndex) {
		this.memberIndex = Integer.parseInt(memberIndex);
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public double getClaimAmountRequested() {
		return claimAmountRequested;
	}

	public void setClaimAmountRequested(double claimAmountRequested) {
		this.claimAmountRequested = claimAmountRequested;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getPatientId() {
		return clamIplcId;
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
		return claimAmountRequested;
	}

	public void setPatientId(int patientId) {
		this.clamIplcId = patientId;
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
		this.claimAmountRequested = roomCharges;
	}

}