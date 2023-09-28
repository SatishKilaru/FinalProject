package com.insurance.Hospital.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.Claim;

public class ClaimsMapper implements RowMapper<Claim> {

	@Override
	public Claim mapRow(ResultSet rs, int rowNum) throws SQLException {
		Claim clam = new Claim();

		clam.setClamId(rs.getInt("clam_id"));
		clam.setClamSource(rs.getString("clam_source"));
		clam.setClamType(rs.getString("clam_type"));
		clam.setClamDate(rs.getDate("clam_date"));
		clam.setClamAmountRequested(rs.getDouble("clam_amount_requested"));
		clam.setClamIplcId(rs.getInt("clam_iplc_id"));
		clam.setClamProcessedAmount(rs.getDouble("clam_processed_amount"));
		clam.setClamProcessedDate(rs.getDate("clam_processed_date"));
		clam.setClamProcessedBy(rs.getInt("clam_processed_by"));
		clam.setClamRemarks(rs.getString("clam_remarks"));
		clam.setClamStatus(rs.getString("clam_status"));

		return clam;

	}

}