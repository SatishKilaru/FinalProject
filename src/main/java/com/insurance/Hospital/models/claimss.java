package com.insurance.Hospital.models;



import java.sql.Date;

public class claimss {


	int clam_id;
	String clam_source;
	String clam_type;
	Date clam_date;
	double clam_amount_requested;
	int clam_iplc_id;
	double clam_processed_amount;
	Date clam_processed_Date;
	int clam_processed_by;
	String clam_remarks;
	String clam_status;
	
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
	public double getClam_amount_requested() {
		return clam_amount_requested;
	}
	public void setClam_amount_requested(double clam_amount_requested) {
		this.clam_amount_requested = clam_amount_requested;
	}
	public int getClam_iplc_id() {
		return clam_iplc_id;
	}
	public void setClam_iplc_id(int clam_iplc_id) {
		this.clam_iplc_id = clam_iplc_id;
	}
	public double getClam_processed_amount() {
		return clam_processed_amount;
	}
	public void setClam_processed_amount(double clam_processed_amount) {
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
	public String getClam_status() {
		return clam_status;
	}
	public void setClam_status(String clam_status) {
		this.clam_status = clam_status;
	}
	public String getClam_remarks() {
		return clam_remarks;
	}
	public void setClam_remarks(String clam_remarks) {
		this.clam_remarks = clam_remarks;
	}
	public claimss(int clam_id, String clam_source, String clam_type, Date clam_date, double clam_amount_requested,
			int clam_iplc_id, double clam_processed_amount, Date clam_processed_Date, int clam_processed_by,
			String clam_status, String clam_remarks) {

		this.clam_id = clam_id;
		this.clam_source = clam_source;
		this.clam_type = clam_type;
		this.clam_date = clam_date;
		this.clam_amount_requested = clam_amount_requested;
		this.clam_iplc_id = clam_iplc_id;
		this.clam_processed_amount = clam_processed_amount;
		this.clam_processed_Date = clam_processed_Date;
		this.clam_processed_by = clam_processed_by;
		this.clam_status = clam_status;
		this.clam_remarks = clam_remarks;
	}
	public claimss() {
		
	}
	
	
	
	
}