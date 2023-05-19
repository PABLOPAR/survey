package com.pablop.survey.web.app.models.entity;

public class BooleanOption {

	
	public BooleanOption(String name, Boolean boleanOption) {
		super();
		this.name = name;
		this.boleanOption = boleanOption;
	}


	private String name;
	private Boolean boleanOption;
	
	
	
	public BooleanOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getBoleanOption() {
		return boleanOption;
	}
	public void setBoleanOption(Boolean boleanOption) {
		this.boleanOption = boleanOption;
	}


	@Override
	public String toString() {
		return "BooleanOptions [name=" + name + ", boleanOption=" + boleanOption + "]";
	}
	
	
}
