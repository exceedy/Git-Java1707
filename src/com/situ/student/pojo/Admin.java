package com.situ.student.pojo;

import java.io.Serializable;

public class Admin implements Serializable{
	private String ursename;
	private String password;
	
	
	
	public Admin() {
		super();
	}
	public Admin(String ursename, String password) {
		super();
		this.ursename = ursename;
		this.password = password;
	}
	public String getUrsename() {
		return ursename;
	}
	public void setUrsename(String ursename) {
		this.ursename = ursename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [ursename=" + ursename + ", password=" + password + "]";
	}
	
	
}
