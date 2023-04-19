package com.pablop.survey.web.app.editors;

import com.pablop.survey.web.app.models.entity.Country;

public interface ICountryEditor {

	public void setAsText(String text) throws IllegalArgumentException;
	public Country getCountrybyId(Long id);
	
}
