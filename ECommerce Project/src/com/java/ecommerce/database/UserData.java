package com.java.ecommerce.database;

public class UserData {
	String name;
	 long mobileNum;
	 String email;
	 String password;
	
	
	public UserData(long mobileNum, String name, String email, String password) {
		this.mobileNum=mobileNum;
		this.name=name;
		 this.email=email;
		 this.password=password;
	}
}
