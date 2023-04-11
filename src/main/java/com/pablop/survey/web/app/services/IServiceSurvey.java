package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.Survey;

public interface IServiceSurvey {
	
	public void save (Survey survey);
	public Survey surveyfindById(Long id);
	public Survey surveyFindByName(String name);
	public List<Survey> findSurveyList();
	public void deleteSurveyById(Long id);

}
