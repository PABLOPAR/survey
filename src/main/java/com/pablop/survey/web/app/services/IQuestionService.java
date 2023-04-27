package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.QuestionOption;

public interface IQuestionService {
	
	public List<Question> questionList();
	public void addQuestion(Question question);
	public Question findQuestionById(Long id);
	public Question findByQuestionText(String questionText);
	public List<Question> getQuestionBySurveyId(Long id);


}
