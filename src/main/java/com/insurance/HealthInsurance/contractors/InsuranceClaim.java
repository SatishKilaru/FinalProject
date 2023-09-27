package com.insurance.HealthInsurance.contractors;

import java.util.ArrayList;
import java.util.List;

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

public interface InsuranceClaim {

	// Package wise Diseases

	List<InsurancePackage> getAllInsurancePackages();

	List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId);

	DiseaseDetails getDetailsByDiseaseId(int discId);

	List<InsurancePackage> getFiteredDiseases(String status, int age);

	List<InsurancePackage> getPackagesByStatus(String status);

	List<InsurancePackage> getAllInsurancePackagesByAge(int age);
	
	List<DiseaseDetails> getDiseasesByPackageId(int inspId);

	// Login
	int sendmail(String to_mail);

	int resetpwd(String email, String pwd);

	int checkCredentials(LoginClass lc);

	// ListClaims

	ArrayList<Claims> getAllClaims();

	ArrayList<Claims> getFilteredClaims(String status);

	Claims getClaimById(int clamId);

	List<ClaimBills> getRejectedLoans();

	List<claimss> getAllApplicants();

	List<ClaimBills> getClaimedAmount();

	List<ClaimBills> getTotalAmount();

	List<claimss> getAllClaimss();

	// Payments

	List<Payments> getPayments();

	Payments getPaymentById(String paymentId);

	List<Payments> filterList(String type, String value);

	void addClaimApplication(ClaimApplication application);

	void addClaim(int clamIplcId);

	Claim getClaimByid(int clamIplcId);

	void addClaimBills(String originalFilename, String fullPath, int cid);
}
