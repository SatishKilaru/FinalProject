package com.insurance.HealthInsurance.models;

import java.sql.Date;

public class Claims {
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

	public Claims() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the clamId
	 */
	public int getClamId() {
		return clamId;
	}

	/**
	 * @param clamId the clamId to set
	 */
	public void setClamId(int clamId) {
		this.clamId = clamId;
	}

	/**
	 * @return the clamSource
	 */
	public String getClamSource() {
		return clamSource;
	}

	/**
	 * @param clamSource the clamSource to set
	 */
	public void setClamSource(String clamSource) {
		this.clamSource = clamSource;
	}

	/**
	 * @return the clamType
	 */
	public String getClamType() {
		return clamType;
	}

	/**
	 * @param clamType the clamType to set
	 */
	public void setClamType(String clamType) {
		this.clamType = clamType;
	}

	/**
	 * @return the clamDate
	 */
	public Date getClamDate() {
		return clamDate;
	}

	/**
	 * @param clamDate the clamDate to set
	 */
	public void setClamDate(Date clamDate) {
		this.clamDate = clamDate;
	}

	/**
	 * @return the clamAmountRequested
	 */
	public double getClamAmountRequested() {
		return clamAmountRequested;
	}

	/**
	 * @param clamAmountRequested the clamAmountRequested to set
	 */
	public void setClamAmountRequested(double clamAmountRequested) {
		this.clamAmountRequested = clamAmountRequested;
	}

	/**
	 * @return the clamIplcId
	 */
	public int getClamIplcId() {
		return clamIplcId;
	}

	/**
	 * @param clamIplcId the clamIplcId to set
	 */
	public void setClamIplcId(int clamIplcId) {
		this.clamIplcId = clamIplcId;
	}

	/**
	 * @return the clamProcessedAmount
	 */
	public double getClamProcessedAmount() {
		return clamProcessedAmount;
	}

	/**
	 * @param clamProcessedAmount the clamProcessedAmount to set
	 */
	public void setClamProcessedAmount(double clamProcessedAmount) {
		this.clamProcessedAmount = clamProcessedAmount;
	}

	/**
	 * @return the clamProcessedDate
	 */
	public Date getClamProcessedDate() {
		return clamProcessedDate;
	}

	/**
	 * @param clamProcessedDate the clamProcessedDate to set
	 */
	public void setClamProcessedDate(Date clamProcessedDate) {
		this.clamProcessedDate = clamProcessedDate;
	}

	/**
	 * @return the clamProcessedBy
	 */
	public int getClamProcessedBy() {
		return clamProcessedBy;
	}

	/**
	 * @param clamProcessedBy the clamProcessedBy to set
	 */
	public void setClamProcessedBy(int clamProcessedBy) {
		this.clamProcessedBy = clamProcessedBy;
	}

	/**
	 * @return the clamRemarks
	 */
	public String getClamRemarks() {
		return clamRemarks;
	}

	/**
	 * @param clamRemarks the clamRemarks to set
	 */
	public void setClamRemarks(String clamRemarks) {
		this.clamRemarks = clamRemarks;
	}

	/**
	 * @return the clamStatus
	 */
	public String getClamStatus() {
		return clamStatus;
	}

	/**
	 * @param clamStatus the clamStatus to set
	 */
	public void setClamStatus(String clamStatus) {
		this.clamStatus = clamStatus;
	}

	@Override
	public String toString() {
		return "Claims [clamId=" + clamId + ", clamSource=" + clamSource + ", clamType=" + clamType + ", clamDate="
				+ clamDate + ", clamAmountRequested=" + clamAmountRequested + ", clamIplcId=" + clamIplcId
				+ ", clamProcessedAmount=" + clamProcessedAmount + ", clamProcessedDate=" + clamProcessedDate
				+ ", clamProcessedBy=" + clamProcessedBy + ", clamRemarks=" + clamRemarks + ", clamStatus=" + clamStatus
				+ "]";
	}

}