package com.insurance.Hospital.Repositories;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.Hospital.contractors.InsuranceClaim;
import com.insurance.Hospital.models.Claim;
import com.insurance.Hospital.models.ClaimApplication;
import com.insurance.Hospital.models.PolicyMembers;
import com.insurance.Hospital.models.ReUpload;
import com.insurance.Hospital.models.Uploads;
import com.insurance.Hospital.rowmappers.ClaimMapper;
import com.insurance.Hospital.rowmappers.PolicyMembersRowMapper;
import com.insurance.Hospital.rowmappers.UploadsRowMapper;
import com.insurance.Hospital.rowmappers.ReUploadRowMapper;
import com.insurance.Hospital.rowmappers.RowMap;

@Component
public class InsuranceClaimRepo implements InsuranceClaim {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private String SQL_GET_CLAIMS = "select * from  _Claims";
	private String SQL_GET_FILTERED_CLAIMS = "select * from  _Claims where clam_status=?";
	private String SQL_GET_CLAIM_BY_ID = "select * from  _Claims where clam_id=?";

	@Override
	public ArrayList<Claim> getAllClaims() {
		System.out.println("bhav");
		return (ArrayList<Claim>) jdbcTemplate.query(SQL_GET_CLAIMS, new ClaimMapper());
	}

	@Override
	public ArrayList<Claim> getFilteredClaims(String status) {
		// TODO Auto-generated method stub
		return (ArrayList<Claim>) jdbcTemplate.query(SQL_GET_FILTERED_CLAIMS, new Object[] { status },
				new ClaimMapper());
	}

	@Override
	public Claim getClaimById(int clamId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SQL_GET_CLAIM_BY_ID, new Object[] { clamId }, new ClaimMapper());
	}

	// New Claim

	private String SQL_INSERT_CLAIM = "insert into _Claims(clam_source,clam_type,clam_date,clam_iplc_id) values(?,?,?,?)";
	private String SQL_INSERT_CLAIMBill = "insert into Claim_Bills(clam_id,clbl_document_title,clbl_document_path) values(?,?,?)";

	@Override
	public void addClaimApplication(ClaimApplication application) {
		System.out.println(application.getMemberIndex() + 1);
		String query = "insert into insurance_claim(policy_id,member_index,relation,joined_date,patient_name,date_of_birth,gender,contact_number,address,disease,diagnosis,treatment,claimAmount) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] values = { application.getClamIplcId(), application.getMemberIndex(), application.getRelation(),
				application.getJoinedDate(), application.getPatientName(), application.getDateOfBirth(),
				application.getGender(), application.getContactNumber(), application.getAddress(),
				application.getDisease(), application.getDiagnosis(), application.getTreatment(),
				application.getClaimAmountRequested() };
		jdbcTemplate.update(query, values);
	}

	@Override
	public void addClaim(int i) {
		try {
			String dateOfBirth = "3003-03-30";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = dateFormat.parse(dateOfBirth);
			Date date = new Date(utilDate.getTime());
			jdbcTemplate.update(SQL_INSERT_CLAIM, "HSPT", "DRCT", date, i);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void addClaimBills(String f, String filePath, int cid) {

		jdbcTemplate.update(SQL_INSERT_CLAIMBill, cid, f, filePath);
	}

	@Override
	public Claim getClaimByid(int clamIplcId) {
		// TODO Auto-generated method stub

		return jdbcTemplate.queryForObject("select distinct clam_id from _Claims where clam_iplc_id=" + clamIplcId,
				new RowMap());
	}

	@Override
	public List<PolicyMembers> getFamilyByPolicy(int id) {

		return jdbcTemplate.query(
				"select ipcm_mindex,iplc_id, ipcm_membername, ipcm_relation from insurancepolicycoveragemembers",
				new PolicyMembersRowMapper());
	}
		
	
	//////////////////////////////
	
	//Reupload
	
	 @Override
		public void addRequiredUploads(ReUpload upload) {
			String query = "insert into reuploads(claimId,name,type,Status,description) values(?,?,?,?,?)";
			Object[] values = { upload.getClaimId(), upload.getName(), upload.getType(), upload.getStatus(),
					upload.getDescription() };
			jdbcTemplate.update(query, values);
		}

		@Override
		public List<ReUpload> getAllReUploads(int id) {

			return jdbcTemplate.query("select * from reuploads where claimId="+id, new ReUploadRowMapper());
		}

		@Override
		public void addUploads(Uploads up) {

			System.out.println("jdbc");
			String query = "insert into uploads(uploadId,reuploadId,claimId,data,type) values(?,?,?,?)";
			Object[] values = { up.getUploadId(), up.getReUploadId(), up.getClaimId(), up.getData(), up.getType() };
			jdbcTemplate.update(query, values);
		}

		@Override
		public List<Uploads> getAllUploads(int claimId) {
			
			return jdbcTemplate.query("select * from uploads where claimId="+claimId, new UploadsRowMapper());
		}
}
