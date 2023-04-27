package com.pablop.survey.web.app.services;


import java.util.List;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.QuestionSurveySelected;

public interface IQuestionSurveySelected {

	
	public void QuestionSurveySelectedAdd(QuestionSurveySelected questionSurveySelected) ;
	public QuestionSurveySelected QuestSurveySelSearch (Long id);
	public List<QuestionSurveySelected> findAllQuestSurveySelect();
	public QuestionSurveySelected getQuestionSurveyBySurveyId(Long surveyId);
	public List<Question> questionInThisSurveySelected(Long surveyId);
}
