package com.insurance.HealthInsurance.models;


import java.sql.Date;

public class Payments {
	String paymentID;
	String customerID;
	String claimID;
	String hospitalID;
	Double paymentAmount;
	Date paymentDate;
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getClaimID() {
		return claimID;
	}
	public void setClaimID(String claimID) {
		this.claimID = claimID;
	}
	public String getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Payments(String paymentID, String customerID, String claimID, String hospitalID, Double paymentAmount,
			Date paymentDate) {
		super();
		this.paymentID = paymentID;
		this.customerID = customerID;
		this.claimID = claimID;
		this.hospitalID = hospitalID;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}
	public Payments() {
		super();
	}
	
	
	
}