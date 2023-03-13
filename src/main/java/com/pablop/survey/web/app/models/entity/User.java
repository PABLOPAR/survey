package com.pablop.survey.web.app.models.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

public class User extends Person{

	@NotEmpty
	private String lastName;
	
	@NotEmpty
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	
	public User(String country, Date birthday, String firstName, String email) {
		super(country, firstName, email);
		// TODO Auto-generated constructor stub
	}
	
		
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
}
