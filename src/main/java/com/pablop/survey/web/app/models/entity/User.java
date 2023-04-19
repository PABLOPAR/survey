package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;



@Entity(name="users")
@DiscriminatorValue(value="user")
public class User extends Person implements Serializable{


	
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name="last_names")
	private String lastName;

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@NotNull
	@Column(name="countries")	
	private Country country;

	@Column(name="user_list_survys")
	private ArrayList<Survey> userListSurvey;

	@Column(name="user_people_analyzed")
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
