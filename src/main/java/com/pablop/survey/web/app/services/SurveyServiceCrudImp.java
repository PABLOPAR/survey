package com.pablop.survey.web.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablop.survey.web.app.models.entity.Survey;

@Service
public class SurveyServiceCrudImp implements IServiceSurvey {

	@Autowired
	private ISurveyServiceCrud iSurveyServiceCrud;
	
	
	@Override
	public void save(Survey survey) {

		if (surveyfindById(survey.getId()) == null) {
			iSurveyServiceCrud.save(survey);
		}

	}

	@Override
	public Survey surveyfindById(Long id) {

		Survey survey = null;

		if (id !=null) {
			survey = iSurveyServiceCrud.findById(id).orElse(null);
		}

		return survey;
	}

}
