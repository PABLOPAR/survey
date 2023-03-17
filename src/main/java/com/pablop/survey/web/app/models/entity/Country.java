package com.pablop.survey.web.app.models.entity;

import javax.validation.constraints.NotNull;

public class Country {
	
	@NotNull
	private String name;
	private String code;
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Country(String name) {
		super();
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + "]";
	}


	
	
	
	

}
