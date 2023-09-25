package com.insurance.HealthInsurance.models;


import java.sql.Date;

public class Claimsss {
	int clam_id;
	String clam_source;
	String clam_type;
	Date clam_date;
	Double clam_amount_requested;
	int clam_iplc_id;
	Double clam_processed_amount;
	Date clam_processed_Date;
	int clam_processed_by;
	String clam_remarks;
	String clam_status;
	String pay_status;

	public Claimsss() {
	}

	public int getClam_id() {
		return clam_id;
	}

	public void setClam_id(int clam_id) {
		this.clam_id = clam_id;
	}

	public String getClam_source() {
		return clam_source;
	}

	public void setClam_source(String clam_source) {
		this.clam_source = clam_source;
	}

	public String getClam_type() {
		return clam_type;
	}

	public void setClam_type(String clam_type) {
		this.clam_type = clam_type;
	}

	public Date getClam_date() {
		return clam_date;
	}

	public void setClam_date(Date clam_date) {
		this.clam_date = clam_date;
	}

	public Double getClam_amount_requested() {
		return clam_amount_requested;
	}

	public void setClam_amount_requested(Double clam_amount_requested) {
		this.clam_amount_requested = clam_amount_requested;
	}

	public int getClam_iplc_id() {
		return clam_iplc_id;
	}

	public void setClam_iplc_id(int clam_iplc_id) {
		this.clam_iplc_id = clam_iplc_id;
	}

	public Double getClam_processed_amount() {
		return clam_processed_amount;
	}

	public void setClam_processed_amount(Double clam_processed_amount) {
		this.clam_processed_amount = clam_processed_amount;
	}

	public Date getClam_processed_Date() {
		return clam_processed_Date;
	}

	public void setClam_processed_Date(Date clam_processed_Date) {
		this.clam_processed_Date = clam_processed_Date;
	}

	public int getClam_processed_by() {
		return clam_processed_by;
	}

	public void setClam_processed_by(int clam_processed_by) {
		this.clam_processed_by = clam_processed_by;
	}

	public String getClam_remarks() {
		return clam_remarks;
	}

	public void setClam_remarks(String clam_remarks) {
		this.clam_remarks = clam_remarks;
	}

	public String getClam_status() {
		return clam_status;
	}

	public void setClam_status(String clam_status) {
		this.clam_status = clam_status;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

}