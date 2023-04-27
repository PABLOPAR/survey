package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

		if (question != null) {

			if (findByQuestionText(question.getQuestion()) == null) {

				iQuestionCrud.save(question);

			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Question findQuestionById(Long id) {
		
		return iQuestionCrud.findById(id).orElse(null);
	}
	
	
	
	public Question findByQuestionText(String questionText) {

		Question questionSearched = null;
		List<Question> questionList = questionList();
		int index = 0;

		while (index < questionList.size() && questionSearched == null) {

			if (questionList.get(index).getQuestion().equalsIgnoreCase(questionText)) {
				questionSearched = questionList.get(index);

			} else {

				index++;
			}

		}

		return questionSearched;
	}

	@Override
	public List<Question> getQuestionBySurveyId(Long id) {

		ArrayList<Question> questionSelected = new ArrayList<Question>();

		for (Question question : questionList()) {

			if (question.getSurveyIdFk() == id) {
				questionSelected.add(question);
			}
		}
		return questionSelected;
	}
}
