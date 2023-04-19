	package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity(name="people_analyzed")
@DiscriminatorValue(value="peopleAnalyzed")
public class PeopleAnalyzed extends Person implements Serializable{
	

	private static final long serialVersionUID = 1L;

//	@Size(min=2)
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="id_User")
	Long idPerson;
	
	
	@Past
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	
	
//	@NotNull
	private Country country;


	public PeopleAnalyzed(String firstName, String email) {
		super(firstName,email);
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
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}



	@Override
	public String toString() {
		return "PeopleAnalyzed [lastName=" + lastName + ", getCountry()=" + getCountry() + ", getBirthday()="
				+ ", getFirstName()=" + getFirstName() + ", getEmail()=" + getEmail() + ", toString()="
				+ super.toString() + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
