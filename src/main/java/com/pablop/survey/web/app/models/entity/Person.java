package com.pablop.survey.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity(name = "persons")
@DiscriminatorColumn(name = "type")
public abstract class Person implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email
	@Column(name = "email")
	@Size(min = 3, max = 50)
	@NotBlank
	private String email;

	@NotEmpty
	@Column(name = "first_name")
	@Size(min = 2, max = 30)
	private String firstName;

	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate;

	@Column(name = "rol_id")
	private ArrayList<Long> roleIds;
	
	@Column(name="is_active")
	private Boolean isUserActive;

	@PrePersist
	public void prePersist() {
		creationDate = new Date();
	}


	public Person(@Email @Size(min = 3, max = 50) @NotBlank String email,
			@NotEmpty @Size(min = 2, max = 30) String firstName, Boolean isUserActive) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.isUserActive = isUserActive;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public ArrayList<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(ArrayList<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public Boolean isUserActive() {
		return isUserActive;
	}

	public void setUserActive(Boolean isUserActive) {
		this.isUserActive = isUserActive;
	}


	public Boolean getIsUserActive() {
		return isUserActive;
	}

	public void setIsUserActive(Boolean isUserActive) {
		this.isUserActive = isUserActive;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + ", firstName=" + firstName + ", creationDate=" + creationDate
				+ ", roleIds=" + roleIds + ", isUserActive=" + isUserActive + "]";
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {

		}
		return clone;
	}








	
}
