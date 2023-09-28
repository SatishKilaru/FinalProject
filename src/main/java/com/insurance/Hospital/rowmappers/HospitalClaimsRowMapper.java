package com.insurance.Hospital.rowmappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.HospitalClaims;


public class HospitalClaimsRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		HospitalClaims hclaims=new HospitalClaims();
		
		hclaims.setClam_id(rs.getInt(1));
		hclaims.setHclm_hosp_id(rs.getInt(2));
		hclaims.setHclm_husr_id(rs.getInt(3));
		
		return null;
	}

}
