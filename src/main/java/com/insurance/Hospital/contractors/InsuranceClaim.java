package com.insurance.Hospital.contractors;

import java.util.ArrayList;
import java.util.List;

import com.insurance.Hospital.models.Claim;
import com.insurance.Hospital.models.ClaimApplication;
import com.insurance.Hospital.models.PolicyMembers;
import com.insurance.Hospital.models.ReUpload;
import com.insurance.Hospital.models.Uploads;

public interface InsuranceClaim {

	// ListClaims

	ArrayList<Claim> getAllClaims();

	ArrayList<Claim> getFilteredClaims(String status);

	Claim getClaimById(int clamId);

	// Payments

	void addClaimApplication(ClaimApplication application);

	void addClaim(int clamIplcId);

	Claim getClaimByid(int clamIplcId);

	void addClaimBills(String originalFilename, String fullPath, int cid);

	List<PolicyMembers> getFamilyByPolicy(int id);
	
	//Upload

	void addRequiredUploads(ReUpload upload);

	List<ReUpload> getAllReUploads(int id);

	void addUploads(Uploads up);

	List<Uploads> getAllUploads(int claimId);
}
