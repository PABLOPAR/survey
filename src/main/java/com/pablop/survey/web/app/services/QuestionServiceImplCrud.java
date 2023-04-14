package com.pablop.survey.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

import com.pablop.survey.web.app.models.entity.Question;

@Service
@Primary
public class QuestionServiceImplCrud implements IQuestionService{

	public QuestionServiceImplCrud() {
		super();
	}

	@Autowired
	private IQuestionCrud iQuestionCrud;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Question> questionList() {
		return (List<Question>) iQuestionCrud.findAll();
	}

	@Override
	@Transactional
	public void addQuestion(Question question) {
		iQuestionCrud.save(question);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Question findQuestionById(Long id) {
		
		return iQuestionCrud.findById(id).orElse(null);
	}
	
	
	

}
