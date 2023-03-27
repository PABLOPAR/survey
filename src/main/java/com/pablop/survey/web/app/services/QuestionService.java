package com.pablop.survey.web.app.services;

import java.util.List;

import com.pablop.survey.web.app.models.entity.Question;

public interface QuestionService {
	
	public List<Question> questionList();
	public void addQuestion(Question question);

}
