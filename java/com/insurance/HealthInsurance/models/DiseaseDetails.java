package com.insurance.HealthInsurance.models;

public class DiseaseDetails {
private int diseaseId;
private String diseaseName;
private String icdCode;
private String diseaseDiscription;
private String diseaseStatus;
public int getDiseaseId() {
	return diseaseId;
}
public String getDiseaseName() {
	return diseaseName;
}
public DiseaseDetails(int diseaseId, String diseaseName, String icdCode, String diseaseDiscription,
		String diseaseStatus) {
	super();
	this.diseaseId = diseaseId;
	this.diseaseName = diseaseName;
	this.icdCode = icdCode;
	this.diseaseDiscription = diseaseDiscription;
	this.diseaseStatus = diseaseStatus;
}
public DiseaseDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public String getIcdCode() {
	return icdCode;
}
public String getDiseaseDiscription() {
	return diseaseDiscription;
}
public String getDiseaseStatus() {
	return diseaseStatus;
}
public void setDiseaseId(int diseaseId) {
	this.diseaseId = diseaseId;
}
public void setDiseaseName(String diseaseName) {
	this.diseaseName = diseaseName;
}
public void setIcdCode(String icdCode) {
	this.icdCode = icdCode;
}
public void setDiseaseDiscription(String diseaseDiscription) {
	this.diseaseDiscription = diseaseDiscription;
}
public void setDiseaseStatus(String diseaseStatus) {
	this.diseaseStatus = diseaseStatus;
}
	
	
}
