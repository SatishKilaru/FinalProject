package com.insurance.HealthInsurance.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.HealthInsurance.models.ClaimBills;



public class ClaimBillsRowMappers implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClaimBills bills=new ClaimBills();
		
		bills.setClam_id(rs.getInt(1));
		bills.setClbl_billindex(rs.getInt(2));
		bills.setClbl_document_title(rs.getString(3));
		bills.setClbl_document_path(rs.getString(4));
		bills.setClbl_claim_amount(rs.getDouble(5));
		bills.setClbl_processed_amount(rs.getDouble(6));
		bills.setClbl_processed_Date(rs.getString(7));
		bills.setClbl_processed_by(rs.getInt(8));
		bills.setClbl_remarks(rs.getString(9));
		bills.setClbl_status(rs.getString(10));
		
		
		return bills;
	}

}
