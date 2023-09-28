package com.insurance.Hospital.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.Hospital.contractors.DashboardDaoInterface;
import com.insurance.Hospital.models.ClaimBills;
import com.insurance.Hospital.models.claimss;
import com.insurance.Hospital.rowmappers.ClaimBillsRowMappers;
import com.insurance.Hospital.rowmappers.ClaimsRowMapper;

@Component
public class DashboardDao implements DashboardDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String SELECT_ALL_CLAIM_BILLS = "SELECT * FROM _claims  ";
	private static final String SELECT_FULL_CLAIM_BILLS = "SELECT * FROM _claims WHERE clam_status = 'APPR'";
	private static final String SELECT_FULL_CLAIMED_AMOUNT = "SELECT * FROM claim_bills WHERE clbl_status = 'FULL'";
	private static final String SELECT_TOTAL_AMOUNT = "SELECT * FROM claim_bills WHERE clbl_status = 'FULL' or clbl_status='PART' ";
	private static final String SELECT_ALL_REJECTED = "SELECT * FROM claim_bills where clbl_status='REJT' or clbl_status='PART'";

	@Override
	public List<claimss> getAllApplicants() {
		return jdbcTemplate.query(SELECT_ALL_CLAIM_BILLS, new ClaimsRowMapper());

	}

	@Override
	public List<claimss> getAllClaimss() {
		return jdbcTemplate.query(SELECT_FULL_CLAIM_BILLS, new ClaimsRowMapper());
	}

	@Override
	public List<ClaimBills> getRejectedLoans() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL_REJECTED, new ClaimBillsRowMappers());

	}

	@Override
	public List<ClaimBills> getClaimedAmount() {

		return jdbcTemplate.query(SELECT_FULL_CLAIMED_AMOUNT, new ClaimBillsRowMappers());
	}

	@Override
	public List<ClaimBills> getTotalAmount() {

		return jdbcTemplate.query(SELECT_TOTAL_AMOUNT, new ClaimBillsRowMappers());
	}

}
