package com.pablop.survey.web.app.models;

import java.util.List;

import com.pablop.survey.web.app.models.entity.PeopleAnalyzed;

public interface IPeopleAnalyzedDao {

	public List<PeopleAnalyzed> findAll();
	
	
}
