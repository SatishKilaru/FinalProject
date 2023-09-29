package com.insurance.Hospital.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.Hospital.contractors.InsuranceClaim;
import com.insurance.Hospital.models.Claim;
import com.insurance.Hospital.models.ClaimApplication;
import com.insurance.Hospital.models.PolicyMembers;
import com.insurance.Hospital.models.Uploads;
import com.insurance.Hospital.models.ReUpload;

@Service
public class ClaimService {

	@Autowired
	InsuranceClaim insuranceClaim;

	// LIstClaims

	public ArrayList<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		return (ArrayList<Claim>) insuranceClaim.getAllClaims();
	}

	public ArrayList<Claim> getFilteredClaims(String status) {
		// TODO Auto-generated method stub
		return (ArrayList<Claim>) insuranceClaim.getFilteredClaims(status);
	}

	public Claim getClaimById(int clamId) {
		// TODO Auto-generated method stub
		return insuranceClaim.getClaimById(clamId);
	}

	// New Claim
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

	public List<String> getFamilyByPolicy(int id) {

		List<PolicyMembers> members = insuranceClaim.getFamilyByPolicy(id);
		List<String> names = new ArrayList<>();

		for (PolicyMembers mem : members) {
			if (mem.getInsurancePolicyId() == id) {
				names.add(mem.getMemberName());
			}
		}
		return names;
	}
	
	//Upload

	public List<ReUpload> getAllReUploads(int id) {
		return insuranceClaim.getAllReUploads(id);
	}

	public List<Uploads> getAllUploads(int claimId) {
		return insuranceClaim.getAllUploads(claimId);
	}

	public void addUploads(Uploads up) {
		insuranceClaim.addUploads(up);
		
	}
	

}