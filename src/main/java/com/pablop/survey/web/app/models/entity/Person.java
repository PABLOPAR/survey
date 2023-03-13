package com.pablop.survey.web.app.models.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

public abstract class Person {

	@NotEmpty
	private String email;
	
	@NotEmpty
	private String country;

	
	@NotEmpty
	private String firstName;
	
	public Person(String country, String firstName, String email) {
		super();
		this.country = country;
		this.firstName = firstName;
		this.email= email;
	}
	
	public Person() {
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
