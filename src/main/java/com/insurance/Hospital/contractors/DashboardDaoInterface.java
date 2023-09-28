package com.insurance.Hospital.contractors;

import java.util.List;
import com.insurance.Hospital.models.*;


public interface DashboardDaoInterface {


	List<ClaimBills> getRejectedLoans();

	List<claimss> getAllApplicants();

	List<ClaimBills> getClaimedAmount();

	List<ClaimBills> getTotalAmount();

	List<claimss> getAllClaimss();
}
