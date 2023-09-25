package com.insurance.HealthInsurance.contractors;

import java.util.ArrayList;
import java.util.List;

import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.Claims;
import com.insurance.HealthInsurance.models.Claimsss;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
import com.insurance.HealthInsurance.models.LoginClass;
import com.insurance.HealthInsurance.models.Payments;

public interface InsuranceClaim {

	void addClaim(Claim claim);

	List<InsurancePackage> getAllInsurancePackages();

	List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId);

	DiseaseDetails getDetailsByDiseaseId(int discId);

	List<InsurancePackage> getFiteredDiseases(String status, int age);

	List<InsurancePackage> getPackagesByStatus(String status);

	List<InsurancePackage> getAllInsurancePackagesByAge(int age);

	// Login
	int sendmail(String to_mail);

	int resetpwd(String email, String pwd);

	int checkCredentials(LoginClass lc);

	// ListClaims

	ArrayList<Claims> getAllClaims();

	ArrayList<Claims> getFilteredClaims(String status);

	Claims getClaimById(int clamId);

	List<ClaimBills> getRejectedLoans();

	List<Claims> getAllApplicants();

	List<ClaimBills> getClaimedAmount();

	List<ClaimBills> getTotalAmount();

	List<Claims> getAllClaimss();

	//payments
List<Payments> getPayments();

	
	Payments getPaymentById(String paymentId);
}
