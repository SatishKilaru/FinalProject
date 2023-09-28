package com.insurance.Hospital.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.Hospital.contractors.DashboardDaoInterface;
import com.insurance.Hospital.contractors.DashboardRepositoryInterface;
import com.insurance.Hospital.models.ClaimBills;
import com.insurance.Hospital.models.claimss;

@Repository
public class DashboardRepository implements DashboardRepositoryInterface {

	@Autowired
	DashboardDaoInterface dbi;

	@Override
	public List<ClaimBills> getRejectedLoans() {

		return dbi.getRejectedLoans();
	}

	@Override
	public List<claimss> getAllApplicants() {

		return dbi.getAllApplicants();
	}

	@Override
	public List<ClaimBills> getClaimedAmount() {

		return dbi.getClaimedAmount();
	}

	@Override
	public List<ClaimBills> getTotalAmount() {

		return dbi.getTotalAmount();
	}

	@Override
	public List<claimss> getAllClaimss() {

		return dbi.getAllClaimss();
	}
}
