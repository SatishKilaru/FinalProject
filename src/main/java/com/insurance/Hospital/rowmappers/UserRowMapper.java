package com.insurance.Hospital.rowmappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.User;


public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user=new User();
		
		user.setUserid(rs.getInt(1));
		user.setCurrentdate(rs.getDate(2));
		user.setEmail(rs.getString(3));
		user.setMobile(rs.getString(4));
		user.setPassword(rs.getString("password"));
		user.setRecoveryemail(rs.getString(6));
		user.setUsername(rs.getString("username"));
		user.setUsertype(rs.getString(8));
		
		return user;
	}
	
	

}