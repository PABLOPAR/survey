package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.Country;

public interface CountryListService {

	public Country searchCountryByName(String name);
	public List<Country> getCountryListObject();
	public Country searchCountryById(Long id);
}
