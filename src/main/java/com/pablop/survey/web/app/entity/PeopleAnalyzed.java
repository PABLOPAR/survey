package com.pablop.survey.web.app.entity;

import java.util.Date;

public class PeopleAnalyzed extends Person{
	
	private String lastName;

	public PeopleAnalyzed(String country, Date birthday, String firstName, String email) {
		super(country, birthday, firstName,email);
		// TODO Auto-generated constructor stub
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
