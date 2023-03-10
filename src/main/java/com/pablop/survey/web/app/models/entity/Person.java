package com.pablop.survey.web.app.models.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public abstract class Person {

	private String email;
	private String country;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String firstName;
	
	public Person(String country, Date birthday, String firstName, String email) {
		super();
		this.country = country;
		this.birthday = birthday;
		this.firstName = firstName;
		this.email= email;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
