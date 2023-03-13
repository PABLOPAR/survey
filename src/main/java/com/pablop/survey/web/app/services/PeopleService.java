package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

public interface PeopleService {

	
	public List<PeopleAnalyzed> peopleListAnalized();
	public PeopleAnalyzed analyzedByEmail(String email);
	public List<PeopleAnalyzed> addPeopleAnalyzed(PeopleAnalyzed newPeople);
	public List<PeopleAnalyzed> getPeopleAnalyzedList();
}
