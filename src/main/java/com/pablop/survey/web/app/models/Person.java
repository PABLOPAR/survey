package com.pablop.survey.web.app.models;

import java.util.Date;

public abstract class Person {


	private String country;
	private Date birthday;
	private String firstName;
	
	public Person(String country, Date birthday, String firstName) {
		super();
		this.country = country;
		this.birthday = birthday;
		this.firstName = firstName;
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

	
}
