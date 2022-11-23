package com.jdbc;

import com.constants.Role;

public class Registration {
	private int user_id;
	private String uname;
	private String fName;
	private String lName;
	private String password;
	private String role;

	public Registration(String uname, String fName, String lName, String password, String role) {
		super();
		this.uname = uname;
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.role = role;
	}

	public String getUname() {
		return uname;
	}

	public int getUser_id() {
		return user_id;
	}

//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Registration [user_id=" + user_id + ", uname=" + uname + ", fName=" + fName + ", lName=" + lName
				+ ", password=" + password + ", role=" + role + "]";
	}

}
