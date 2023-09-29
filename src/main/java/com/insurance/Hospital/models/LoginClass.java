package com.insurance.Hospital.models;

public class LoginClass {
	String user_name;
	String password;
	String roleId;
	
	

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public LoginClass() {

	}

	public LoginClass(String user_name, String password, String roleId) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.roleId=roleId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginClass [user_name=" + user_name + ", password=" + password + "]";
	}

}