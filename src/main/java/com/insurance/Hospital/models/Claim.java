package com.insurance.Hospital.models;

import java.sql.Date;

public class Claim {
	private int clamId;
	private String clamSource;
	private String clamType;
	private Date clamDate;
	private double clamAmountRequested;
	private int clamIplcId;
	private double clamProcessedAmount;
	private Date clamProcessedDate;
	private int clamProcessedBy;
	private String clamRemarks;
	private String clamStatus;

	// Default constructor
	public Claim() {
	}

	// Parameterized constructor
	public Claim(int clamId, String clamSource, String clamType, Date clamDate, double clamAmountRequested,
			int clamIplcId, double clamProcessedAmount, Date clamProcessedDate, int clamProcessedBy, String clamRemarks,
			String clamStatus) {
		this.clamId = clamId;
		this.clamSource = clamSource;
		this.clamType = clamType;
		this.clamDate = clamDate;
		this.clamAmountRequested = clamAmountRequested;
		this.clamIplcId = clamIplcId;
		this.clamProcessedAmount = clamProcessedAmount;
		this.clamProcessedDate = clamProcessedDate;
		this.clamProcessedBy = clamProcessedBy;
		this.clamRemarks = clamRemarks;
		this.clamStatus = clamStatus;
	}

	// Getter for clamId
	public int getClamId() {
		return clamId;
	}

	// Setter for clamId
	public void setClamId(int clamId) {
		this.clamId = clamId;
	}

	// Getter for clamSource
	public String getClamSource() {
		return clamSource;
	}

	// Setter for clamSource
	public void setClamSource(String clamSource) {
		this.clamSource = clamSource;
	}

	// Getter for clamType
	public String getClamType() {
		return clamType;
	}

	// Setter for clamType
	public void setClamType(String clamType) {
		this.clamType = clamType;
	}

	// Getter for clamDate
	public Date getClamDate() {
		return clamDate;
	}

	// Setter for clamDate
	public void setClamDate(Date clamDate) {
		this.clamDate = clamDate;
	}

	// Getter for clamAmountRequested
	public double getClamAmountRequested() {
		return clamAmountRequested;
	}

	// Setter for clamAmountRequested
	public void setClamAmountRequested(double clamAmountRequested) {
		this.clamAmountRequested = clamAmountRequested;
	}

	// Getter for clamIplcId
	public int getClamIplcId() {
		return clamIplcId;
	}

	// Setter for clamIplcId
	public void setClamIplcId(int clamIplcId) {
		this.clamIplcId = clamIplcId;
	}

	// Getter for clamProcessedAmount
	public double getClamProcessedAmount() {
		return clamProcessedAmount;
	}

	// Setter for clamProcessedAmount
	public void setClamProcessedAmount(double clamProcessedAmount) {
		this.clamProcessedAmount = clamProcessedAmount;
	}

	// Getter for clamProcessedDate
	public Date getClamProcessedDate() {
		return clamProcessedDate;
	}

	// Setter for clamProcessedDate
	public void setClamProcessedDate(Date clamProcessedDate) {
		this.clamProcessedDate = clamProcessedDate;
	}

	// Getter for clamProcessedBy
	public int getClamProcessedBy() {
		return clamProcessedBy;
	}

	// Setter for clamProcessedBy
	public void setClamProcessedBy(int clamProcessedBy) {
		this.clamProcessedBy = clamProcessedBy;
	}

	// Getter for clamRemarks
	public String getClamRemarks() {
		return clamRemarks;
	}

	// Setter for clamRemarks
	public void setClamRemarks(String clamRemarks) {
		this.clamRemarks = clamRemarks;
	}

	// Getter for clamStatus
	public String getClamStatus() {
		return clamStatus;
	}

	// Setter for clamStatus
	public void setClamStatus(String clamStatus) {
		this.clamStatus = clamStatus;
	}

	@Override
	public String toString() {
		return "Claim{" + "clamId=" + clamId + ", clamSource='" + clamSource + '\'' + ", clamType='" + clamType + '\''
				+ ", clamDate=" + clamDate + ", clamAmountRequested=" + clamAmountRequested + ", clamIplcId="
				+ clamIplcId + ", clamProcessedAmount=" + clamProcessedAmount + ", clamProcessedDate="
				+ clamProcessedDate + ", clamProcessedBy=" + clamProcessedBy + ", clamRemarks='" + clamRemarks + '\''
				+ ", clamStatus='" + clamStatus + '\'' + '}';
	}
}