package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.PeopleAnalyzed;

public interface PeopleService {

	
	public List<PeopleAnalyzed> peopleListAnalized();
	public PeopleAnalyzed analyzedByEmail(String email);
	
}
