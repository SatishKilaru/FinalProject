package com.insurance.Hospital.contractors;

import java.util.List;

import com.insurance.Hospital.models.ClaimBills;
import com.insurance.Hospital.models.claimss;

public interface DashboardRepositoryInterface {

	List<ClaimBills> getRejectedLoans();

	List<claimss> getAllApplicants();

	List<ClaimBills> getClaimedAmount();

	List<ClaimBills> getTotalAmount();

	List<claimss> getAllClaimss();
}
