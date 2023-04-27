package com.pablop.survey.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.QuestionSurveySelected;

@Service
public class QuestionSurveySelectedImp implements IQuestionSurveySelected {
	

	@Autowired 
	IQuestionSurveySelectedCrud iQuestionSurveySelectedCrud;
	
	

	@Override
	@Transactional
	public void QuestionSurveySelectedAdd (QuestionSurveySelected questionSurveySelected) {
		iQuestionSurveySelectedCrud.save(questionSurveySelected);
		
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public QuestionSurveySelected QuestSurveySelSearch (Long id) {
		
		return iQuestionSurveySelectedCrud.findById(id).orElse(null);
		
	}

	
	@Override
	@Transactional(readOnly = true)
	public QuestionSurveySelected getQuestionSurveyBySurveyId(Long surveyId) {

		List<QuestionSurveySelected> allQuestSurvey = findAllQuestSurveySelect();

		QuestionSurveySelected questionSurveySelected = null;
		int index = 0;

		while (index < allQuestSurvey.size() && questionSurveySelected == null) {
			if (allQuestSurvey.get(index).getIdSurvey() == surveyId) {
				questionSurveySelected = allQuestSurvey.get(index);

			} else {
				index++;
			}
		}

		return questionSurveySelected;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Question> questionInThisSurveySelected(Long surveyId) {

		QuestionSurveySelected questionSurveySelected = getQuestionSurveyBySurveyId(surveyId);

		return questionSurveySelected.getQuestionAsList();

	}
	
	
	
	
	
	


	@Override
	public List<QuestionSurveySelected> findAllQuestSurveySelect() {
		
		return (List<QuestionSurveySelected>) iQuestionSurveySelectedCrud.findAll();
	}
	
	

}
