package com.insurance.Hospital.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.Claim;
import com.insurance.Hospital.models.LoginClass;

public class LoginClassMapper implements RowMapper<LoginClass>{

	@Override
	public LoginClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginClass lc=new LoginClass();
		lc.setUser_name(rs.getString(1));
		lc.setPassword(rs.getString(2));
		lc.setRoleId(rs.getString(3));
		return lc;
	}

}
