package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.Country;
import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;
import com.pablop.survey.web.app.models.entity.Survey;

public interface IPeopleService {

	
	public List<PeopleAnalyzed> peopleListAnalized();
	public PeopleAnalyzed analyzedByEmail(String email);
	public void addPeopleAnalyzed(PeopleAnalyzed newPeople);
	public List<PeopleAnalyzed> getPeopleAnalyzedList();
	public PeopleAnalyzed findPeopleById(Long id);
	public void deletePeopleAnalyzedById(Long id);

}
