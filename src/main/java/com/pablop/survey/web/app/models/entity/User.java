package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@Column(name = "user_list_surveys")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "users")
	private List<Survey> userListSurvey;

	@Column(name="user_people_analyzed")
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_User")
	private List<PeopleAnalyzed> userPeopleAnalyzed;

	public User(Date birthday, String firstName, String email, Boolean isUserActive) {
		super(firstName, email, isUserActive);
		userListSurvey= new ArrayList<Survey>();
		userPeopleAnalyzed= new ArrayList<PeopleAnalyzed>();
		
	}
	

	public User() {
		super();
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
	
	
	public String getCountryString() {
		return country.getName();
	};


	public void setCountry(Country country) {
		this.country = country;
	}


	public List<Survey> getUserListSurvey() {
		return userListSurvey;
	}


	public void setUserListSurvey(List<Survey> userListSurvey) {
		this.userListSurvey = userListSurvey;
	}


	public List<PeopleAnalyzed> getUserPeopleAnalyzed() {
		return userPeopleAnalyzed;
	}


	public void setUserPeopleAnalyzed(List<PeopleAnalyzed> userPeopleAnalyzed) {
		this.userPeopleAnalyzed = userPeopleAnalyzed;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", birthday=" + birthday + ", country=" + country + ", userListSurvey="
				+ userListSurvey + ", userPeopleAnalyzed=" + userPeopleAnalyzed + ", getLastName()=" + getLastName()
				+ ", getBirthday()=" + getBirthday() + ", getCountry()=" + getCountry() + ", getUserListSurvey()="
				+ getUserListSurvey() + ", getUserPeopleAnalyzed()=" + getUserPeopleAnalyzed() + "]";
	}


	



}
