package com.insurance.HealthInsurance.rowmappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.HealthInsurance.models.Payments;



public class PaymentMapper implements RowMapper<Payments> {

	@Override
	public Payments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Payments pay=new Payments();
		pay.setPaymentID(rs.getString(1));
		pay.setCustomerID(rs.getString(2));
		pay.setClaimID(rs.getString(3));
		pay.setHospitalID(rs.getString(4));
		pay.setPaymentAmount(rs.getDouble(5));
		pay.setPaymentDate(rs.getDate(6));
		return pay;
	}

}
