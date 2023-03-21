package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Survey;

public interface PeopleService {

	
	public List<PeopleAnalyzed> peopleListAnalized();
	public PeopleAnalyzed analyzedByEmail(String email);
	public List<PeopleAnalyzed> addPeopleAnalyzed(PeopleAnalyzed newPeople);
	public List<PeopleAnalyzed> getPeopleAnalyzedList();
	public List<String> countryList();
	public List<Country> countryListObject();
	public Country searchCountryByName(String name);
	public List<Survey> exampleListSurvey();
}
