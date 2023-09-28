package com.insurance.Hospital.models;


public class HospitalClaims {

	int clam_id;
	int hclm_hosp_id;
	int hclm_husr_id;
	public int getClam_id() {
		return clam_id;
	}
	public void setClam_id(int clam_id) {
		this.clam_id = clam_id;
	}
	public int getHclm_hosp_id() {
		return hclm_hosp_id;
	}
	public void setHclm_hosp_id(int hclm_hosp_id) {
		this.hclm_hosp_id = hclm_hosp_id;
	}
	public int getHclm_husr_id() {
		return hclm_husr_id;
	}
	public void setHclm_husr_id(int hclm_husr_id) {
		this.hclm_husr_id = hclm_husr_id;
	}
	public HospitalClaims(int clam_id, int hclm_hosp_id, int hclm_husr_id) {
		super();
		this.clam_id = clam_id;
		this.hclm_hosp_id = hclm_hosp_id;
		this.hclm_husr_id = hclm_husr_id;
	}
	public HospitalClaims() {
		super();
	}
	
	
	
}
