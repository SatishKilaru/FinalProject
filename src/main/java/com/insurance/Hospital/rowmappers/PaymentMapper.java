package com.insurance.Hospital.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.Payments;

public class PaymentMapper implements RowMapper<Payments> {

	@Override
	public Payments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Payments pay = new Payments();
		pay.setStmt_id(rs.getInt(1));
		pay.setTran_id(rs.getString(2));
		pay.setPayment_Processed_date(rs.getDate(3));
		pay.setClaim_id(rs.getInt(4));
		pay.setTran_amnt(rs.getDouble(5));
		return pay;
	}

}