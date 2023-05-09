package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.Survey;

public interface IServiceSurvey {
	
	public void save (Survey survey);
	public Survey surveyfindById(Long id);
	public Survey surveyFindByName(String name);
	public List<Survey> findSurveyList();
	public void deleteSurveyById(Long id);
	public void setQuestionSurveyByID(ArrayList<Question> surveyQuestions, Long idSurvey);
	public void edit(Survey newSurvey);

}
