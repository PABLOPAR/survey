package com.pablop.survey.web.app.models.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class User extends Person {

	@NotEmpty
	private String lastName;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@NotNull
	private Country country;

	private ArrayList<Survey> userListSurvey;

	private ArrayList<PeopleAnalyzed> userPeopleAnalyzed;

	public User(Date birthday, String firstName, String email) {
		super(firstName, email);
		userListSurvey= new ArrayList<Survey>();
		userPeopleAnalyzed= new ArrayList<PeopleAnalyzed>();
		
	}
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String email) {
		super(firstName, email);
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public ArrayList<Survey> getUserListSurvey() {
		return userListSurvey;
	}

	public void setUserListSurvey(ArrayList<Survey> userListSurvey) {
		this.userListSurvey = userListSurvey;
	}

	public ArrayList<PeopleAnalyzed> getUserPeopleAnalyzed() {
		return userPeopleAnalyzed;
	}

	public void setUserPeopleAnalyzed(ArrayList<PeopleAnalyzed> userPeopleAnalyzed) {
		this.userPeopleAnalyzed = userPeopleAnalyzed;
	}


	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", birthday=" + birthday + ", country=" + country + ", userListSurvey="
				+ userListSurvey + ", userPeopleAnalyzed=" + userPeopleAnalyzed + ", getFirstName()=" + getFirstName()
				+ ", getEmail()=" + getEmail() + "]";
	}




}
