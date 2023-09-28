package com.insurance.Hospital.models;

import java.sql.Date;

public class Payments {
	int stmt_id;
	String tran_id;
	Date payment_Processed_date;
	int claim_id;
	double tran_amnt;

	public int getStmt_id() {
		return stmt_id;
	}

	public void setStmt_id(int stmt_id) {
		this.stmt_id = stmt_id;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public Date getPayment_Processed_date() {
		return payment_Processed_date;
	}

	public void setPayment_Processed_date(Date payment_Processed_date) {
		this.payment_Processed_date = payment_Processed_date;
	}

	public int getClaim_id() {
		return claim_id;
	}

	public void setClaim_id(int claim_id) {
		this.claim_id = claim_id;
	}

	public double getTran_amnt() {
		return tran_amnt;
	}

	public void setTran_amnt(double tran_amnt) {
		this.tran_amnt = tran_amnt;
	}

	public Payments() {
		super();
	}

}