package com.insurance.Hospital.rowmappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.claimss;


public class ClaimsRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		claimss claim=new claimss();
		claim.setClam_id(rs.getInt(1));
		claim.setClam_source(rs.getString(2));
		claim.setClam_type(rs.getString(3));
		claim.setClam_date(rs.getDate(4));
		claim.setClam_amount_requested(rs.getDouble(5));
		claim.setClam_iplc_id(rs.getInt(6));
		claim.setClam_processed_amount(rs.getDouble(7));
		claim.setClam_processed_Date(rs.getDate(8));
		claim.setClam_processed_by(rs.getInt(9));
		claim.setClam_status(rs.getString(11));
		claim.setClam_remarks(rs.getString(10));
	
		
		return claim;
	}

}