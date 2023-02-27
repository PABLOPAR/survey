package com.pablop.survey.web.app.models;

import java.util.Date;

public class User extends Person{


	private String email;
	private String lastName;
	
	public User(String country, Date birthday, String firstName, String email, String lastName) {
		super(country, birthday, firstName);
		this.email = email;
		this.lastName = lastName;
	}
	
	
	public User(String country, Date birthday, String firstName) {
		super(country, birthday, firstName);
		// TODO Auto-generated constructor stub
	}
	
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
