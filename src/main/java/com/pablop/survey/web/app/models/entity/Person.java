package com.pablop.survey.web.app.models.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public abstract class Person {

	@Email
	@Size (min=3, max= 25)
	@NotBlank
	private String email;
	

	@NotEmpty
	@Size (min=2, max=30)
	private String firstName;
	
	
	public Person(String firstName, String email) {
		super();

		this.firstName = firstName;
		this.email= email;
	}
	
	public Person() {
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

	@Override
	public String toString() {
		return "Person [email=" + email + ", firstName=" + firstName + "]";
	}

	
}
