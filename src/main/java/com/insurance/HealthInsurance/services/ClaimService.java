package com.insurance.HealthInsurance.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimApplication;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.Claims;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
import com.insurance.HealthInsurance.models.LoginClass;
import com.insurance.HealthInsurance.models.Payments;
import com.insurance.HealthInsurance.models.claimss;

@Service
public class ClaimService {

	@Autowired
	InsuranceClaim insuranceClaim;

	public List<InsurancePackage> getAllInsurancePackages() {
		return insuranceClaim.getAllInsurancePackages();
	}

	public List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId) {
		return insuranceClaim.getCoveredDiseasesByPackageId(packageId);
	}

	public DiseaseDetails getDiseaseDetailsById(int discId) {

		return insuranceClaim.getDetailsByDiseaseId(discId);
	}

	public List<InsurancePackage> getFilteredPackages(String status, int age) {
		return insuranceClaim.getFiteredDiseases(status, age);
	}

	public List<InsurancePackage> getPackagesByStatus(String status) {

		return insuranceClaim.getPackagesByStatus(status);
	}

	public List<InsurancePackage> getAllInsurancePackagesByAge(int age) {

		return insuranceClaim.getAllInsurancePackagesByAge(age);
	}

	// Login
	public int sendmail(String to_mail) {
		return insuranceClaim.sendmail(to_mail);
	}

	public int resetpwd(String email, String pwd) {
		return insuranceClaim.resetpwd(email, pwd);
	}

	public int checkCredentials(LoginClass lc) {
		// TODO Auto-generated method stub
		return insuranceClaim.checkCredentials(lc);
	}
	// LIstClaims

	public ArrayList<Claims> getAllClaims() {
		// TODO Auto-generated method stub
		return (ArrayList<Claims>) insuranceClaim.getAllClaims();
	}

	public ArrayList<Claims> getFilteredClaims(String status) {
		// TODO Auto-generated method stub
		return (ArrayList<Claims>) insuranceClaim.getFilteredClaims(status);
	}

	public Claims getClaimById(int clamId) {
		// TODO Auto-generated method stub
		return insuranceClaim.getClaimById(clamId);
	}

	public List<claimss> getAllApplicants() {
		return insuranceClaim.getAllApplicants();
	}

	public List<claimss> getAllClaimss() {
		return insuranceClaim.getAllClaimss();
	}

	public List<ClaimBills> getRejectedLoans() {

		return insuranceClaim.getRejectedLoans();
	}

	public List<ClaimBills> getClaimedAmount() {

		return insuranceClaim.getClaimedAmount();
	}

	public List<ClaimBills> getTotalAmount() {

		return insuranceClaim.getTotalAmount();
	}

	// payments

	public List<Payments> getPayments() {
		return insuranceClaim.getPayments();
	}

	public Payments getPaymentById(String paymentId) {
		return insuranceClaim.getPaymentById(paymentId);
	}

	public List<Payments> filterList(String type, String value) {
		return insuranceClaim.filterList(type, value);
	}

	public void addClaimApplication(ClaimApplication application) {
		insuranceClaim.addClaimApplication(application);

	}

	public void addClaim(int clamIplcId) {
		insuranceClaim.addClaim(clamIplcId);

	}

	public Claim getClaimByid(int clamIplcId) {
		return insuranceClaim.getClaimByid(clamIplcId);
	}

	public void addClaimBills(String originalFilename, String fullPath, int cid) {
		insuranceClaim.addClaimBills(originalFilename, fullPath, cid);

	}

}
