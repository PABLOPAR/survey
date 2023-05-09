package com.pablop.survey.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablop.survey.web.app.models.entity.Question;
import com.pablop.survey.web.app.models.entity.Survey;

@Service
public class SurveyServiceCrudImp implements IServiceSurvey {

	@Autowired
	private ISurveyServiceCrud iSurveyServiceCrud;
	
	
	@Override
	@Transactional
	public void save(Survey survey) {

		if (surveyfindById(survey.getId()) == null && surveyFindByName(survey.getSurveyName())==null) {
			iSurveyServiceCrud.save(survey);
		}
		
	}
	
	@Override
	@Transactional
	public void edit(Survey newSurvey) {

		Survey surveyToBeModified = surveyfindById(newSurvey.getId());
		surveyToBeModified = newSurvey;
		iSurveyServiceCrud.save(surveyToBeModified);

	}
		
	

	@Override
	@Transactional(readOnly=true)
	public Survey surveyfindById(Long id) {

		Survey survey = null;

		if (id !=null) {
			survey = iSurveyServiceCrud.findById(id).orElse(null);
		}

		return survey;
	}

	@Override
	@Transactional(readOnly=true)
	public Survey surveyFindByName(String name) {

		Survey surveySearched = null;
		int index = 0;

		List<Survey> surveyList = (List<Survey>) iSurveyServiceCrud.findAll();

		if (name.length() > 0) {

			while (surveySearched == null && index < surveyList.size()) {
				if (surveyList.get(index).surveyName.equalsIgnoreCase(name)) {
					surveySearched = surveyList.get(index);
				} else {
					index++;
				}
			}
		}

		return surveySearched;
	}

	@Override
	@Transactional(readOnly=true)
	public ArrayList<Survey> findSurveyList() {

		return (ArrayList<Survey>) iSurveyServiceCrud.findAll();
	}

	
	@Override
	@Transactional
	public void deleteSurveyById(Long id) {
		
		if(id>0){
			Survey surveyToBeDeleted=surveyfindById(id);
			
			if(surveyToBeDeleted!=null){
				iSurveyServiceCrud.delete(surveyToBeDeleted);
				
			}
		}

	}

	@Override
	@Transactional
	public void setQuestionSurveyByID(ArrayList<Question> surveyQuestions, Long idSurvey) {
		
		surveyfindById(idSurvey).setSurveyQuestions(surveyQuestions);
		
		iSurveyServiceCrud.save(surveyfindById(idSurvey));
		
	
	}

}
