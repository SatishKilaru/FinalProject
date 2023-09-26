package com.insurance.HealthInsurance.models;

import java.sql.Date;

public class ClaimBills {
	int clam_id;
	int clbl_billindex;
	String clbl_document_title;
	String clbl_document_path;
	double clbl_claim_amount;
	double clbl_processed_amount;
	String clbl_processed_Date;
	int clbl_processed_by;
	String clbl_remarks;
	String clbl_status;
	public int getClam_id() {
		return clam_id;
	}
	
	public double getClbl_processed_amount() {
		return clbl_processed_amount;
	}

	public void setClbl_processed_amount(double clbl_processed_amount) {
		this.clbl_processed_amount = clbl_processed_amount;
	}

	public void setClam_id(int clam_id) {
		this.clam_id = clam_id;
	}
	public int getClbl_billindex() {
		return clbl_billindex;
	}
	public void setClbl_billindex(int clbl_billindex) {
		this.clbl_billindex = clbl_billindex;
	}
	public String getClbl_document_title() {
		return clbl_document_title;
	}
	public void setClbl_document_title(String clbl_document_title) {
		this.clbl_document_title = clbl_document_title;
	}
	public String getClbl_document_path() {
		return clbl_document_path;
	}
	public void setClbl_document_path(String clbl_document_path) {
		this.clbl_document_path = clbl_document_path;
	}
	public double getClbl_claim_amount() {
		return clbl_claim_amount;
	}
	public void setClbl_claim_amount(double clbl_claim_amount) {
		this.clbl_claim_amount = clbl_claim_amount;
	}
	public String getClbl_processed_Date() {
		return clbl_processed_Date;
	}
	public void setClbl_processed_Date(String clbl_processed_Date) {
		this.clbl_processed_Date = clbl_processed_Date;
	}
	public int getClbl_processed_by() {
		return clbl_processed_by;
	}
	public void setClbl_processed_by(int clbl_processed_by) {
		this.clbl_processed_by = clbl_processed_by;
	}
	public String getClbl_remarks() {
		return clbl_remarks;
	}
	public void setClbl_remarks(String clbl_remarks) {
		this.clbl_remarks = clbl_remarks;
	}
	public String getClbl_status() {
		return clbl_status;
	}
	public void setClbl_status(String clbl_status) {
		this.clbl_status = clbl_status;
	}

	public ClaimBills(int clam_id, int clbl_billindex, String clbl_document_title, String clbl_document_path,
			double clbl_claim_amount, double clbl_processed_amount, String clbl_processed_Date, int clbl_processed_by,
			String clbl_remarks, String clbl_status) {
		super();
		this.clam_id = clam_id;
		this.clbl_billindex = clbl_billindex;
		this.clbl_document_title = clbl_document_title;
		this.clbl_document_path = clbl_document_path;
		this.clbl_claim_amount = clbl_claim_amount;
		this.clbl_processed_amount = clbl_processed_amount;
		this.clbl_processed_Date = clbl_processed_Date;
		this.clbl_processed_by = clbl_processed_by;
		this.clbl_remarks = clbl_remarks;
		this.clbl_status = clbl_status;
	}

	public ClaimBills() {
		super();
	}
	
	
	
	

}
