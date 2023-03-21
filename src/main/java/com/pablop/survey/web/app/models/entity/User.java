package com.pablop.survey.web.app.models.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class User extends Person {

	@NotEmpty
	private String lastName;

	@NotEmpty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@NotEmpty
	@Size(min = 2, max = 40)
	private Country country;

	private ArrayList<Survey> userListSurvey;

	private ArrayList<PeopleAnalyzed> userPeopleAnalyzed;

	public User(Date birthday, String firstName, String email) {
		super(firstName, email);
		userListSurvey= new ArrayList<Survey>();
		userPeopleAnalyzed= new ArrayList<PeopleAnalyzed>();
		
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

}
