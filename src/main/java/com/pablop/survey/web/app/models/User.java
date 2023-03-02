package com.pablop.survey.web.app.models;

import java.util.Date;

public class User extends Person{


	private String lastName;
	
	
	public User(String country, Date birthday, String firstName, String email) {
		super(country, birthday, firstName, email);
		// TODO Auto-generated constructor stub
	}
	
		
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
