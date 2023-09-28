package com.insurance.Hospital.models;


import java.sql.Date;


public class User {

	int userid;
	String username;
	Date currentdate;
	String usertype;
	String password;
	String email;
	String recoveryemail;
	String mobile;

	public User() {

	}

	public int getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public Date getCurrentdate() {
		return currentdate;
	}

	public String getUsertype() {
		return usertype;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRecoveryemail() {
		return recoveryemail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCurrentdate(Date currentdate) {
		this.currentdate = currentdate;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRecoveryemail(String recoveryemail) {
		this.recoveryemail = recoveryemail;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}