	package com.pablop.survey.web.app.models.entity;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class PeopleAnalyzed extends Person{
	
	@Size(min=2)
	private String lastName;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Date birthday;

	public PeopleAnalyzed(String country, String firstName, String email) {
		super(country, firstName,email);
		// TODO Auto-generated constructor stub
	}

	public PeopleAnalyzed() {
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "PeopleAnalyzed [lastName=" + lastName + ", getCountry()=" + getCountry() + ", getBirthday()="
				 + ", getFirstName()=" + getFirstName() + ", getEmail()=" + getEmail() + ", toString()="
				+ super.toString() + "]";
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
}
